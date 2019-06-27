package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.AdministrarPrioridad;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VistaPrioridad extends JFrame {

	private JPanel contentPane;
	private JTextField textNombrePrio;
	private String nombrePrioridad;
	private AdministrarPrioridad adminPrioridad=new AdministrarPrioridad();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrioridad frame = new VistaPrioridad();
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
	public VistaPrioridad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombrePrio = new JLabel("Nombre");
		lblNombrePrio.setBounds(39, 93, 46, 14);
		contentPane.add(lblNombrePrio);
		
		textNombrePrio = new JTextField();
		textNombrePrio.setBounds(95, 90, 86, 20);
		contentPane.add(textNombrePrio);
		textNombrePrio.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombrePrioridad=textNombrePrio.getText();
				adminPrioridad.AgregarPrioridad(nombrePrioridad);
				adminPrioridad.listarPrioridades();
			}
		});
		btnAgregar.setBounds(95, 149, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminPrioridad.listarPrioridades();
			}
		});
		btnConsultar.setBounds(222, 149, 89, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblPrioridad = new JLabel("PRIORIDAD");
		lblPrioridad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrioridad.setBounds(157, 31, 106, 34);
		contentPane.add(lblPrioridad);
	}
}
