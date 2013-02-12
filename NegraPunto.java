
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class NegraPunto extends Figura implements Dibujable
{
	private final String nom = "negraPunto";
	private final double valor = 1.5;

	public NegraPunto(int x,int y)
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
		g.drawImage(new ImageIcon("imagenes/linux/negra2.gif").getImage(),x+12,y-18,this);
	}
}
