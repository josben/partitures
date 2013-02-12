
import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import java.io.FileInputStream;
import java.io.IOException;
//import com.digitprop.tonic.*;

/**
 * @author Jose Benjamin Perez Soto
 * @version 0.0.0.0.0.14.14;
 */

public class Principal
{
	/**
	 * Este metodo nos sirve para ejecutar el programa,
	 * y se cogen todos las posibles excepciones.
	 */
	public static void main(String arg[])
	{
		try
		{
			//JDialog.setDefaultLookAndFeelDecorated(true);
			//JFrame.setDefaultLookAndFeelDecorated(true);
		}
		catch ( IllegalArgumentException ia )
		{
			System.err.println("Error en principal en Decoracion = "+ia);
		}
		catch ( Exception e )
		{
			System.out.println("Ocurrio una excepcion general = "+e );
		}
		
		try
		{
			Toolkit.getDefaultToolkit().setDynamicLayout(true);
		}
		catch ( AWTError awt )
		{
			System.out.println("Un Toolkit no funciona "+awt);
		}
		catch ( HeadlessException he )
		{
			System.out.println("Si ocurre un error en los graficos "+he );
		}
		catch ( Exception e )
		{
			System.out.println("Ocurrio una excepcion general = "+e );
		}
		
		try
		{
			System.setProperty("sun.awt.noerasebackground","true");
		}
		catch ( SecurityException se )
		{
			System.out.println( "No existe el metodo especificado = "+se );
		}
		catch ( NullPointerException npe )
		{
			System.out.println ( "Ocurrio un acceso nulo = "+npe );
		}
		catch ( IllegalArgumentException iae )
		{
			System.out.println ( "El acceso esta vacio = "+iae );
		}
		catch ( Exception e )
		{
			System.out.println("Ocurrio una excepcion general = "+e );
		}
		
		try
		{
            //javax.swing.plaf.metal.MetalLookAndFeel.setCurrentTheme( new javax.swing.plaf.metal.DefaultMetalTheme());
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            //UIManager.setLookAndFeel(new TonicLookAndFeel());
            //UIManager.setLookAndFeel("com.teknolust.plaf.teknolust.TeknolustLookAndFeel");
        }  
        catch ( UnsupportedLookAndFeelException e )
        {
            System.out.println ("Esta plataforma no soporta este Metal Look & Feel. \nFin de la ejecucion");
            System.exit(0);
        }
        /*
        catch ( IllegalAccessException e )
        {
            System.out.println ("Metal Look & Feel nose puede tener acceso. \nPrograma se cerro.");
            System.exit(0);
        }
        catch ( ClassNotFoundException e )
        {
            System.out.println ("Metal Look & Feel no puede ser ejecutado. \nPrograma se cerro.");
            System.exit(0);
        }   
        catch ( InstantiationException e )
        {
            System.out.println ("Metal Look & Feel no puede ser instanciado. \nPrograma se cerro");
            System.exit(0);
        }
        */
        catch ( Exception e )
        {
            System.out.println ("Unexpected error. \nPrograma se cerrara");
            e.printStackTrace();
            System.exit(0);
        }
		try
		{
			// se llama a la clase Pentagrama para levantar las ventanas.
			Pentagrama penta = new Pentagrama();
			penta.setVisible(true);
		}
		catch(Exception e)
		{
			System.err.println("Error en el Principal = "+e);
		}
	} // fin del main
}
