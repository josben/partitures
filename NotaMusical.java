
public abstract class NotaMusical
{
	private int posPentagrama;
	
	public NotaMusical(int pos)
	{
		posPentagrama = pos;
	}
	
	public void setPosPentagrama(int pos)
	{
		posPentagrama = pos;
	}
	
	public int getPosPentagrama()
	{
		return posPentagrama;
	}
}