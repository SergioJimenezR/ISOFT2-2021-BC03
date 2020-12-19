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
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Plato;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import java.awt.event.ActionEvent;

/**
 * Clase que representa la interfaz grafica de usuario de la Cocina.
 * 
 * @author BC03
 *
 */
public class IU_Cocina extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Instancia del patron singleton.
	 */
	private static IU_Cocina mInstancia = null;

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
	 * Numero que representa el numero de ccomandas pendientes a preparar.
	 */
	private int numComandasPendientes;

	/**
	 * Metodo que devuelve la instancia de la interfaz, del patron Singleton.
	 * 
	 * @return instancia
	 */
	public static IU_Cocina getInterfaz() { // Patron Singleton
		if (mInstancia == null) {
			mInstancia = new IU_Cocina();
			mInstancia.setVisible(true);
		}
		return mInstancia;
	}

	/**
	 * Constructor de la interfaz grafica de usuario, que ayuda a colocar todos los
	 * elementos sobre esta.
	 */
	private IU_Cocina() {

		addWindowListener(new ThisWindowListener());

		setTitle("Vista Cocinero");

		numComandasPendientes = 0;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"COCINA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPane.add(panel, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 182, 279, 26, 0 };
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
				textPaneAvisosComandaEntrante = new JTextPane();
				textPaneAvisosComandaEntrante.setEditable(false);
				GridBagConstraints gbc_textPaneComandaEntrante = new GridBagConstraints();
				gbc_textPaneComandaEntrante.fill = GridBagConstraints.BOTH;
				gbc_textPaneComandaEntrante.gridwidth = 2;
				gbc_textPaneComandaEntrante.insets = new Insets(0, 0, 5, 0);
				gbc_textPaneComandaEntrante.gridx = 1;
				gbc_textPaneComandaEntrante.gridy = 0;
				panel.add(textPaneAvisosComandaEntrante, gbc_textPaneComandaEntrante);
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
				textPaneInfoComandaSeleccionada = new JTextPane();
				textPaneInfoComandaSeleccionada.setEditable(false);
				GridBagConstraints gbc_textPaneInfoComandaSeleccionada = new GridBagConstraints();
				gbc_textPaneInfoComandaSeleccionada.fill = GridBagConstraints.BOTH;
				gbc_textPaneInfoComandaSeleccionada.gridwidth = 2;
				gbc_textPaneInfoComandaSeleccionada.insets = new Insets(0, 0, 5, 0);
				gbc_textPaneInfoComandaSeleccionada.gridx = 1;
				gbc_textPaneInfoComandaSeleccionada.gridy = 2;
				panel.add(textPaneInfoComandaSeleccionada, gbc_textPaneInfoComandaSeleccionada);
			}
			{
				btnAvisar = new JButton("Avisar de Platos preparados");
				btnAvisar.setEnabled(false);
				btnAvisar.addActionListener(new BtnAvisarActionListener());
				{
					panelMantenimiento = new JPanel();
					panelMantenimiento.setBorder(null);
					GridBagConstraints gbc_panelMantenimiento = new GridBagConstraints();
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
				}
				GridBagConstraints gbc_btnAvisar = new GridBagConstraints();
				gbc_btnAvisar.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnAvisar.gridwidth = 2;
				gbc_btnAvisar.gridx = 1;
				gbc_btnAvisar.gridy = 3;
				panel.add(btnAvisar, gbc_btnAvisar);
			}
		}
	}

	/**
	 * Metodo que ayuda a enlistar las comandas que disponen de comidas en la
	 * JComboBox que las reune.
	 * 
	 * @param comanda a enlistar
	 */
	public void enlistarComanda(Comanda comanda) {
		cbComandasPendientes.setEnabled(true);
		textPaneAvisosComandaEntrante.setText("Se ha recibido una nueva comanda: " + comanda.toString() + ".");

		lblNumComandasPendientes.setText("(" + ++numComandasPendientes + ")");
		((DefaultComboBoxModel<Comanda>) cbComandasPendientes.getModel()).addElement(comanda);
	}

	/**
	 * Metodo que reduce el stock de comidas de una determinada comanda seleccionada
	 * en la JComboBox, cuando se pulsa el boton de Avisar.
	 * 
	 * @param c
	 */
	private void reducirStockPlatos(Comanda c) {
		ArrayList<Plato> listaPlatos = null;
		for (int i = 0; i < 3; i++) {
			switch (i) {
			case 0:
				listaPlatos = c.getEntrantes();
				break;
			case 1:
				listaPlatos = c.getPrimeros();
				break;
			case 2:
				listaPlatos = c.getSegundos();
				break;
			case 3:
				listaPlatos = c.getPostres();
				break;
			}
			for (int j = 0; j < listaPlatos.size(); j++) {
				Almacen.getAlmacen().reducirStockPlatos(listaPlatos.get(j).getIngredientes());
			}
		}

		if (Almacen.getAlmacen().comprobarUmbralIngredientes()) {
			textPaneAvisosComandaEntrante.setText(
					"Restado el stock de ingredientes de los platos de esta ultima comanda.\n" + c.toStringPlatos());
		} else {
			textPaneAvisosComandaEntrante.setText(
					"Restado el stock de ingredientes de los platos de esta ultima comanda.\n" + c.toStringPlatos()
							+ ".\nIMPORTANTE: El stock de ingredientes ha descendido por debajo del umbral.");
		}

	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion de un
	 * elemento de la lista desplegable JComboBox donde estan enlistadas las
	 * Comandas Pendientes.
	 * 
	 * @author BC03
	 *
	 */
	private class CbComandasPendientesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnAvisar.setEnabled(true);
			try {
				textPaneInfoComandaSeleccionada
						.setText(((Comanda) cbComandasPendientes.getSelectedItem()).toStringPlatos());
			} catch (NullPointerException NPE) {
				// Al eliminar un elemento de la ComboBox, el indice cambia y se ejecuta este
				// metodo, devolviendo una NullPointer porque no hay nada seleccionado.
			}
		}
	}

	/**
	 * ActionListener segun inner class que maneja el evento de pulsacion del boton
	 * Avisar, que srive para marcar como preparada las comidas de la comanda por
	 * parte de la cocina, para avisar al camarero de mesa para que sirva la comida
	 * a la mesa.
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
			lblNumComandasPendientes.setText("(" + --numComandasPendientes + ")");
			if (numComandasPendientes == 0)
				cbComandasPendientes.setEnabled(false);

			reducirStockPlatos(comandaSeleccionada);

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
	 * almacen al maximo de stock reglamentado, cuando se avisa de que se ha
	 * descendido por debajo del umbral.
	 * 
	 * @author BC03
	 *
	 */
	private class BtnReponerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Almacen.getAlmacen().reponerStocks();
		}
	}

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
