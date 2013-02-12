
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;

public class SilencioRedonda extends Figura implements Dibujable
{
	private final double valor = 4.0;
	private final String nombre = "silencioRedonda";

	public SilencioRedonda(int x, int y)
	{
		super(x,y);
	}

	public double getValor()
	{
		return valor;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void dibujar(Graphics g)
	{
		g.drawImage (new ImageIcon("imagenes/silencioR.gif").getImage (),x,y-10,this);
	}
}