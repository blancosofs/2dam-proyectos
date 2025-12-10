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
		rdbtn_marca.setBounds(53, 246, 109, 23);
		add(rdbtn_marca);

		rdbtn_as = new JRadioButton("As");
		rdbtn_as.setEnabled(false);
		rdbtn_as.setBounds(53, 285, 109, 23);
		add(rdbtn_as);

		rdbtn_mundo = new JRadioButton("Mundo");
		rdbtn_mundo.setEnabled(false);
		rdbtn_mundo.setBounds(53, 323, 109, 23);
		add(rdbtn_mundo);

		ButtonGroup d = new ButtonGroup();
		d.add(rdbtn_marca);
		d.add(rdbtn_as);
		d.add(rdbtn_mundo);
		
		rdbtn_economista = new JRadioButton("Economista");
		rdbtn_economista.setEnabled(false);
		rdbtn_economista.setBounds(311, 246, 109, 23);
		add(rdbtn_economista);

		rdbtn_confidencial = new JRadioButton("Confidencial");
		rdbtn_confidencial.setEnabled(false);
		rdbtn_confidencial.setBounds(311, 285, 109, 23);
		add(rdbtn_confidencial);

		rdbtn_digital = new JRadioButton("Digital");
		rdbtn_digital.setEnabled(false);
		rdbtn_digital.setBounds(311, 323, 109, 23);
		add(rdbtn_digital);

		ButtonGroup e = new ButtonGroup();
		e.add(rdbtn_economista);
		e.add(rdbtn_confidencial);
		e.add(rdbtn_mundo);

		
		chckbx_deportes = new JCheckBox("DEPORTES");
		chckbx_deportes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbx_deportes.setBounds(53, 184, 146, 45);
		add(chckbx_deportes);
		boolean activarDep = chckbx_deportes.isSelected();
		if (activarDep) {
			rdbtn_as.setEnabled(true);
			rdbtn_mundo.setEnabled(true);
			rdbtn_marca.setEnabled(true);
			
		}
		chckbx_economia = new JCheckBox("ECONOMIA");
		chckbx_economia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbx_economia.setBounds(311, 184, 132, 45);
		add(chckbx_economia);
		if (chckbx_economia.isSelected()) {
			rdbtn_economista.setEnabled(true);
			rdbtn_confidencial.setEnabled(true);
			rdbtn_digital.setEnabled(true);
			
		}
		
		button = new JButton("Guardar");
		button.setBounds(1000, 675, 89, 23);
		add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

	}
}
