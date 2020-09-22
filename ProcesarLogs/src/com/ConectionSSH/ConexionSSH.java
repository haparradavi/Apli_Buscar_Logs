package com.ConectionSSH;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.Globales.Globalvar;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;


public class ConexionSSH {

	//String filePath = "/ESB/log/trace/mqsitransit/trazabilidad20200910161125.log";
	//String filePath = "/ESB/log/trace/mqsitransit/trazabilidad20200911025100.log";

	public void connect(String username, String host, String password, int port)
			throws JSchException, IllegalAccessException, IOException, SftpException {

		try {

		if (Globalvar.sessionGlobal == null || !Globalvar.sessionGlobal.isConnected()) {
			
			JSch jsch = new JSch();
			Globalvar.setSessionGlobal(jsch.getSession(username, host, port));
			Globalvar.sessionGlobal.setPassword(password);
			Globalvar.sessionGlobal.setConfig("StrictHostKeyChecking", "no");
			Globalvar.sessionGlobal.connect(60000);
			System.out.println("conexion exitosa");
			
		} else {
			Globalvar.sessionGlobal.disconnect();
			//throw new IllegalAccessException("Sesion SFTP ya iniciada.");
		}

			
		} catch (Exception e) {
			System.out.println("connec:"+e.getMessage());
			throw e;
		}	

			//addFile(this.filePath);

//		} else {
//			Globalvar.sessionGlobal.disconnect();
//			//throw new IllegalAccessException("Sesion SFTP ya iniciada.");
//		}
	}

	public InputStream addFile(String filePath) throws JSchException, IllegalAccessException, IOException, SftpException {

		InputStream stream=null;
		try {
			
			if (Globalvar.sessionGlobal != null && Globalvar.sessionGlobal.isConnected()) {
	
				// Abrimos un canal SFTP. Es como abrir una consola.
				Channel channel = Globalvar.sessionGlobal.openChannel("sftp");
				channel.connect();	
				Globalvar.setSftpChannel((ChannelSftp) channel);
				stream = Globalvar.sftpChannel.get(filePath);
				System.out.println("ok");
	
			} else {
	
				throw new IllegalAccessException("No existe sesion SFTP iniciada.");
			}
		
		} catch (Exception e) {
			throw e;
		}
		return stream;
	}
	
    public String executeCommand(String script) throws JSchException, IOException, InterruptedException{
     //   System.out.println("Execute sudo");
        String result="";
        ChannelExec channel = (ChannelExec) Globalvar.sessionGlobal.openChannel("exec");
        try {
      
        ((ChannelExec) channel).setCommand( script);

        InputStream in = channel.getInputStream();
        OutputStream out = channel.getOutputStream();
        ((ChannelExec) channel).setErrStream(System.err);

        channel.connect();
      //  out.write((sudo_pass + "\n").getBytes());
        out.flush();

        byte[] tmp = new byte[1024];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0)
                    break;
             //   System.out.print(new String(tmp, 0, i));
                result=result.concat(new String(tmp, 0, i));
            }
            if (channel.isClosed()) {
//                System.out.println("exit-status: " + channel.getExitStatus());
                break;
            }
         
                Thread.sleep(1000);
        }
        } catch (JSchException | IOException ee) {
//          System.out.println(ee);
      	throw ee;
      }
        channel.disconnect();
        return result;
       // System.out.println("Sudo disconnect");
    }
    
	public  String getFinalLog (String comando,String nommbreArchivo)throws JSchException, IllegalAccessException, IOException, SftpException, InterruptedException {
		String namelog="";
		try {
		ConexionSSH conSh = new ConexionSSH();	
		namelog=conSh.executeCommand("cd "+ comando+"; ls -1tr "+nommbreArchivo+" | tail -1");
		} catch (JSchException | IOException | InterruptedException e) {
			throw e;
		}
		return namelog.trim();
		
	}
    
	public  String execCommanLinux (String comando)throws Exception{
		String namelog="";
		try {
//		System.out.println("comando: "+comando);
		ConexionSSH conSh = new ConexionSSH();
		namelog=conSh.executeCommand(comando);
		} catch (JSchException | IOException | InterruptedException e) {
			throw e;
		}
		return namelog.trim();
		
	}
	
	public  String execCommangrep (String datobusqueda,String ruta)throws Exception {
		ConexionSSH conSh = new ConexionSSH();
		String namelog="";
		try {
		
//		System.out.println("comando: "+"grep -i "+datobusqueda+" "+ruta);
		namelog=conSh.executeCommand("grep -i "+datobusqueda+" "+ruta);
		} catch (JSchException | IOException | InterruptedException e) {
			throw e;
		}
		return namelog.trim();
		
	}
	
	public  String eliminarrutalog (String linea) throws Exception {
		String nuevo="";
		try {
			if(linea != null && !linea .isEmpty()) {
				String [] saltolinea = linea.split("\n");
				linea="";
				for (int i = 0; i < saltolinea.length; i++) {
					String [] puntos = saltolinea[i].split(":");
					for (int j = 0; j < puntos.length; j++) {
						if(!puntos[j].contains("ESB")) {
						nuevo=nuevo.concat(":").concat(puntos[j]);   // se utiliza para adicionar los : a la linea debido a que se eliminar con el split
						}			
					}
					nuevo =nuevo.substring(1,nuevo.length());    // se utiliza para quitar los : de la primera fila de cada linea
					linea=linea+nuevo+"\n";
					nuevo="";
				}
			}
				
		} catch (Exception e) {
			System.out.println("Error eliminarrutalog "+e.getMessage());
			throw e;
		}
		return linea;	
	}
	
	public  String validafintagerror (String linea, String filepatherror) throws Exception{
		
		String nuevatraza="";
		try {
			String result="";
			int numerolinea=0;
			boolean faltandatos=true;
			if(linea != null && !linea .isEmpty()) {
				String[] parts = linea.split("\n");
				for (int i = 0; i < parts.length; i++) {
					nuevatraza= nuevatraza.concat(parts[i]);
					if(!parts[i].contains("</error>")) {
						String [] lineapart = parts[i].split(":");
						numerolinea = Integer.valueOf(lineapart[0]);
						while(faltandatos) {
							numerolinea=numerolinea+1;
							result=execCommanLinux("sed '"+numerolinea+"q;d' "+filepatherror);		
							nuevatraza= nuevatraza.concat(result).concat("\n");
							if(result.contains("</error>")) {
								faltandatos=false;
							}
						}
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error validafintagerror: "+e.getMessage());
			throw e;
		}

		return nuevatraza;	
	}
	
	

}