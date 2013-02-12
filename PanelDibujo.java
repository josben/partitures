
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class PanelDibujo extends JPanel implements ControlPantalla
{
	Point point = null;
	Dimension preferredSize = new Dimension(300,100);
	final int largo = 200;
	int rectAncho = 50;
	int rectAlto = 50;
	static ImageIcon imagen;
	//Dibujable figuras[];
	private Lista lista;
	//Figura fig[];
	int cantidadFig;
	int entero;
	String cadena;
	boolean accion;
	private int oX,oY,dX,dY;
	private Entrada raton;
	
	private boolean entrada1 = false;
	private boolean entrada2 = false;
	private PentagramaAuxiliar aux1;
	private PentagramaAuxiliar2 aux2;
	
	private Indicador flecha = new Indicador(0,0);
	private boolean banderaPlay = false;
	
	public PanelDibujo(int fg)
	{
		entero = fg;
	}

	public PanelDibujo(int ox, int oy, int dx, int dy)
	{
		//Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		//Border loweredBevel = BorderFactory.createLoweredBevelBorder();
		//Border compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
		//setBorder(compound);
		
		setBackground(Color.white);
		//setToolTipText("Pentagrama musical");
		lista = new Lista();
		raton = new Entrada();
		//figuras = new Dibujable[100];
		//fig = new Figura[100];
		cantidadFig = 0;
		aux1 = new PentagramaAuxiliar(ox,oy,dx,dy);
		aux2 = new PentagramaAuxiliar2(ox,oy,dx,dy);

		// CROSSHAIR_CURSOR(puntero en cruz)
		// CUSTOM_CURSOR(no fuciona aun)
		// MOVE_CURSOR(cursor para mover pantalla)
		// HAND_CURSOR(una manito apuntando)
		// SE_RESIZE_CURSOR(flechita inclinada)
		// DEFAULT_CURSOR(no cambia nada)
		// E_RESIZE_CURSOR(flechita horizontal)
		// N_RESIZE_CURSOR(flechita vertical)
		// NE_RESIZE_CURSOR(flecha inclinada)
		// NW_RESIZE_CURSOR(flecha inclinada hacia el norte)
		// S_RESIZE_CURSOR(flecha vertical)
		// WAIT_CURSOR(cursor de espera)
		addMouseMotionListener(raton);
		
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	}

	public void cerrar()
	{
		setVisible(false);
		this.requestFocus(false);
	}

	public void abrir()
	{
		setVisible(true);
		this.requestFocus(true);
		this.repaint ();
	}

	public Dimension getPreferredSize()
	{
		return preferredSize;
	}
	
	public void setBanderaPlay(boolean estado)
	{
		banderaPlay = estado;
	}
	
	public boolean getBanderaPlay()
	{
		return banderaPlay;
	}
	
	public Indicador getIndicador()
	{
		return flecha;
	}
	
	public void setPosIndicador(int x, int y)
	{
		flecha.setX(x);
		flecha.setY(y);
	}

	public void setImagen(int op)
	{
		try
		{
			if ( op == 1 )
			{
				setCursor(MiCursor.getRedonda ());
			}

			if ( op == 2 )
			{
				setCursor(MiCursor.getBlanca ());
			}

			if ( op == 3 )
			{
				setCursor(MiCursor.getNegra ());
			}

			if ( op == 4 )
			{
				setCursor(MiCursor.getCorchea ());
			}

			if ( op == 5 )
			{
				setCursor(MiCursor.getSemiCorchea ());
			}
			
			if ( op == 6 )
			{
				setCursor(MiCursor.getSilencioRedonda ());
			}
			
			if ( op == 7 )
			{
				setCursor(MiCursor.getSilencioBlanca ());
			}
			
			if ( op == 8 )
			{
				setCursor(MiCursor.getSilencioNegra ());
			}
			
			if ( op == 9 )
			{
				setCursor(MiCursor.getSilencioCorchea ());
			}
			
			if ( op == 10 )
			{
				setCursor(MiCursor.getSilencioSemiCorchea());
			}
			
			if ( op == 11 )
			{
				setCursor(MiCursor.getBorrador());
			}
			
			if ( op == 12 )
			{
				setCursor(MiCursor.getRedondaPunto());
			}
			
			if ( op == 13 )
			{
				setCursor(MiCursor.getBlancaPunto());
			}
			
			if ( op == 14 )
			{
				setCursor(MiCursor.getNegraPunto());
			}
			
			if ( op == 15 )
			{
				setCursor(MiCursor.getCorcheaPunto());
			}
			
			if ( op == 16 )
			{
				setCursor(MiCursor.getSemiCorcheaPunto());
			}
			
			if ( op == 17 )
			{
				setCursor(MiCursor.getRedondaSostenida());
			}
			
			if ( op == 18 )
			{
				setCursor(MiCursor.getBlancaSostenida());
			}
			
			if ( op == 19 )
			{
				setCursor(MiCursor.getNegraSostenida());
			}
			
			if ( op == 20 )
			{
				setCursor(MiCursor.getCorcheaSostenida());
			}
			
			if ( op == 21 )
			{
				setCursor(MiCursor.getSemiCorcheaSostenida());
			}
			
			if ( op == 22 )
			{
				setCursor(MiCursor.getRedondaBemol ());
			}
			
			if ( op == 23 )
			{
				setCursor(MiCursor.getBlancaBemol ());
			}
			
			if ( op == 24 )
			{
				setCursor(MiCursor.getNegraBemol ());
			}
			
			if ( op == 25 )
			{
				setCursor(MiCursor.getCorcheaBemol ());
			}
			
			if ( op == 26 )
			{
				setCursor(MiCursor.getSemiCorcheaBemol ());
			}
		}
		catch ( IllegalArgumentException ia )
		{
			System.err.println("Error de IllegalArgumentException en PanelDibujo = "+ia);
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en PanelDibujo = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en PanelDibujo = "+he);
		}
		catch(Exception e)
		{
			System.err.println (e);
		}
	}

	public void añadir(Dibujable fig)
	{
		//if ( cantidadFig < figuras.length )
		//{
			//figuras[cantidadFig++] = fig;
			lista.agregar(fig);
			cantidadFig++;
			repaint();
		//}
		//else
		//{
			//System.err.println("SE COMPLETO EL ESPACIO DISPONIBLE");
		//}
	}
	
	public void accionarBanderas()
	{
		banderaPlay = true;
	}
	
	/*
	public void añadirFiguras(Figura figu)
	{
		if ( cantidadFig < fig.length )
		{
			fig[cantidadFig++] = figu;
		}
		else
		{
			System.err.println("SE COMPLETO EL ESPACIO DISPONIBLE");
		}
	}*/

	public void paint(Graphics g)
	{
		int lineaY = 0;
		int lineaX = 0;
		try
		{
			super.paint(g);
			
			if ( banderaPlay )
			{
				((Dibujable)flecha).dibujar(g);
				System.out.println("entro a pintar la flecha");
			}
			
			// g.drawImage (new ImageIcon("imagenes/notaDo.png").getImage (),30,1,this);
			// g.drawImage (new ImageIcon("imagenes/cuatro.png").getImage (),60,15,this);
			// g.drawImage (new ImageIcon("imagenes/silencioR.png").getImage (),130,28,this);
			for ( int i = 1 ; i <= cantidadFig ; i++)
			{
				Object o = lista.acceder(i);
				if ( o instanceof Dibujable )
				{
					if ( o instanceof Redonda )
					{
						lineaY = ((Redonda)o).getY();
						lineaX = ((Redonda)o).getX();
					}
					
					if ( o instanceof Blanca )
					{
						lineaY = ((Blanca)o).getY();
						lineaX = ((Blanca)o).getX();
					}
					
					if ( o instanceof Negra )
					{
						lineaY = ((Negra)o).getY();
						lineaX = ((Negra)o).getX();
					}
					
					if ( o instanceof Corchea )
					{
						lineaY = ((Corchea)o).getY();
						lineaX = ((Corchea)o).getX();
					}
					
					if ( o instanceof SemiCorchea )
					{
						lineaY = ((SemiCorchea)o).getY();
						lineaX = ((SemiCorchea)o).getX();
					}
					///////////***************
					if ( o instanceof RedondaPunto )
					{
						lineaY = ((RedondaPunto)o).getY();
						lineaX = ((RedondaPunto)o).getX();
					}
					
					if ( o instanceof BlancaPunto )
					{
						lineaY = ((BlancaPunto)o).getY();
						lineaX = ((BlancaPunto)o).getX();
					}
					
					if ( o instanceof NegraPunto )
					{
						lineaY = ((NegraPunto)o).getY();
						lineaX = ((NegraPunto)o).getX();
					}
					
					if ( o instanceof CorcheaPunto )
					{
						lineaY = ((CorcheaPunto)o).getY();
						lineaX = ((CorcheaPunto)o).getX();
					}
					
					if ( o instanceof SemiCorcheaPunto )
					{
						lineaY = ((SemiCorcheaPunto)o).getY();
						lineaX = ((SemiCorcheaPunto)o).getX();
					}
					
					if ( o instanceof RedondaSostenida )
					{
						lineaY = ((RedondaSostenida)o).getY();
						lineaX = ((RedondaSostenida)o).getX();
					}
					
					if ( o instanceof BlancaSostenida )
					{
						lineaY = ((BlancaSostenida)o).getY();
						lineaX = ((BlancaSostenida)o).getX();
					}
					
					if ( o instanceof NegraSostenida )
					{
						lineaY = ((NegraSostenida)o).getY();
						lineaX = ((NegraSostenida)o).getX();
					}
					
					if ( o instanceof CorcheaSostenida )
					{
						lineaY = ((CorcheaSostenida)o).getY();
						lineaX = ((CorcheaSostenida)o).getX();
					}
					
					if ( o instanceof SemiCorcheaSostenida )
					{
						lineaY = ((SemiCorcheaSostenida)o).getY();
						lineaX = ((SemiCorcheaSostenida)o).getX();
					}
					
					if ( o instanceof RedondaBemol )
					{
						lineaY = ((RedondaBemol)o).getY();
						lineaX = ((RedondaBemol)o).getX();
					}
					
					if ( o instanceof BlancaBemol )
					{
						lineaY = ((BlancaBemol)o).getY();
						lineaX = ((BlancaBemol)o).getX();
					}
					
					if ( o instanceof NegraBemol )
					{
						lineaY = ((NegraBemol)o).getY();
						lineaX = ((NegraBemol)o).getX();
					}
					
					if ( o instanceof CorcheaBemol )
					{
						lineaY = ((CorcheaBemol)o).getY();
						lineaX = ((CorcheaBemol)o).getX();
					}
					
					if ( o instanceof SemiCorcheaBemol )
					{
						lineaY = ((SemiCorcheaBemol)o).getY();
						lineaX = ((SemiCorcheaBemol)o).getX();
					}
					else
					{
						((Dibujable)o).dibujar(g);
					}
					
					if ( lineaY >= 16 && lineaY <= 64 )
					{
						dibujarLineas(16,64,lineaY,lineaX,g);
						((Dibujable)o).dibujar(g);
					}
					else
					{
						if ( lineaY >= 104 && lineaY <= 148 )
						{
							dibujarLineas(104,148,lineaY,lineaX,g);
							((Dibujable)o).dibujar(g);
						}
						else
						{
							((Dibujable)o).dibujar(g);
						}
					}
				}
				/*
				if ( figuras[i] != null )
				{
					figuras[i].dibujar(g);
				}*/
			}
			if ( entrada1 )
			{
				aux1.dibujar(g);
			}
			else
			{
				if ( entrada2 )
				{
					aux2.dibujar(g);
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("Error de paint = "+e);
		}
	}
	
	public void dibujarLineas( int lim1, int lim2, int lineaY,int lineaX, Graphics g )
	{
		if ( lim1 == 16 && lim2 == 64 )
		{
			for ( int i = 60 ; i >= lineaY ; i = i - 8 )
			{
				g.drawLine(lineaX+10,i,lineaX+23,i);
			}
		}
		else
		{
			if ( lim1 == 104 && lim2 == 148 )
			{
				for ( int i = 108 ; i <= lineaY ; i = i + 8 )
				{
					g.drawLine(lineaX+10,i,lineaX+23,i);
				}
			}
		}
	}
	
	public void quitarUltimo()
	{
		try
		{
			/*
			for ( int i = figuras.length-1 ; i > 0 ; i-- )
			{
				if ( figuras[i] != null )
				{
					figuras[i] = null;
					cantidadFig--;
					repaint();
					return;
				}
				else
				{
					//System.out.println("entro null = "+figuras[i]);
				}
			}*/
			if ( cantidadFig != 1 )
			{
				lista.borrarUltimo();
				cantidadFig--;
				repaint();
			}
		}
		catch(Exception e)
		{
			System.err.println("Error de quitar ultimo = "+e);
		}
	}
	
	public void setAccion(boolean res)
	{
		accion = res;
	}
	
	public boolean getAccion()
	{
		return accion;
	}
	
	class Entrada extends MouseMotionAdapter
	{
		public void mouseMoved(MouseEvent e)
		{
			if ( e.getY() >= 12 && e.getY() <= 75 )
			{
				entrada1 = true;
				entrada2 = false;
				//System.out.println("entro al entered 1 = "+e.getY());
			}
			else
			{
				if ( e.getY() >= 107 && e.getY() <= 152 )
				{
					entrada1 = false;
					entrada2 = true;
					//System.out.println("entro al entered 2 = "+e.getY());
				}
				else
				{
					entrada1 = false;
					entrada2 = false;
					//System.out.println("entro al entered que no hace nada = "+e.getY() );
				}
			}
			repaint();
		}
	};
	/*
	public void setPosicionPentagrama(int ox, int oy, int dx, int dy)
	{
		aux1 = new PentagramaAuxiliar(ox,oy,dx,dy);
		aux2 = new PentagramaAuxiliar2(ox,oy,dx,dy);
	}*/
}
