package uiPaneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JPanel;

import dao.PreferenciasDAO;
import domain.Usuario;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PanelUsuarioPreferencias extends JPanel {

	private static final long serialVersionUID = 1L;

	private JEditorPane editorPane;
	private JButton button;
	private JLabel lbl_deportes;
	private JLabel lbl_economia;
	private JCheckBox chckbx_D1;
	private JCheckBox chckbx_D2;
	private JCheckBox chckbx_D3;
	private JCheckBox chckbx_E1;
	private JCheckBox chckbx_E2;
	private JCheckBox chckbx_E3;

	private JLabel lbl_nacional;
	private JCheckBox chckbx_N1;
	private JCheckBox chckbx_N2;
	private JCheckBox chckbx_N3;

	private JLabel lbl_internacional;
	private JCheckBox chckbx_I1;
	private JCheckBox chckbx_I2;
	private JCheckBox chckbx_I3;

	private JLabel lbl_musica;
	private JCheckBox chckbx_M1;
	private JCheckBox chckbx_M2;
	private JCheckBox chckbx_M3;

	private JLabel lbl_aleatorio;
	private JCheckBox chckbx_A1;
	private JCheckBox chckbx_A2;
	private JCheckBox chckbx_A3;

	private JButton btn_exit;

	public PanelUsuarioPreferencias(PanelUsuarioNoticias panelUsuarioNoticias) {
		int[] seleccionPreferencias = new int[18];

		setLayout(null);
		setBounds(0, 0, 1200, 800);

		editorPane = new JEditorPane();
		editorPane.setFont(new Font("Argelina", Font.BOLD, 20));
		editorPane.setContentType("text/html");
		editorPane.setText(
				"<center><h1>Bienvenido al panel de personalizacion <br> <h2>Seleccione sus preferencias (max 18 minimo 1)");
		editorPane.setEditable(false);
		editorPane.setBounds(221, 35, 760, 90);
		add(editorPane);

		lbl_deportes = new JLabel("DEPORTES");
		lbl_deportes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_deportes.setBounds(48, 173, 97, 14);
		add(lbl_deportes);

		chckbx_D1 = new JCheckBox("Marca");
		chckbx_D1.setBounds(48, 212, 97, 23);
		add(chckbx_D1);

		chckbx_D2 = new JCheckBox("As");
		chckbx_D2.setBounds(48, 249, 97, 23);
		add(chckbx_D2);

		chckbx_D3 = new JCheckBox("Mundo deportivo");
		chckbx_D3.setBounds(48, 288, 113, 23);
		add(chckbx_D3);

		lbl_economia = new JLabel("ECONOMIA");
		lbl_economia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_economia.setBounds(250, 173, 97, 14);
		add(lbl_economia);

		chckbx_E1 = new JCheckBox("Economista");
		chckbx_E1.setBounds(250, 212, 97, 23);
		add(chckbx_E1);

		chckbx_E2 = new JCheckBox("Expansion");
		chckbx_E2.setBounds(248, 249, 97, 23);
		add(chckbx_E2);

		chckbx_E3 = new JCheckBox("El digital");
		chckbx_E3.setBounds(250, 288, 97, 23);
		add(chckbx_E3);

		lbl_nacional = new JLabel("NACIONAL");
		lbl_nacional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_nacional.setBounds(448, 173, 97, 14);
		add(lbl_nacional);

		chckbx_N1 = new JCheckBox("Rtve");
		chckbx_N1.setBounds(448, 212, 97, 23);
		add(chckbx_N1);

		chckbx_N2 = new JCheckBox("The objetive");
		chckbx_N2.setBounds(448, 249, 97, 23);
		add(chckbx_N2);

		chckbx_N3 = new JCheckBox("El mundo");
		chckbx_N3.setBounds(448, 288, 97, 23);
		add(chckbx_N3);

		lbl_internacional = new JLabel("INTERNACIONAL");
		lbl_internacional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_internacional.setBounds(640, 173, 126, 14);
		add(lbl_internacional);

		chckbx_I1 = new JCheckBox("Europapress");
		chckbx_I1.setBounds(640, 212, 97, 23);
		add(chckbx_I1);

		chckbx_I2 = new JCheckBox("20 minutos");
		chckbx_I2.setBounds(638, 249, 97, 23);
		add(chckbx_I2);

		chckbx_I3 = new JCheckBox("La razon");
		chckbx_I3.setBounds(640, 288, 97, 23);
		add(chckbx_I3);

		lbl_musica = new JLabel("MUSICA");
		lbl_musica.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_musica.setBounds(868, 173, 97, 14);
		add(lbl_musica);

		chckbx_M1 = new JCheckBox("Rockfm");
		chckbx_M1.setBounds(868, 212, 97, 23);
		add(chckbx_M1);

		chckbx_M2 = new JCheckBox("Radiole");
		chckbx_M2.setBounds(868, 249, 97, 23);
		add(chckbx_M2);

		chckbx_M3 = new JCheckBox("El pais");
		chckbx_M3.setBounds(868, 288, 97, 23);
		add(chckbx_M3);

		lbl_aleatorio = new JLabel("ALEATORIO");
		lbl_aleatorio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_aleatorio.setBounds(1070, 173, 97, 14);
		add(lbl_aleatorio);

		chckbx_A1 = new JCheckBox("Cbr");
		chckbx_A1.setBounds(1070, 212, 97, 23);
		add(chckbx_A1);

		chckbx_A2 = new JCheckBox("Lecturalia");
		chckbx_A2.setBounds(1068, 249, 97, 23);
		add(chckbx_A2);

		chckbx_A3 = new JCheckBox("9 to 5");
		chckbx_A3.setBounds(1070, 288, 97, 23);
		add(chckbx_A3);

		button = new JButton("Guardar");
		button.setBounds(559, 526, 89, 23);
		add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbx_D1.isSelected()) {
					seleccionPreferencias[0] = 1;
				}
				if (chckbx_D2.isSelected()) {
					seleccionPreferencias[1] = 1;
				}
				if (chckbx_D3.isSelected()) {
					seleccionPreferencias[2] = 1;
				}
				if (chckbx_E1.isSelected()) {
					seleccionPreferencias[3] = 1;
				}
				if (chckbx_E2.isSelected()) {
					seleccionPreferencias[4] = 1;
				}
				if (chckbx_E3.isSelected()) {
					seleccionPreferencias[5] = 1;
				}
				if (chckbx_N1.isSelected()) {
					seleccionPreferencias[6] = 1;
				}
				if (chckbx_N2.isSelected()) {
					seleccionPreferencias[7] = 1;
				}
				if (chckbx_N3.isSelected()) {
					seleccionPreferencias[8] = 1;
				}
				if (chckbx_I1.isSelected()) {
					seleccionPreferencias[9] = 1;
				}
				if (chckbx_I2.isSelected()) {
					seleccionPreferencias[10] = 1;
				}
				if (chckbx_I3.isSelected()) {
					seleccionPreferencias[11] = 1;
				}
				if (chckbx_M1.isSelected()) {
					seleccionPreferencias[12] = 1;
				}
				if (chckbx_M2.isSelected()) {
					seleccionPreferencias[13] = 1;
				}
				if (chckbx_M3.isSelected()) {
					seleccionPreferencias[14] = 1;
				}
				if (chckbx_A1.isSelected()) {
					seleccionPreferencias[15] = 1;
				}
				if (chckbx_A2.isSelected()) {
					seleccionPreferencias[16] = 1;
				}
				if (chckbx_A3.isSelected()) {
					seleccionPreferencias[17] = 1;
				}

				//guardar preferencias
				Usuario u = new Usuario();
				u.setPreferencias(true);
				
				PreferenciasDAO.escribirPreferencias(seleccionPreferencias);
				panelUsuarioNoticias.setVisible(true);
				setVisible(false);
			}
		});

		btn_exit = new JButton("x");
		btn_exit.setBorder(null);
		btn_exit.setBackground(new Color(255, 21, 0));
		btn_exit.setBounds(1141, 6, 53, 26);

		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmacion = JOptionPane.showConfirmDialog(null, "Esta seguro?", "Cerrar aplicacion",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (confirmacion == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		add(btn_exit);

	}
}
