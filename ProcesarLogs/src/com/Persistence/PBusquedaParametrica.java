package com.Persistence;

import java.io.IOException;

import com.ConectionSSH.ConexionSSH;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.procesarlogs.ParametrosLogsDAO;
import com.procesarlogs.ProcesarArchivo;

public class PBusquedaParametrica {

	public ParametrosLogsDAO PersistencePBusquedaParametrica(ParametrosLogsDAO parametrosLogsDAO) {
		ConexionSSH conexionSSH = new ConexionSSH();
		ProcesarArchivo procesar = new ProcesarArchivo();

		try {

			String filepath = parametrosLogsDAO.getRutaTraza().concat(parametrosLogsDAO.getNameLogcommand());
			System.out.println("Log traza:" + filepath);
			parametrosLogsDAO.setStream(conexionSSH.addFile(filepath));
			System.out.println("Archivo Encontrado OK....");
			parametrosLogsDAO = procesar.readFile(parametrosLogsDAO);

		} catch (IllegalAccessException | IOException | SftpException | JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error busquedaparametros: " + e.getMessage());
		}

		return parametrosLogsDAO;

	}

}
