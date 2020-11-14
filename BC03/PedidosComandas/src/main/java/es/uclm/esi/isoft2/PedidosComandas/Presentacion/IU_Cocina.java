package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Comanda;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Cocina extends JFrame {

	private static final long serialVersionUID = 1L;

	private static IU_CamareroMesa frmCamareroMesa;
	private static IU_Cocina frmCocina;
	
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblUltimaComandaEntrante;
	private JTextPane textPaneComandaEntrante;
	private JLabel lblComandaPendiente;
	private JLabel lblDescripcion;
	private JTextPane textPaneInfoComandaSeleccionada;
	private JButton btnAvisar;
	private JComboBox<Comanda> cbComandasPendientes;
	private JLabel lblNumComandasPendientes;

	private int numComandasPendientes;

	/**
	 * Create the frame.
	 */
	public IU_Cocina() {

		numComandasPendientes = 0;

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COCINA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPane.add(panel, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 279, 26, 0 };
			gbl_panel.rowHeights = new int[] { 50, 0, 50, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				lblUltimaComandaEntrante = new JLabel("Última comanda entrante:");
				GridBagConstraints gbc_lblUltimaComandaEntrante = new GridBagConstraints();
				gbc_lblUltimaComandaEntrante.anchor = GridBagConstraints.EAST;
				gbc_lblUltimaComandaEntrante.insets = new Insets(0, 0, 5, 5);
				gbc_lblUltimaComandaEntrante.gridx = 0;
				gbc_lblUltimaComandaEntrante.gridy = 0;
				panel.add(lblUltimaComandaEntrante, gbc_lblUltimaComandaEntrante);
			}
			{
				textPaneComandaEntrante = new JTextPane();
				textPaneComandaEntrante.setEditable(false);
				GridBagConstraints gbc_textPaneComandaEntrante = new GridBagConstraints();
				gbc_textPaneComandaEntrante.fill = GridBagConstraints.BOTH;
				gbc_textPaneComandaEntrante.gridwidth = 2;
				gbc_textPaneComandaEntrante.insets = new Insets(0, 0, 5, 0);
				gbc_textPaneComandaEntrante.gridx = 1;
				gbc_textPaneComandaEntrante.gridy = 0;
				panel.add(textPaneComandaEntrante, gbc_textPaneComandaEntrante);
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
				lblDescripcion = new JLabel("Descripción:");
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
				GridBagConstraints gbc_btnAvisar = new GridBagConstraints();
				gbc_btnAvisar.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnAvisar.gridwidth = 2;
				gbc_btnAvisar.gridx = 1;
				gbc_btnAvisar.gridy = 3;
				panel.add(btnAvisar, gbc_btnAvisar);
			}
		}
	}
	
	public static void receiveFromCamareroMesa(Comanda C, IU_CamareroMesa origen, IU_Cocina destino) {
		frmCamareroMesa = origen;
		frmCocina = destino;
		frmCocina.enlistarComanda(C);
	}
	
	private void enlistarComanda(Comanda comanda) {
		cbComandasPendientes.setEnabled(true);
		textPaneComandaEntrante.setText("Se ha recibido una nueva comanda: " + comanda.toString() + ".");
		lblNumComandasPendientes.setText("(" + ++numComandasPendientes + ")");
		((DefaultComboBoxModel<Comanda>) cbComandasPendientes.getModel()).addElement(comanda);
	}

	private class CbComandasPendientesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnAvisar.setEnabled(true);
			try {
				textPaneInfoComandaSeleccionada.setText(((Comanda) cbComandasPendientes.getSelectedItem()).toStringPlatos());
			} catch (NullPointerException NPE) {
				// Al eliminar un elemento de la ComboBox, el índice cambia y se ejecuta este método, devolviendo una NullPointer porque no hay nada seleccionado.
			}
		}
	}
	private class BtnAvisarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Comanda comandaSeleccionada = (Comanda) cbComandasPendientes.getSelectedItem();
			((DefaultComboBoxModel<Comanda>) cbComandasPendientes.getModel()).removeElement(comandaSeleccionada);
			cbComandasPendientes.setSelectedIndex(-1);
			textPaneInfoComandaSeleccionada.setText("Aviso enviado correctamente.");
			btnAvisar.setEnabled(false);
			lblNumComandasPendientes.setText("(" + --numComandasPendientes + ")");
			if(numComandasPendientes == 0)
				cbComandasPendientes.setEnabled(false);
			
			IU_CamareroMesa.receiveFromCocina(comandaSeleccionada, frmCocina, frmCamareroMesa);
		}
	}
}
