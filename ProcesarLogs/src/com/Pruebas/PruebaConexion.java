package com.Pruebas;


import java.io.IOException;
import com.ConectionSSH.GetRutaYNombresTraza;
import java.io.InputStream;
import com.ConectionSSH.ConexionAmbiente;
import com.ConectionSSH.ConexionSSH;
import com.Globales.Globalvar;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.procesarlogs.ParametrosLogsDAO;
import com.procesarlogs.ProcesarArchivo;

public class PruebaConexion {



	public static void main(String[] args)  {


//         busquedaparametros();
//         pruebaTail() ;

		
	
	}


	
	
	public static void execprocLogs(ParametrosLogsDAO parametrosLogsDAO) throws IllegalAccessException, IOException, SftpException, JSchException {
		try {
			ConexionSSH conSh = new ConexionSSH();
			String filepath = "";
			InputStream stream=null;
			ProcesarArchivo procesar = new ProcesarArchivo();
			//filepath = parametrosLogsDAO.getRutaTraza().concat(parametrosLogsDAO.getNombreLog());
			filepath = parametrosLogsDAO.getRutaErrorlog().concat(parametrosLogsDAO.getNameLogcommand());
			System.out.println("Log traza:"+filepath);
		//	stream= conSh.addFile(filepath);
			parametrosLogsDAO.setStream(conSh.addFile(filepath)); // vamos aca
			System.out.println("Archivo Encontrado OK....");
			
			parametrosLogsDAO=procesar.readFile(parametrosLogsDAO );

			
/*			filepath = parametrosLogsDAO.getRutaErrorlog().concat(parametrosLogsDAO.getNameErrorcommand());
			filepath = "/ESB/log/error/mqsitransit/Error.txt";
			System.out.println("******Procesar traza error:"+filepath);
			System.out.println("*******idtransaccion***** "+parametrosLogsDAO.getIdtransaccion());
			stream= conSh.addFile(filepath);
			parametrosLogsDAO.setStream(conSh.addFile(filepath)); // vamos aca
			System.out.println("Archivo error  Encontrado OK....");
			parametrosLogsDAO.setRutaDestinoArchivo("C:/Users/haparra/Documents/GenerarLogs/logInver_Error.txt");
			parametrosLogsDAO.setIdtransaccion("2fac1092f6a311ea8a615a04051100002fac113cf6a311ea");
			parametrosLogsDAO=procesar.readFile(stream, parametrosLogsDAO );
*/			

			Globalvar.sessionGlobal.disconnect();
			
			
		} catch (Exception e) {
			System.out.println("Error execprocLogs "+e.getMessage());
		}

	}
	

}