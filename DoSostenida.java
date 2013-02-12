
public class DoSostenida extends NotaMusical
{
	private final int arrDoSostenida[] = {25,37,49,61,73,85,97,109};
	 
	public DoSostenida(int pos)
	{
		super(pos);	
	}
	
	public int[] getArrDoSostenida()
	{
		return arrDoSostenida;
	}
	
	public int getArrDoSostenida(int indice)
	{
		return arrDoSostenida[indice];
	}
}