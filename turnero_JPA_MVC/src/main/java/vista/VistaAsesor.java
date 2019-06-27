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
import java.awt.Font;

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
		txtIdentificacion.setBounds(194, 71, 116, 22);
		contentPane.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		JLabel lblIdentificacin = new JLabel("Identificaci\u00F3n");
		lblIdentificacin.setBounds(36, 74, 116, 16);
		contentPane.add(lblIdentificacin);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(36, 115, 56, 16);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(194, 112, 116, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JCheckBox chbEstado = new JCheckBox("Estado");
		chbEstado.setBounds(32, 151, 113, 25);
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
		btnGuardar.setBounds(179, 202, 97, 25);
		contentPane.add(btnGuardar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminAsesor.listarAsesor();
			}
		});
		btnListar.setBounds(306, 202, 97, 25);
		contentPane.add(btnListar);
		
		JLabel lblAsesor = new JLabel("ASESOR");
		lblAsesor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAsesor.setBounds(163, 24, 97, 36);
		contentPane.add(lblAsesor);
	}
}
