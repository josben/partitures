
import java.awt.*;
import javax.swing.ImageIcon;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class Redonda extends Figura implements Dibujable
{
	//private int oX;
	//private int oY;
	private final int radio = 15;
	private final String nom = "redonda";
	private final double valor = 4.0;

	public Redonda(int x, int y)
	{
		super(x, y);
	}

	/*
	public int getX()
	{
		return oX;
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
		//g.drawArc(oX,oY,radio-5,radio,0,360);
		//g.drawOval(x-6, y-4, radio, radio-5);
		g.drawImage(new ImageIcon("imagenes/linux/redonda.gif").getImage(),x+9,y-7,this);
	}
}
