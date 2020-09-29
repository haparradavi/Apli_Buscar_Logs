package com.frame;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.UIManager;

import com.Globales.Globalvar;
import com.Properties.Constantes;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.net.URL;

public class InicioBuscarLogs {

	public static JPConexion jpconexion;
	public static JPBusqueda jpBusqueda;
	private JFrame frmBusquedaLogs;
	public JButton btnConectar;
	private JTabbedPane tabbedPane;
	public URL fondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					 UIManager.setLookAndFeel(new GraphiteLookAndFeel());  
					UIManager.setLookAndFeel(new AcrylLookAndFeel());
					InicioBuscarLogs window = new InicioBuscarLogs();
					window.frmBusquedaLogs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioBuscarLogs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmBusquedaLogs = new JFrame();
		frmBusquedaLogs.setTitle(Constantes.nameAplicacion);
		frmBusquedaLogs.setBounds(100, 100, 1200, 897);
		frmBusquedaLogs.setIconImage(new ImageIcon(getClass().getResource(Constantes.rutaicono)).getImage());
		frmBusquedaLogs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBusquedaLogs.setLocationRelativeTo(null);
//		frmBusquedaLogs.setResizable(false);
		frmBusquedaLogs.dispose();
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmBusquedaLogs.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		jpconexion = new JPConexion(tabbedPane);
		jpBusqueda = new JPBusqueda(tabbedPane);

		frmBusquedaLogs.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				
				if (Globalvar.sessionGlobal != null && Globalvar.sessionGlobal.isConnected()) {
					Globalvar.sessionGlobal.disconnect();
				}
				System.exit(0);
			}
		});

	}

}
