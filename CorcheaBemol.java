
import java.awt.Graphics;
import javax.swing.ImageIcon;
/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class CorcheaBemol extends Figura implements Dibujable
{
	private final String nom = "corcheaBemol";
	private final double valor = 0.5;

	public CorcheaBemol(int x,int y)
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
		g.drawImage(new ImageIcon("imagenes/linux/corchea4.gif").getImage(),x-2,y-20,this);
	}
}
