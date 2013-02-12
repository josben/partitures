
public class LaBemol extends NotaMusical
{
	private final int arrLaBemol[] = {32,44,56,68,80,92,104,116}; 
	
	public LaBemol(int pos)
	{
		super(pos);
	}
	
	public int[] getArrLaBemol()
	{
		return arrLaBemol;
	}
	
	public int getArrLaBemol(int indice)
	{
		return arrLaBemol[indice];
	}
}