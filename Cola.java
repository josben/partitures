
/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

class Cola
{
	Lista dato;
	public Cola()
	{
		dato = new Lista();
	}
	
	public boolean vacia()
	{
		return dato.vacia();
	}
	
	public void encolar(Object d)
	{
		dato.agregar(d);
	}

	public Object decolar()
	{
		return dato.borrarPrimero();
	}
	public void mostrar()
	{
		dato.mostrar();
	}
}