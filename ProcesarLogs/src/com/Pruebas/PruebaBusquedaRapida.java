package com.Pruebas;

import java.io.IOException;

import com.ConectionSSH.ConexionAmbiente;
import com.Persistence.PBusquedaRapida;
import com.Persistence.PObtenerRutasYNombreLogs;
import com.Properties.Constantes;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.procesarlogs.ParametrosLogsDAO;

public class PruebaBusquedaRapida {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frontPersistemcePBusquedaRapida();
		

	}
	
	public static void frontPersistemcePBusquedaRapida() {
		ConexionAmbiente conecAmb = new ConexionAmbiente();
		ParametrosLogsDAO parametrosLogsDAO = new  ParametrosLogsDAO ();
		PBusquedaRapida persisBusqueda= new PBusquedaRapida();
        PObtenerRutasYNombreLogs persisobtenerRutasYNombreLogs=new PObtenerRutasYNombreLogs();
        
		
		try {
			conecAmb.conexion(2);
			parametrosLogsDAO.setAmbienteFabrica(1);	
			
//		    parametrosLogsDAO.setNombreServicio("ConsultaValorTasaMinimaProdConYSinLibranza");
//			parametrosLogsDAO.setFechatransaccion("2020-09-18T21:42:26");
//			
//			parametrosLogsDAO.setIdtransaccion("c0de33e8fa2111eaafc55a0405110000c0de34d8fa2111ea");
			parametrosLogsDAO.setIdtransaccion("2020-09-18T21:26");
			parametrosLogsDAO=persisobtenerRutasYNombreLogs.persistenceObtenerRutasYNombreLogs(parametrosLogsDAO);
           
//			parametrosLogsDAO.setNameLogcommand("trazabilidad20200917154000.log");

			
			System.out.println("Ruta archivo: "+parametrosLogsDAO.getRutaTraza());
			System.out.println(" Nombre Log: "+parametrosLogsDAO.getNameLogcommand());
			System.out.println("Ruta Error: "+parametrosLogsDAO.getRutaErrorlog());
			System.out.println(" Nombre Log Error: "+parametrosLogsDAO.getNameErrorcommand());
			
			parametrosLogsDAO =persisBusqueda.PersistencePBusquedaRapida(parametrosLogsDAO);
			parametrosLogsDAO = validacionnull(parametrosLogsDAO);
			System.out.println("result log: "+parametrosLogsDAO.getResultBusquedaLog());
			System.out.println("result error: "+parametrosLogsDAO.getResultBusquedaError());
			System.out.println("result idtransaccion "+parametrosLogsDAO.getIdtransaccion());
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error frontPersistemcePBusquedaRapida: "+e.getMessage());
			e.printStackTrace();
		}	
		
	}		
	
	
	public static ParametrosLogsDAO validacionnull(ParametrosLogsDAO parametrosLogsDAO) throws Exception{
		try {
			if(parametrosLogsDAO.getResultBusquedaLog() == null || parametrosLogsDAO.getResultBusquedaLog() .isEmpty()) {
				parametrosLogsDAO.setResultBusquedaLog(Constantes.MsgResultTrazaLog);
				}
			if(parametrosLogsDAO.getResultBusquedaError() == null || parametrosLogsDAO.getResultBusquedaError().isEmpty()) { 
				parametrosLogsDAO.setResultBusquedaError(Constantes.MsgResultError);
			}
			if(parametrosLogsDAO.getIdtransaccion()  == null || parametrosLogsDAO.getIdtransaccion().isEmpty()) { 
				parametrosLogsDAO.setIdtransaccion(Constantes.MsgIdTransaccion);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error frontPersistemcePBusquedaRapida: "+e.getMessage());
			throw e;
		}		
		return parametrosLogsDAO;
	}

}
