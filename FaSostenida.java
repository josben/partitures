
public class FaSostenida extends NotaMusical
{
	private final int arrFaSostenida[] = {30,42,54,66,78,90,102,114}; 
	
	public FaSostenida(int pos)
	{
		super(pos);
	}
	
	public int[] getArrFaSostenida()
	{
		return arrFaSostenida;
	}
	
	public int getArrFaSostenida(int indice)
	{
		return arrFaSostenida[indice];
	}
}