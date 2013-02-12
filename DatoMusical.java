
/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class DatoMusical
{
	private int x;
	private int y;
	private String nom;
	private NotaMusical not;
	
	public DatoMusical(int x,int y,String nom)//,NotaMusical n)
	{
		this.x = x;
		this.y = y;
		this.nom = nom;
		verNombre();
	}
	
	public String toString()
	{
		return "X= "+x+", Y= "+y+" Nom= "+nom;
	}
	
	public String guardar()
	{
		return x+","+y+","+nom+":";
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public NotaMusical getNota()
	{
		return not;
	}
	
	public void verNombre()
	{
		if ( nom.equalsIgnoreCase("redondaSostenida") || nom.equalsIgnoreCase("blancaSostenida")
				|| nom.equalsIgnoreCase("negraSostenida") || nom.equalsIgnoreCase("corcheaSostenida")
				|| nom.equalsIgnoreCase("semiCorcheaSostenida") )
		{
			verificarSostenidos();
		}
		else
		{
			if ( nom.equalsIgnoreCase ("redondaBemol") || nom.equalsIgnoreCase ("blancaBemol")
					|| nom.equalsIgnoreCase ("negraBemol") || nom.equalsIgnoreCase ("corcheaBemol")
					|| nom.equalsIgnoreCase ("semiCorcheaBemol") )
			{
				verificarBemoles();
			}
			else
			{
				verificarNotaMusical();
			}
		}
	}
	
	public void verificarSostenidos()
	{
		if ( y == 16 )
		{
			not = new MiSostenida(y);
		}
		
		if ( y == 20 )
		{
			not = new ReSostenida(y);
		}
		
		if ( y == 24 )
		{
			not = new DoSostenida(y);
		}
		
		if ( y == 28 )
		{
			not = new SiSostenida(y);
		}
		
		if ( y == 32 )
		{
			not = new LaSostenida(y);
		}
		
		if ( y == 36 )
		{
			not = new SolSostenida(y);
		}
		
		if ( y == 40 )
		{
			not = new FaSostenida(y);
		}
		
		if ( y == 44 )
		{
			not = new MiSostenida(y);
		}
		
		if ( y == 48 )
		{
			not = new ReSostenida(y);
		}
		
		if ( y == 52 )
		{
			not = new DoSostenida(y);
		}
		
		if ( y == 56 )
		{
			not = new SiSostenida(y);
		}
		
		if ( y == 60 )
		{
			not = new LaSostenida(y);
		}
		
		if ( y == 64 )
		{
			not = new SolSostenida(y);
		}
		
		if ( y == 68 )
		{
			not = new FaSostenida(y);
		}
		
		if ( y == 72 )
		{
			not = new MiSostenida(y);
		}
		
		if ( y == 76 )
		{
			not = new ReSostenida(y);
		}
		
		if ( y == 80 )
		{
			not = new DoSostenida(y);
		}
		
		if ( y == 84 )
		{
			not = new SiSostenida(y);
		}
		
		if ( y == 88 )
		{
			not = new LaSostenida(y);
		}
		
		if ( y == 92 )
		{
			not = new SolSostenida(y);
		}
		
		if ( y == 96 )
		{
			not = new FaSostenida(y);
		}
		
		if ( y == 100 )
		{
			not = new MiSostenida(y);
		}
		
		if ( y == 104 )
		{
			not = new ReSostenida(y);
		}
		
		if ( y == 108 )
		{
			not = new DoSostenida(y);
		}
		
		if ( y == 112 )
		{
			not = new SiSostenida(y);
		}
		
		if ( y == 116 )
		{
			not = new LaSostenida(y);
		}
		
		if ( y == 120 )
		{
			not = new SolSostenida(y);
		}
		
		if ( y == 124 )
		{
			not = new FaSostenida(y);
		}
		
		if ( y == 128 )
		{
			not = new MiSostenida(y);
		}
		
		if ( y == 132 )
		{
			not = new ReSostenida(y);
		}
		
		if ( y == 136 )
		{
			not = new DoSostenida(y);
		}
		
		if ( y == 140 )
		{
			not = new SiSostenida(y);
		}
		
		if ( y == 144 )
		{
			not = new LaSostenida(y);
		}
		
		if ( y == 148)
		{
			not = new SolSostenida(y);
		}
	}
	
	public void verificarBemoles()
	{
		if ( y == 16 )
		{
			not = new MiBemol(y);
		}
		
		if ( y == 20 )
		{
			not = new ReBemol(y);
		}
		
		if ( y == 24 )
		{
			not = new DoBemol(y);
		}
		
		if ( y == 28 )
		{
			not = new SiBemol(y);
		}
		
		if ( y == 32 )
		{
			not = new LaBemol(y);
		}
		
		if ( y == 36 )
		{
			not = new SolBemol(y);
		}
		
		if ( y == 40 )
		{
			not = new FaBemol(y);
		}
		
		if ( y == 44 )
		{
			not = new MiBemol(y);
		}
		
		if ( y == 48 )
		{
			not = new ReBemol(y);
		}
		
		if ( y == 52 )
		{
			not = new DoBemol(y);
		}
		
		if ( y == 56 )
		{
			not = new SiBemol(y);
		}
		
		if ( y == 60 )
		{
			not = new LaBemol(y);
		}
		
		if ( y == 64 )
		{
			not = new SolBemol(y);
		}
		
		if ( y == 68 )
		{
			not = new FaBemol(y);
		}
		
		if ( y == 72 )
		{
			not = new MiBemol(y);
		}
		
		if ( y == 76 )
		{
			not = new ReBemol(y);
		}
		
		if ( y == 80 )
		{
			not = new DoBemol(y);
		}
		
		if ( y == 84 )
		{
			not = new SiBemol(y);
		}
		
		if ( y == 88 )
		{
			not = new LaBemol(y);
		}
		
		if ( y == 92 )
		{
			not = new SolBemol(y);
		}
		
		if ( y == 96 )
		{
			not = new FaBemol(y);
		}
		
		if ( y == 100 )
		{
			not = new MiBemol(y);
		}
		
		if ( y == 104 )
		{
			not = new ReBemol(y);
		}
		
		if ( y == 108 )
		{
			not = new DoBemol(y);
		}
		
		if ( y == 112 )
		{
			not = new SiBemol(y);
		}
		
		if ( y == 116 )
		{
			not = new LaBemol(y);
		}
		
		if ( y == 120 )
		{
			not = new SolBemol(y);
		}
		
		if ( y == 124 )
		{
			not = new FaBemol(y);
		}
		
		if ( y == 128 )
		{
			not = new MiBemol(y);
		}
		
		if ( y == 132 )
		{
			not = new ReBemol(y);
		}
		
		if ( y == 136 )
		{
			not = new DoBemol(y);
		}
		
		if ( y == 140 )
		{
			not = new SiBemol(y);
		}
		
		if ( y == 144 )
		{
			not = new LaBemol(y);
		}
		
		if ( y == 148)
		{
			not = new SolBemol(y);
		}
	}
	
	public void verificarNotaMusical()
	{	
		if ( y == 16 )
		{
			not = new Mi(y);
		}
		
		if ( y == 20 )
		{
			not = new Re(y);
		}
		
		if ( y == 24 )
		{
			not = new Do(y);
		}
		
		if ( y == 28 )
		{
			not = new Si(y);
		}
		
		if ( y == 32 )
		{
			not = new La(y);
		}
		
		if ( y == 36 )
		{
			not = new Sol(y);
		}
		
		if ( y == 40 )
		{
			not = new Fa(y);
		}
		
		if ( y == 44 )
		{
			not = new Mi(y);
		}
		
		if ( y == 48 )
		{
			not = new Re(y);
		}
		
		if ( y == 52 )
		{
			not = new Do(y);
		}
		
		if ( y == 56 )
		{
			not = new Si(y);
		}
		
		if ( y == 60 )
		{
			not = new La(y);
		}
		
		if ( y == 64 )
		{
			not = new Sol(y);
		}
		
		if ( y == 68 )
		{
			not = new Fa(y);
		}
		
		if ( y == 72 )
		{
			not = new Mi(y);
		}
		
		if ( y == 76 )
		{
			not = new Re(y);
		}
		
		if ( y == 80 )
		{
			not = new Do(y);
		}
		
		if ( y == 84 )
		{
			not = new Si(y);
		}
		
		if ( y == 88 )
		{
			not = new La(y);
		}
		
		if ( y == 92 )
		{
			not = new Sol(y);
		}
		
		if ( y == 96 )
		{
			not = new Fa(y);
		}
		
		if ( y == 100 )
		{
			not = new Mi(y);
		}
		
		if ( y == 104 )
		{
			not = new Re(y);
		}
		
		if ( y == 108 )
		{
			not = new Do(y);
		}
		
		if ( y == 112 )
		{
			not = new Si(y);
		}
		
		if ( y == 116 )
		{
			not = new La(y);
		}
		
		if ( y == 120 )
		{
			not = new Sol(y);
		}
		
		if ( y == 124 )
		{
			not = new Fa(y);
		}
		
		if ( y == 128 )
		{
			not = new Mi(y);
		}
		
		if ( y == 132 )
		{
			not = new Re(y);
		}
		
		if ( y == 136 )
		{
			not = new Do(y);
		}
		
		if ( y == 140 )
		{
			not = new Si(y);
		}
		
		if ( y == 144 )
		{
			not = new La(y);
		}
		
		if ( y == 148)
		{
			not = new Sol(y);
		}
	}
}