package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Constantes;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.MesaDAO;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Almacen;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Plato;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Bebida;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Comanda;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.EstadosMesas;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Aviso;

import java.awt.BorderLayout;

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

import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextPane;

import javax.swing.Timer;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Clase que representa la interfaz grafica de usuario del Camarero de mesa,
 * nucleo del programa. NOTAS ACLARATORIAS: Notese que al anyadir y eliminar
 * platos y bebidas de la anotacion de la comanda, se efectuan cambios de stock
 * no definitivos, para que de esta forma, se controle que ya no se pueden
 * anyadir mas elementos. Notese tambien que cada grupo de comensales de cada
 * mesa solo puede realizar una comanda.
 * 
 * @author BC03
 *
 */

public class IU_CamareroMesa extends JFrame implements Constantes {

	/**
	 * Instancia del patron singleton.
	 */
	private static IU_CamareroMesa mInstancia;

	/**
	 * Atributo de la constancia del indice que se lleva, para la identificacion
	 * unica de los productos.
	 */
	private int index;
	/**
	 * Atributo que refleja el numero de notificaciones pendientes en la lista de
	 * Avisos.
	 */
	private int numNotificacionesPendientes;

	/**
	 * Elementos de la interfaz grafica de usuario:
	 */

	private JPanel contentPane;

	private JPanel panelCamareria;
	private JButton btnQuitarBebida;
	private JButton btnAnyadirBebida;
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
	private static JComboBox<Mesa> cbMesa;
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
	private JButton btnAnyadirEntrante;
	private JButton btnQuitarEntrante;
	private JButton btnAnyadirPrimero;
	private JButton btnQuitarPrimero;
	private JButton btnAnyadirSegundo;
	private JButton btnQuitarSegundo;
	private JButton btnAnyadirPostre;
	private JButton btnQuitarPostre;
	private JLabel lblEntrantes;
	private JLabel lblPrimero;
	private JLabel lblSegundo;
	private JLabel lblPostre;
	private JButton btnLimpiar;
	/**
	 * Lista de mesas que ya han pasado por todos los estados
	 */
	private ArrayList<Mesa> paraEstadisticas;

	/**
	 * Ojbeto Timer que ayuda a manejar y hacer saltar los avisos de tiempos.
	 */
	private static Timer timer;

	private JButton btnGuardar;

	private JButton btnCerrarCuenta;
	private JButton btnConfirmarPago;
	private JButton btnMesaPreparada;
	private JTextField textFieldPrecio;
	private JButton btnImprimirCuenta;

	private static final long serialVersionUID = 1L;
	private JButton btnRefrescar;

	/**
	 * Metodo que devuelve la instancia de la interfaz segun el patron Singleton.
	 * 
	 * @return instancia
	 * @throws SQLException
	 */
	public static IU_CamareroMesa getInterfaz() throws SQLException { // Patron Singleton
		if (mInstancia == null) {
			mInstancia = new IU_CamareroMesa();
			mInstancia.setVisible(true);
		}
		return mInstancia;
	}

	/**
	 * Metodo constructor de la clase, privado por llevar a cabo el patron
	 * Singleton.
	 * 
	 * @throws SQLException
	 */
	private IU_CamareroMesa() throws SQLException {

		addWindowListener(new ThisWindowListener()); // Boton de cerrar.

		paraEstadisticas = new ArrayList<Mesa>();

		index = Constantes.INDICE_INICIAL_PRODUCTOS;
		numNotificacionesPendientes = 0;
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
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new BtnGuardarActionListener());
				GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
				gbc_btnGuardar.insets = new Insets(0, 0, 5, 0);
				gbc_btnGuardar.gridx = 2;
				gbc_btnGuardar.gridy = 0;
				panelCamareria.add(btnGuardar, gbc_btnGuardar);
			}
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
						textNMesaAviso.setText("Mesa Numero: ***");
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

				panelNuevaComanda.setBorder(new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
						"Control de mesas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelNuevaComanda.setLayout(null);
				GridBagConstraints gbc_panelNuevaComanda = new GridBagConstraints();
				gbc_panelNuevaComanda.gridheight = 2;
				gbc_panelNuevaComanda.insets = new Insets(0, 0, 5, 5);
				gbc_panelNuevaComanda.fill = GridBagConstraints.BOTH;
				gbc_panelNuevaComanda.gridx = 1;
				gbc_panelNuevaComanda.gridy = 2;
				panelCamareria.add(panelNuevaComanda, gbc_panelNuevaComanda);
				{
					lblInfo = new JLabel("Mesa numero");
					lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblInfo.setBounds(64, 89, 109, 24);
					panelNuevaComanda.add(lblInfo);
				}
				{
					cbMesa = new JComboBox<Mesa>();
					cbMesa.addActionListener(new CbMesaActionListener());
					DefaultComboBoxModel<Mesa> modelo = rellenarCbMesas();
					cbMesa.setModel(modelo);
					cbMesa.setBounds(183, 88, 142, 31);
					panelNuevaComanda.add(cbMesa);
				}
				{
					btnIniciarComanda = new JButton("Iniciar Comanda");
					btnIniciarComanda.setEnabled(false);
					btnIniciarComanda.addActionListener(new BtnIniciarComandaActionListener());
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
					lblNumMesa = new JLabel("Mesa Numero 6");
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
								btnAnyadirEntrante = new JButton("Anyadir");
								btnAnyadirEntrante.setEnabled(false);
								btnAnyadirEntrante.addActionListener(new BtnAnyadirEntranteActionListener());
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
										btnAnyadirBebida = new JButton("Anyadir");
										btnAnyadirBebida.setEnabled(false);
										btnAnyadirBebida.addActionListener(new BtnAnyadirBebidaActionListener());
										GridBagConstraints gbc_btnAnyadirBebida = new GridBagConstraints();
										gbc_btnAnyadirBebida.insets = new Insets(0, 0, 5, 5);
										gbc_btnAnyadirBebida.gridx = 3;
										gbc_btnAnyadirBebida.gridy = 0;
										panelCarta.add(btnAnyadirBebida, gbc_btnAnyadirBebida);
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
								GridBagConstraints gbc_btnAnyadirEntrante = new GridBagConstraints();
								gbc_btnAnyadirEntrante.insets = new Insets(0, 0, 5, 5);
								gbc_btnAnyadirEntrante.gridx = 3;
								gbc_btnAnyadirEntrante.gridy = 3;
								panelCarta.add(btnAnyadirEntrante, gbc_btnAnyadirEntrante);
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
							btnAnyadirPostre = new JButton("Anyadir");
							btnAnyadirPostre.addActionListener(new BtnAnyadirPostreActionListener());
							{
								cbPostres = new JComboBox<String>();
								cbPostres.addActionListener(new CbPostresActionListener());
								{
									btnQuitarSegundo = new JButton("Quitar");
									btnQuitarSegundo.addActionListener(new BtnQuitarSegundoActionListener());
									{
										btnAnyadirSegundo = new JButton("Anyadir");
										btnAnyadirSegundo.addActionListener(new BtnAnyadirSegundoActionListener());
										{
											cbSegundos = new JComboBox<String>();
											cbSegundos.addActionListener(new CbSegundosActionListener());
											{
												btnQuitarPrimero = new JButton("Quitar");
												btnQuitarPrimero
														.addActionListener(new BtnQuitarPrimeroActionListener());
												{
													btnAnyadirPrimero = new JButton("Anyadir");
													btnAnyadirPrimero
															.addActionListener(new BtnAnyadirPrimeroActionListener());
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
													btnAnyadirPrimero.setEnabled(false);
													GridBagConstraints gbc_btnAnyadirPrimero = new GridBagConstraints();
													gbc_btnAnyadirPrimero.insets = new Insets(0, 0, 5, 5);
													gbc_btnAnyadirPrimero.gridx = 3;
													gbc_btnAnyadirPrimero.gridy = 6;
													panelCarta.add(btnAnyadirPrimero, gbc_btnAnyadirPrimero);
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
										btnAnyadirSegundo.setEnabled(false);
										GridBagConstraints gbc_btnAnyadirSegundo = new GridBagConstraints();
										gbc_btnAnyadirSegundo.insets = new Insets(0, 0, 5, 5);
										gbc_btnAnyadirSegundo.gridx = 3;
										gbc_btnAnyadirSegundo.gridy = 9;
										panelCarta.add(btnAnyadirSegundo, gbc_btnAnyadirSegundo);
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
							btnAnyadirPostre.setEnabled(false);
							GridBagConstraints gbc_btnAnyadirPostre = new GridBagConstraints();
							gbc_btnAnyadirPostre.insets = new Insets(0, 0, 5, 5);
							gbc_btnAnyadirPostre.gridx = 3;
							gbc_btnAnyadirPostre.gridy = 12;
							panelCarta.add(btnAnyadirPostre, gbc_btnAnyadirPostre);
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
					btnCancelar.addActionListener(new BtnCancelarActionListener());
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
		cbMesa.setSelectedIndex(-1);
		{
			btnRefrescar = new JButton("Refrescar");
			btnRefrescar.addActionListener(new BtnRefrescarActionListener());
			btnRefrescar.setBounds(76, 209, 109, 21);
			panelNuevaComanda.add(btnRefrescar);
		}

	}

	/**
	 * Metodo que modifica la informacion mostrada en el cuadro de texto, durante la
	 * anotacion de la comanda, referido al stock.
	 * 
	 * @param mensaje
	 */
	private void mostrarMsgEstado(String mensaje) {
		textPaneEstado.setText(mensaje);
	}

	// BEBIDAS
	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de un
	 * elemento en la lista desplegable de las Bebidas, en el panel de Anotacion de
	 * comanda, que habilita o deshabilita el boton para enlistar.
	 * 
	 * @author BC03
	 *
	 */
	private class CbBebidaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Bebida aux = new Bebida(index, (String) cbBebidas.getSelectedItem());
				if (Almacen.getAlmacen().comprobarStockBebidas(aux.getNombre())) {

					btnAnyadirBebida.setEnabled(true);

					mostrarMsgEstado("Se ha seleccionado " + aux.getNombre() + ". Se puede anyadir.");
				} else {
					btnAnyadirBebida.setEnabled(false);

					mostrarMsgEstado("Se ha seleccionado " + (String) cbBebidas.getSelectedItem()
							+ ". No se puede anyadir por insuficiencia de stock. (Stock virtual: "
							+ Almacen.getAlmacen().toStringStockBebidas() + ").");

				}
			} catch (NullPointerException exc) {
				// Se causa e ignora con el comboBox.setSelectedIndex(-1);
			}

		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * de enlistar una bebida seleccionada en la JComboBox, que asi lo hace.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnAnyadirBebidaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Bebida b = new Bebida(index++, (String) cbBebidas.getSelectedItem());

			((DefaultListModel<Bebida>) listBebidas.getModel()).addElement(b);

			Almacen.getAlmacen().reducirStockBebidas(b.getNombre());

			mostrarMsgEstado("Bebida " + b.toString() + " anyadida con exito. " + "(Stock virtual: "
					+ Almacen.getAlmacen().toStringStockBebidas() + ").");

			Bebida aux = new Bebida(index, (String) cbBebidas.getSelectedItem());
			if (!Almacen.getAlmacen().comprobarStockBebidas(aux.getNombre())) {
				btnAnyadirBebida.setEnabled(false);
				mostrarMsgEstado("Se acaba de terminar el stock de esta bebida " + aux.getNombre()
						+ ".\n(Stock virtual: " + Almacen.getAlmacen().toStringStockBebidas() + ").");

			}

			btnCerrarComanda.setEnabled(true);
			btnLimpiar.setEnabled(true);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de un
	 * elemento de la JList de Bebidas que habilita o deshabilita el acceso al boton
	 * Quitar.
	 * 
	 * @author BC03
	 *
	 */
	private class ListBebidasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if (listBebidas.getSelectedIndex() >= 0)
				btnQuitarBebida.setEnabled(true);
			else
				btnQuitarBebida.setEnabled(false);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Quitar, que elimina el elemento seleccionado de la JList respectiva, rcupera
	 * su stock y retrasa los siguientes ids.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnQuitarBebidaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Bebida b = ((DefaultListModel<Bebida>) listBebidas.getModel()).get(listBebidas.getSelectedIndex());

			Almacen.getAlmacen().aumentarStockBebidas(b.getNombre());

			((DefaultListModel<Bebida>) listBebidas.getModel()).remove(listBebidas.getSelectedIndex());

			retrasarIds(b.getId());
			index--;

			mostrarMsgEstado("Bebida " + b.toString() + " eliminada con exito. \n(Stock virtual: "
					+ Almacen.getAlmacen().toStringStockBebidas() + ").");

			if (index == Constantes.INDICE_INICIAL_PRODUCTOS) {
				btnCerrarComanda.setEnabled(false);
				btnLimpiar.setEnabled(false);
			}
		}
	}

	// ENTRANTES
	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de un
	 * elemento en la JComboBox de Entrantes, y que llama al metodo que los resume.
	 * 
	 * @author BC03
	 *
	 */
	private class CbEntrantesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoComboBox(cbEntrantes, btnAnyadirEntrante);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Anyadir de los Entrantes, y que llama al metodo que lo lleva a cabo.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnAnyadirEntranteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoAnyadir(cbEntrantes, btnAnyadirEntrante, listEntrantes);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de
	 * elementos de la JList de los Entrantes, y que llama al metodo que lo
	 * modulariza.
	 * 
	 * @author BC03
	 *
	 */
	private class ListEntrantesListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			eventoLista(listEntrantes, btnQuitarEntrante);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Quitar de los Entrantes, y que llama al metodo que lo modulariza
	 * 
	 * @author BC03
	 *
	 */
	private class BtnQuitarEntranteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoQuitar(listEntrantes);
		}
	}

	// PRIMEROS
	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de un
	 * elemento en la JComboBox de Primeros, y que llama al metodo que los resume.
	 * 
	 * @author BC03
	 *
	 */
	private class CbPrimerosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoComboBox(cbPrimeros, btnAnyadirPrimero);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Anyadir de los Primeros, y que llama al metodo que lo lleva a cabo.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnAnyadirPrimeroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoAnyadir(cbPrimeros, btnAnyadirPrimero, listPrimeros);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de
	 * elementos de la JList de los Primeros, y que llama al metodo que lo
	 * modulariza.
	 * 
	 * @author BC03
	 *
	 */
	private class ListPrimerosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			eventoLista(listPrimeros, btnQuitarPrimero);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Quitar de los Primeros, y que llama al metodo que lo modulariza
	 * 
	 * @author BC03
	 *
	 */
	private class BtnQuitarPrimeroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoQuitar(listPrimeros);
		}
	}

	// SEGUNDOS
	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de un
	 * elemento en la JComboBox de Segundos, y que llama al metodo que los resume.
	 * 
	 * @author BC03
	 *
	 */
	private class CbSegundosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoComboBox(cbSegundos, btnAnyadirSegundo);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Anyadir de los Segundos, y que llama al metodo que lo lleva a cabo.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnAnyadirSegundoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoAnyadir(cbSegundos, btnAnyadirSegundo, listSegundos);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de
	 * elementos de la JList de los Segundos, y que llama al metodo que lo
	 * modulariza.
	 * 
	 * @author BC03
	 *
	 */
	private class ListSegundosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			eventoLista(listSegundos, btnQuitarSegundo);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Quitar de los Segundos, y que llama al metodo que lo modulariza
	 * 
	 * @author BC03
	 *
	 */
	private class BtnQuitarSegundoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoQuitar(listSegundos);
		}
	}

	// POSTRES
	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de un
	 * elemento en la JComboBox de Postres, y que llama al metodo que los resume.
	 * 
	 * @author BC03
	 *
	 */
	private class CbPostresActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoComboBox(cbPostres, btnAnyadirPostre);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Anyadir de los Postres, y que llama al metodo que lo lleva a cabo.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnAnyadirPostreActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoAnyadir(cbPostres, btnAnyadirPostre, listPostres);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de
	 * elementos de la JList de los Postres, y que llama al metodo que lo
	 * modulariza.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnQuitarPostreActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			eventoQuitar(listPostres);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Quitar de los Postres, y que llama al metodo que lo modulariza
	 * 
	 * @author BC03
	 *
	 */
	private class ListPostresListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			eventoLista(listPostres, btnQuitarPostre);
		}
	}

	// MODULARIDAD DE EVENTOS DE PLATOS
	/**
	 * Metodo que ejecuta las acciones cuando se pulsa un elemento de un JComboBox
	 * en concreto, comprobando el stock para habilitar o deshabilitar el boton
	 * Anyadir.
	 * 
	 * @param comboBox
	 * @param btnAnyadir
	 */
	private void eventoComboBox(JComboBox<String> comboBox, JButton btnAnyadir) {
		try {
			Plato aux = new Plato(index, (String) comboBox.getSelectedItem());

			if (Almacen.getAlmacen().comprobarStockPlatos(aux.getIngredientes())) {

				btnAnyadir.setEnabled(true);

				mostrarMsgEstado("Se ha seleccionado " + aux.getNombre() + ". Se puede anyadir.");
			} else {
				btnAnyadir.setEnabled(false);

				mostrarMsgEstado("Se ha seleccionado " + (String) comboBox.getSelectedItem()
						+ ". No se puede anyadir por insuficiencia de stock. (Stock virtual: "
						+ Almacen.getAlmacen().toStringStockPlatos() + "). (Stock necesario: "
						+ aux.toStringIngredientes() + ").");

			}
		} catch (NullPointerException exc) {
			// Se causa e ignora con el comboBox.setSelectedIndex(-1);
		}
	}

	/**
	 * Metodo que ejecuta las acciones cuando se pulsa un boton Anyadir en concreto,
	 * que anyade a su respectiva JList el plato seleccionado en la JComboBox.
	 * 
	 * @param comboBox
	 * @param btnAnyadir
	 * @param lista
	 */
	private void eventoAnyadir(JComboBox<String> comboBox, JButton btnAnyadir, JList<Plato> lista) {

		Plato aux = new Plato(index, (String) comboBox.getSelectedItem());
		if (!Almacen.getAlmacen().comprobarStockPlatos(aux.getIngredientes())) {
			btnAnyadir.setEnabled(false);
			mostrarMsgEstado("Se acaba de terminar el stock de ingredientes para cocinar este plato " + aux.getNombre()
					+ ". \n(Stock virtual: " + Almacen.getAlmacen().toStringStockPlatos() + "). (Stock necesario: "
					+ aux.toStringIngredientes() + ").");
		} else {
			Plato p = new Plato(index++, (String) comboBox.getSelectedItem());

			((DefaultListModel<Plato>) lista.getModel()).addElement(p);
			Almacen.getAlmacen().reducirStockPlatos(p.getIngredientes());

			mostrarMsgEstado("Plato " + p.toString() + " anyadido con exito. " + "(Stock virtual: "
					+ Almacen.getAlmacen().toStringStockPlatos() + ").");

			btnCerrarComanda.setEnabled(true);
			btnLimpiar.setEnabled(true);
		}

	}

	/**
	 * Metodo que ejecuta las acciones cuando se pulsa un elemento de una JList en
	 * concreto, que habilita o deshabilita el boton Quitar.
	 * 
	 * @param lista
	 * @param btnQuitar
	 */
	private void eventoLista(JList<Plato> lista, JButton btnQuitar) {
		if (lista.getSelectedIndex() >= 0)
			btnQuitar.setEnabled(true);
		else
			btnQuitar.setEnabled(false);
	}

	/**
	 * Metodo que ejecuta las acciones cuando se pulsa un boton Quitar en concreto,
	 * eliminando el elemento seleccionado de una JList asociada a este, revirtiendo
	 * el stock que se consumio para anyadirlo, y retrasando los siguientes ids en 1
	 * unidad.
	 * 
	 * @param lista
	 */
	private void eventoQuitar(JList<Plato> lista) {
		Plato p = ((DefaultListModel<Plato>) lista.getModel()).get(lista.getSelectedIndex());
		Almacen.getAlmacen().aumentarStockPlatos(p.getIngredientes());
		((DefaultListModel<Plato>) lista.getModel()).remove(lista.getSelectedIndex());

		retrasarIds(p.getId());
		index--;

		mostrarMsgEstado("Plato " + p.toString() + " eliminado con exito. \n(Stock virtual: "
				+ Almacen.getAlmacen().toStringStockPlatos() + ").");

		if (index == Constantes.INDICE_INICIAL_PRODUCTOS) {
			btnCerrarComanda.setEnabled(false);
			btnLimpiar.setEnabled(false);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Cancelar, el cual hace aparecer un cuadro de dialogo de confirmacion, y que
	 * en el caso de pulsar el boton de Si cancelar, se revierte el stock consumido,
	 * revirtiendo tambien todos los futuros indices y limpiando el panel.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnCancelarActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCancelar) {
				int sel = JOptionPane.showOptionDialog(contentPane, "¿Seguro que quieres cancelar?", "Cancelar comadna",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (sel == JOptionPane.YES_OPTION) {
					CardLayout panel = (CardLayout) (contentPane.getLayout());
					panel.show(contentPane, e.getActionCommand());

					index -= ((DefaultListModel<Bebida>) listBebidas.getModel()).size()
							+ ((DefaultListModel<Plato>) listEntrantes.getModel()).size()
							+ ((DefaultListModel<Plato>) listPrimeros.getModel()).size()
							+ ((DefaultListModel<Plato>) listSegundos.getModel()).size()
							+ ((DefaultListModel<Plato>) listPostres.getModel()).size();
					limpiarAnotacionComanda();

					cbMesa.setSelectedItem(null);
					btnIniciarComanda.setEnabled(false);
				} else {
					return;
				}
			}
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * de cerrar la ventana (X), y que limpia y actualiza la base de datos hasta el
	 * momento en el caso de pulsar Si cerrar.
	 * 
	 * @author BC03
	 *
	 */
	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			int sel = JOptionPane.showOptionDialog(contentPane, "¿Seguro que quieres salir?", "Salir del programa",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (sel == JOptionPane.YES_OPTION) {
				if (panelAnotacionComanda.isShowing()) {
					limpiarAnotacionComanda();
					Almacen.getAlmacen().actualizacionBD();
				}
				setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Yes
				System.exit(1);
			} else {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // No
			}
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de Cerrar (confirmar)
	 * la Comanda, que inicia el Timer y que envia las comandas a la cocina y barra,
	 * ademas de limpiar el panel, en esencia.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnCerrarComandaActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Comanda comanda = crearComanda(index++);

			Mesa m = (Mesa) cbMesa.getSelectedItem();
			m.setEstadoMesa(EstadosMesas.ESPERANDOCOMIDA);

			iniciarTimer(comanda);

			if (comanda.tienePlatos()) {
				IU_Cocina.getInterfaz().enlistarComanda(comanda);
			}
			if (comanda.tieneBebidas()) {
				IU_CamareroBarra.getInterfaz().enlistarComanda(comanda);
			}

			CardLayout panel = (CardLayout) (contentPane.getLayout());
			panel.show(contentPane, "Cancelar");
			((Mesa) cbMesa.getSelectedItem()).setComanda(comanda);
			btnIniciarComanda.setEnabled(false);
			limpiarAnotacionComanda();
			cbMesa.setSelectedItem(null);

		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de un
	 * elemento de la JComboBox cbMesa para iniciar una comanda, o marcar como
	 * realizados otros procesos del camarero.
	 * 
	 * @author BC03
	 *
	 */
	private class CbMesaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (cbMesa.getSelectedItem() != null) {
				btnIniciarComanda.setEnabled(true);
				btnCerrarCuenta.setEnabled(false);
				btnImprimirCuenta.setEnabled(false);
				btnConfirmarPago.setEnabled(false);
				btnMesaPreparada.setEnabled(false);
				Mesa m = (Mesa) cbMesa.getSelectedItem();
				if (m.getEstadoMesa() != EstadosMesas.OCUPADA) {
					btnIniciarComanda.setEnabled(false);
				}

				if (m.getEstadoMesa() == EstadosMesas.SERVIDOS) {
					btnCerrarCuenta.setEnabled(true);
				}
				if (m.getEstadoMesa() == EstadosMesas.ESPERANDOCUENTA) {
					btnImprimirCuenta.setEnabled(true);
				}
				if (m.getEstadoMesa() == EstadosMesas.PAGANDO) {
					btnConfirmarPago.setEnabled(true);
					textFieldPrecio.setText(((Mesa) cbMesa.getSelectedItem()).getPrecio() + " €");
				}
				if (m.getEstadoMesa() != EstadosMesas.PAGANDO) {
					textFieldPrecio.setText("-");
				}
				if (m.getEstadoMesa() == EstadosMesas.ENPREPARACION) {
					btnMesaPreparada.setEnabled(true);
				}
			}
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Limpiar de la Anotacion de Comanda, restaurando el stock consumido.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			limpiarAnotacionComanda();
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de un
	 * elemento del JComboBox Avisos del Camarero de Mesa.
	 * 
	 * @author BC03
	 *
	 */
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

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Borrar Aviso, que borra el aviso seleccionado de la JComboBox, y marca como
	 * servida la mesa del aviso en cuestion.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnBorrarAvisoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (cbAvisos.getSelectedIndex() >= 0) {
				Aviso comandaSeleccionada = (Aviso) cbAvisos.getSelectedItem();
				comandaSeleccionada.setAtendidoTrue();
				comandaSeleccionada.getMesa().setEstadoMesa(EstadosMesas.SERVIDOS);
				((DefaultComboBoxModel<Aviso>) cbAvisos.getModel()).removeElement(comandaSeleccionada);

				textPaneNotificacion.setText("Aviso eliminado correctamente.");
				btnBorrarAviso.setEnabled(false);
				lblNumNotificaciones.setText("(" + cbAvisos.getItemCount() + ")");
				if (cbAvisos.getItemCount() == 0) {
					cbAvisos.setEnabled(false);
					cbAvisos.setSelectedIndex(-1);
					textTituloAviso.setText("** No hay avisos **");
					textNMesaAviso.setText("Mesa numero: ***");
					textEstadoMesa.setText("Estado mesa: ***");
				} else
					cbAvisos.setSelectedIndex(0);
			} else {
				textPaneNotificacion.setText("No ha seleccionado un aviso.");
			}
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Guardar que hace una actualizacion del estado actual de los stocks del
	 * Almacen contra la Base de datos.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Almacen.getAlmacen().actualizacionBD();
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Iniciar comanda, una vez seleccionado un elemento en la JComboBox cbMesa.
	 * Notese que al anyadir y eliminar platos y bebidas de la anotacion de la
	 * comanda, se efectuan cambios de stock no definitivos, para que de esta forma,
	 * se controle que ya no se pueden anyadir mas elementos.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnIniciarComandaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((Mesa) cbMesa.getSelectedItem()).setEstadoMesa(EstadosMesas.PIDIENDO);
			;
			CardLayout panel = (CardLayout) (contentPane.getLayout());
			panel.show(contentPane, "Iniciar Comanda");
			lblNumMesa.setText("Mesa Numero: " + cbMesa.getSelectedItem());
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Cerrar cuenta, que cierra la cuenta de la Mesa, habilitando y deshabilitando
	 * otras acciones sobre esta mesa, para empezar procesos posteriores, de pago,
	 * etc.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnCerrarCuentaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnCerrarCuenta.setEnabled(false);
			((Mesa) cbMesa.getSelectedItem()).setEstadoMesa(EstadosMesas.ESPERANDOCUENTA);

			((Mesa) cbMesa.getSelectedItem()).cerrarCuenta();

			btnImprimirCuenta.setEnabled(false);
			cbMesa.setSelectedItem(null);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Imprimir cuenta, que imprime la cuenta.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnImprimirCuentaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			textFieldPrecio.setText(((Mesa) cbMesa.getSelectedItem()).getPrecio() + " €");

			btnImprimirCuenta.setEnabled(false);
			((Mesa) cbMesa.getSelectedItem()).setEstadoMesa(EstadosMesas.PAGANDO);

			btnConfirmarPago.setEnabled(false);
			cbMesa.setSelectedItem(null);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Confirmar pago, que confirma el pago efectuado de los comensales. Acto
	 * seguido, los comensales se retiran de la mesa.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnConfirmarPagoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnConfirmarPago.setEnabled(false);
			((Mesa) cbMesa.getSelectedItem()).setEstadoMesa(EstadosMesas.ENPREPARACION);
			// Aviso aviso = new Aviso
			// anyadirAviso(aviso);

			textFieldPrecio.setText("-");

			btnMesaPreparada.setEnabled(false);
			cbMesa.setSelectedItem(null);
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * de Mesa preparada, que remarca la limpieza de la mesa.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnMesaPreparadaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (paraEstadisticas == null)
				paraEstadisticas = new ArrayList<Mesa>();
			btnMesaPreparada.setEnabled(false);
			((Mesa) cbMesa.getSelectedItem()).setEstadoMesa(EstadosMesas.LIBRE);
			Mesa mesa = (Mesa) cbMesa.getSelectedItem();
			paraEstadisticas.add(mesa);
			cbMesa.removeItem(mesa);
			try {
				MesaDAO.actualizarNumMesa(mesa.getId(), mesa.getEstadoMesa().toString(), mesa.getDni());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Refrescar para actualizar la JComboBox de Mesas.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnRefrescarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultComboBoxModel<Mesa> modelo;
			try {
				modelo = rellenarCbMesas();
				cbMesa.setModel(modelo);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Metodo auxiliar que ayuda a crear una comanda segun lo que figura reunido en
	 * las JList respectivas.
	 * 
	 * @param index
	 * @return comanda
	 */
	public Comanda crearComanda(int index) {

		ArrayList<Bebida> arrayListBebidas = obtenerArrayListBebida(listBebidas);
		ArrayList<Plato> arrayListEntrantes = obtenerArrayListPlato(listEntrantes);
		ArrayList<Plato> arrayListPrimeros = obtenerArrayListPlato(listPrimeros);
		ArrayList<Plato> arrayListSegundos = obtenerArrayListPlato(listSegundos);
		ArrayList<Plato> arrayListPostres = obtenerArrayListPlato(listPostres);

		Mesa m = (Mesa) cbMesa.getSelectedItem();

		Comanda c = new Comanda(index, m, arrayListBebidas, arrayListEntrantes, arrayListPrimeros, arrayListSegundos,
				arrayListPostres);

		return c;
	}

	/**
	 * Metodo auxiliar que reune en una lista dinamica que se devuelve, las bebidas
	 * del JList de Bebidas.
	 * 
	 * @param JList
	 * @return lista
	 */
	public ArrayList<Bebida> obtenerArrayListBebida(JList<Bebida> list) {
		ArrayList<Bebida> arrayListBebidas = new ArrayList<Bebida>();
		for (int i = 0; i < list.getModel().getSize(); i++) {
			Bebida b = ((DefaultListModel<Bebida>) list.getModel()).get(i);
			arrayListBebidas.add(b);
		}
		return arrayListBebidas;
	}

	/**
	 * Metodo auxiliar que reune en una lista dinamica que se devuelve, los platos
	 * de una JList de Platos en concreto.
	 * 
	 * @param JList
	 * @return lista
	 */
	public ArrayList<Plato> obtenerArrayListPlato(JList<Plato> list) {
		ArrayList<Plato> arrayListPlato = new ArrayList<Plato>();

		for (int i = 0; i < list.getModel().getSize(); i++) {
			Plato p = ((DefaultListModel<Plato>) list.getModel()).get(i);
			arrayListPlato.add(p);
		}

		return arrayListPlato;
	}

	/**
	 * Metodo que reinicializa el estado neutro del panel de anotacion de comanda,
	 * revirtiendo el stock consumido durante la anotacion, eliminando los elementos
	 * de la JList, deshabilitando botones y deseleccionando los indices de las
	 * JComboBox.
	 */
	public void limpiarAnotacionComanda() {

		Almacen.getAlmacen().aumentarStock(crearComanda(0));

		((DefaultListModel<Bebida>) listBebidas.getModel()).removeAllElements();
		((DefaultListModel<Plato>) listEntrantes.getModel()).removeAllElements();
		((DefaultListModel<Plato>) listPrimeros.getModel()).removeAllElements();
		((DefaultListModel<Plato>) listSegundos.getModel()).removeAllElements();
		((DefaultListModel<Plato>) listPostres.getModel()).removeAllElements();

		btnAnyadirBebida.setEnabled(false);
		btnAnyadirEntrante.setEnabled(false);
		btnAnyadirPrimero.setEnabled(false);
		btnAnyadirSegundo.setEnabled(false);
		btnAnyadirPostre.setEnabled(false);

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

	/**
	 * Metodo que retrasa los ids de los posteriores items adscritos a las JList en
	 * una unidad, cuando se elimina un elemento anterior, para mantener una
	 * absoluta continuidad entre los indices de los productos solicitados
	 * oficialmente.
	 * 
	 * @param k
	 */
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

	/**
	 * Metodo que enlista una nueva Comanda en la lista desplegable JComboBox de
	 * avisos del Camarero de Mesa.
	 * 
	 * @param comanda
	 */
	public void enlistarComanda(Comanda comanda) {
		cbAvisos.setEnabled(true);
		textPaneNotificacion.setText("Se ha recibido una nueva comanda: " + comanda.toString() + ".");
		lblNumNotificaciones.setText("(" + ++numNotificacionesPendientes + ")");
		((DefaultComboBoxModel<Aviso>) cbAvisos.getModel()).addElement(comanda);
		textNMesaAviso.setText("Mesa Numero: " + comanda.getMesa().getId());
		textEstadoMesa.setText("Estado Mesa: " + comanda.getMesa().getEstadoMesa());

	}

	/**
	 * Metodo que inicia un Timer al momento de Cerrar (confirmar) la Comanda, para
	 * resaltar en su expedicion.
	 * 
	 * @param aviso
	 */
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
					textNMesaAviso.setText("Mesa numero: " + lanzado.getMesa().getId());
					textEstadoMesa.setText("Estado de la mesa: " + lanzado.getMesa().getEstadoMesa().name());
					timer.stop();
				}

			}
		});

		timer.start();
	}

	/**
	 * Metodo que anyade un aviso a la lista JComboBox de avisos.
	 * 
	 * @param aviso
	 */
	public void anyadirAviso(Aviso aviso) {
		((DefaultComboBoxModel<Aviso>) cbAvisos.getModel()).addElement(aviso);
		textNMesaAviso.setText("Mesa numero: " + aviso.getMesa().getId());
		textEstadoMesa.setText("Estado de la mesa: " + aviso.getMesa().getEstadoMesa().name());
	}

	/**
	 * Metodo que enlista en un modelo de ComboBox, las mesas que se han marcado
	 * como ocupadas (Llegada).
	 * 
	 * @return modelo
	 * @throws SQLException
	 */
	public static DefaultComboBoxModel<Mesa> rellenarCbMesas() throws SQLException {
		DefaultComboBoxModel<Mesa> modelo = new DefaultComboBoxModel<Mesa>();
		for (int m = 1; m <= Constantes.NUM_MESAS; m++) {
			ArrayList<Integer> mesasOcupadas = MesaDAO.consultarMesasOcupadas();
			for (int i = 0; i < mesasOcupadas.size(); i++) {
				if (mesasOcupadas.get(i) == m) {
					modelo.addElement(new Mesa(m, EstadosMesas.OCUPADA));
				}
			}
		}
		return modelo;
	}

	/**
	 * Getter del atributo paraEstadisticas
	 * 
	 * @return
	 */
	public ArrayList<Mesa> getMesaEstadisticas() {
		return paraEstadisticas;
	}

	/**
	 * Reinicializa la lista paraEstadisticas
	 */
	public void restartMesas() {
		paraEstadisticas = new ArrayList<Mesa>();
	}
}
