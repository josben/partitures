
public class MiSostenida extends NotaMusical
{
	private final int arrMiSostenida[] = {29,41,53,65,77,89,101,113}; 
	
	public MiSostenida(int pos)
	{
		super(pos);
	}
	
	public int[] getArrMiSostenida()
	{
		return arrMiSostenida;
	}
	
	public int getArrMiSostenida(int indice)
	{
		return arrMiSostenida[indice];
	}
}