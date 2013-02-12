
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Indicador extends Figura implements Dibujable
{
	private ImageIcon flecha;
	private int anchoI, altoI;
	
	public Indicador(int x, int y)
	{
		super(x,y);
		
		flecha = new ImageIcon("imagenes/flecha.gif");
		anchoI = flecha.getIconWidth();
		altoI = flecha.getIconHeight();
	}
	
	public void dibujar(Graphics g)
	{
		//g.drawImage(new ImageIcon("imagenes/flecha.gif").getImage(),x,y,this);
		g.drawImage(flecha.getImage(),x,0,this);
	}
}