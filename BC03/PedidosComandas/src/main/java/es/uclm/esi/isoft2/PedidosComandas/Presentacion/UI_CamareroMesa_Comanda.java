package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Almacen;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Plato;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Auxiliar;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Bebida;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.CardLayout;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;

public class UI_CamareroMesa_Comanda extends JFrame {

	static int[] stockVirtualPlatos;
	static int[] stockVirtualBebidas;
	static int index;

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
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

	private JPanel panelCamareria;
	private JButton btnQuitarBebida;
	private JButton btnAñadirBebida;
	private JComboBox<String> cbBebida;
	private JLabel lblBebidas;
	private JList<Bebida> listBebidas;
	private JList<Plato> listPostres;
	private JTextArea textEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_CamareroMesa_Comanda frame = new UI_CamareroMesa_Comanda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI_CamareroMesa_Comanda() {

		index = 1;
		
		stockVirtualPlatos = new int[3];
		stockVirtualBebidas = new int[Carta.BEBIDAS.length];
		
		// Ésto es de prueba. Luego el stock se leerá de la BBDD por medio de AlmacenDAO (CDU2):
		for (int i = 0; i < stockVirtualPlatos.length; i++)
			stockVirtualPlatos[i] = 1000;
		for (int i = 0; i < stockVirtualBebidas.length; i++)
			stockVirtualBebidas[i] = 10;
		
		setTitle("Camarero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 789);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		{
			panelAnotacionComanda = new JPanel();
			contentPane.add(panelAnotacionComanda, "name_868160916949900");
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
					textEstado = new JTextArea();
					textEstado.setEditable(false);
					GridBagConstraints gbc_textEstado = new GridBagConstraints();
					gbc_textEstado.gridwidth = 3;
					gbc_textEstado.insets = new Insets(0, 0, 0, 5);
					gbc_textEstado.fill = GridBagConstraints.BOTH;
					gbc_textEstado.gridx = 1;
					gbc_textEstado.gridy = 0;
					panelDatosMesa.add(textEstado, gbc_textEstado);
				}
			}
			{
				panelComanda = new JPanel();
				panelComanda.setBorder(
						new TitledBorder(null, "Comanda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelAnotacionComanda.add(panelComanda, BorderLayout.CENTER);
				GridBagLayout gbl_panelComanda = new GridBagLayout();
				gbl_panelComanda.columnWidths = new int[] { 0, 0, 0, 0, 15, 0, 0 };
				gbl_panelComanda.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				gbl_panelComanda.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
				gbl_panelComanda.rowWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
						1.0, 1.0, 0.0, Double.MIN_VALUE };
				panelComanda.setLayout(gbl_panelComanda);
				{
					lblBebidas = new JLabel("Bebidas:");
					lblBebidas.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblBebidas = new GridBagConstraints();
					gbc_lblBebidas.insets = new Insets(0, 0, 5, 5);
					gbc_lblBebidas.gridx = 3;
					gbc_lblBebidas.gridy = 0;
					panelComanda.add(lblBebidas, gbc_lblBebidas);
				}
				{
					panelCarta = new JPanel();
					panelCarta.setBorder(
							new TitledBorder(null, "Carta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					GridBagConstraints gbc_panelCarta = new GridBagConstraints();
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
					gbl_panelCarta.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0,
							0.0, Double.MIN_VALUE };
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
										cbBebida = new JComboBox();
										cbBebida.addActionListener(new CbBebidaActionListener());
										cbBebida.setModel(new DefaultComboBoxModel(new String[] {"Bebida1", "Bebida2", "Bebida3", "Bebida4", "Bebida5"}));
										GridBagConstraints gbc_cbBebida = new GridBagConstraints();
										gbc_cbBebida.insets = new Insets(0, 0, 5, 5);
										gbc_cbBebida.fill = GridBagConstraints.HORIZONTAL;
										gbc_cbBebida.gridx = 1;
										gbc_cbBebida.gridy = 0;
										panelCarta.add(cbBebida, gbc_cbBebida);
									}
									{
										btnAñadirBebida = new JButton("Añadir");
										btnAñadirBebida.addActionListener(new BtnAñadirBebidaActionListener());
										GridBagConstraints gbc_btnAñadirBebida = new GridBagConstraints();
										gbc_btnAñadirBebida.insets = new Insets(0, 0, 5, 5);
										gbc_btnAñadirBebida.gridx = 3;
										gbc_btnAñadirBebida.gridy = 0;
										panelCarta.add(btnAñadirBebida, gbc_btnAñadirBebida);
									}
									{
										btnQuitarBebida = new JButton("Quitar");
										btnQuitarBebida.addActionListener(new BtnQuitarBebidaActionListener());
										GridBagConstraints gbc_btnQuitarBebida = new GridBagConstraints();
										gbc_btnQuitarBebida.insets = new Insets(0, 0, 5, 5);
										gbc_btnQuitarBebida.gridx = 3;
										gbc_btnQuitarBebida.gridy = 1;
										panelCarta.add(btnQuitarBebida, gbc_btnQuitarBebida);
									}
									cbEntrantes.setModel(new DefaultComboBoxModel<String>(Carta.ENTRANTES));
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
												btnQuitarPrimero.addActionListener(new BtnQuitarPrimeroActionListener());
												{
													btnAñadirPrimero = new JButton("Añadir");
													btnAñadirPrimero.addActionListener(new BtnAñadirPrimeroActionListener());
													cbPrimeros = new JComboBox<String>();
													cbPrimeros.addActionListener(new CbPrimerosActionListener());
													cbPrimeros.setModel(new DefaultComboBoxModel<String>(Carta.PRIMEROS));
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
											cbSegundos.setModel(new DefaultComboBoxModel<String>(Carta.SEGUNDOS));
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
								cbPostres.setModel(new DefaultComboBoxModel<String>(Carta.POSTRES));
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
						gbc_listBebidas.gridx = 3;
						gbc_listBebidas.gridy = 1;
						panelComanda.add(listBebidas, gbc_listBebidas);
					}
					{
						lblEntrantes = new JLabel("Entrantes:");
						lblEntrantes.setFont(new Font("Tahoma", Font.BOLD, 14));
						GridBagConstraints gbc_lblEntrantes = new GridBagConstraints();
						gbc_lblEntrantes.insets = new Insets(0, 0, 5, 5);
						gbc_lblEntrantes.gridx = 3;
						gbc_lblEntrantes.gridy = 3;
						panelComanda.add(lblEntrantes, gbc_lblEntrantes);
					}
					GridBagConstraints gbc_listEntrantes = new GridBagConstraints();
					gbc_listEntrantes.gridwidth = 2;
					gbc_listEntrantes.gridheight = 2;
					gbc_listEntrantes.insets = new Insets(0, 0, 5, 5);
					gbc_listEntrantes.fill = GridBagConstraints.BOTH;
					gbc_listEntrantes.gridx = 3;
					gbc_listEntrantes.gridy = 4;
					panelComanda.add(listEntrantes, gbc_listEntrantes);
				}
				{
					lblPrimero = new JLabel("Primeros:");
					lblPrimero.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblPrimero = new GridBagConstraints();
					gbc_lblPrimero.insets = new Insets(0, 0, 5, 5);
					gbc_lblPrimero.gridx = 3;
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
					gbc_listPrimeros.gridx = 3;
					gbc_listPrimeros.gridy = 7;
					panelComanda.add(listPrimeros, gbc_listPrimeros);
				}
				{
					lblSegundo = new JLabel("Segundos:");
					lblSegundo.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblSegundo = new GridBagConstraints();
					gbc_lblSegundo.insets = new Insets(0, 0, 5, 5);
					gbc_lblSegundo.gridx = 3;
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
					gbc_listSegundos.gridx = 3;
					gbc_listSegundos.gridy = 10;
					panelComanda.add(listSegundos, gbc_listSegundos);
				}
				{
					lblPostre = new JLabel("Postres:");
					lblPostre.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblPostre = new GridBagConstraints();
					gbc_lblPostre.insets = new Insets(0, 0, 5, 5);
					gbc_lblPostre.gridx = 3;
					gbc_lblPostre.gridy = 12;
					panelComanda.add(lblPostre, gbc_lblPostre);
				}
				{
					listPostres = new JList<Plato>(new DefaultListModel<Plato>());
					GridBagConstraints gbc_listPostres = new GridBagConstraints();
					gbc_listPostres.gridheight = 2;
					gbc_listPostres.gridwidth = 2;
					gbc_listPostres.insets = new Insets(0, 0, 5, 5);
					gbc_listPostres.fill = GridBagConstraints.BOTH;
					gbc_listPostres.gridx = 3;
					gbc_listPostres.gridy = 13;
					panelComanda.add(listPostres, gbc_listPostres);
				}
				{
					btnCancelar = new JButton("Cancelar");
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
					btnCerrarComanda.setFont(new Font("Tahoma", Font.BOLD, 15));
					GridBagConstraints gbc_btnCerrarComanda = new GridBagConstraints();
					gbc_btnCerrarComanda.fill = GridBagConstraints.BOTH;
					gbc_btnCerrarComanda.gridwidth = 2;
					gbc_btnCerrarComanda.insets = new Insets(0, 0, 5, 5);
					gbc_btnCerrarComanda.gridx = 3;
					gbc_btnCerrarComanda.gridy = 16;
					panelComanda.add(btnCerrarComanda, gbc_btnCerrarComanda);
				}
			}
		}
		{
			panelCamareria = new JPanel();
			contentPane.add(panelCamareria, "name_880407293944900");
		}
	}

	private void mostrarMsgEstado(String mensaje) {
		//System.out.println(mensaje);
		textEstado.setText(mensaje);
	}

	//BEBIDAS
	private class CbBebidaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			eventoComboBox(cbBebida, btnAñadirBebida);
		}
	}
	private class BtnAñadirBebidaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//eventoAñadir(cbBebida, btnAñadirBebida, listBebidas);
		}
	}
	private class ListBebidasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			//eventoLista(listBebidas, btnQuitarBebida);
		}
	}
	private class BtnQuitarBebidaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//eventoQuitar(listBebidas);
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

	// MODULARIDAD DE EVENTOS DE PLATOS
	private void eventoComboBox(JComboBox<String> comboBox, JButton btnAñadir) {
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
	}

	private void retrasarIds(int k) {
		DefaultListModel<Plato> modelo = null;
		for (int i = 1; i <= 4; i++) { // (CAMBIAR A 5 AL AÑADIR LAS BEBIDAS)
			switch (i) {
			case 1:
				modelo = (DefaultListModel<Plato>) listEntrantes.getModel();
				break;
			case 2:
				modelo = (DefaultListModel<Plato>) listPrimeros.getModel();
				break;
			case 3:
				modelo = (DefaultListModel<Plato>) listSegundos.getModel();
				break;
			case 4:
				modelo = (DefaultListModel<Plato>) listPostres.getModel();
				break;
			case 5:
				// modelo = (DefaultListModel<Plato>) listBebidas.getModel();
				break;
			}

			for (int j = 0; j < modelo.size(); j++) {
				Plato p = modelo.get(j);
				if (p.getId() > k)
					p.reducirId();
			}
		}
	}

}
