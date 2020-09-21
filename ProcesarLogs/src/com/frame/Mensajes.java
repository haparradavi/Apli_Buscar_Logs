package com.frame;

import javax.swing.JOptionPane;

public class Mensajes {
	
	public static JOptionPane mensajeInformativoParametrico(String mensaje) {
		JOptionPane msg = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE);
		return msg;
	}
	
	public static void mensajeInformativo(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje,"titulo",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void mensajeError(String mensaje) {	
		JOptionPane.showMessageDialog(null, mensaje,"titulo",JOptionPane.ERROR_MESSAGE);
	}
	
	public static  void mensajeWarning(String mensaje) {		
		JOptionPane.showMessageDialog(null, mensaje,"titulo",JOptionPane.WARNING_MESSAGE);
	}
	
	public static void mensajeQuestion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje,"titulo",JOptionPane.QUESTION_MESSAGE);
	}
	
	public static void mensajePlain(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje,"titulo",JOptionPane.PLAIN_MESSAGE);
	}

}

