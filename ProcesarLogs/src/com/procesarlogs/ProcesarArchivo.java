package com.procesarlogs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import com.Globales.Globalvar;

public class ProcesarArchivo {

	public ParametrosLogsDAO readFile(ParametrosLogsDAO parametrosLogsDAO) {

		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(parametrosLogsDAO.getStream()));
	
	//		BufferedReader buffer1 = new BufferedReader(new InputStreamReader(stream),1000*8192);
			String line = null;
			if (parametrosLogsDAO.getTipoProcesoLog()==1)
				parametrosLogsDAO=readFileFinal(line, buffer,parametrosLogsDAO);
			else
				parametrosLogsDAO=readAllFile(line, buffer,parametrosLogsDAO);

		} finally {
			System.out.println("proceso terminado");
			try {
				
				parametrosLogsDAO.getStream().close();
				Globalvar.sftpChannel.exit();
				Globalvar.sessionGlobal.disconnect();
				System.out.println("cierra conexiones");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return parametrosLogsDAO;

	}

	public ParametrosLogsDAO readFileFinal(String line, BufferedReader br,ParametrosLogsDAO parametrosLogsDAO) {
       System.out.println("inica en procesar el archivo readFileFinal");
       StringBuilder sb = new StringBuilder();
		try {
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
//				System.out.println(line);
			}
			
//			Scanner sc = new Scanner(parametrosLogsDAO.getStream(), "UTF-8");
//		    while (sc.hasNextLine()) {
//		    	sb.append(sc.nextLine()).append("\n");
//		        // System.out.println(line);
//		    }
			
			TailBuscarServicio tailBuscarServicio = new TailBuscarServicio();
			parametrosLogsDAO=tailBuscarServicio.tailbusquedaservicio(sb,parametrosLogsDAO);
		} catch (Exception e) {
			System.out.println("Exception occurred during reading file from SFTP server due to " + e.getMessage());
			e.getMessage();
			e.printStackTrace();
		}
		return parametrosLogsDAO;
	}

	public ParametrosLogsDAO readAllFile(String line, BufferedReader br,ParametrosLogsDAO parametrosLogsDAO) {
	       System.out.println("inica en procesar el archivo readAllFile");
	       StringBuilder sb = new StringBuilder();
		try {
			
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");				
			}

			LecturaLogs readLogs =new LecturaLogs();
			parametrosLogsDAO=readLogs.foundDatalog(sb,parametrosLogsDAO);
//			if(parametrosLogsDAO.getCloseFilesearchDate()==1)
//				break;
			Globalvar.setIndFechaInicioglobal(0);
			parametrosLogsDAO.getBufferwrite().close();
			
		} catch (IOException e) {
			System.out.println("Exception occurred during reading file from SFTP server due to " + e.getMessage());
			e.printStackTrace();
		}
		return parametrosLogsDAO;
	}

}
