
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Container;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;
/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class MiCursor extends Container
{
	static MiCursor aux = new MiCursor();
	
	public static Cursor getRedonda()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/gif/music_fullnote.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en Redonda = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en Redonda = "+he);
		}
		catch(Exception e)
		{
			aux.llamadaDeErrorDeCursor("REDONDA",e);
		}
		
		return cursor;
	}
	
	public static Cursor getBlanca()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/gif/music_halfnote.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en Blanca = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en Blanca = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("BLANCA",e);
		}
		
		return cursor;
	}
	
	public static Cursor getNegra()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/gif/music_quarternote.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en Negra = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en Negra = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("NEGRA",e);
		}
		
		return cursor;
	}
	
	public static Cursor getCorchea()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/gif/music_eightnote.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en Corchea = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en Corchea = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("CORCHEA",e);
		}
		
		return cursor;
	}
	
	public static Cursor getSemiCorchea()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/gif/music_sixteenthnote.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en SemiCorchea = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en SemiCorchea = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("SEMI CORCHEA",e);
		}
		
		return cursor;
	}
	
	public static Cursor getRedondaPunto()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/puntillo/redonda.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en RedondaPunto = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en RedondaPunto = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("REDONDA PUNTO",e);
		}
		
		return cursor;
	}
	
	public static Cursor getBlancaPunto()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/puntillo/blanca.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en BlancaPunto = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en BlancaPunto = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("BLANCA PUNTO",e);
		}
		
		return cursor;
	}
	
	public static Cursor getNegraPunto()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/puntillo/negra.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en NegraPunto = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en NegraPunto = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("NEGRA PUNTO",e);
		}
		
		return cursor;
	}
	
	public static Cursor getCorcheaPunto()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/puntillo/corchea.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,28),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en CorcheaPunto = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en CorcheaPunto = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("CORCHEA PUNTO",e);
		}
		
		return cursor;
	}
	
	public static Cursor getSemiCorcheaPunto()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/puntillo/semiCorchea.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en SemiCorcheaPunto = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en SemiCorcheaPunto = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("SEMI CORCHEA PUNTO",e);
		}
		
		return cursor;
	}
	
	public static Cursor getRedondaSostenida()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/sostenido/redonda.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,26),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en RedondaSostenida = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en RedondaSostenida = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("REDONDA SOSTENIDA",e);
		}
		
		return cursor;
	}
	
	public static Cursor getBlancaSostenida()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/sostenido/blanca.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,26),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en BlancaSostenida = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en BlancaSostenida = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("BLANCA SOSTENIDA",e);
		}
		
		return cursor;
	}
	
	public static Cursor getNegraSostenida()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/sostenido/negra.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,26),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en NegraSostenida = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en NegraSostenida = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("NEGRA SOSTENIDA",e);
		}
		
		return cursor;
	}
	
	public static Cursor getCorcheaSostenida()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/sostenido/corchea.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,26),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en CorcheaSostenida = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en CorcheaSostenida = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("CORCHEA SOSTENIDA",e);
		}
		
		return cursor;
	}
	
	public static Cursor getSemiCorcheaSostenida()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/sostenido/semiCorchea.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,26),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en SemiCorcheaSostenida = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en SemiCorcheaSostenida = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("SEMI CORCHEA SOSTENIDA",e);
		}
		
		return cursor;
	}
	/////////////*****************
	
	public static Cursor getRedondaBemol()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/bemol/redonda.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,26),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en RedondaBemol = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en RedondaBemol = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("REDONDA BEMOL",e);
		}
		
		return cursor;
	}
	
	public static Cursor getBlancaBemol()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/bemol/blanca.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,26),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en BlancaBemol = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en BlancaBemol = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("BLANCA BEMOL",e);
		}
		
		return cursor;
	}
	
	public static Cursor getNegraBemol()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/bemol/negra.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,26),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en NegraBemol = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en NegraBemol = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("NEGRA BEMOL",e);
		}
		
		return cursor;
	}
	
	public static Cursor getCorcheaBemol()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/bemol/corchea.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,26),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en CorcheaBemol = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en CorcheaBemol = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("CORCHEA BEMOL",e);
		}
		
		return cursor;
	}
	
	public static Cursor getSemiCorcheaBemol()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/bemol/semiCorchea.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,26),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en SemiCorcheaBemol = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en SemiCorcheaBemol = "+he);
		}
		catch ( Exception e )
		{
			aux.llamadaDeErrorDeCursor("SEMI CORCHEA BEMOL",e);
		}
		
		return cursor;
	}
	
	////////////************************
	public static Cursor getSilencioRedonda()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta = Toolkit.getDefaultToolkit();
			Image img = herramienta.getImage("imagenes/silencioR.gif");
			cursor = herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en SilencioRedonda = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en SilencioRedonda = "+he);
		}
		catch(Exception e)
		{
			aux.llamadaDeErrorDeCursor("SILENCIO REDONDA",e);
		}
		
		return cursor;
	}
	
	public static Cursor getSilencioBlanca()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta = Toolkit.getDefaultToolkit();
			Image img = herramienta.getImage("imagenes/silencioB.gif");
			cursor = herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en SilencioBlanca = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en SilencioBlanca = "+he);
		}
		catch(Exception e)
		{
			aux.llamadaDeErrorDeCursor("SILENCIO BLANCA",e);
		}
		
		return cursor;
	}
	
	public static Cursor getSilencioNegra()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/silencioN.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en SilencioNegra = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en SilencioNegra = "+he);
		}
		catch(Exception e)
		{
			aux.llamadaDeErrorDeCursor("SILENCIO NEGRA",e);
		}
		return cursor;
	}
	
	public static Cursor getSilencioCorchea()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/silencioC.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en SilencioCorchea = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en SilencioCorchea = "+he);
		}
		catch(Exception e)
		{
			aux.llamadaDeErrorDeCursor("SILENCIO CORCHEA",e);
		}
		
		return cursor;
	}
	
	public static Cursor getSilencioSemiCorchea()
	{
		Cursor cursor = null;
		try
		{
			Toolkit herramienta=Toolkit.getDefaultToolkit();
			Image img=herramienta.getImage("imagenes/silencioSC.gif");
			cursor=herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		}
		catch(IndexOutOfBoundsException io)
		{
			System.out.println("Error de IndexOutOfBoundsException en SilencioSemiCorchea = "+io);
		}
		catch(HeadlessException he)
		{
			System.out.println("Error de HeadlessException en SilencioSemiCorchea = "+he);
		}
		catch(Exception e)
		{
			aux.llamadaDeErrorDeCursor("SILENCIO SEMI-CORCHEA",e);
		}
		return cursor;
	}
	
	public static Cursor getBorrador()
	{
		Toolkit herramienta = Toolkit.getDefaultToolkit();
		Image img = herramienta.getImage("imagenes/borrador.gif");
		Cursor cursor = herramienta.createCustomCursor(img,new Point(10,29),"cursor");
		
		return cursor;
	}
	
	public static Cursor getCursorDorado()
	{
		Toolkit aux = Toolkit.getDefaultToolkit();
		Image img = aux.getImage("imagenes/cursor.gif");
		Cursor cursor = aux.createCustomCursor(img,new Point(10,10),"cursor");
		
		return cursor;
	}
	
	public void llamadaDeErrorDeCursor(String nombre, Exception e)
	{
		String dialogo = "Error en la figura "+nombre;
		JOptionPane.showMessageDialog (this,dialogo,"Error de Dibujo",JOptionPane.ERROR_MESSAGE);
	}
}