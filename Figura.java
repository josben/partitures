
import java.awt.*;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public abstract class Figura extends Container
{
	protected int x;
	protected int y;

	public Figura(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}


	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public void setCoordenada(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Point getCoordenada()
	{
		return new Point(x,y);
	}

	/*
	public Figura()
	{
		oX = 0;
		oY = 0;
	}
	*/
}
