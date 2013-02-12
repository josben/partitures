
public class SiSostenida extends NotaMusical
{
	private final int arrSiSostenida[] = {36,48,60,72,84,96,108,120}; 
	
	public SiSostenida(int pos)
	{
		super(pos);
	}
	
	public int[] getArrSiSostenida()
	{
		return arrSiSostenida;
	}
	
	public int getArrSiSostenida(int indice)
	{
		return arrSiSostenida[indice];
	}
}