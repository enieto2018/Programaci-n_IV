package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.AdministrarAsesor;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaAsesor extends JFrame {
	private AdministrarAsesor adminAsesor = new AdministrarAsesor();
	private JPanel contentPane;
	private JTextField txtIdentificacion;
	private JTextField txtNombre;
	private String nombre;
	private String identificacion;
	private boolean estado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAsesor frame = new VistaAsesor();
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
	public VistaAsesor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(194, 36, 116, 22);
		contentPane.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		JLabel lblIdentificacin = new JLabel("Identificaci\u00F3n");
		lblIdentificacin.setBounds(32, 39, 116, 16);
		contentPane.add(lblIdentificacin);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 79, 56, 16);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(194, 71, 116, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JCheckBox chbEstado = new JCheckBox("Estado");
		chbEstado.setBounds(32, 119, 113, 25);
		contentPane.add(chbEstado);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				identificacion=txtIdentificacion.getText();
				nombre=txtNombre.getText();
				estado = chbEstado.isSelected();
				
				adminAsesor.agregarAsesor(nombre, identificacion, estado);
			}
			
		});
		btnGuardar.setBounds(176, 177, 97, 25);
		contentPane.add(btnGuardar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminAsesor.listarAsesor();
			}
		});
		btnListar.setBounds(304, 177, 97, 25);
		contentPane.add(btnListar);
	}
}
