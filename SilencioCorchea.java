
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;

public class SilencioCorchea extends Figura implements Dibujable
{
	private final double valor = 0.5;
	private final String nombre = "silencioCorchea";

	public SilencioCorchea(int x, int y)
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
		g.drawImage (new ImageIcon("imagenes/silencioC.gif").getImage (),x,y-10,this);
	}
}