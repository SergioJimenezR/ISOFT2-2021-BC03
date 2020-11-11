package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class UI_CamareroMesa {

	private JFrame frmInterfazCamareroBarra;
	private JPanel panel;
	private JPanel panelSelecMesa;
	private JPanel panelComanda;
	private JPanel panelEntrantes;
	private JPanel panelPrimerPlato;
	private JPanel panelSegundoPlato;
	private JPanel panelPostre;
	private JPanel panelBebida;
	private JButton btnCerrarComanda;
	private JCheckBox chckbxPapas;
	private JSpinner spinnerPapas;
	private JCheckBox chckbxTortilla;
	private JSpinner spinnerTortilla;
	private JCheckBox chckbxEnsalada;
	private JSpinner spinnerEnsalada;
	private JCheckBox chckbxMontado;
	private JSpinner spinnerMontado;
	private JCheckBox chckbxCalamares;
	private JSpinner spinnerCalamares;
	private JButton btnCancelarComanda;
	private JCheckBox chckbxPolloAsado;
	private JSpinner spinnerPolloAsado;
	private JCheckBox chckbxMacarrones;
	private JSpinner spinnerMacarrones;
	private JCheckBox chckbxEnsalada_1;
	private JSpinner spinnerEnsalada_1;
	private JCheckBox chckbxMontado_1;
	private JSpinner spinnerMontado_1;
	private JSpinner spinnerCalamares_1;
	private JCheckBox chckbxCalamares_1;
	private JButton btnComenzarComanda;
	private JComboBox comboBox;
	private JLabel lblEstadoMesa;
	private JTextPane textPaneEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_CamareroMesa window = new UI_CamareroMesa();
					window.frmInterfazCamareroBarra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI_CamareroMesa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInterfazCamareroBarra = new JFrame();
		frmInterfazCamareroBarra.setTitle("Interfaz Camarero Barra");
		frmInterfazCamareroBarra.setBounds(100, 100, 880, 645);
		frmInterfazCamareroBarra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			panel = new JPanel();
			frmInterfazCamareroBarra.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new CardLayout(0, 0));
			{
				panelSelecMesa = new JPanel();
				panel.add(panelSelecMesa, "name_784089217106300");
				GridBagLayout gbl_panelSelecMesa = new GridBagLayout();
				gbl_panelSelecMesa.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
				gbl_panelSelecMesa.rowHeights = new int[]{0, 0, 0, 0, 67, 0, 0};
				gbl_panelSelecMesa.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
				gbl_panelSelecMesa.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
				panelSelecMesa.setLayout(gbl_panelSelecMesa);
				{
					comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mesa 1", "Mesa 2", "Mesa 3", "Mesa 4", "Mesa 5", "Mesa 6"}));
					GridBagConstraints gbc_comboBox = new GridBagConstraints();
					gbc_comboBox.insets = new Insets(0, 0, 5, 5);
					gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
					gbc_comboBox.gridx = 1;
					gbc_comboBox.gridy = 1;
					panelSelecMesa.add(comboBox, gbc_comboBox);
				}
				{
					lblEstadoMesa = new JLabel("Estado de la Mesa:");
					GridBagConstraints gbc_lblEstadoMesa = new GridBagConstraints();
					gbc_lblEstadoMesa.insets = new Insets(0, 0, 5, 5);
					gbc_lblEstadoMesa.gridx = 1;
					gbc_lblEstadoMesa.gridy = 2;
					panelSelecMesa.add(lblEstadoMesa, gbc_lblEstadoMesa);
				}
				{
					textPaneEstado = new JTextPane();
					textPaneEstado.setText("Estado Mesa");
					GridBagConstraints gbc_textPaneEstado = new GridBagConstraints();
					gbc_textPaneEstado.insets = new Insets(0, 0, 5, 5);
					gbc_textPaneEstado.fill = GridBagConstraints.HORIZONTAL;
					gbc_textPaneEstado.gridx = 2;
					gbc_textPaneEstado.gridy = 2;
					panelSelecMesa.add(textPaneEstado, gbc_textPaneEstado);
				}
				{
					btnComenzarComanda = new JButton("Realizar Comanda");
					btnComenzarComanda.setEnabled(false);
					btnComenzarComanda.setFont(new Font("Tahoma", Font.BOLD, 17));
					GridBagConstraints gbc_btnComenzarComanda = new GridBagConstraints();
					gbc_btnComenzarComanda.fill = GridBagConstraints.BOTH;
					gbc_btnComenzarComanda.gridwidth = 2;
					gbc_btnComenzarComanda.insets = new Insets(0, 0, 5, 5);
					gbc_btnComenzarComanda.gridx = 2;
					gbc_btnComenzarComanda.gridy = 4;
					panelSelecMesa.add(btnComenzarComanda, gbc_btnComenzarComanda);
				}
			}
			{
				panelComanda = new JPanel();
				panel.add(panelComanda, "name_784092948542100");
				GridBagLayout gbl_panelComanda = new GridBagLayout();
				gbl_panelComanda.columnWidths = new int[]{-42, 171, 274, 237, 245, 0, 0};
				gbl_panelComanda.rowHeights = new int[]{37, 60, 75, 120, 121, 85, 14, 57, -17, 0};
				gbl_panelComanda.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
				gbl_panelComanda.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
				panelComanda.setLayout(gbl_panelComanda);
				{
					panelBebida = new JPanel();
					panelBebida.setBorder(new TitledBorder(null, "Bebida", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					GridBagConstraints gbc_panelBebida = new GridBagConstraints();
					gbc_panelBebida.gridwidth = 4;
					gbc_panelBebida.insets = new Insets(0, 0, 5, 5);
					gbc_panelBebida.fill = GridBagConstraints.BOTH;
					gbc_panelBebida.gridx = 1;
					gbc_panelBebida.gridy = 1;
					panelComanda.add(panelBebida, gbc_panelBebida);
				}
				{
					panelEntrantes = new JPanel();
					panelEntrantes.setBorder(new TitledBorder(null, "Entrantes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panelEntrantes.setLayout(null);
					GridBagConstraints gbc_panelEntrantes = new GridBagConstraints();
					gbc_panelEntrantes.gridwidth = 4;
					gbc_panelEntrantes.insets = new Insets(0, 0, 5, 5);
					gbc_panelEntrantes.fill = GridBagConstraints.BOTH;
					gbc_panelEntrantes.gridx = 1;
					gbc_panelEntrantes.gridy = 2;
					panelComanda.add(panelEntrantes, gbc_panelEntrantes);
					{
						chckbxPapas = new JCheckBox("Papas Bravas");
						chckbxPapas.setBounds(29, 27, 87, 21);
						panelEntrantes.add(chckbxPapas);
					}
					{
						spinnerPapas = new JSpinner();
						spinnerPapas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
						spinnerPapas.setBounds(122, 28, 30, 20);
						panelEntrantes.add(spinnerPapas);
					}
					{
						chckbxTortilla = new JCheckBox("Tortilla");
						chckbxTortilla.setBounds(199, 27, 57, 21);
						panelEntrantes.add(chckbxTortilla);
					}
					{
						spinnerTortilla = new JSpinner();
						spinnerTortilla.setBounds(262, 28, 30, 20);
						panelEntrantes.add(spinnerTortilla);
					}
					{
						chckbxEnsalada = new JCheckBox("Ensalada");
						chckbxEnsalada.setBounds(342, 27, 67, 21);
						panelEntrantes.add(chckbxEnsalada);
					}
					{
						spinnerEnsalada = new JSpinner();
						spinnerEnsalada.setBounds(415, 28, 30, 20);
						panelEntrantes.add(spinnerEnsalada);
					}
					{
						chckbxMontado = new JCheckBox("Montado");
						chckbxMontado.setBounds(498, 27, 67, 21);
						panelEntrantes.add(chckbxMontado);
					}
					{
						spinnerMontado = new JSpinner();
						spinnerMontado.setBounds(571, 28, 30, 20);
						panelEntrantes.add(spinnerMontado);
					}
					{
						chckbxCalamares = new JCheckBox("Calamares");
						chckbxCalamares.setBounds(657, 27, 75, 21);
						panelEntrantes.add(chckbxCalamares);
					}
					{
						spinnerCalamares = new JSpinner();
						spinnerCalamares.setBounds(738, 28, 30, 20);
						panelEntrantes.add(spinnerCalamares);
					}
				}
				{
					panelPrimerPlato = new JPanel();
					panelPrimerPlato.setBorder(new TitledBorder(null, "Primer Plato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panelPrimerPlato.setLayout(null);
					GridBagConstraints gbc_panelPrimerPlato = new GridBagConstraints();
					gbc_panelPrimerPlato.gridwidth = 4;
					gbc_panelPrimerPlato.insets = new Insets(0, 0, 5, 5);
					gbc_panelPrimerPlato.fill = GridBagConstraints.BOTH;
					gbc_panelPrimerPlato.gridx = 1;
					gbc_panelPrimerPlato.gridy = 3;
					panelComanda.add(panelPrimerPlato, gbc_panelPrimerPlato);
					{
						chckbxPolloAsado = new JCheckBox("Pollo Asado");
						chckbxPolloAsado.setBounds(35, 23, 87, 21);
						panelPrimerPlato.add(chckbxPolloAsado);
					}
					{
						spinnerPolloAsado = new JSpinner();
						spinnerPolloAsado.setBounds(128, 24, 30, 20);
						panelPrimerPlato.add(spinnerPolloAsado);
					}
					{
						chckbxMacarrones = new JCheckBox("Macarrones");
						chckbxMacarrones.setBounds(185, 23, 79, 21);
						panelPrimerPlato.add(chckbxMacarrones);
					}
					{
						spinnerMacarrones = new JSpinner();
						spinnerMacarrones.setBounds(270, 24, 30, 20);
						panelPrimerPlato.add(spinnerMacarrones);
					}
					{
						chckbxEnsalada_1 = new JCheckBox("Ensalada");
						chckbxEnsalada_1.setBounds(345, 24, 67, 21);
						panelPrimerPlato.add(chckbxEnsalada_1);
					}
					{
						spinnerEnsalada_1 = new JSpinner();
						spinnerEnsalada_1.setBounds(417, 24, 30, 20);
						panelPrimerPlato.add(spinnerEnsalada_1);
					}
					{
						chckbxMontado_1 = new JCheckBox("Montado");
						chckbxMontado_1.setBounds(507, 24, 65, 21);
						panelPrimerPlato.add(chckbxMontado_1);
					}
					{
						spinnerMontado_1 = new JSpinner();
						spinnerMontado_1.setBounds(577, 24, 30, 20);
						panelPrimerPlato.add(spinnerMontado_1);
					}
					{
						spinnerCalamares_1 = new JSpinner();
						spinnerCalamares_1.setBounds(742, 25, 30, 20);
						panelPrimerPlato.add(spinnerCalamares_1);
					}
					{
						chckbxCalamares_1 = new JCheckBox("Calamares");
						chckbxCalamares_1.setBounds(661, 24, 75, 21);
						panelPrimerPlato.add(chckbxCalamares_1);
					}
				}
				{
					panelSegundoPlato = new JPanel();
					panelSegundoPlato.setBorder(new TitledBorder(null, "Segundo Plato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					GridBagConstraints gbc_panelSegundoPlato = new GridBagConstraints();
					gbc_panelSegundoPlato.gridwidth = 4;
					gbc_panelSegundoPlato.insets = new Insets(0, 0, 5, 5);
					gbc_panelSegundoPlato.fill = GridBagConstraints.BOTH;
					gbc_panelSegundoPlato.gridx = 1;
					gbc_panelSegundoPlato.gridy = 4;
					panelComanda.add(panelSegundoPlato, gbc_panelSegundoPlato);
				}
				{
					panelPostre = new JPanel();
					panelPostre.setBorder(new TitledBorder(null, "Postre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					GridBagConstraints gbc_panelPostre = new GridBagConstraints();
					gbc_panelPostre.gridwidth = 4;
					gbc_panelPostre.insets = new Insets(0, 0, 5, 5);
					gbc_panelPostre.fill = GridBagConstraints.BOTH;
					gbc_panelPostre.gridx = 1;
					gbc_panelPostre.gridy = 5;
					panelComanda.add(panelPostre, gbc_panelPostre);
				}
				{
					btnCerrarComanda = new JButton("Enviar Comanda");
					btnCerrarComanda.setFont(new Font("Tahoma", Font.BOLD, 17));
					GridBagConstraints gbc_btnCerrarComanda = new GridBagConstraints();
					gbc_btnCerrarComanda.gridwidth = 2;
					gbc_btnCerrarComanda.fill = GridBagConstraints.BOTH;
					gbc_btnCerrarComanda.insets = new Insets(0, 0, 5, 5);
					gbc_btnCerrarComanda.gridx = 1;
					gbc_btnCerrarComanda.gridy = 7;
					panelComanda.add(btnCerrarComanda, gbc_btnCerrarComanda);
				}
				{
					btnCancelarComanda = new JButton("Cancelar Comanda");
					btnCancelarComanda.setFont(new Font("Tahoma", Font.PLAIN, 17));
					GridBagConstraints gbc_btnCancelarComanda = new GridBagConstraints();
					gbc_btnCancelarComanda.fill = GridBagConstraints.BOTH;
					gbc_btnCancelarComanda.gridwidth = 2;
					gbc_btnCancelarComanda.insets = new Insets(0, 0, 5, 5);
					gbc_btnCancelarComanda.gridx = 3;
					gbc_btnCancelarComanda.gridy = 7;
					panelComanda.add(btnCancelarComanda, gbc_btnCancelarComanda);
				}
			}
		}
	}
}
