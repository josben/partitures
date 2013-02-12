
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class Corchea extends Figura implements Dibujable
{
	//private int oX;
	//private int oY;
	private final int radio = 15;
	private final String nom = "corchea";
	private final double valor = 0.5;

	public Corchea(int x,int y)
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
		//g.drawImage (new ImageIcon("imagenes/cuatro.png").getImage (),60,15,this);
		//g.fillOval(x-6, y-4, radio, radio-5);
		//g.drawLine(x+10, y+2, x+10, y-25);
		//g.drawLine(x+10, y-25, x+15, y-18);
		g.drawImage(new ImageIcon("imagenes/linux/corchea.gif").getImage(),x+12,y-20,this);
	}
	/*
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height)
	{
		//ImageIcon img = new ImageIcon("imagenes/cuatro.png").getImage();
		return true;
	}*/
}
