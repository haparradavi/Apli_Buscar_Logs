package com.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.List;
import java.awt.Panel;
import java.net.URL;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class InicioBuscarLogs {

	public static JPConexion jpconexion;
	public static JPBusqueda jpBusqueda;
	private JFrame frmBusquedaLogs;
	private JTextField textUser;
	private JTextField textField_1;
	public JButton btnConectar;
	private JTabbedPane tabbedPane;
	private JTextField textPassword;
	private Image imagenfondo;
	public URL fondo;
	private JTextField textHost;
	private JTextField textMostrarUser;
	private JTextField textMostrarPassword;
	private JTextField textMostrarHost;
	private JTextField textPort;
	private JTextField textMostrarPort;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		frmBusquedaLogs.setTitle("Aplicacion Busqueda Logs");
		frmBusquedaLogs.setBounds(100, 100, 1200, 897);
		frmBusquedaLogs.setIconImage(new ImageIcon(getClass().getResource("/com/Images/logo6.png")).getImage());
		frmBusquedaLogs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBusquedaLogs.setLocationRelativeTo(null);
//		frmBusquedaLogs.setResizable(false);
		frmBusquedaLogs.dispose();
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmBusquedaLogs.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		jpconexion =new JPConexion(tabbedPane);
//		conexion();
		jpBusqueda =new JPBusqueda(tabbedPane);
/*
		JPanel jpbusquedaparametrica = new Imagenes();
		tabbedPane.addTab("Busqueda", null, jpbusquedaparametrica, null);
		jpbusquedaparametrica.setLayout(null);
		
		JLabel lblNombreDelServicio = new JLabel("Nombre del Servicio: ");
		lblNombreDelServicio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDelServicio.setBounds(89, 109, 155, 14);
		jpbusquedaparametrica.add(lblNombreDelServicio);
		
		JLabel lblFechaDeLa = new JLabel("Fecha de la Transacci\u00F3n:");
		lblFechaDeLa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaDeLa.setBounds(89, 144, 176, 14);
		jpbusquedaparametrica.add(lblFechaDeLa);
		
		JLabel lblIdTransaccion = new JLabel("Id Transaccion:");
		lblIdTransaccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdTransaccion.setBounds(89, 183, 121, 14);
		jpbusquedaparametrica.add(lblIdTransaccion);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(311, 107, 462, 20);
		jpbusquedaparametrica.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(311, 142, 271, 20);
		jpbusquedaparametrica.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(311, 181, 462, 20);
		jpbusquedaparametrica.add(textField_3);
		
		JRadioButton rdbtnIBM = new JRadioButton("IBM");
		rdbtnIBM.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnIBM.setBounds(365, 46, 121, 24);
		jpbusquedaparametrica.add(rdbtnIBM);
		
		JTextArea textAreaLogs = new JTextArea();
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
		
		JTextArea textAreaError = new JTextArea();
		textAreaError.setBounds(89, 543, 1000, 194);
//		jpbusquedaparametrica.add(textAreaError);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnBuscar.setBounds(537, 777, 100, 23);
		jpbusquedaparametrica.add(btnBuscar);
		
		JLabel lblDirectorio = new JLabel("Directorio:");
		lblDirectorio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDirectorio.setBounds(89, 219, 121, 14);
		jpbusquedaparametrica.add(lblDirectorio);
		
		JButton btnBuscar_1 = new JButton("...");
		btnBuscar_1.setFont(new Font("Dialog", Font.BOLD, 18));
		btnBuscar_1.setBounds(801, 219, 64, 23);
		jpbusquedaparametrica.add(btnBuscar_1);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(311, 222, 462, 20);
		jpbusquedaparametrica.add(textField_4);
		
        JScrollPane standardScrollPaneLogs = new JScrollPane(textAreaLogs,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        standardScrollPaneLogs.setBounds(89, 300, 1000, 194);
		jpbusquedaparametrica.add(standardScrollPaneLogs);
		
        JScrollPane standardScrollPaneEror = new JScrollPane(textAreaError,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        standardScrollPaneEror.setBounds(89, 543, 1000, 194);
		jpbusquedaparametrica.add(standardScrollPaneEror);
		
		JRadioButton rdbtnTcs = new JRadioButton("TCS");
		rdbtnTcs.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnTcs.setBounds(548, 46, 121, 24);
		jpbusquedaparametrica.add(rdbtnTcs);
		
		ButtonGroup grupoButtonFabrica = new ButtonGroup();
		grupoButtonFabrica.add(rdbtnTcs);
		grupoButtonFabrica.add(rdbtnIBM);
*/
		/*********************************************/
/*		JPanel jpconexion_1 = new Imagenes();
		tabbedPane.addTab("conexion", null, jpconexion_1, null);

		jpconexion_1.setLayout(null);
		JLabel lblUser = new JLabel("User: ");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(651, 391, 80, 14);
		jpconexion_1.add(lblUser);

		textUser = new JTextField();
		textUser.setBounds(743, 389, 163, 20);
		jpconexion_1.add(textUser);
		textUser.setColumns(10);

		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConectar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnConectar.setBounds(794, 590, 100, 23);
		jpconexion_1.add(btnConectar);

		JLabel lblConexionSsh = new JLabel("Conexi\u00F3n SSH");
		lblConexionSsh.setFont(new Font("Dialog", Font.BOLD, 18));
		lblConexionSsh.setBounds(824, 217, 137, 20);
		jpconexion_1.add(lblConexionSsh);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(651, 436, 80, 14);
		jpconexion_1.add(lblPassword);

		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(743, 434, 163, 20);
		jpconexion_1.add(textPassword);

		JLabel lblHost = new JLabel("Host:");
		lblHost.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHost.setBounds(651, 483, 80, 14);
		jpconexion_1.add(lblHost);

		textHost = new JTextField();
		textHost.setColumns(10);
		textHost.setBounds(743, 481, 163, 20);
		jpconexion_1.add(textHost);

		textMostrarUser = new JTextField();
		textMostrarUser.setEditable(false);
		textMostrarUser.setColumns(10);
		textMostrarUser.setBounds(949, 389, 163, 20);
		jpconexion_1.add(textMostrarUser);

		textMostrarPassword = new JTextField();
		textMostrarPassword.setEditable(false);
		textMostrarPassword.setColumns(10);
		textMostrarPassword.setBounds(949, 434, 163, 20);
		jpconexion_1.add(textMostrarPassword);

		textMostrarHost = new JTextField();
		textMostrarHost.setEditable(false);
		textMostrarHost.setColumns(10);
		textMostrarHost.setBounds(949, 481, 163, 20);
		jpconexion_1.add(textMostrarHost);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPort.setBounds(651, 529, 80, 14);
		jpconexion_1.add(lblPort);

		textPort = new JTextField();
		textPort.setColumns(10);
		textPort.setBounds(743, 527, 163, 20);
		jpconexion_1.add(textPort);

		textMostrarPort = new JTextField();
		textMostrarPort.setEditable(false);
		textMostrarPort.setColumns(10);
		textMostrarPort.setBounds(949, 527, 163, 20);
		jpconexion_1.add(textMostrarPort);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnModificar.setBounds(947, 590, 100, 23);
		jpconexion_1.add(btnModificar);

		JRadioButton rdbtnDesarrollo = new JRadioButton("Desarrollo");
		rdbtnDesarrollo.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnDesarrollo.setBounds(666, 289, 121, 24);
		jpconexion_1.add(rdbtnDesarrollo);

		JRadioButton rdbtnLaboratorio = new JRadioButton("Laboratorio");
		rdbtnLaboratorio.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnLaboratorio.setBounds(827, 289, 121, 24);
		jpconexion_1.add(rdbtnLaboratorio);

		JRadioButton rdbtnProduccion = new JRadioButton("Producción");
		rdbtnProduccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnProduccion.setBounds(983, 289, 121, 24);
		jpconexion_1.add(rdbtnProduccion);

		ButtonGroup grupoButton = new ButtonGroup();
		grupoButton.add(rdbtnProduccion);
		grupoButton.add(rdbtnLaboratorio);
		grupoButton.add(rdbtnDesarrollo);
*/		/*********************************************/
	}

	public void conexion() {

//		btnNewButton.addActionListener(this);

//		jpconexion.setPreferredSize(new Dimension( 690, 450));
	}
}
