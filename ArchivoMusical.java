
/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class ArchivoMusical
{
	private Cola cola;
	private DatoMusical dato;
	
	public ArchivoMusical(DatoMusical d)
	{
		dato = d;
	}
	
	public ArchivoMusical()
	{
		cola = new Cola();
	}
	
	public void añadir(DatoMusical dat)
	{
		cola.encolar (dat);
	}
	
	public Cola getCola()
	{
		return cola;
	}
	
	public DatoMusical getDato()
	{
		return dato;
	}
	
	public String sacarCola()
	{
		Cola aux = new Cola();
		while(!cola.vacia ())
		{
			Object o = cola.decolar ();
			aux.encolar (o);
			return ((DatoMusical)o).guardar();
			//System.out.println ("vaciar; "+o.toString ());
		}
		while(!aux.vacia ())
		{
			cola.encolar (aux.decolar ());
		}
		return null;
	}
	
	public void sacarUltimoDato()
	{
		Lista aux = new Lista();
		while (!cola.vacia())
		{
			aux.agregar(cola.decolar());
		}
		aux.borrarUltimo();
		while(!aux.vacia())
		{
			cola.encolar(aux.borrarPrimero());
		}
	}
}