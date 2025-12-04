package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;


public class Not1 {

	private JFrame frame;
	private JPanel panel_selectFuentes;

	private JLabel lbl_preferencias;
	private JLabel lbl_FuentesDeportes;
	private JButton btn_save;

	public String rdbt_num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Not1 window = new Not1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Not1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel_selectFuentes = new JPanel();
		panel_selectFuentes.setBackground(new Color(255, 204, 255));
		panel_selectFuentes.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(panel_selectFuentes);
		panel_selectFuentes.setLayout(null);

		lbl_preferencias = new JLabel(
				"Seleccione sus preferencias. 1 fuente por categoria .pulse guardar para continuar");
		lbl_preferencias.setBounds(27, 26, 700, 31);
		panel_selectFuentes.add(lbl_preferencias);

		lbl_FuentesDeportes = new JLabel("DEPORTES:");
		lbl_FuentesDeportes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_FuentesDeportes.setBounds(26, 68, 180, 23);
		panel_selectFuentes.add(lbl_FuentesDeportes);

		// Para que no te deje seleccionar mas de uno, como en htmlforms
		ButtonGroup g = new ButtonGroup();

		JRadioButton rdbtn_Marca = new JRadioButton("MARCA");
		rdbtn_Marca.setBounds(27, 113, 109, 23);
		panel_selectFuentes.add(rdbtn_Marca);

		JRadioButton rdbtn_As = new JRadioButton("AS");
		rdbtn_As.setBounds(215, 113, 109, 23);
		panel_selectFuentes.add(rdbtn_As);

		JRadioButton rdbtn_MundoDep = new JRadioButton("MUNDO DEP");
		rdbtn_MundoDep.setBounds(427, 113, 109, 23);
		panel_selectFuentes.add(rdbtn_MundoDep);

		g.add(rdbtn_Marca);
		g.add(rdbtn_As);
		g.add(rdbtn_MundoDep);

		btn_save = new JButton("GUARDAR Y NEXT");
		btn_save.setBounds(605, 464, 151, 53);
		btn_save.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (rdbtn_Marca.isSelected()) {
					String rdbt_num = "1";
					//ConfiguracionDAO.escribirFuentesTXT(rdbt_num);
				} else if (rdbtn_As.isSelected()) {
					String rdbt_num = "2";
					//ConfiguracionDAO.escribirFuentesTXT(rdbt_num);
				} else {
					String rdbt_num = "3";
					//ConfiguracionDAO.escribirFuentesTXT(rdbt_num);
				}
			}
		});
		panel_selectFuentes.add(btn_save);
	}
}
