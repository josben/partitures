
import java.awt.Graphics;
import javax.swing.ImageIcon;
/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class CorcheaPunto extends Figura implements Dibujable
{
	private final String nom = "corcheaPunto";
	private final double valor = 0.75;

	public CorcheaPunto(int x,int y)
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
		g.drawImage(new ImageIcon("imagenes/linux/corchea2.gif").getImage(),x+12,y-18,this);
	}
}
