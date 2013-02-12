import java.awt.Graphics;
import javax.swing.ImageIcon;

public class RedondaPunto extends Figura implements Dibujable
{
	private final String nom = "redondaPunto";
	private final double valor = 6.0;

	public RedondaPunto(int x, int y)
	{
		super(x, y);
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
		g.drawImage(new ImageIcon("imagenes/linux/redonda2.gif").getImage(),x-6,y-7,this);
	}
}