package com.Pruebas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class minutos {

	public static void main(String[]args){
		
		String fecha1 = "2020-09-23T14:15:40".replaceAll("T", " ");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			cal.setTime(sdf.parse(fecha1));
			cal.add(Calendar.SECOND, -3);
		    System.out.println("La fecha actual aaa es: " + 
		      String.format("%1$tb %1$td %1$tH:%1$tM:%1$tS", cal).toUpperCase());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("******************************");
		
		String fechainver = "SEP 23 14:16:10";
		Calendar calinver  = Calendar.getInstance();
		SimpleDateFormat sdfinver  = new SimpleDateFormat("MMM dd HH:mm:ss");
		try {
			calinver .setTime(sdfinver.parse(fechainver));
			calinver .add(Calendar.SECOND, 30);
		    System.out.println("La fecha actual aaa es: " + 
		      String.format("%1$tm%1$td%1$tH:%1$tM:%1$tS", calinver).replaceAll("[^0-9]",""));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("******************************");
		String fechaActual="2020-09-23T14:15:40";
		String fecha3 = (fechaActual.substring(5,fechaActual.length())).replaceAll("[^0-9]","");
		System.out.println("fecha3 "+fecha3);

		
	}
}
