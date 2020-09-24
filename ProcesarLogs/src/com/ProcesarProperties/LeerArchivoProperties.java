package com.ProcesarProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

import com.Properties.Constantes;

public class LeerArchivoProperties {
	


	public PropertiesDao getProperties() {
		Properties propiedades = new Properties();
		PropertiesDao propertiesDAO = new PropertiesDao();
		InputStream url=null;
		try {
//			propiedades.load(new FileInputStream(Constantes.getRutaproperties()));
			 url = ClassLoader.getSystemResourceAsStream("com/Properties/DatosConexion.properties");
			propiedades.load(url);

			propertiesDAO.setUserDES(propiedades.getProperty("userDES"));
			propertiesDAO.setUserLAB(propiedades.getProperty("userLAB"));
			propertiesDAO.setUserPROD(propiedades.getProperty("userPROD"));
			propertiesDAO.setPassDES(propiedades.getProperty("passDES"));
			propertiesDAO.setPassLab(propiedades.getProperty("passLab"));
			propertiesDAO.setPassPROD(propiedades.getProperty("passPROD"));
			propertiesDAO.setPortDES(propiedades.getProperty("portDES"));
			propertiesDAO.setPortLAB(propiedades.getProperty("portLAB"));
			propertiesDAO.setPortPROD(propiedades.getProperty("portPROD"));
			propertiesDAO.setIpDES(propiedades.getProperty("ipDES"));
			propertiesDAO.setIpLAB(propiedades.getProperty("ipLAB"));
			propertiesDAO.setIpPROD(propiedades.getProperty("ipPROD"));
			propertiesDAO.setRutaTrazaLogIBMDES(propiedades.getProperty("rutaTrazaLogIBMDES"));
			propertiesDAO.setRutaTrazaLogTCSDES(propiedades.getProperty("rutaTrazaLogTCSDES"));
			propertiesDAO.setRutaTrazaErrorIBMDES(propiedades.getProperty("rutaTrazaErrorIBMDES"));
			propertiesDAO.setRutaTrazaErrorTCSDES(propiedades.getProperty("rutaTrazaErrorTCSDES"));
			propertiesDAO.setRutaTrazaLogLAB(propiedades.getProperty("rutaTrazaLogLAB"));
			propertiesDAO.setRutaTrazaLogPROD(propiedades.getProperty("rutaTrazaLogPROD"));
			propertiesDAO.setRutaTrazaErrorLAB(propiedades.getProperty("rutaTrazaErrorLAB"));
			propertiesDAO.setRutaTrazaErrorPROD(propiedades.getProperty("rutaTrazaErrorPROD"));
	
			url.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }finally {
				
        }

		return propertiesDAO;

	}

	public void setProperties(PropertiesDao propertiesDAO) {

		Properties propiedades = new Properties();
		InputStream url=null;
		try {
			
			propiedades.load(new FileInputStream(Constantes.getRutaproperties()));
			
//			 url = ClassLoader.getSystemResourceAsStream("com/Properties/DatosConexion.properties");
//			propiedades.load(url);
			
			
			propiedades.setProperty("userDES", propertiesDAO.getUserDES());
			propiedades.setProperty("userLAB", propertiesDAO.getUserLAB());
			propiedades.setProperty("userPROD", propertiesDAO.getUserPROD());
			propiedades.setProperty("passDES", propertiesDAO.getPassDES());
			propiedades.setProperty("passLab", propertiesDAO.getPassLab());
			propiedades.setProperty("passPROD", propertiesDAO.getPassPROD());
			propiedades.setProperty("portDES", propertiesDAO.getPortDES());
			propiedades.setProperty("portLAB", propertiesDAO.getPortLAB());
			propiedades.setProperty("portPROD", propertiesDAO.getPortPROD());
			propiedades.setProperty("ipDES", propertiesDAO.getIpDES());
			propiedades.setProperty("ipLAB", propertiesDAO.getIpLAB());
			propiedades.setProperty("ipPROD", propertiesDAO.getIpPROD());
			propiedades.setProperty("rutaTrazaLogIBMDES", propertiesDAO.getRutaTrazaLogIBMDES());
			propiedades.setProperty("rutaTrazaLogTCSDES", propertiesDAO.getRutaTrazaLogTCSDES());
			propiedades.setProperty("rutaTrazaErrorIBMDES", propertiesDAO.getRutaTrazaErrorIBMDES());
			propiedades.setProperty("rutaTrazaErrorTCSDES", propertiesDAO.getRutaTrazaErrorTCSDES());
			propiedades.setProperty("rutaTrazaLogLAB", propertiesDAO.getRutaTrazaLogLAB());
			propiedades.setProperty("rutaTrazaLogPROD", propertiesDAO.getRutaTrazaLogPROD());
			propiedades.setProperty("rutaTrazaErrorLAB", propertiesDAO.getRutaTrazaErrorLAB());
			propiedades.setProperty("rutaTrazaErrorPROD", propertiesDAO.getRutaTrazaErrorPROD());


			FileOutputStream fileout = new FileOutputStream(Constantes.getRutaproperties().replace("\\", "/"));
			propiedades.store(fileout, null);
//			OutputStream  output = new FileOutputStream(ClassLoader.getSystemResource("com/Properties/DatosConexion.properties").getFile());
//		    propiedades.store(output, null);
//			output.close();


			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
