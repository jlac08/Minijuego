package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 391);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/juego/LogoBueno.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Creado por Jose Luis");
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		JButton btnNewButton = new JButton("Jugar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MiJuego frame = new MiJuego();
							frame.setVisible(true);
							dispose();
							Clip sonido = AudioSystem.getClip();
							sonido.open(AudioSystem.getAudioInputStream(new File("src/juego/ringtones-tema-zelda.wav")));
							sonido.start();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				
				
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Principal.class.getResource("/juego/ZeldaLogo.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(196)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(229)
									.addComponent(lblNewLabel_2))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(77)
									.addComponent(lblNewLabel_1))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(42)
									.addComponent(lblNewLabel_3)))
							.addGap(35)))
					.addContainerGap(178, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addComponent(lblNewLabel_1)
							.addGap(61)
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel)))
					.addGap(55)
					.addComponent(btnNewButton)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
