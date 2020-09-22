package com.frame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import com.ProcesarProperties.LeerArchivoProperties;
import com.ProcesarProperties.PropertiesDao;
import com.procesarlogs.ParametrosLogsDAO;


public class JPConexion extends JPanel implements ActionListener {

	private JScrollPane jscrollPane = null;
	private JTextField textUser;
	public JButton btnConectar;
	private JTextField textPassword;
	private JTextField textHost;
	private JTextField textMostrarUser;
	private JTextField textMostrarPassword;
	private JTextField textMostrarHost;
	private JTextField textPort;
	private JTextField textMostrarPort;
	private JRadioButton rdbtnProduccion;
	private JRadioButton rdbtnLaboratorio; 
	private JRadioButton rdbtnDesarrollo ;
	private ButtonGroup grupoButton;
	private JButton btnModificar; 	
	private LeerArchivoProperties leer;
	private PropertiesDao propertiesDao ;
	private int tipoAmbiente=0;
	private ParametrosLogsDAO parametrosLogsDAO  =new ParametrosLogsDAO();

	private static final long serialVersionUID = 497736894875774303L;

	public JPConexion(JTabbedPane tabbedPane) {
		// System.out.println("llego:"+dato);
//		JPanel jpconexion = new JPanel();
    //		tabbedPane.addTab("conexion", null, jpconexion, null);
		
		JPanel jpconexion = new Imagenes();
//		tabbedPane.addTab("conexion", null, jpconexion, null);

		jpconexion.setLayout(null);
		JLabel lblUser = new JLabel("User: ");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(651, 391, 80, 14);
		jpconexion.add(lblUser);

		textUser = new JTextField();
		textUser.setBounds(743, 389, 163, 20);
		jpconexion.add(textUser);
		textUser.setColumns(10);

		btnConectar = new JButton("Conectar");
		btnConectar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnConectar.setBounds(794, 590, 100, 23);
		jpconexion.add(btnConectar);

		JLabel lblConexionSsh = new JLabel("Conexi\u00F3n SSH");
		lblConexionSsh.setFont(new Font("Dialog", Font.BOLD, 18));
		lblConexionSsh.setBounds(824, 217, 137, 20);
		jpconexion.add(lblConexionSsh);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(651, 436, 80, 14);
		jpconexion.add(lblPassword);

		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(743, 434, 163, 20);
		jpconexion.add(textPassword);

		JLabel lblHost = new JLabel("Host:");
		lblHost.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHost.setBounds(651, 483, 80, 14);
		jpconexion.add(lblHost);

		textHost = new JTextField();
		textHost.setColumns(10);
		textHost.setBounds(743, 481, 163, 20);
		jpconexion.add(textHost);

		textMostrarUser = new JTextField();
		textMostrarUser.setEditable(false);
		textMostrarUser.setColumns(10);
		textMostrarUser.setBounds(949, 389, 163, 20);
		jpconexion.add(textMostrarUser);

		textMostrarPassword = new JTextField();
		textMostrarPassword.setEditable(false);
		textMostrarPassword.setColumns(10);
		textMostrarPassword.setBounds(949, 434, 163, 20);
		jpconexion.add(textMostrarPassword);

		textMostrarHost = new JTextField();
		textMostrarHost.setEditable(false);
		textMostrarHost.setColumns(10);
		textMostrarHost.setBounds(949, 481, 163, 20);
		jpconexion.add(textMostrarHost);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPort.setBounds(651, 529, 80, 14);
		jpconexion.add(lblPort);

		textPort = new JTextField();
		textPort.setColumns(10);
		textPort.setBounds(743, 527, 163, 20);
		jpconexion.add(textPort);

		textMostrarPort = new JTextField();
		textMostrarPort.setEditable(false);
		textMostrarPort.setColumns(10);
		textMostrarPort.setBounds(949, 527, 163, 20);
		jpconexion.add(textMostrarPort);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnModificar.setBounds(947, 590, 100, 23);
		jpconexion.add(btnModificar);

		rdbtnDesarrollo = new JRadioButton("Desarrollo");
		rdbtnDesarrollo.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnDesarrollo.setBounds(666, 289, 121, 24);
		jpconexion.add(rdbtnDesarrollo);

		rdbtnLaboratorio = new JRadioButton("Laboratorio");
		rdbtnLaboratorio.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnLaboratorio.setBounds(827, 289, 121, 24);
		jpconexion.add(rdbtnLaboratorio);

		rdbtnProduccion = new JRadioButton("Producción");
		rdbtnProduccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnProduccion.setBounds(983, 289, 121, 24);
		jpconexion.add(rdbtnProduccion);

		grupoButton = new ButtonGroup();
		grupoButton.add(rdbtnProduccion);
		grupoButton.add(rdbtnLaboratorio);
		grupoButton.add(rdbtnDesarrollo);
		
		//1200, 897
		jpconexion.setPreferredSize(new Dimension( 1130, 615));
		
		jscrollPane = new JScrollPane();
	    jscrollPane.setBounds(5,10, 1130, 615);
	    jscrollPane.setViewportView(jpconexion);
		tabbedPane.addTab("conexion", null, jscrollPane, null);
		
		
		rdbtnDesarrollo.addActionListener(this);
		rdbtnLaboratorio.addActionListener(this);
		rdbtnProduccion.addActionListener(this);
		btnModificar.addActionListener(this);
		btnConectar.addActionListener(this);
	
/*		jpconexion.setLayout(null);

		JLabel lblNewLabel = new JLabel("Dato a enviar");
		lblNewLabel.setBounds(140, 75, 80, 14);
		jpconexion.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(254, 72, 86, 20);
		jpconexion.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(266, 156, 89, 23);
		jpconexion.add(btnNewButton);
	btnNewButton.addActionListener(this);
*/			
//copiar hasta aca		
//		jpconexion.setPreferredSize(new Dimension( 690, 450));
		
//		jscrollPane = new JScrollPane();
//	    jscrollPane.setBounds(5,10, 690,450);
//	    jscrollPane.setViewportView(jpconexion);
//		tabbedPane.addTab("conexion", null, jscrollPane, null);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rdbtnDesarrollo)
			mostarDatosConexion(1);
		if (e.getSource() == rdbtnLaboratorio)
			mostarDatosConexion(2);
		if (e.getSource() == rdbtnProduccion)
			mostarDatosConexion(3);
		
		
		if (e.getSource() == btnModificar) {
			if(tipoAmbiente==0)
				Mensajes.mensajeError("Debe seleccionar un ambiente para modificar.");
			else {
				if(vatidaTextosVaciosConexion())
					Mensajes.mensajeError("Ingrese datos para modificar los datos de conexión.");
				else {
				modificardatosconexion();
				Mensajes.mensajeInformativo("Modificación exitosa.");
				}
			}
		}	
		
		if (e.getSource() == btnConectar) {
//			 InicioBuscarLogs.jpBusqueda.recibirAmbienteConexion(tipoAmbiente); 
			if(tipoAmbiente==0)
				Mensajes.mensajeError("Debe seleccionar un ambiente para conectarse.");
			else {
				if(conexionambiente(tipoAmbiente)) {
		        	  Mensajes.mensajeError("No se puedo establecer conexión");
//		        	  tipoAmbiente=0;
				} else {
		        	  Mensajes.mensajeInformativo("Conexión Exitosa");
		        	  InicioBuscarLogs.jpBusqueda.recibirAmbienteConexion(tipoAmbiente); 
		          }  
			}
				
		}

	}
	
//	ValidacionesFront validacion = new ValidacionesFront();
//	validacion.procesoespera(1);
//
//	
//	Mensajes.mensajeError("proceso terminado");
	
//	  JFileChooser guardar = new JFileChooser();
//	  guardar.showSaveDialog(null);
//    System.out.println("name: "+guardar.getSelectedFile());
//	
	
	
	
/*		  JFileChooser fileChooser = new JFileChooser();
	  fileChooser.setCurrentDirectory(new File("."));
	  fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	  fileChooser.setAcceptAllFileFilterUsed(false);
	  
	  if (fileChooser.showOpenDialog(null) ==JFileChooser.APPROVE_OPTION) { 
		  File  rutadestino = fileChooser.getCurrentDirectory();
	  System.out.println("nombre: "+rutadestino.separator);
	  System.out.println("nombre1: "+rutadestino.getAbsoluteFile());
	  System.out.println("rutadestino "+rutadestino); }
*/		  
	 
//	InicioBuscarLogs.jpBusqueda.recibirpanelbusqueda(textField.getText());  //enviar datos de una jpanel a otro
	
	public void mostarDatosConexion(int ambiente) {
		leer =new LeerArchivoProperties();
		propertiesDao = new PropertiesDao();
		propertiesDao =leer.getProperties();
		tipoAmbiente=ambiente;
		try {
			
			switch (ambiente) {
			case 1:  // desarrollo
				textMostrarUser.setText(propertiesDao.getUserDES());
				textMostrarHost.setText(propertiesDao.getIpDES());
				textMostrarPassword.setText(propertiesDao.getPassDES());
				textMostrarPort.setText(propertiesDao.getPortDES());
				break;
			case 2:   //Laboratorio
				textMostrarUser.setText(propertiesDao.getUserLAB());
				textMostrarHost.setText(propertiesDao.getIpLAB());
				textMostrarPassword.setText(propertiesDao.getPassLab());
				textMostrarPort.setText(propertiesDao.getPortLAB());				
				break;
			case 3:     // Produccion
				textMostrarUser.setText(propertiesDao.getUserPROD());
				textMostrarHost.setText(propertiesDao.getIpPROD());
				textMostrarPassword.setText(propertiesDao.getPassPROD());
				textMostrarPort.setText(propertiesDao.getPortPROD());		
				
				break;				

			default:
				break;
			}
			
		} catch (Exception e) {
			Mensajes.mensajeError("mostarDatosConexion: "+e.getMessage());
		}
	}
	
	public void modificardatosconexion() {
		try {
			
			switch (tipoAmbiente) {
			case 1:  // desarrollo
				if(textUser.getText() != null && !textUser.getText() .isEmpty()) {propertiesDao.setUserDES(textUser.getText());}
				if(textPassword.getText() != null && !textPassword.getText() .isEmpty()) {propertiesDao.setPassDES(textPassword.getText());}
				if(textHost.getText() != null && !textHost.getText() .isEmpty()) {propertiesDao.setIpDES(textHost.getText());}
				if(textPort.getText() != null && !textPort.getText() .isEmpty()) {propertiesDao.setPortDES(textPort.getText());}
				break;
			case 2:   //Laboratorio
				if(textUser.getText() != null && !textUser.getText() .isEmpty()) {propertiesDao.setUserLAB(textUser.getText());}
				if(textPassword.getText() != null && !textPassword.getText() .isEmpty()) {propertiesDao.setPassLab(textPassword.getText());}
				if(textHost.getText() != null && !textHost.getText() .isEmpty()) {propertiesDao.setIpLAB(textHost.getText());}
				if(textPort.getText() != null && !textPort.getText() .isEmpty()) {propertiesDao.setPortLAB(textPort.getText());}		
				break;
			case 3:     // Produccion
				if(textUser.getText() != null && !textUser.getText() .isEmpty()) {propertiesDao.setUserPROD(textUser.getText());}
				if(textPassword.getText() != null && !textPassword.getText() .isEmpty()) {propertiesDao.setPassPROD(textPassword.getText());}
				if(textHost.getText() != null && !textHost.getText() .isEmpty()) {propertiesDao.setIpPROD(textHost.getText());}
				if(textPort.getText() != null && !textPort.getText() .isEmpty()) {propertiesDao.setPortPROD(textPort.getText());}	
				
				break;	   
			}
			
			leer.setProperties(propertiesDao);
			mostarDatosConexion(tipoAmbiente);
			
		} catch (Exception e) {
			Mensajes.mensajeError("modificardatosconexion: "+e.getMessage());
		}
	}
	
	public boolean vatidaTextosVaciosConexion () { 
		boolean vacio =false;
		if((textUser.getText() == null || textUser.getText() .isEmpty()) &&
		   (textPassword.getText() == null || textPassword.getText() .isEmpty())	&&
		   (textHost.getText() == null || textHost.getText() .isEmpty()) &&
		   (textPort.getText() == null || textPort.getText() .isEmpty())) {
			vacio= true;
		}else		
			vacio= false;
		return vacio;
	}
	
	public boolean conexionambiente(int ambiente) {
		boolean validaconexionambiente=false;
		try {
          if(ValidacionesFront.procesoespera(2, ambiente,parametrosLogsDAO))
        	  validaconexionambiente=true;
        	  
		} catch (Exception e) {
			System.out.println("conexionambiente "+e.getMessage());
			Mensajes.mensajeError("conexionambiente: "+e.getMessage());
		}
		return validaconexionambiente;
	}
	
	
	public  boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
}
