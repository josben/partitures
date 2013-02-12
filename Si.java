
public class Si extends NotaMusical
{
	private final int arrSi[] = {35,47,59,71,83,95,107,119}; 
	
	public Si(int pos)
	{
		super(pos);
	}
	
	public int[] getArrSi()
	{
		return arrSi;
	}
	
	public int getArrSi(int indice)
	{
		return arrSi[indice];
	}
}