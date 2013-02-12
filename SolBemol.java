
public class SolBemol extends NotaMusical
{
	private final int arrSolBemol[] = {30,42,54,66,78,90,102,114}; 
	
	public SolBemol(int pos)
	{
		super(pos);
	}
	
	public int[] getArrSolBemol()
	{
		return arrSolBemol;
	}
	
	public int getArrSolBemol(int indice)
	{
		return arrSolBemol[indice];
	}
}