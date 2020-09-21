package com.procesarlogs;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import com.CrearArhivodeSalida.GenerarArhivoSalida;

public class TailBuscarServicio {
	
	//String ruta="C:/Users/haparra/Documents/GenerarLogs/logInver.txt";

	public ParametrosLogsDAO tailbusquedaservicio(StringBuilder sb,ParametrosLogsDAO parametrosLogsDAO) {
		
		try {
			GenerarArhivoSalida outfile =new GenerarArhivoSalida();
			BufferedWriter out =outfile.createFlieOut(parametrosLogsDAO.getRutaDestinoArchivo());
			
			
			boolean existService = true;
			String idtransaccion = null;
			boolean foundAllIdTransaccion = false;
			List<String> ordenarcadena= new ArrayList<String>();
			System.out.println("inicar a leer el archivo al reves");
			String[] cadena = sb.toString().split("\n");
			System.out.println("Entra");
			for (int i = cadena.length - 1; i >= 0; i--) {
				/*Control para validar el archivo log o el de error*/
				if(parametrosLogsDAO.getIdtransaccion() == null ||parametrosLogsDAO.getIdtransaccion() .isEmpty()) {
					// busca el ultimo servicio correspondiente
					if (cadena[i].contains(parametrosLogsDAO.getNombreServicio()) && existService) {
						String[] parts = cadena[i].split(",");
						idtransaccion = parts[1];
						parametrosLogsDAO.setIdtransaccion(idtransaccion);
						existService = false;
						foundAllIdTransaccion = true;
						
					}
					// busca el Idtransaccion del servicio 
					if (foundAllIdTransaccion) {
						if (cadena[i].contains(idtransaccion)) {		
							ordenarcadena.add(cadena[i]);
							
						}
						else
							break;
					}
				
				}else if(cadena[i].contains(parametrosLogsDAO.getIdtransaccion())) {
				/*se utiliza para validar el idtransaccion en el archivo de error*/
					out.write(cadena[i].concat("\n"));
					break;
				}
			}
			System.out.println("procesa el servicio encontrado");
			if (!ordenarcadena.equals(null)) {
				for (int i = ordenarcadena.size() - 1; i >= 0; i--) {
					System.out.println(ordenarcadena.get(i));
					out.write(ordenarcadena.get(i).concat("\n"));
				}
			}
				
			
			out.close();

		} catch (Exception e) {
			System.out.println("Error tailbusquedaservicio: "+e.getMessage());
		}
		
		return parametrosLogsDAO;
	}

}
