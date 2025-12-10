package uiPaneles;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelAdmin extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelAdmin() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		PanelAlta panelAlta = new PanelAlta();
		add(panelAlta);
		panelAlta.setBounds(0, 0, 1200, 800);
		panelAlta.setLayout(null);
		panelAlta.setVisible(false);

		PanelBaja panelBaja = new PanelBaja();
		add(panelBaja);
		panelBaja.setBounds(0, 0, 1200, 800);
		panelBaja.setLayout(null);
		panelBaja.setVisible(false);

		PanelTest panelTest = new PanelTest();
		add(panelTest);
		panelTest.setBounds(0, 0, 1200, 800);
		panelTest.setVisible(false);

		PanelHora panelHora = new PanelHora();
		add(panelHora);
		panelHora.setBounds(0, 0, 1200, 800);
		panelHora.setLayout(null);
		panelHora.setVisible(false);

		PanelConfig panelConfig = new PanelConfig(panelTest, panelHora, panelAlta, panelBaja);
		panelConfig.setBounds(0, 0, 1200, 800);
		add(panelConfig);

	}
}
