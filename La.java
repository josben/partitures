
public class La extends NotaMusical
{
	private final int arrLa[] = {33,45,57,69,81,93,105,117}; 
	
	public La(int pos)
	{
		super(pos);
	}
	
	public int[] getArrLa()
	{
		return arrLa;
	}
	
	public int getArrLa(int indice)
	{
		return arrLa[indice];
	}
}