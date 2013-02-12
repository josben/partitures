
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class Incio extends JPanel
{
	JRadioButton b1,b2;
	
	public Incio()
	{
		setSize(200,400);
		b1 = new JRadioButton("hola");
		
		b2 = new JRadioButton("chau");
		
		ButtonGroup grup = new ButtonGroup();
		grup.add(b1);
		grup.add(b2);
		
		add(b1);
		add(b2);
		setVisible(true);
	}
	
	public static void main(String arg[])
	{
		JFrame aux = new JFrame("Incio");
		
		Incio ini = new Incio();
		aux.getContentPane().add(ini);
		aux.show();
	}
}