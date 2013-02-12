
import java.awt.*;
import javax.swing.ImageIcon;
/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class SemiCorcheaSostenida extends Figura implements Dibujable
{
	private final String nom = "semiCorcheaSostenida";
	private final double valor = 0.25;
	
	public SemiCorcheaSostenida(int x,int y)
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
		g.drawImage(new ImageIcon("imagenes/linux/semiCorchea3.gif").getImage(),x-2,y-20,this);
	}
}
