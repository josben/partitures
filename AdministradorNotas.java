
import java.awt.*;

/**
 * La clase <code>AdministradorNotas</code> se encarga de administrar la 
 * suma de figuras en un intervalo.<b>
 *
 * @author José Benjamín Pérez Soto
 * @version 0.0.0.22.02.08_04_07
 */

public class AdministradorNotas
{
	private Figura fig[]; // arreglo de figuras
	private int contador; // contador de posicines
	private double dato; // el valor del compas
	
	/**
	 * @param d Este parametro inicializa el dato
	 * cuando se crea un nueva ventana se manda a este
	 * el valor del compas.
	 */
	public AdministradorNotas( double d )
	{
		fig = new Figura[100];
		contador = 0;
		dato = d;
	}
	
	/**
	 * Esten metodo fija una figura en el arreglo de
	 * Figuras despues de verificar que se este poniendo
	 * en una posicion valida.
	 * 
	 * @param f Este parametro es el dato que se coloca en
	 * el arreglo.
	 */
	public void setNota(Figura f)
	{
		if ( contador < fig.length )
		{
			fig[contador++] = f;
		}
		else
		{
			System.err.println ("SE COMPLETO EL ESPACIO");
		}
	}
	
	/**
	 * Este metodo se encarga de verificar una nota cuando
	 * se desea añadir. Verifica que la nota no sobre pase
	 * el valor del compas.
	 *
	 * @param figu Este es la figura que se desea añadir.
	 * @param x este indica en el intervalo en el que se encuentra.
	 * @return Este metodo retorna falso o verdadero. Falso cuando
	 * la suma se pasa del comas, y Verdadero cuando es menor o igual
	 * a la suma del compas.
	 */
	public boolean verificarNota ( Figura figu, int x )
	{
		boolean res = false;
		try
		{
			double valor = 0;
			
			if ( figu != null )
			{
				/*
				 * Aqui se saca el valor de la figura.
				 */
				if ( figu instanceof Redonda )
				{
					valor = ((Redonda)figu).getValor ();
				}
				
				if ( figu instanceof Blanca )
				{
					valor = ((Blanca)figu).getValor ();
				}
				
				if ( figu instanceof Negra )
				{
					valor = ((Negra)figu).getValor();
				}
				
				if ( figu instanceof Corchea )
				{
					valor = ((Corchea)figu).getValor ();
				}
				
				if ( figu instanceof SemiCorchea )
				{
					valor = ((SemiCorchea)figu).getValor ();
				}
				
				////////*********
				
				if ( figu instanceof RedondaPunto )
				{
					valor = ((RedondaPunto)figu).getValor ();
				}
				
				if ( figu instanceof BlancaPunto )
				{
					valor = ((BlancaPunto)figu).getValor ();
				}
				
				if ( figu instanceof NegraPunto )
				{
					valor = ((NegraPunto)figu).getValor();
				}
				
				if ( figu instanceof CorcheaPunto )
				{
					valor = ((CorcheaPunto)figu).getValor ();
				}
				
				if ( figu instanceof SemiCorcheaPunto )
				{
					valor = ((SemiCorcheaPunto)figu).getValor ();
				}
				
				if ( figu instanceof RedondaSostenida )
				{
					valor = ((RedondaSostenida)figu).getValor ();
				}
				
				if ( figu instanceof BlancaSostenida )
				{
					valor = ((BlancaSostenida)figu).getValor ();
				}
				
				if ( figu instanceof NegraSostenida )
				{
					valor = ((NegraSostenida)figu).getValor();
				}
				
				if ( figu instanceof CorcheaSostenida )
				{
					valor = ((CorcheaSostenida)figu).getValor ();
				}
				
				if ( figu instanceof SemiCorcheaSostenida )
				{
					valor = ((SemiCorcheaSostenida)figu).getValor ();
				}
				
				if ( figu instanceof RedondaBemol )
				{
					valor = ((RedondaBemol)figu).getValor ();
				}
				
				if ( figu instanceof BlancaBemol )
				{
					valor = ((BlancaBemol)figu).getValor ();
				}
				
				if ( figu instanceof NegraBemol )
				{
					valor = ((NegraBemol)figu).getValor ();
				}
				
				if ( figu instanceof CorcheaBemol )
				{
					valor = ((CorcheaBemol)figu).getValor ();
				}
				
				if ( figu instanceof SemiCorcheaBemol )
				{
					valor = ((SemiCorcheaBemol)figu).getValor ();
				}
				
				/////////**************
				
				if ( figu instanceof SilencioRedonda )
				{
					valor = ((SilencioRedonda)figu).getValor();
				}
				
				if ( figu instanceof SilencioBlanca )
				{
					valor = ((SilencioBlanca)figu).getValor();
				}
				
				if ( figu instanceof SilencioNegra )
				{
					valor = ((SilencioNegra)figu).getValor();
				}
				
				if ( figu instanceof SilencioCorchea )
				{
					valor = ((SilencioCorchea)figu).getValor();
				}
				
				if ( figu instanceof SilencioSemiCorchea )
				{
					valor = ((SilencioSemiCorchea)figu).getValor();
				}
				
				if ( x > 147 && x < 347 )
				{
					double suma1 = valor+getSumaIntervalo(147,347);
					return resultado(suma1);
				}
				else
				{
					// se verifica en el intervalo en el que se encuentra.
					if ( x > 347 && x < 597 )
					{
						double suma2 = valor+getSumaIntervalo(347,597);
						return resultado(suma2);
					}
					else
					{
						if ( x > 597 && x < 855 )
						{
							double suma3 = valor+getSumaIntervalo(597,855);
							return resultado(suma3);
						}
					}
				}
			}
		}
		catch ( Exception e )
		{
			System.err.println (e);
		}
		return res;
	}
	
	/**
	 * Este verfica que la suma de un intervalo
	 * no sobre pase el valor del compas.
	 *
	 * @param suma Este parametro es la suma que
	 * se saca de un intervalo.
	 * @return Devuelve Falso si la suma es mayor que el valor
	 * del intervalo, y Verdadero si es igual o menor que el 
	 * valor del intervalo.
	 */
	public boolean resultado(double suma)
	{
		boolean res = false;
		if ( suma == dato )
		{
			res = true;
		}
		else
		{
			if ( suma < dato )
			{
				res = true;
			}
			else
			{
				if ( suma > dato )
				{
					res = false;
				}
			}
		}
		return res;
	}
	
	/**
	 * Retorna una figura en una determindada posicion
	 */
	public Figura getFigura(int i)
	{
		return fig[i];
	}
	
	/**
	 * Retorna la suma total de todas la figuras.
	 */
	public double getSumaTotal()
	{
		double sum = 0.0;
		for ( int i = 0 ; i < fig.length ; i++ )
		{
			if ( fig [i] != null )
			{
				if ( fig[i] instanceof Redonda )
				{
					sum = sum + ((Redonda)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof Blanca )
				{
					sum = sum + ((Blanca)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof Negra )
				{
					sum = sum + ((Negra)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof Corchea )
				{
					sum = sum + ((Corchea)fig[i]).getValor ();
				}
				
				if ( fig [i] instanceof SemiCorchea )
				{
					sum = sum + ((SemiCorchea)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof RedondaPunto )
				{
					sum = sum + ((RedondaPunto)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof BlancaPunto )
				{
					sum = sum + ((BlancaPunto)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof NegraPunto )
				{
					sum = sum + ((NegraPunto)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof CorcheaPunto )
				{
					sum = sum + ((Corchea)fig[i]).getValor ();
				}
				
				if ( fig [i] instanceof SemiCorcheaPunto )
				{
					sum = sum + ((SemiCorcheaPunto)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof RedondaSostenida )
				{
					sum = sum + ((RedondaSostenida)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof BlancaSostenida )
				{
					sum = sum + ((BlancaSostenida)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof NegraSostenida )
				{
					sum = sum + ((NegraSostenida)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof CorcheaSostenida )
				{
					sum = sum + ((CorcheaSostenida)fig[i]).getValor ();
				}
				
				if ( fig [i] instanceof SemiCorcheaSostenida )
				{
					sum = sum + ((SemiCorcheaSostenida)fig[i]).getValor ();
				}
			}
		}
		return sum;
	}
	
	/**
	 * Este metodo se encarga de sacar la suma de las figuras en un
	 * determinado intervalo.
	 */
	public double getSumaIntervalo(int inferior, int superior)
	{
		double sum = 0.0;
		try
		{
			for ( int i = 0 ; i < fig.length ; i++ )
			{
				if ( fig[i] != null )
				{
					if ( fig[i].getX () >= inferior && fig[i].getX () < superior )
					{
						if ( fig[i] instanceof Redonda )
						{
							sum = sum + ((Redonda)fig[i]).getValor ();
						}
				
						if ( fig[i] instanceof Blanca )
						{
							sum = sum + ((Blanca)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof Negra )
						{
							sum = sum + ((Negra)fig[i]).getValor ();
						}
				
						if ( fig[i] instanceof Corchea )
						{
							sum = sum + ((Corchea)fig[i]).getValor ();
						}
				
						if ( fig [i] instanceof SemiCorchea )
						{
							sum = sum + ((SemiCorchea)fig[i]).getValor ();
						}
						//////********
						if ( fig[i] instanceof RedondaPunto )
						{
							sum = sum + ((RedondaPunto)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof BlancaPunto )
						{
							sum = sum + ((BlancaPunto)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof NegraPunto )
						{
							sum = sum + ((NegraPunto)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof CorcheaPunto )
						{
							sum = sum + ((CorcheaPunto)fig[i]).getValor ();
						}
						
						if ( fig [i] instanceof SemiCorcheaPunto )
						{
							sum = sum + ((SemiCorcheaPunto)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof RedondaSostenida )
						{
							sum = sum + ((RedondaSostenida)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof BlancaSostenida )
						{
							sum = sum + ((BlancaSostenida)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof NegraSostenida )
						{
							sum = sum + ((NegraSostenida)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof CorcheaSostenida )
						{
							sum = sum + ((CorcheaSostenida)fig[i]).getValor ();
						}
						
						if ( fig [i] instanceof SemiCorcheaSostenida )
						{
							sum = sum + ((SemiCorcheaSostenida)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof RedondaBemol )
						{
							sum = sum + ((RedondaBemol)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof BlancaBemol )
						{
							sum = sum + ((BlancaBemol)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof NegraBemol )
						{
							sum = sum + ((NegraBemol)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof CorcheaBemol )
						{
							sum = sum + ((CorcheaBemol)fig[i]).getValor ();
						}
						
						if ( fig [i] instanceof SemiCorcheaBemol )
						{
							sum = sum + ((SemiCorcheaBemol)fig[i]).getValor ();
						}
						
						//////////********
						if ( fig[i] instanceof SilencioRedonda )
						{
							sum = sum + ((SilencioRedonda)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof SilencioBlanca )
						{
							sum = sum + ((SilencioBlanca)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof SilencioNegra )
						{
							sum = sum + ((SilencioNegra)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof SilencioCorchea )
						{
							sum = sum + ((SilencioCorchea)fig[i]).getValor ();
						}
						
						if ( fig[i] instanceof SilencioSemiCorchea )
						{
							sum = sum + ((SilencioSemiCorchea)fig[i]).getValor ();
						}
					}
				}
			}
		}
		catch ( Exception e )
		{
			System.err.println (e);
		}
		return sum;
	}
	
	/**
	 * Este metodo muestra todo el arreglo
	 */
	public void muestraArreglo()
	{
		double valArr = 0.0;
		double sum = 0.0;
		for ( int i = 0 ; i < fig.length ; i++ )
		{
			if ( fig[i] != null )
			{
				if ( fig[i] instanceof Redonda )
				{
					valArr = ((Redonda)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof Blanca )
				{
					valArr = ((Blanca)fig[i]).getValor ();
				}
					
				if ( fig[i] instanceof Negra )
				{
					valArr = ((Negra)fig[i]).getValor ();
				}
				
				if ( fig[i] instanceof Corchea )
				{
					valArr = ((Corchea)fig[i]).getValor ();
				}
						
				if ( fig[i] instanceof SemiCorchea )
				{
					valArr = ((SemiCorchea)fig[i]).getValor ();
				}	
				System.out.println(valArr);
				sum = sum+valArr;
			}
		}
		System.out.println("La poderosa suma"+sum);
	}
	
	/**
	 * Este metodo se encarga de borrar la ultima nota
	 */
	public void borrarUltimaNota()
	{
		try
		{
			for ( int i = fig.length-1 ; i >= 0 ; i-- )
			{
				if ( fig[i] != null )
				{
					fig[i] = null;
					contador--;
					return;
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("Error de borrarUltimaNota = "+e);
		}
	}
}