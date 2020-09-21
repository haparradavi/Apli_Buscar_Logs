package com.Persistence;

import java.io.IOException;

import com.ConectionSSH.ConexionSSH;
import com.Globales.Globalvar;
import com.jcraft.jsch.JSchException;
import com.procesarlogs.ParametrosLogsDAO;

public class PBusquedaRapida {
	
	public ParametrosLogsDAO  PersistencePBusquedaRapida(ParametrosLogsDAO parametrosLogsDAO)throws Exception  {
		ConexionSSH conexionSSH = new ConexionSSH();
		StringAXml mstringAXml = new StringAXml();
        

		 try {

			String lineService ,errortraza = null,trazaLog = null;
			String filepathtraza=parametrosLogsDAO.getRutaTraza().concat(parametrosLogsDAO.getNameLogcommand());
			String filepatherror=parametrosLogsDAO.getRutaErrorlog().concat(parametrosLogsDAO.getNameErrorcommand());
			if(parametrosLogsDAO.getIdtransaccion() != null && !parametrosLogsDAO.getIdtransaccion() .isEmpty()) {
			//	trazaLog=conexionSSH.execCommangrep(parametrosLogsDAO.getIdtransaccion(), filepathtraza);
				trazaLog=conexionSSH.execCommanLinux("find "+parametrosLogsDAO.getRutaTraza()+"tra* -type f -mtime -1 | xargs   grep -i  "+parametrosLogsDAO.getIdtransaccion());
				//errortraza=conexionSSH.execCommangrep(parametrosLogsDAO.getIdtransaccion(), filepatherror);
				errortraza=conexionSSH.execCommanLinux("grep -n "+parametrosLogsDAO.getIdtransaccion()+" "+filepatherror);
				errortraza =conexionSSH.validafintagerror(errortraza,filepatherror);
//				System.out.println("lineService: "+trazaLog);
//				System.out.println("errortraza: "+errortraza);
				
			}else {
			
				if(parametrosLogsDAO.getFechatransaccion() != null && !parametrosLogsDAO.getFechatransaccion() .isEmpty()) { 
					//lineService=conexionSSH.execCommanLinux("grep "+parametrosLogsDAO.getFechatransaccion()+" "+filepathtraza+"   | grep -i "+parametrosLogsDAO.getNombreServicio());
					lineService=conexionSSH.execCommanLinux("find "+parametrosLogsDAO.getRutaTraza()+"tra* -type f -mtime -1 | xargs   grep -i  "+parametrosLogsDAO.getFechatransaccion()+" | grep -i "+parametrosLogsDAO.getNombreServicio());
				}else {
					lineService=conexionSSH.execCommanLinux("tail -1 "+filepathtraza+" | grep -i "+parametrosLogsDAO.getNombreServicio());
				}
				if(lineService != null && !lineService.isEmpty()) {
					if(parametrosLogsDAO.getAmbienteFabrica()==1) {
						String[] parts = lineService.split(",");
						parametrosLogsDAO.setIdtransaccion(parts[1]);
					}else {
						parametrosLogsDAO =  mstringAXml.stringAXml(lineService,parametrosLogsDAO);
					}

					long start = System.currentTimeMillis();
					long end = start + 74*1000; // 60 seconds * 1000 ms/sec
					while (System.currentTimeMillis() < end){
						 errortraza=conexionSSH.execCommanLinux("grep -in "+parametrosLogsDAO.getIdtransaccion()+" "+filepatherror); 
						errortraza =conexionSSH.validafintagerror(errortraza,filepatherror);
						if(errortraza != null && !errortraza.isEmpty());
							break;
					}
								
					 //trazaLog=conexionSSH.execCommangrep(parametrosLogsDAO.getIdtransaccion(), filepathtraza);
					trazaLog=conexionSSH.execCommanLinux("find "+parametrosLogsDAO.getRutaTraza()+"tra* -type f -mtime -1 | xargs   grep -i  "+parametrosLogsDAO.getIdtransaccion());
//    				System.out.println("errortraza: "+errortraza);	
//			    	System.out.println("trazaLog "+trazaLog);
//					System.out.println("Idtransaccion "+parametrosLogsDAO.getIdtransaccion());
					
	
				}else {
					System.out.println("Servicio no encontrado ");
					trazaLog="Servicio no encontrado, buscar con la fecha de la transaccion en el campo IdTransaccion";
					errortraza="No se proceso el archivo de error debido a que no de encontro informacion del servicio";
				}
			
			}
			/*Para el front devuelve el reultado de log y el error y por consiguiente el idtransaccion*/
			trazaLog=conexionSSH.eliminarrutalog(trazaLog);
			parametrosLogsDAO.setResultBusquedaLog(trazaLog);
			parametrosLogsDAO.setResultBusquedaError(errortraza);
			Globalvar.sessionGlobal.disconnect();
			
	        } catch (JSchException | IOException ee) {
//	          System.out.println(ee);
	      	throw ee;
	      }

	return parametrosLogsDAO;
		
	}

}
