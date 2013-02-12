
public class MiBemol extends NotaMusical
{
	private final int arrMiBemol[] = {27,39,51,63,75,87,99,111}; 
	
	public MiBemol(int pos)
	{
		super(pos);
	}
	
	public int[] getArrMiBemol()
	{
		return arrMiBemol;
	}
	
	public int getArrMiBemol(int indice)
	{
		return arrMiBemol[indice];
	}
}