package uiPaneles;

import javax.swing.JLayeredPane;

public class PanelAdmin extends JLayeredPane {
	
	private static final long serialVersionUID = 1L;

	public PanelAdmin() {
		setLayout(null);
		PanelAlta panelAlta = new PanelAlta();
		add(panelAlta);
		panelAlta.setLayout(null);

		PanelBaja panelBaja = new PanelBaja();
		add(panelBaja);
		panelBaja.setLayout(null);

		PanelTest panelTest = new PanelTest();
		add(panelTest);
		panelTest.setVisible(false);

		PanelHora panelHora = new PanelHora();
		add(panelHora);
		panelHora.setLayout(null);

		PanelConfig panelConfig = new PanelConfig(panelTest);
		add(panelConfig);

	}
}
