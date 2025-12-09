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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.Timer;

public class VentanaCarga extends JFrame {
	Timer barra;
	int contador = 0;

	public VentanaCarga(VentanaLogin miVentanaLogin) {
		setSize(660, 330);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(buscarImagen());
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("icono.png")));
		

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(45, 280, 560, 40);
		progressBar.setStringPainted(true);
		progressBar.setOpaque(true);
		getContentPane().add(progressBar);

		barra = new Timer(500, new ActionListener() { // Timer el millisegundos. Con 500 avanza en 5segundos
			@Override
			public void actionPerformed(ActionEvent e) {
				contador += 20;
				progressBar.setValue(contador);

				if (contador == 80) {
					// control errores para TXT (en boolean)
					// si distinto de booleano llamas a ventana errores
					// JOptionPane.showMessageDialog(null, null,"ERROR",1);
				}

				if (contador >= 100) {
					barra.stop();
					miVentanaLogin.setVisible(true);
					dispose();
				}
			}
		});
		
		barra.start();

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
		panelConFondo.setBounds(0, 0, 660, 330);

		return panelConFondo;
	}
}
