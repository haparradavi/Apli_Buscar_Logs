package com.Pruebas;

import com.ConectionSSH.ConexionAmbiente;
import com.procesarlogs.BuscarErrorSyslog;
import com.procesarlogs.ParametrosLogsDAO;

public class ProbarBuscarSyslog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionAmbiente conecAmb = new ConexionAmbiente();
		try {
			conecAmb.conexion(1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Sep 26 08:06:31 
		StringBuilder resultLog = new StringBuilder();
		BuscarErrorSyslog buscarsyslog = new BuscarErrorSyslog();
		String fecha= "2020-09-26T15:52:03";
		ParametrosLogsDAO parametrosLogsDAO = new  ParametrosLogsDAO ();
		try {

			
			parametrosLogsDAO.setFechaInicio("2020-09-26T15:52:03");
			parametrosLogsDAO=buscarsyslog.procesarSyslog(parametrosLogsDAO);
			System.out.println("resultado: "+resultLog);
		} catch (Exception e) {
			System.out.println("ProbarBuscarSyslog "+e.getMessage());
			e.printStackTrace();
		}

	}

}
