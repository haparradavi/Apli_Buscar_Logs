package com.procesarlogs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.ConectionSSH.ConexionSSH;

public class BuscarErrorSyslog {

	public ParametrosLogsDAO procesarSyslog(ParametrosLogsDAO parametrosLogsDAO) throws Exception {
		String fechaentrada="";
		String fehcaFormatmin = "";
		String fehcaFormatmax = "";
		String Trazasyslog = "";
		String fechasinSegundos="";
		long numLinea=0;
		String fechaSyslog="";
		long infechaformat=0;
		long infechaformatmin=0;
		long infechaformatmax=0;
		String resulsed="";
		String rutasyslog="";
		String mes ="";
		StringBuilder resultLog = new StringBuilder();
		int segundosProceso=0;
		
		ConexionSSH conexionSSH = new ConexionSSH();
		try {
			
			fechaentrada = parametrosLogsDAO.getFechaInicio().replaceAll("T", " ");
			segundosProceso=parametrosLogsDAO.getSegundosProceso();
			segundosProceso=segundosProceso+3;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			cal.setTime(sdf.parse(fechaentrada));
			cal.add(Calendar.SECOND, -3);
			fehcaFormatmin = String.format("%1$tb %1$td %1$tH:%1$tM:%1$tS", cal).toUpperCase();
			mes =String.format("%1$tb", cal).toUpperCase();
			System.out.println("mes: "+mes);
			System.out.println("La fecha min log: " + fehcaFormatmin);
			cal.add(Calendar.SECOND,segundosProceso);
			fehcaFormatmax = String.format("%1$tb %1$td %1$tH:%1$tM:%1$tS", cal).toUpperCase();
			System.out.println("La fecha max log: " + fehcaFormatmax);
			
			fechasinSegundos= fehcaFormatmin.substring(0,fehcaFormatmin.length()-2);
			System.out.println("fechasinSegundos "+fechasinSegundos);

			Trazasyslog=conexionSSH.execCommanLinux("find /var/adm/ras/syslog* -type f  -mtime -1 | xargs grep -in '"+fechasinSegundos+"' | head -n 1");
			System.out.println("Trazasyslog "+Trazasyslog);
			if(Trazasyslog != null && !Trazasyslog.isEmpty()) {
				String[] arraylinea = Trazasyslog.split(":");
				rutasyslog=arraylinea[0];
				numLinea=Long.parseLong(arraylinea[1]);
				fechaSyslog =arraylinea[2]+":"+arraylinea[3]+":"+arraylinea[4].substring(0,2);
				infechaformat= formatfecha(fechaSyslog);
				infechaformatmin= formatfecha(fehcaFormatmin);			
				while(infechaformat<infechaformatmin ) {
					numLinea =numLinea+1;
					resulsed=conexionSSH.execCommanLinux("sed '"+numLinea+"q;d' "+rutasyslog);	
//					System.out.println("buscando: "+resulsed);
					if(resulsed.toUpperCase().contains(mes)) {
						infechaformat= formatfecha(resulsed.substring(0,15));
					}
				}

				System.out.println("fecha es mayor");
				infechaformatmax= formatfecha(fehcaFormatmax);
				while(infechaformat <= infechaformatmax ) {		
					resultLog.append(resulsed.concat("\n"));	
					resulsed=conexionSSH.execCommanLinux("sed '"+numLinea+"q;d' "+rutasyslog);	
					if(resulsed.toUpperCase().contains(mes)) {
				    	infechaformat= formatfecha(resulsed.substring(0,15));
				    }				
				    numLinea =numLinea+1;
				}
										
			}	
//			System.out.println("rutasyslog: "+resultLog);
			parametrosLogsDAO.setResultErrorSyslog(resultLog);
			return parametrosLogsDAO;

		} catch (Exception e) {
			System.out.println("procesarSyslog " + e.getMessage());
			throw e;
			// TODO: handle exception
		}
	}
	
	public long formatfecha(String fecha) {  // 'SEP 24 11:27:01' - 924112701
		long fechareturn=0;
		Calendar calinver  = Calendar.getInstance();
		SimpleDateFormat sdfinver  = new SimpleDateFormat("MMM dd HH:mm:ss");
		String format="";
		try {
			calinver .setTime(sdfinver.parse(fecha));
//			calinver .add(Calendar.SECOND, 30);
		    format =String.format("%1$tm%1$td%1$tH:%1$tM:%1$tS", calinver).replaceAll("[^0-9]","");
		    fechareturn = Long.parseLong(format);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fechareturn;
	}

}
