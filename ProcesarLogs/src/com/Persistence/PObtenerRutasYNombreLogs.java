package com.Persistence;

import java.io.IOException;

import com.ConectionSSH.GetRutaYNombresTraza;
import com.Globales.Globalvar;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.procesarlogs.ParametrosLogsDAO;

public class PObtenerRutasYNombreLogs {
	
	public ParametrosLogsDAO persistenceObtenerRutasYNombreLogs(ParametrosLogsDAO parametrosLogsDAO)throws IllegalAccessException, JSchException, IOException, SftpException, InterruptedException {
		try {
			
	
			GetRutaYNombresTraza  getRutaYNombresTraza =new GetRutaYNombresTraza();	
			parametrosLogsDAO =getRutaYNombresTraza.getRutaLogs(Globalvar.getTipoAmbiente(), parametrosLogsDAO);
			return parametrosLogsDAO;
		} catch (JSchException| IOException | SftpException |InterruptedException  e) {
			// TODO: handle exception
			throw e;
		}	
	}
	

}
