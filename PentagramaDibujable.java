
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class PentagramaDibujable extends Container implements Dibujable
{
	private int oX;
	private int oY;
	private int dX;
	private int dY;
	private ImageIcon imagen;

	public PentagramaDibujable(int oX, int oY, int dX, int dY, ImageIcon img )//, ImageIcon img) //, int x, int y)
	{
		setSize(800,100);
		this.oX = oX;
		this.oY = oY;
		this.dX = dX;
		this.dY = dY;
		imagen = img;
	}

	public void dibujar(Graphics g)
	{
		//g.drawString("Pentagrama Musical",280,50);

		//g.drawImage (new ImageIcon("imagenes/silencioR.png").getImage (),130,28,this);
		g.setColor(Color.blue);
		g.drawLine (oX, oY, oX, oY+32);
		g.drawLine (oX+250, oY, oX+250, oY+32);//230
		g.drawLine (oX+500, oY, oX+500, oY+32);//460
		g.drawLine (oX+758, oY, dX, oY+32);//690
		
		g.setColor(Color.black);
		g.drawLine(oX, oY, dX, dY);
		g.drawLine(oX, oY+8, dX, dY+8);
		g.drawLine(oX, oY+16, dX, dY+16);
		g.drawLine(oX, oY+24, dX, dY+24);
		g.drawLine(oX, oY+32, dX, dY+32);
		
		g.drawImage (new ImageIcon("imagenes/notaDo2.png").getImage (),oX-20,30,this);
		g.drawImage (imagen.getImage (),oX+35,71,this);
		/*
		g.drawLine(oX, oY+152, dX, dY+152);
		g.drawLine(oX, oY+165, dX, dY+165);
		g.drawLine(oX, oY+178, dX, dY+178);
		g.drawLine(oX, oY+191, dX, dY+191);
		g.drawLine(oX, oY+204, dX, dY+204);
		*/
	}
	
	public ImageIcon getImagen()
	{
		return imagen;
	}

	public void setOY(int oY)
	{
		this.oY = oY;
	}

	public void setDY(int dY)
	{
		this.dY = dY;
	}
	
	public void setImagen(ImageIcon i)
	{
		imagen = i;
	}
}
