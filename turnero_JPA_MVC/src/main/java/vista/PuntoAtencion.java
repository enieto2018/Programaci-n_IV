package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class PuntoAtencion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuntoAtencion frame = new PuntoAtencion();
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
	public PuntoAtencion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAsesor = new JLabel("Asesor");
		lblAsesor.setBounds(71, 88, 46, 14);
		contentPane.add(lblAsesor);
		
		JLabel lblPuntoDeAtencin = new JLabel("PUNTO DE ATENCIÓN");
		lblPuntoDeAtencin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPuntoDeAtencin.setBounds(107, 36, 226, 14);
		contentPane.add(lblPuntoDeAtencin);
		
		JCheckBox chckbxDisponible = new JCheckBox("Disponible");
		chckbxDisponible.setBounds(71, 121, 97, 23);
		contentPane.add(chckbxDisponible);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(116, 188, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(241, 188, 89, 23);
		contentPane.add(btnListar);
	}
}
