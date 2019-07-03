package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.AdministrarPuntoAtencion;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PuntoAtencion extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private String nombre;
	private AdministrarPuntoAtencion adminPunto= new AdministrarPuntoAtencion();

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
		lblAsesor.setBounds(71, 125, 46, 14);
		contentPane.add(lblAsesor);
		
		JLabel lblPuntoDeAtencin = new JLabel("PUNTO DE ATENCIÓN");
		lblPuntoDeAtencin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPuntoDeAtencin.setBounds(107, 36, 226, 14);
		contentPane.add(lblPuntoDeAtencin);
		
		JCheckBox chckbxDisponible = new JCheckBox("Disponible");
		chckbxDisponible.setBounds(71, 161, 97, 23);
		contentPane.add(chckbxDisponible);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre=textNombre.getText();
				adminPunto.AgregarPuntoAtencion(asesor, disponible, nombre);
				
			}
		});
		btnAgregar.setBounds(110, 203, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(230, 203, 89, 23);
		contentPane.add(btnListar);
		
		JComboBox comboBoxAsesor = new JComboBox();
		comboBoxAsesor.setBounds(170, 122, 79, 20);
		contentPane.add(comboBoxAsesor);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(71, 87, 46, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(170, 84, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
	}
}
