package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class UI_Cocinero {

	private JFrame frmUicocinero;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnAvisarCamarero;
	private JComboBox cbMesasCocinero;
	private JLabel lblPlatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Cocinero window = new UI_Cocinero();
					window.frmUicocinero.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI_Cocinero() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUicocinero = new JFrame();
		frmUicocinero.setTitle("UI_Cocinero");
		frmUicocinero.setBounds(100, 100, 583, 363);
		frmUicocinero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			panel = new JPanel();
			frmUicocinero.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Mesas Listas Para Servir", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(21, 159, 538, 136);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					btnAvisarCamarero = new JButton("Avisar a Camarero");
					btnAvisarCamarero.setEnabled(false);
					btnAvisarCamarero.setFont(new Font("Tahoma", Font.BOLD, 17));
					btnAvisarCamarero.setBounds(156, 92, 233, 21);
					panel_1.add(btnAvisarCamarero);
				}
				{
					cbMesasCocinero = new JComboBox();
					cbMesasCocinero.setModel(new DefaultComboBoxModel(new String[] {"Mesa 1", "Mesa 3", "Mesa 4"}));
					cbMesasCocinero.setBounds(156, 36, 233, 21);
					panel_1.add(cbMesasCocinero);
				}
			}
			{
				lblPlatos = new JLabel("Platos");
				lblPlatos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
				lblPlatos.setBounds(21, 21, 91, 13);
				panel.add(lblPlatos);
			}
		}
	}
}
