
import javax.swing.plaf.metal.*;
import javax.swing.plaf.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class MetalMenu extends JMenu implements ActionListener
{
	String apariencia[];
	String nombres[];
	
	public MetalMenu(String nom, String[] ap, String[] nombre)
	{
		super(nom);
		apariencia = ap;
		nombres = nombre;
		
		ButtonGroup grupo = new ButtonGroup();
		
		if ( apariencia.length == nombres.length )
		{
			for ( int i = 0 ; i < apariencia.length ; i++ )
			{
				JRadioButtonMenuItem item = new JRadioButtonMenuItem(nombres[i]);
				grupo.add(item);
				add(item);
				item.setActionCommand(i+"");
				item.addActionListener(this);
				if ( item == 0 )
				{
					
				}
			}
		}
	}
}