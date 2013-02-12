
public class LaSostenida extends NotaMusical
{
	private final int arrLaSostenida[] = {34,46,58,70,82,94,106,118}; 
	
	public LaSostenida(int pos)
	{
		super(pos);
	}
	
	public int[] getArrLaSostenida()
	{
		return arrLaSostenida;
	}
	
	public int getArrLaSostenida(int indice)
	{
		return arrLaSostenida[indice];
	}
}