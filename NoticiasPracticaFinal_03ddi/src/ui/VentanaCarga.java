package ui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;

public class VentanaCarga extends JFrame {

	public VentanaCarga() {
		setSize(660, 330);
		setResizable(false);
		setLocationRelativeTo(null);
		add(buscarImagen());
		
		

	}

	private Component buscarImagen() {
		BufferedImage fondo = null;

		try {
			fondo = ImageIO.read(new File("src/ui/fondo.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		final Image foto = fondo;
		JPanel panelConFondo = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(foto, 0, 0, 660, 330, null);
			}
		};

		return panelConFondo;
	}

}
