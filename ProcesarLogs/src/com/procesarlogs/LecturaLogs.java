package com.procesarlogs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.CrearArhivodeSalida.GenerarArhivoSalida;
import com.Globales.Globalvar;
import com.Persistence.StringAXml;
import com.Properties.Constantes;


public class LecturaLogs {
	
	
	
	public ParametrosLogsDAO foundDatalog(StringBuilder sb,ParametrosLogsDAO parametros) throws IOException {
		
		try {
			System.out.println("Inicia foundata");
			GenerarArhivoSalida outfile =new GenerarArhivoSalida();
			parametros.setBufferwrite(outfile.createFlieOut(parametros.getRutaDestinoArchivo()));
			List<String> listParamFront= new ArrayList<String>();
			listParamFront =evaluaLisVaciaFront(parametros);
			String[] lineFile = sb.toString().split("\n");
			
			for (String cadena : lineFile) {
				ParametrosLogsDAO paramLog = splitDataFile(cadena,parametros.getAmbienteFabrica());			
				List<String> listParamLineDAO= new ArrayList<String>();
				listParamLineDAO.add(paramLog.getAdaptador());
				listParamLineDAO.add(paramLog.getCanal());
				listParamLineDAO.add(paramLog.getNombreServicio());
				listParamLineDAO.add(paramLog.getIdtransaccion());

				if(parametros.getFechaFin() == null || parametros.getFechaFin() .isEmpty()) {				
					if(parametros.getFechaInicio() != null && !parametros.getFechaInicio() .isEmpty()) { listParamLineDAO.add(replaceFecha(paramLog.getFechaInicio(), parametros.getFechaInicio()));}
					if(contineAlldataList(listParamLineDAO,listParamFront)) {
					//	System.out.println("Buscando por fecha encontrado");
						parametros.getBufferwrite().write(cadena.concat("\n"));
						parametros.setResultBusquedaLog(Constantes.MsgResultTrazaLogOK);
					}	
					//	else
					//System.out.println("NO contiene todos los datos");
				}else {
					listParamLineDAO.add(paramLog.getFechaInicio());
					parametros=busquedaporfecha(listParamLineDAO, parametros, cadena);
					if(parametros.getCloseFilesearchDate()==1)
						break;
				}
				     
			}	
			
		} catch (Exception e) {
			System.out.println("Error foundDatalog:" +e);
		}
			return parametros;
		
	}
	
	public List<String> evaluaLisVaciaFront (ParametrosLogsDAO parametros){
		
		List<String> list= new ArrayList<String>();
		if(parametros.getAdaptador() != null && !parametros.getAdaptador() .isEmpty()) { list.add(parametros.getAdaptador()); }
		if(parametros.getCanal() != null && !parametros.getCanal() .isEmpty()) { list.add(parametros.getCanal());}
		if(parametros.getFechaInicio() != null && !parametros.getFechaInicio() .isEmpty()) { list.add(replaceFecha(parametros.getFechaInicio(), parametros.getFechaInicio()));}
		if(parametros.getNombreServicio() != null && !parametros.getNombreServicio() .isEmpty()) { list.add(parametros.getNombreServicio()); }
		if(parametros.getIdtransaccion() != null && !parametros.getIdtransaccion() .isEmpty()) { list.add(parametros.getIdtransaccion()); }
		
		return list;
		
	}
	
    public ParametrosLogsDAO busquedaporfecha(List<String> listParamLineDAO, ParametrosLogsDAO parametros, String cadena) throws IOException {

    	String fechaprocLine = "";
    	String fechaprocfin= "";
    	long intfechaIniArchivo=0;
    	long intfechaFinFront=0;
    	 try {
	    	if(Globalvar.getIndFechaInicioglobal()==0) { // normalmente a la ejecucion del programa la variable se encuentra en cero
	    		fechaprocLine= replaceFecha(listParamLineDAO.get(4), parametros.getFechaInicio());
	    		fechaprocfin = replaceFecha(parametros.getFechaInicio(), parametros.getFechaInicio());
	    		intfechaIniArchivo = Long.parseLong(fechaprocLine);
	    		intfechaFinFront =Long.parseLong(fechaprocfin);
	    		if(intfechaFinFront<=intfechaIniArchivo) {
	    			if(parametros.getBusquedaparametro() == null || parametros.getBusquedaparametro() .isEmpty()) {
	    				parametros.getBufferwrite().write(cadena.concat("\n"));
	    				parametros.setResultBusquedaLog(Constantes.MsgResultTrazaLogOK);
//	    	    		System.out.println("imprime encontro fecha inicio");
	    	    		Globalvar.setIndFechaInicioglobal(1);
	    			}else if(listParamLineDAO.contains(parametros.getBusquedaparametro())) {
//	    	    		System.out.println("imprime encontro fecha inicio");
	    	    		Globalvar.setIndFechaInicioglobal(1);
	    	    		parametros.getBufferwrite().write(cadena.concat("\n")); 
	    	    		parametros.setResultBusquedaLog(Constantes.MsgResultTrazaLogOK);
	    			}
	    		}
	    		
	    	}else {
	    		fechaprocLine= replaceFecha(listParamLineDAO.get(4), parametros.getFechaFin());
	    		fechaprocfin = replaceFecha(parametros.getFechaFin(), parametros.getFechaFin());
	    		intfechaIniArchivo = Long.parseLong(fechaprocLine);
	    		intfechaFinFront =Long.parseLong(fechaprocfin);
	    		if(intfechaIniArchivo<=intfechaFinFront) {
	    			if(parametros.getBusquedaparametro() == null || parametros.getBusquedaparametro() .isEmpty()) {
	    				parametros.getBufferwrite().write(cadena.concat("\n"));
	    				parametros.setResultBusquedaLog(Constantes.MsgResultTrazaLogOK);
//	        			System.out.println("imprime linea en el archivo ya que encontro");
	    			}else if(listParamLineDAO.contains(parametros.getBusquedaparametro())) {
	    					parametros.getBufferwrite().write(cadena.concat("\n"));   
	    					parametros.setResultBusquedaLog(Constantes.MsgResultTrazaLogOK);
	    			}
	    		}else {
	    			Globalvar.setIndFechaInicioglobal(0);
	    			parametros.setCloseFilesearchDate(1);
	    			System.out.println("salirse de la lectura del archivo ya que no encontro mas registros que coincidan");
	    		}
	    			
	    	}
	    	
 		} catch (Exception e) {
			System.out.println("Error busquedaporfecha:" +e);
		}
    	 return parametros;
	    		    	
    }
	
	
	public boolean contineAlldataList(List<String> listParamLineDAO, List<String> listParamFront) {
		
		boolean evaluarContendor= true;

		for (int i = 0; i < listParamFront.size(); i++) {
			if(!listParamLineDAO.contains(listParamFront.get(i))) {
				evaluarContendor= false;
			    break;
			}		
		}
		
		return evaluarContendor;
		
	}
	
	public String replaceFecha (String fecha, String fechaFront) {
		String fechafin="";
		fecha= fecha.substring(0,fechaFront.length());
		fechafin= fecha.replaceAll("[^0-9]", "");
		return fechafin;
	}
	
	public ParametrosLogsDAO splitDataFile (String cadena, int ambienteFabrica){
		ParametrosLogsDAO paramLog =new ParametrosLogsDAO();
		StringAXml stringAXmlv =new StringAXml();
		try {
			if(ambienteFabrica==1){
				String[] parts = cadena.split(",");
				paramLog.setCanal(parts[0]);
				paramLog.setIdtransaccion(parts[1]);
				paramLog.setAdaptador(parts[2]);
				paramLog.setFechaInicio(parts[3]);
				paramLog.setNombreServicio(parts[4]);
		}else {
			paramLog=stringAXmlv.stringAXml( cadena,paramLog);
		}
            
		} catch (Exception e) {
			System.out.println("splitDataFile: "+"  "+cadena+" "+e);
		}
		return paramLog;
	}
	
}
