
import java.awt.Graphics;
import java.awt.Color;

public class PentagramaAuxiliar implements Dibujable
{
	private int oX,oY,dX,dY;
	
	public PentagramaAuxiliar(int ox, int oy, int dx, int dy)
	{
		oX = ox;
		oY = oy;
		dX = dx;
		dY = dy;
	}
	
	public void dibujar(Graphics g)
	{
		g.setColor(Color.blue);
		g.drawLine(oX,oY-8,dX,dY-8);
		g.drawLine(oX,oY-16,dX,dY-16);
		g.drawLine(oX,oY-24,dX,dY-24);
		g.drawLine(oX,oY-32,dX,dY-32);
		g.drawLine(oX,oY-40,dX,dY-40);
		g.drawLine(oX,oY-48,dX,dY-48);
		
		g.drawLine (oX, oY, oX, oY-48);
		g.drawLine (oX+250, oY, oX+250, oY-48);
		g.drawLine (oX+500, oY, oX+500, oY-48);
		g.drawLine (oX+758, oY, dX, oY-48);
	}
}