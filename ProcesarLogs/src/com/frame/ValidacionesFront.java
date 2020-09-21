package com.frame;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ValidacionesFront {
	
	public void procesoespera(int metodoEjecucion){
		
		JOptionPane msg= Mensajes.mensajeInformativoParametrico("Se esta ejecutando el proceso por favor espere");

		final JDialog dlg = msg.createDialog("Procesando...");
		dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dlg.disable();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
//					Thread.sleep(5000);
					switch (metodoEjecucion) {
					case 1:
						procesoTimer ();
						break;
					case 2:
						
						break;
					case 3:
						
						break;	

					default:
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				dlg.setVisible(false);
			}
		}).start();
		dlg.setVisible(true);
		dlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}
	
	public void procesoTimer () {
		long start = System.currentTimeMillis();
		long end = start + 5 * 1000;
		System.out.println("inicio");
		while (System.currentTimeMillis() < end)
			continue;
		System.out.println("fin");
	}

}
