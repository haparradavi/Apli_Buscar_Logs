package com.Pruebas;

import java.io.IOException;

import com.ConectionSSH.ConexionAmbiente;
import com.Globales.Globalvar;
import com.Persistence.PBusquedaParametrica;
import com.Persistence.PObtenerRutasYNombreLogs;
import com.Properties.Constantes;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.procesarlogs.ParametrosLogsDAO;

public class PruebaBusquedaParametrica {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frontPersistemcePBusquedaParametrica();
		

	}

	private static void frontPersistemcePBusquedaParametrica() {
		
		ConexionAmbiente conecAmb = new ConexionAmbiente();
		ParametrosLogsDAO parametrosLogsDAO = new  ParametrosLogsDAO ();
		PObtenerRutasYNombreLogs persisobtenerRutasYNombreLogs=new PObtenerRutasYNombreLogs();
		PBusquedaParametrica persisBusquedaParametrica = new PBusquedaParametrica();

		try {
		conecAmb.conexion(1);
		parametrosLogsDAO.setAmbienteFabrica(2);
		parametrosLogsDAO=persisobtenerRutasYNombreLogs.persistenceObtenerRutasYNombreLogs(parametrosLogsDAO);

			
		//Para probar busqueda de parametros en el archivo
		//70,586b57e4f55511ea8a615a0405110000586b5884f55511ea,ADPTCHWS55.RESP.IN,2020-09-12T19:09:39.586736-05:00,XoomGetInstructions,N/A
//		parametrosLogsDAO.setNombreLog("trazabilidad20200912185703.log"); //IBM
//		parametrosLogsDAO.setNameLogcommand("trazabilidad20200916072035.log"); //TCS
		parametrosLogsDAO.setRutaDestinoArchivo("C:/Users/haparra/Documents/GenerarLogs/logInver.txt");
		parametrosLogsDAO.setTipoProcesoLog(2);  // parametro 2 ya que va arealizar la busqueda por parametros
		
//		parametrosLogsDAO.setAdaptador("FWKGTWYFD01.RESP.IN");
//    	parametrosLogsDAO.setCanal("37");
	    parametrosLogsDAO.setNombreServicio("liquidaTransferenciaRecibidaApp");
		//2020-09-11T18:34:14.310694-05:00
		// fecha fin prueba   70,2d4e079cf58111ea8a615a04051100002d4e086ef58111ea,FWKGTWYBX03.RESP.IN,2020-09-13T00:23:24.921857-05:00,XoomGetInstructions,N/A
	  //  parametrosLogsDAO.setIdtransaccion("76af6772f55511ea8d165a040511000076af6862f55511ea");
//		parametrosLogsDAO.setNombreServicio("ConsultaValorTasaMinimaProdConYSinLibranza");
		
	
//		parametrosLogsDAO.setFechaInicio("2020-09-16T21:25");
//		parametrosLogsDAO.setFechaFin("2020-09-16T21:28");
//		parametrosLogsDAO.setBusquedaparametro("ADPTCHWS61.REQ.IN");
	    
	    parametrosLogsDAO =persisBusquedaParametrica.PersistencePBusquedaParametrica(parametrosLogsDAO);
	    
	    if(parametrosLogsDAO.getResultBusquedaLog() == null || parametrosLogsDAO.getResultBusquedaLog() .isEmpty()) {
			parametrosLogsDAO.setResultBusquedaLog(Constantes.MsgResultTrazaLog);
			}
	   // Globalvar.sessionGlobal.disconnect();
	    
	    System.out.println(parametrosLogsDAO.getResultBusquedaLog());
	    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error frontPersistemcePBusquedaParametrica: "+e.getMessage());
			e.printStackTrace();
		}
		
	}

}
