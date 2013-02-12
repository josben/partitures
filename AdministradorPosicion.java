
import java.awt.Point;

/**
 * Esta clase administra las posisiciones de las figuras que
 * se añaden en el panel.<b>
 *
 * @author Jose Benjamin Perez Soto
 * @version 0.0.0.22.02.08_04_07
 */

public class AdministradorPosicion
{
	private Point puntos[];
	private int contador;
	
	/**
	 * Inicializa los atributos.
	 */
	public AdministradorPosicion()
	{
		puntos = new Point[100];
		contador = 0;
	}
	
	/**
	 * Añade el punto despues de verficar que la posicion en la que
	 * se desea añadir sea correcta.
	 * 
	 * @param p Es un objeto de tipo Point que almacena las posiciones
	 * x,y.
	 */
	public void setPunto(Point p)
	{
		if ( contador < puntos.length )
		{
			puntos[contador++] = p;
			System.out.println("X = "+p.getX()+", "+"Y = "+p.getY());
		}
		else
		{
			System.err.println("SE COMPLETO EL ESPACIO");
		}
	}
	
	/**
	 * Verifica que la posicion en la que se desea añadir sea valida.
	 * @param x La posicion X de la figura.
	 * @param y La posicion Y de la figura.
	 * @return Retorna Verdadero si la posicion esta libre, y falso si
	 * no la esta.
	 */
	public boolean posicionValida(int x, int y)
	{
		int oX = 0, oY = 0;
		boolean res = false;
		if ( puntos[0] == null )
		{
			res = true;
		}
		else
		{
			try
			{
				for ( int i = 0 ; i < puntos.length ; i++ )
				{
					//System.out.println(puntos[i].toString());
					if ( puntos[i] != null )
					{
						oX = (int)puntos[i].getX();
						oY = (int)puntos[i].getY();
						//System.out.println ("Entro al if se copara con i X = "+oX+", oY = "+oY);
						//System.out.println ("puntos que entraron X = "+x+", Y = "+y);

						if ( oX == x && oY == y)
						{
							return res = false;
							//System.out.println("entro al if falso");
						}
						else
						{
							if ( ( x >= (int)puntos[i].getX()-10 ) && ( x <= (int)puntos[i].getX()+16 ) )
							{
								return res = false;
								//System.out.println("entro al sengundo if false");
							}
							else
							{
								res = true;
								//System.out.println("entro al tercer if true");
							}
						}
					}
					/*
					else
					{
						return res = true;
					}*/
				}
			}
			catch(Exception e)
			{
				System.err.println (e);
			}
			//return res;
		}
		return res;
	}
	
	/**
	 * Ajusta el valo X de la figura para que no se dispare a cualquier lado.
	 * @param x Este es el X en el que se desea añadir la figura.
	 * @return Retorna la nueva posicion X para la figura.
	 */
	public int ajustarX(int x)
	{
		System.out.println ("entro al ajustarX");
		int res = 0;
		try
		{
			int oX = 0;
			if ( x >147 && x < 347 )
			{
				res = parametro1();
			}
			else
			{
				if ( x >= 347 && x < 597 )
				{
					res = parametro2();
				}
				else
				{
					if ( x >= 597 && x < 855 )
					{
						res = parametro3();
					}
				}
			}
		}
		catch(Exception e)
		{
			System.err.println (e);
		}
		return res;
	}
	
	/**
	 * Se encarga del primer intervalo.
	 */
	public int parametro1()
	{
		int oX = 0;
		try
		{
			if ( puntos[0] == null )
			{
				return 147;
			}
			else
			{
				for ( int i = puntos.length-1 ; i >= 0 ; i-- )
				{
					//System.out.println("entro al for");
					if ( puntos[i] != null )
					{
						System.out.println ("entro al if");
						oX = (int)puntos[i].getX();
						return (oX+25);
					}
				}
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		return oX;
	}
	
	/**
	 * Se encarga del Segundo intervalo.
	 */
	public int parametro2()
	{
		int oX = 0;
		try
		{
			if ( puntos[0] == null )
			{
				return (347+25);
			}
			else
			{
				System.out.println("entro****************");
				for ( int i = puntos.length-1 ; i >= 0 ; i-- )
				{
					if ( puntos[i] != null )
					{
						System.out.println("entro al si no es null");
						if ( puntos[i].getX() > 347.0 )
						{
							oX = (int)puntos[i].getX();
							return (oX+25);
						}
						else
						{
							System.out.println("se modifico");
							oX = 347;
							return (oX+10);
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		return oX;
	}
	
	/**
	 * Se encarga del Terser intervalo.
	 */
	public int parametro3()
	{
		int oX = 0;
		try
		{
			if ( puntos[0] == null )
			{
				return (597+25);
			}
			else
			{
				for ( int i = puntos.length-1 ; i >= 0 ; i-- )
				{
					if ( puntos[i] != null )
					{
						if ( puntos[i].getX() > 597.0 )
						{
							oX = (int)puntos[i].getX();
							return (oX+25);
						}
						else
						{
							oX = 597;
							return (oX+10);
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		return oX;
	}
	
	/**
	 * Este metodo se encarga de verificar las posicione Y de la figura.
	 */
	public int ajustarY(int y)
	{
		int res = 0;
		
		if ( y <= 18 && y > 14 )
		{
			res = 16;
		}
		
		if ( y <= 22 && y > 18 )
		{
			res = 20;
		}
		
		if ( y <= 26 && y > 22 )
		{
			res = 24;
		}
		
		if ( y <= 30 && y > 26 )
		{
			res = 28;
		}
		
		if ( y <= 34 && y > 30 )
		{
			res = 32;
		}
		
		if ( y <= 38 && y > 34 )
		{
			res = 36;
		}
		
		if ( y <= 42 && y > 38 )
		{
			res = 40;
		}
		
		if ( y <= 46 && y > 42 )
		{
			res = 44;
		}
		
		if ( y <= 50 && y > 46 )
		{
			res = 48;
		}
		
		if ( y <= 54 && y > 50 )
		{
			res = 52;
		}
		
		if ( y <= 58 && y > 54 )
		{
			res = 56;
		}
		
		if ( y <= 62 && y > 58 )
		{
			res = 60;
		}
		
		if ( y <= 66 && y > 62 )
		{
			res = 64;
		}
		
		if ( y <= 70 && y > 66 )
		{
			res = 68;
		}
		
		if ( y <= 74 && y > 70 )
		{
			res = 72;
		}
		
		if ( y <= 78 && y > 74 )
		{
			res = 76;
		}
		
		if ( y <= 82 && y > 78 )
		{
			res = 80;
		}
		
		if ( y <= 86 && y > 82 )
		{
			res = 84;
		}
		
		if ( y <= 90 && y > 86 )
		{
			res = 88;
		}
		
		if ( y <= 94 && y > 90 )
		{
			res = 92;
		}
		
		if ( y <= 98 && y > 94 )
		{
			res = 96;
		}
		
		if ( y <= 102 && y > 98 )
		{
			res = 100;
		}
		
		if ( y <= 106 && y > 102 )
		{
			res = 104;
		}
		
		if ( y <= 110 && y > 106 )
		{
			res = 108;
		}
		
		if ( y <= 114 && y > 110 )
		{
			res = 112;
		}
		
		if ( y <= 118 && y > 114 )
		{
			res = 116;
		}
		
		if ( y <= 122 && y > 118 )
		{
			res = 120;
		}
		
		if ( y <= 126 && y > 122 )
		{
			res = 124;
		}
		
		if ( y <= 130 && y > 126 )
		{
			res = 128;
		}
		
		if ( y <= 134 && y > 130 )
		{
			res = 132;
		}
		
		if ( y <= 138 && y > 134 )
		{
			res = 136;
		}
		
		if ( y <= 142 && y > 138 )
		{
			res = 140;
		}
		
		if ( y <= 146 && y > 142 )
		{
			res = 144;
		}
		
		if ( y <= 152 && y > 146 ) // sol
		{
			res = 148;
		}
		return res;
	}
	
	/**
	 * Muestra todos los puntos.
	 */
	public void muestraPuntos()
	{
		for ( int i = 0 ; i < puntos.length ; i++ )
		{
			if ( puntos[i] != null )
			{
				System.out.println(puntos[i].toString());
			}
			else
			{
				return;
			}
		}
	}
	
	/**
	 * Se encarga de boorar el ultimo punto.
	 */
	public void borrarUltimoPunto()
	{
		try
		{
			for ( int i = puntos.length-1 ; i >= 0 ; i-- )
			{
				if( puntos[i] != null )
				{
					puntos[i] = null;
					contador--;
					System.out.println(contador);
					return;
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("Error de borrarUltimoPunto = "+e);
		}
	}
}
