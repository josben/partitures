
import javax.swing.*;
import javax.swing.table.*;
import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.Vector;
import java.io.File;
import java.io.IOException;

public class Instrumento extends JPanel
{
	protected Synthesizer sintonizador;
	protected Instrument ins[];
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	Key key;
	ChannelData channels[];
	//InstrumentsTable tab;
	private JPanel panel;
	private Border compound;
	private ChannelData cc;
	static MidiChannel midi[];
	JTable table;
	final int ON = 0, OFF = 1;
	final int NOTEON = 144;
	final int NOTEOFF = 128;
	protected boolean record = false;
	////********
	long startTime;
	final int PROGRAM = 192;
	protected RecordFrame recordFrame;
	///////********
	private JButton boton;
	private Pentagrama penta = new Pentagrama(1);
	private int velocidad1 = 700, velocidad2 = 900;
	private IconoDeArchivo icono;
	private FiltroDeArchivo filtro;
	private Pentagrama fram;
	private PanelDibujo panelD;
	
	public Instrumento(Pentagrama pf)
	{
		fram = pf;
		//////*******////////
		setLayout(new BorderLayout());
		Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		Border loweredBevel = BorderFactory.createLoweredBevelBorder();
		compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
		setBorder(compound);
		//penta = new Pentagrama(1);
		try
		{
			if (sintonizador == null)
			{
				if ((sintonizador = MidiSystem.getSynthesizer()) == null)
				{
					System.out.println("getSynthesizer() failed!");
					return;
				}
			}
			try
			{
				sintonizador.open();
			}
			catch (MidiUnavailableException mu)
			{
				llamadaDeErrorDeSonido(mu);
				//System.out.println(mu);
			}
			catch (SecurityException se)
			{
				System.out.println(se);
			}
			sequencer = MidiSystem.getSequencer();
			sequence = new Sequence(Sequence.PPQ, 10);
		}
        catch (Exception ex)
		{
			ex.printStackTrace();
			return;
		}
		
		/////**********///////
		Soundbank sb = sintonizador.getDefaultSoundbank();
		if(sb != null)
		{
			ins = sintonizador.getDefaultSoundbank().getInstruments();
			sintonizador.loadInstrument(ins[0]);
		}
		track = sequence.createTrack ();
		midi = sintonizador.getChannels();
		channels = new ChannelData[midi.length];
		for ( int i = 0 ; i < channels.length ; i++ )
		{
			channels[i] = new ChannelData(midi[i],i);
		}
		cc = channels[0];
		//addMouseListener(this);

		//tab = new InstrumentsTable();
		filtro = new FiltroDeArchivo("mid","mid archivo MIDI");
		icono = new IconoDeArchivo();
		icono.putIcon("mid",new ImageIcon("imagenes/icono2.gif"));
		llenarPanel();

		add(panel);//,BorderLayout.SOUTH);
		setVisible(true);
	}

	public void creaEvento(int type, double num, PanelDibujo panelDib, Figura figu)
	{
		if ( num == 6.0 || num == 4.0 || num == 3.0 || num == 2.0 || num == 1.0 || num == 1.5 )
		{
			System.out.println ("Entro al 1");
			creaMusica(type,num,velocidad1,panelDib,figu);
		}
		else
		{
			if ( num == 0.5 || num == 0.25 || num == 0.75 || num == 0.375 )
			{
				System.out.println ("Entro al 2##");
				creaMusica(type,num,velocidad2,panelDib,figu);
			}
		}
		/*
		Thread hilo = new Thread();
		key = new Key(type);
		key.on();
		try
		{
			System.out.println("a entrador");
			// 600 para redonda, blanca, negra
			hilo.sleep((int)num*800);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		key.off();
		*/
	}
	
	public void creaMusica(int type, double num, int cant, PanelDibujo panelDib, Figura figu)
	{
		panelDib.getIndicador().setX(figu.getX()-8);
		panelDib.accionarBanderas();
		panelDib.repaint();
		Thread hilo = new Thread();
		if ( type == 0 )
		{
			try
			{
				hilo.sleep((int)(num*cant));
			}
			catch(InterruptedException e)
			{
				System.err.println(e);
			}
		}
		else
		{
			key = new Key(type);
			key.on();
			try
			{
				System.out.println("a entrador");
				// 600 para redonda, blanca, negra
				hilo.sleep((int)(num*cant));
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			key.off();
		}
		panelDib.setBanderaPlay(false);
		panelDib.repaint();
	}
	
	public void setVelocidad(int v1, int v2 )
	{
		velocidad1 = v1;
		velocidad2 = v2;
	}

	public void llenarPanel()
	{
		panel = new JPanel();
		panel.setLayout (new BorderLayout());
		final String names[] = {
			"Piano", "Chromatic Perc.", "Organ", "Guitar",
			"Bass", "Strings", "Ensemble", "Brass",
			"Reed", "Pipe", "Synth Lead", "Synth Pad",
			"Synth Effects", "Ethnic", "Percussive", "Sound Effects" };
		final int nRows = 8;
		final int nCols = names.length;

		TableModel dataModel = new AbstractTableModel()
		{
			public int getColumnCount() { return nCols; }
			public int getRowCount() { return nRows;}
			public Object getValueAt(int r, int c)
			{
				if (ins != null)
				{
					return ins[c*nRows+r].getName();
				}
				else
				{
					return Integer.toString(c*nRows+r);
				}
			}
			public String getColumnName(int c)
			{
				return names[c];
			}
			public Class getColumnClass(int c)
			{
				return getValueAt(0, c).getClass();
			}
			public boolean isCellEditable(int r, int c)
			{
				return false;
			}
			public void setValueAt(Object obj, int r, int c) { }
		};

		table = new JTable(dataModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		/////////**********
		ListSelectionModel lsm = table.getSelectionModel();
		lsm.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				ListSelectionModel sm = (ListSelectionModel) e.getSource();
				if (!sm.isSelectionEmpty())
				{
					cc.row = sm.getMinSelectionIndex();
				}
				programChange(cc.col*nRows+cc.row);
			}
		});

		// Listener for column changes
		lsm = table.getColumnModel().getSelectionModel();
		lsm.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				ListSelectionModel sm = (ListSelectionModel) e.getSource();
				if (!sm.isSelectionEmpty())
				{
					cc.col = sm.getMinSelectionIndex();
				}
				programChange(cc.col*nRows+cc.row);
			}
		});
		///////////**********
		table.setPreferredScrollableViewportSize(new Dimension(nCols*110, 200));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		for (int i = 0; i < names.length; i++)
		{
			TableColumn column = table.getColumn(names[i]);
			column.setPreferredWidth(110);
		}
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);

		JScrollPane sp = new JScrollPane(table);
		sp.setVerticalScrollBarPolicy(sp.VERTICAL_SCROLLBAR_NEVER);
		sp.setHorizontalScrollBarPolicy(sp.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(sp);
	}///***********

	public Dimension getPreferredSize()
	{
		return new Dimension(800,170);
	}

	public Dimension getMaximumSize()
	{
		return new Dimension(800,170);
	}

	private void programChange(int program)
	{
		if (ins != null)
		{
			System.out.println (ins[program].getName ());
			sintonizador.loadInstrument(ins[program]);
		}
		cc.channel.programChange(program);
		if (false)
		{
			//createShortEvent(PROGRAM, program);
		}
	}

	class ChannelData
	{
		MidiChannel channel;
		boolean solo, mono, mute, sustain;
		int velocity, pressure, bend, reverb;
		int row, col, num;

		public ChannelData(MidiChannel channel, int num)
		{
			this.channel = channel;
			this.num = num;
			velocity = pressure = bend = reverb = 64;
		}

		public void setComponentStates()
		{
			table.setRowSelectionInterval(row, row);
			table.setColumnSelectionInterval(col, col);
		}
	}

	class Key
	{
		int noteState = OFF;
		int kNum;
		public Key(int num)
		{
			kNum = num;
		}
		public boolean isNoteOn()
		{
			return noteState == ON;
		}
		public void on()
		{
			setNoteState(ON);
			cc.channel.noteOn(kNum, cc.velocity);
			if (record)
			{
				createShortEvent(NOTEON, kNum);
			}
		}
		public void off()
		{
			setNoteState(OFF);
			cc.channel.noteOff(kNum, cc.velocity);
			if (record)
			{
				createShortEvent(NOTEOFF, kNum);
			}
		}
		public void setNoteState(int state)
		{
			noteState = state;
		}
	}
	
	public void llamadaDeErrorDeSonido(MidiUnavailableException e)
	{
		String dialogo = "Se a detectado que en su equipo no esta \n"+ 
						"configurada la targeta de sonido por tanto \n usted no podra ejecutar este programa \n"+e;
		
		JOptionPane.showMessageDialog (this,dialogo,"Error de Sonido",JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
	
	/**
	 * A frame that allows for midi capture & saving the captured data.
     */
	class RecordFrame extends JPanel implements ActionListener, MetaEventListener
	{
		public JButton recordB, playB, saveB;
		Vector tracks = new Vector();
		DefaultListModel listModel = new DefaultListModel();
		TableModel dataModel;
		JTable table;
		JButton cerr;
		JPanel pan;
		
		public RecordFrame()
		{
			//super(fram,"Creando Midi...",true);
			try
			{
				
				//***this.setIconImage((new ImageIcon("imagenes/kmidi.gif")).getImage());
				//setFrameIcon(new ImageIcon("imagenes/kmidi.gif"));
				//getContentPane().setLayout(new BorderLayout());
				setLayout(new BorderLayout());
				/*
				addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						recordFrame = null;
					}
            	});*/
            	
            	sequencer.addMetaEventListener(this);
            	try
            	{
            		sequence = new Sequence(Sequence.PPQ, 10);
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
				try
				{
					pan = new JPanel ( new FlowLayout(FlowLayout.RIGHT) );
					cerr = new JButton("Cerrar");
					pan.setBorder(compound);
					pan.add(cerr);
					
					cerr.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							recordFrame.setVisible(false);
							recordFrame = null;
						}
					});
				}
				catch(Exception e)
				{
					System.err.println("Error en cerrar = "+e);
				}
				
				JPanel p1 = new JPanel(new BorderLayout());
				
				JPanel p2 = new JPanel();
				p2.setBorder(new EmptyBorder(5,5,5,5));
				p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
				
				recordB = createButton("Grabar", p2, true);
				playB = createButton("Play", p2, false);
				saveB = createButton("Guardar...", p2, false);
				
				////getContentPane().add("North", p2);
				add("North", p2);
				
				final String[] names = { "Channel #", "Instrumento" };
				
				dataModel = new AbstractTableModel()
				{
					public int getColumnCount()
					{
						return names.length;
					}
					public int getRowCount()
					{
						return tracks.size();
					}
					public Object getValueAt(int row, int col)
					{
						if (col == 0)
						{
							return ((TrackData) tracks.get(row)).chanNum;
						} else if (col == 1) {
                        	return ((TrackData) tracks.get(row)).name;
                    	} 
                    	return null;
                	}
                	
					public String getColumnName(int col)
					{
						return names[col];
					}
					
					public Class getColumnClass(int c)
					{
						return getValueAt(0, c).getClass();
					}
                	
					public boolean isCellEditable(int row, int col)
					{
						return false;
                	}
                	
					public void setValueAt(Object val, int row, int col)
					{
						if (col == 0)
						{
							((TrackData) tracks.get(row)).chanNum = (Integer) val;
                    	} else if (col == 1) {
                        	((TrackData) tracks.get(row)).name = (String) val;
                    	}
                	}
            	}; /// Fin del dataModel
            	
            	table = new JTable(dataModel);
				TableColumn col = table.getColumn("Channel #");
				col.setMaxWidth(65);
				table.sizeColumnsToFit(0);
				
				JScrollPane scrollPane = new JScrollPane(table);
				EmptyBorder eb = new EmptyBorder(0,5,5,5);
				scrollPane.setBorder(new CompoundBorder(eb,new EtchedBorder()));
				
				//getContentPane().add( scrollPane, BorderLayout.CENTER);
				add( scrollPane, BorderLayout.CENTER);
				/*
				try
				{
					////getContentPane().add(pan, BorderLayout.SOUTH);
					add(pan, BorderLayout.SOUTH);
				}
				catch(Exception e)
				{
					System.err.println("Error ## = "+e);
				}*/
				/*
				pack();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				int w = 210;
				int h = 160;
				setLocation(d.width/2 - w/2, d.height/2 - h/2);
				setSize(w, h);
				setVisible(true);*/
			}
			catch ( Exception e)
			{
				System.err.println("#Error en constructor = "+e);
			}
        } // Fin del constructor


        public JButton createButton(String name, JPanel p, boolean state)
        {
            JButton b = new JButton(name);
            b.setFont(new Font("serif", Font.PLAIN, 12));
            b.setEnabled(state);
            b.addActionListener(this);
            p.add(b);
            return b;
        }
		
		
        public void actionPerformed(ActionEvent e)
        {
            JButton button = (JButton) e.getSource();
            if (button.equals(recordB))
            {
            	record = recordB.getText().startsWith("Grabar");
                if (record)
                {
                	Thread hilo = new Thread()
                	{
                		public void run()
                		{
                			track = sequence.createTrack();
                    		startTime = System.currentTimeMillis();
							
							// add a program change right at the beginning of 
                    		// the track for the current instrument
                    		createShortEvent(PROGRAM,cc.col*8+cc.row);
									
                    		recordB.setText("Stop");
                    		playB.setEnabled(false);
                    		saveB.setEnabled(false);
                    		Pentagrama.grabarMusica(record);
                    		/*
                    		Thread h = new Thread()
                    		{
                    			public void run()
                    			{
                    				fram.setMensaje(true);
                    			}
                    		};
                    		h.start();*/
                    	}
                    };
                    hilo.start();
                    
                }
                else
                {
                	String name = null;
                    if (ins != null)
                    {
                    	name = ins[cc.col*8+cc.row].getName();
                    }
                    else
                    {
                    	name = Integer.toString(cc.col*8+cc.row);
                    }
                    tracks.add(new TrackData(cc.num+1, name, track)); 
                    table.tableChanged(new TableModelEvent(dataModel));
                    recordB.setText("Grabar");
                    Pentagrama.generarStop();
                    //fram.setMensaje(false);
                    playB.setEnabled(true);
                    saveB.setEnabled(true);
                }
            } else if (button.equals(playB))
            {
            	if (playB.getText().startsWith("Play"))
            	{
            		try
            		{
            			sequencer.open();
                        sequencer.setSequence(sequence);
                    }
                    catch (Exception ex) { ex.printStackTrace(); }
                    sequencer.start();
                    playB.setText("Stop");
                    recordB.setEnabled(false);
                }
                else
                {
                	sequencer.stop();
                	System.out.println("detiene el sequencer****************////////////*/*/*/*");
                    playB.setText("Play");
                    recordB.setEnabled(true);
                }
            } else if (button.equals(saveB))
            {
            	try
            	{
                    File file = new File(System.getProperty("user.dir"));
                    JFileChooser fc = new JFileChooser(file);
                    fc.addChoosableFileFilter(filtro);
                    fc.setFileView(icono);
                    /*
                    fc.setFileFilter(new javax.swing.filechooser.FileFilter() {
                        public boolean accept(File f) {
                            if (f.isDirectory()) {
                                return true;
                            }
                            return false;
                        }
                        public String getDescription() {
                            return "Save as .mid file.";
                        }
                    });*/
                    if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                    {
                        saveMidiFile(fc.getSelectedFile());
                    }
                }
                catch (SecurityException ex)
                { 
                    //JavaSound.showInfoDialog();
                    ex.printStackTrace();
                } catch (Exception ex)
                { 
                    ex.printStackTrace();
                }
            }
        } ///////************


        public void meta(MetaMessage message)
        {
            if (message.getType() == 47) // 47 is end of track
            {
                playB.setText("Play");
                recordB.setEnabled(true);
            }
        }


        public void saveMidiFile(File file)
        {
            try
            {
                int[] fileTypes = MidiSystem.getMidiFileTypes(sequence);
                if (fileTypes.length == 0)
                {
                    System.out.println("No se puede guardar la secuencia");
                }
                else
                {
                    if (MidiSystem.write(sequence, fileTypes[0], file) == -1)
                    {
                        throw new IOException("Problemas al escribir el archivo");
                    }
                }
            }
            catch (SecurityException ex)
            { 
                //JavaSound.showInfoDialog();
            } catch (Exception ex)
            { 
                ex.printStackTrace(); 
            }
        }


        class TrackData extends Object
        {
            Integer chanNum; String name; Track track;
            public TrackData(int chanNum, String name, Track track)
            {
                this.chanNum = new Integer(chanNum);
                this.name = name;
                this.track = track;
            }
        } // End class TrackData
    }
    
    public void createShortEvent(int type, int num)
    {
        ShortMessage message = new ShortMessage();
        try
        {
            long millis = System.currentTimeMillis() - startTime;
            long tick = millis * sequence.getResolution() / 500;
            message.setMessage(type+cc.num, num, cc.velocity); 
            MidiEvent event = new MidiEvent(message, tick);
            track.add(event);
        }
        catch (Exception ex) { ex.printStackTrace(); }
    }
    
    public void entradaDato(boolean res)
    {
    	if(res)
    	{
    		//if ( recordFrame != null )
    		//{
    			//recordFrame.toFront();
    		//}
    		//else
    		//{
    			recordFrame = new RecordFrame();
    			record = true;
    		//}
    	}
    }
    
    public RecordFrame getRecord()
    {
    	return recordFrame;
    }
}