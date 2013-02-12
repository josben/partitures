
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import javax.swing.border.*;
import java.awt.print.Printable;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.*;
import java.text.SimpleDateFormat;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import java.io.*;
import java.net.MalformedURLException;

/**
 * @author Jose Benjamin Perez Soto
 * @version 0.0.0.0.0.14.14;
 */

public class Pentagrama extends JFrame implements ActionListener, ControlPantalla, ChangeListener, Printable, FocusListener
{
	private LinkedList ventanas = new LinkedList();
	private JScrollPane sp[] = new JScrollPane[10];
	private Font fondos = new Font("serif", Font.PLAIN, 12);
	private JPanel panelInicio;
	private JRadioButton nuevoDoc, antDoc;
	private JButton acep,cancel, ayuda, dir;
	
	private Raton raton;
	private JPanel panel, panelBar;
	
	private JMenuBar menu;
	private Mi_PanelControl control;
	
	private JTabbedPane tp = new JTabbedPane(JTabbedPane.SCROLL_TAB_LAYOUT);
	
	private int cant = 1;
	private JButton b1,b2,b3,b4,b5,b6,b7;
	private int contador = 0;
	private static int index = 0;
	
	private JButton bp1, bp2,bp3,bp4,bp5,bp7,bp8;
	private static JButton bp6,record;
	private JButton añadir,quitar;
	
	private static AdministradorVentanas adm[] = new AdministradorVentanas[10];
	
	private boolean itemNuevo = false, itemAntiguo = false;
	
	private JPanel miPanel;
	
	private FiltroDeArchivo filtro;
	private IconoDeArchivo iconoArch;
	private ImageIcon imagen;
	private JLabel label;
	private JComboBox box,box2;
	private Date dato;
	private MetalTheme selectedTheme;
	private JLabel fondo;
	private static int niv = 0;
	private JPanel panelVentanas[] = new JPanel[10];
	private Border compound;
	private static Instrumento instrumentoTabla[] = new Instrumento[10];
	private JButton verInstrumento;
	double val;
	ImageIcon im;
	private JWindow window;
	private JProgressBar progresoBar;
	private JLabel progresoLabel; 
	private JFrame jframe;
	private JDialog instrument,fram;
	public static final String AYUDA_EDITOR = "ayuda/inicio.html";
	private VisorAyuda help;
	
	private static final int CERRAR = 1;
	private static final int ERROR_OPTION = -1;
	private int retornarValor = ERROR_OPTION;
	private static JRadioButtonMenuItem arrVentana[] = new JRadioButtonMenuItem[10];
	private JMenu juntar;
	private static int contVentanas = 0;
	private static boolean stop = false;
	private boolean bandera = false;
	private static JMenuItem rec, play;
	private JDesktopPane desktop;
	private JDialog di;
	private boolean mensaje;
	private static JButton vi;
	private String nomArch;
	
	public Pentagrama(int o)
	{
		
	}
	
	public Pentagrama()
	{
		mostrarProgreso();
		try
		{
			progresoBar.setMaximum(13);
			progresoLabel.setText("Cargando panel de ventanas...");
			panelVentanas[contador] = new JPanel(new BorderLayout());
			progresoBar.setValue(progresoBar.getValue()+1);
			progresoLabel.setText("Cargando Administrador de Ventanas...");
			adm[contador] = new AdministradorVentanas(new ImageIcon("imagenes/cuatro2.gif"),4.0);
			progresoBar.setValue(progresoBar.getValue()+1);
			progresoLabel.setText("Cargando contenedor de Paneles...");
			panel = new JPanel(); // 8/09/2003
			progresoBar.setValue(progresoBar.getValue()+1);
			progresoLabel.setText("Cargando Instrumentos...");
			instrumentoTabla[contador] = new Instrumento(this);
			progresoBar.setValue(progresoBar.getValue()+1);
			progresoLabel.setText("Cargando ScrollPane...");
			sp[contador] = new JScrollPane();
			progresoBar.setValue(progresoBar.getValue()+1);
			progresoLabel.setText("Cargando Panel de Control...");
			control = new Mi_PanelControl();
			progresoBar.setValue(progresoBar.getValue()+1);
			
			progresoLabel.setText("Cargando visor de Ayuda...");
			label = new JLabel("Para recibir ayuda, presione F1");
			label.setFont(fondos);
			progresoBar.setValue(progresoBar.getValue()+1);
			progresoLabel.setText("Cargando filtros...");
			filtro = new FiltroDeArchivo("info", "info archifo de musica");
			iconoArch = new IconoDeArchivo();
			iconoArch.putIcon("info", new ImageIcon("imagenes/knotify.gif"));
			progresoBar.setValue(progresoBar.getValue()+1);
			
			progresoLabel.setText("Carga de componentes de ventana...");
			desktop = new JDesktopPane();
			
			getContentPane().setLayout(new BorderLayout());
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			
			int w = 760;
			int h = 470;
			setLocation(screenSize.width/2 - w/2, screenSize.height/2 - h/2);
			setSize(w, h);
			
			fondo = new JLabel(new ImageIcon("imagenes/Fondo3.jpg"));
			tp.setFont(new Font("serif", Font.PLAIN, 12));
			
			setIconImage((new ImageIcon("imagenes/kmidi.gif")).getImage());
			setTitle("Editor de Partituras");
			raton = new Raton();
			this.addFocusListener (this);
			
			Border raisedBevel = BorderFactory.createRaisedBevelBorder();
			Border loweredBevel = BorderFactory.createLoweredBevelBorder();
			compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
			
			panelVentanas[contador].addMouseListener(raton);
			
			progresoBar.setValue(progresoBar.getValue()+1);
			progresoLabel.setText("Cargando componentes de los Paneles...");
			vi = new JButton("Ver Instrumentos"); /// Crea el boton de instrumentos del
			adm[contador].getPanel (0).addMouseListener (new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Para recibir ayuda, presione F1");
				}
			});
			
			tp.setTabPlacement(JTabbedPane.BOTTOM);
			tp.addChangeListener(this);
			
			
			panel.setLayout (new BorderLayout());
			panelVentanas[contador].setBorder(compound);
			panelVentanas[contador].add(adm[contador], BorderLayout.CENTER);
			sp[contador].setViewportView(panelVentanas[contador]);
			ventanas.add(panelVentanas[contador]); // añade un panel al vector
			imagen = new ImageIcon("imagenes/knotify.gif");
			cant++;
			tp.addTab("Melodia",imagen,sp[contador],"Melodia"+(cant-1));
			tp.addMouseListener (new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Para recibir ayuda, presione F1");
				}
			});
			
			menu = crearMenu();
			progresoBar.setValue(progresoBar.getValue()+1);
			progresoLabel.setText("Cargando eventos de Raton...");
			
			control.getBotonRedonda ().addMouseListener (new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Nota Musical Redonda");
				}
			});
			
			control.getBotonBlanca ().addMouseListener (new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Nota Musical Blanca");
				}
			});
			
			control.getBotonNegra ().addMouseListener (new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Nota Musical Negra");
				}
			});
			
			control.getBotonCorchea ().addMouseListener (new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Nota Musical Corchea");
				}
			});
			
			control.getBotonSCorchea ().addMouseListener (new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Nota Musical Semi Corchea");
				}
			});
			
			control.getBotonSilencioRedonda().addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Nota Musical Silencio Redonda");
				}
			});
			
			control.getBotonSilencioBlanca().addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Nota Musical Silencio Blanca");
				}
			});
			
			control.getBotonSilencioNegra().addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Nota Musical Silencio Negra");
				}
			});
			
			control.getBotonSilencioCorchea().addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Nota Musical Silencio Corchea");
				}
			});
			
			control.getBotonSilencioSemiCorchea().addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Nota Musical Silencio Semi Corchea");
				}
			});
			
			setJMenuBar(menu);
			crearBar();
			
			
			label.setAlignmentX(LEFT_ALIGNMENT);
			label.setBorder(compound);
			panel.add (tp, BorderLayout.CENTER); // 8/09/2003
			panel.add (control, BorderLayout.WEST); // 806/2003
			panel.add (label, BorderLayout.SOUTH);
			panel.addMouseListener (new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Para recibir ayuda, presione F1");
				}
			});
			
			getContentPane().add (panel, BorderLayout.CENTER); // 8/09/2003
			
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
			progresoBar.setValue(progresoBar.getValue()+1);
			progresoLabel.setText("Cargando focos...");
			
			instrumentoTabla[contador].setFocusable(false);
			panelVentanas[contador].setFocusable(true);
			adm[contador].setFocusable(true);
			control.setFocusable(true);
			label.setFocusable(true);
			tp.setFocusable(true);
			sp[contador].setFocusable(true);
			panelVentanas[contador].addFocusListener(this);
			adm[contador].addFocusListener(this);
			control.addFocusListener(this);
			label.addFocusListener(this);
			tp.addFocusListener(this);
			sp[contador].addFocusListener(this);
			Thread hilo = new Thread();
			progresoBar.setValue(progresoBar.getValue()+1);
			progresoLabel.setText("El editor esta listo y funsionando");
			progresoBar.setValue(progresoBar.getValue()+1);
			try
			{
				hilo.sleep(1500);
			}
			catch(InterruptedException inte)
			{
				System.err.println(inte);
			}
			UIManager.put("Button.margin",new Insets(0,0,0,0));
			window.setVisible(false);
			window = null;
			
			setVisible(true);
			System.out.println(getWidth()+" "+getHeight());
			UIManager.addPropertyChangeListener(new UISwitchListener((JComponent)getRootPane()));
		}
		catch(Exception e)
		{
			System.err.println("Ocurrio un error GARRAFAL = "+e);
		}
	}
	
	public void mostrarProgreso()
	{
		window = new JWindow();
		window.getContentPane().setLayout(new BorderLayout());
		//int WIDTH = 335, HEIGHT = 264;
        int WIDTH = 320, HEIGHT = 521;
        window.setSize(WIDTH, HEIGHT);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(d.width/2 - WIDTH/2, d.height/2 - HEIGHT/2);
        
		JPanel progresoPanel = new JPanel()
		{
			public Insets getInsets()
			{
				return new Insets(40,30,20,30);
			}
		};
		//JLabel la = new JLabel(new ImageIcon("imagenes/logoMio3.gif"));
		JLabel la = new JLabel(new ImageIcon("imagenes/logo01.gif"));
		progresoPanel.setLayout(new BoxLayout(progresoPanel, BoxLayout.Y_AXIS));
		window.getContentPane().add(la,BorderLayout.CENTER);
		window.getContentPane().add(progresoPanel,BorderLayout.SOUTH);
		
		Dimension labelDimension = new Dimension(400,20);
		progresoLabel = new JLabel("Cargando, porfavor espere...");
        progresoLabel.setForeground(new Color(191,210,216));
        progresoLabel.setFont(new Font("dialoginput",Font.BOLD, 12));
        progresoLabel.setAlignmentX(CENTER_ALIGNMENT);
        progresoLabel.setMaximumSize(labelDimension);
        progresoLabel.setPreferredSize(labelDimension);
        progresoPanel.setBackground(Color.black);//nuevo
        progresoPanel.add(progresoLabel);
        progresoPanel.add(Box.createRigidArea(new Dimension(1,20)));
		
        progresoBar = new JProgressBar();
        progresoBar.setBackground(Color.black);//nuevo
        progresoBar.setFont(new Font("dialoginput",Font.BOLD, 12));
        progresoBar.setStringPainted(true);
        progresoLabel.setLabelFor(progresoBar);
        progresoBar.setAlignmentX(CENTER_ALIGNMENT);
        progresoBar.setMinimum(0);
        progresoBar.setValue(0);
        progresoBar.getAccessibleContext().setAccessibleName("Progreso de carga del Editor de Partituras");
        progresoPanel.add(progresoBar);
		
        window.setVisible(true);
	}

	public void modificarLabel(String text)
	{
		dato = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("MM / dd / yy");
		String aux = formato.format(dato);
		label.setText (text+"  ( "+aux+" )");
	}

	public void llenarMiPanel()
	{
		miPanel = new JPanel();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.SOUTH;
        JLabel label = new JLabel("A Label");
        label.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
        label.setBackground (Color.white);
        gridbag.setConstraints(label, c);
        miPanel.setLayout (gridbag);
        miPanel.add(label);

        getContentPane().add (miPanel, BorderLayout.SOUTH);
	}

	public void opcionDeSalida()
	{
		int opcion = JOptionPane.showConfirmDialog (this,"desea guardar la melodia");
		if ( opcion == 1 )
		{
			System.exit (0);
		}
	}
	
	public void llamadaErrorDeInicio( String dialogo )
	{
		JOptionPane.showMessageDialog (this,dialogo,"Error de Inicio",JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Este metodo agarra los eventos de las pestañas.
	 */
	public void stateChanged(ChangeEvent e)
	{
		cerrar();
		//System.gc();
		index = tp.getSelectedIndex();
		System.out.println("El indice actual es : "+index);
		panelVentanas[index].requestFocus();
		adm[index].requestFocus();
		abrir();
	}

	public void cerrar()
	{
		//((ControlPantalla) ventanas.get(index)).cerrar();
		//ventanas.get(intdex)
	}

	public void abrir()
	{
		((JPanel)ventanas.get(index)).validate();
	}

	/*
	 *Crea un menu
	 */
	public JMenuBar crearMenu()
	{
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		JMenuBar aux = new JMenuBar();
		aux.setFont(new Font("serif", Font.PLAIN, 12));
		JMenu archivo = llenarArchivo();
		archivo.setFont(new Font("serif", Font.PLAIN, 12));
		archivo.addFocusListener (this);
		JMenu editar = llenarEditar();
		editar.setFont(new Font("serif", Font.PLAIN, 12));
		editar.addFocusListener (this);
		String motif = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		String win = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		
		String[] extras = {motif,win};
		String[] nom = {"Motif","Windows"};
		
		MetalTheme myTheme = null;
		try
		{
			myTheme =  new PropertiesMetalTheme(new FileInputStream("MyTheme.theme"));
		}
		catch (IOException e) {System.out.println(e);}
		
		// construlle un arreglo de themes.
		MetalTheme[] themes = { new DefaultMetalTheme(),
					new WhiteSatinTheme(),
					new GreenMetalTheme(),
					new AquaMetalTheme(),
					new KhakiMetalTheme(),
					new DemoMetalTheme(),
					new ContrastMetalTheme(),
					new BigContrastMetalTheme(),
	                        	myTheme };

		// pone el arrglo de thems en un menu.
		JMenu apariencia = new AparienciaMenu("Apariencia", themes, extras, nom);
		apariencia.setFont(fondos);
		apariencia.setFont(new Font("serif", Font.PLAIN, 12));
		JMenu reproducir = llenarReproducir();
		reproducir.setFont(new Font("serif", Font.PLAIN, 12));
		JMenu ayuda = llenarAyuda();
		ayuda.setFont(new Font("serif", Font.PLAIN, 12));
		ayuda.addFocusListener (this);

		archivo.setMnemonic (KeyEvent.VK_A);
		editar.setMnemonic (KeyEvent.VK_E);
		apariencia.setMnemonic(KeyEvent.VK_V);
		reproducir.setMnemonic(KeyEvent.VK_R);
		ayuda.setMnemonic (KeyEvent.VK_H);

		aux.add(archivo);
		aux.add(editar);
		aux.add(reproducir);
		aux.add(apariencia);
		aux.add(ayuda);

		return aux;
	}
	
	public JMenu llenarReproducir()
	{
		JMenu aux = new JMenu("Reproducir");
		JMenuItem parar;
		
		play = new JMenuItem("Ejecutar Melodia",new ImageIcon("imagenes/azul/play3.gif"));
		play.setFont(fondos);
		play.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				generarPlay();
			}
		});
		
		rec = new JMenuItem("Grabar Melodia",new ImageIcon("imagenes/azul/record3.gif"));
		rec.setFont(fondos);
		rec.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				generarRecord();
			}
		});
		
		parar = new JMenuItem("Detener Melodia",new ImageIcon("imagenes/azul/stop3.gif"));
		parar.setFont(fondos);
		parar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				generarStop();
			}
		});
		
		play.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7,0));
		rec.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,0));
		parar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8,0));
		aux.add(play);
		aux.add(rec);
		aux.add(parar);
		
		return aux;
	}
	
	public static void activo(boolean bool)
	{
		bp6.setEnabled(bool);
		play.setEnabled(bool);
		record.setEnabled(bool);
		rec.setEnabled(bool);
	}
	
	public void generarPlay()
	{
		stop = false;
		activo(false);
		Thread miHilo = new Thread()
		{
			public void run()
			{
				crearMusica();
			}
		};
		miHilo.start ();
	}
	
	public void generarRecord()
	{
		stop = false;
		di = new JDialog(this,"Creando Midi...", true);
		di.getContentPane().setLayout(new BorderLayout());
		JPanel pan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pan.setFont(fondos);
		JButton cerr = new JButton("Cerrar");
		vi.setFont(fondos);
		cerr.setFont(fondos);
		cerr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				generarStop();
				di.setVisible(false);
				di = null;
				instrumentoTabla[index].recordFrame = null;
			}
		});
		vi.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mostrarInstrumentos();
			}
		});
		pan.setBorder(compound);
		pan.add(vi);
		pan.add(cerr);
		instrumentoTabla[index].entradaDato(true);
		di.getContentPane().add(instrumentoTabla[index].getRecord(),BorderLayout.CENTER);
		di.getContentPane().add(pan, BorderLayout.SOUTH);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int w = 240;
		int h = 210;
		di.setLocation(d.width/2 - w/2, d.height/2 - h/2);
		di.setSize(w, h);
		di.setVisible(true);
	}
	
	public static void generarStop()
	{
		stop = true;
	}
	
	public void setMensaje(boolean m)
	{
		if ( m )
		{
			vi.setEnabled(false);
		}
		else
		{
			vi.setEnabled(true);
		}
	}

	public JMenu llenarArchivo()
	{
		JMenu aux = new JMenu("Archivo");
		//aux.setFont(new Font("serif", Font.PLAIN, 12));
		JMenuItem nuevo,abrir,guardar,configurar,imprimir,salir,otro;

		abrir = new JMenuItem("Abrir",new ImageIcon("imagenes/fileopen2.gif"));
		abrir.setFont(fondos);
		abrir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				abrirArchivo();
			}
		});

		nuevo = new JMenuItem("Nuevo",new ImageIcon("imagenes/filenew2.gif"));
		nuevo.setFont(fondos);
		nuevo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				nuevaVentana("Melodia");
			}
		});

		imprimir = new JMenuItem("Imprimir",new ImageIcon("imagenes/fileprint2.gif"));
		imprimir.setFont(fondos);
		imprimir.addActionListener (new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				adm[index].imprimir();
				//imprimirPentagrama();
			}
		});
		
		configurar = new JMenuItem("Configurar Pagina");
		configurar.setFont(fondos);
		configurar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				adm[index].configurarPagina();
			}
		});
		
		guardar = new JMenuItem("Guardar",new ImageIcon("imagenes/filesave2.gif"));
		guardar.setFont(fondos);
		guardar.addActionListener (new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				guardarArchivo();
			}
		});

		salir = new JMenuItem("Salir",new ImageIcon("imagenes/fileclose2.gif"));
		salir.setFont(fondos);
		salir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		otro = new JMenuItem("otro");
		otro.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				abrirOtro();
			}
		});

		abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,Event.CTRL_MASK));
		nuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.CTRL_MASK));
		guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,Event.CTRL_MASK));
		imprimir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,Event.CTRL_MASK));
		salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,Event.ALT_MASK));

		aux.add(nuevo);
		aux.add(abrir);
		aux.add(guardar);
		aux.addSeparator();
		aux.add(configurar);
		aux.add(imprimir);
		aux.addSeparator();
		aux.add(salir);
		//aux.add(otro);

		return aux;
	}
	
	public void abrirOtro()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(this);
	}

	public JMenu llenarEditar()
	{
		JMenu aux = new JMenu("Editar");
		juntar = new JMenu("Seleccionar Ventanas");
		juntar.setFont(fondos);
		llenarJuntar();
		JMenuItem undo;
		
		undo = new JMenuItem("Deshacer Nota");
		undo.setFont(fondos);
		undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,Event.CTRL_MASK));
		undo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					adm[index].quitarFigura(true);
				}
				catch(Exception ex)
				{
					System.err.println("Error de Menu item undo = "+ex);
				}
			}
		});
		aux.add(juntar);
		aux.add(undo);

		return aux;
	}
	
	public void llenarJuntar()
	{
		try
		{
			juntar.add( arrVentana[contVentanas++] = new JRadioButtonMenuItem("Ventana "+(contVentanas),true) );
			arrVentana[contVentanas-1].setFont(fondos);
		}
		catch(Exception e)
		{
			System.err.println("Error en JuntarVentana = "+e);
		}
	}
	
	public void accionarVentanas()
	{
		System.out.println ( "Entro a accionar musica cont = "+getContador());
		try
		{
			/*
			for ( int i = 1 ; i <= getContador() ; i++ )
			{
				if ( !arrVentana[i].isEnabled() )
				{
					//***arrVentana[i].setEnabled(true);
					//arrVentana[i].setSelected(true);
					arrVentana[i] = new JRadioButtonMenuItem("Ventana "+(getContador+1));
					contVentanas++;
					System.out.println("contador es = "+contVentanas);
				}
			}*/
			
			juntar.add( arrVentana[contVentanas++] = new JRadioButtonMenuItem("Ventana "+contVentanas,true) );
			arrVentana[contVentanas-1].setFont(fondos);
		}
		catch(Exception e)
		{
			System.err.println("Error en accionarVentanas = "+e);
		}
	}
	
	public JMenu llenarAyuda()
	{
		JMenu aux = new JMenu("Ayuda");
		JMenuItem creditos = new JMenuItem("Creditos");
		creditos.setFont(fondos);
		creditos.addActionListener (new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mensajeDeCreditos();
			}
		});
		creditos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
		
		JMenuItem manual = new JMenuItem("Manual del Editor");
		manual.setFont(fondos);
		try
		{
			manual.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ventanaDeAyuda();
				}
			});
			manual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));
		}
		catch(Exception e)
		{
			System.err.println("Error en el manual = "+e);
		}
		
		JMenuItem agra = new JMenuItem("Agradecimientos");
		agra.setFont(fondos);
		agra.addActionListener (new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mensajeDeAgradecimiento();
			}
		});
		agra.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,0));
		
		aux.add(manual);
		aux.add(creditos);
		aux.add(agra);
		return aux;
	}
	
	public void mensajeDeCreditos()
	{
		String mensaje = "Universidad Mayor de San Simon \n\n Autor : José Benjamín Pérez Soto \n\n Bajo la instruccion del : \n\n Profesor de Música ' Ovidio Gutierrez Mora ' \n\n Bajo la direccion de : \n\n Lic. Corina Flores \n\n\t Cochabamba - Bolivia";
		JOptionPane.showMessageDialog (this,mensaje,"Informacion",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensajeDeAgradecimiento()
	{
		String mensaje = " Se agradece al Profesor de Música ' Ovidio Gutierrez Mora ' \n por la instruccion que brindo en el desarrollo del programa \n Editor de Partituras Musicales. \n Y a la Licenciada Corina Flores por el seguimiento que hizo \n  durante el desarrollo del programa";
		JOptionPane.showMessageDialog (this,mensaje,"Agradecimientos",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void ventanaDeAyuda()
	{
		try
		{
			VisorAyuda help = new VisorAyuda();
			JPanel dialogo = new JPanel();
			dialogo.setLayout(new FlowLayout(FlowLayout.RIGHT));
			final JDialog dialogoAyuda = new JDialog(Pentagrama.this,"Ayuda",true);
			dialogoAyuda.getContentPane().setLayout(new BorderLayout());
			int h = 450, w = 400;
			
			dialogoAyuda.setSize(w, h);
        	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        	dialogoAyuda.setLocation(d.width/2 - w/2, d.height/2 - h/2);
			JButton cerrar = new JButton("Cerrar");
			
			dialogoAyuda.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					retornarValor = CERRAR;
				}
			});
			
			cerrar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dialogoAyuda.setVisible(false);
					//dialogoAyuda = null;
				}
			});
			dialogo.add(cerrar);
			//dialogoAyuda.setContentPane(help);
			dialogoAyuda.getContentPane().add(help,BorderLayout.CENTER);
			dialogoAyuda.getContentPane().add(dialogo,BorderLayout.SOUTH);
			dialogoAyuda.setVisible(true);
		}
		catch(Exception e)
		{
			System.err.println("Error en ventanaDeAyuda = "+e);
		}
	}

	public void crearBar()
	{
		panelBar = new JPanel();
		JPanel pan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelBar.setLayout(new FlowLayout(FlowLayout.LEFT));


		JToolBar bar = new JToolBar();
		JToolBar bar2 = new JToolBar();

		b1 = new JButton(new ImageIcon("imagenes/filenew.gif"));
		b1.setToolTipText("nuevo");
		b1.addActionListener(this);
		b1.setRolloverIcon (new ImageIcon("imagenes/buttons/b2.gif"));
		b1.addFocusListener (this);
		b1.addMouseListener (new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				modificarLabel("crear nuevo documento");
			}
		});

		b2 = new JButton(new ImageIcon("imagenes/fileopen.gif"));
		b2.setToolTipText("abrir");
		b2.addActionListener(this);
		b2.addFocusListener (this);
		b2.addMouseListener (new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				modificarLabel("abrir documento");
			}
		});

		b3 = new JButton(new ImageIcon("imagenes/filesave.gif"));
		b3.setToolTipText("guardar");
		b3.addActionListener(this);
		b3.addFocusListener (this);
		b3.addMouseListener (new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				modificarLabel("guardar documento");
			}
		});

		b4 = new JButton(new ImageIcon("imagenes/fileclose.gif"));
		b4.setToolTipText("cerrar");
		b4.addActionListener(this);
		b4.addFocusListener (this);
		b4.addMouseListener (new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				modificarLabel("cerrar editor de partituras");
			}
		});

		b5 = new JButton(new ImageIcon("imagenes/fileprint.gif"));
		b5.setToolTipText("imprimir");
		b5.addActionListener(this);
		b5.addFocusListener (this);
		b5.addMouseListener (new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				modificarLabel("imprimir pentagrama");
			}
		});
		
		b6 = new JButton(new ImageIcon("imagenes/azul/borrador.gif"));
		b6.setPressedIcon(new ImageIcon("imagenes/azul/borrador2.gif"));
		b6.setToolTipText("borrador");
		b6.addActionListener(this);
		b6.addFocusListener(this);
		b6.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				modificarLabel("borrador de notas");
			}
		});
		
		b7 = new JButton(new ImageIcon("imagenes/azul/undo.gif"));
		b7.setPressedIcon(new ImageIcon("imagenes/azul/undo2.gif"));
		b7.setToolTipText("Deshacer Nota");
		b7.addActionListener(this);
		b7.setFocusable(false);
		b7.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				modificarLabel("borrar ultima nota");
			}
		});
		
		///
		
		bp3 = new JButton(new ImageIcon("imagenes/azul/stop.gif"));
		bp3.setPressedIcon(new ImageIcon("imagenes/azul/stop2.gif"));
		bp3.setToolTipText("Detener Melodia");
		bp3.addActionListener(this);
		bp3.addMouseListener ( new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				modificarLabel("parar la musica");
			}
		});
		
		bp6 = new JButton(new ImageIcon("imagenes/azul/play.gif"));
		bp6.setPressedIcon(new ImageIcon("imagenes/azul/play2.gif"));
		bp6.setToolTipText("Ejecutar Melodia");
		bp6.addActionListener (this);
		bp6.addFocusListener (this);
		bp6.addMouseListener (new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				modificarLabel("reproducir sonido");
			}
		});

		String arr[] = {"Nivel 1","Nivel 2","Nivel 3"};
		box = new JComboBox(arr);
		box.setFont(fondos);
		box.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JComboBox cb = (JComboBox)e.getSource();
				niv = cb.getSelectedIndex();
				System.out.println (niv);
			}
		});
		box.addFocusListener (this);
		
		String arr2[] = {"Velocidad 1","Velocidad 2","Velocidad 3","Velocidad 4"};
		box2 = new JComboBox(arr2);
		box2.setFont(fondos);
		box2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JComboBox cb = (JComboBox)e.getSource();
				cambiarVelocidad(cb.getSelectedIndex());
			}
		});
		
		record = new JButton(new ImageIcon("imagenes/azul/record.gif"));
		record.setPressedIcon(new ImageIcon("imagenes/azul/record2.gif"));
		record.setToolTipText("Grabar Melodia");
		record.addActionListener(this);
		
		añadir = new JButton("add");
		añadir.setToolTipText("Añadir Pentagrama");
		añadir.addActionListener(this);
		añadir.addFocusListener(this);
		
		quitar = new JButton("quitar");
		quitar.setToolTipText("quitar Pentagrama");
		quitar.addActionListener(this);
		quitar.addFocusListener(this);
		
		verInstrumento = new JButton("Ver Instrumento");
		verInstrumento.setFont(fondos);
		verInstrumento.setToolTipText("Ver tabla de instrumentos");
		verInstrumento.setMnemonic(KeyEvent.VK_I);
		verInstrumento.addActionListener(this);
		verInstrumento.addFocusListener(this);
		
		bar2.add(bp3);
		bar2.add(bp6);
		bar2.add(record);
		
		pan.add(verInstrumento);
		pan.add(box);
		pan.add(box2);
		bar2.add(pan);

		bar.add(b1);
		bar.add(b2);
		bar.add(b3);
		bar.add(b4);
		bar.add(b5);
		//bar.add(b6);
		bar.add(b7);
		
		panelBar.add(bar);
		panelBar.add(bar2);

		getContentPane().add(panelBar, BorderLayout.NORTH);
	}
	
	public void cambiarVelocidad( int vel )
	{
		if ( vel == 0 )
		{
			instrumentoTabla[index].setVelocidad(700,900);
		}
		else
		{
			if ( vel == 1 )
			{
				instrumentoTabla[index].setVelocidad(530,730);
			}
			else
			{
				if ( vel == 2 )
				{
					instrumentoTabla[index].setVelocidad(360,560);
				}
				else
				{
					instrumentoTabla[index].setVelocidad(310,510);
				}
			}
		}
	}
	
	public void abrirAntiguoDocumento()
	{
		try
		{
			abrirArchivo();
		}
		catch ( Exception e)
		{
			System.err.println (e);
		}
	}
	
	protected synchronized void mostrarInstrumentos()
	{
		Pentagrama.this.repaint();
		try
		{
			//Thread hilo = new Thread()
			//{
				//public void run()
				//{
					instrument = new JDialog(Pentagrama.this,"Instrumentos",true);
					instrument.setCursor(new Cursor(Cursor.HAND_CURSOR));
					//final JFrame instrument = new JFrame("Tabla de Instrumentos");
					instrument.getContentPane().setLayout(new BorderLayout());
					JPanel p = new JPanel();
					p.setLayout(new FlowLayout(FlowLayout.RIGHT));
					JButton cerrar = new JButton("Cerrar");
					cerrar.setFont(fondos);
					cerrar.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							instrument.setVisible(false);
							instrument = null;
						}
					});
					p.add(cerrar);
					
					if ( instrumentoTabla[index] != null )
					{
						//instrumentoTabla[index] = new Instrumento(Pentagrama.this);
						instrumentoTabla[index].setBorder(compound);
						instrument.getContentPane().add(instrumentoTabla[index], BorderLayout.CENTER);
						instrument.getContentPane().add(p,BorderLayout.SOUTH);
						
						Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						int w = 650;
						int h = 250;
						instrument.setLocation(screenSize.width/2 - w/2, screenSize.height/2 - h/2);
						instrument.setSize(w, h);
				
						instrument.setVisible(true);
					}
					else
					{
						System.out.println("Error de cargar instrumentos");
					}
				//}
			//};
			//hilo.start();
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		Object o = e.getSource();
		
		if ( o == verInstrumento )
		{
			mostrarInstrumentos();
			/*

			final JFrame instrument = new JFrame("Tabla de Instrumentos");
			instrument.getContentPane().setLayout(new BorderLayout());
			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.RIGHT));
			JButton cerrar = new JButton("Cerrar");
			cerrar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					instrument.setVisible(false);
				}
			});
			p.add(cerrar);
			
			if ( instrumentoTabla[index] != null )
			{
				instrumentoTabla[index].setBorder(compound);
				instrument.getContentPane().add(instrumentoTabla[index], BorderLayout.CENTER);
				instrument.getContentPane().add(p,BorderLayout.SOUTH);
				
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int w = 650;
				int h = 250;
				instrument.setLocation(screenSize.width/2 - w/2, screenSize.height/2 - h/2);
				instrument.setSize(w, h);
				
				instrument.setVisible(true);
			}
			else
			{
				System.out.println("Error de cargar instrumentos");
			}
			*/
		}
		if(o == b1)
		{
			nuevaVentana("Melodia");
		}

		if(o == b2)
		{
			abrirArchivo();
		}

		if(o == b3)
		{
			guardarArchivo();
		}

		if(o == b4)
		{
			/*
			try
			{
				for( int i = 0 ; i > tp.getTabCount() ; i++ )
				{
					if (adm[i].getArchivo (i).getCola ().vacia ())
					{
						tp.removeTabAt (i);
						ventanas.remove(i);
						adm[i] = null;
						index--;
					}
					else
					{
						try
						{
							int opcion = JOptionPane.showConfirmDialog (this,"desea guardar la melodia # "+(i+1));
							if(opcion == 0)
							{
								guardarArchivo();
								tp.removeTabAt (i);
								ventanas.remove(i);
								adm[i] = null;
								index--;
								System.out.println ("entro a guardar el"+(i+1));
							}
							else
							{
								if(opcion == 1)
								{
									tp.removeTabAt (i);
									ventanas.remove(i);
									adm[i] = null;
									index--;
									System.out.println ("no guardo el "+(i+1));
								}
								else
								{
									tp.setVisible (true);
									System.out.println ("selecciono cancelar");
									return;
								}
							}
						}
						catch(Exception pop)
						{
							System.err.println ("Error en el metodo"+pop);
						}
					}
				}
			}
			catch(Exception p)
			{
				System.err.println ("Error en el for"+p);
			}*/
			cerrarEditor();
			//System.exit(0);
		}

		if(o == b5)
		{
			adm[index].imprimir();
			//imprimirPentagrama();
		}
		
		if ( o == b6 )
		{
			//adm[index].setFigura("borrador");
		}
		
		if ( o == b7 )
		{
			try
			{
				adm[index].quitarFigura(true);
			}
			catch(Exception ex)
			{
				System.err.println("Error del boton 7 = "+ex);
			}
		}

		if ( o == bp6 )
		{
			generarPlay();
			//bp6.setEnabled(false);
		}
		
		if ( o == record )
		{
			//Instrumento.RecordFrame fram = instrumentoTabla[index].new RecordFrame();
			/*
			if ( instrumentoTabla[index].recordFrame != null )
			{
				instrumentoTabla[index].recordFrame.toFront();
			}
			else
			{
				instrumentoTabla[index].recordFrame = instrumentoTabla[index].new RecordFrame();
			}*/
			generarRecord();
			//instrumentoTabla[index].entradaDato(true);
			//crearMusica();
		}
		
		if ( o == bp3 )
		{
			generarStop();
		}
	}
	
	public void cerrarEditor()
	{
		String s1 = "Cerrar";
		String s2 = "Cancelar";
		Object[] options = {s1, s2};
		int n = JOptionPane.showOptionDialog(this,
				"Asegurese que todas las ventanas esten guardadas",
				"Confirme su desicion",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				s1);
		if (n == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	
	public void imprimirPentagrama()
	{
		System.out.println(getWidth()+" "+getHeight());
		PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(this);
        printJob.setCopies(1);
        if (printJob.printDialog())
        {
            try
            {
                printJob.print();  
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                return;
            }
        }		
	}

	public void llamdaConfirmacion(int i)
	{
		try
		{
			int opcion = JOptionPane.showConfirmDialog (this,"desea guardar la melodia # "+(i+1));
			if(opcion == 0)
			{
				guardarArchivo();
				tp.remove (i);
			}
			else
			{
				if(opcion == 1)
				{
					tp.remove (i);
				}
				else
				{
					tp.setVisible (true);
					return;
				}
			}
		}
		catch(Exception e)
		{
			System.err.println ("Error en el metodo"+e);
		}
	}

	public void construccion()
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("En construccion");
		frame.setSize(250,170);
		JLabel label = new JLabel(new ImageIcon("imagenes/COMPUTER.GIF"));
		frame.getContentPane().add(label);
		frame.show();
	}

	public void nuevaVentana(String nom)
	{
		if ( contador+1 < adm.length )
		{
			ventanaDeNotas(nom);
		}
		else
		{
			System.err.println("ERROR SE COMPLETO LA CANTIDAD DE VENTANAS");
		}
	}
	
	public void ventanaDeNotas(String nom)
	{
		nomArch = nom;
		try
		{
			//final JFrame fram = new JFrame("Elija una figura");
			fram = new JDialog(this,"Elija una figura",true);
			fram.setCursor(new Cursor(Cursor.HAND_CURSOR));
			fram.getContentPane ().setLayout (new BorderLayout());
			JPanel pa = new JPanel();
			JPanel pane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			pa.setLayout (new FlowLayout(FlowLayout.CENTER));
			final JButton n1,n2,n3,n4,n5,n6,n7,ac,can;
			
			n1 = new JButton(new ImageIcon("imagenes/dosDos.gif"));
			n2 = new JButton(new ImageIcon("imagenes/dosCuatro.gif"));
			n3 = new JButton(new ImageIcon("imagenes/tresCuatro.gif"));
			n4 = new JButton(new ImageIcon("imagenes/tresOcho.gif"));
			n5 = new JButton(new ImageIcon("imagenes/cuatro.gif"));
			n6 = new JButton(new ImageIcon("imagenes/seisOcho.gif"));
			n7 = new JButton(new ImageIcon("imagenes/nueveOcho.gif"));
			ac = new JButton("Aceptar");
			can = new JButton("Cancelar");
			
			n1.addActionListener (new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					n1.setEnabled (false);
					n2.setEnabled (true);
					n3.setEnabled (true);
					n4.setEnabled (true);
					n5.setEnabled (true);
					n6.setEnabled (true);
					n7.setEnabled (true);
					
					val = 4.0;
					im = new ImageIcon("imagenes/dosDos2.gif");
				}
			});
			
			n2.addActionListener (new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					n1.setEnabled (true);
					n2.setEnabled (false);
					n3.setEnabled (true);
					n4.setEnabled (true);
					n5.setEnabled (true);
					n6.setEnabled (true);
					n7.setEnabled (true);
					
					val = 2.0;
					im = new ImageIcon("imagenes/dosCuatro2.gif");
				}
			});
			
			n3.addActionListener (new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					n1.setEnabled (true);
					n2.setEnabled (true);
					n3.setEnabled (false);
					n4.setEnabled (true);
					n5.setEnabled (true);
					n6.setEnabled (true);
					n7.setEnabled (true);
					
					val = 3.0;
					im = new ImageIcon("imagenes/tresCuatro2.gif");
				}
			});
			
			n4.addActionListener (new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					n1.setEnabled (true);
					n2.setEnabled (true);
					n3.setEnabled (true);
					n4.setEnabled (false);
					n5.setEnabled (true);
					n6.setEnabled (true);
					n7.setEnabled (true);
					
					val = 1.5;
					im = new ImageIcon("imagenes/tresOcho2.gif");
				}
			});
			
			n5.addActionListener (new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					n1.setEnabled (true);
					n2.setEnabled (true);
					n3.setEnabled (true);
					n4.setEnabled (true);
					n5.setEnabled (false);
					n6.setEnabled (true);
					n7.setEnabled (true);
					
					val = 4.0;
					im = new ImageIcon("imagenes/cuatro2.gif");
				}
			});
			
			n6.addActionListener (new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					n1.setEnabled (true);
					n2.setEnabled (true);
					n3.setEnabled (true);
					n4.setEnabled (true);
					n5.setEnabled (true);
					n6.setEnabled (false);
					n7.setEnabled (true);
					
					val = 3.0;
					im = new ImageIcon("imagenes/seisOcho2.gif");
				}
			});
			
			n7.addActionListener (new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					n1.setEnabled (true);
					n2.setEnabled (true);
					n3.setEnabled (true);
					n4.setEnabled (true);
					n5.setEnabled (true);
					n6.setEnabled (true);
					n7.setEnabled (false);
					
					val = 4.5;
					im = new ImageIcon("imagenes/nueveOcho2.gif");
				}
			});
			
			ac.addActionListener (new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if ( im != null && val != 0.0 )
					{
						crearTodosLosAccesos(im,val,nomArch);
						fram.setVisible (false);
					}
				}
			});
			
			can.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					fram.setVisible(false);
				}
			});
			
			pa.add (n1);
			pa.add (n2);
			pa.add (n3);
			pa.add (n4);
			pa.add (n5);
			pa.add (n6);
			pa.add (n7);
			pa.setBorder (compound);
			
			pane.add(can);
			pane.add (ac);
			
			fram.getContentPane ().add (pa,BorderLayout.CENTER);
			fram.getContentPane ().add (pane,BorderLayout.SOUTH);
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int w = 600;
			int h = 200;
			fram.setLocation(screenSize.width/2 - w/2, screenSize.height/2 - h/2);
			fram.setSize(w, h);
			fram.setVisible (true);
		}
		catch (Exception e)
		{
			System.err.println (e);
		}
	}
	
	public void crearTodosLosAccesos(ImageIcon ig, double v, String nom)
	{
		try
		{
			System.out.println(contador);
			int i = ++contador;
			setContador(i);
			accionarVentanas();
			panelVentanas[contador] = new JPanel(new BorderLayout());
			adm[i] = new AdministradorVentanas(ig,v);
			
			adm[i].getPanel (0).addMouseListener (new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					modificarLabel("Para recibir ayuda, presione F1");
				}
			});
			
			panelVentanas[i].addMouseListener(raton);
			panelVentanas[i].setBorder(compound);
			panelVentanas[i].add(adm[i], BorderLayout.CENTER);
			
			instrumentoTabla[i] = new Instrumento(this);

			sp[i] = new JScrollPane();
			sp[i].setViewportView(panelVentanas[i]);
			
			ventanas.add(panelVentanas[i]);

			//tp.addTab("Melodia"+cant++,imagen, sp[i], "Melodia"+(cant-1));
			cant++;
			tp.addTab(nom,imagen, sp[i], "Melodia"+(cant-1));
			tp.setSelectedIndex (i);

			panel.add (tp, BorderLayout.CENTER); // 8/09/2003
			getContentPane().add (panel,BorderLayout.CENTER); // 8/09/2003
			
			adm[i].setFocusable(true);
			panelVentanas[i].setFocusable(true);
			instrumentoTabla[i].setFocusable(false);
			sp[i].setFocusable(true);
			
			adm[i].addFocusListener(this);
			panelVentanas[i].addFocusListener(this);
			
			sp[i].addFocusListener(this);
		}
		catch (Exception e)
		{
			System.err.println (e);
		}
	}

	public void setContador(int i)
	{
		contador = i;
	}

	public int getContador()
	{
		return contador;
	}

	public void abrirArchivo()
	{
		try
		{
			//Pentagrama.this.repaint ();
			final JFileChooser abrir = new JFileChooser(System.getProperty("user.dir"));
			abrir.addChoosableFileFilter(filtro);
			abrir.setFileView(iconoArch);
			//abrir.setCurrentDirectory(abrir.getCurrentDirectory());
			if ( abrir.showOpenDialog (this) != JFileChooser.APPROVE_OPTION )
			{
				return;
			}
			//abrir.showOpenDialog(this);
			Thread hilo = new Thread()
			{
				public void run()
				{
					try
					{
						BufferedReader leer = new BufferedReader(new FileReader(abrir.getSelectedFile ()));
						String line;

						while ( ( line = leer.readLine() ) != null )
						{
							recuperarArchivo(line, abrir.getName (abrir.getSelectedFile ()));
						}
						leer.close ();
					}
					catch ( IOException e )
					{
						String dialogo = "Error no se pudo abrir el archivo seleccionado \n"+e;
						e.printStackTrace();
						llamadaDeErrorAlAbrirArchivo (dialogo);
						return;
					}
				}
			};
			hilo.start ();
		}
		catch ( Exception ex )
		{
			String dialogo = "Error al utilizar el metodo \n"+ex;
			JOptionPane.showMessageDialog (this,dialogo,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void llamadaDeErrorAlAbrirArchivo( String dialogo )
	{
		JOptionPane.showMessageDialog (this,dialogo,"Error de Archivo",JOptionPane.ERROR_MESSAGE);
	}

	public void recuperarArchivo(String line, String nom)
	{
		try
		{
			tp.setSelectedIndex (index);
			String aux;
			String direc;
			int im = line.indexOf (",",0);
			direc = line.substring (0,im);
			crearVentanaNueva(direc, nom);
			int ipos = line.indexOf (",",im+1);
			String pos = line.substring (im+1, ipos);
			if ( pos.equals ("A") )
			{
				llenarFilas(pos,line.substring (ipos+1, line.length ()));
			}
		}
		catch (Exception e)
		{
			String dialogo = "Error no se pudo abrir el archivo seleccionado \n"+e;
			JOptionPane.showMessageDialog (this,dialogo,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void llenarFilas(String aux, String line)
	{
		try
		{
			int contA = 0,contB = 0,contC = 0,contD = 0, contE = 0, contF = 0, contG = 0, contH = 0, contI = 0, contJ = 0;
			String lineaA = "",lineaB = "",lineaC = "",lineaD = "",lineaE = "",lineaF = "",lineaG = "",lineaH = "",lineaI = "",lineaJ = "";
	
			System.out.println (aux);

			while ( !aux.equals ("B") && !aux.equals ("C") && !aux.equals ("D") &&!aux.equals ("E") &&!aux.equals ("F") && !aux.equals ("G") && !aux.equals ("H") && !aux.equals ("I") && !aux.equals ("J") )
			{
				try
				{
					int posNota = line.indexOf (":",contA);
					String nota = line.substring (contA,posNota);
					crearNota("A",nota);
					aux = line.substring (posNota+1,posNota+2);
					contA = posNota+1;
					lineaA = line.substring (contA+2,line.length ());
				}
				catch (Exception e)
				{
					System.err.println("ERROR"+e);
					return;
				}
			}

			System.out.println (aux);

			while ( !aux.equals ("C") && !aux.equals ("D") && !aux.equals ("E") &&!aux.equals ("F") &&!aux.equals ("G") && !aux.equals ("H") && !aux.equals ("I") && !aux.equals ("J") )
			{
				try
				{
					int posNota = lineaA.indexOf (":",contB);
					String nota = lineaA.substring (contB,posNota);
					
					crearNota("B",nota);
					aux = lineaA.substring (posNota+1,posNota+2);
					contB = posNota+1;
					lineaB = lineaA.substring (contB+2,lineaA.length ());
				}	
				catch (Exception e)
				{
					System.err.println("ERROR"+e);
					return;
				}
			}

			System.out.println (aux);

			while ( !aux.equals ("D") && !aux.equals ("E") && !aux.equals ("F") &&!aux.equals ("G") &&!aux.equals ("H") && !aux.equals ("I") && !aux.equals ("J") )
			{
				try
				{
					int posNota = lineaB.indexOf (":",contC);
					String nota = lineaB.substring (contC,posNota);
					
					crearNota("C",nota);
					aux = lineaB.substring (posNota+1,posNota+2);
					contC = posNota+1;
					lineaC = lineaB.substring (contC+2,lineaB.length ());
				}
				catch (Exception e)
				{
					System.err.println("ERROR"+e);
					return;
				}
			}

			System.out.println (aux);
	
			while ( !aux.equals ("E") && !aux.equals ("F") &&!aux.equals ("G") &&!aux.equals ("H") && !aux.equals ("I") && !aux.equals ("J") )
			{
				try
				{
					int posNota = lineaC.indexOf (":",contD);
					String nota = lineaC.substring (contD,posNota);
					
					crearNota("D",nota);
					aux = lineaC.substring (posNota+1,posNota+2);
					contD = posNota+1;
					lineaD = lineaC.substring (contD+2,lineaC.length ());
				}
				catch (Exception e)
				{
					System.err.println("ERROR"+e);
					return;
				}
			}

			System.out.println (aux);

			while ( !aux.equals ("F") &&!aux.equals ("G") &&!aux.equals ("H") && !aux.equals ("I") && !aux.equals ("J") )
			{
				try
				{
					int posNota = lineaD.indexOf (":",contE);
					String nota = lineaD.substring (contE,posNota);
					
					crearNota("E",nota);
					aux = lineaD.substring (posNota+1,posNota+2);
					contE = posNota+1;
					lineaE = lineaD.substring (contE+2,lineaD.length ());
				}
				catch (Exception e)
				{
					System.err.println("ERROR.........."+e);
					return;
				}
			}

			System.out.println (aux);

			while ( !aux.equals ("G") &&!aux.equals ("H") && !aux.equals ("I") && !aux.equals ("J") )
			{
				try
				{
					int posNota = lineaE.indexOf (":",contF);
					String nota = lineaE.substring (contF,posNota);
					
					crearNota("F",nota);
					aux = lineaE.substring (posNota+1,posNota+2);
					contF = posNota+1;
					lineaF = lineaE.substring (contF+2,lineaE.length ());
				}
				catch (Exception e)
				{
					System.err.println("ERROR..........."+e);
					return;
				}
			}
	
			System.out.println (aux);

			while ( !aux.equals ("H") && !aux.equals ("I") && !aux.equals ("J") )
			{
				try
				{
					int posNota = lineaF.indexOf (":",contG);
					String nota = lineaF.substring (contG,posNota);
					
					crearNota("G",nota);
					aux = lineaF.substring (posNota+1,posNota+2);
					contG = posNota+1;
					lineaG = lineaF.substring (contG+2,lineaF.length ());
				}
				catch (Exception e)
				{
					System.err.println("ERROR........"+e);
					return;
				}
			}

			System.out.println (aux);
	
			while ( !aux.equals ("I") && !aux.equals ("J") )
			{
				try
				{
					int posNota = lineaG.indexOf (":",contH);
					String nota = lineaG.substring (contH,posNota);
					
					crearNota("H",nota);
					aux = lineaG.substring (posNota+1,posNota+2);
					contH = posNota+1;
					lineaH = lineaG.substring (contH+2,lineaG.length ());
				}
				catch (Exception e)
				{
					System.err.println("ERROR.........."+e);
					return;
				}
			}

			System.out.println (aux);
	
			while ( !aux.equals ("J") )
			{
				try
				{
					int posNota = lineaH.indexOf (":",contI);
					String nota = lineaH.substring (contI,posNota);
					
					crearNota("I",nota);
					aux = lineaH.substring (posNota+1,posNota+2);
					contI = posNota+1;
					lineaI = lineaH.substring (contI+2,lineaH.length ());
				}
				catch (Exception e)
				{
					System.err.println("ERROR.............."+e);
					return;
				}
			}

			System.out.println (aux);

			while ( aux.equals ("J") )
			{
				try
				{
					int posNota = lineaI.indexOf (":",contJ);
					String nota = lineaI.substring (contJ,posNota);
					
					crearNota("J",nota);
					aux = "J";
					contJ = posNota+1;
					lineaJ = lineaI.substring (contJ+2,lineaI.length ());
				}
				catch (Exception e)
				{
					System.err.println("ERROR..................."+e);
					return;
					/*
					 * El problema de lo que se colgaba era de que este estaba en comentario
					 * en linux este no molesta pero en windows si.
					 */
				}
			}
		}
		catch ( Exception e )
		{
			System.err.println("ERROR.............."+e);
		}
	}

	public void crearNota(String fila, String nota)
	{
		try
		{
			if ( fila.equalsIgnoreCase("A") )
			{
				dibujarNota(0,nota+",");
			}

			if ( fila.equals("B") )
			{
				dibujarNota(1,nota+",");
			}

			if ( fila.equals("C") )
			{
				dibujarNota(2,nota+",");
			}

			if ( fila.equals("D") )
			{
				dibujarNota(3,nota+",");
			}

			if ( fila.equals("E") )
			{
				dibujarNota(4,nota+",");
			}

			if ( fila.equals("F") )
			{
				dibujarNota(5,nota+",");
			}

			if ( fila.equals("G") )
			{
				dibujarNota(6,nota+",");
			}

			if ( fila.equals("H") )
			{
				dibujarNota(7,nota+",");
			}

			if ( fila.equals("I") )
			{
				dibujarNota(8,nota+",");
			}

			if ( fila.equals("J") )
			{
				dibujarNota(9,nota+",");
			}
		}
		catch ( Exception e ) { System.err.println("ERROR............"+e); }
	}

	public void dibujarNota(int fila, String line)
	{
		try
		{
			int iposX = line.indexOf (",",0);
			int x = Integer.parseInt (line.substring (0,iposX));

			int iposY = line.indexOf (",",iposX+1);
			int y = Integer.parseInt (line.substring (iposX + 1,iposY));

			int iposN = line.indexOf (",",iposY+1);
			String nom = line.substring (iposY+1,iposN);
			
			if ( nom.equalsIgnoreCase("redonda") )
			{
				System.out.println("EL INDICE EN EL QUE SE ABRIRA ES : "+index);
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				Redonda rd = new Redonda(x,y);
				adm[index].getPanel(fila).añadir(rd);
				adm[index].getNota(fila).setNota(rd);
			}

			if ( nom.equalsIgnoreCase("blanca") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				Blanca bl = new Blanca(x,y);
				adm[index].getPanel(fila).añadir(bl);
				adm[index].getNota(fila).setNota(bl);
			}

			if ( nom.equalsIgnoreCase("negra") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				Negra ne = new Negra(x,y);
				adm[index].getPanel(fila).añadir(ne);
				adm[index].getNota(fila).setNota(ne);
			}

			if ( nom.equalsIgnoreCase("corchea") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				Corchea co = new Corchea(x,y);
				adm[index].getPanel(fila).añadir(co);
				adm[index].getNota(fila).setNota(co);
			}

			if ( nom.equalsIgnoreCase("semiCorchea") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				SemiCorchea sc = new SemiCorchea(x,y);
				adm[index].getPanel(fila).añadir(sc);
				adm[index].getNota(fila).setNota(sc);
			}
			///////////////*********************
			
			if ( nom.equalsIgnoreCase("redondaPunto") )
			{
				System.out.println("EL INDICE EN EL QUE SE ABRIRA ES : "+index);
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				RedondaPunto rd = new RedondaPunto(x,y);
				adm[index].getPanel(fila).añadir(rd);
				adm[index].getNota(fila).setNota(rd);
			}

			if ( nom.equalsIgnoreCase("blancaPunto") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				BlancaPunto bl = new BlancaPunto(x,y);
				adm[index].getPanel(fila).añadir(bl);
				adm[index].getNota(fila).setNota(bl);
			}

			if ( nom.equalsIgnoreCase("negraPunto") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				NegraPunto ne = new NegraPunto(x,y);
				adm[index].getPanel(fila).añadir(ne);
				adm[index].getNota(fila).setNota(ne);
			}

			if ( nom.equalsIgnoreCase("corcheaPunto") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				CorcheaPunto co = new CorcheaPunto(x,y);
				adm[index].getPanel(fila).añadir(co);
				adm[index].getNota(fila).setNota(co);
			}

			if ( nom.equalsIgnoreCase("semiCorcheaPunto") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				SemiCorcheaPunto sc = new SemiCorcheaPunto(x,y);
				adm[index].getPanel(fila).añadir(sc);
				adm[index].getNota(fila).setNota(sc);
			}
			
			if ( nom.equalsIgnoreCase("redondaSostenida") )
			{
				System.out.println("EL INDICE EN EL QUE SE ABRIRA ES : "+index);
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				RedondaSostenida rd = new RedondaSostenida(x,y);
				adm[index].getPanel(fila).añadir(rd);
				adm[index].getNota(fila).setNota(rd);
			}

			if ( nom.equalsIgnoreCase("blancaSostenida") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				BlancaSostenida bl = new BlancaSostenida(x,y);
				adm[index].getPanel(fila).añadir(bl);
				adm[index].getNota(fila).setNota(bl);
			}

			if ( nom.equalsIgnoreCase("negraSostenida") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				NegraSostenida ne = new NegraSostenida(x,y);
				adm[index].getPanel(fila).añadir(ne);
				adm[index].getNota(fila).setNota(ne);
			}

			if ( nom.equalsIgnoreCase("corcheaSostenida") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				CorcheaSostenida co = new CorcheaSostenida(x,y);
				adm[index].getPanel(fila).añadir(co);
				adm[index].getNota(fila).setNota(co);
			}

			if ( nom.equalsIgnoreCase("semiCorcheaSostenida") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				SemiCorcheaSostenida sc = new SemiCorcheaSostenida(x,y);
				adm[index].getPanel(fila).añadir(sc);
				adm[index].getNota(fila).setNota(sc);
			}
			/////////*****************
			
			if ( nom.equalsIgnoreCase("redondaBemol") )
			{
				System.out.println("EL INDICE EN EL QUE SE ABRIRA ES : "+index);
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				RedondaBemol rd = new RedondaBemol(x,y);
				adm[index].getPanel(fila).añadir(rd);
				adm[index].getNota(fila).setNota(rd);
			}

			if ( nom.equalsIgnoreCase("blancaBemol") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				BlancaBemol bl = new BlancaBemol(x,y);
				adm[index].getPanel(fila).añadir(bl);
				adm[index].getNota(fila).setNota(bl);
			}

			if ( nom.equalsIgnoreCase("negraBemol") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				NegraBemol ne = new NegraBemol(x,y);
				adm[index].getPanel(fila).añadir(ne);
				adm[index].getNota(fila).setNota(ne);
			}

			if ( nom.equalsIgnoreCase("corcheaBemol") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				CorcheaBemol co = new CorcheaBemol(x,y);
				adm[index].getPanel(fila).añadir(co);
				adm[index].getNota(fila).setNota(co);
			}

			if ( nom.equalsIgnoreCase("semiCorcheaBemol") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,y));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,y,nom));
				SemiCorcheaBemol sc = new SemiCorcheaBemol(x,y);
				adm[index].getPanel(fila).añadir(sc);
				adm[index].getNota(fila).setNota(sc);
			}
			
			//////////////////********************
			if ( nom.equalsIgnoreCase("silencioRedonda") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,84));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,84,nom));
				SilencioRedonda sr = new SilencioRedonda(x,84);
				adm[index].getPanel(fila).añadir(sr);
				adm[index].getNota(fila).setNota(sr);
			}
			
			if ( nom.equalsIgnoreCase("silencioBlanca") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,84));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,84,nom));
				SilencioBlanca sb = new SilencioBlanca(x,84);
				adm[index].getPanel(fila).añadir(sb);
				adm[index].getNota(fila).setNota(sb);
			}
			
			if ( nom.equalsIgnoreCase("silencioNegra") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,84));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,84,nom));
				SilencioNegra sn = new SilencioNegra(x,84);
				adm[index].getPanel(fila).añadir(sn);
				adm[index].getNota(fila).setNota(sn);
			}
			
			if ( nom.equalsIgnoreCase("silencioCorchea") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,84));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,84,nom));
				SilencioCorchea sc = new SilencioCorchea(x,84);
				adm[index].getPanel(fila).añadir(sc);
				adm[index].getNota(fila).setNota(sc);
			}
			
			if ( nom.equalsIgnoreCase("silencioSemiCorchea") )
			{
				adm[index].getPosicion(fila).setPunto(new Point(x,84));
				adm[index].getArchivo(fila).añadir(new DatoMusical(x,84,nom));
				SilencioSemiCorchea ssc = new SilencioSemiCorchea(x,84);
				adm[index].getPanel(fila).añadir(ssc);
				adm[index].getNota(fila).setNota(ssc);
			}
		}
		catch ( Exception e ) { System.err.println(e); }
		
		try
		{
			ventanas.add(adm[index]);
		}
		catch (Exception e)
		{
			System.err.println(" Error al añadir ventana que recien se abrio "+e);
		}
	}

	public void guardarArchivo()
	{
		try
		{
			//Pentagrama.this.repaint();
			final JFileChooser guardar = new JFileChooser(System.getProperty("user.dir"));
			guardar.addChoosableFileFilter(filtro);
			guardar.setFileView(iconoArch);
			
			if(guardar.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
			{
				return;
			}
			
			//guardar.showSaveDialog(this);
        	Thread hilo2=new Thread()
			{
				public void run()
				{
					File archi_guardar = guardar.getSelectedFile();
					try
					{
						Cola aux = new Cola();
						FileWriter escribir = new FileWriter(archi_guardar);
						escribir.write (adm[index].getNombreDeImagen ()+",");
						char cont = 65;
						for ( int i = 0 ; i < adm[index].getTotalPaneles() ; i++)
						{
							escribir.write(cont+",");
							while ( !adm[index].getArchivo(i).getCola().vacia() )
							{
								Object o = adm[index].getArchivo(i).getCola().decolar();
								//escribir.write(adm[index].getArchivo(i).sacarCola());
								escribir.write(((DatoMusical)o).guardar());
								aux.encolar(o);
							}
							cont++;
							reconstruirColas( adm[index].getArchivo(i).getCola(), aux );
						}
						escribir.close();
						//reconstruirColas( adm[index].getArchivo(i).getCola(), aux );
					}
					catch (IOException e)
					{
						e.printStackTrace();
						return;
					}
					tp.setTitleAt(index, guardar.getName (guardar.getSelectedFile()));
				}
			};
			hilo2.start();
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
	
	public void reconstruirColas( Cola arch, Cola aux )
	{
		while( !aux.vacia() )
		{
			arch.encolar(aux.decolar());
		}
	}
	
	public void llamadaDeAlerta()
	{
		String otro = "Alerta usted no puede colocar \n las notas en esa posicion";
		// Esta seccion te permite tener mensajes de ERROR.
		JOptionPane.showMessageDialog (this,otro,"ALERTA",JOptionPane.WARNING_MESSAGE);
	}
	
	public void muestraFoco( FocusEvent e )
	{
		System.out.println ( e.getComponent() );
	}
	
	public int print(Graphics g, PageFormat pf, int pi) throws PrinterException
	{
		System.out.println(getWidth()+" "+getHeight());
		if (pi >= 1)
		{
			return Printable.NO_SUCH_PAGE;
        }
		
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        /*g2d.translate(pf.getImageableWidth() / 2,
                      pf.getImageableHeight() / 2);
        */
        //Paper pap = new Paper();
        //pap.setSize(adm[index].getWidth(),adm[index].getHeight());
        //pf.setPaper(pap);
        
        g2d.translate(pf.getImageableWidth()/2,
                      pf.getImageableHeight() /4);
                      
        Dimension d = getSize();
		
		double scale = Math.min(pf.getImageableWidth() / d.width,
            	                    pf.getImageableHeight() / d.height);
        
        if (scale < 1.0) {
            g2d.scale(scale, scale);
        }
		
        g2d.translate(-d.width / 2.0, -d.height / 2.0);
		/*
        if (bimg == null) {
            Graphics2D g2 = createGraphics2D(d.width, d.height, null, g2d);
            render(d.width, d.height, g2);
            g2.dispose();
        } else {
            g2d.drawImage(bimg, 0, 0, this);
        }
		*/
		adm[index].printAll(g2d);
		
        return Printable.PAGE_EXISTS;
    }
	
	public void imprimiendo(Graphics g)
	{
		g.setFont (new Font("Helvetica-Bold", Font.PLAIN, 48));
		
		g = adm[index].getGraphics ();
	}
	
	class Raton implements MouseListener
	{
		public void mousePressed(MouseEvent e)
		{
			panelVentanas[index].requestFocus();
			System.out.println("Entroooooooooo");
			/*
			for (  int i = 0 ; i < adm[index].getPanelArray().length ; i++ )
			{
				adm[index].getPanel(i).repaint();
				System.out.println("\t\t\n\nEntro al evento del raton\n\n = "+index);
				adm[index].grabFocus();
			}*/
		};

		public void mouseEntered ( MouseEvent e ) { };

		public void mouseExited ( MouseEvent e ) { };

		public void mouseClicked ( MouseEvent e ) { };

		public void mouseReleased ( MouseEvent e ) { };

		public void mouseMoved ( MouseEvent e ) { };

		public void mouseDragged ( MouseEvent e) { };

	}

	public static void crearMusica()
	{
		//crearProgreso();
		for ( int j = 0 ; j < contVentanas ; j++ )
		{
			if ( arrVentana[j].isSelected() )
			{
				for ( int i = 1 ; i <= adm[j].getArchivoMusical ().getContador() ; i++ )
				{
					if ( adm[j].getArchivoMusical ().acceder(i) != null )
					{
						Object o = adm[j].getListaPaneles().acceder(i);
						reconstruirDatoMusical(((ArchivoMusical)adm[j].getArchivoMusical ().acceder(i)).getCola (), ((PanelDibujo)o));
						System.out.println("Entro al if del for de crear musica");
					//progresoBar.setValue(progresoBar.getValue()+1);
					}
					/*
					else
					{
						bp6.setEnabled(true);
						System.out.println("Finalizo la musica");
					}*/
					//progresoBar.setValue(progresoBar.getValue()+1);
				}
				///bp6.setEnabled(true);
			}
		}
		activo(true);
		//bp6.setEnabled(true);
		//jframe.setVisible(false);
		//jframe = null;
	}

	public static void reconstruirDatoMusical(Cola cola, PanelDibujo panelDib)
	{
		//System.out.println("Entro a reconstruir musica");	
		Cola aux = new Cola();
		while(!cola.vacia ())
		{
			if ( !stop )
			{
				Object o = cola.decolar ();
				aux.encolar (o);
				crearEventoDeMusica(((DatoMusical)o), panelDib);
				//System.out.println ("vaciar; "+o.toString ());
				//progresoBar.setValue(progresoBar.getValue()+1);
			}
			else
			{
				arreglarCola(aux,cola);
				return;
			}
		}
		//progresoBar.setValue(progresoBar.getValue()+1);
		
		while(!aux.vacia ())
		{
			cola.encolar (aux.decolar ());
			//progresoBar.setValue(progresoBar.getValue()+1);
		}
		//progresoBar.setValue(progresoBar.getValue()+1);
	}

	public static void crearEventoDeMusica(DatoMusical dato, PanelDibujo panelDib)
	{
		int posY = dato.getY ();
		NotaMusical nota = dato.getNota ();
		String nom = dato.getNom ();

		if ( nom.equalsIgnoreCase ("redonda") )
		{
			accionaMusica(new Redonda(dato.getX (),dato.getY ()),nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("blanca") )
		{
			accionaMusica(new Blanca(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("negra") )
		{
			accionaMusica(new Negra(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("corchea") )
		{
			accionaMusica(new Corchea(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("semiCorchea") )
		{
			accionaMusica(new SemiCorchea(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}
		///////////***********
		if ( nom.equalsIgnoreCase ("redondaPunto") )
		{
			accionaMusica(new RedondaPunto(dato.getX (),dato.getY ()),nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("blancaPunto") )
		{
			accionaMusica(new BlancaPunto(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("negraPunto") )
		{
			accionaMusica(new NegraPunto(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("corcheaPunto") )
		{
			accionaMusica(new CorcheaPunto(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("semiCorcheaPunto") )
		{
			accionaMusica(new SemiCorcheaPunto(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}
		
		if ( nom.equalsIgnoreCase ("redondaSostenida") )
		{
			accionaMusica(new RedondaSostenida(dato.getX (),dato.getY ()),nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("blancaSostenida") )
		{
			accionaMusica(new BlancaSostenida(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("negraSostenida") )
		{
			accionaMusica(new NegraSostenida(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("corcheaSostenida") )
		{
			accionaMusica(new CorcheaSostenida(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("semiCorcheaSostenida") )
		{
			accionaMusica(new SemiCorcheaSostenida(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}
		
		if ( nom.equalsIgnoreCase ("redondaBemol") )
		{
			accionaMusica(new RedondaBemol(dato.getX (),dato.getY ()),nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("blancaBemol") )
		{
			accionaMusica(new BlancaBemol(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("negraBemol") )
		{
			accionaMusica(new NegraBemol(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("corcheaBemol") )
		{
			accionaMusica(new CorcheaBemol(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}

		if ( nom.equalsIgnoreCase ("semiCorcheaBemol") )
		{
			accionaMusica(new SemiCorcheaBemol(dato.getX (), dato.getY ()), nota,posY, panelDib);
		}
		
		//////////***************
		if ( nom.equalsIgnoreCase("silencioRedonda") )
		{
			accionaMusica(new SilencioRedonda(dato.getX(),dato.getY()), nota,posY, panelDib);
		}
		
		if ( nom.equalsIgnoreCase("silencioBlanca") )
		{
			accionaMusica(new SilencioBlanca(dato.getX(),dato.getY()), nota,posY, panelDib);
		}
		
		if ( nom.equalsIgnoreCase("silencioNegra") )
		{
			accionaMusica(new SilencioNegra(dato.getX(),dato.getY()), nota,posY, panelDib);
		}
		
		if ( nom.equalsIgnoreCase("silencioCorchea") )
		{
			accionaMusica(new SilencioCorchea(dato.getX(),dato.getY()), nota,posY, panelDib);
		}
		
		if ( nom.equalsIgnoreCase("silencioSemiCorchea") )
		{
			accionaMusica(new SilencioSemiCorchea(dato.getX(),dato.getY()), nota,posY, panelDib);
		}
	}

	public static void accionaMusica( Figura figu, NotaMusical nota, int posY, PanelDibujo panelDib )
	{
		if ( figu instanceof SilencioRedonda )
		{
			instrumentoTabla[index].creaEvento(0,((SilencioRedonda)figu).getValor(), panelDib, figu);
		}
		else
		{
			if ( figu instanceof SilencioBlanca )
			{	
				instrumentoTabla[index].creaEvento(0,((SilencioBlanca)figu).getValor(), panelDib, figu);
			}
			else
			{
				if ( figu instanceof SilencioNegra )
				{
					instrumentoTabla[index].creaEvento(0,((SilencioNegra)figu).getValor(), panelDib, figu);
				}
				else
				{
					if ( figu instanceof SilencioCorchea )
					{
						instrumentoTabla[index].creaEvento(0,((SilencioCorchea)figu).getValor(), panelDib, figu);
					}
					else
					{
						if ( figu instanceof SilencioSemiCorchea )
						{
							instrumentoTabla[index].creaEvento(0,((SilencioSemiCorchea)figu).getValor(), panelDib, figu);
						}
						else
						{
							double valorFigura = verificarInstancias(figu);
							int valorDeSonido = verificarNota(nota,posY);
		
							System.out.println("\t valor Figura"+valorFigura+"\t valor de sonido "+valorDeSonido);
							
							instrumentoTabla[index].creaEvento(valorDeSonido,valorFigura, panelDib, figu);
						}
					}
				}
			}
		}
	}

	public static double verificarInstancias(Figura figu)
	{
		double res = 0;

		if ( figu instanceof Redonda )
		{
			res = ((Redonda)figu).getValor ();
		}

		if ( figu instanceof Blanca )
		{
			res = ((Blanca)figu).getValor ();
		}

		if ( figu instanceof Negra )
		{
			res = ((Negra)figu).getValor ();
		}

		if ( figu instanceof Corchea )
		{
			res = ((Corchea)figu).getValor ();
		}

		if ( figu instanceof SemiCorchea )
		{
			res = ((SemiCorchea)figu).getValor ();
		}
		//////////////****************
		
		if ( figu instanceof RedondaPunto )
		{
			res = ((RedondaPunto)figu).getValor ();
		}

		if ( figu instanceof BlancaPunto )
		{
			res = ((BlancaPunto)figu).getValor ();
		}

		if ( figu instanceof NegraPunto )
		{
			res = ((NegraPunto)figu).getValor ();
		}

		if ( figu instanceof CorcheaPunto )
		{
			res = ((CorcheaPunto)figu).getValor ();
		}

		if ( figu instanceof SemiCorcheaPunto )
		{
			res = ((SemiCorcheaPunto)figu).getValor ();
		}
		
		if ( figu instanceof RedondaSostenida )
		{
			res = ((RedondaSostenida)figu).getValor ();
		}

		if ( figu instanceof BlancaSostenida )
		{
			res = ((BlancaSostenida)figu).getValor ();
		}

		if ( figu instanceof NegraSostenida )
		{
			res = ((NegraSostenida)figu).getValor ();
		}

		if ( figu instanceof CorcheaSostenida )
		{
			res = ((CorcheaSostenida)figu).getValor ();
		}

		if ( figu instanceof SemiCorcheaSostenida )
		{
			res = ((SemiCorcheaSostenida)figu).getValor ();
		}
		
		if ( figu instanceof RedondaBemol )
		{
			res = ((RedondaBemol)figu).getValor ();
		}

		if ( figu instanceof BlancaBemol )
		{
			res = ((BlancaBemol)figu).getValor ();
		}

		if ( figu instanceof NegraBemol )
		{
			res = ((NegraBemol)figu).getValor ();
		}

		if ( figu instanceof CorcheaBemol )
		{
			res = ((CorcheaBemol)figu).getValor ();
		}

		if ( figu instanceof SemiCorcheaBemol )
		{
			res = ((SemiCorcheaBemol)figu).getValor ();
		}
		
		////////////********************

		return res;
	}

	public static int verificarNota(NotaMusical nota, int posY)
	{
		int res = 0;
		int auxN = 0;
		
		if ( niv == 0 )
		{
			res = verificarNotaAux(nota,posY,0);
		}
		else
		{
			if ( niv == 1 )
			{
				res = verificarNotaAux(nota,posY,1);
			}
			else
			{
				if ( niv == 2 )
				{
					res = verificarNotaAux(nota,posY,2);
				}
			}
		}

		return res;
	}
	
	public static int verificarNotaAux(NotaMusical nota, int posY, int i)
	{
		int res = 0;
		int auxN = 0;
		
		if ( posY >= 16 && posY <= 24 )
		{
			auxN = i+5;
			res = devuelveRes(nota, auxN);
		}
		else
		{
			if ( posY >= 28 && posY <= 52 )
			{
				auxN = i+4;
				res = devuelveRes(nota,auxN);
			}
			else
			{
				if ( posY >= 56 && posY <= 80 )
				{
					auxN = i+3;
					res = devuelveRes(nota,auxN);
				}
				else
				{
					if ( posY >= 84 && posY <= 108 )
					{
						auxN = i+2;
						res = devuelveRes(nota,auxN);
					}
					else
					{
						if ( posY >= 112 && posY <= 136 )
						{
							auxN = i+1;
							res = devuelveRes(nota,auxN);
						}
						else
						{
							if ( posY >= 140 && posY <= 148 )
							{
								auxN = i;
								res = devuelveRes(nota,auxN);
							}
							else
							{
								res = 0;
							}
						}
					}
				}
			}
		}
		
		return res;
	}
	
	public static int devuelveRes( NotaMusical nota, int nivAux )
	{
		int res = 0;
		
		if ( nota instanceof Do )
		{
			res = ((Do)nota).getArrDo (nivAux);
		}

		if ( nota instanceof Re )
		{
			res = ((Re)nota).getArrRe (nivAux);
		}

		if (nota instanceof Mi )
		{
			res = ((Mi)nota).getArrMi (nivAux);
		}

		if ( nota instanceof Fa )
		{
			res = ((Fa)nota).getArrFa (nivAux);
		}

		if ( nota instanceof Sol )
		{
			res = ((Sol)nota).getArrSol (nivAux);
		}

		if ( nota instanceof La )
		{
			res = ((La)nota).getArrLa (nivAux);
		}

		if ( nota instanceof Si )
		{
			res = ((Si)nota).getArrSi (nivAux);
		}
		/////////////************
		
		if ( nota instanceof DoSostenida )
		{
			res = ((DoSostenida)nota).getArrDoSostenida (nivAux);
		}

		if ( nota instanceof ReSostenida )
		{
			res = ((ReSostenida)nota).getArrReSostenida (nivAux);
		}

		if (nota instanceof MiSostenida )
		{
			res = ((MiSostenida)nota).getArrMiSostenida (nivAux);
		}

		if ( nota instanceof FaSostenida )
		{
			res = ((FaSostenida)nota).getArrFaSostenida (nivAux);
		}

		if ( nota instanceof SolSostenida )
		{
			System.out.println("Entro a Sol Sostenida");
			res = ((SolSostenida)nota).getArrSolSostenida (nivAux);
		}

		if ( nota instanceof LaSostenida )
		{
			res = ((LaSostenida)nota).getArrLaSostenida (nivAux);
		}

		if ( nota instanceof SiSostenida )
		{
			res = ((SiSostenida)nota).getArrSiSostenida (nivAux);
		}
		
		if ( nota instanceof DoBemol )
		{
			res = ((DoBemol)nota).getArrDoBemol (nivAux);
		}

		if ( nota instanceof ReBemol )
		{
			res = ((ReBemol)nota).getArrReBemol (nivAux);
		}

		if (nota instanceof MiBemol )
		{
			res = ((MiBemol)nota).getArrMiBemol (nivAux);
		}

		if ( nota instanceof FaBemol )
		{
			res = ((FaBemol)nota).getArrFaBemol (nivAux);
		}

		if ( nota instanceof SolBemol )
		{
			System.out.println("Entro a Sol Bemol");
			res = ((SolBemol)nota).getArrSolBemol (nivAux);
		}

		if ( nota instanceof LaBemol )
		{
			res = ((LaBemol)nota).getArrLaBemol (nivAux);
		}

		if ( nota instanceof SiBemol )
		{
			res = ((SiBemol)nota).getArrSiBemol (nivAux);
		}
		
		//////////////**********
		return res;
	}
	
	public static void arreglarCola(Cola aux, Cola cola)
	{
		Lista lista = new Lista();
		//Lista lista2 = new Lista();
		
		while ( !aux.vacia() )
		{
			lista.agregar(aux.decolar());
		}
		while ( !cola.vacia() )
		{
			lista.agregar(cola.decolar());
		}
		while ( !lista.vacia() )
		{
			cola.encolar(lista.borrarPrimero());
		}
	}
	
	public void focusGained(FocusEvent e)
	{
		Object o = e.getSource();
		
		if ( o == adm[0] )
		{
			adm[0].validate();
		}
	}
	
    public void focusLost(FocusEvent e)
    {
    	
    }
    
    public static void grabarMusica ( boolean res )
    {
    	if ( res )
    	{
    		try
    		{
    			crearMusica();
    		}
    		catch ( Exception e )
    		{
    			System.err.println("ERROR GARRAFAL EN GRABAR MUSICA = "+e);
    		}
    	}
    }
    
    public void crearVentanaNueva(String dir, String nom)
    {
    	if ( dir.equalsIgnoreCase ("imagenes/dosDos2.gif") )
    	{
    		crearTodosLosAccesos(new ImageIcon(dir),4.0, nom);
    	}
    	
    	if ( dir.equalsIgnoreCase ("imagenes/dosCuatro2.gif") )
    	{
    		crearTodosLosAccesos(new ImageIcon(dir),2.0, nom);
    	}
    	
    	if ( dir.equalsIgnoreCase ("imagenes/tresCuatro2.gif") )
    	{
    		crearTodosLosAccesos(new ImageIcon(dir),3.0, nom);
    	}
    	
    	if ( dir.equalsIgnoreCase ("imagenes/tresOcho2.gif") )
    	{
    		crearTodosLosAccesos(new ImageIcon(dir),1.5, nom);
    	}
    	
    	if ( dir.equalsIgnoreCase ("imagenes/cuatro2.gif") )
    	{
    		crearTodosLosAccesos(new ImageIcon(dir),4.0, nom);
    	}
    	
    	if ( dir.equalsIgnoreCase ("imagenes/seisOcho2.gif") )
    	{
    		crearTodosLosAccesos(new ImageIcon(dir),3.0, nom);
    	}
    	
    	if ( dir.equalsIgnoreCase ("imagenes/nueveOcho2.gif") )
    	{
    		crearTodosLosAccesos(new ImageIcon(dir),4.5, nom);
    	}
    }
    
    public void crearProgreso()
    {
    	//JOptionPane.setRootFrame(this);
    	
    	jframe = new JFrame ("Reproduciendo...");
    	jframe.setIconImage(new ImageIcon("imagenes/knotify.gif").getImage());
    	jframe.getContentPane().setLayout(new BorderLayout());
    	
		int WIDTH = 400, HEIGHT = 200;
        jframe.setSize(WIDTH, HEIGHT);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        jframe.setLocation(d.width/2 - WIDTH/2, d.height/2 - HEIGHT/2);
        
		JPanel progresoPanel = new JPanel()
		{
			public Insets getInsets()
			{
				return new Insets(40,30,20,30);
			}
		};
		//JLabel la = new JLabel(new ImageIcon("imagenes/presentacion2.jpg"));
		progresoPanel.setLayout(new BoxLayout(progresoPanel, BoxLayout.Y_AXIS));
		//window.getContentPane().add(la,BorderLayout.CENTER);
		jframe.getContentPane().add(progresoPanel,BorderLayout.CENTER);
		
		Dimension labelDimension = new Dimension(400,20);
		progresoLabel = new JLabel("Reproduciendo...");
        progresoLabel.setAlignmentX(CENTER_ALIGNMENT);
        progresoLabel.setMaximumSize(labelDimension);
        progresoLabel.setPreferredSize(labelDimension);
        progresoPanel.add(progresoLabel);
        progresoPanel.add(Box.createRigidArea(new Dimension(1,20)));
		
        progresoBar = new JProgressBar();
        progresoBar.setStringPainted(true);
        progresoLabel.setLabelFor(progresoBar);
        progresoBar.setAlignmentX(CENTER_ALIGNMENT);
        progresoBar.setMinimum(0);
        progresoBar.setValue(0);
        progresoBar.getAccessibleContext().setAccessibleName("Progreso de carga del Editor de Partituras");
        progresoPanel.add(progresoBar);
		
        jframe.setVisible(true);
    }
}