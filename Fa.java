
public class Fa extends NotaMusical
{
	private final int arrFa[] = {29,41,53,65,77,89,101,113}; 
	
	public Fa(int pos)
	{
		super(pos);
	}
	
	public int[] getArrFa()
	{
		return arrFa;
	}
	
	public int getArrFa(int indice)
	{
		return arrFa[indice];
	}
}