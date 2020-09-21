package com.frame;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.ConectionSSH.ConexionAmbiente;
import com.ProcesarProperties.LeerArchivoProperties;
import com.ProcesarProperties.PropertiesDao;
import com.procesarlogs.ParametrosLogsDAO;

public class ValidacionesFront {
	static boolean errorprocesoespera=false;
	public static boolean procesoespera(int metodoEjecucion,int ambiente) throws Exception{
		
		JOptionPane msg= Mensajes.mensajeInformativoParametrico("Se esta ejecutando el proceso por favor espere");
		try {
			final JDialog dlg = msg.createDialog("Procesando...");
			dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dlg.disable();
			new Thread(new Runnable() {
				public void run(){
					try {
	//					Thread.sleep(5000);
						switch (metodoEjecucion) {
						case 1:
					//		procesoTimer ();
							break;
						case 2:
							ConexionAmbiente conecAmb = new ConexionAmbiente();
							conecAmb.conexion(ambiente);
							break;
						case 3:
							
							break;	
	
						default:
							break;
						}
	
					} catch (Exception e) {
						errorprocesoespera=true;
						Mensajes.mensajeError("ValidacionesFront: "+e.getMessage());
						System.out.println("aqui hubo error");
					}
					dlg.setVisible(false);
				}
			}).start();
			
			dlg.setVisible(true);
			dlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		} catch (Exception e) {
			errorprocesoespera=true;
			System.out.println("procesoespera"+e.getMessage());   
			throw e;
		}
		return errorprocesoespera;
		
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
