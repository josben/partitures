
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;

public class SilencioSemiCorchea extends Figura implements Dibujable
{
	private final double valor = 0.25;
	private final String nombre = "silencioSemiCorchea";

	public SilencioSemiCorchea(int x, int y)
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
		g.drawImage (new ImageIcon("imagenes/silencioSC.gif").getImage (),x,y-10,this);
	}
}