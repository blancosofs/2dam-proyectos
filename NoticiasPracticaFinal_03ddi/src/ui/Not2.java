package ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import service.GestorNoticias;
import javax.swing.SwingConstants;

import dao.PersonalizacionDAO;

public class Not2 {

	private JFrame frame;
	private JLayeredPane layeredPane;

	private JPanel panel_deportes;

	private JLabel lbl_select;

	private JButton btn_nextEconomia;
	private JButton btn_nextDeportes;

	private JPanel panel_categorias;
	private JPanel panel_economia;
	private JLabel lbl_notDeportes;
	private JLabel lbl_notEconomia;

	private JLabel lbl_Titular;
	private JLabel lbl_Economista;
	private JLabel lbl_Confidencial;

	public String rdbt_num;
	private JPanel panel_selectFuentes;
	private JLabel lbl_preferencias;
	private JLabel lbl_FuentesDeportes;
	private JRadioButton rdbtn_Marca;
	private JRadioButton rdbtn_As;
	private JRadioButton rdbtn_MundoDep;
	private JButton btn_save;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Not2 window = new Not2();
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
	public Not2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Para que no te deje seleccionar mas de uno, como en htmlforms
		ButtonGroup g = new ButtonGroup();

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(layeredPane);

		panel_selectFuentes = new JPanel();
		panel_selectFuentes.setLayout(null);
		panel_selectFuentes.setBackground(new Color(255, 204, 255));
		panel_selectFuentes.setBounds(0, 0, 784, 561);
		layeredPane.add(panel_selectFuentes);

		lbl_preferencias = new JLabel(
				"Seleccione sus preferencias. 1 fuente por categoria .pulse guardar para continuar");
		lbl_preferencias.setBounds(27, 26, 700, 31);
		panel_selectFuentes.add(lbl_preferencias);

		lbl_FuentesDeportes = new JLabel("DEPORTES:");
		lbl_FuentesDeportes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_FuentesDeportes.setBounds(26, 68, 180, 23);
		panel_selectFuentes.add(lbl_FuentesDeportes);

		rdbtn_Marca = new JRadioButton("MARCA");
		rdbtn_Marca.setBounds(27, 113, 109, 23);
		panel_selectFuentes.add(rdbtn_Marca);

		rdbtn_As = new JRadioButton("AS");
		rdbtn_As.setBounds(215, 113, 109, 23);
		panel_selectFuentes.add(rdbtn_As);

		rdbtn_MundoDep = new JRadioButton("MUNDO DEP");
		rdbtn_MundoDep.setBounds(427, 113, 109, 23);
		panel_selectFuentes.add(rdbtn_MundoDep);

		g.add(rdbtn_Marca);
		g.add(rdbtn_As);
		g.add(rdbtn_MundoDep);

		btn_save = new JButton("GUARDAR Y NEXT");
		btn_save.setBounds(605, 464, 151, 53);
		panel_selectFuentes.add(btn_save);
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtn_Marca.isSelected()) {
					String rdbt_num = "1";
					PersonalizacionDAO.escribirFuentesTXT(rdbt_num);
				} else if (rdbtn_As.isSelected()) {
					String rdbt_num = "2";
					PersonalizacionDAO.escribirFuentesTXT(rdbt_num);
				} else {
					String rdbt_num = "3";
					PersonalizacionDAO.escribirFuentesTXT(rdbt_num);
				}
				panel_selectFuentes.setVisible(false);
				panel_categorias.setVisible(true);
			}
		});

		panel_categorias = new JPanel();
		panel_categorias.setBackground(new Color(0, 153, 255));
		panel_categorias.setBounds(0, 0, 800, 600);
		layeredPane.add(panel_categorias);
		panel_categorias.setLayout(null);
		panel_categorias.setVisible(false);

		lbl_select = new JLabel("Seleccione una categoría....");
		lbl_select.setBounds(35, 60, 151, 14);
		panel_categorias.add(lbl_select);

		btn_nextEconomia = new JButton("Economia");
		btn_nextEconomia.setBounds(36, 221, 117, 23);
		btn_nextEconomia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_categorias.setVisible(false);
				panel_deportes.setVisible(false);
				panel_economia.setVisible(true);
			}
		});

		btn_nextDeportes = new JButton("Deportes");
		btn_nextDeportes.setBounds(35, 111, 117, 23);
		btn_nextDeportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_categorias.setVisible(false);
				panel_economia.setVisible(false);
				panel_deportes.setVisible(true);
			}
		});

		panel_categorias.add(btn_nextDeportes);
		panel_categorias.add(btn_nextEconomia);

		panel_deportes = new JPanel();
		panel_deportes.setBackground(new Color(153, 153, 255));
		panel_deportes.setBounds(0, 0, 790, 600);
		layeredPane.add(panel_deportes);
		panel_deportes.setLayout(null);
		panel_deportes.setVisible(false);

		lbl_notDeportes = new JLabel("Noticias Deportes....");
		lbl_notDeportes.setBounds(25, 27, 224, 37);
		panel_deportes.add(lbl_notDeportes);

		lbl_Titular = new JLabel(GestorNoticias.exNot_Titular());
		lbl_Titular.setVerticalAlignment(SwingConstants.TOP);
		lbl_Titular.setBounds(25, 75, 594, 97);
		panel_deportes.add(lbl_Titular);

		panel_economia = new JPanel();
		panel_economia.setLayout(null);
		panel_economia.setBackground(new Color(153, 153, 255));
		panel_economia.setBounds(0, 0, 800, 600);
		layeredPane.add(panel_economia);
		panel_economia.setVisible(false);

		lbl_notEconomia = new JLabel("Noticias Economia....");
		lbl_notEconomia.setBounds(27, 27, 181, 33);
		panel_economia.add(lbl_notEconomia);

		lbl_Economista = new JLabel(GestorNoticias.exNot_eEconomista());
		lbl_Economista.setVerticalAlignment(SwingConstants.TOP);
		lbl_Economista.setBounds(27, 71, 594, 97);
		panel_economia.add(lbl_Economista);

		lbl_Confidencial = new JLabel(GestorNoticias.exNot_eDigital());
		lbl_Confidencial.setVerticalAlignment(SwingConstants.TOP);
		lbl_Confidencial.setBounds(27, 187, 612, 51);
		panel_economia.add(lbl_Confidencial);

	}
}
