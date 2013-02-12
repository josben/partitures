
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;

public class SilencioBlanca extends Figura implements Dibujable
{
	private final double valor = 2.0;
	private final String nombre = "silencioBlanca";

	public SilencioBlanca(int x, int y)
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
		g.drawImage (new ImageIcon("imagenes/silencioB.gif").getImage (),x,y-13,this);
	}
}