package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class IU_JefeSala extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTextField textFieldNombre;
	private JLabel lblNombre;
	private JLabel lblMesa;
	private JComboBox comboBox;
	private JLabel lblFecha;
	private JFormattedTextField formattedTextField;

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
			gbl_panel.columnWidths = new int[]{0, 0, 121, 235, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				comboBox = new JComboBox();
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 2;
				gbc_comboBox.gridy = 3;
				panel.add(comboBox, gbc_comboBox);
			}
			{
				lblFecha = new JLabel("Fecha:");
				GridBagConstraints gbc_lblFecha = new GridBagConstraints();
				gbc_lblFecha.anchor = GridBagConstraints.EAST;
				gbc_lblFecha.insets = new Insets(0, 0, 0, 5);
				gbc_lblFecha.gridx = 1;
				gbc_lblFecha.gridy = 5;
				panel.add(lblFecha, gbc_lblFecha);
			}
			{
				MaskFormatter formato= new MaskFormatter("## / ## / ##");
				formattedTextField = new JFormattedTextField(formato);
				GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
				gbc_formattedTextField.insets = new Insets(0, 0, 0, 5);
				gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_formattedTextField.gridx = 2;
				gbc_formattedTextField.gridy = 5;
				panel.add(formattedTextField, gbc_formattedTextField);
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
		}
	}

}
