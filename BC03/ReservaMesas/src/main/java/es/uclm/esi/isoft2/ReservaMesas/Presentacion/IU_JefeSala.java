package es.uclm.esi.isoft2.ReservaMesas.Presentacion;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Constantes;
import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.MesaDAO;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.EstadosMesas;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;
import es.uclm.esi.isoft2.ReservaMesas.Dominio.GestorMesa;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class IU_JefeSala extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField textFieldDni;
	private JLabel lblDni;
	private JLabel lblMesa;
	private JComboBox<Mesa> cBMesas;
	private JLabel lblFecha;
	private JFormattedTextField ftfFecha;
	private JLabel lblReserva;
	private static JComboBox<Mesa> cBLlegadaReserva;
	private JButton btnLlegada;
	private JButton btnCancelarReserva;
	private JButton btnReservar;
	private JLabel lblDniCliente;
	private JTextField txtDni;
	private JButton btnRefrescar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_JefeSala frame = new IU_JefeSala();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 * @throws SQLException
	 */
	public IU_JefeSala() throws ParseException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 172, 110, 100, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		{
			panel = new JPanel();
			panel.setBorder(
					new TitledBorder(null, "Nueva reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 1;
			contentPane.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 85, 103, 235, 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				lblDni = new JLabel("Dni Cliente:");
				GridBagConstraints gbc_lblDni = new GridBagConstraints();
				gbc_lblDni.insets = new Insets(0, 0, 5, 5);
				gbc_lblDni.anchor = GridBagConstraints.EAST;
				gbc_lblDni.gridx = 1;
				gbc_lblDni.gridy = 1;
				panel.add(lblDni, gbc_lblDni);
			}
			{
				textFieldDni = new JTextField();
				GridBagConstraints gbc_textFieldDni = new GridBagConstraints();
				gbc_textFieldDni.gridwidth = 2;
				gbc_textFieldDni.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldDni.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldDni.gridx = 2;
				gbc_textFieldDni.gridy = 1;
				panel.add(textFieldDni, gbc_textFieldDni);
				textFieldDni.setColumns(10);
			}
			{
				lblMesa = new JLabel("Mesa:");
				GridBagConstraints gbc_lblMesa = new GridBagConstraints();
				gbc_lblMesa.anchor = GridBagConstraints.EAST;
				gbc_lblMesa.insets = new Insets(0, 0, 5, 5);
				gbc_lblMesa.gridx = 1;
				gbc_lblMesa.gridy = 3;
				panel.add(lblMesa, gbc_lblMesa);
			}
			{
				cBMesas = new JComboBox<Mesa>();
				GridBagConstraints gbc_cBMesas = new GridBagConstraints();
				gbc_cBMesas.insets = new Insets(0, 0, 5, 5);
				gbc_cBMesas.fill = GridBagConstraints.HORIZONTAL;
				gbc_cBMesas.gridx = 2;
				gbc_cBMesas.gridy = 3;
				panel.add(cBMesas, gbc_cBMesas);
				DefaultComboBoxModel<Mesa> modelo = rellenarCbLibres();
				cBMesas.setModel(modelo);
			}
			{
				lblFecha = new JLabel("Fecha:");
				GridBagConstraints gbc_lblFecha = new GridBagConstraints();
				gbc_lblFecha.anchor = GridBagConstraints.EAST;
				gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
				gbc_lblFecha.gridx = 1;
				gbc_lblFecha.gridy = 5;
				panel.add(lblFecha, gbc_lblFecha);
			}
			{
				MaskFormatter formatoFecha = new MaskFormatter("##/##/####");
				ftfFecha = new JFormattedTextField(formatoFecha);
				GridBagConstraints gbc_ftfFecha = new GridBagConstraints();
				gbc_ftfFecha.insets = new Insets(0, 0, 5, 5);
				gbc_ftfFecha.fill = GridBagConstraints.HORIZONTAL;
				gbc_ftfFecha.gridx = 2;
				gbc_ftfFecha.gridy = 5;
				panel.add(ftfFecha, gbc_ftfFecha);
			}
			{
				btnReservar = new JButton("Reservar");
				btnReservar.addActionListener(new BtnReservarActionListener());
				GridBagConstraints gbc_btnReservar = new GridBagConstraints();
				gbc_btnReservar.insets = new Insets(0, 0, 0, 5);
				gbc_btnReservar.gridx = 4;
				gbc_btnReservar.gridy = 6;
				panel.add(btnReservar, gbc_btnReservar);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Llegada clientes reserva", TitledBorder.LEADING, TitledBorder.TOP,
					null, null));
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.insets = new Insets(0, 0, 5, 5);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 1;
			gbc_panel_1.gridy = 2;
			contentPane.add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0 };
			gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel_1.setLayout(gbl_panel_1);
			{
				lblDniCliente = new JLabel("Dni Cliente::");
				GridBagConstraints gbc_lblDniCliente = new GridBagConstraints();
				gbc_lblDniCliente.anchor = GridBagConstraints.EAST;
				gbc_lblDniCliente.insets = new Insets(0, 0, 5, 5);
				gbc_lblDniCliente.gridx = 1;
				gbc_lblDniCliente.gridy = 1;
				panel_1.add(lblDniCliente, gbc_lblDniCliente);
			}
			{
				txtDni = new JTextField();
				txtDni.setColumns(10);
				GridBagConstraints gbc_txtDni = new GridBagConstraints();
				gbc_txtDni.insets = new Insets(0, 0, 5, 5);
				gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDni.gridx = 2;
				gbc_txtDni.gridy = 1;
				panel_1.add(txtDni, gbc_txtDni);
			}
			{
				btnLlegada = new JButton("Llegada");
				btnLlegada.addActionListener(new BtnLlegadaActionListener());
				GridBagConstraints gbc_btnLlegada = new GridBagConstraints();
				gbc_btnLlegada.insets = new Insets(0, 0, 5, 5);
				gbc_btnLlegada.gridx = 4;
				gbc_btnLlegada.gridy = 1;
				panel_1.add(btnLlegada, gbc_btnLlegada);
			}
			{
				lblReserva = new JLabel("Reserva:");
				GridBagConstraints gbc_lblReserva = new GridBagConstraints();
				gbc_lblReserva.insets = new Insets(0, 0, 0, 5);
				gbc_lblReserva.anchor = GridBagConstraints.EAST;
				gbc_lblReserva.gridx = 1;
				gbc_lblReserva.gridy = 2;
				panel_1.add(lblReserva, gbc_lblReserva);
			}
			{
				cBLlegadaReserva = new JComboBox<Mesa>();
				GridBagConstraints gbc_cBLlegadaReserva = new GridBagConstraints();
				gbc_cBLlegadaReserva.insets = new Insets(0, 0, 0, 5);
				gbc_cBLlegadaReserva.fill = GridBagConstraints.HORIZONTAL;
				gbc_cBLlegadaReserva.gridx = 2;
				gbc_cBLlegadaReserva.gridy = 2;
				DefaultComboBoxModel<Mesa> modelo = rellenarCbReserva();
				cBLlegadaReserva.setModel(modelo);
				panel_1.add(cBLlegadaReserva, gbc_cBLlegadaReserva);
			}
			{
				btnCancelarReserva = new JButton("Cancelar");
				GridBagConstraints gbc_btnCancelarReserva = new GridBagConstraints();
				gbc_btnCancelarReserva.insets = new Insets(0, 0, 0, 5);
				gbc_btnCancelarReserva.gridx = 4;
				gbc_btnCancelarReserva.gridy = 2;
				panel_1.add(btnCancelarReserva, gbc_btnCancelarReserva);
				btnCancelarReserva.addActionListener(new BtnCancelarReservaActionListener());
			}
		}
		{
			{
				DefaultComboBoxModel<Mesa> modelo = rellenarCbReserva();
			}
		}
		{
			btnRefrescar = new JButton("Refrescar");
			btnRefrescar.addActionListener(new BtnRefrescarActionListener());
			GridBagConstraints gbc_btnRefrescar = new GridBagConstraints();
			gbc_btnRefrescar.fill = GridBagConstraints.BOTH;
			gbc_btnRefrescar.insets = new Insets(0, 0, 5, 5);
			gbc_btnRefrescar.gridx = 1;
			gbc_btnRefrescar.gridy = 5;
			contentPane.add(btnRefrescar, gbc_btnRefrescar);
		}
	}

	private class BtnCancelarReservaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			Mesa m = (Mesa) cBLlegadaReserva.getSelectedItem();
			try {
				GestorMesa.cancelarMesa(m.getId());
				cBMesas.addItem(m);
				cBLlegadaReserva.removeItem(m);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	private class BtnLlegadaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String dni = txtDni.getText();
			Mesa reservada = (Mesa) cBLlegadaReserva.getSelectedItem();
			try {
				GestorMesa.cambiarEstadoOcupado(reservada.getId(), dni);
				cBLlegadaReserva.removeItem(reservada);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	private class BtnReservarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String dni = textFieldDni.getText();
			String fechaString = ftfFecha.getText();
			Mesa reservada = (Mesa) cBMesas.getSelectedItem();

			try {
				Date fecha = new SimpleDateFormat("dd/MM/yy").parse(fechaString);
				reservada.modificarDatosReservado(dni, fecha);
				cBLlegadaReserva.addItem(reservada);
				cBMesas.removeItem(reservada);
				GestorMesa.actualizarMesa(reservada.getId(), "RESERVADA", reservada.getDni());
			} catch (ParseException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	private class BtnRefrescarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultComboBoxModel<Mesa> modelo;
			DefaultComboBoxModel<Mesa> modelo2;
			try {
				modelo = rellenarCbReserva();
				modelo2 = rellenarCbLibres();

				cBLlegadaReserva.setModel(modelo);
				cBMesas.setModel(modelo2);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static DefaultComboBoxModel<Mesa> rellenarCbReserva() throws SQLException {
		DefaultComboBoxModel<Mesa> modelo = new DefaultComboBoxModel<Mesa>();
		for (int m = 1; m <= Constantes.NUM_MESAS; m++) {
			ArrayList<Integer> mesasReservadas = MesaDAO.consultarMesasReservadas();
			for (int i = 0; i < mesasReservadas.size(); i++) {
				if (mesasReservadas.get(i) == m) {
					modelo.addElement(new Mesa(m, EstadosMesas.RESERVADA));
				}
			}
		}
		return modelo;
	}

	public static DefaultComboBoxModel<Mesa> rellenarCbLibres() throws SQLException {
		DefaultComboBoxModel<Mesa> modelo = new DefaultComboBoxModel<Mesa>();
		for (int m = 1; m <= Constantes.NUM_MESAS; m++) {
			ArrayList<Integer> mesasDisponibles = MesaDAO.consultarMesasDisponibles();
			for (int i = 0; i < mesasDisponibles.size(); i++) {
				if (mesasDisponibles.get(i) == m) {
					modelo.addElement(new Mesa(m, EstadosMesas.LIBRE));
				}
			}
		}
		return modelo;
	}

	public static JComboBox<Mesa> getComboBoxReservadas() {
		return cBLlegadaReserva;
	}

	public static void setComboBoxReservadas(JComboBox<Mesa> cbMesas) {
		cBLlegadaReserva = cbMesas;
	}
}