
public class FaBemol extends NotaMusical
{
	private final int arrFaBemol[] = {28,40,52,64,76,88,100,112}; 
	
	public FaBemol(int pos)
	{
		super(pos);
	}
	
	public int[] getArrFaBemol()
	{
		return arrFaBemol;
	}
	
	public int getArrFaBemol(int indice)
	{
		return arrFaBemol[indice];
	}
}