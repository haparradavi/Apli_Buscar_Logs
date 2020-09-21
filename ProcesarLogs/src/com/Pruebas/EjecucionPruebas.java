package com.Pruebas;


import java.io.IOException;

import com.procesarlogs.LecturaLogs;
import com.procesarlogs.ParametrosLogsDAO;


public class EjecucionPruebas {

	public static void main(String[] args) throws IOException {
		 LecturaLogs as = new LecturaLogs();
		ParametrosLogsDAO param = new ParametrosLogsDAO();
		param.setAdaptador("ADPINTSPSAF01.REQ.IN");
		param.setCanal("16");
		param.setNombreServicio("AperturaProductosBancaPatrimonial");
		//2020-09-11T18:34:14.310694-05:00
        param.setFechaInicio("2020-09-11T18:34:13.588274-05:00");
        param.setRutaDestinoArchivo("C:/Users/haparra/Documents/GenerarLogs/Dataencontrda.txt");
        String cadena ="16,4c6192f2f48711eaa3cf5a04051100004c619428f48711ea,ADPINTSPSAF01.REQ.IN,2020-09-11T18:34:13.578274-05:00,AperturaProductosBancaPatrimonial,N/A";
        //ParametrosLogsDAO param1= as.foundDatalog(sb,param);
       // param1.getBufferwrite().close();

		
	}

}
