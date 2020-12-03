package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.CardLayout;
import javax.swing.event.ListSelectionListener;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Almacen;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Auxiliar;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Aviso;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Bebida;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Comanda;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.EstadosMesas;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Plato;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JTextPane;

import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class IU_CamareroMesa extends JFrame {

	private static final long serialVersionUID = 1L;

	private int[] stockVirtualPlatos;
	private int[] stockVirtualBebidas;
	private int index;
	private int numNotificacionesPendientes;

	private static IU_CamareroMesa frmCamareroMesa;
	private static IU_Cocina frmCocina;
	private static IU_CamareroBarra frmCamareroBarra;

	private JPanel contentPane;

	private JPanel panelCamareria;
	private JButton btnQuitarBebida;
	private JButton btnAñadirBebida;
	private JComboBox<String> cbBebidas;
	private JLabel lblBebidas;
	private JList<Bebida> listBebidas;
	private JList<Plato> listPostres;
	private JTextArea textPaneEstado;
	private JPanel Avisos;
	private JPanel panelNuevaComanda;
	private JPanel panelAvisos;
	private JComboBox<Aviso> cbAvisos;
	private JPanel panelDatosAviso;
	private JLabel lblInfo;
	private JComboBox<Mesa> cbMesa;
	private JButton btnIniciarComanda;
	private JTextArea textTituloAviso;
	private JTextArea textNMesaAviso;
	private JTextArea textEstadoMesa;
	private JButton btnBorrarAviso;
	private JTextPane textPaneNotificacion;
	private JLabel lblNumNotificaciones;

	private JPanel panelAnotacionComanda;
	private JPanel panelDatosMesa;
	private JPanel panelComanda;
	private JLabel lblNumMesa;
	private JPanel panelCarta;
	private JList<Plato> listEntrantes;
	private JList<Plato> listPrimeros;
	private JList<Plato> listSegundos;
	private JButton btnCerrarComanda;
	private JButton btnCancelar;
	private JComboBox<String> cbEntrantes;
	private JComboBox<String> cbPrimeros;
	private JComboBox<String> cbSegundos;
	private JComboBox<String> cbPostres;
	private JButton btnAñadirEntrante;
	private JButton btnQuitarEntrante;
	private JButton btnAñadirPrimero;
	private JButton btnQuitarPrimero;
	private JButton btnAñadirSegundo;
	private JButton btnQuitarSegundo;
	private JButton btnAñadirPostre;
	private JButton btnQuitarPostre;
	private JLabel lblEntrantes;
	private JLabel lblPrimero;
	private JLabel lblSegundo;
	private JLabel lblPostre;
	private JButton btnLimpiar;

	private static Timer timer;
	private JButton btnCerrarCuenta;
	private JButton btnConfirmarPago;
	private JButton btnMesaPreparada;
	private JTextField textFieldPrecio;
	private JButton btnImprimirCuenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCamareroMesa = new IU_CamareroMesa();
					frmCamareroMesa.setVisible(true);
					frmCamareroMesa.preparativos();

					frmCocina = new IU_Cocina();
					frmCocina.setVisible(true);

					frmCamareroBarra = new IU_CamareroBarra();
					frmCamareroBarra.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IU_CamareroMesa() {

		addWindowListener(new ThisWindowListener()); // Botón de cerrar.

		index = Constantes.INDICE_INICIAL_PRODUCTOS;
		numNotificacionesPendientes = 0;

		stockVirtualPlatos = new int[3];
		stockVirtualBebidas = new int[Constantes.NOMBRES_BEBIDAS.length];
		{
			// Entorno de prueba. Luego el stock se leerá de la BBDD por medio de AlmacenDAO
			// (CDU2):
			for (int i = 0; i < stockVirtualPlatos.length; i++)
				stockVirtualPlatos[i] = 1000;
			for (int i = 0; i < stockVirtualBebidas.length; i++)
				stockVirtualBebidas[i] = 10;
		}

		setTitle("Camarero");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 789);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		{
			panelCamareria = new JPanel();
			contentPane.add(panelCamareria, "Cancelar");
			GridBagLayout gbl_panelCamareria = new GridBagLayout();
			gbl_panelCamareria.columnWidths = new int[] { 0, 0, 0, 0 };
			gbl_panelCamareria.rowHeights = new int[] { 0, 315, 0, 0, 0, 0 };
			gbl_panelCamareria.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
			gbl_panelCamareria.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
			panelCamareria.setLayout(gbl_panelCamareria);
			{
				Avisos = new JPanel();
				Avisos.setBorder(new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
						"Avisos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				GridBagConstraints gbc_Avisos = new GridBagConstraints();
				gbc_Avisos.insets = new Insets(0, 0, 5, 5);
				gbc_Avisos.fill = GridBagConstraints.BOTH;
				gbc_Avisos.gridx = 1;
				gbc_Avisos.gridy = 1;
				panelCamareria.add(Avisos, gbc_Avisos);
				Avisos.setLayout(new BorderLayout(0, 0));
				{
					panelAvisos = new JPanel();
					Avisos.add(panelAvisos, BorderLayout.NORTH);
					{
						cbAvisos = new JComboBox<Aviso>();
						cbAvisos.addActionListener(new CbAvisosActionListener());
						cbAvisos.setEnabled(false);
						panelAvisos.add(cbAvisos);
					}
					{
						lblNumNotificaciones = new JLabel("(" + numNotificacionesPendientes + ")");
						panelAvisos.add(lblNumNotificaciones);
					}
					{
						btnBorrarAviso = new JButton("Borrar aviso");
						btnBorrarAviso.addActionListener(new BtnBorrarAvisoActionListener());
						btnBorrarAviso.setEnabled(false);
						panelAvisos.add(btnBorrarAviso);
					}
					{
						textPaneNotificacion = new JTextPane();
						textPaneNotificacion.setEditable(false);
						panelAvisos.add(textPaneNotificacion);
					}
				}
				{
					panelDatosAviso = new JPanel();
					panelDatosAviso
							.setBorder(new TitledBorder(
									new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
											new Color(160, 160, 160)),
									"Informaci\u00F3n del aviso", TitledBorder.LEADING, TitledBorder.TOP, null,
									new Color(0, 0, 0)));
					Avisos.add(panelDatosAviso, BorderLayout.CENTER);
					GridBagLayout gbl_panelDatosAviso = new GridBagLayout();
					gbl_panelDatosAviso.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
					gbl_panelDatosAviso.rowHeights = new int[] { 0, 53, 0, 85, 0, 0 };
					gbl_panelDatosAviso.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
					gbl_panelDatosAviso.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
					panelDatosAviso.setLayout(gbl_panelDatosAviso);
					{
						textTituloAviso = new JTextArea();
						textTituloAviso.setText("** No hay avisos **");
						textTituloAviso.setEditable(false);
						GridBagConstraints gbc_textTituloAviso = new GridBagConstraints();
						gbc_textTituloAviso.gridwidth = 3;
						gbc_textTituloAviso.insets = new Insets(0, 0, 5, 5);
						gbc_textTituloAviso.fill = GridBagConstraints.BOTH;
						gbc_textTituloAviso.gridx = 1;
						gbc_textTituloAviso.gridy = 1;
						panelDatosAviso.add(textTituloAviso, gbc_textTituloAviso);
					}
					{
						textNMesaAviso = new JTextArea();
						textNMesaAviso.setText("Mesa Número: ***");
						textNMesaAviso.setEditable(false);
						GridBagConstraints gbc_textNMesaAviso = new GridBagConstraints();
						gbc_textNMesaAviso.insets = new Insets(0, 0, 5, 5);
						gbc_textNMesaAviso.fill = GridBagConstraints.BOTH;
						gbc_textNMesaAviso.gridx = 1;
						gbc_textNMesaAviso.gridy = 3;
						panelDatosAviso.add(textNMesaAviso, gbc_textNMesaAviso);
					}
					{
						textEstadoMesa = new JTextArea();
						textEstadoMesa.setText("Estado Mesa: ***");
						textEstadoMesa.setEditable(false);
						GridBagConstraints gbc_textEstadoMesa = new GridBagConstraints();
						gbc_textEstadoMesa.insets = new Insets(0, 0, 5, 5);
						gbc_textEstadoMesa.fill = GridBagConstraints.BOTH;
						gbc_textEstadoMesa.gridx = 3;
						gbc_textEstadoMesa.gridy = 3;
						panelDatosAviso.add(textEstadoMesa, gbc_textEstadoMesa);
					}
				}
			}
			{
				panelNuevaComanda = new JPanel();
				panelNuevaComanda.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Control de mesas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelNuevaComanda.setLayout(null);
				GridBagConstraints gbc_panelNuevaComanda = new GridBagConstraints();
				gbc_panelNuevaComanda.gridheight = 2;
				gbc_panelNuevaComanda.insets = new Insets(0, 0, 5, 5);
				gbc_panelNuevaComanda.fill = GridBagConstraints.BOTH;
				gbc_panelNuevaComanda.gridx = 1;
				gbc_panelNuevaComanda.gridy = 2;
				panelCamareria.add(panelNuevaComanda, gbc_panelNuevaComanda);
				{
					lblInfo = new JLabel("Mesa número");
					lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblInfo.setBounds(64, 89, 109, 24);
					panelNuevaComanda.add(lblInfo);
				}
				{
					cbMesa = new JComboBox<Mesa>();
					cbMesa.addActionListener(new CbMesaActionListener());
					DefaultComboBoxModel<Mesa> modelo = new DefaultComboBoxModel<Mesa>();
					for (int m = 1; m <= Constantes.NUM_MESAS; m++)
						modelo.addElement(new Mesa(m));
					cbMesa.setModel(modelo);
					cbMesa.setBounds(183, 88, 142, 31);
					panelNuevaComanda.add(cbMesa);
				}
				{
					btnIniciarComanda = new JButton("Iniciar Comanda");
					btnIniciarComanda.setEnabled(false);
					btnIniciarComanda.addActionListener(new BtnPanelActionListener());
					btnIniciarComanda.setFont(new Font("Tahoma", Font.BOLD, 16));
					btnIniciarComanda.setBounds(397, 22, 202, 72);
					panelNuevaComanda.add(btnIniciarComanda);
				}
				{
					btnCerrarCuenta = new JButton("Cerrar cuenta");
					btnCerrarCuenta.addActionListener(new BtnCerrarCuentaActionListener());
					btnCerrarCuenta.setEnabled(false);
					btnCerrarCuenta.setBounds(397, 118, 202, 21);
					panelNuevaComanda.add(btnCerrarCuenta);
				}
				{
					btnConfirmarPago = new JButton("Confirmar Pago");
					btnConfirmarPago.addActionListener(new BtnConfirmarPagoActionListener());
					btnConfirmarPago.setEnabled(false);
					btnConfirmarPago.setBounds(397, 178, 202, 21);
					panelNuevaComanda.add(btnConfirmarPago);
				}
				{
					btnMesaPreparada = new JButton("Mesa Preparada");
					btnMesaPreparada.addActionListener(new BtnMesaPreparadaActionListener());
					btnMesaPreparada.setEnabled(false);
					btnMesaPreparada.setBounds(397, 209, 202, 21);
					panelNuevaComanda.add(btnMesaPreparada);
				}
				{
					textFieldPrecio = new JTextField();
					textFieldPrecio.setHorizontalAlignment(SwingConstants.CENTER);
					textFieldPrecio.setText("-");
					textFieldPrecio.setEnabled(false);
					textFieldPrecio.setBounds(286, 148, 96, 19);
					panelNuevaComanda.add(textFieldPrecio);
					textFieldPrecio.setColumns(10);
				}
				{
					btnImprimirCuenta = new JButton("Imprimir cuenta");
					btnImprimirCuenta.addActionListener(new BtnImprimirCuentaActionListener());
					btnImprimirCuenta.setEnabled(false);
					btnImprimirCuenta.setBounds(397, 149, 202, 21);
					panelNuevaComanda.add(btnImprimirCuenta);
				}
			}
		}

		{
			panelAnotacionComanda = new JPanel();
			contentPane.add(panelAnotacionComanda, "Iniciar Comanda");
			panelAnotacionComanda.setLayout(new BorderLayout(0, 0));
			{
				panelDatosMesa = new JPanel();
				panelDatosMesa.setBorder(
						new TitledBorder(null, "Datos Mesa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelAnotacionComanda.add(panelDatosMesa, BorderLayout.NORTH);
				GridBagLayout gbl_panelDatosMesa = new GridBagLayout();
				gbl_panelDatosMesa.columnWidths = new int[] { 290, 193, 171, 47, 0, 0 };
				gbl_panelDatosMesa.rowHeights = new int[] { 28, 0 };
				gbl_panelDatosMesa.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
				gbl_panelDatosMesa.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
				panelDatosMesa.setLayout(gbl_panelDatosMesa);
				{
					lblNumMesa = new JLabel("Mesa Número 6");
					lblNumMesa.setFont(new Font("Tahoma", Font.BOLD, 15));
					GridBagConstraints gbc_lblNumMesa = new GridBagConstraints();
					gbc_lblNumMesa.insets = new Insets(0, 0, 0, 5);
					gbc_lblNumMesa.gridx = 0;
					gbc_lblNumMesa.gridy = 0;
					panelDatosMesa.add(lblNumMesa, gbc_lblNumMesa);
				}
				{
					textPaneEstado = new JTextArea();
					textPaneEstado.setEditable(false);
					GridBagConstraints gbc_textPaneEstado = new GridBagConstraints();
					gbc_textPaneEstado.gridwidth = 3;
					gbc_textPaneEstado.insets = new Insets(0, 0, 0, 5);
					gbc_textPaneEstado.fill = GridBagConstraints.BOTH;
					gbc_textPaneEstado.gridx = 1;
					gbc_textPaneEstado.gridy = 0;
					panelDatosMesa.add(textPaneEstado, gbc_textPaneEstado);
				}
			}
			{
				panelComanda = new JPanel();
				panelComanda.setBorder(
						new TitledBorder(null, "Comanda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelAnotacionComanda.add(panelComanda, BorderLayout.CENTER);
				GridBagLayout gbl_panelComanda = new GridBagLayout();
				gbl_panelComanda.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 15, 0, 0 };
				gbl_panelComanda.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				gbl_panelComanda.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0,
						Double.MIN_VALUE };
				gbl_panelComanda.rowWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
						1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
				panelComanda.setLayout(gbl_panelComanda);
				{
					lblBebidas = new JLabel("Bebidas:");
					lblBebidas.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblBebidas = new GridBagConstraints();
					gbc_lblBebidas.insets = new Insets(0, 0, 5, 5);
					gbc_lblBebidas.gridx = 5;
					gbc_lblBebidas.gridy = 0;
					panelComanda.add(lblBebidas, gbc_lblBebidas);
				}
				{
					panelCarta = new JPanel();
					panelCarta.setBorder(
							new TitledBorder(null, "Carta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					GridBagConstraints gbc_panelCarta = new GridBagConstraints();
					gbc_panelCarta.gridwidth = 3;
					gbc_panelCarta.gridheight = 14;
					gbc_panelCarta.insets = new Insets(0, 0, 5, 5);
					gbc_panelCarta.fill = GridBagConstraints.BOTH;
					gbc_panelCarta.gridx = 1;
					gbc_panelCarta.gridy = 1;
					panelComanda.add(panelCarta, gbc_panelCarta);
					GridBagLayout gbl_panelCarta = new GridBagLayout();
					gbl_panelCarta.columnWidths = new int[] { 8, 222, 0, 10, 0, 0 };
					gbl_panelCarta.rowHeights = new int[] { 21, 0, 45, 0, 0, 51, 0, 29, 0, -5, 30, 0, 0, 0, 0 };
					gbl_panelCarta.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
					gbl_panelCarta.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0,
							1.0, 0.0, 0.0, Double.MIN_VALUE };
					panelCarta.setLayout(gbl_panelCarta);
					{
						{
							btnQuitarEntrante = new JButton("Quitar");
							btnQuitarEntrante.setEnabled(false);
							btnQuitarEntrante.addActionListener(new BtnQuitarEntranteActionListener());
							{
								btnAñadirEntrante = new JButton("Añadir");
								btnAñadirEntrante.setEnabled(false);
								btnAñadirEntrante.addActionListener(new BtnAñadirEntranteActionListener());
								{
									cbEntrantes = new JComboBox<String>();
									cbEntrantes.addActionListener(new CbEntrantesActionListener());
									{
										cbBebidas = new JComboBox<String>();
										cbBebidas.addActionListener(new CbBebidaActionListener());
										cbBebidas
												.setModel(new DefaultComboBoxModel<String>(Constantes.NOMBRES_BEBIDAS));
										GridBagConstraints gbc_cbBebidas = new GridBagConstraints();
										gbc_cbBebidas.insets = new Insets(0, 0, 5, 5);
										gbc_cbBebidas.fill = GridBagConstraints.HORIZONTAL;
										gbc_cbBebidas.gridx = 1;
										gbc_cbBebidas.gridy = 0;
										panelCarta.add(cbBebidas, gbc_cbBebidas);
									}
									{
										btnAñadirBebida = new JButton("Añadir");
										btnAñadirBebida.setEnabled(false);
										btnAñadirBebida.addActionListener(new BtnAñadirBebidaActionListener());
										GridBagConstraints gbc_btnAñadirBebida = new GridBagConstraints();
										gbc_btnAñadirBebida.insets = new Insets(0, 0, 5, 5);
										gbc_btnAñadirBebida.gridx = 3;
										gbc_btnAñadirBebida.gridy = 0;
										panelCarta.add(btnAñadirBebida, gbc_btnAñadirBebida);
									}
									{
										btnQuitarBebida = new JButton("Quitar");
										btnQuitarBebida.setEnabled(false);
										btnQuitarBebida.addActionListener(new BtnQuitarBebidaActionListener());
										GridBagConstraints gbc_btnQuitarBebida = new GridBagConstraints();
										gbc_btnQuitarBebida.insets = new Insets(0, 0, 5, 5);
										gbc_btnQuitarBebida.gridx = 3;
										gbc_btnQuitarBebida.gridy = 1;
										panelCarta.add(btnQuitarBebida, gbc_btnQuitarBebida);
									}
									cbEntrantes
											.setModel(new DefaultComboBoxModel<String>(Constantes.NOMBRES_ENTRANTES));
									GridBagConstraints gbc_cbEntrantes = new GridBagConstraints();
									gbc_cbEntrantes.insets = new Insets(0, 0, 5, 5);
									gbc_cbEntrantes.anchor = GridBagConstraints.NORTH;
									gbc_cbEntrantes.fill = GridBagConstraints.HORIZONTAL;
									gbc_cbEntrantes.gridx = 1;
									gbc_cbEntrantes.gridy = 3;
									panelCarta.add(cbEntrantes, gbc_cbEntrantes);
								}
								GridBagConstraints gbc_btnAñadirEntrante = new GridBagConstraints();
								gbc_btnAñadirEntrante.insets = new Insets(0, 0, 5, 5);
								gbc_btnAñadirEntrante.gridx = 3;
								gbc_btnAñadirEntrante.gridy = 3;
								panelCarta.add(btnAñadirEntrante, gbc_btnAñadirEntrante);
							}
							GridBagConstraints gbc_btnQuitarEntrante = new GridBagConstraints();
							gbc_btnQuitarEntrante.insets = new Insets(0, 0, 5, 5);
							gbc_btnQuitarEntrante.gridx = 3;
							gbc_btnQuitarEntrante.gridy = 4;
							panelCarta.add(btnQuitarEntrante, gbc_btnQuitarEntrante);
						}
					}
					{
						btnQuitarPostre = new JButton("Quitar");
						btnQuitarPostre.addActionListener(new BtnQuitarPostreActionListener());
						{
							btnAñadirPostre = new JButton("Añadir");
							btnAñadirPostre.addActionListener(new BtnAñadirPostreActionListener());
							{
								cbPostres = new JComboBox<String>();
								cbPostres.addActionListener(new CbPostresActionListener());
								{
									btnQuitarSegundo = new JButton("Quitar");
									btnQuitarSegundo.addActionListener(new BtnQuitarSegundoActionListener());
									{
										btnAñadirSegundo = new JButton("Añadir");
										btnAñadirSegundo.addActionListener(new BtnAñadirSegundoActionListener());
										{
											cbSegundos = new JComboBox<String>();
											cbSegundos.addActionListener(new CbSegundosActionListener());
											{
												btnQuitarPrimero = new JButton("Quitar");
												btnQuitarPrimero
														.addActionListener(new BtnQuitarPrimeroActionListener());
												{
													btnAñadirPrimero = new JButton("Añadir");
													btnAñadirPrimero
															.addActionListener(new BtnAñadirPrimeroActionListener());
													cbPrimeros = new JComboBox<String>();
													cbPrimeros.addActionListener(new CbPrimerosActionListener());
													cbPrimeros.setModel(new DefaultComboBoxModel<String>(
															Constantes.NOMBRES_PRIMEROS));
													GridBagConstraints gbc_cbPrimeros = new GridBagConstraints();
													gbc_cbPrimeros.insets = new Insets(0, 0, 5, 5);
													gbc_cbPrimeros.fill = GridBagConstraints.HORIZONTAL;
													gbc_cbPrimeros.gridx = 1;
													gbc_cbPrimeros.gridy = 6;
													panelCarta.add(cbPrimeros, gbc_cbPrimeros);
													btnAñadirPrimero.setEnabled(false);
													GridBagConstraints gbc_btnAñadirPrimero = new GridBagConstraints();
													gbc_btnAñadirPrimero.insets = new Insets(0, 0, 5, 5);
													gbc_btnAñadirPrimero.gridx = 3;
													gbc_btnAñadirPrimero.gridy = 6;
													panelCarta.add(btnAñadirPrimero, gbc_btnAñadirPrimero);
												}
												btnQuitarPrimero.setEnabled(false);
												GridBagConstraints gbc_btnQuitarPrimero = new GridBagConstraints();
												gbc_btnQuitarPrimero.insets = new Insets(0, 0, 5, 5);
												gbc_btnQuitarPrimero.gridx = 3;
												gbc_btnQuitarPrimero.gridy = 7;
												panelCarta.add(btnQuitarPrimero, gbc_btnQuitarPrimero);
											}
											cbSegundos.setModel(
													new DefaultComboBoxModel<String>(Constantes.NOMBRES_SEGUNDOS));
											GridBagConstraints gbc_cbSegundos = new GridBagConstraints();
											gbc_cbSegundos.insets = new Insets(0, 0, 5, 5);
											gbc_cbSegundos.fill = GridBagConstraints.HORIZONTAL;
											gbc_cbSegundos.gridx = 1;
											gbc_cbSegundos.gridy = 9;
											panelCarta.add(cbSegundos, gbc_cbSegundos);
										}
										btnAñadirSegundo.setEnabled(false);
										GridBagConstraints gbc_btnAñadirSegundo = new GridBagConstraints();
										gbc_btnAñadirSegundo.insets = new Insets(0, 0, 5, 5);
										gbc_btnAñadirSegundo.gridx = 3;
										gbc_btnAñadirSegundo.gridy = 9;
										panelCarta.add(btnAñadirSegundo, gbc_btnAñadirSegundo);
									}
									btnQuitarSegundo.setEnabled(false);
									GridBagConstraints gbc_btnQuitarSegundo = new GridBagConstraints();
									gbc_btnQuitarSegundo.insets = new Insets(0, 0, 5, 5);
									gbc_btnQuitarSegundo.gridx = 3;
									gbc_btnQuitarSegundo.gridy = 10;
									panelCarta.add(btnQuitarSegundo, gbc_btnQuitarSegundo);
								}
								cbPostres.setModel(new DefaultComboBoxModel<String>(Constantes.NOMBRES_POSTRES));
								GridBagConstraints gbc_cbPostres = new GridBagConstraints();
								gbc_cbPostres.insets = new Insets(0, 0, 5, 5);
								gbc_cbPostres.fill = GridBagConstraints.HORIZONTAL;
								gbc_cbPostres.gridx = 1;
								gbc_cbPostres.gridy = 12;
								panelCarta.add(cbPostres, gbc_cbPostres);
							}
							btnAñadirPostre.setEnabled(false);
							GridBagConstraints gbc_btnAñadirPostre = new GridBagConstraints();
							gbc_btnAñadirPostre.insets = new Insets(0, 0, 5, 5);
							gbc_btnAñadirPostre.gridx = 3;
							gbc_btnAñadirPostre.gridy = 12;
							panelCarta.add(btnAñadirPostre, gbc_btnAñadirPostre);
						}
						btnQuitarPostre.setEnabled(false);
						GridBagConstraints gbc_btnQuitarPostre = new GridBagConstraints();
						gbc_btnQuitarPostre.insets = new Insets(0, 0, 0, 5);
						gbc_btnQuitarPostre.gridx = 3;
						gbc_btnQuitarPostre.gridy = 13;
						panelCarta.add(btnQuitarPostre, gbc_btnQuitarPostre);
					}
				}
				{
					listEntrantes = new JList<Plato>(new DefaultListModel<Plato>());
					listEntrantes.addListSelectionListener(new ListEntrantesListSelectionListener());
					{
						listBebidas = new JList<Bebida>(new DefaultListModel<Bebida>());
						listBebidas.addListSelectionListener(new ListBebidasListSelectionListener());
						GridBagConstraints gbc_listBebidas = new GridBagConstraints();
						gbc_listBebidas.gridheight = 2;
						gbc_listBebidas.gridwidth = 2;
						gbc_listBebidas.insets = new Insets(0, 0, 5, 5);
						gbc_listBebidas.fill = GridBagConstraints.BOTH;
						gbc_listBebidas.gridx = 5;
						gbc_listBebidas.gridy = 1;
						panelComanda.add(listBebidas, gbc_listBebidas);
					}
					{
						lblEntrantes = new JLabel("Entrantes:");
						lblEntrantes.setFont(new Font("Tahoma", Font.BOLD, 14));
						GridBagConstraints gbc_lblEntrantes = new GridBagConstraints();
						gbc_lblEntrantes.insets = new Insets(0, 0, 5, 5);
						gbc_lblEntrantes.gridx = 5;
						gbc_lblEntrantes.gridy = 3;
						panelComanda.add(lblEntrantes, gbc_lblEntrantes);
					}
					GridBagConstraints gbc_listEntrantes = new GridBagConstraints();
					gbc_listEntrantes.gridwidth = 2;
					gbc_listEntrantes.gridheight = 2;
					gbc_listEntrantes.insets = new Insets(0, 0, 5, 5);
					gbc_listEntrantes.fill = GridBagConstraints.BOTH;
					gbc_listEntrantes.gridx = 5;
					gbc_listEntrantes.gridy = 4;
					panelComanda.add(listEntrantes, gbc_listEntrantes);
				}
				{
					lblPrimero = new JLabel("Primeros:");
					lblPrimero.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblPrimero = new GridBagConstraints();
					gbc_lblPrimero.insets = new Insets(0, 0, 5, 5);
					gbc_lblPrimero.gridx = 5;
					gbc_lblPrimero.gridy = 6;
					panelComanda.add(lblPrimero, gbc_lblPrimero);
				}
				{
					listPrimeros = new JList<Plato>(new DefaultListModel<Plato>());
					listPrimeros.addListSelectionListener(new ListPrimerosListSelectionListener());
					GridBagConstraints gbc_listPrimeros = new GridBagConstraints();
					gbc_listPrimeros.gridwidth = 2;
					gbc_listPrimeros.gridheight = 2;
					gbc_listPrimeros.insets = new Insets(0, 0, 5, 5);
					gbc_listPrimeros.fill = GridBagConstraints.BOTH;
					gbc_listPrimeros.gridx = 5;
					gbc_listPrimeros.gridy = 7;
					panelComanda.add(listPrimeros, gbc_listPrimeros);
				}
				{
					lblSegundo = new JLabel("Segundos:");
					lblSegundo.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblSegundo = new GridBagConstraints();
					gbc_lblSegundo.insets = new Insets(0, 0, 5, 5);
					gbc_lblSegundo.gridx = 5;
					gbc_lblSegundo.gridy = 9;
					panelComanda.add(lblSegundo, gbc_lblSegundo);
				}
				{
					listSegundos = new JList<Plato>(new DefaultListModel<Plato>());
					listSegundos.addListSelectionListener(new ListSegundosListSelectionListener());
					GridBagConstraints gbc_listSegundos = new GridBagConstraints();
					gbc_listSegundos.gridwidth = 2;
					gbc_listSegundos.gridheight = 2;
					gbc_listSegundos.insets = new Insets(0, 0, 5, 5);
					gbc_listSegundos.fill = GridBagConstraints.BOTH;
					gbc_listSegundos.gridx = 5;
					gbc_listSegundos.gridy = 10;
					panelComanda.add(listSegundos, gbc_listSegundos);
				}
				{
					lblPostre = new JLabel("Postres:");
					lblPostre.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblPostre = new GridBagConstraints();
					gbc_lblPostre.insets = new Insets(0, 0, 5, 5);
					gbc_lblPostre.gridx = 5;
					gbc_lblPostre.gridy = 12;
					panelComanda.add(lblPostre, gbc_lblPostre);
				}
				{
					listPostres = new JList<Plato>(new DefaultListModel<Plato>());
					listPostres.addListSelectionListener(new ListPostresListSelectionListener());
					GridBagConstraints gbc_listPostres = new GridBagConstraints();
					gbc_listPostres.gridheight = 2;
					gbc_listPostres.gridwidth = 2;
					gbc_listPostres.insets = new Insets(0, 0, 5, 5);
					gbc_listPostres.fill = GridBagConstraints.BOTH;
					gbc_listPostres.gridx = 5;
					gbc_listPostres.gridy = 13;
					panelComanda.add(listPostres, gbc_listPostres);
				}
				{
					btnCancelar = new JButton("Cancelar");
					btnCancelar.addActionListener(new BtnPanelActionListener());
					btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
					GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
					gbc_btnCancelar.fill = GridBagConstraints.BOTH;
					gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
					gbc_btnCancelar.gridx = 1;
					gbc_btnCancelar.gridy = 16;
					panelComanda.add(btnCancelar, gbc_btnCancelar);
				}
				{
					btnCerrarComanda = new JButton("Cerrar Comanda");
					btnCerrarComanda.setEnabled(false);
					btnCerrarComanda.addActionListener(new BtnCerrarComandaActionListener());
					{
						btnLimpiar = new JButton("Limpiar");
						btnLimpiar.setEnabled(false);
						btnLimpiar.addActionListener(new BtnLimpiarActionListener());
						GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
						gbc_btnLimpiar.fill = GridBagConstraints.BOTH;
						gbc_btnLimpiar.insets = new Insets(0, 0, 5, 5);
						gbc_btnLimpiar.gridx = 3;
						gbc_btnLimpiar.gridy = 16;
						panelComanda.add(btnLimpiar, gbc_btnLimpiar);
					}
					btnCerrarComanda.setFont(new Font("Tahoma", Font.BOLD, 15));
					GridBagConstraints gbc_btnCerrarComanda = new GridBagConstraints();
					gbc_btnCerrarComanda.fill = GridBagConstraints.BOTH;
					gbc_btnCerrarComanda.gridwidth = 2;
					gbc_btnCerrarComanda.insets = new Insets(0, 0, 5, 5);
					gbc_btnCerrarComanda.gridx = 5;
					gbc_btnCerrarComanda.gridy = 16;
					panelComanda.add(btnCerrarComanda, gbc_btnCerrarComanda);
				}
			}
		}

	}

	private void mostrarMsgEstado(String mensaje) {
		textPaneEstado.setText(mensaje);
	}

	// BEBIDAS
	private class CbBebidaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Bebida aux = new Bebida(index, (String) cbBebidas.getSelectedItem());
				if (Almacen.comprobarStockVirtualBebidas(stockVirtualBebidas, aux.getNombre())) {
					btnAñadirBebida.setEnabled(true);

					mostrarMsgEstado("Se ha seleccionado " + aux.getNombre() + ". Se puede añadir.");
				} else {
					btnAñadirBebida.setEnabled(false);

					mostrarMsgEstado("Se ha seleccionado " + (String) cbBebidas.getSelectedItem()
							+ ". No se puede añadir por insuficiencia de stock. (Stock virtual: "
							+ Auxiliar.imprimirVector(stockVirtualBebidas) + ").");
				}
			} catch (NullPointerException exc) {
				// Se causa e ignora con el comboBox.setSelectedIndex(-1);
			}

		}
	}

	private class BtnAñadirBebidaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Bebida b = new Bebida(index++, (String) cbBebidas.getSelectedItem());

			((DefaultListModel<Bebida>) listBebidas.getModel()).addElement(b);
			stockVirtualBebidas = Almacen.reducirStockVirtualBebidas(stockVirtualBebidas, b.getNombre());

			mostrarMsgEstado("Bebida " + b.toString() + " añadida con éxito. " + "(Stock virtual: "
					+ Auxiliar.imprimirVector(stockVirtualBebidas) + ").");

			Bebida aux = new Bebida(index, (String) cbBebidas.getSelectedItem());
			if (!Almacen.comprobarStockVirtualBebidas(stockVirtualBebidas, aux.getNombre())) {
				btnAñadirBebida.setEnabled(false);
				mostrarMsgEstado("Se acaba de terminar el stock de esta bebida " + aux.getNombre()
						+ ".\n(Stock virtual: " + Auxiliar.imprimirVector(stockVirtualBebidas) + ").");
			}

			btnCerrarComanda.setEnabled(true);
			btnLimpiar.setEnabled(true);
		}
	}

	private class ListBebidasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if (listBebidas.getSelectedIndex() >= 0)
				btnQuitarBebida.setEnabled(true);
			else
				btnQuitarBebida.setEnabled(false);
		}
	}

	private class BtnQuitarBebidaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Bebida b = ((DefaultListModel<Bebida>) listBebidas.getModel()).get(listBebidas.getSelectedIndex());
			stockVirtualBebidas = Almacen.aumentarStockVirtualBebidas(stockVirtualBebidas, b.getNombre());
			((DefaultListModel<Bebida>) listBebidas.getModel()).remove(listBebidas.getSelectedIndex());

			retrasarIds(b.getId());
			index--;

			mostrarMsgEstado("Bebida " + b.toString() + " eliminado con éxito. \n(Stock virtual: "
					+ Auxiliar.imprimirVector(stockVirtualBebidas) + ").");

			if (index == Constantes.INDICE_INICIAL_PRODUCTOS) {
				btnCerrarComanda.setEnabled(false);
				btnLimpiar.setEnabled(false);
			}
		}
	}

	// ENTRANTES
	private class CbEntrantesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoComboBox(cbEntrantes, btnAñadirEntrante);
		}
	}

	private class BtnAñadirEntranteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoAñadir(cbEntrantes, btnAñadirEntrante, listEntrantes);
		}
	}

	private class ListEntrantesListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			eventoLista(listEntrantes, btnQuitarEntrante);
		}
	}

	private class BtnQuitarEntranteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoQuitar(listEntrantes);
		}
	}

	// PRIMEROS
	private class CbPrimerosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoComboBox(cbPrimeros, btnAñadirPrimero);
		}
	}

	private class BtnAñadirPrimeroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoAñadir(cbPrimeros, btnAñadirPrimero, listPrimeros);
		}
	}

	private class ListPrimerosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			eventoLista(listPrimeros, btnQuitarPrimero);
		}
	}

	private class BtnQuitarPrimeroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoQuitar(listPrimeros);
		}
	}

	// SEGUNDOS
	private class CbSegundosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoComboBox(cbSegundos, btnAñadirSegundo);
		}
	}

	private class BtnAñadirSegundoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoAñadir(cbSegundos, btnAñadirSegundo, listSegundos);
		}
	}

	private class ListSegundosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			eventoLista(listSegundos, btnQuitarSegundo);
		}
	}

	private class BtnQuitarSegundoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoQuitar(listSegundos);
		}
	}

	// POSTRES
	private class CbPostresActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoComboBox(cbPostres, btnAñadirPostre);
		}
	}

	private class BtnAñadirPostreActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoAñadir(cbPostres, btnAñadirPostre, listPostres);
		}
	}

	private class BtnQuitarPostreActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoQuitar(listPostres);
		}
	}

	private class ListPostresListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			eventoLista(listPostres, btnQuitarPostre);
		}
	}

	// MODULARIDAD DE EVENTOS DE PLATOS
	private void eventoComboBox(JComboBox<String> comboBox, JButton btnAñadir) {
		try {
			Plato aux = new Plato(index, (String) comboBox.getSelectedItem());
			if (Almacen.comprobarStockVirtualPlatos(stockVirtualPlatos, aux.getIngredientes())) {
				btnAñadir.setEnabled(true);

				mostrarMsgEstado("Se ha seleccionado " + aux.getNombre() + ". Se puede añadir.");
			} else {
				btnAñadir.setEnabled(false);

				mostrarMsgEstado("Se ha seleccionado " + (String) comboBox.getSelectedItem()
						+ ". No se puede añadir por insuficiencia de stock. (Stock virtual: "
						+ Auxiliar.imprimirVector(stockVirtualPlatos) + "). (Stock necesario: "
						+ Auxiliar.imprimirVector(aux.getIngredientes()) + ").");
			}
		} catch (NullPointerException exc) {
			// Se causa e ignora con el comboBox.setSelectedIndex(-1);
		}
	}

	private void eventoAñadir(JComboBox<String> comboBox, JButton btnAñadir, JList<Plato> lista) {
		Plato p = new Plato(index++, (String) comboBox.getSelectedItem());

		((DefaultListModel<Plato>) lista.getModel()).addElement(p);
		stockVirtualPlatos = Almacen.reducirStockVirtualPlatos(stockVirtualPlatos, p.getIngredientes());

		mostrarMsgEstado("Plato " + p.toString() + " añadido con éxito. " + "(Stock virtual: "
				+ Auxiliar.imprimirVector(stockVirtualPlatos) + ").");

		Plato aux = new Plato(index, (String) comboBox.getSelectedItem());
		if (!Almacen.comprobarStockVirtualPlatos(stockVirtualPlatos, aux.getIngredientes())) {
			btnAñadir.setEnabled(false);
			mostrarMsgEstado("Se acaba de terminar el stock de ingredientes para cocinar este plato " + aux.getNombre()
					+ ". \n(Stock virtual: " + Auxiliar.imprimirVector(stockVirtualPlatos) + "). (Stock necesario: "
					+ Auxiliar.imprimirVector(p.getIngredientes()) + ").");
		}

		btnCerrarComanda.setEnabled(true);
		btnLimpiar.setEnabled(true);

	}

	private void eventoLista(JList<Plato> lista, JButton btnQuitar) {
		if (lista.getSelectedIndex() >= 0)
			btnQuitar.setEnabled(true);
		else
			btnQuitar.setEnabled(false);
	}

	private void eventoQuitar(JList<Plato> lista) {
		Plato p = ((DefaultListModel<Plato>) lista.getModel()).get(lista.getSelectedIndex());
		stockVirtualPlatos = Almacen.aumentarStockVirtualPlatos(stockVirtualPlatos, p.getIngredientes());
		((DefaultListModel<Plato>) lista.getModel()).remove(lista.getSelectedIndex());

		retrasarIds(p.getId());
		index--;

		mostrarMsgEstado("Plato " + p.toString() + " eliminado con éxito. \n(Stock virtual: "
				+ Auxiliar.imprimirVector(stockVirtualPlatos) + ").");

		if (index == Constantes.INDICE_INICIAL_PRODUCTOS) {
			btnCerrarComanda.setEnabled(false);
			btnLimpiar.setEnabled(false);
		}
	}

	private class BtnPanelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCancelar) {
				int sel = JOptionPane.showOptionDialog(contentPane, "¿Seguro que quieres cancelar?", "Cancelar comadna",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (sel == JOptionPane.YES_OPTION) {
					CardLayout panel = (CardLayout) (contentPane.getLayout());
					panel.show(contentPane, e.getActionCommand());
					limpiarAnotacionComanda();
					lblNumMesa.setText("Mesa Número: " + cbMesa.getSelectedItem());
				} else {
					return;
				}
			}
			CardLayout panel = (CardLayout) (contentPane.getLayout());
			panel.show(contentPane, e.getActionCommand());
			limpiarAnotacionComanda();
			lblNumMesa.setText("Mesa Número: " + cbMesa.getSelectedItem());
		}
	}

	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			int sel = JOptionPane.showOptionDialog(contentPane, "¿Seguro que quieres salir?", "Salir del programa",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (sel == JOptionPane.YES_OPTION) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Yes
			} else {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // No
			}
		}
	}

	private class BtnCerrarComandaActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Comanda comanda = crearComanda();
			// Falta la persistencia de los tiempos de atención que establece la directivaa
			iniciarTimer(comanda);

			if (comanda.tienePlatos()) {
				IU_Cocina.receiveFromCamareroMesa(comanda, frmCamareroMesa, frmCocina);
			}
			if (comanda.tieneBebidas()) {
				IU_CamareroBarra.receiveFromCamareroMesa(comanda, frmCamareroMesa, frmCamareroBarra);
			}

			CardLayout panel = (CardLayout) (contentPane.getLayout());
			panel.show(contentPane, "Cancelar");
			
			((Mesa) cbMesa.getSelectedItem()).setComanda(comanda);
			
			cbMesa.setSelectedItem(null);
			btnIniciarComanda.setEnabled(false);
			limpiarAnotacionComanda();
			
			//btnCerrarCuenta.setEnabled(false);

		}
	}

	private class CbMesaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (cbMesa.getSelectedItem() != null) {
				btnIniciarComanda.setEnabled(true);
				btnCerrarCuenta.setEnabled(false);
				btnImprimirCuenta.setEnabled(false);
				btnConfirmarPago.setEnabled(false);
				btnMesaPreparada.setEnabled(false);
				Mesa m = (Mesa) cbMesa.getSelectedItem();
				if (m.getEstadoMesa() != EstadosMesas.LIBRE) {
					btnIniciarComanda.setEnabled(false);
				}
				if(m.getEstadoMesa() == EstadosMesas.SERVIDOS) {
					btnCerrarCuenta.setEnabled(true);
				}
				if(m.getEstadoMesa() == EstadosMesas.ESPERANDOCUENTA) {
					btnImprimirCuenta.setEnabled(true);
				}
				if(m.getEstadoMesa() == EstadosMesas.PAGANDO) {
					btnConfirmarPago.setEnabled(true);
					textFieldPrecio.setText(((Mesa) cbMesa.getSelectedItem()).getPrecio() + " €");
				}
				if(m.getEstadoMesa() != EstadosMesas.PAGANDO) {
					textFieldPrecio.setText("-");
				}
				if(m.getEstadoMesa() == EstadosMesas.ENPREPARACION) {
					btnMesaPreparada.setEnabled(true);
				}
			}
			
		}
	}

	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			limpiarAnotacionComanda();
		}
	}

	private class CbAvisosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (cbAvisos.getItemCount() > 0) {
				cbAvisos.setEnabled(true);
				cbAvisos.setSelectedIndex(0);
				btnBorrarAviso.setEnabled(true);
				lblNumNotificaciones.setText("(" + cbAvisos.getItemCount() + ")");
				Aviso seleccionado = (Aviso) cbAvisos.getSelectedItem();
				textTituloAviso.setText(seleccionado.toString());
			} else
				btnBorrarAviso.setEnabled(false);
		}
	}

	private class BtnBorrarAvisoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (cbAvisos.getSelectedIndex() >= 0) {
				Aviso comandaSeleccionada = (Aviso) cbAvisos.getSelectedItem();
				comandaSeleccionada.setAtendidoTrue();
				comandaSeleccionada.getMesa().setEstadoMesa(EstadosMesas.SERVIDOS);
				
				// El btnCerrarCuenta.setEnabled(true) se pone en el evento de la combobox, porque parte a deseleccionada.
				
				((DefaultComboBoxModel<Aviso>) cbAvisos.getModel()).removeElement(comandaSeleccionada);

				textPaneNotificacion.setText("Aviso eliminado correctamente.");
				btnBorrarAviso.setEnabled(false);
				lblNumNotificaciones.setText("(" + cbAvisos.getItemCount() + ")");
				if (cbAvisos.getItemCount() == 0) {
					cbAvisos.setEnabled(false);
					cbAvisos.setSelectedIndex(-1);
					textTituloAviso.setText("** No hay avisos **");
					textNMesaAviso.setText("Mesa número: ***");
					textEstadoMesa.setText("Estado mesa: ***");
				} else
					cbAvisos.setSelectedIndex(0);
			} else {
				textPaneNotificacion.setText("No ha seleccionado un aviso.");
			}
		}
	}
	private class BtnCerrarCuentaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnCerrarCuenta.setEnabled(false);
			((Mesa) cbMesa.getSelectedItem()).setEstadoMesa(EstadosMesas.ESPERANDOCUENTA);
			
			((Mesa) cbMesa.getSelectedItem()).cerrarCuenta();
			
			btnImprimirCuenta.setEnabled(false);
			cbMesa.setSelectedItem(null);
		}
	}
	
	private class BtnImprimirCuentaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			textFieldPrecio.setText(((Mesa) cbMesa.getSelectedItem()).getPrecio() + " €");
			
			btnImprimirCuenta.setEnabled(false);
			((Mesa) cbMesa.getSelectedItem()).setEstadoMesa(EstadosMesas.PAGANDO);
			
			btnConfirmarPago.setEnabled(false);
			cbMesa.setSelectedItem(null);
		}
	}
	
	private class BtnConfirmarPagoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnConfirmarPago.setEnabled(false);
			((Mesa) cbMesa.getSelectedItem()).setEstadoMesa(EstadosMesas.ENPREPARACION);
			// Aviso aviso = new Aviso
			// añadirAviso(aviso);
			
			textFieldPrecio.setText("-");
			
			btnMesaPreparada.setEnabled(false);
			cbMesa.setSelectedItem(null);
		}
	}
	
	private class BtnMesaPreparadaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnMesaPreparada.setEnabled(false);
			((Mesa) cbMesa.getSelectedItem()).setEstadoMesa(EstadosMesas.LIBRE);
			
			cbMesa.setSelectedItem(null);
		}
	}

	public Comanda crearComanda() {

		ArrayList<Bebida> arrayListBebidas = obtenerArrayListBebida(listBebidas);
		ArrayList<Plato> arrayListEntrantes = obtenerArrayListPlato(listEntrantes);
		ArrayList<Plato> arrayListPrimeros = obtenerArrayListPlato(listPrimeros);
		ArrayList<Plato> arrayListSegundos = obtenerArrayListPlato(listSegundos);
		ArrayList<Plato> arrayListPostres = obtenerArrayListPlato(listPostres);

		Mesa m = (Mesa) cbMesa.getSelectedItem();
		m.setEstadoMesa(EstadosMesas.ESPERANDOCOMIDA);

		Comanda c = new Comanda(index++, m, arrayListBebidas, arrayListEntrantes, arrayListPrimeros, arrayListSegundos,
				arrayListPostres);

		return c;
	}

	public ArrayList<Bebida> obtenerArrayListBebida(JList<Bebida> list) {
		ArrayList<Bebida> arrayListBebidas = new ArrayList<Bebida>();
		for (int i = 0; i < list.getModel().getSize(); i++) {
			Bebida b = ((DefaultListModel<Bebida>) list.getModel()).get(i);
			arrayListBebidas.add(b);
		}
		return arrayListBebidas;
	}

	public ArrayList<Plato> obtenerArrayListPlato(JList<Plato> list) {
		ArrayList<Plato> arrayListPlato = new ArrayList<Plato>();

		for (int i = 0; i < list.getModel().getSize(); i++) {
			Plato p = ((DefaultListModel<Plato>) list.getModel()).get(i);
			arrayListPlato.add(p);
		}

		return arrayListPlato;
	}

	public void limpiarAnotacionComanda() {

		((DefaultListModel<Bebida>) listBebidas.getModel()).removeAllElements();
		((DefaultListModel<Plato>) listEntrantes.getModel()).removeAllElements();
		((DefaultListModel<Plato>) listPrimeros.getModel()).removeAllElements();
		((DefaultListModel<Plato>) listSegundos.getModel()).removeAllElements();
		((DefaultListModel<Plato>) listPostres.getModel()).removeAllElements();

		btnAñadirBebida.setEnabled(false);
		btnAñadirEntrante.setEnabled(false);
		btnAñadirPrimero.setEnabled(false);
		btnAñadirSegundo.setEnabled(false);
		btnAñadirPostre.setEnabled(false);

		btnQuitarBebida.setEnabled(false);
		btnQuitarEntrante.setEnabled(false);
		btnQuitarPrimero.setEnabled(false);
		btnQuitarSegundo.setEnabled(false);
		btnQuitarPostre.setEnabled(false);

		btnCerrarComanda.setEnabled(false);
		btnLimpiar.setEnabled(false);

		cbBebidas.setSelectedIndex(-1);
		cbEntrantes.setSelectedIndex(-1);
		cbPrimeros.setSelectedIndex(-1);
		cbSegundos.setSelectedIndex(-1);
		cbPostres.setSelectedIndex(-1);
		
		textPaneEstado.setText("Seleccione platos o bebidas.");

	}

	private void retrasarIds(int k) {
		DefaultListModel<Plato> modeloPlatos = null;
		for (int i = 1; i <= 4; i++) {
			switch (i) {
			case 1:
				modeloPlatos = (DefaultListModel<Plato>) listEntrantes.getModel();
				break;
			case 2:
				modeloPlatos = (DefaultListModel<Plato>) listPrimeros.getModel();
				break;
			case 3:
				modeloPlatos = (DefaultListModel<Plato>) listSegundos.getModel();
				break;
			case 4:
				modeloPlatos = (DefaultListModel<Plato>) listPostres.getModel();
				break;
			}

			for (int j = 0; j < modeloPlatos.size(); j++) {
				Plato p = modeloPlatos.get(j);
				if (p.getId() > k)
					p.reducirId();
			}
		}

		DefaultListModel<Bebida> modeloBebidas = (DefaultListModel<Bebida>) listBebidas.getModel();
		for (int j = 0; j < modeloBebidas.size(); j++) {
			Bebida b = modeloBebidas.get(j);
			if (b.getId() > k)
				b.reducirId();
		}
	}

	public static void receiveFromCocina(Comanda comanda, IU_Cocina origen, IU_CamareroMesa destino) {
		frmCocina = origen;
		frmCamareroMesa = destino;

		frmCamareroMesa.enlistarComanda(comanda);
	}

	public static void receiveFromCamareroBarra(Comanda comanda, IU_CamareroBarra origen, IU_CamareroMesa destino) {
		frmCamareroBarra = origen;
		frmCamareroMesa = destino;

		frmCamareroMesa.enlistarComanda(comanda);
	}

	private void enlistarComanda(Comanda comanda) {
		cbAvisos.setEnabled(true);
		textPaneNotificacion.setText("Se ha recibido una nueva comanda: " + comanda.toString() + ".");
		lblNumNotificaciones.setText("(" + ++numNotificacionesPendientes + ")");
		((DefaultComboBoxModel<Aviso>) cbAvisos.getModel()).addElement(comanda);
		textNMesaAviso.setText("Mesa Número: " + comanda.getMesa().getId());
		textEstadoMesa.setText("Estado Mesa: " + comanda.getMesa().getEstadoMesa());

	}

	private void preparativos() {
		frmCamareroMesa.cbMesa.setSelectedIndex(-1);
	}

	public void iniciarTimer(Aviso aviso) {
		Aviso lanzado;

		if (aviso instanceof Comanda)
			lanzado = new Aviso(aviso.getId(), aviso.getMesa());
		else
			lanzado = aviso;

		timer = new Timer(lanzado.getTiempoEspera(), new ActionListener() {
			public void actionPerformed(ActionEvent f) {

				if (aviso.getAtendido()) {
					timer.stop();
				} else {
					((DefaultComboBoxModel<Aviso>) cbAvisos.getModel()).addElement(lanzado);
					textNMesaAviso.setText("Mesa número: " + lanzado.getMesa().getId());
					textEstadoMesa.setText("Estado de la mesa: " + lanzado.getMesa().getEstadoMesa().name());
					timer.stop();
				}

			}
		});

		timer.start();
	}
	
	public void añadirAviso(Aviso aviso) {
		((DefaultComboBoxModel<Aviso>) cbAvisos.getModel()).addElement(aviso);
		textNMesaAviso.setText("Mesa número: " + aviso.getMesa().getId());
		textEstadoMesa.setText("Estado de la mesa: " + aviso.getMesa().getEstadoMesa().name());
	}
}
