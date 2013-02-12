
import java.io.*;

public class CreaArchivo
{
    public static void main(String arg[])
    {
        try
        {
            FileWriter aux = new FileWriter(new File("archivoMio.txt"));
            aux.write("hola");
            aux.close();
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }
}