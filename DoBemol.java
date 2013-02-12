
public class DoBemol extends NotaMusical
{
	private final int arrDoBemol[] = {23,35,47,59,71,83,95,107}; 
	public DoBemol(int pos)
	{
		super(pos);	
	}
	
	public int[] getArrDoBemol()
	{
		return arrDoBemol;
	}
	
	public int getArrDoBemol(int indice)
	{
		return arrDoBemol[indice];
	}
}