
/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

class Nodo
{
	private Object dato;
	private Nodo sig;

	public Nodo(Object d, Nodo n)
	{
		dato = d;
		sig = n;
	}
	
	/**
	 * Este metodo me permite ver el dato.
	 * @return Retorna el dato.
	 */
	public Object getDato()
	{
		return dato;
	}
	
	/**
	 * Devuelve el siguiente.
	 * @return Retorna el nodo siguiente.
	 */
	public Nodo getSig()
	{
		return sig;
	}
	
	/**
	 * Este metodo fija el dato.
	 * @param d -El dato a colocar.
	 */
	public void setDato(Object d)
	{
		dato = d;
	}
	
	/**
	 * Este metodo fija el siguiente.
	 * @param e -Fija el siguiente nodo.
	 */
	public void setSig(Nodo e)
	{
		sig = e;
	}
}
