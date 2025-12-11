package uiPaneles;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import service.NoticiasService;

import javax.swing.JLabel;

public class PanelUsuarioNoticias extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel lbl_msgDeporte;
	private JTextArea textArea_D1;
	private JTextArea textArea_D2;
	private JTextArea textArea_D3;
	private JLabel lbl_msgEconomia;
	private JTextArea textArea_E1;
	private JTextArea textArea_E2;
	private JTextArea textArea_E3;
	private JLabel lbl_msgNacional;
	private JTextArea textArea_N1;
	private JTextArea textArea_N2;
	private JTextArea textArea_N3;
	
	
	public PanelUsuarioNoticias() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		lbl_msgDeporte = new JLabel("DEPORTE");
		lbl_msgDeporte.setBounds(20, 16, 108, 16);
		add(lbl_msgDeporte);

		textArea_D1 = new JTextArea(NoticiasService.exNot_dMarca());
		textArea_D1.setEditable(false);
		textArea_D1.setBounds(20, 44, 537, 60);
		add(textArea_D1);
		textArea_D1.setLineWrap(true);
		textArea_D1.setWrapStyleWord(true);

		textArea_D2 = new JTextArea(NoticiasService.exNot_dAs());
		textArea_D2.setEditable(false);
		textArea_D2.setBounds(20, 116, 537, 60);
		add(textArea_D2);
		textArea_D2.setLineWrap(true);
		textArea_D2.setWrapStyleWord(true);

		textArea_D3 = new JTextArea(NoticiasService.exNot_dMundoDep());
		textArea_D3.setEditable(false);
		textArea_D3.setBounds(20, 197, 537, 60);
		add(textArea_D3);
		textArea_D3.setLineWrap(true);
		textArea_D3.setWrapStyleWord(true);

		lbl_msgEconomia = new JLabel("ECONOMIA");
		lbl_msgEconomia.setBounds(20, 269, 123, 16);
		add(lbl_msgEconomia);

		textArea_E1 = new JTextArea(NoticiasService.exNot_eEconomista());
		textArea_E1.setEditable(false);
		textArea_E1.setBounds(20, 297, 537, 60);
		add(textArea_E1);
		textArea_E1.setLineWrap(true);
		textArea_E1.setWrapStyleWord(true);

		textArea_E2 = new JTextArea(NoticiasService.exNot_eDigital());
		textArea_E2.setEditable(false);
		textArea_E2.setBounds(20, 367, 537, 60);
		add(textArea_E2);
		textArea_E2.setLineWrap(true);
		textArea_E2.setWrapStyleWord(true);

		textArea_E3 = new JTextArea(NoticiasService.exNot_eExpansion());
		textArea_E3.setEditable(false);
		textArea_E3.setBounds(20, 439, 537, 60);
		add(textArea_E3);
		textArea_E3.setLineWrap(true);
		textArea_E3.setWrapStyleWord(true);

		lbl_msgNacional = new JLabel("NACIONAL");
		lbl_msgNacional.setBounds(20, 522, 123, 16);
		add(lbl_msgNacional);

		textArea_N1 = new JTextArea();
		textArea_N1.setEditable(false);
		textArea_N1.setBounds(20, 550, 537, 60);
		add(textArea_N1);

		textArea_N2 = new JTextArea();
		textArea_N2.setEditable(false);
		textArea_N2.setBounds(20, 621, 537, 60);
		add(textArea_N2);

		textArea_N3 = new JTextArea();
		textArea_N3.setEditable(false);
		textArea_N3.setBounds(20, 692, 537, 60);
		add(textArea_N3);
		
		JLabel lbl_msgDeporte_1 = new JLabel("DEPORTE");
		lbl_msgDeporte_1.setBounds(614, 16, 108, 16);
		add(lbl_msgDeporte_1);
		
		JTextArea textArea_D1_1 = new JTextArea("");
		textArea_D1_1.setWrapStyleWord(true);
		textArea_D1_1.setLineWrap(true);
		textArea_D1_1.setEditable(false);
		textArea_D1_1.setBounds(614, 44, 537, 60);
		add(textArea_D1_1);
		
		JTextArea textArea_D2_1 = new JTextArea("");
		textArea_D2_1.setWrapStyleWord(true);
		textArea_D2_1.setLineWrap(true);
		textArea_D2_1.setEditable(false);
		textArea_D2_1.setBounds(614, 116, 537, 60);
		add(textArea_D2_1);
		
		JTextArea textArea_D3_1 = new JTextArea("");
		textArea_D3_1.setWrapStyleWord(true);
		textArea_D3_1.setLineWrap(true);
		textArea_D3_1.setEditable(false);
		textArea_D3_1.setBounds(614, 197, 537, 60);
		add(textArea_D3_1);
		
		JLabel lbl_msgEconomia_1 = new JLabel("ECONOMIA");
		lbl_msgEconomia_1.setBounds(614, 269, 123, 16);
		add(lbl_msgEconomia_1);
		
		JTextArea textArea_E1_1 = new JTextArea("");
		textArea_E1_1.setWrapStyleWord(true);
		textArea_E1_1.setLineWrap(true);
		textArea_E1_1.setEditable(false);
		textArea_E1_1.setBounds(614, 297, 537, 60);
		add(textArea_E1_1);
		
		JTextArea textArea_E2_1 = new JTextArea("");
		textArea_E2_1.setWrapStyleWord(true);
		textArea_E2_1.setLineWrap(true);
		textArea_E2_1.setEditable(false);
		textArea_E2_1.setBounds(614, 367, 537, 60);
		add(textArea_E2_1);
		
		JTextArea textArea_E3_1 = new JTextArea("");
		textArea_E3_1.setWrapStyleWord(true);
		textArea_E3_1.setLineWrap(true);
		textArea_E3_1.setEditable(false);
		textArea_E3_1.setBounds(614, 439, 537, 60);
		add(textArea_E3_1);
		
		JLabel lbl_msgNacional_1 = new JLabel("NACIONAL");
		lbl_msgNacional_1.setBounds(614, 522, 123, 16);
		add(lbl_msgNacional_1);
		
		JTextArea textArea_N1_1 = new JTextArea();
		textArea_N1_1.setEnabled(false);
		textArea_N1_1.setEditable(false);
		textArea_N1_1.setBounds(614, 550, 537, 60);
		add(textArea_N1_1);
		
		JTextArea textArea_N2_1 = new JTextArea();
		textArea_N2_1.setEditable(false);
		textArea_N2_1.setBounds(614, 621, 537, 60);
		add(textArea_N2_1);
		
		JTextArea textArea_N3_1 = new JTextArea();
		textArea_N3_1.setEditable(false);
		textArea_N3_1.setBounds(614, 692, 537, 60);
		add(textArea_N3_1);
		
		
		
	}
}
