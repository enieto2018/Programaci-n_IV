package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.AdministrarAsesor;
import controlador.AdministrarServicios;
import modelo.Servicios;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class AgregarServAsesor extends JFrame {

	private String identificacion;
	private JPanel contentPane;
	private JTextField txtIdentificacion;
	private AdministrarServicios adminServicios = new AdministrarServicios();
	private AdministrarAsesor adminAsesor =new AdministrarAsesor();
	private List<Servicios> listServAsesor = new ArrayList<Servicios>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarServAsesor frame = new AgregarServAsesor();
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
	public AgregarServAsesor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarServicioAsesor = new JLabel("AGREGAR SERVICIO ASESOR");
		lblAgregarServicioAsesor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAgregarServicioAsesor.setBounds(89, 35, 277, 14);
		contentPane.add(lblAgregarServicioAsesor);
		
		JLabel lblIdentAsesor = new JLabel("Ident. Asesor");
		lblIdentAsesor.setBounds(41, 89, 100, 14);
		contentPane.add(lblIdentAsesor);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(166, 86, 114, 20);
		contentPane.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		
		
		
		JButton btnListr = new JButton("Listar");
		btnListr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnListr.setBounds(208, 211, 89, 23);
		contentPane.add(btnListr);
		
		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setBounds(41, 114, 46, 14);
		contentPane.add(lblServicios);
		
		JList list = new JList();
		list.setBounds(349, 164, -80, -24);
		contentPane.add(list);
		List<Servicios> listaServicios = adminServicios.obtenerListaServicios();
		
		String[] values = new String[listaServicios.size()];
		for(int i=0; i<values.length; i++){
			values[i] = listaServicios.get(i).getNombre();
		}
		JList list_Servicios = new JList();
		list_Servicios.setModel(new AbstractListModel() {
		//	String[] values = new String[] {"1", "2", "3"};
			public int getSize() {
				return listaServicios.size();
			}
			public Object getElementAt(int index) {
				return listaServicios.get(index).getNombre();
			}
		});
		
		list_Servicios.setBounds(166, 113, 114, 52);
		contentPane.add(list_Servicios);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(91, 211, 89, 23);
		contentPane.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				identificacion=txtIdentificacion.getText();
				
				for(int i=0; i<list_Servicios.getSelectedValuesList().size(); i++) {
					listServAsesor.add(adminServicios.obtenerServicioXNombre(list_Servicios.getSelectedValuesList().get(i).toString())) ;
				}
			}				
		});
		
		adminAsesor.agregarServicioAsesor(identificacion, listServAsesor);
	}
	
}
