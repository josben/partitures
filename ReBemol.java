
public class ReBemol extends NotaMusical
{
	private final int arrReBemol[] = {25,37,49,61,73,85,97,109}; 
	
	public ReBemol(int pos)
	{
		super(pos);
	}
	
	public int[] getArrReBemol()
	{
		return arrReBemol;
	}
	
	public int getArrReBemol(int indice)
	{
		return arrReBemol[indice];
	}
}