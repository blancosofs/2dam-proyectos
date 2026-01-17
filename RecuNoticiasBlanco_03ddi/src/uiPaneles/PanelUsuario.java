package uiPaneles;

import java.awt.CardLayout;

import javax.swing.JPanel;


public class PanelUsuario extends JPanel {

	private static final long serialVersionUID = 1L;

	/* CONTENEDOR DE TARJETAS */
	private static JPanel tarjetas3;

	public static void mostrar3(String nombre) {
		CardLayout cl = (CardLayout) tarjetas3.getLayout();
		cl.show(tarjetas3, nombre);
	}

	public PanelUsuario() {
		setLayout(null);
		setBounds(0, 0,800, 600);

		// el panel contenedor va a ser CardLayout
		tarjetas3 = new JPanel(new CardLayout());
		tarjetas3.setBounds(0, 0, 1200, 800); 
		add(tarjetas3); // este va al panel, no al frame por eso add

		PanelUsuarioNoticias panelUsuarioNoticias = new PanelUsuarioNoticias();
		panelUsuarioNoticias.setBounds(0, 0, 1200, 800);
		tarjetas3.add(panelUsuarioNoticias, "noticias");
		
		
		PanelUsuarioPreferencias panelUsuarioNuevo = new PanelUsuarioPreferencias(panelUsuarioNoticias);
		panelUsuarioNuevo.setBounds(0, 0, 1200, 800);
		tarjetas3.add(panelUsuarioNuevo, "preferencias");
		
		/*COMPROBAR PREFERENCIAS
		
		//con esto te usas lo de antes sin subir todo a estatico :D, se te vaa null pointer :/
		Usuario usuarioComparar = null;
		List<Usuario> userLeer = UsuariosDAO.extraerUsuarioObjeto();
		
		for (Usuario u : userLeer) {
		    if (u.isLoggeado()) {
		    	usuarioComparar = u;
		    }
		}
		if (!usuarioComparar.isPreferencias()) { //false que tengas preferencias
			mostrar3("preferencias");
		} else {
			mostrar3("noticias");
		}
		*/
		
	}


}
