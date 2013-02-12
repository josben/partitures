
public class Sol extends NotaMusical
{
	private final int arrSol[] = {31,43,55,67,79,91,103,115}; 
	
	public Sol(int pos)
	{
		super(pos);
	}
	
	public int[] getArrSol()
	{
		return arrSol;
	}
	
	public int getArrSol(int indice)
	{
		return arrSol[indice];
	}
}