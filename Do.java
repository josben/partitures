
public class Do extends NotaMusical
{
	private final int arrDo[] = {24,36,48,60,72,84,96,108}; 
	public Do(int pos)
	{
		super(pos);	
	}
	
	public int[] getArrDo()
	{
		return arrDo;
	}
	
	public int getArrDo(int indice)
	{
		return arrDo[indice];
	}
}