package com.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class JPBusqueda extends JPanel implements ActionListener {
	
	private JTextField textField_1;
 
	private static final long serialVersionUID = -5704905176070654585L;

	public  JPBusqueda (JTabbedPane tabbedPane) {
		
		JPanel jpbusquedarapida = new JPanel();
		tabbedPane.addTab("Busqueda", null, jpbusquedarapida, null);
		jpbusquedarapida.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(289, 100, 86, 20);
		jpbusquedarapida.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Recepcion");
		lblNewLabel_1.setBounds(176, 103, 69, 14);
		jpbusquedarapida.add(lblNewLabel_1);
	}
	
	public  void recibirpanelbusqueda (String dato) {
		System.out.println("llego al panel bisqueda dato: "+dato);
		
		
//		JPanel jpbusquedarapida = new JPanel();
//		InicioBuscarLogs.tabbedPane.addTab("Busqueda", null, jpbusquedarapida, null);
//		jpbusquedarapida.setLayout(null);
//		
//		textField_1 = new JTextField();
//		textField_1.setBounds(289, 100, 86, 20);
//		jpbusquedarapida.add(textField_1);
//		textField_1.setColumns(10);
//		
//		JLabel lblNewLabel_1 = new JLabel("Recepcion");
//		lblNewLabel_1.setBounds(176, 103, 69, 14);
//		jpbusquedarapida.add(lblNewLabel_1);
//		jpbusquedarapida.revalidate();
		
		textField_1.setText(dato);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
