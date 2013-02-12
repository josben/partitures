
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.KeyListener;
import java.util.EventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.print.Printable;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * Esta clase se encarga de adminstrar todas la ventanas que se abre y de
 * colocar todos sus atributos.<b>
 * 
 * @author Jose Benjamin Perez Soto
 * @version 0.0.0.22.02.08_04_07
 */

public class AdministradorVentanas extends JPanel implements ControlPantalla, KeyListener, FocusListener, Printable
{
	private static PanelDibujo auxP = new PanelDibujo(1);
	
	private static Lista listaPanel;
	private Lista listaArchivo;
	private Lista listaPosicion;
	private Lista listaNotas;
	
	private Raton raton;
	
	private PentagramaDibujable pentagrama;
	private PentagramaAuxiliar pentaAux;
	private PentagramaAuxiliar2 pentaAux2;
	private int oX = 97, oY = 68, dX = 855, dY = 68;//787
	private static Figura fig;
	
	private NuevoGrid niveles;
	
	private int cantidadPan = 0;
	
	private ImageIcon imagen;
	private ImageIcon imgVacio = new ImageIcon("imagenes/vacio.gif");
	private double dato;
	private PageFormat pagina = null;
    private PrinterJob imprimir = null;
	
	/**
	 * Contructor vasio.
	 */
	public AdministradorVentanas( int out )
	{

	}
	
	/**
	 * Inicializa todos los atributos.
	 */
	public AdministradorVentanas(ImageIcon img, double d)
	{
		niveles = new NuevoGrid(10,1);
		setLayout(niveles);
		this.setFocusable(true);
		
		listaPanel = new Lista();
		listaArchivo = new Lista();
		listaPosicion = new Lista();
		listaNotas = new Lista();
		
		imagen = img;
		dato = d;
		
		Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		Border loweredBevel = BorderFactory.createLoweredBevelBorder();
		Border compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
		setBorder(compound);
		
		raton = new Raton();
		
		pentagrama = new PentagramaDibujable(oX, oY, dX, dY,imagen);
		
		llenarListaPaneles();
		llenarPanel();
	}
	
	/**
	 * Devuelve la listaArchivo.
	 */
	public Lista getArchivoMusical()
	{
		return listaArchivo;
	}
	
	/**
	 * Llena la listaPanel.
	 */
	public void llenarListaPaneles()
	{
		for ( int i = 1 ; i <= 10 ; i++ )
		{
			listaPanel.agregar(new PanelDibujo(oX, oY, dX, dY));
		}
	}
	
	public Lista getListaPaneles()
	{
		return listaPanel;
	}
	
	/**
	 * Llena el panel contodos sus componentes.
	 */
	public void llenarPanel()
	{
		for ( int i = 1 ; i <= 10 ; i++ )
		{	
			listaArchivo.agregar(new ArchivoMusical());
			listaPosicion.agregar(new AdministradorPosicion());
			listaNotas.agregar(new AdministradorNotas(dato));
			
			Object o = listaPanel.acceder(i);
			if ( o instanceof PanelDibujo )
			{
				if ( i == 1 )
				{
					System.out.println("entro a colocar la armadura");
					((PanelDibujo)o).setForeground(Color.black);
					((PanelDibujo)o).añadir(pentagrama);
					((PanelDibujo)o).setFocusable(true);
					((PanelDibujo)o).addKeyListener(this);
					add(((PanelDibujo)o));
					((PanelDibujo)o).addFocusListener(this);
					((PanelDibujo)o).addMouseListener(raton);
				}
				else
				{
					//pentagrama.setImagen(imgVacio);
					((PanelDibujo)o).setForeground(Color.black);
					((PanelDibujo)o).añadir(pentagrama);
					((PanelDibujo)o).setFocusable(true);
					((PanelDibujo)o).addKeyListener(this);
					add(((PanelDibujo)o));
					((PanelDibujo)o).addFocusListener(this);
					((PanelDibujo)o).addMouseListener(raton);
				}
			}
		}
	}
	
	/**
	 * Retorna el pentagrama.
	 */
	public PentagramaDibujable getPentagrama()
	{
		return pentagrama;
	}
	
	/**
	 * Retorna un Objeto de Tipo AdministradorPosicion.
	 */
	public AdministradorPosicion getPosicion(int indice)
	{
		return ((AdministradorPosicion)listaPosicion.acceder(indice+1));
	}
	
	/**
	 * Retorna un Objeto de tipo PanelDibujo.
	 */
	public PanelDibujo getPanel(int indice)
	{
		return ((PanelDibujo)listaPanel.acceder(indice+1));
	}
	
	/**
	 * Retorna toda una Lista que contiene Paneles.
	 */
	public Lista getPanelArray()
	{
		return listaPanel;
	}
	
	/**
	 * Retorna el total de paneles.
	 */
	public int getTotalPaneles()
	{
		return 10;
	}
	
	/**
	 * Retorna un Objeto de tipo ArchivoMusical.
	 */
	public ArchivoMusical getArchivo(int indice)
	{
		return ((ArchivoMusical)listaArchivo.acceder(indice+1));
	}
	
	/**
	 * Retorna un Objeto de tipo AdminstradoNotas.
	 */
	public AdministradorNotas getNota(int indice)
	{
		return ((AdministradorNotas)listaNotas.acceder(indice+1));
	}
	
	/**
	 * Este metodo se encarga de cambiar la imagen del cursor cuando
	 * se hace clic en la barra de las figuras.
	 */
	public void setFigura(Mi_PanelControl m, String cadena)
	{
		try
		{
			if ( m.getAccionPunto() )
			{
				if ( m.getAccionRedonda() )
				{
					fig = new RedondaPunto(0,0);
					colocarImagen(12);
				}
				
				if ( m.getAccionBlanca() )
				{
					fig = new BlancaPunto(0,0);
					colocarImagen(13);
				}
				
				if ( m.getAccionNegra() )
				{
					fig = new NegraPunto(0,0);
					colocarImagen(14);
				}
				
				if ( m.getAccionCorchea() )
				{
					fig = new CorcheaPunto(0,0);
					colocarImagen(15);
				}
				
				if ( m.getAccionSemiCorchea() )
				{
					fig = new SemiCorcheaPunto(0,0);
					colocarImagen(16);
				}
			}
			else
			{
				if ( m.getAccionSostenido() )
				{
					if ( m.getAccionRedonda() )
					{
						fig = new RedondaSostenida(0,0);
						colocarImagen(17);
					}
					
					if ( m.getAccionBlanca() )
					{
						fig = new BlancaSostenida(0,0);
						colocarImagen(18);
					}
					
					if ( m.getAccionNegra() )
					{
						fig = new NegraSostenida(0,0);
						colocarImagen(19);
					}
					
					if ( m.getAccionCorchea() )
					{
						fig = new CorcheaSostenida(0,0);
						colocarImagen(20);
					}
					
					if ( m.getAccionSemiCorchea() )
					{
						fig = new SemiCorcheaSostenida(0,0);
						colocarImagen(21);
					}
				}
				else
				{
					if ( m.getAccionBemol () )
					{
						if ( m.getAccionRedonda () )
						{
							fig = new RedondaBemol(0,0);
							colocarImagen(22);
						}
						
						if ( m.getAccionBlanca () )
						{
							fig = new BlancaBemol(0,0);
							colocarImagen(23);
						}
						
						if ( m.getAccionNegra () )
						{
							fig = new NegraBemol(0,0);
							colocarImagen(24);
						}
						
						if ( m.getAccionCorchea () )
						{
							fig = new CorcheaBemol(0,0);
							colocarImagen(25);
						}
						
						if ( m.getAccionSemiCorchea () )
						{
							fig = new SemiCorcheaBemol(0,0);
							colocarImagen(26);
						}
					}
					else
					{
						if ( cadena.equalsIgnoreCase("cambio") )
						{
							if ( m.getAccionRedonda() )
							{
								fig = new Redonda(0,0);
								colocarImagen(1);
							}
							
							if ( m.getAccionBlanca() )
							{
								fig = new Blanca(0,0);
								colocarImagen(2);
							}
							
							if ( m.getAccionNegra() )
							{
								fig = new Negra(0,0);
								colocarImagen(3);
							}
							
							if ( m.getAccionCorchea() )
							{
								fig = new Corchea(0,0);
								colocarImagen(4);
							}
							
							if ( m.getAccionSemiCorchea() )
							{
								fig = new SemiCorchea(0,0);
								colocarImagen(5);
							}
						}
						else
						{
							if ( cadena.equalsIgnoreCase("redonda") )
							{
								fig = new Redonda(0,0);
								colocarImagen(1);
							}
							
							if ( cadena.equalsIgnoreCase("blanca") )
							{
								fig = new Blanca(0,0);
								colocarImagen(2);
							}
							
							if ( cadena.equalsIgnoreCase("negra") )
							{
								fig = new Negra(0,0);
								colocarImagen(3);
							}
							
							if ( cadena.equalsIgnoreCase("corchea") )
							{
								fig = new Corchea(0,0);
								colocarImagen(4);
							}
							
							if ( cadena.equalsIgnoreCase("semiCorchea") )
							{
								fig = new SemiCorchea(0,0);
								colocarImagen(5);
							}
							
							if ( cadena.equalsIgnoreCase("silencioRedonda") )
							{
								fig = new SilencioRedonda(0,0);
								colocarImagen(6);
							}
							
							if ( cadena.equalsIgnoreCase("silencioBlanca") )
							{
								fig = new SilencioBlanca(0,0);
								colocarImagen(7);
							}
							
							if ( cadena.equalsIgnoreCase ("silencioNegra") )
							{
								fig = new SilencioNegra(0,0);
								colocarImagen(8);
							}
							
							if ( cadena.equalsIgnoreCase ("silencioCorchea") )
							{
								fig = new SilencioCorchea(0,0);
								colocarImagen(9);
							}
							
							if ( cadena.equalsIgnoreCase ("silencioSemiCorchea") )
							{
								fig = new SilencioSemiCorchea(0,0);
								colocarImagen(10);
							}
							
							if ( cadena.equalsIgnoreCase("borrador") )
							{
								colocarImagen(11);
							}
						}
					}
				}
			}
		}
		catch ( Exception e )
		{
			String dialogo = "Error al cargar la figura del raton \n"+e;
			llamadaDeErrorDeFigura(dialogo);
		}
	}

	public void llamadaDeErrorDeFigura( String dialogo )
	{
		JOptionPane.showMessageDialog (this,dialogo,"Error en figuras",JOptionPane.ERROR_MESSAGE);
	}

	class Raton implements MouseListener
	{
		public void mouseEntered ( MouseEvent e ) { };

		public void mouseExited ( MouseEvent e ) { };

		public void mouseClicked ( MouseEvent e ) { };

		public void mousePressed ( MouseEvent e )
		{
			try
			{
				System.out.println("El punto es X = "+e.getX()+", Y = "+e.getY());
				if ( fig != null )
				{

					if ( e.getY() < 153 && e.getY() >= 15 && e.getX () > 95 && e.getX () < 855)
					{
						Object win = e.getSource ();
						if ( win == ((PanelDibujo)listaPanel.acceder(1)) )
						{
							((PanelDibujo)listaPanel.acceder(1)).setForeground (Color.black);
							if (((AdministradorPosicion)listaPosicion.acceder(1)).posicionValida(e.getX(), e.getY()))
							{
								añadirFigura(1, e.getX(), e.getY());
								((PanelDibujo)listaPanel.acceder(1)).requestFocus();
							}
							else
							{
								mensajeError();
							}
						}

						if ( win == ((PanelDibujo)listaPanel.acceder(2)) )
						{
							((PanelDibujo)listaPanel.acceder(2)).setForeground (Color.black);
							if ( ((AdministradorPosicion)listaPosicion.acceder(2)).posicionValida(e.getX(), e.getY()) )
							{
								System.out.println("Entro al panel 2");
								añadirFigura(2, e.getX(), e.getY());
								((PanelDibujo)listaPanel.acceder(2)).requestFocus();
							}
							else
							{
								mensajeError();
							}
						}

						if ( win == ((PanelDibujo)listaPanel.acceder(3)) )
						{
							((PanelDibujo)listaPanel.acceder(3)).setForeground (Color.black);
							if ( ((AdministradorPosicion)listaPosicion.acceder(3)).posicionValida(e.getX(), e.getY()) )
							{
								añadirFigura(3, e.getX(), e.getY());
								((PanelDibujo)listaPanel.acceder(3)).requestFocus();
							}
							else
							{
								mensajeError();
							}
						}

						if ( win == ((PanelDibujo)listaPanel.acceder(4)) )
						{
							((PanelDibujo)listaPanel.acceder(4)).setForeground (Color.black);
							if ( ((AdministradorPosicion)listaPosicion.acceder(4)).posicionValida(e.getX(), e.getY()) )
							{
								añadirFigura(4, e.getX(), e.getY());
								((PanelDibujo)listaPanel.acceder(4)).requestFocus();
							}
							else
							{
								mensajeError();
							}
						}

						if ( win == ((PanelDibujo)listaPanel.acceder(5)) )
						{
							((PanelDibujo)listaPanel.acceder(5)).setForeground (Color.black);
							if ( ((AdministradorPosicion)listaPosicion.acceder(5)).posicionValida(e.getX(), e.getY()) )
							{
								añadirFigura(5, e.getX(), e.getY());
								((PanelDibujo)listaPanel.acceder(5)).requestFocus();
							}
							else
							{
								mensajeError();
							}
						}

						if ( win == ((PanelDibujo)listaPanel.acceder(6)) )
						{
							((PanelDibujo)listaPanel.acceder(6)).setForeground (Color.black);
							if ( ((AdministradorPosicion)listaPosicion.acceder(6)).posicionValida(e.getX(), e.getY()) )
							{
								añadirFigura(6, e.getX(), e.getY());
								((PanelDibujo)listaPanel.acceder(6)).requestFocus();
							}
							else
							{
								mensajeError();
							}
						}
						if ( win == ((PanelDibujo)listaPanel.acceder(7)) )
						{
							((PanelDibujo)listaPanel.acceder(7)).setForeground (Color.black);
							if ( ((AdministradorPosicion)listaPosicion.acceder(7)).posicionValida(e.getX(), e.getY()) )
							{
								añadirFigura(7, e.getX(), e.getY());
								((PanelDibujo)listaPanel.acceder(7)).requestFocus();
							}
							else
							{
								mensajeError();
							}
						}
						if ( win == ((PanelDibujo)listaPanel.acceder(8)) )
						{
							((PanelDibujo)listaPanel.acceder(8)).setForeground (Color.black);
							if ( ((AdministradorPosicion)listaPosicion.acceder(8)).posicionValida(e.getX(), e.getY()) )
							{
								añadirFigura(8, e.getX(), e.getY());
								((PanelDibujo)listaPanel.acceder(8)).requestFocus();
							}
							else
							{
								mensajeError();
							}
						}
						if ( win == ((PanelDibujo)listaPanel.acceder(9)) )
						{
							((PanelDibujo)listaPanel.acceder(9)).setForeground (Color.black);
							if ( ((AdministradorPosicion)listaPosicion.acceder(9)).posicionValida(e.getX(), e.getY()) )
							{
								añadirFigura(9, e.getX(), e.getY());
								((PanelDibujo)listaPanel.acceder(9)).requestFocus();
							}
							else
							{
								mensajeError();
							}
						}
						if ( win == ((PanelDibujo)listaPanel.acceder(10)) )
						{
							((PanelDibujo)listaPanel.acceder(10)).setForeground (Color.black);
							if ( ((AdministradorPosicion)listaPosicion.acceder(10)).posicionValida(e.getX(), e.getY()) )
							{
								añadirFigura(10, e.getX(), e.getY());
								((PanelDibujo)listaPanel.acceder(10)).requestFocus();
							}
							else
							{
								mensajeError();
							}
						}
					}
					else
					{
						llamadaDeAlerta();
					}
				}
				else
				{
					errorDeFigura();
				}
			}
			catch ( Exception ep)
			{
				System.err.println (ep);
			}
		};

		public void mouseReleased ( MouseEvent e ) { };

		public void mouseMoved ( MouseEvent e ) { };

		public void mouseDragged ( MouseEvent e) { };
	}

	public void errorDeFigura()
	{
		String mensaje = "Usted debe primero seleccionar una figura musical \n y luego recien hacer clik";
		JOptionPane.showMessageDialog (this,mensaje,"Error de figuras",JOptionPane.ERROR_MESSAGE);
	}

	public void mensajeError()
	{
		try
		{
			String mensaje = "La posicion en la que usted \n esta queriendo añadir ya esta ocupada";
			JOptionPane.showMessageDialog (this,mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
			System.out.println("***************");
			
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
	}

	public void llamadaDeAlerta()
	{
		String otro = "Alerta usted no puede colocar \n las notas en esa posicion";
		// Esta seccion te permite tener mensajes de ERROR.
		JOptionPane.showMessageDialog (this,otro,"ALERTA",JOptionPane.WARNING_MESSAGE);
	}

	public void añadirFigura(int index, int x, int y)
	{
		if ( fig instanceof Redonda )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota (fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				System.out.println("ajustar X = "+auxX+"ajustar Y = "+auxY);
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,auxY));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((Redonda)fig).getNom()));
				
				fig = new Redonda(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota (fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((Redonda)fig));
			}
				
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof Blanca )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota (fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto( new Point(auxX,auxY) );
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((Blanca)fig).getNom()));

				fig = new Blanca(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota (fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((Blanca)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof Negra )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				System.out.println("ajustar X = "+auxX+"ajustar Y = "+auxY);
				System.out.println (pentagrama.getImagen ().toString ());
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto( new Point(auxX,auxY) );
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((Negra)fig).getNom()));

				fig = new Negra(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota (fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((Negra)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof Corchea )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto ( new Point(auxX, auxY) );
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((Corchea)fig).getNom()));

				fig = new Corchea(auxX,auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((Corchea)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof SemiCorchea )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,auxY));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((SemiCorchea)fig).getNom()));

				fig = new SemiCorchea(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((SemiCorchea)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}
		////////////******************* Figuras con Punto
		
		if ( fig instanceof RedondaPunto )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota (fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				System.out.println("ajustar X = "+auxX+"ajustar Y = "+auxY);
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,auxY));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((RedondaPunto)fig).getNom()));
				
				fig = new RedondaPunto(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota (fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((RedondaPunto)fig));
			}
				
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof BlancaPunto )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota (fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto( new Point(auxX,auxY) );
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((BlancaPunto)fig).getNom()));

				fig = new BlancaPunto(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota (fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((BlancaPunto)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof NegraPunto )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				System.out.println("ajustar X = "+auxX);
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto( new Point(auxX,auxY) );
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((NegraPunto)fig).getNom()));

				fig = new NegraPunto(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota (fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((NegraPunto)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof CorcheaPunto )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto ( new Point(auxX, auxY) );
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((CorcheaPunto)fig).getNom()));

				fig = new CorcheaPunto(auxX,auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((CorcheaPunto)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof SemiCorcheaPunto )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,auxY));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((SemiCorcheaPunto)fig).getNom()));

				fig = new SemiCorcheaPunto(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((SemiCorcheaPunto)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}
		
		//////////////***************** Fin de los puntos
		
		////////////**********
		
		if ( fig instanceof RedondaSostenida )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota (fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				System.out.println("ajustar X = "+auxX+"ajustar Y = "+auxY);
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,auxY));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((RedondaSostenida)fig).getNom()));
				
				fig = new RedondaSostenida(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota (fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((RedondaSostenida)fig));
			}
				
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof BlancaSostenida )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota (fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto( new Point(auxX,auxY) );
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((BlancaSostenida)fig).getNom()));

				fig = new BlancaSostenida(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota (fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((BlancaSostenida)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof NegraSostenida )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				System.out.println("ajustar X = "+auxX);
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto( new Point(auxX,auxY) );
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((NegraSostenida)fig).getNom()));

				fig = new NegraSostenida(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota (fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((NegraSostenida)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof CorcheaSostenida )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto ( new Point(auxX, auxY) );
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((CorcheaSostenida)fig).getNom()));

				fig = new CorcheaSostenida(auxX,auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((CorcheaSostenida)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof SemiCorcheaSostenida )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,auxY));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((SemiCorcheaSostenida)fig).getNom()));

				fig = new SemiCorcheaSostenida(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((SemiCorcheaSostenida)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}
		
		//////////////************ Fin de las Sostenidas
		
		if ( fig instanceof RedondaBemol )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota (fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				System.out.println("ajustar X = "+auxX+"ajustar Y = "+auxY);
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,auxY));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((RedondaBemol)fig).getNom()));
				
				fig = new RedondaBemol(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota (fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((RedondaBemol)fig));
				//paneles[index].añadirFiguras(fig);
			}
				
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof BlancaBemol )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota (fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto( new Point(auxX,auxY) );
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((BlancaBemol)fig).getNom()));

				fig = new BlancaBemol(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota (fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((BlancaBemol)fig));
				//paneles[index].añadirFiguras(fig);
			}
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof NegraBemol )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				System.out.println("ajustar X = "+auxX);
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto( new Point(auxX,auxY) );
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((NegraBemol)fig).getNom()));

				fig = new NegraBemol(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota (fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((NegraBemol)fig));
				//paneles[index].añadirFiguras(fig);
			}
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof CorcheaBemol )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto ( new Point(auxX, auxY) );
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((CorcheaBemol)fig).getNom()));

				fig = new CorcheaBemol(auxX,auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((CorcheaBemol)fig));
				//paneles[index].añadirFiguras(fig);
			}
			else
			{
				mensajeDeCompleto();
			}
		}

		if ( fig instanceof SemiCorcheaBemol )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				System.out.println (x+", "+y);
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX (x);
				int auxY = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarY(y);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,auxY));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, auxY, ((SemiCorcheaBemol)fig).getNom()));

				fig = new SemiCorcheaBemol(auxX, auxY);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((SemiCorcheaBemol)fig));
				//paneles[index].añadirFiguras(fig);
			}
			else
			{
				mensajeDeCompleto();
			}
		}
		
		////////////////*************** Fin de los Bemoles
		if ( fig instanceof SilencioRedonda )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX(x);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,46));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, 46, ((SilencioRedonda)fig).getNombre()));
				
				fig = new SilencioRedonda(auxX,84);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((SilencioRedonda)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}
		
		if ( fig instanceof SilencioBlanca )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX(x);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,46));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, 46, ((SilencioBlanca)fig).getNombre()));
				
				fig = new SilencioBlanca(auxX,84);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((SilencioBlanca)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}
		
		if ( fig instanceof SilencioNegra )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX(x);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,46));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, 46, ((SilencioNegra)fig).getNombre()));
				
				fig = new SilencioNegra(auxX,84);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((SilencioNegra)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}
		
		if ( fig instanceof SilencioCorchea )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX(x);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,46));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, 46, ((SilencioCorchea)fig).getNombre()));
				
				fig = new SilencioCorchea(auxX,84);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((SilencioCorchea)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}
		
		if ( fig instanceof SilencioSemiCorchea )
		{
			if ( ((AdministradorNotas)listaNotas.acceder(index)).verificarNota(fig,x) )
			{
				int auxX = ((AdministradorPosicion)listaPosicion.acceder(index)).ajustarX(x);
				
				((AdministradorPosicion)listaPosicion.acceder(index)).setPunto(new Point(auxX,46));
				
				((ArchivoMusical)listaArchivo.acceder(index)).añadir(new DatoMusical(auxX, 46, ((SilencioSemiCorchea)fig).getNombre()));
				
				fig = new SilencioSemiCorchea(auxX,84);
				((AdministradorNotas)listaNotas.acceder(index)).setNota(fig);
				((PanelDibujo)listaPanel.acceder(index)).añadir(((SilencioSemiCorchea)fig));
			}
			else
			{
				mensajeDeCompleto();
			}
		}
	}

	public static void colocarImagen(int img)
	{
		try
		{
			for ( int i = 1 ; i <= 10 ; i++ )
			{
				((PanelDibujo)listaPanel.acceder(i)).setImagen(img);
			}
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en AdministradorVentana al cargar Cursor = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en AdministradorVentana al cargar Cursor = "+he);
		}
		catch(Exception e)
		{
			System.out.println("Error de Exception en AdministradorVentana al cargar Cursor = "+e);
		}
	}

	public void cerrar()
	{
		setVisible(false);
		this.requestFocus(false);
	}

	public void abrir()
	{
		setVisible(true);
		/*
		for ( int i = 0 ; i < this.paneles.length ; i++ )
		{
			System.out.println("entroooooooooooooooooo\n");
			this.paneles[i].repaint();
			this.paneles[i].grabFocus();
			this.paneles[i].setFocusable(true);
		}
		*/
		this.requestFocus(true);
	}

	public void mensajeDeCompleto()
	{
		String mensaje = "Ya se completo el compas con la cantidad respectiva";
		JOptionPane.showMessageDialog (this,mensaje,"Error de figuras",JOptionPane.ERROR_MESSAGE);
	}

	public void keyTyped(KeyEvent e) {
		// TODO: Add your code here
	}

	public void keyPressed(KeyEvent e)
	{
		int cod = e.getKeyCode();
		
		if ( cod == KeyEvent.VK_ESCAPE )
		{
			fig = null;
			for ( int i = 1 ; i<= 10 ; i++)
			{
				System.out.println("Entro al teclado");
				((PanelDibujo)listaPanel.acceder(i)).requestFocus();
				((PanelDibujo)listaPanel.acceder(i)).setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			}
			Mi_PanelControl.retorna();
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO: Add your code here
	}
	
	public void muestraFoco( FocusEvent e )
	{
		System.out.println ( e.getComponent()+"*******" );
	}
	
	public void focusGained(FocusEvent e)
	{
		//muestraFoco(e);
		Object o = e.getSource();
		
		if ( ((PanelDibujo)listaPanel.acceder(1)) == o )
		{
			((PanelDibujo)listaPanel.acceder(1)).setAccion(true);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(2)) == o )
		{
			((PanelDibujo)listaPanel.acceder(2)).setAccion(true);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(3)) == o )
		{
			((PanelDibujo)listaPanel.acceder(3)).setAccion(true);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(4)) == o )
		{
			((PanelDibujo)listaPanel.acceder(4)).setAccion(true);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(5)) == o )
		{
			((PanelDibujo)listaPanel.acceder(5)).setAccion(true);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(6)) == o )
		{
			((PanelDibujo)listaPanel.acceder(6)).setAccion(true);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(7)) == o )
		{
			((PanelDibujo)listaPanel.acceder(7)).setAccion(true);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(8)) == o )
		{
			((PanelDibujo)listaPanel.acceder(8)).setAccion(true);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(9)) == o )
		{
			((PanelDibujo)listaPanel.acceder(9)).setAccion(true);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(10)) == o )
		{
			((PanelDibujo)listaPanel.acceder(10)).setAccion(true);
		}
	}
	
	public void focusLost(FocusEvent e)
	{
		Object o = e.getSource();
		
		if ( ((PanelDibujo)listaPanel.acceder(1)) == o )
		{
			((PanelDibujo)listaPanel.acceder(1)).setAccion(false);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(2)) == o )
		{
			((PanelDibujo)listaPanel.acceder(2)).setAccion(false);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(3)) == o )
		{
			((PanelDibujo)listaPanel.acceder(3)).setAccion(false);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(4)) == o )
		{
			((PanelDibujo)listaPanel.acceder(4)).setAccion(false);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(5)) == o )
		{
			((PanelDibujo)listaPanel.acceder(5)).setAccion(false);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(6)) == o )
		{
			((PanelDibujo)listaPanel.acceder(6)).setAccion(false);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(7)) == o )
		{
			((PanelDibujo)listaPanel.acceder(7)).setAccion(false);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(8)) == o )
		{
			((PanelDibujo)listaPanel.acceder(8)).setAccion(false);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(9)) == o )
		{
			((PanelDibujo)listaPanel.acceder(9)).setAccion(false);
		}
		
		if ( ((PanelDibujo)listaPanel.acceder(10)) == o )
		{
			((PanelDibujo)listaPanel.acceder(10)).setAccion(false);
		}
		
	}
	
	public void quitarFigura(boolean res)
	{
		try
		{
			if ( res )
			{
				for ( int i = 1 ; i <= 10 ; i++ )
				{
					if ( ((PanelDibujo)listaPanel.acceder(i)).getAccion() )
					{
						((PanelDibujo)listaPanel.acceder(i)).quitarUltimo();
						((ArchivoMusical)listaArchivo.acceder(i)).sacarUltimoDato();
						((AdministradorNotas)listaNotas.acceder(i)).borrarUltimaNota();
						((AdministradorPosicion)listaPosicion.acceder(i)).borrarUltimoPunto();
					}
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("Error de quitar Figura = "+e);
		}
	}
	
	public void agregarPentagrama()
	{
		listaPanel.agregar(new PanelDibujo(oX, oY, dX, dY));
		cantidadPan++;
		llenarAccesorios(cantidadPan);
	}
	
	public void llenarAccesorios(int c)
	{
		try
		{
			Object o = listaPanel.acceder(c);
			
			((PanelDibujo)o).setForeground(Color.black);
			((PanelDibujo)o).añadir(pentagrama);
			((PanelDibujo)o).setFocusable(true);
			((PanelDibujo)o).addKeyListener(this);
			add(((PanelDibujo)o));
			((PanelDibujo)o).addFocusListener(this);
			((PanelDibujo)o).addMouseListener(raton);
		}
		catch(Exception e)
		{
			System.err.println("Error de llenarAccesorios = "+e);
		}
	}
	
	public String getNombreDeImagen()
	{
		return pentagrama.getImagen ().toString ();
	}
	
	public void imprimir()
	{
		if ( imprimir == null )
		{
			imprimir = PrinterJob.getPrinterJob();
            pagina = imprimir.defaultPage();
        }
        //printMode = i;
        imprimir.setPrintable( this, pagina );

        if ( imprimir.printDialog() )
        {
        	try
        	{
        		imprimir.print();
            }
            catch ( Exception e )
            {
            	System.err.println( "ERROR al imprimir");
            }
        }
	}
	
	public void configurarPagina()
	{
		if ( imprimir == null )
		{
            imprimir = PrinterJob.getPrinterJob();
            pagina = imprimir.defaultPage();
        }
        pagina = imprimir.pageDialog( pagina );
	}
	
	public int print(Graphics g, PageFormat pf, int pi) throws PrinterException
	{
		System.out.println(getWidth()+" "+getHeight());
		if (pi >= 1)
		{
			return Printable.NO_SUCH_PAGE;
        }
		
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        
        g2d.translate(pf.getImageableWidth()/ 2,
                      pf.getImageableHeight() / 2);
                      
        Dimension d = getSize();
		
		double scale = Math.min(pf.getImageableWidth() / d.width,
            	                    pf.getImageableHeight() / d.height);
        
        if (scale < 1.0) {
            g2d.scale(scale, scale);
        }
		
        g2d.translate(-d.width / 2.0, -d.height / 2.0);
		
		printAll(g2d);
		
        return Printable.PAGE_EXISTS;
	}
}
