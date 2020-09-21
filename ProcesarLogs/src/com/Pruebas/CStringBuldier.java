package com.Pruebas;

public class CStringBuldier {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		sb.append("0,1,2,3,4,5,6");
		sb.append("\n");
		sb.append("line 2");
		sb.append("\n");
		sb.append("line 3");
		sb.append("\n");
		sb.append("line 4");
		sb.append("\n");
		sb.append("line 5");
		sb.append("\n");
		sb.append("line 6");
		sb.append("\n");
		sb.append("line 7");
		sb.append("\n");
		sb.append("line 8");
		sb.append("\n");
		sb.append("line 9");
		sb.append("\n");
		sb.append("line 10");



/*		String[] cadena = sb.toString().split("\n");
		for (int i = cadena.length - 1; i >= 0; i--) {
			System.out.println("Content = " + cadena[i]);
			if (cadena[i].contains("3")) {
				System.out.println("contiene el numero"+cadena[i]);
			}
			
*/			
			

		String[] lineFile = sb.toString().split("\n");
			for (String lin : lineFile) {
				System.out.println(lin);
			}
	
		
		
		
		/*
		 * 		String[] lines = sb.toString().split("\n");
		for (String str : lines) {
			System.out.println("Content = " + str);
			// System.out.println("Length = " + s.length());
			String[] lineFile = str.split(",");
			for (String lin : lineFile) {
				System.out.println("Content = " + lin);
				// System.out.println("Length = " + s.length());
			}
		}
		 */

	}
	
	public void prueba (String[] cadena ) {
		
	}

}
