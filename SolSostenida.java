
public class SolSostenida extends NotaMusical
{
	private final int arrSolSostenida[] = {32,44,56,68,80,92,104,116}; 
	
	public SolSostenida(int pos)
	{
		super(pos);
	}
	
	public int[] getArrSolSostenida()
	{
		return arrSolSostenida;
	}
	
	public int getArrSolSostenida(int indice)
	{
		return arrSolSostenida[indice];
	}
}