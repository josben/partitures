
import java.awt.*;
import javax.swing.ImageIcon;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class Blanca extends Figura implements Dibujable
{
	//private int oX;
	//private int oY;
	private final String nom = "Blanca";
	private final int radio = 15;
	private final double valor = 2.0;
	public Blanca(int x,int y)
	{
		super(x,y);
	}
	/*
	public int getX()
	{
		return oX;
	}

	public int getY()
	{
		return oY;
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

	//public Blanca() { }
	/*
	public void setCoordenada(int x, int y)
	{
		oX = x;
		oY = y;
	}
	*/
	public void dibujar(Graphics g)
	{
		//g.drawOval(x-6, y-4, radio, radio-5);
		//g.drawLine(x+10, y+2, x+10, y-25);
		g.drawImage(new ImageIcon("imagenes/linux/blanca.gif").getImage(),x+9,y-20,this);
	}
}
