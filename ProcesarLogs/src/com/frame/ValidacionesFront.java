package com.frame;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.ConectionSSH.ConexionAmbiente;
import com.Persistence.PBusquedaRapida;
import com.Properties.Constantes;
import com.procesarlogs.BuscarErrorSyslog;
import com.procesarlogs.ParametrosLogsDAO;

public class ValidacionesFront {
	
	
	static boolean errorprocesoespera=false;
	static ParametrosLogsDAO parametrosLogsDAO1  =new ParametrosLogsDAO();
	
	
	public static boolean procesoespera(int metodoEjecucion,int ambiente,ParametrosLogsDAO parametrosLogsDAO) throws Exception{
		errorprocesoespera=false;
		parametrosLogsDAO1 =new ParametrosLogsDAO();
		JOptionPane msg= Mensajes.mensajeInformativoParametrico(Constantes.MsgProcesoEspera);
		try {
			final JDialog dlg = msg.createDialog(Constantes.MsgTituloDialog);
			dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dlg.disable();
			new Thread(new Runnable() {
				public void run(){
					try {
						switch (metodoEjecucion) {
						case 1:
					//		procesoTimer ();
							break;
						case 2:
							ConexionAmbiente conecAmb = new ConexionAmbiente();
							conecAmb.conexion(ambiente);
							break;
						case 3:
							PBusquedaRapida persisBusqueda= new PBusquedaRapida();
							parametrosLogsDAO1 =persisBusqueda.PersistencePBusquedaRapida(parametrosLogsDAO);
							break;	
						case 4:
							BuscarErrorSyslog buscarsyslog = new BuscarErrorSyslog();
							parametrosLogsDAO1=buscarsyslog.procesarSyslog(parametrosLogsDAO);
							break;	
	
						default:
							break;
						}
	
					} catch (Exception e) {
						errorprocesoespera=true;
						Mensajes.mensajeError("ValidacionesFront: "+e.getMessage());
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
