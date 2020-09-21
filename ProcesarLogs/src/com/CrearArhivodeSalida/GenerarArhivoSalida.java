package com.CrearArhivodeSalida;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class GenerarArhivoSalida {
	
	public BufferedWriter createFlieOut(String rutaFileOut) {
		BufferedWriter out=null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaFileOut)));
			
		} catch (FileNotFoundException e) {
			System.out.println("Arhivo no encontrado "+e.getMessage());
			e.printStackTrace();
		}
		return out;
	}
	

}
