package com.Pruebas;

import com.ProcesarProperties.LeerArchivoProperties;
import com.ProcesarProperties.PropertiesDao;

public class ProbarPoperties {

	
	public static void main(String[] args) {
		LeerArchivoProperties leer =new LeerArchivoProperties();
		PropertiesDao propertiesDao = new PropertiesDao();
		propertiesDao =leer.getProperties();

			propertiesDao.setIpDES("iiii....");
		    propertiesDao.setPassPROD("eiiiee....");
		    
		    leer.setProperties(propertiesDao);
		
		
			
	}

}
	

