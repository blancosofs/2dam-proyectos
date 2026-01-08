package ui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.Timer;

import common.ControlErrores;

public class VentanaCarga extends JFrame {
	private static final long serialVersionUID = 1L;
	Timer barra;
	int contador = 0;

	public VentanaCarga(VentanaLogin miVentanaLogin) {
		if (!ControlErrores.hayInternet()) {
			String msg = "[error] No hay internet!\nPorfavor conectate a la red para cargar la aplicacion";
			JOptionPane.showMessageDialog(null, msg, "", 1);
			dispose();
			System.exit(0);
		} else {
			setSize(660, 330);
			setResizable(false);
			setLocationRelativeTo(null);
			getContentPane().setLayout(null);

			/* CONTROL IMAGENES */
			if (!ControlErrores.comprobarIcono() || !ControlErrores.comprobarFondo()) {
				String msg = "[error] Error en la carga de imagenes, sentimos las molestias!";
				JOptionPane.showMessageDialog(null, msg, "", 1);
				dispose();
				System.exit(0);
			} else {

				// fondo
				getContentPane().add(buscarImagen());
				// icono
				setIconImage(Toolkit.getDefaultToolkit().getImage("imagen/icono.png"));

				JProgressBar progressBar = new JProgressBar();
				progressBar.setBounds(45, 280, 560, 40);
				progressBar.setStringPainted(true);
				progressBar.setOpaque(true);
				getContentPane().add(progressBar);

				barra = new Timer(30, new ActionListener() { // Timer en millisegundos. Con 500 avanza en 5segundos
					@Override
					public void actionPerformed(ActionEvent e) {
						contador++;
						progressBar.setValue(contador);

						if (contador == 80) {
							/* CONTROL ARCHIVOS */
							if (!ControlErrores.comprobarTXTconfig() || !ControlErrores.comprobarTXThistorico()
									|| !ControlErrores.comprobarTXTusuarios()) {
								String msg = "[error] Error en la carga de archivos, sentimos las molestias!";
								JOptionPane.showMessageDialog(null, msg, "", 1);
								dispose();
								return;
							} else {
								barra.stop();
								miVentanaLogin.setVisible(true);
								dispose();
							}
						}
						/*
						 * if (contador >= 100) { barra.stop(); miVentanaLogin.setVisible(true);
						 * dispose(); }
						 */
					}
				});

				barra.start();
			}
		}
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
