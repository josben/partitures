
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class BlancaSostenida extends Figura implements Dibujable
{
	private final String nom = "blancaSostenida";
	private final double valor = 2.0;
	
	public BlancaSostenida(int x,int y)
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
		g.drawImage(new ImageIcon("imagenes/linux/blanca3.gif").getImage(),x,y-20,this);
	}
}
