
public class Re extends NotaMusical
{
	private final int arrRe[] = {26,38,50,62,74,86,98,110}; 
	
	public Re(int pos)
	{
		super(pos);
	}
	
	public int[] getArrRe()
	{
		return arrRe;
	}
	
	public int getArrRe(int indice)
	{
		return arrRe[indice];
	}
}