package com.Pruebas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.Globales.Globalvar;
import com.Persistence.PBusquedaRapida;
import com.Persistence.PObtenerRutasYNombreLogs;
import com.Properties.Constantes;
import com.frame.Imagenes;
import com.frame.ValidacionesFront;
import com.procesarlogs.ParametrosLogsDAO;

public class FramePrueba extends JFrame implements ActionListener {
	
	private JTextField textNombreServicio;
	private JTextField textFechaTransaccion;
	private JTextField textIdTransaccion;
	private JTextField textDirectorio;
	private JRadioButton rdbtnIBM;
	private JRadioButton rdbtnTcs;
	private JButton btnDirectorio;
	private JButton btnBuscar;
	private JScrollPane jscrollPane = null;
	private JTextArea textAreaLogs;
	private JTextArea textAreaError ;
	private int tipoAmbiente =0;
	private JTextField textFechaSyslog;
	private JTextArea textAreaSyslog ;
	private JButton btnBuscarSyslog;
	private JLabel lblSegundos;
	private JTextField textSegundos;

	public  FramePrueba (JTabbedPane tabbedPane) {
		
		JPanel jpbusquedaparametrica = new Imagenes();
//		tabbedPane.addTab("Busqueda", null, jpbusquedaparametrica, null);
		jpbusquedaparametrica.setLayout(null);
		
		JLabel lblNombreDelServicio = new JLabel("Nombre del Servicio: ");
		lblNombreDelServicio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDelServicio.setBounds(89, 109, 155, 14);
		jpbusquedaparametrica.add(lblNombreDelServicio);
		
		JLabel lblFechaTransaccion = new JLabel("Fecha de la Transacción:");
		lblFechaTransaccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaTransaccion.setBounds(89, 144, 176, 14);
		jpbusquedaparametrica.add(lblFechaTransaccion);
		
		JLabel lblIdTransaccion = new JLabel("Id Transaccion:");
		lblIdTransaccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdTransaccion.setBounds(89, 183, 121, 14);
		jpbusquedaparametrica.add(lblIdTransaccion);
		
		textNombreServicio = new JTextField();
		textNombreServicio.setColumns(10);
		textNombreServicio.setBounds(311, 107, 462, 20);
		jpbusquedaparametrica.add(textNombreServicio);
		
		textFechaTransaccion = new JTextField();
		textFechaTransaccion.setColumns(10);
		textFechaTransaccion.setBounds(311, 142, 271, 20);
		jpbusquedaparametrica.add(textFechaTransaccion);
		
	    JLabel lbltEjemploFechaTran = new JLabel("2020-09-20T11:32:57");
	    lbltEjemploFechaTran.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lbltEjemploFechaTran.setBounds(616, 144, 162, 14);
	    jpbusquedaparametrica.add(lbltEjemploFechaTran);
		
		textIdTransaccion = new JTextField();
		textIdTransaccion.setColumns(10);
		textIdTransaccion.setBounds(311, 181, 462, 20);
		jpbusquedaparametrica.add(textIdTransaccion);
		
		rdbtnIBM = new JRadioButton("IBM");
		rdbtnIBM.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnIBM.setBounds(365, 46, 121, 24);
		jpbusquedaparametrica.add(rdbtnIBM);
		
		textAreaLogs = new JTextArea();
		textAreaLogs.setBounds(89, 300, 1000, 194);
//		jpbusquedaparametrica.add(textAreaLogs);
		
		JLabel lblTrazaLogs = new JLabel("Traza Logs");
		lblTrazaLogs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrazaLogs.setBounds(89, 275, 121, 17);
		jpbusquedaparametrica.add(lblTrazaLogs);
		
		JLabel lblTrazaError = new JLabel("Traza Error");
		lblTrazaError.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrazaError.setBounds(89, 521, 121, 17);
		jpbusquedaparametrica.add(lblTrazaError);
		
		textAreaError = new JTextArea();
		textAreaError.setBounds(89, 543, 1000, 194);
//		jpbusquedaparametrica.add(textAreaError);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnBuscar.setBounds(537, 777, 100, 23);
		jpbusquedaparametrica.add(btnBuscar);
		
		JLabel lblDirectorio = new JLabel("Directorio:");
		lblDirectorio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDirectorio.setBounds(89, 219, 121, 14);
		jpbusquedaparametrica.add(lblDirectorio);
		
		btnDirectorio = new JButton("...");
		btnDirectorio.setFont(new Font("Dialog", Font.BOLD, 18));
		btnDirectorio.setBounds(801, 219, 64, 23);
		jpbusquedaparametrica.add(btnDirectorio);
		
		textDirectorio = new JTextField();
		textDirectorio.setEditable(false);
		textDirectorio.setColumns(10);
		textDirectorio.setBounds(311, 222, 462, 20);
		jpbusquedaparametrica.add(textDirectorio);
		
        JScrollPane standardScrollPaneLogs = new JScrollPane(textAreaLogs,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        standardScrollPaneLogs.setBounds(89, 300, 1000, 194);
		jpbusquedaparametrica.add(standardScrollPaneLogs);
		
        JScrollPane standardScrollPaneEror = new JScrollPane(textAreaError,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        standardScrollPaneEror.setBounds(89, 543, 1000, 194);
		jpbusquedaparametrica.add(standardScrollPaneEror);
		
		rdbtnTcs = new JRadioButton("TCS");
		rdbtnTcs.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnTcs.setBounds(548, 46, 121, 24);
		jpbusquedaparametrica.add(rdbtnTcs);
		
		ButtonGroup grupoButtonFabrica = new ButtonGroup();
		grupoButtonFabrica.add(rdbtnTcs);
		grupoButtonFabrica.add(rdbtnIBM);
		
		JLabel lblFechaDeSyslog = new JLabel("Fecha de syslog:");
		lblFechaDeSyslog.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaDeSyslog.setBounds(89, 856, 121, 19);
		jpbusquedaparametrica.add(lblFechaDeSyslog);
		
		textFechaSyslog = new JTextField();
		textFechaSyslog.setColumns(10);
		textFechaSyslog.setBounds(237, 857, 170, 20);
		jpbusquedaparametrica.add(textFechaSyslog);
		
		textAreaSyslog = new JTextArea();
		textAreaSyslog.setBounds(89, 930, 1000, 194);
		jpbusquedaparametrica.add(textAreaSyslog);
		
		JLabel lblTrazasyslog = new JLabel("Traza Syslog");
		lblTrazasyslog.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrazasyslog.setBounds(89, 912, 121, 17);
		jpbusquedaparametrica.add(lblTrazasyslog);
		
        JScrollPane standardScrollPanelSyslog = new JScrollPane(textAreaSyslog,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        standardScrollPanelSyslog.setBounds(89, 930, 1000, 194);
		jpbusquedaparametrica.add(standardScrollPanelSyslog);
		
		btnBuscarSyslog = new JButton("Buscar Syslog");
		btnBuscarSyslog.setFont(new Font("Dialog", Font.BOLD, 15));
		btnBuscarSyslog.setBounds(530, 1145, 120, 23);
		jpbusquedaparametrica.add(btnBuscarSyslog);
//		
		// 1200, 897
//		jpbusquedaparametrica.setPreferredSize(new Dimension( 1130, 810));
		jpbusquedaparametrica.setPreferredSize(new Dimension( 1130, 1200));
		
		jscrollPane = new JScrollPane();
//	    jscrollPane.setBounds(5,10, 1130, 810);
	     jscrollPane.setBounds(5,10, 1130, 1200);
	    jscrollPane.setViewportView(jpbusquedaparametrica);
	    
	    lblSegundos = new JLabel("Segundos:");
	    lblSegundos.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblSegundos.setBounds(89, 882, 121, 19);
	    jpbusquedaparametrica.add(lblSegundos);
	    
	    textSegundos = new JTextField();
	    textSegundos.setColumns(10);
	    textSegundos.setBounds(237, 883, 57, 20);
	    jpbusquedaparametrica.add(textSegundos);
//		tabbedPane.addTab("Busqueda", null, jscrollPane, null);
		
		
		rdbtnTcs.addActionListener(this);
		rdbtnIBM.addActionListener(this);
		btnDirectorio.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnBuscarSyslog.addActionListener(this);
	}
	
	public  void recibirAmbienteConexion (int ambienteconexion) {
		System.out.println("llego al panel bisqueda dato: "+ambienteconexion);
		tipoAmbiente=ambienteconexion;
		
//		JPanel FramePruebarapida = new JPanel();
//		InicioBuscarLogs.tabbedPane.addTab("Busqueda", null, FramePruebarapida, null);
//		FramePruebarapida.setLayout(null);
//		
//		textField_1 = new JTextField();
//		textField_1.setBounds(289, 100, 86, 20);
//		FramePruebarapida.add(textField_1);
//		textField_1.setColumns(10);
//		
//		JLabel lblNewLabel_1 = new JLabel("Recepcion");
//		lblNewLabel_1.setBounds(176, 103, 69, 14);
//		FramePruebarapida.add(lblNewLabel_1);
//		FramePruebarapida.revalidate();
		
//		textField_1.setText(dato);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
