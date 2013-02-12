
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class RedondaSostenida extends Figura implements Dibujable
{
	private final String nom = "redondaSostenida";
	private final double valor = 4.0;

	public RedondaSostenida(int x, int y)
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
		g.drawImage(new ImageIcon("imagenes/linux/redonda3.gif").getImage(),x,y-13,this);
	}
}