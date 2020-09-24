package com.Pruebas;

import com.ProcesarProperties.LeerArchivoProperties;
import com.ProcesarProperties.PropertiesDao;

public class ProbarPoperties {

	
	public static void main(String[] args) {
		LeerArchivoProperties leer =new LeerArchivoProperties();
		PropertiesDao propertiesDao = new PropertiesDao();
		try {
			

		
		propertiesDao =leer.getProperties();
         System.out.println("propiedaddes: "+propertiesDao.getIpDES());
			propertiesDao.setIpDES("uuuuu");
		    propertiesDao.setPassPROD("mmmm");
//		    
		    leer.setProperties(propertiesDao);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
	}

}
	

