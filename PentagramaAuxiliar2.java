
import java.awt.Graphics;
import java.awt.Color;

public class PentagramaAuxiliar2 implements Dibujable
{
	private int oX,oY,dX,dY;
	
	public PentagramaAuxiliar2(int ox, int oy, int dx, int dy)
	{
		oX = ox;
		oY = oy;
		dX = dx;
		dY = dy;
	}
	
	public void dibujar(Graphics g)
	{
		g.setColor(Color.blue);
		g.drawLine(oX,oY+40,dX,dY+40);
		g.drawLine(oX,oY+48,dX,dY+48);
		g.drawLine(oX,oY+56,dX,dY+56);
		g.drawLine(oX,oY+64,dX,dY+64);
		g.drawLine(oX,oY+72,dX,dY+72);
		g.drawLine(oX,oY+80,dX,dY+80);
		
		g.drawLine (oX, oY, oX, oY+80);
		g.drawLine (oX+250, oY, oX+250, oY+80);
		g.drawLine (oX+500, oY, oX+500, oY+80);
		g.drawLine (oX+758, oY, dX, oY+80);
	}
}