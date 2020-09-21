package com.frame;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JPConexion extends JPanel implements ActionListener {

	private JTextField textField;
	private JButton btnNewButton;
	private FileDialog fileDialog = null;
	private JScrollPane jscrollPane = null;

	private static final long serialVersionUID = 497736894875774303L;

	public JPConexion(JTabbedPane tabbedPane) {
		// System.out.println("llego:"+dato);
		JPanel jpconexion = new JPanel();
//		tabbedPane.addTab("conexion", null, jpconexion, null);
	
		jpconexion.setLayout(null);

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
//copiar hasta aca		
		jpconexion.setPreferredSize(new Dimension( 690, 450));
		
		jscrollPane = new JScrollPane();
	    jscrollPane.setBounds(5,10, 690,450);
	    jscrollPane.setViewportView(jpconexion);
		tabbedPane.addTab("conexion", null, jscrollPane, null);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton)
			System.out.println("vamos bien");
		
		ValidacionesFront validacion = new ValidacionesFront();
		validacion.procesoespera(1);

		
		Mensajes.mensajeError("proceso terminado");

//		  JFileChooser guardar = new JFileChooser();
//		  guardar.showSaveDialog(null);
//          System.out.println("name: "+guardar.getSelectedFile());
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
		 
//		InicioBuscarLogs.jpBusqueda.recibirpanelbusqueda(textField.getText());

	}
	
}
