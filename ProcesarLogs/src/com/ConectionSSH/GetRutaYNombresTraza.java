package com.ConectionSSH;

import java.io.IOException;

import com.ProcesarProperties.LeerArchivoProperties;
import com.ProcesarProperties.PropertiesDao;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.procesarlogs.ParametrosLogsDAO;

public class GetRutaYNombresTraza {
	
	public  ParametrosLogsDAO getRutaLogs(int tipoAmbiente, ParametrosLogsDAO parametrosLogsDAO)throws IllegalAccessException, JSchException, IOException, SftpException, InterruptedException {
		
		LeerArchivoProperties leer =new LeerArchivoProperties();
		ConexionSSH conn =new ConexionSSH();
		PropertiesDao propertiesDao = new PropertiesDao();
		propertiesDao =leer.getProperties();
		
       try {
			switch (tipoAmbiente) {
			
			case 1: // Desarrollo			
				if (parametrosLogsDAO.getAmbienteFabrica()==1) {
					parametrosLogsDAO.setRutaTraza(propertiesDao.getRutaTrazaLogIBMDES());
					parametrosLogsDAO.setRutaErrorlog((propertiesDao.getRutaTrazaErrorIBMDES()));
					parametrosLogsDAO.setNameLogcommand(conn.getFinalLog(parametrosLogsDAO.getRutaTraza(),"traza*.log "));
					parametrosLogsDAO.setNameErrorcommand(conn.getFinalLog(parametrosLogsDAO.getRutaErrorlog(),"Error*"));
				}else {
					parametrosLogsDAO.setRutaTraza(propertiesDao.getRutaTrazaLogTCSDES());
					parametrosLogsDAO.setRutaErrorlog((propertiesDao.getRutaTrazaErrorTCSDES()));
					parametrosLogsDAO.setNameLogcommand(conn.getFinalLog(parametrosLogsDAO.getRutaTraza(),"traza*.log "));
					parametrosLogsDAO.setNameErrorcommand(conn.getFinalLog(parametrosLogsDAO.getRutaErrorlog(),"Error*"));
				}
				break;
	
			case 2: // Laboratorio			
				parametrosLogsDAO.setRutaTraza(propertiesDao.getRutaTrazaLogLAB());
				parametrosLogsDAO.setRutaErrorlog(propertiesDao.getRutaTrazaErrorLAB());
				parametrosLogsDAO.setNameLogcommand(conn.getFinalLog(parametrosLogsDAO.getRutaTraza(),"traza*.log "));
				parametrosLogsDAO.setNameErrorcommand(conn.getFinalLog(parametrosLogsDAO.getRutaErrorlog(),"Error*"));
				break;
	
			case 3:  // Produccion			
				parametrosLogsDAO.setRutaTraza(propertiesDao.getRutaTrazaLogPROD());
				parametrosLogsDAO.setRutaErrorlog(propertiesDao.getRutaTrazaErrorPROD());
				parametrosLogsDAO.setNameLogcommand(conn.getFinalLog(parametrosLogsDAO.getRutaTraza(),"traza*.log "));
				parametrosLogsDAO.setNameErrorcommand(conn.getFinalLog(parametrosLogsDAO.getRutaErrorlog(),"Error.txt"));
				break;
	
			default:
				break;
			}
		
		} catch (JSchException| IOException | SftpException |InterruptedException  e) {
			// TODO Auto-generated catch block
			System.out.println("Error getRutaLogs: "+e.getMessage());
			throw e;
		}	
		
		return parametrosLogsDAO;
	}

}
