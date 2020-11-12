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
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;

public class UI_CamareroMesa_Comanda extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panelDatosMesa;
	private JPanel panelComanda;
	private JLabel lblNumMesa;
	private JLabel lblNumComensales;
	private JComboBox comboBox;
	private JPanel panelCarta;
	private JList listEntrantes;
	private JList listPrimeros;
	private JList listSegundos;
	private JList listPostres;
	private JButton btnCerrarComanda;
	private JButton btnCancelar;
	private JComboBox cbEntrantes;
	private JComboBox cbPrimeros;
	private JComboBox cbSegundos;
	private JComboBox cbPostres;
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
		setTitle("Comanda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				panelDatosMesa = new JPanel();
				panelDatosMesa.setBorder(new TitledBorder(null, "Datos Mesa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.add(panelDatosMesa, BorderLayout.NORTH);
				GridBagLayout gbl_panelDatosMesa = new GridBagLayout();
				gbl_panelDatosMesa.columnWidths = new int[]{290, 193, 171, 47, 0, 0};
				gbl_panelDatosMesa.rowHeights = new int[]{28, 0};
				gbl_panelDatosMesa.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_panelDatosMesa.rowWeights = new double[]{0.0, Double.MIN_VALUE};
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
					lblNumComensales = new JLabel("Numero comensales");
					lblNumComensales.setFont(new Font("Tahoma", Font.PLAIN, 13));
					GridBagConstraints gbc_lblNumComensales = new GridBagConstraints();
					gbc_lblNumComensales.fill = GridBagConstraints.VERTICAL;
					gbc_lblNumComensales.insets = new Insets(0, 0, 0, 5);
					gbc_lblNumComensales.gridx = 2;
					gbc_lblNumComensales.gridy = 0;
					panelDatosMesa.add(lblNumComensales, gbc_lblNumComensales);
				}
				{
					comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
					GridBagConstraints gbc_comboBox = new GridBagConstraints();
					gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
					gbc_comboBox.insets = new Insets(0, 0, 0, 5);
					gbc_comboBox.gridx = 3;
					gbc_comboBox.gridy = 0;
					panelDatosMesa.add(comboBox, gbc_comboBox);
				}
			}
			{
				panelComanda = new JPanel();
				panelComanda.setBorder(new TitledBorder(null, "Comanda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.add(panelComanda, BorderLayout.CENTER);
				GridBagLayout gbl_panelComanda = new GridBagLayout();
				gbl_panelComanda.columnWidths = new int[]{0, 0, 0, 0, 15, 0, 0};
				gbl_panelComanda.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panelComanda.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
				gbl_panelComanda.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
				panelComanda.setLayout(gbl_panelComanda);
				{
					lblEntrantes = new JLabel("Entrantes:");
					lblEntrantes.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblEntrantes = new GridBagConstraints();
					gbc_lblEntrantes.insets = new Insets(0, 0, 5, 5);
					gbc_lblEntrantes.gridx = 3;
					gbc_lblEntrantes.gridy = 0;
					panelComanda.add(lblEntrantes, gbc_lblEntrantes);
				}
				{
					panelCarta = new JPanel();
					panelCarta.setBorder(new TitledBorder(null, "Carta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					GridBagConstraints gbc_panelCarta = new GridBagConstraints();
					gbc_panelCarta.gridheight = 11;
					gbc_panelCarta.insets = new Insets(0, 0, 5, 5);
					gbc_panelCarta.fill = GridBagConstraints.BOTH;
					gbc_panelCarta.gridx = 1;
					gbc_panelCarta.gridy = 1;
					panelComanda.add(panelCarta, gbc_panelCarta);
					GridBagLayout gbl_panelCarta = new GridBagLayout();
					gbl_panelCarta.columnWidths = new int[]{8, 222, 0, 10, 0, 0};
					gbl_panelCarta.rowHeights = new int[]{21, 0, 51, 0, 0, 62, 0, 0, 64, 0, 0, 0, 0};
					gbl_panelCarta.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
					gbl_panelCarta.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
					panelCarta.setLayout(gbl_panelCarta);
					{
						cbEntrantes = new JComboBox();
						GridBagConstraints gbc_cbEntrantes = new GridBagConstraints();
						gbc_cbEntrantes.insets = new Insets(0, 0, 5, 5);
						gbc_cbEntrantes.anchor = GridBagConstraints.NORTH;
						gbc_cbEntrantes.fill = GridBagConstraints.HORIZONTAL;
						gbc_cbEntrantes.gridx = 1;
						gbc_cbEntrantes.gridy = 0;
						panelCarta.add(cbEntrantes, gbc_cbEntrantes);
					}
					{
						btnAñadirEntrante = new JButton("Añadir");
						GridBagConstraints gbc_btnAñadirEntrante = new GridBagConstraints();
						gbc_btnAñadirEntrante.insets = new Insets(0, 0, 5, 5);
						gbc_btnAñadirEntrante.gridx = 3;
						gbc_btnAñadirEntrante.gridy = 0;
						panelCarta.add(btnAñadirEntrante, gbc_btnAñadirEntrante);
					}
					{
						btnQuitarEntrante = new JButton("Quitar");
						GridBagConstraints gbc_btnQuitarEntrante = new GridBagConstraints();
						gbc_btnQuitarEntrante.insets = new Insets(0, 0, 5, 5);
						gbc_btnQuitarEntrante.gridx = 3;
						gbc_btnQuitarEntrante.gridy = 1;
						panelCarta.add(btnQuitarEntrante, gbc_btnQuitarEntrante);
					}
					{
						cbPrimeros = new JComboBox();
						GridBagConstraints gbc_cbPrimeros = new GridBagConstraints();
						gbc_cbPrimeros.insets = new Insets(0, 0, 5, 5);
						gbc_cbPrimeros.fill = GridBagConstraints.HORIZONTAL;
						gbc_cbPrimeros.gridx = 1;
						gbc_cbPrimeros.gridy = 3;
						panelCarta.add(cbPrimeros, gbc_cbPrimeros);
					}
					{
						btnAñadirPrimero = new JButton("Añadir");
						GridBagConstraints gbc_btnAñadirPrimero = new GridBagConstraints();
						gbc_btnAñadirPrimero.insets = new Insets(0, 0, 5, 5);
						gbc_btnAñadirPrimero.gridx = 3;
						gbc_btnAñadirPrimero.gridy = 3;
						panelCarta.add(btnAñadirPrimero, gbc_btnAñadirPrimero);
					}
					{
						btnQuitarPrimero = new JButton("Quitar");
						GridBagConstraints gbc_btnQuitarPrimero = new GridBagConstraints();
						gbc_btnQuitarPrimero.insets = new Insets(0, 0, 5, 5);
						gbc_btnQuitarPrimero.gridx = 3;
						gbc_btnQuitarPrimero.gridy = 4;
						panelCarta.add(btnQuitarPrimero, gbc_btnQuitarPrimero);
					}
					{
						cbSegundos = new JComboBox();
						GridBagConstraints gbc_cbSegundos = new GridBagConstraints();
						gbc_cbSegundos.insets = new Insets(0, 0, 5, 5);
						gbc_cbSegundos.fill = GridBagConstraints.HORIZONTAL;
						gbc_cbSegundos.gridx = 1;
						gbc_cbSegundos.gridy = 6;
						panelCarta.add(cbSegundos, gbc_cbSegundos);
					}
					{
						btnAñadirSegundo = new JButton("Añadir");
						GridBagConstraints gbc_btnAñadirSegundo = new GridBagConstraints();
						gbc_btnAñadirSegundo.insets = new Insets(0, 0, 5, 5);
						gbc_btnAñadirSegundo.gridx = 3;
						gbc_btnAñadirSegundo.gridy = 6;
						panelCarta.add(btnAñadirSegundo, gbc_btnAñadirSegundo);
					}
					{
						btnQuitarSegundo = new JButton("Quitar");
						GridBagConstraints gbc_btnQuitarSegundo = new GridBagConstraints();
						gbc_btnQuitarSegundo.insets = new Insets(0, 0, 5, 5);
						gbc_btnQuitarSegundo.gridx = 3;
						gbc_btnQuitarSegundo.gridy = 7;
						panelCarta.add(btnQuitarSegundo, gbc_btnQuitarSegundo);
					}
					{
						cbPostres = new JComboBox();
						GridBagConstraints gbc_cbPostres = new GridBagConstraints();
						gbc_cbPostres.insets = new Insets(0, 0, 5, 5);
						gbc_cbPostres.fill = GridBagConstraints.HORIZONTAL;
						gbc_cbPostres.gridx = 1;
						gbc_cbPostres.gridy = 9;
						panelCarta.add(cbPostres, gbc_cbPostres);
					}
					{
						btnAñadirPostre = new JButton("Añadir");
						GridBagConstraints gbc_btnAñadirPostre = new GridBagConstraints();
						gbc_btnAñadirPostre.insets = new Insets(0, 0, 5, 5);
						gbc_btnAñadirPostre.gridx = 3;
						gbc_btnAñadirPostre.gridy = 9;
						panelCarta.add(btnAñadirPostre, gbc_btnAñadirPostre);
					}
					{
						btnQuitarPostre = new JButton("Quitar");
						GridBagConstraints gbc_btnQuitarPostre = new GridBagConstraints();
						gbc_btnQuitarPostre.insets = new Insets(0, 0, 5, 5);
						gbc_btnQuitarPostre.gridx = 3;
						gbc_btnQuitarPostre.gridy = 10;
						panelCarta.add(btnQuitarPostre, gbc_btnQuitarPostre);
					}
				}
				{
					listEntrantes = new JList();
					GridBagConstraints gbc_listEntrantes = new GridBagConstraints();
					gbc_listEntrantes.gridwidth = 2;
					gbc_listEntrantes.gridheight = 2;
					gbc_listEntrantes.insets = new Insets(0, 0, 5, 5);
					gbc_listEntrantes.fill = GridBagConstraints.BOTH;
					gbc_listEntrantes.gridx = 3;
					gbc_listEntrantes.gridy = 1;
					panelComanda.add(listEntrantes, gbc_listEntrantes);
				}
				{
					lblPrimero = new JLabel("Primero:");
					lblPrimero.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblPrimero = new GridBagConstraints();
					gbc_lblPrimero.insets = new Insets(0, 0, 5, 5);
					gbc_lblPrimero.gridx = 3;
					gbc_lblPrimero.gridy = 3;
					panelComanda.add(lblPrimero, gbc_lblPrimero);
				}
				{
					listPrimeros = new JList();
					GridBagConstraints gbc_listPrimeros = new GridBagConstraints();
					gbc_listPrimeros.gridwidth = 2;
					gbc_listPrimeros.gridheight = 2;
					gbc_listPrimeros.insets = new Insets(0, 0, 5, 5);
					gbc_listPrimeros.fill = GridBagConstraints.BOTH;
					gbc_listPrimeros.gridx = 3;
					gbc_listPrimeros.gridy = 4;
					panelComanda.add(listPrimeros, gbc_listPrimeros);
				}
				{
					lblSegundo = new JLabel("Segundo:");
					lblSegundo.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblSegundo = new GridBagConstraints();
					gbc_lblSegundo.insets = new Insets(0, 0, 5, 5);
					gbc_lblSegundo.gridx = 3;
					gbc_lblSegundo.gridy = 6;
					panelComanda.add(lblSegundo, gbc_lblSegundo);
				}
				{
					listSegundos = new JList();
					GridBagConstraints gbc_listSegundos = new GridBagConstraints();
					gbc_listSegundos.gridwidth = 2;
					gbc_listSegundos.gridheight = 2;
					gbc_listSegundos.insets = new Insets(0, 0, 5, 5);
					gbc_listSegundos.fill = GridBagConstraints.BOTH;
					gbc_listSegundos.gridx = 3;
					gbc_listSegundos.gridy = 7;
					panelComanda.add(listSegundos, gbc_listSegundos);
				}
				{
					lblPostre = new JLabel("Postre:");
					lblPostre.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblPostre = new GridBagConstraints();
					gbc_lblPostre.insets = new Insets(0, 0, 5, 5);
					gbc_lblPostre.gridx = 3;
					gbc_lblPostre.gridy = 9;
					panelComanda.add(lblPostre, gbc_lblPostre);
				}
				{
					listPostres = new JList();
					GridBagConstraints gbc_listPostres = new GridBagConstraints();
					gbc_listPostres.gridwidth = 2;
					gbc_listPostres.gridheight = 2;
					gbc_listPostres.insets = new Insets(0, 0, 5, 5);
					gbc_listPostres.fill = GridBagConstraints.BOTH;
					gbc_listPostres.gridx = 3;
					gbc_listPostres.gridy = 10;
					panelComanda.add(listPostres, gbc_listPostres);
				}
				{
					btnCancelar = new JButton("Cancelar");
					btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
					GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
					gbc_btnCancelar.fill = GridBagConstraints.BOTH;
					gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
					gbc_btnCancelar.gridx = 1;
					gbc_btnCancelar.gridy = 13;
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
					gbc_btnCerrarComanda.gridy = 13;
					panelComanda.add(btnCerrarComanda, gbc_btnCerrarComanda);
				}
			}
		}
	}
}
