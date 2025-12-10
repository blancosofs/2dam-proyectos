package uiPaneles;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class PanelUsuarioNuevo extends JPanel {

	private JEditorPane editorPane;
	private JCheckBox chckbx_deportes;
	private JCheckBox chckbx_economia;
	private JRadioButton rdbtn_marca;
	private JRadioButton rdbtn_as;
	private JRadioButton rdbtn_mundo;
	private JRadioButton rdbtn_economista;
	private JRadioButton rdbtn_confidencial;
	private JRadioButton rdbtn_digital;
	private JButton button;
	private JCheckBox chckbx_internacional;
	private JRadioButton rdbtn_marca_1;
	private JRadioButton rdbtn_as_1;
	private JRadioButton rdbtn_mundo_1;
	private JCheckBox chckbx_nacional;
	private JRadioButton rdbtn_marca_2;
	private JRadioButton rdbtn_as_2;
	private JRadioButton rdbtn_mundo_2;
	private JCheckBox chckbx_musica;
	private JRadioButton rdbtn_marca_3;
	private JRadioButton rdbtn_as_3;
	private JRadioButton rdbtn_mundo_3;
	private JCheckBox chckbx_deportes_4;
	private JRadioButton rdbtn_marca_4;
	private JRadioButton rdbtn_as_4;
	private JRadioButton rdbtn_mundo_4;

	public PanelUsuarioNuevo() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		editorPane = new JEditorPane();
		editorPane.setFont(new Font("Argelina", Font.BOLD, 20));
		editorPane.setContentType("text/html");
		editorPane.setText("<center><h1>Bienvenido al panel de personalizacion <br> <h2>Seleccione sus preferencias (Primero categoria, luego fuente)");
		editorPane.setEditable(false);
		editorPane.setBounds(221, 35, 760, 90);
		add(editorPane);

		rdbtn_marca = new JRadioButton("Marca");
		rdbtn_marca.setEnabled(false);
		rdbtn_marca.setBounds(125, 246, 109, 23);
		add(rdbtn_marca);

		rdbtn_as = new JRadioButton("As");
		rdbtn_as.setEnabled(false);
		rdbtn_as.setBounds(125, 285, 109, 23);
		add(rdbtn_as);

		rdbtn_mundo = new JRadioButton("Mundo");
		rdbtn_mundo.setEnabled(false);
		rdbtn_mundo.setBounds(125, 323, 109, 23);
		add(rdbtn_mundo);

		ButtonGroup d = new ButtonGroup();
		d.add(rdbtn_marca);
		d.add(rdbtn_as);
		d.add(rdbtn_mundo);
		
		rdbtn_economista = new JRadioButton("Economista");
		rdbtn_economista.setEnabled(false);
		rdbtn_economista.setBounds(361, 246, 109, 23);
		add(rdbtn_economista);

		rdbtn_confidencial = new JRadioButton("Confidencial");
		rdbtn_confidencial.setEnabled(false);
		rdbtn_confidencial.setBounds(361, 285, 109, 23);
		add(rdbtn_confidencial);

		rdbtn_digital = new JRadioButton("Digital");
		rdbtn_digital.setEnabled(false);
		rdbtn_digital.setBounds(361, 323, 109, 23);
		add(rdbtn_digital);

		ButtonGroup e = new ButtonGroup();
		e.add(rdbtn_economista);
		e.add(rdbtn_confidencial);
		e.add(rdbtn_mundo);
		
		chckbx_deportes = new JCheckBox("DEPORTES");
		chckbx_deportes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbx_deportes.setBounds(125, 184, 146, 45);
		add(chckbx_deportes);
		boolean activarDep = chckbx_deportes.isSelected();
		if (activarDep) {
			rdbtn_as.setEnabled(true);
			rdbtn_mundo.setEnabled(true);
			rdbtn_marca.setEnabled(true);
		}
		chckbx_economia = new JCheckBox("ECONOMIA");
		chckbx_economia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbx_economia.setBounds(361, 184, 132, 45);
		add(chckbx_economia);
		if (chckbx_economia.isSelected()) {
			rdbtn_economista.setEnabled(true);
			rdbtn_confidencial.setEnabled(true);
			rdbtn_digital.setEnabled(true);
			
		}
		
		button = new JButton("Guardar");
		button.setBounds(471, 631, 89, 23);
		add(button);
		
		chckbx_internacional = new JCheckBox("INTERNACIONAL");
		chckbx_internacional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbx_internacional.setBounds(866, 184, 185, 45);
		add(chckbx_internacional);
		
		rdbtn_marca_1 = new JRadioButton("Marca");
		rdbtn_marca_1.setEnabled(false);
		rdbtn_marca_1.setBounds(866, 246, 109, 23);
		add(rdbtn_marca_1);
		
		rdbtn_as_1 = new JRadioButton("As");
		rdbtn_as_1.setEnabled(false);
		rdbtn_as_1.setBounds(866, 285, 109, 23);
		add(rdbtn_as_1);
		
		rdbtn_mundo_1 = new JRadioButton("Mundo");
		rdbtn_mundo_1.setEnabled(false);
		rdbtn_mundo_1.setBounds(866, 323, 109, 23);
		add(rdbtn_mundo_1);
		
		ButtonGroup i = new ButtonGroup();
		i.add(rdbtn_economista);
		i.add(rdbtn_confidencial);
		i.add(rdbtn_mundo);
		
		chckbx_nacional = new JCheckBox("NACIONAL");
		chckbx_nacional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbx_nacional.setBounds(619, 184, 146, 45);
		add(chckbx_nacional);
		
		rdbtn_marca_2 = new JRadioButton("Marca");
		rdbtn_marca_2.setEnabled(false);
		rdbtn_marca_2.setBounds(619, 246, 109, 23);
		add(rdbtn_marca_2);
		
		rdbtn_as_2 = new JRadioButton("As");
		rdbtn_as_2.setEnabled(false);
		rdbtn_as_2.setBounds(619, 285, 109, 23);
		add(rdbtn_as_2);
		
		rdbtn_mundo_2 = new JRadioButton("Mundo");
		rdbtn_mundo_2.setEnabled(false);
		rdbtn_mundo_2.setBounds(619, 323, 109, 23);
		add(rdbtn_mundo_2);
		
		ButtonGroup n = new ButtonGroup();
		n.add(rdbtn_economista);
		n.add(rdbtn_confidencial);
		n.add(rdbtn_mundo);
		
		chckbx_musica = new JCheckBox("MUSICA");
		chckbx_musica.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbx_musica.setBounds(250, 421, 146, 45);
		add(chckbx_musica);
		
		rdbtn_marca_3 = new JRadioButton("Marca");
		rdbtn_marca_3.setEnabled(false);
		rdbtn_marca_3.setBounds(250, 483, 109, 23);
		add(rdbtn_marca_3);
		
		rdbtn_as_3 = new JRadioButton("As");
		rdbtn_as_3.setEnabled(false);
		rdbtn_as_3.setBounds(250, 522, 109, 23);
		add(rdbtn_as_3);
		
		rdbtn_mundo_3 = new JRadioButton("Mundo");
		rdbtn_mundo_3.setEnabled(false);
		rdbtn_mundo_3.setBounds(250, 560, 109, 23);
		add(rdbtn_mundo_3);
		
		ButtonGroup m = new ButtonGroup();
		m.add(rdbtn_economista);
		m.add(rdbtn_confidencial);
		m.add(rdbtn_mundo);
		
		chckbx_deportes_4 = new JCheckBox("DEPORTES");
		chckbx_deportes_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbx_deportes_4.setBounds(716, 421, 146, 45);
		add(chckbx_deportes_4);
		
		rdbtn_marca_4 = new JRadioButton("Marca");
		rdbtn_marca_4.setEnabled(false);
		rdbtn_marca_4.setBounds(716, 483, 109, 23);
		add(rdbtn_marca_4);
		
		rdbtn_as_4 = new JRadioButton("As");
		rdbtn_as_4.setEnabled(false);
		rdbtn_as_4.setBounds(716, 522, 109, 23);
		add(rdbtn_as_4);
		
		rdbtn_mundo_4 = new JRadioButton("Mundo");
		rdbtn_mundo_4.setEnabled(false);
		rdbtn_mundo_4.setBounds(716, 560, 109, 23);
		add(rdbtn_mundo_4);
		button.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

	}
}
