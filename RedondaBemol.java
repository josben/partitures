

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class RedondaBemol extends Figura implements Dibujable
{
	private final String nom = "redondaBemol";
	private final double valor = 4.0;

	public RedondaBemol(int x, int y)
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
		g.drawImage(new ImageIcon("imagenes/linux/redonda4.gif").getImage(),x+2,y-13,this);
	}
}