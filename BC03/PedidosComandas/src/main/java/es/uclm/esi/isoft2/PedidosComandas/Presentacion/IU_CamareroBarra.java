package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Comanda;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Almacen;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Bebida;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/**
 * Clase que representa la interfaz grafica de usuario del Camarero de la Barra.
 * 
 * @author BC03
 *
 */
public class IU_CamareroBarra extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Instancia del patron singleton.
	 */
	private static IU_CamareroBarra mInstancia;

	/**
	 * Elementos de la interfaz grafica de usuario.
	 */
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblUltimaComandaEntrante;
	private JTextPane textPaneAvisosComandaEntrante;

	private JLabel lblComandaPendiente;
	private JLabel lblDescripcion;
	private JTextPane textPaneInfoComandaSeleccionada;
	private JButton btnAvisar;
	private JComboBox<Comanda> cbComandasPendientes;
	private JLabel lblNumComandasPendientes;

	private JPanel panelMantenimiento;
	private JButton btnGuardar;
	private JButton btnReponer;

	/**
	 * Numero que representa el numero de comandas pendientes a preparar.
	 */
	private int numComandasPendientes;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	/**
	 * Metodo que devuelve la instancia de la interfaz, del patron Singleton.
	 * 
	 * @return instancia
	 */
	public static IU_CamareroBarra getInterfaz() { // Patron Singleton
		if (mInstancia == null) {
			mInstancia = new IU_CamareroBarra();
			mInstancia.setVisible(true);
		}
		return mInstancia;
	}

	/**
	 * Constructor de la interfaz grafica de usuario, que ayuda a colocar todos los
	 * elementos sobre esta.
	 */
	public IU_CamareroBarra() {

		addWindowListener(new ThisWindowListener());

		numComandasPendientes = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 400, 478, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"CAMARERO DE BARRA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPane.add(panel, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 205, 279, 26, 0 };
			gbl_panel.rowHeights = new int[] { 50, 0, 50, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				lblUltimaComandaEntrante = new JLabel("Avisos / ultima comanda entrante:");
				GridBagConstraints gbc_lblUltimaComandaEntrante = new GridBagConstraints();
				gbc_lblUltimaComandaEntrante.anchor = GridBagConstraints.EAST;
				gbc_lblUltimaComandaEntrante.insets = new Insets(0, 0, 5, 5);
				gbc_lblUltimaComandaEntrante.gridx = 0;
				gbc_lblUltimaComandaEntrante.gridy = 0;
				panel.add(lblUltimaComandaEntrante, gbc_lblUltimaComandaEntrante);
			}
			{
				scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridwidth = 2;
				gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 0;
				panel.add(scrollPane, gbc_scrollPane);
				{
					textPaneAvisosComandaEntrante = new JTextPane();
					scrollPane.setViewportView(textPaneAvisosComandaEntrante);
					textPaneAvisosComandaEntrante.setEditable(false);
				}
			}
			{
				lblComandaPendiente = new JLabel("Comandas pendientes:");
				GridBagConstraints gbc_lblComandaPendiente = new GridBagConstraints();
				gbc_lblComandaPendiente.anchor = GridBagConstraints.EAST;
				gbc_lblComandaPendiente.insets = new Insets(0, 0, 5, 5);
				gbc_lblComandaPendiente.gridx = 0;
				gbc_lblComandaPendiente.gridy = 1;
				panel.add(lblComandaPendiente, gbc_lblComandaPendiente);
			}
			{
				cbComandasPendientes = new JComboBox<Comanda>();
				cbComandasPendientes.setEnabled(false);
				cbComandasPendientes.addActionListener(new CbComandasPendientesActionListener());
				cbComandasPendientes.setModel(new DefaultComboBoxModel<Comanda>());
				GridBagConstraints gbc_cbComandasPendientes = new GridBagConstraints();
				gbc_cbComandasPendientes.insets = new Insets(0, 0, 5, 5);
				gbc_cbComandasPendientes.fill = GridBagConstraints.HORIZONTAL;
				gbc_cbComandasPendientes.gridx = 1;
				gbc_cbComandasPendientes.gridy = 1;
				panel.add(cbComandasPendientes, gbc_cbComandasPendientes);
			}
			{
				lblNumComandasPendientes = new JLabel("(" + numComandasPendientes + ")");
				GridBagConstraints gbc_lblNumComandasPendientes = new GridBagConstraints();
				gbc_lblNumComandasPendientes.insets = new Insets(0, 0, 5, 0);
				gbc_lblNumComandasPendientes.gridx = 2;
				gbc_lblNumComandasPendientes.gridy = 1;
				panel.add(lblNumComandasPendientes, gbc_lblNumComandasPendientes);
			}
			{
				lblDescripcion = new JLabel("Descripcion:");
				GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
				gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
				gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
				gbc_lblDescripcion.gridx = 0;
				gbc_lblDescripcion.gridy = 2;
				panel.add(lblDescripcion, gbc_lblDescripcion);
			}
			{
				{
					scrollPane_1 = new JScrollPane();
					GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
					gbc_scrollPane_1.gridwidth = 2;
					gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
					gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
					gbc_scrollPane_1.gridx = 1;
					gbc_scrollPane_1.gridy = 2;
					panel.add(scrollPane_1, gbc_scrollPane_1);
					{
						textPaneInfoComandaSeleccionada = new JTextPane();
						scrollPane_1.setViewportView(textPaneInfoComandaSeleccionada);
						textPaneInfoComandaSeleccionada.setEditable(false);
					}
				}
				{
					panelMantenimiento = new JPanel();
					panelMantenimiento.setBorder(null);
					GridBagConstraints gbc_panelMantenimiento = new GridBagConstraints();
					gbc_panelMantenimiento.gridwidth = 3;
					gbc_panelMantenimiento.insets = new Insets(0, 0, 0, 5);
					gbc_panelMantenimiento.fill = GridBagConstraints.BOTH;
					gbc_panelMantenimiento.gridx = 0;
					gbc_panelMantenimiento.gridy = 3;
					panel.add(panelMantenimiento, gbc_panelMantenimiento);
					{
						btnGuardar = new JButton("Guardar");
						btnGuardar.addActionListener(new BtnGuardarActionListener());
						panelMantenimiento.add(btnGuardar);
					}
					{
						btnReponer = new JButton("Reponer");
						btnReponer.addActionListener(new BtnReponerActionListener());
						panelMantenimiento.add(btnReponer);
					}
					btnAvisar = new JButton("Avisar de Bebidas preparadas");
					panelMantenimiento.add(btnAvisar);
					btnAvisar.setEnabled(false);
					btnAvisar.addActionListener(new BtnAvisarActionListener());
				}
			}
		}
	}

	/**
	 * Metodo que ayuda a enlistar las comandas que disponen de bebidas en la
	 * JComboBox que las reune.
	 * 
	 * @param comanda a enlistar
	 */
	public void enlistarComanda(Comanda comanda) {
		cbComandasPendientes.setEnabled(true);
		textPaneAvisosComandaEntrante.setText("Se ha recibido una nueva comanda: " + comanda.toString() + ".");
		((DefaultComboBoxModel<Comanda>) cbComandasPendientes.getModel()).addElement(comanda);
		lblNumComandasPendientes.setText("(" + cbComandasPendientes.getItemCount() + ")");
	}

	/**
	 * Metodo que reduce el stock de bebidas de una determinada comanda seleccionada
	 * en la JComboBox, cuando se pulsa el boton de Avisar.
	 * 
	 * @param c
	 */
	private void reducirStockBebidas(Comanda c) {
		ArrayList<Bebida> listaBebidas = c.getBebidas();
		for (int i = 0; i < listaBebidas.size(); i++) {
			Almacen.getAlmacen().reducirStockBebidas(listaBebidas.get(i).getNombre());
		}

		if (Almacen.getAlmacen().comprobarUmbralBebidas()) {
			textPaneAvisosComandaEntrante
					.setText("Restado el stock de unidades de bebidas de esta ultima comanda.\n" + c.toStringBebidas());
		} else {
			textPaneAvisosComandaEntrante.setText("Restado el stock de unidades de bebidas de esta ultima comanda.\n"
					+ c.toStringBebidas() + ".\nIMPORTANTE: El stock de bebidas ha descendido por debajo del umbral.");
		}

	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de un
	 * elemento de la lista desplegable ComboBox donde estan enlistadas las Comandas
	 * Pendientes.
	 * 
	 * @author BC03
	 *
	 */
	private class CbComandasPendientesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnAvisar.setEnabled(true);
			try {
				textPaneInfoComandaSeleccionada
						.setText(((Comanda) cbComandasPendientes.getSelectedItem()).toStringBebidas());
			} catch (NullPointerException NPE) {
				/*
				 * Al eliminar un elemento de la ComboBox, el indice cambia y se ejecuta este
				 * metodo, devolviendo una NullPointer porque no hay nada seleccionado.
				 */
			}
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Avisar, que sirve para marcar como preparada las bebidas de la comanda por
	 * parte del camarero de barra, para avisar al camarero de mesa para que sirva
	 * las bebidas a la mesa.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnAvisarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Comanda comandaSeleccionada = (Comanda) cbComandasPendientes.getSelectedItem();
			((DefaultComboBoxModel<Comanda>) cbComandasPendientes.getModel()).removeElement(comandaSeleccionada);
			cbComandasPendientes.setSelectedIndex(-1);
			textPaneInfoComandaSeleccionada.setText("Aviso enviado correctamente.");
			btnAvisar.setEnabled(false);
			lblNumComandasPendientes.setText("(" + cbComandasPendientes.getItemCount() + ")");
			if (cbComandasPendientes.getItemCount() == 0)
				cbComandasPendientes.setEnabled(false);

			reducirStockBebidas(comandaSeleccionada);

			try {
				IU_CamareroMesa.getInterfaz().enlistarComanda(comandaSeleccionada);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Guardar, que sirve para actualizar la base de datos segun el stock actual del
	 * Almacen.
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
	 * Reponer, que sirve para actualizar los stocks de la base de datos y del
	 * Almacen al maximo de stock reglamentado, cuando se avisa de que ha descendido
	 * por debajo del umbral.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnReponerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Almacen.getAlmacen().reponerStocks();
		}
	}

	/**
	 * WindowListener segun inner class que maneja el evento de pulsacion del boton
	 * de cerrar la ventana (X), y que cierra la ventana y finaliza el programa en
	 * caso de pulsar Sí.
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
				setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Yes
				System.exit(1);
			} else {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // No
			}
		}
	}
}
