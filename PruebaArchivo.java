
import java.io.*;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class PruebaArchivo
{
	public static void main(String arg[])
	{
		int dia = 0,mes = 0,año = 0;
		try
		{
			//FileInputStream arch = new FileInputStream(new File("musica.txt"));
			BufferedReader a = new BufferedReader(new FileReader("archivo.txt"));
			int c;
			String line;// = a.readLine();
			
			while((line = a.readLine()) != null)
			{
				int auxDia = line.indexOf(",", 0);
        		dia = Integer.parseInt(line.substring(0, auxDia));
        		
        		int auxMes = line.indexOf(",", auxDia + 1);
        		mes = Integer.parseInt(line.substring(auxDia+1, auxMes));
        		
        		int auxAño = line.indexOf(",", auxMes + 1);
        		año = Integer.parseInt(line.substring(auxMes+1, auxAño));
        		System.out.println("entro");
			}
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
		
		System.out.println("dia= "+dia);
		System.out.println("mes= "+mes);
		System.out.println("año= "+año);
	}
}