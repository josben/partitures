
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;

public class SilencioNegra extends Figura implements Dibujable
{
	private final double valor = 1.0;
	private final String nombre = "silencioNegra";

	public SilencioNegra(int x, int y)
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
		g.drawImage (new ImageIcon("imagenes/silencioN.gif").getImage (),x,y-10,this);
	}
}