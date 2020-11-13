package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Almacen;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Plato;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Auxiliar;

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

public class UI_CamareroMesa_Comanda extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panelAnotacionComanda;
	private JPanel panelDatosMesa;
	private JPanel panelComanda;
	private JLabel lblNumMesa;
	private JLabel lblNumComensales;
	private JComboBox<Integer> cbNComensales;
	private JPanel panelCarta;
	private JList<Plato> listEntrantes;
	private JList<Plato> listPrimeros;
	private JList<Plato> listSegundos;
	private JList<Plato> listPostres;
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

	static int[] stockVirtualPlatos;
	static int[] stockVirtualBebidas;
	static int index;

	static String cadenaEstado; // Acoplar el contenido de cadenaEstado al argumento de
	private JPanel panelCamareria;
								// textPaneEstado.setText(AQUÍ) y eliminar esta variable global innecesaria.

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

		// Ésto es de prueba. Luego va con la BBDD.
		stockVirtualPlatos = new int[3];
		for (int i = 0; i < stockVirtualPlatos.length; i++)
			stockVirtualPlatos[i] = 1000;
		stockVirtualBebidas = new int[Carta.bebidas.length];

		setTitle("Camarero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 672);
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
				gbl_panelDatosMesa.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
				gbl_panelDatosMesa.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
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
					cbNComensales = new JComboBox<Integer>();
					cbNComensales.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 1, 2, 3, 4, 5 }));
					GridBagConstraints gbc_cbNComensales = new GridBagConstraints();
					gbc_cbNComensales.fill = GridBagConstraints.HORIZONTAL;
					gbc_cbNComensales.insets = new Insets(0, 0, 0, 5);
					gbc_cbNComensales.gridx = 3;
					gbc_cbNComensales.gridy = 0;
					panelDatosMesa.add(cbNComensales, gbc_cbNComensales);
				}
			}
			{
				panelComanda = new JPanel();
				panelComanda.setBorder(
						new TitledBorder(null, "Comanda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelAnotacionComanda.add(panelComanda, BorderLayout.CENTER);
				GridBagLayout gbl_panelComanda = new GridBagLayout();
				gbl_panelComanda.columnWidths = new int[] { 0, 0, 0, 0, 15, 0, 0 };
				gbl_panelComanda.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				gbl_panelComanda.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
				gbl_panelComanda.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
						1.0, 1.0, 0.0, Double.MIN_VALUE };
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
					panelCarta.setBorder(
							new TitledBorder(null, "Carta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					GridBagConstraints gbc_panelCarta = new GridBagConstraints();
					gbc_panelCarta.gridheight = 11;
					gbc_panelCarta.insets = new Insets(0, 0, 5, 5);
					gbc_panelCarta.fill = GridBagConstraints.BOTH;
					gbc_panelCarta.gridx = 1;
					gbc_panelCarta.gridy = 1;
					panelComanda.add(panelCarta, gbc_panelCarta);
					GridBagLayout gbl_panelCarta = new GridBagLayout();
					gbl_panelCarta.columnWidths = new int[] { 8, 222, 0, 10, 0, 0 };
					gbl_panelCarta.rowHeights = new int[] { 21, 0, 51, 0, 0, 62, 0, 0, 64, 0, 0, 0, 0 };
					gbl_panelCarta.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
					gbl_panelCarta.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							0.0, Double.MIN_VALUE };
					panelCarta.setLayout(gbl_panelCarta);
					{
						cbEntrantes = new JComboBox<String>();
						cbEntrantes.addActionListener(new CbEntrantesActionListener());
						cbEntrantes.setModel(new DefaultComboBoxModel<String>(Carta.entrantes));
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
						btnAñadirEntrante.setEnabled(false);
						btnAñadirEntrante.addActionListener(new BtnAñadirEntranteActionListener());
						GridBagConstraints gbc_btnAñadirEntrante = new GridBagConstraints();
						gbc_btnAñadirEntrante.insets = new Insets(0, 0, 5, 5);
						gbc_btnAñadirEntrante.gridx = 3;
						gbc_btnAñadirEntrante.gridy = 0;
						panelCarta.add(btnAñadirEntrante, gbc_btnAñadirEntrante);
					}
					{
						btnQuitarEntrante = new JButton("Quitar");
						btnQuitarEntrante.setEnabled(false);
						btnQuitarEntrante.addActionListener(new BtnQuitarEntranteActionListener());
						GridBagConstraints gbc_btnQuitarEntrante = new GridBagConstraints();
						gbc_btnQuitarEntrante.insets = new Insets(0, 0, 5, 5);
						gbc_btnQuitarEntrante.gridx = 3;
						gbc_btnQuitarEntrante.gridy = 1;
						panelCarta.add(btnQuitarEntrante, gbc_btnQuitarEntrante);
					}
					{
						cbPrimeros = new JComboBox<String>();
						cbPrimeros.addActionListener(new CbPrimerosActionListener());
						cbPrimeros.setModel(new DefaultComboBoxModel<String>(Carta.primeros));
						GridBagConstraints gbc_cbPrimeros = new GridBagConstraints();
						gbc_cbPrimeros.insets = new Insets(0, 0, 5, 5);
						gbc_cbPrimeros.fill = GridBagConstraints.HORIZONTAL;
						gbc_cbPrimeros.gridx = 1;
						gbc_cbPrimeros.gridy = 3;
						panelCarta.add(cbPrimeros, gbc_cbPrimeros);
					}
					{
						btnAñadirPrimero = new JButton("Añadir");
						btnAñadirPrimero.addActionListener(new BtnAñadirPrimeroActionListener());
						btnAñadirPrimero.setEnabled(false);
						GridBagConstraints gbc_btnAñadirPrimero = new GridBagConstraints();
						gbc_btnAñadirPrimero.insets = new Insets(0, 0, 5, 5);
						gbc_btnAñadirPrimero.gridx = 3;
						gbc_btnAñadirPrimero.gridy = 3;
						panelCarta.add(btnAñadirPrimero, gbc_btnAñadirPrimero);
					}
					{
						btnQuitarPrimero = new JButton("Quitar");
						btnQuitarPrimero.addActionListener(new BtnQuitarPrimeroActionListener());
						btnQuitarPrimero.setEnabled(false);
						GridBagConstraints gbc_btnQuitarPrimero = new GridBagConstraints();
						gbc_btnQuitarPrimero.insets = new Insets(0, 0, 5, 5);
						gbc_btnQuitarPrimero.gridx = 3;
						gbc_btnQuitarPrimero.gridy = 4;
						panelCarta.add(btnQuitarPrimero, gbc_btnQuitarPrimero);
					}
					{
						cbSegundos = new JComboBox<String>();
						cbSegundos.addActionListener(new CbSegundosActionListener());
						cbSegundos.setModel(new DefaultComboBoxModel<String>(Carta.segundos));
						GridBagConstraints gbc_cbSegundos = new GridBagConstraints();
						gbc_cbSegundos.insets = new Insets(0, 0, 5, 5);
						gbc_cbSegundos.fill = GridBagConstraints.HORIZONTAL;
						gbc_cbSegundos.gridx = 1;
						gbc_cbSegundos.gridy = 6;
						panelCarta.add(cbSegundos, gbc_cbSegundos);
					}
					{
						btnAñadirSegundo = new JButton("Añadir");
						btnAñadirSegundo.addActionListener(new BtnAñadirSegundoActionListener());
						btnAñadirSegundo.setEnabled(false);
						GridBagConstraints gbc_btnAñadirSegundo = new GridBagConstraints();
						gbc_btnAñadirSegundo.insets = new Insets(0, 0, 5, 5);
						gbc_btnAñadirSegundo.gridx = 3;
						gbc_btnAñadirSegundo.gridy = 6;
						panelCarta.add(btnAñadirSegundo, gbc_btnAñadirSegundo);
					}
					{
						btnQuitarSegundo = new JButton("Quitar");
						btnQuitarSegundo.addActionListener(new BtnQuitarSegundoActionListener());
						btnQuitarSegundo.setEnabled(false);
						GridBagConstraints gbc_btnQuitarSegundo = new GridBagConstraints();
						gbc_btnQuitarSegundo.insets = new Insets(0, 0, 5, 5);
						gbc_btnQuitarSegundo.gridx = 3;
						gbc_btnQuitarSegundo.gridy = 7;
						panelCarta.add(btnQuitarSegundo, gbc_btnQuitarSegundo);
					}
					{
						cbPostres = new JComboBox<String>();
						cbPostres.addActionListener(new CbPostresActionListener());
						cbPostres.setModel(new DefaultComboBoxModel<String>(Carta.postres));
						GridBagConstraints gbc_cbPostres = new GridBagConstraints();
						gbc_cbPostres.insets = new Insets(0, 0, 5, 5);
						gbc_cbPostres.fill = GridBagConstraints.HORIZONTAL;
						gbc_cbPostres.gridx = 1;
						gbc_cbPostres.gridy = 9;
						panelCarta.add(cbPostres, gbc_cbPostres);
					}
					{
						btnAñadirPostre = new JButton("Añadir");
						btnAñadirPostre.addActionListener(new BtnAñadirPostreActionListener());
						btnAñadirPostre.setEnabled(false);
						GridBagConstraints gbc_btnAñadirPostre = new GridBagConstraints();
						gbc_btnAñadirPostre.insets = new Insets(0, 0, 5, 5);
						gbc_btnAñadirPostre.gridx = 3;
						gbc_btnAñadirPostre.gridy = 9;
						panelCarta.add(btnAñadirPostre, gbc_btnAñadirPostre);
					}
					{
						btnQuitarPostre = new JButton("Quitar");
						btnQuitarPostre.addActionListener(new BtnQuitarPostreActionListener());
						btnQuitarPostre.setEnabled(false);
						GridBagConstraints gbc_btnQuitarPostre = new GridBagConstraints();
						gbc_btnQuitarPostre.insets = new Insets(0, 0, 5, 5);
						gbc_btnQuitarPostre.gridx = 3;
						gbc_btnQuitarPostre.gridy = 10;
						panelCarta.add(btnQuitarPostre, gbc_btnQuitarPostre);
					}
				}
				{
					listEntrantes = new JList<Plato>(new DefaultListModel<Plato>());
					listEntrantes.addListSelectionListener(new ListEntrantesListSelectionListener());
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
					lblPrimero = new JLabel("Primeros:");
					lblPrimero.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblPrimero = new GridBagConstraints();
					gbc_lblPrimero.insets = new Insets(0, 0, 5, 5);
					gbc_lblPrimero.gridx = 3;
					gbc_lblPrimero.gridy = 3;
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
					gbc_listPrimeros.gridy = 4;
					panelComanda.add(listPrimeros, gbc_listPrimeros);
				}
				{
					lblSegundo = new JLabel("Segundos:");
					lblSegundo.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblSegundo = new GridBagConstraints();
					gbc_lblSegundo.insets = new Insets(0, 0, 5, 5);
					gbc_lblSegundo.gridx = 3;
					gbc_lblSegundo.gridy = 6;
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
					gbc_listSegundos.gridy = 7;
					panelComanda.add(listSegundos, gbc_listSegundos);
				}
				{
					lblPostre = new JLabel("Postres:");
					lblPostre.setFont(new Font("Tahoma", Font.BOLD, 14));
					GridBagConstraints gbc_lblPostre = new GridBagConstraints();
					gbc_lblPostre.insets = new Insets(0, 0, 5, 5);
					gbc_lblPostre.gridx = 3;
					gbc_lblPostre.gridy = 9;
					panelComanda.add(lblPostre, gbc_lblPostre);
				}
				{
					listPostres = new JList<Plato>(new DefaultListModel<Plato>());
					listPostres.addListSelectionListener(new ListPostresListSelectionListener());
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
		{
			panelCamareria = new JPanel();
			contentPane.add(panelCamareria, "name_880407293944900");
		}
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

	// ENTRANTES
	private class CbEntrantesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			Plato aux = new Plato(index, (String) cbEntrantes.getSelectedItem());
			if (Almacen.comprobarStockVirtualPlatos(stockVirtualPlatos, aux.getIngredientes())) {
				btnAñadirEntrante.setEnabled(true);

				cadenaEstado = "Plato " + aux.getNombre() + " seleccionado. Se puede añadir dicho plato.";
				System.out.println(cadenaEstado);
				// textPaneEstado.setText(cadenaEstado);
			} else {
				btnAñadirEntrante.setEnabled(false);

				cadenaEstado = "Plato " + (String) cbEntrantes.getSelectedItem()
						+ " seleccionado. No se puede añadir dicho plato por insuficiencia de stock. (Stock virtual: "
						+ Auxiliar.imprimirVector(stockVirtualPlatos) + "). (Stock necesario: "
						+ Auxiliar.imprimirVector(aux.getIngredientes()) + ").";
				System.out.println(cadenaEstado);
				// textPaneEstado.setText(cadenaEstado);
			}

		}
	}

	private class BtnAñadirEntranteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			Plato p = new Plato(index++, (String) cbEntrantes.getSelectedItem());

			((DefaultListModel<Plato>) listEntrantes.getModel()).addElement(p);
			stockVirtualPlatos = Almacen.reducirStockVirtualPlatos(stockVirtualPlatos, p.getIngredientes());

			cadenaEstado = "Plato " + p.toString() + " añadido con éxito. " + "(Stock virtual: "
					+ Auxiliar.imprimirVector(stockVirtualPlatos) + ").";
			System.out.println(cadenaEstado);
			// textPaneEstado.setText(cadenaEstado);

			Plato aux = new Plato(index, (String) cbEntrantes.getSelectedItem());
			if (!Almacen.comprobarStockVirtualPlatos(stockVirtualPlatos, aux.getIngredientes())) {
				btnAñadirEntrante.setEnabled(false);
				cadenaEstado = "Se acaba de terminar el stock de ingredientes para cocinar este plato "
						+ aux.getNombre() + ". (Stock virtual: " + Auxiliar.imprimirVector(stockVirtualPlatos)
						+ "). (Stock necesario: " + Auxiliar.imprimirVector(p.getIngredientes()) + ").";
				System.out.println(cadenaEstado);
				// textPaneEstado.setText(cadenaEstado);
			}

		}
	}

	private class ListEntrantesListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {

			if (listEntrantes.getSelectedIndex() >= 0)
				btnQuitarEntrante.setEnabled(true);
			else
				btnQuitarEntrante.setEnabled(false);

		}
	}

	private class BtnQuitarEntranteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			Plato p = ((DefaultListModel<Plato>) listEntrantes.getModel()).get(listEntrantes.getSelectedIndex());
			stockVirtualPlatos = Almacen.aumentarStockVirtualPlatos(stockVirtualPlatos, p.getIngredientes());
			((DefaultListModel<Plato>) listEntrantes.getModel()).remove(listEntrantes.getSelectedIndex());

			retrasarIds(p.getId());
			index--;

			cadenaEstado = "Plato " + p.toString() + " eliminado con éxito, e identificadores corridos. "
					+ "(Stock virtual: " + Auxiliar.imprimirVector(stockVirtualPlatos) + ").";
			System.out.println(cadenaEstado);
			// textPaneEstado.setText(cadenaEstado);
		}
	}

	// PRIMEROS
	private class CbPrimerosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}

	private class BtnAñadirPrimeroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}

	private class ListPrimerosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
		}
	}

	private class BtnQuitarPrimeroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}

	// SEGUNDOS
	private class CbSegundosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}

	private class BtnAñadirSegundoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}

	private class ListSegundosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
		}
	}

	private class BtnQuitarSegundoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}

	// POSTRES
	private class CbPostresActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}

	private class BtnAñadirPostreActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}

	private class ListPostresListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
		}
	}

	private class BtnQuitarPostreActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}

	// BEBIDAS
	// private class...

}
