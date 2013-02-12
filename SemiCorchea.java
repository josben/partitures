
import java.awt.*;
import javax.swing.ImageIcon;
/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class SemiCorchea extends Figura implements Dibujable
{
	//private int oX;
	//private int oY;
	private final int radio = 15;
	private final String nom = "semiCorchea";
	private final double valor = 0.25;
	public SemiCorchea(int x,int y)
	{
		super(x,y);
	}

	/*
	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	*/
	public String getNom()
	{
		return nom;
	}
	
	public double getValor()
	{
		return valor;
	}
	/*
	public void setCoordenada(int x, int y)
	{
		oX = x;
		oY = y;
	}
	*/
	public void dibujar(Graphics g)
	{
		//g.fillOval(x-6, y-4, radio, radio-5);
		//g.drawLine(x+10, y+2, x+10, y-25);
		//g.drawLine(x+10, y-25, x+15, y-18);
		//g.drawLine(x+10, y-20, x+15, y-13);
		g.drawImage(new ImageIcon("imagenes/linux/semiCorchea.gif").getImage(),x+12,y-20,this);
	}
}
