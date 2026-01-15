package uiPaneles;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class PanelAdmin extends JPanel {

	/* CONTENEDOR DE TARJETAS */
	private static JPanel tarjetas2;

	public static void mostrar2(String nombre) {
		CardLayout cl = (CardLayout) tarjetas2.getLayout();
		cl.show(tarjetas2, nombre);
	}

	private static final long serialVersionUID = 1L;

	public PanelAdmin() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		// el panel contenedor va a ser CardLayout
		tarjetas2 = new JPanel(new CardLayout());
		tarjetas2.setBounds(0, 0, 1200, 800); //IMPORTANTE QUE SI NO TE REVIENTA (le quitas el del individual pero todo tiene que medir igual o no abre)
		add(tarjetas2); // este va al panel, no al frame por eso add

		PanelAlta panelAlta = new PanelAlta();
		//add(panelAlta);
		//panelAlta.setVisible(false);
		tarjetas2.add(panelAlta, "alta");

		PanelBaja panelBaja = new PanelBaja();
		//add(panelBaja);
		//panelBaja.setVisible(false);
		tarjetas2.add(panelBaja, "baja");

		PanelTest panelTest = new PanelTest();
		//add(panelTest);
		//panelTest.setVisible(false);
		tarjetas2.add(panelTest, "test");

		PanelHora panelHora = new PanelHora();
		//add(panelHora);
		//panelHora.setVisible(false);
		tarjetas2.add(panelHora, "hora");

		PanelConfig panelConfig = new PanelConfig();
		//add(panelConfig);
		tarjetas2.add(panelConfig, "config");
		mostrar2("config");

	}
}
