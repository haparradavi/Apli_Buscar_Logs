package com.ConectionSSH;

import java.io.IOException;

import com.Globales.Globalvar;
import com.ProcesarProperties.LeerArchivoProperties;
import com.ProcesarProperties.PropertiesDao;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

public class ConexionAmbiente {
	
	
	public  void conexion(int ambienteConn) throws IllegalAccessException, JSchException, IOException, SftpException {

		ConexionSSH connecSSh = new ConexionSSH();
		LeerArchivoProperties leer =new LeerArchivoProperties();
		PropertiesDao propertiesDao = new PropertiesDao();
		
		propertiesDao =leer.getProperties();
		
		switch (ambienteConn) {
		
		case 1: // Desarrollo			
			connecSSh.connect(propertiesDao.getUserDES(), propertiesDao.getIpDES(), propertiesDao.getPassDES(),Integer.parseInt(propertiesDao.getPortDES()) );
			Globalvar.setTipoAmbiente(1);
			break;

		case 2: // Laboratorio			
			connecSSh.connect(propertiesDao.getUserLAB(), propertiesDao.getIpLAB(), propertiesDao.getPassLab(),Integer.parseInt(propertiesDao.getPortLAB()) );
			Globalvar.setTipoAmbiente(2);
			break;

		case 3:  // Produccion			
			connecSSh.connect(propertiesDao.getUserPROD(), propertiesDao.getIpPROD(), propertiesDao.getPassPROD(),Integer.parseInt(propertiesDao.getPortPROD()) );
			Globalvar.setTipoAmbiente(3);
			break;

		default:
			break;
		}
	}

}
