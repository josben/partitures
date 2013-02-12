
import java.awt.*;
import javax.swing.ImageIcon;
/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class SemiCorcheaPunto extends Figura implements Dibujable
{
	private final String nom = "semiCorcheaPunto";
	private final double valor = 0.375;
	
	public SemiCorcheaPunto(int x,int y)
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
		g.drawImage(new ImageIcon("imagenes/linux/semiCorchea2.gif").getImage(),x+12,y-18,this);
	}
}
