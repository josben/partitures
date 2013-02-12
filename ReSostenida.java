
public class ReSostenida extends NotaMusical
{
	private final int arrReSostenida[] = {27,39,51,63,75,87,99,111}; 
	
	public ReSostenida(int pos)
	{
		super(pos);
	}
	
	public int[] getArrReSostenida()
	{
		return arrReSostenida;
	}
	
	public int getArrReSostenida(int indice)
	{
		return arrReSostenida[indice];
	}
}