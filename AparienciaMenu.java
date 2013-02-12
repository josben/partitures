/*
 * @(#)MetalThemeMenu.java	1.7 01/12/03
 *
 * Copyright 2002 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
 

import javax.swing.plaf.metal.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class describes a theme using "green" colors.
 *
 * @version 1.7 12/03/01
 * @author Steve Wilson
 */
public class AparienciaMenu extends JMenu implements ActionListener
{
	MetalTheme[] themes;
	String[] extras;
	String[] nom;
	private Font fondo;
	int tam;
	int j;
	
	public AparienciaMenu(String name, MetalTheme[] themeArray, String[] ex, String[] nombre)
	{
		super(name);
		themes = themeArray;
		fondo = new Font("serif", Font.PLAIN, 12);
		extras = ex;
		nom = nombre;
		tam = themes.length + extras.length;
		j = 0;
		
    	ButtonGroup group = new ButtonGroup();
    	for (int i = 0; i < tam; i++)
    	{
    		try
    		{
    			JRadioButtonMenuItem item = new JRadioButtonMenuItem( themes[i].getName() );
				item.setFont(fondo);
				group.add(item);
        		add( item );
				item.setActionCommand(i+"");
				item.addActionListener(this);
				if ( i == 0)
	    			item.setSelected(true);
	    	}
	    	catch( Exception e )
	    	{
	    		if ( j < 3 )
	    		{
	    			JRadioButtonMenuItem item = new JRadioButtonMenuItem( nom[j] );
	    			item.setFont(fondo);
	    			group.add(item);
	    			add( item );
	    			item.setActionCommand(nom[j]);
	    			item.addActionListener(this);
	    			j++;
	    		}
	    	}
    	}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String numStr = e.getActionCommand();
		try
		{
			MetalTheme selectedTheme = themes[ Integer.parseInt(numStr) ];
    		MetalLookAndFeel.setCurrentTheme(selectedTheme);
    		try
    		{
    			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    		}
    		catch (Exception ex)
    		{
    			System.out.println("Failed loading Metal");
				System.out.println(ex);
    		}
    	}
    	catch(Exception ex)
    	{
    		try
    		{
    			if ( e.getActionCommand().equalsIgnoreCase("motif") )
    			{
    				UIManager.setLookAndFeel(extras[0]);
    			}
    			if ( e.getActionCommand().equalsIgnoreCase("windows") )
    			{
    				UIManager.setLookAndFeel(extras[1]);
    			}
    		}
    		catch(Exception err)
    		{
    			System.err.println("Error = "+err);
    		}
    	}
	}
}
