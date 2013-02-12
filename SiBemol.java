
public class SiBemol extends NotaMusical
{
	private final int arrSiBemol[] = {34,46,58,70,82,94,106,118}; 
	
	public SiBemol(int pos)
	{
		super(pos);
	}
	
	public int[] getArrSiBemol()
	{
		return arrSiBemol;
	}
	
	public int getArrSiBemol(int indice)
	{
		return arrSiBemol[indice];
	}
}