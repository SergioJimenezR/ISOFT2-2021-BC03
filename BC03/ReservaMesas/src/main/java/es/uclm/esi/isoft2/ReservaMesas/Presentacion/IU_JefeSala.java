package es.uclm.esi.isoft2.ReservaMesas.Presentacion;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import es.uclm.esi.isoft2.PedidosComandas.Dominio.EstadosMesas;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;
import es.uclm.esi.isoft2.PedidosComandas.Presentacion.IU_CamareroMesa;
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
	private JPanel panel_2;
	private JTextField textFieldNombre;
	private JLabel lblNombre;
	private JLabel lblMesa;
	private JComboBox <Mesa> cBMesas;
	private JLabel lblFecha;
	private JFormattedTextField ftfFecha;
	private JLabel lblReserva;
	private JComboBox <Mesa> cBLlegadaReserva;
	private JButton btnLlegada;
	private JLabel lblReservaCancel;
	private JComboBox <Mesa> cBCancelarReserva;
	private JButton btnCancelarReserva;
	private JLabel lblTelefono;
	private JFormattedTextField fTFTelefono;
	private JButton btnReservar;
	private JLabel lblNombreCliente;
	private JTextField txtNombre;

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
	 * @throws ParseException 
	 */
	public IU_JefeSala() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 172, 110, 100, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Nueva reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 1;
			contentPane.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 103, 235, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				lblNombre = new JLabel("Nombre:");
				GridBagConstraints gbc_lblNombre = new GridBagConstraints();
				gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
				gbc_lblNombre.anchor = GridBagConstraints.EAST;
				gbc_lblNombre.gridx = 1;
				gbc_lblNombre.gridy = 1;
				panel.add(lblNombre, gbc_lblNombre);
			}
			{
				textFieldNombre = new JTextField();
				GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
				gbc_textFieldNombre.gridwidth = 2;
				gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldNombre.gridx = 2;
				gbc_textFieldNombre.gridy = 1;
				panel.add(textFieldNombre, gbc_textFieldNombre);
				textFieldNombre.setColumns(10);
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
				//this.completarComboBoxMesas();
			}
			{
				lblTelefono = new JLabel("Teléfono");
				GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
				gbc_lblTelefono.anchor = GridBagConstraints.EAST;
				gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
				gbc_lblTelefono.gridx = 1;
				gbc_lblTelefono.gridy = 4;
				panel.add(lblTelefono, gbc_lblTelefono);
			}
			{
				MaskFormatter formatoTelefono= new MaskFormatter("#########");
				fTFTelefono = new JFormattedTextField(formatoTelefono);
				GridBagConstraints gbc_fTFTelefono = new GridBagConstraints();
				gbc_fTFTelefono.insets = new Insets(0, 0, 5, 5);
				gbc_fTFTelefono.fill = GridBagConstraints.HORIZONTAL;
				gbc_fTFTelefono.gridx = 2;
				gbc_fTFTelefono.gridy = 4;
				panel.add(fTFTelefono, gbc_fTFTelefono);
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
				MaskFormatter formatoFecha= new MaskFormatter("##/##/##");
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
			panel_1.setBorder(new TitledBorder(null, "Llegada clientes reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.insets = new Insets(0, 0, 5, 5);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 1;
			gbc_panel_1.gridy = 2;
			contentPane.add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			{
				lblNombreCliente = new JLabel("Nombre:");
				GridBagConstraints gbc_lblNombreCliente = new GridBagConstraints();
				gbc_lblNombreCliente.anchor = GridBagConstraints.EAST;
				gbc_lblNombreCliente.insets = new Insets(0, 0, 5, 5);
				gbc_lblNombreCliente.gridx = 1;
				gbc_lblNombreCliente.gridy = 1;
				panel_1.add(lblNombreCliente, gbc_lblNombreCliente);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				GridBagConstraints gbc_txtNombre = new GridBagConstraints();
				gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
				gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtNombre.gridx = 2;
				gbc_txtNombre.gridy = 1;
				panel_1.add(txtNombre, gbc_txtNombre);
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
				panel_1.add(cBLlegadaReserva, gbc_cBLlegadaReserva);
			}
			{
				btnLlegada = new JButton("Llegada");
				btnLlegada.addActionListener(new BtnLlegadaActionListener());
				GridBagConstraints gbc_btnLlegada = new GridBagConstraints();
				gbc_btnLlegada.insets = new Insets(0, 0, 0, 5);
				gbc_btnLlegada.gridx = 4;
				gbc_btnLlegada.gridy = 2;
				panel_1.add(btnLlegada, gbc_btnLlegada);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Cancelar reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel_2 = new GridBagConstraints();
			gbc_panel_2.insets = new Insets(0, 0, 5, 5);
			gbc_panel_2.fill = GridBagConstraints.BOTH;
			gbc_panel_2.gridx = 1;
			gbc_panel_2.gridy = 3;
			contentPane.add(panel_2, gbc_panel_2);
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel_2.rowHeights = new int[]{0, 0, 0};
			gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel_2.setLayout(gbl_panel_2);
			{
				lblReservaCancel = new JLabel("Reserva");
				GridBagConstraints gbc_lblReservaCancel = new GridBagConstraints();
				gbc_lblReservaCancel.insets = new Insets(0, 0, 0, 5);
				gbc_lblReservaCancel.gridx = 1;
				gbc_lblReservaCancel.gridy = 1;
				panel_2.add(lblReservaCancel, gbc_lblReservaCancel);
			}
			{
				cBCancelarReserva = new JComboBox<Mesa>();
				GridBagConstraints gbc_cBCancelarReserva = new GridBagConstraints();
				gbc_cBCancelarReserva.gridwidth = 2;
				gbc_cBCancelarReserva.insets = new Insets(0, 0, 0, 5);
				gbc_cBCancelarReserva.fill = GridBagConstraints.HORIZONTAL;
				gbc_cBCancelarReserva.gridx = 2;
				gbc_cBCancelarReserva.gridy = 1;
				panel_2.add(cBCancelarReserva, gbc_cBCancelarReserva);
			}
			{
				btnCancelarReserva = new JButton("Cancelar");
				btnCancelarReserva.addActionListener(new BtnCancelarReservaActionListener());
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
				gbc_btnNewButton.gridx = 5;
				gbc_btnNewButton.gridy = 1;
				panel_2.add(btnCancelarReserva, gbc_btnNewButton);
			}
		}			
	}
	
	public void completarComboBoxMesas() {
		JComboBox<Mesa> mesas = IU_CamareroMesa.getComboBoxMesas();
		DefaultComboBoxModel<Mesa> modelo = new DefaultComboBoxModel<Mesa>();
		for (int i = 0; i < mesas.getItemCount(); i++) {
			if (mesas.getItemAt(i).getEstadoMesa() != EstadosMesas.LIBRE 
					&& mesas.getItemAt(i).getEstadoMesa() != EstadosMesas.RESERVADA) {
				modelo.addElement(mesas.getItemAt(i));
			}
		}
		this.cBMesas.setModel(modelo);
	}
	private class BtnCancelarReservaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			Mesa m = (Mesa) cBCancelarReserva.getSelectedItem();
			
			try {
				GestorMesa.cancelarMesa(m.getId());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class BtnLlegadaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombre = lblNombreCliente.getText();
			Mesa reservada = (Mesa)cBLlegadaReserva.getSelectedItem();
			try {
				GestorMesa.cambiarEstadoOcupado(reservada.getId(), nombre);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class BtnReservarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				String nombre = lblNombre.getText();
				String fechaString = ftfFecha.getText();
				Mesa reservada = (Mesa)cBMesas.getSelectedItem();

				try {
					Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaString);
					reservada.modificarDatosReservado(nombre, fecha);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}		
		}
	}
		
	
}
