
import javax.swing.*;
import java.awt.*;

public class Prueba
{
	public static void main (String arg[])
	{
		JFrame aux = new JFrame("Ventana");
		JToolBar aux2 = new JToolBar();
		JButton boton = new JButton(new ImageIcon("imagenes/azul/redonda.gif"));
		boton.setRolloverEnabled (false);
		boton.setRolloverIcon (new ImageIcon("imagenes/azul/redonda2.gif"));
		aux2.add (boton);
		aux.getContentPane().setLayout(new BorderLayout());
		aux.setSize(600,200);
		aux.getContentPane ().add (aux2);
		//aux.getContentPane().add(new Instrumento(), BorderLayout.NORTH);
		aux.show();
	}
}