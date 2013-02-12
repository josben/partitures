
import javax.swing.*;
import java.awt.*;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class Presentacion extends JWindow
{
	private ImageIcon img;

	public Presentacion()
	{
		img = new ImageIcon("imagenes/HB_MAN.GIF");

		JLabel label = new JLabel(img);

		label.setBackground(Color.black);

		getContentPane().add(label);
		pack();
		show();
	}
}
