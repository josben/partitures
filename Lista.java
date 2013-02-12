
/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

class Lista
{
    // Los atributos de la clase
    private Nodo comienzo;
    private Nodo ahora;
    private int contador;
    
    /**
     * Constructor de la Clase Lista
     */
    public Lista()
    {
        comienzo = null;
        ahora = null;
        contador = 0;
    }

    /**
     * Este es el metodo que permite ver el objeto en una posicion dada.
     * @param pos -Es la posicion del Objeto al que se quiere acceder.
     */
    public Object acceder(int pos)
    {
        Nodo res = null;
        Nodo actual = comienzo;
        while(pos != 1)
        {
            actual = actual.getSig();
            pos-=1;
        }
        res = actual;
        return res.getDato();
    }

    /**
     * Este metodo nos perminte fijar un objeto en una posicion o tambien se
     * puede utilizar para intercambiar posiciones.
     * @param d -Este es el dato que se quiere colocar.
     * @param pos -Este es la posicion al que se insertara.
     */
    public void setPosicion(Object d,int pos)
    {
        Nodo aux = comienzo;
        while(pos != 1)
        {
                aux = aux.getSig();
                pos-=1;
        }
        aux.setDato(d);
    }
    
    /**
     * Este metodo nos permite insertar elementos al final de la lista.
     * @param x -Es el dato que se desea insertar.
     */
    public void agregar(Object x)
    {
        if (comienzo == null)
        {
            comienzo = new Nodo(x,null);
            ahora = comienzo;
            contador++;
        }

        else
        {
            Nodo T = new Nodo(x, ahora.getSig());
            ahora.setSig(T);
            ahora = T;
            contador++;
        }
    }
    
    /**
     * Este metodo me permite borrar el elemento del principio.
     * @return me devuelve el dato que a borrado.
     */
    public Object borrarPrimero()
    {
        Object remover = null;
        if (vacia())
        {
            System.out.println("La lista esta vacia");
        }
        
        remover = comienzo.getDato();
        
        if ( comienzo.equals( ahora ) )
        {
            comienzo = null;
            ahora = null;
            contador--;
        }
        else
        {
            comienzo = comienzo.getSig();
            contador--;
        }
        return remover;
    }
    
    /**
     * Este es el metodo que permite borrar elementos de la ultima posicion.
     * @return Retorna el objeto que a borrado.
     */
    public Object borrarUltimo()
    {
        Object remover = null;
        if (vacia())
        {
            System.out.println("La lista esta vacia");
        }
        
        remover = ahora.getDato();
        
        if (comienzo.equals(ahora))
        {
            comienzo = ahora =  null;
            contador--;
        }
        else
        {
            Nodo actual = comienzo;
            
            while (actual.getSig() != ahora)
            {
                actual = actual.getSig();
            }
            ahora = actual;
            actual.setSig(null);
            contador--;
        }
        return remover;
    }
    
    public void eliminar( Object dat )
    {
    	Nodo aux = comienzo;
    	Object d;
    	if ( !vacia() )
    	{
    		d = aux.getDato();
    		if ( dat.equals( d ) )
    		{
    			comienzo = comienzo.getSig();
    		}
    		else
    		{
    			Nodo auxSig = aux.getSig();
    			if( auxSig != null )
    			{
    				d = auxSig.getDato();
    				
    				while( auxSig.getSig() != null && d != dat )
    				{
    					aux = aux.getSig();
    					auxSig = aux.getSig();
    					d = auxSig.getDato();
    				}
    				
    				if( dat.equals( d ) )
    				{
    					Nodo q = aux.getSig();
    					aux.setSig( q.getSig() );
    				}
    			}
    		}
    		contador--;
    	}
    }
    
    /**
     * Este meto me permite ver el comienzo de la lista.
     * @return Retorna el primer dato.
     */
    public Nodo getComienzo()
    {
        return comienzo;
    }
    
    /**
     * Este metodo que permite ver el ultimo dato.
     * @return Retorna el ultimo dato.
     */
    public Object getAhora()
    {
        return ahora.getDato();
    }
    
    /**
     * Este metodo devuelve el valor previo de un dato.
     * @return Retorna el valor previo.
     *
    public Object getPrevio()
    {
        return previo.getDato();
    }*/

    /**
     * Este es el metodo que me dice si la lista esta vacia o no esta vacia.
     * @return true si esta vacia y false si no lo esta.
     */
    public boolean vacia()
    {
        return comienzo == null;
    }

    /**
     * Este metodo me muestra los elementos de la Lista.
     */
    public void mostrar()
    {
        if (vacia())
        {
            System.out.println("La lista esta vacia");
        }
        else
        {
            Nodo aux = comienzo;
            while (aux != null)
            {
                System.out.print(aux.getDato()+" ");
                aux = aux.getSig();
            }
        }
        System.out.println();
    }
    
    /**
     *Este metodo retorna true si se halla el objeto y
     *false en caso de que no haya sido encontrado.
     *@param x Es el objeto que va hacer buscado.
     *@return true o false.
     */
    public boolean buscar(Object x)
    {
        Nodo aux = comienzo;
        boolean res = false;
        while(aux != null)
        {
            if (aux.getDato().equals(x))
            {
                res = true;
            }
            aux = aux.getSig();
        }
        return res;
    }
    
    public int getContador()
    {
    	return contador;
    }
}