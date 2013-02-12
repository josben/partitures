
public class Mi extends NotaMusical
{
	private final int arrMi[] = {28,40,52,64,76,88,100,112}; 
	
	public Mi(int pos)
	{
		super(pos);
	}
	
	public int[] getArrMi()
	{
		return arrMi;
	}
	
	public int getArrMi(int indice)
	{
		return arrMi[indice];
	}
}