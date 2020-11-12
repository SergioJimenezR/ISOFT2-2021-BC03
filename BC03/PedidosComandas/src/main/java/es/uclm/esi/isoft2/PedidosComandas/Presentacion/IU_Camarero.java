package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Font;

public class IU_Camarero extends JFrame {

	private JPanel contentPane;
	private JPanel panelAvisos;
	private JComboBox comboBoxAvisos;
	private JPanel panelDatosAvisos;
	private JTextPane textPaneMesa;
	private JTextPane textPaneNumMesa;
	private JTextPane textPaneAviso;
	private JTextPane textPaneDescripcionAviso;
	private JButton btnAvisoFinalizado;
	private JTextPane txtpnNumeroAvisos;
	private JPanel panelNuevaComanda;
	private JComboBox comboBox;
	private JButton btnIniciarComanda;
	private JTextPane txtpnNmeroMesa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Camarero frame = new IU_Camarero();
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
	public IU_Camarero() {
		setTitle("IU_Camarero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 281, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 219, 11, 66, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		{
			panelAvisos = new JPanel();
			panelAvisos.setBorder(new LineBorder(new Color(0, 0, 0)));
			GridBagConstraints gbc_panelAvisos = new GridBagConstraints();
			gbc_panelAvisos.insets = new Insets(0, 0, 5, 5);
			gbc_panelAvisos.fill = GridBagConstraints.BOTH;
			gbc_panelAvisos.gridx = 1;
			gbc_panelAvisos.gridy = 1;
			contentPane.add(panelAvisos, gbc_panelAvisos);
			GridBagLayout gbl_panelAvisos = new GridBagLayout();
			gbl_panelAvisos.columnWidths = new int[]{0, 0, 0, 49, 0, 0};
			gbl_panelAvisos.rowHeights = new int[]{0, 37, 117, 0};
			gbl_panelAvisos.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panelAvisos.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			panelAvisos.setLayout(gbl_panelAvisos);
			{
				comboBoxAvisos = new JComboBox();
				GridBagConstraints gbc_comboBoxAvisos = new GridBagConstraints();
				gbc_comboBoxAvisos.insets = new Insets(0, 0, 5, 5);
				gbc_comboBoxAvisos.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxAvisos.gridx = 1;
				gbc_comboBoxAvisos.gridy = 1;
				panelAvisos.add(comboBoxAvisos, gbc_comboBoxAvisos);
			}
			{
				txtpnNumeroAvisos = new JTextPane();
				txtpnNumeroAvisos.setOpaque(false);
				txtpnNumeroAvisos.setText("NumAvisos");
				GridBagConstraints gbc_txtpnNumeroAvisos = new GridBagConstraints();
				gbc_txtpnNumeroAvisos.anchor = GridBagConstraints.WEST;
				gbc_txtpnNumeroAvisos.insets = new Insets(0, 0, 5, 5);
				gbc_txtpnNumeroAvisos.gridx = 3;
				gbc_txtpnNumeroAvisos.gridy = 1;
				panelAvisos.add(txtpnNumeroAvisos, gbc_txtpnNumeroAvisos);
			}
			{
				panelDatosAvisos = new JPanel();
				panelDatosAvisos.setName("Datos Aviso");
				panelDatosAvisos.setBorder(new LineBorder(new Color(0, 0, 0)));
				GridBagConstraints gbc_panelDatosAvisos = new GridBagConstraints();
				gbc_panelDatosAvisos.gridwidth = 3;
				gbc_panelDatosAvisos.insets = new Insets(0, 0, 0, 5);
				gbc_panelDatosAvisos.fill = GridBagConstraints.HORIZONTAL;
				gbc_panelDatosAvisos.gridx = 1;
				gbc_panelDatosAvisos.gridy = 2;
				panelAvisos.add(panelDatosAvisos, gbc_panelDatosAvisos);
				GridBagLayout gbl_panelDatosAvisos = new GridBagLayout();
				gbl_panelDatosAvisos.columnWidths = new int[]{81, 43, 82, 149, 0, 0};
				gbl_panelDatosAvisos.rowHeights = new int[]{38, 32, 0};
				gbl_panelDatosAvisos.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
				gbl_panelDatosAvisos.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
				panelDatosAvisos.setLayout(gbl_panelDatosAvisos);
				{
					textPaneMesa = new JTextPane();
					textPaneMesa.setFont(new Font("Tahoma", Font.PLAIN, 13));
					textPaneMesa.setOpaque(false);
					textPaneMesa.setText("Mesa");
					GridBagConstraints gbc_textPaneMesa = new GridBagConstraints();
					gbc_textPaneMesa.anchor = GridBagConstraints.EAST;
					gbc_textPaneMesa.insets = new Insets(0, 0, 5, 5);
					gbc_textPaneMesa.gridx = 0;
					gbc_textPaneMesa.gridy = 0;
					panelDatosAvisos.add(textPaneMesa, gbc_textPaneMesa);
				}
				{
					textPaneNumMesa = new JTextPane();
					textPaneNumMesa.setText("N");
					textPaneNumMesa.setOpaque(false);
					GridBagConstraints gbc_textPaneNumMesa = new GridBagConstraints();
					gbc_textPaneNumMesa.insets = new Insets(0, 0, 5, 5);
					gbc_textPaneNumMesa.fill = GridBagConstraints.HORIZONTAL;
					gbc_textPaneNumMesa.gridx = 1;
					gbc_textPaneNumMesa.gridy = 0;
					panelDatosAvisos.add(textPaneNumMesa, gbc_textPaneNumMesa);
				}
				{
					textPaneAviso = new JTextPane();
					textPaneAviso.setFont(new Font("Tahoma", Font.PLAIN, 13));
					textPaneAviso.setOpaque(false);
					textPaneAviso.setText("Aviso");
					GridBagConstraints gbc_textPaneAviso = new GridBagConstraints();
					gbc_textPaneAviso.anchor = GridBagConstraints.EAST;
					gbc_textPaneAviso.insets = new Insets(0, 0, 5, 5);
					gbc_textPaneAviso.gridx = 2;
					gbc_textPaneAviso.gridy = 0;
					panelDatosAvisos.add(textPaneAviso, gbc_textPaneAviso);
				}
				{
					textPaneDescripcionAviso = new JTextPane();
					textPaneDescripcionAviso.setText("toString() del aviso");
					textPaneDescripcionAviso.setOpaque(false);
					GridBagConstraints gbc_textPaneDescripcionAviso = new GridBagConstraints();
					gbc_textPaneDescripcionAviso.insets = new Insets(0, 0, 5, 5);
					gbc_textPaneDescripcionAviso.fill = GridBagConstraints.HORIZONTAL;
					gbc_textPaneDescripcionAviso.gridx = 3;
					gbc_textPaneDescripcionAviso.gridy = 0;
					panelDatosAvisos.add(textPaneDescripcionAviso, gbc_textPaneDescripcionAviso);
				}
				{
					btnAvisoFinalizado = new JButton("Finalizado");
					btnAvisoFinalizado.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						}
					});
					GridBagConstraints gbc_btnAvisoFinalizado = new GridBagConstraints();
					gbc_btnAvisoFinalizado.insets = new Insets(0, 0, 0, 5);
					gbc_btnAvisoFinalizado.gridx = 3;
					gbc_btnAvisoFinalizado.gridy = 1;
					panelDatosAvisos.add(btnAvisoFinalizado, gbc_btnAvisoFinalizado);
				}
			}
		}
		{
			panelNuevaComanda = new JPanel();
			panelNuevaComanda.setBorder(new LineBorder(new Color(0, 0, 0)));
			GridBagConstraints gbc_panelNuevaComanda = new GridBagConstraints();
			gbc_panelNuevaComanda.insets = new Insets(0, 0, 5, 5);
			gbc_panelNuevaComanda.fill = GridBagConstraints.VERTICAL;
			gbc_panelNuevaComanda.gridx = 1;
			gbc_panelNuevaComanda.gridy = 3;
			contentPane.add(panelNuevaComanda, gbc_panelNuevaComanda);
			GridBagLayout gbl_panelNuevaComanda = new GridBagLayout();
			gbl_panelNuevaComanda.columnWidths = new int[]{156, 246, 58, 159, 0};
			gbl_panelNuevaComanda.rowHeights = new int[]{82, 0};
			gbl_panelNuevaComanda.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panelNuevaComanda.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panelNuevaComanda.setLayout(gbl_panelNuevaComanda);
			{
				txtpnNmeroMesa = new JTextPane();
				txtpnNmeroMesa.setOpaque(false);
				txtpnNmeroMesa.setAlignmentX(Component.RIGHT_ALIGNMENT);
				txtpnNmeroMesa.setText("Mesa");
				GridBagConstraints gbc_txtpnNmeroMesa = new GridBagConstraints();
				gbc_txtpnNmeroMesa.anchor = GridBagConstraints.EAST;
				gbc_txtpnNmeroMesa.insets = new Insets(0, 0, 0, 5);
				gbc_txtpnNmeroMesa.gridx = 0;
				gbc_txtpnNmeroMesa.gridy = 0;
				panelNuevaComanda.add(txtpnNmeroMesa, gbc_txtpnNmeroMesa);
			}
			{
				comboBox = new JComboBox();
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.insets = new Insets(0, 0, 0, 5);
				gbc_comboBox.gridx = 1;
				gbc_comboBox.gridy = 0;
				panelNuevaComanda.add(comboBox, gbc_comboBox);
			}
			{
				btnIniciarComanda = new JButton("Iniciar comanda");
				GridBagConstraints gbc_btnIniciarComanda = new GridBagConstraints();
				gbc_btnIniciarComanda.gridx = 3;
				gbc_btnIniciarComanda.gridy = 0;
				panelNuevaComanda.add(btnIniciarComanda, gbc_btnIniciarComanda);
			}
		}
	}

}
