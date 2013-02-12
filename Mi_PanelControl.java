
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.FocusListener;
import java.util.EventListener;
import java.awt.event.FocusEvent;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class Mi_PanelControl extends JToolBar implements ActionListener, FocusListener
{
	private static JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
	
	// private JButton añadir;
	PanelDibujo dibuja;
	private AdministradorVentanas admi = new AdministradorVentanas(1);
	private static boolean accionP = false, accionS = false, accionB = false;
	
	private static boolean estadoR = false, estadoB = false, estadoN = false;
	private static boolean estadoC = false, estadoSC = false;
	
	public Mi_PanelControl()
	{
		//setLayout(new GridLayout(12,1)); // 8/09/2003
		super(JToolBar.VERTICAL);
		setFloatable(false);
		dibuja = new PanelDibujo(1);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		crearBotones();
		colocandoEventosDeTeclado();
	}

	public void crearBotones()
	{
		//super(new Dimension(100,40));

		//b1 = new JButton(new ImageIcon("imagenes/music_fullnote.png"));
		b1 = new JButton(new ImageIcon("imagenes/azul/redonda.gif"));
		b1.setToolTipText("redonda");
		b1.setPressedIcon ( new ImageIcon("imagenes/azul/redonda2.gif"));
		b1.addActionListener(this);
		//b1.addMouseListener(this);

		//b2 = new JButton(new ImageIcon("imagenes/music_halfnote.png"));
		b2 = new JButton(new ImageIcon("imagenes/azul/blanca.gif"));
		b2.setToolTipText("blanca");
		b2.setPressedIcon ( new ImageIcon("imagenes/azul/blanca2.gif"));
		b2.addActionListener(this);

		//b3 = new JButton(new ImageIcon("imagenes/music_quarternote.png"));
		b3 = new JButton(new ImageIcon("imagenes/azul/negra.gif"));
		b3.setToolTipText("negra");
		b3.setPressedIcon ( new ImageIcon("imagenes/azul/negra2.gif"));
		b3.addActionListener(this);

		//b4 = new JButton(new ImageIcon("imagenes/music_eightnote.png"));
		b4 = new JButton(new ImageIcon("imagenes/azul/corchea.gif"));
		b4.setToolTipText("corchea");
		b4.setPressedIcon ( new ImageIcon("imagenes/azul/corchea2.gif"));
		b4.addActionListener(this);
		
		//b5 = new JButton(new ImageIcon("imagenes/music_sixteenthnote.png"));
		b5 = new JButton(new ImageIcon("imagenes/azul/semiCorchea.gif"));
		b5.setToolTipText("semi-corchea");
		b5.setPressedIcon ( new ImageIcon("imagenes/azul/semiCorchea2.gif"));
		b5.addActionListener(this);
		
		b6 = new JButton(new ImageIcon("imagenes/azul/silencioR.gif"));//"imagenes/music_dottednote.png"));
		b6.setToolTipText ("silencio redonda");
		b6.setPressedIcon( new ImageIcon("imagenes/azul/silencioR2.gif") );
		b6.addActionListener(this);
		
		b7 = new JButton(new ImageIcon("imagenes/azul/silencioB.gif"));
		b7.setToolTipText("silencio blanca");
		b7.setPressedIcon(new ImageIcon("imagenes/azul/silencioB2.gif"));
		b7.addActionListener(this);
		
		b8 = new JButton(new ImageIcon("imagenes/azul/silencioN.gif"));
		b8.setToolTipText("silencio negra");
		b8.setPressedIcon(new ImageIcon("imagenes/azul/silencioN2.gif"));
		b8.addActionListener(this);
		
		b9 = new JButton(new ImageIcon("imagenes/azul/silencioC.gif"));
		b9.setToolTipText("silencio corchea");
		b9.setPressedIcon(new ImageIcon("imagenes/azul/silencioC2.gif"));
		b9.addActionListener(this);
		
		b10 = new JButton(new ImageIcon("imagenes/azul/silencioSC.gif"));
		b10.setToolTipText("silencio semi-corchea");
		b10.setPressedIcon(new ImageIcon("imagenes/azul/silencioSC2.gif"));
		b10.addActionListener(this);
		
		b11 = new JButton(new ImageIcon("imagenes/azul/punto.gif"));
		b11.setToolTipText("puntillo");
		b11.setPressedIcon(new ImageIcon("imagenes/azul/punto2.gif"));
		b11.addActionListener(this);
		
		b12 = new JButton(new ImageIcon("imagenes/azul/sostenido.gif"));
		b12.setToolTipText("sostenido");
		b12.setPressedIcon(new ImageIcon("imagenes/azul/sostenido2.gif"));
		b12.addActionListener(this);
		
		b13 = new JButton(new ImageIcon("imagenes/azul/bemol.gif"));
		b13.setToolTipText("bemol");
		b13.setPressedIcon(new ImageIcon("imagenes/azul/bemol2.gif"));
		b13.addActionListener (this);
		
		b1.setFocusable (true);
		b2.setFocusable (true);
		b3.setFocusable (true);
		b4.setFocusable (true);
		b5.setFocusable (true);
		b6.setFocusable (true);
		b7.setFocusable (true);
		b8.setFocusable (true);
		b9.setFocusable (true);
		b10.setFocusable (true);
		b11.setFocusable (true);
		b12.setFocusable (true);
		b13.setFocusable (true);
		/*
		b1.addFocusListener (this);
		b2.addFocusListener (this);
		b3.addFocusListener (this);
		b4.addFocusListener (this);
		b5.addFocusListener (this);
		b6.addFocusListener (this);
		b7.addFocusListener (this);
		b8.addFocusListener (this);
		b9.addFocusListener (this);
		b10.addFocusListener (this);
		b11.addFocusListener (this);
		b12.addFocusListener (this);
		*/
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(b10);
		add(b11);
		add(b12);
		add(b13);
		/*
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(b10);
		add(b11);
		add(b12);
		//add(b13);
		//add(b14);
		//add(b15);
		*/
	}
	
	public JButton getBotonRedonda()
	{
		return b1;
	}
	
	public JButton getBotonBlanca()
	{
		return b2;
	}
	
	public JButton getBotonNegra()
	{
		return b3;
	}
	
	public JButton getBotonCorchea()
	{
		return b4;
	}
	
	public JButton getBotonSCorchea()
	{
		return b5;
	}
	
	public JButton getBotonSilencioRedonda()
	{
		return b6;
	}
	
	public JButton getBotonSilencioBlanca()
	{
		return b7;
	}
	
	public JButton getBotonSilencioNegra()
	{
		return b8;
	}
	
	public JButton getBotonSilencioCorchea()
	{
		return b9;
	}
	
	public JButton getBotonSilencioSemiCorchea()
	{
		return b10;
	}
	
	public void colocandoEventosDeTeclado()
	{
		try
		{
			b1.setMnemonic (KeyEvent.VK_0);
			b2.setMnemonic (KeyEvent.VK_1);
			b3.setMnemonic (KeyEvent.VK_2);
			b4.setMnemonic (KeyEvent.VK_3);
			b5.setMnemonic (KeyEvent.VK_4);
			b6.setMnemonic (KeyEvent.VK_5);
			b7.setMnemonic (KeyEvent.VK_6);
			b8.setMnemonic (KeyEvent.VK_7);
			b9.setMnemonic (KeyEvent.VK_8);
			b10.setMnemonic (KeyEvent.VK_9);
			
			b11.setMnemonic (KeyEvent.VK_P);
			b12.setMnemonic (KeyEvent.VK_S);
			b13.setMnemonic (KeyEvent.VK_B);
		}
		catch ( Exception e )
		{
			String dialogo = "Error en los eventos de teclado \n"+e;
			JOptionPane.showMessageDialog (this,dialogo,"Error de teclado notas",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		Object o = e.getSource();
		try 
		{
			if(o == b1)
			{
				//dibuja.setImagen("imagenes/music_fullnote.png");
				admi.setFigura(this,"redonda");
				//setImagen("imagenes/music_fullnote.png");
				dibuja.setImagen(1);
				setAccion(o);
			}

			if(o == b2)
			{
				dibuja.setImagen(2);
				admi.setFigura(this,"blanca");
				setAccion(o);
			}
	
			if(o == b3)
			{
				dibuja.setImagen(3);
				admi.setFigura(this,"negra");
				setAccion(o);
			}

			if(o == b4)
			{
				dibuja.setImagen(4);
				admi.setFigura(this,"corchea");
				setAccion(o);
			}

			if(o == b5)
			{
				dibuja.setImagen(5);
				admi.setFigura(this,"semiCorchea");
				setAccion(o);
			}
	
			if(o == b6)
			{
				dibuja.setImagen(6);
				admi.setFigura(this,"silencioRedonda");
				setAccion(o);
			}

			if(o == b7)
			{
				dibuja.setImagen(7);
				admi.setFigura(this,"silencioBlanca");
				setAccion(o);
			}
			
			if(o == b8)
			{
				dibuja.setImagen(8);
				admi.setFigura(this,"silencioNegra");
				setAccion(o);
			}
		
			if(o == b9)
			{
				dibuja.setImagen(9);
				admi.setFigura(this,"silencioCorchea");
				setAccion(o);
			}
	
			if(o == b10)
			{
				dibuja.setImagen(10);
				admi.setFigura(this,"silencioSemiCorchea");
				setAccion(o);
			}
	
			if(o == b11)
			{
				//dibuja.setImagen(11);
				setAccion(o);
			}
	
			if(o == b12)
			{
				setAccion(o);
				//dibuja.setImagen(12);
			}
			
			if ( o == b13 )
			{
				setAccion(o);
			}
		}
		catch(Exception p)
		{
			String dialogo = "Error en los eventos de los botones \n"+p;
			JOptionPane.showMessageDialog (this,dialogo,"Error de botones de notas",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void focusGained (FocusEvent e)
	{
		Object o = e.getSource ();
		
		if ( o == b1 )
		{
			b1.setIcon (new ImageIcon("imagenes/azul/redonda3.gif"));
		}
		
		if ( o == b2 )
		{
			b2.setIcon (new ImageIcon("imagenes/azul/blanca3.gif"));
		}
		
		if ( o == b3 )
		{
			b3.setIcon (new ImageIcon("imagenes/azul/negra3.gif"));
		}
		
		if ( o == b4 )
		{
			b4.setIcon (new ImageIcon("imagenes/azul/corchea3.gif"));
		}
		
		if ( o == b5 )
		{
			b5.setIcon (new ImageIcon("imagenes/azul/semiCorchea3.gif"));
		}
	}

	public void focusLost (FocusEvent e)
	{
		Object o = e.getSource ();
		
		if ( o == b1 )
		{
			b1.setIcon (new ImageIcon("imagenes/azul/redonda.gif"));
		}
		
		if ( o == b2 )
		{
			b2.setIcon (new ImageIcon("imagenes/azul/blanca.gif"));
		}
		
		if ( o == b3 )
		{
			b3.setIcon (new ImageIcon("imagenes/azul/negra.gif"));
		}
		
		if ( o == b4 )
		{
			b4.setIcon (new ImageIcon("imagenes/azul/corchea.gif"));
		}
		
		if ( o == b5 )
		{
			b5.setIcon (new ImageIcon("imagenes/azul/semiCorchea.gif"));
		}
	}
	
	public boolean getAccionPunto()
	{
		return accionP;
	}
	
	public boolean getAccionSostenido()
	{
		return accionS;
	}
	
	public boolean getAccionBemol()
	{
		return accionB;
	}
	
	public boolean getAccionRedonda()
	{
		return estadoR;
	}
	
	public boolean getAccionBlanca()
	{
		return estadoB;
	}
	
	public boolean getAccionNegra()
	{
		return estadoN;
	}
	
	public boolean getAccionCorchea()
	{
		return estadoC;
	}
	
	public boolean getAccionSemiCorchea()
	{
		return estadoSC;
	}
	
	public void setAccion( Object o )
	{
		if ( o == b1 )
		{
			b1.setIcon(new ImageIcon("imagenes/azul/redonda2.gif"));
			b2.setIcon(new ImageIcon("imagenes/azul/blanca.gif"));
			b3.setIcon(new ImageIcon("imagenes/azul/negra.gif"));
			b4.setIcon(new ImageIcon("imagenes/azul/corchea.gif"));
			b5.setIcon(new ImageIcon("imagenes/azul/semiCorchea.gif"));
			b6.setIcon(new ImageIcon("imagenes/azul/silencioR.gif"));
			b7.setIcon(new ImageIcon("imagenes/azul/silencioB.gif"));
			b8.setIcon(new ImageIcon("imagenes/azul/silencioN.gif"));
			b9.setIcon(new ImageIcon("imagenes/azul/silencioC.gif"));
			b10.setIcon(new ImageIcon("imagenes/azul/silencioSC.gif"));
			
			estadoR = true;
			estadoB = false;
			estadoN = false;
			estadoC = false;
			estadoSC = false;
		}
		
		if ( o == b2 )
		{
			b1.setIcon(new ImageIcon("imagenes/azul/redonda.gif"));
			b2.setIcon(new ImageIcon("imagenes/azul/blanca2.gif"));
			b3.setIcon(new ImageIcon("imagenes/azul/negra.gif"));
			b4.setIcon(new ImageIcon("imagenes/azul/corchea.gif"));
			b5.setIcon(new ImageIcon("imagenes/azul/semiCorchea.gif"));
			b6.setIcon(new ImageIcon("imagenes/azul/silencioR.gif"));
			b7.setIcon(new ImageIcon("imagenes/azul/silencioB.gif"));
			b8.setIcon(new ImageIcon("imagenes/azul/silencioN.gif"));
			b9.setIcon(new ImageIcon("imagenes/azul/silencioC.gif"));
			b10.setIcon(new ImageIcon("imagenes/azul/silencioSC.gif"));
			
			estadoR = false;
			estadoB = true;
			estadoN = false;
			estadoC = false;
			estadoSC = false;
		}
		
		if ( o == b3 )
		{
			b1.setIcon(new ImageIcon("imagenes/azul/redonda.gif"));
			b2.setIcon(new ImageIcon("imagenes/azul/blanca.gif"));
			b3.setIcon(new ImageIcon("imagenes/azul/negra2.gif"));
			b4.setIcon(new ImageIcon("imagenes/azul/corchea.gif"));
			b5.setIcon(new ImageIcon("imagenes/azul/semiCorchea.gif"));
			b6.setIcon(new ImageIcon("imagenes/azul/silencioR.gif"));
			b7.setIcon(new ImageIcon("imagenes/azul/silencioB.gif"));
			b8.setIcon(new ImageIcon("imagenes/azul/silencioN.gif"));
			b9.setIcon(new ImageIcon("imagenes/azul/silencioC.gif"));
			b10.setIcon(new ImageIcon("imagenes/azul/silencioSC.gif"));
			
			estadoR = false;
			estadoB = false;
			estadoN = true;
			estadoC = false;
			estadoSC = false;
		}
		
		if ( o == b4 )
		{
			b1.setIcon(new ImageIcon("imagenes/azul/redonda.gif"));
			b2.setIcon(new ImageIcon("imagenes/azul/blanca.gif"));
			b3.setIcon(new ImageIcon("imagenes/azul/negra.gif"));
			b4.setIcon(new ImageIcon("imagenes/azul/corchea2.gif"));
			b5.setIcon(new ImageIcon("imagenes/azul/semiCorchea.gif"));
			b6.setIcon(new ImageIcon("imagenes/azul/silencioR.gif"));
			b7.setIcon(new ImageIcon("imagenes/azul/silencioB.gif"));
			b8.setIcon(new ImageIcon("imagenes/azul/silencioN.gif"));
			b9.setIcon(new ImageIcon("imagenes/azul/silencioC.gif"));
			b10.setIcon(new ImageIcon("imagenes/azul/silencioSC.gif"));
			
			estadoR = false;
			estadoB = false;
			estadoN = false;
			estadoC = true;
			estadoSC = false;
		}
		
		if ( o == b5 )
		{
			b1.setIcon(new ImageIcon("imagenes/azul/redonda.gif"));
			b2.setIcon(new ImageIcon("imagenes/azul/blanca.gif"));
			b3.setIcon(new ImageIcon("imagenes/azul/negra.gif"));
			b4.setIcon(new ImageIcon("imagenes/azul/corchea.gif"));
			b5.setIcon(new ImageIcon("imagenes/azul/semiCorchea2.gif"));
			b6.setIcon(new ImageIcon("imagenes/azul/silencioR.gif"));
			b7.setIcon(new ImageIcon("imagenes/azul/silencioB.gif"));
			b8.setIcon(new ImageIcon("imagenes/azul/silencioN.gif"));
			b9.setIcon(new ImageIcon("imagenes/azul/silencioC.gif"));
			b10.setIcon(new ImageIcon("imagenes/azul/silencioSC.gif"));
			
			estadoR = false;
			estadoB = false;
			estadoN = false;
			estadoC = false;
			estadoSC = true;
		}
		
		if ( o == b6 )
		{
			b1.setIcon(new ImageIcon("imagenes/azul/redonda.gif"));
			b2.setIcon(new ImageIcon("imagenes/azul/blanca.gif"));
			b3.setIcon(new ImageIcon("imagenes/azul/negra.gif"));
			b4.setIcon(new ImageIcon("imagenes/azul/corchea.gif"));
			b5.setIcon(new ImageIcon("imagenes/azul/semiCorchea.gif"));
			b6.setIcon(new ImageIcon("imagenes/azul/silencioR2.gif"));
			b7.setIcon(new ImageIcon("imagenes/azul/silencioB.gif"));
			b8.setIcon(new ImageIcon("imagenes/azul/silencioN.gif"));
			b9.setIcon(new ImageIcon("imagenes/azul/silencioC.gif"));
			b10.setIcon(new ImageIcon("imagenes/azul/silencioSC.gif"));
			
			estadoR = false;
			estadoB = false;
			estadoN = false;
			estadoC = false;
			estadoSC = false;
			
			accionP = false;
			accionS = false;
			accionB = false;
			
			b11.setIcon(new ImageIcon("imagenes/azul/punto.gif"));
			b12.setIcon(new ImageIcon("imagenes/azul/sostenido.gif"));
			b13.setIcon(new ImageIcon("imagenes/azul/bemol.gif"));
		}
		
		if ( o == b7 )
		{
			b1.setIcon(new ImageIcon("imagenes/azul/redonda.gif"));
			b2.setIcon(new ImageIcon("imagenes/azul/blanca.gif"));
			b3.setIcon(new ImageIcon("imagenes/azul/negra.gif"));
			b4.setIcon(new ImageIcon("imagenes/azul/corchea.gif"));
			b5.setIcon(new ImageIcon("imagenes/azul/semiCorchea.gif"));
			b6.setIcon(new ImageIcon("imagenes/azul/silencioR.gif"));
			b7.setIcon(new ImageIcon("imagenes/azul/silencioB2.gif"));
			b8.setIcon(new ImageIcon("imagenes/azul/silencioN.gif"));
			b9.setIcon(new ImageIcon("imagenes/azul/silencioC.gif"));
			b10.setIcon(new ImageIcon("imagenes/azul/silencioSC.gif"));
			
			estadoR = false;
			estadoB = false;
			estadoN = false;
			estadoC = false;
			estadoSC = false;
			
			accionP = false;
			accionS = false;
			accionB = false;
			
			b11.setIcon(new ImageIcon("imagenes/azul/punto.gif"));
			b12.setIcon(new ImageIcon("imagenes/azul/sostenido.gif"));
			b13.setIcon(new ImageIcon("imagenes/azul/bemol.gif"));
		}
		
		if ( o == b8 )
		{
			b1.setIcon(new ImageIcon("imagenes/azul/redonda.gif"));
			b2.setIcon(new ImageIcon("imagenes/azul/blanca.gif"));
			b3.setIcon(new ImageIcon("imagenes/azul/negra.gif"));
			b4.setIcon(new ImageIcon("imagenes/azul/corchea.gif"));
			b5.setIcon(new ImageIcon("imagenes/azul/semiCorchea.gif"));
			b6.setIcon(new ImageIcon("imagenes/azul/silencioR.gif"));
			b7.setIcon(new ImageIcon("imagenes/azul/silencioB.gif"));
			b8.setIcon(new ImageIcon("imagenes/azul/silencioN2.gif"));
			b9.setIcon(new ImageIcon("imagenes/azul/silencioC.gif"));
			b10.setIcon(new ImageIcon("imagenes/azul/silencioSC.gif"));
			
			estadoR = false;
			estadoB = false;
			estadoN = false;
			estadoC = false;
			estadoSC = false;
			
			accionP = false;
			accionS = false;
			accionB = false;
			
			b11.setIcon(new ImageIcon("imagenes/azul/punto.gif"));
			b12.setIcon(new ImageIcon("imagenes/azul/sostenido.gif"));
			b13.setIcon(new ImageIcon("imagenes/azul/bemol.gif"));
		}
		
		if ( o == b9 )
		{
			b1.setIcon(new ImageIcon("imagenes/azul/redonda.gif"));
			b2.setIcon(new ImageIcon("imagenes/azul/blanca.gif"));
			b3.setIcon(new ImageIcon("imagenes/azul/negra.gif"));
			b4.setIcon(new ImageIcon("imagenes/azul/corchea.gif"));
			b5.setIcon(new ImageIcon("imagenes/azul/semiCorchea.gif"));
			b6.setIcon(new ImageIcon("imagenes/azul/silencioR.gif"));
			b7.setIcon(new ImageIcon("imagenes/azul/silencioB.gif"));
			b8.setIcon(new ImageIcon("imagenes/azul/silencioN.gif"));
			b9.setIcon(new ImageIcon("imagenes/azul/silencioC2.gif"));
			b10.setIcon(new ImageIcon("imagenes/azul/silencioSC.gif"));
			
			estadoR = false;
			estadoB = false;
			estadoN = false;
			estadoC = false;
			estadoSC = false;
			
			accionP = false;
			accionS = false;
			accionB = false;
			
			b11.setIcon(new ImageIcon("imagenes/azul/punto.gif"));
			b12.setIcon(new ImageIcon("imagenes/azul/sostenido.gif"));
			b13.setIcon(new ImageIcon("imagenes/azul/bemol.gif"));
		}
		
		if ( o == b10 )
		{
			b1.setIcon(new ImageIcon("imagenes/azul/redonda.gif"));
			b2.setIcon(new ImageIcon("imagenes/azul/blanca.gif"));
			b3.setIcon(new ImageIcon("imagenes/azul/negra.gif"));
			b4.setIcon(new ImageIcon("imagenes/azul/corchea.gif"));
			b5.setIcon(new ImageIcon("imagenes/azul/semiCorchea.gif"));
			b6.setIcon(new ImageIcon("imagenes/azul/silencioR.gif"));
			b7.setIcon(new ImageIcon("imagenes/azul/silencioB.gif"));
			b8.setIcon(new ImageIcon("imagenes/azul/silencioN.gif"));
			b9.setIcon(new ImageIcon("imagenes/azul/silencioC.gif"));
			b10.setIcon(new ImageIcon("imagenes/azul/silencioSC2.gif"));
			
			estadoR = false;
			estadoB = false;
			estadoN = false;
			estadoC = false;
			estadoSC = false;
			
			accionP = false;
			accionS = false;
			accionB = false;
			
			b11.setIcon(new ImageIcon("imagenes/azul/punto.gif"));
			b12.setIcon(new ImageIcon("imagenes/azul/sostenido.gif"));
			b13.setIcon(new ImageIcon("imagenes/azul/bemol.gif"));
		}
		
		if ( o == b11 )
		{
			if ( !accionP )
			{
				if ( estadoR || estadoB || estadoN || estadoC || estadoSC )
				{
					accionP = true;
					b11.setIcon(new ImageIcon("imagenes/azul/punto2.gif"));
					accionS = false;
					accionB = false;
					b12.setIcon(new ImageIcon("imagenes/azul/sostenido.gif"));
					b13.setIcon(new ImageIcon("imagenes/azul/bemol.gif"));
					admi.setFigura(this,"entrada");
				}
				else
				{
					llamadaDeError();
				}
			}
			else
			{
				accionP = false;
				b11.setIcon(new ImageIcon("imagenes/azul/punto.gif"));
				admi.setFigura(this,"cambio");
			}
		}
		
		if ( o == b12 )
		{
			if ( !accionS )
			{
				if ( estadoR || estadoB || estadoN || estadoC || estadoSC )
				{
					accionS = true;
					b12.setIcon(new ImageIcon("imagenes/azul/sostenido2.gif"));
					accionP = false;
					accionB = false;
					b11.setIcon(new ImageIcon("imagenes/azul/punto.gif"));
					b13.setIcon(new ImageIcon("imagenes/azul/bemol.gif"));
					admi.setFigura(this,"entrada");
				}
				else
				{
					llamadaDeError();
				}
			}
			else
			{
				accionS = false;
				b12.setIcon(new ImageIcon("imagenes/azul/sostenido.gif"));
				admi.setFigura(this,"cambio");
			}
		}
		
		if ( o == b13 )
		{
			if ( !accionB )
			{
				if ( estadoR || estadoB || estadoN || estadoC || estadoSC )
				{
					accionB = true;
					b13.setIcon(new ImageIcon("imagenes/azul/bemol2.gif"));
					accionP = false;
					accionS = false;
					b11.setIcon(new ImageIcon("imagenes/azul/punto.gif"));
					b12.setIcon(new ImageIcon("imagenes/azul/sostenido.gif"));
					admi.setFigura(this,"entrada");
				}
				else
				{
					llamadaDeError();
				}
			}
			else
			{
				accionB = false;
				b13.setIcon(new ImageIcon("imagenes/azul/bemol.gif"));
				admi.setFigura(this,"cambio");
			}
		}
	}
	
	public void llamadaDeError()
	{
		String dialogo = "Usted debe primero seleccionar una figura \n puede ser Redonda, Blanca, Negra, Corchea \n o Semi-Corchea";
		JOptionPane.showMessageDialog (this,dialogo,"Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public static void retorna()
	{
		b1.setIcon(new ImageIcon("imagenes/azul/redonda.gif"));
		b2.setIcon(new ImageIcon("imagenes/azul/blanca.gif"));
		b3.setIcon(new ImageIcon("imagenes/azul/negra.gif"));
		b4.setIcon(new ImageIcon("imagenes/azul/corchea.gif"));
		b5.setIcon(new ImageIcon("imagenes/azul/semiCorchea.gif"));
		b6.setIcon(new ImageIcon("imagenes/azul/silencioR.gif"));
		b7.setIcon(new ImageIcon("imagenes/azul/silencioB.gif"));
		b8.setIcon(new ImageIcon("imagenes/azul/silencioN.gif"));
		b9.setIcon(new ImageIcon("imagenes/azul/silencioC.gif"));
		b10.setIcon(new ImageIcon("imagenes/azul/silencioSC.gif"));
		b11.setIcon(new ImageIcon("imagenes/azul/punto.gif"));
		b12.setIcon(new ImageIcon("imagenes/azul/sostenido.gif"));
		
		accionP = false;
		accionS = false;
		
		estadoR = false;
		estadoB = false;
		estadoN = false;
		estadoC = false;
		estadoSC = false;
	}
}
