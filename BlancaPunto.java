
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class BlancaPunto extends Figura implements Dibujable
{
	private final String nom = "blancaPunto";
	private final double valor = 3.0;
	
	public BlancaPunto(int x,int y)
	{
		super(x,y);
	}
	
	public String getNom()
	{
		return nom;
	}

	public double getValor()
	{
		return valor;
	}

	public void dibujar(Graphics g)
	{
		g.drawImage(new ImageIcon("imagenes/linux/blanca2.gif").getImage(),x+12,y-18,this);
	}
}
