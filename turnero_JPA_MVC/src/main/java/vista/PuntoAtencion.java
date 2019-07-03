package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.AdministrarAsesor;
import controlador.AdministrarPuntoAtencion;
import modelo.Asesor;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class PuntoAtencion extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private String nombre;
	private boolean disponible;
	private AdministrarPuntoAtencion adminPunto= new AdministrarPuntoAtencion();
	private AdministrarAsesor adminAsesor =new AdministrarAsesor();
	private String nombreAsesor;

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
		
		List<Asesor> listaAsesores  =adminAsesor.obtenerListaAsesores();
		
		String [] listNombAsesor= new String[listaAsesores.size()];
		
		for(int i=0; i<listNombAsesor.length; i++) {
			listNombAsesor[i]=listaAsesores.get(i).getIdentificacion()+" - "+listaAsesores.get(i).getNombre();
		}
		
		JComboBox comboBoxAsesor = new JComboBox();
		comboBoxAsesor.setModel(new DefaultComboBoxModel(listNombAsesor));
		comboBoxAsesor.setBounds(170, 122, 79, 20);
		contentPane.add(comboBoxAsesor);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre=textNombre.getText();
				disponible=chckbxDisponible.isSelected();
				int index=comboBoxAsesor.getSelectedIndex();

				Asesor asesor = listaAsesores.get(index);
				
				adminPunto.AgregarPuntoAtencion(asesor, disponible, nombre);
				
				
			}
		});
		btnAgregar.setBounds(110, 203, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(230, 203, 89, 23);
		contentPane.add(btnListar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(71, 87, 46, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(170, 84, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
	}
}
