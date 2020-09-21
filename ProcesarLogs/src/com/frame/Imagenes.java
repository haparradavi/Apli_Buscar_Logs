package com.frame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Imagenes extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7887257653013351335L;
	
	private Image fondo=null;
	
    @Override
	public void paint(Graphics g){
    	fondo = new ImageIcon(getClass().getResource("/com/Images/imagenfondo.png")).getImage();
    	g.drawImage(fondo,0,0,getWidth(),getHeight(),null);
        setOpaque(false);
        super.paint (g);
    }
    
}
