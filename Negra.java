
import java.awt.*;
import javax.swing.ImageIcon;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class Negra extends Figura implements Dibujable
{
	//private int oX;
	//private int oY;
	private final int radio = 15;
	private final String nom = "negra";
	private final double valor = 1.0;

	public Negra(int x,int y)
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
		g.drawImage(new ImageIcon("imagenes/linux/negra.gif").getImage(),x+10,y-20,this);
	}
}
