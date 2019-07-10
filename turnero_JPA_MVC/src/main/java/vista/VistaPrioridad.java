package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.AdministrarPrioridad;
import modelo.Prioridad;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;

public class VistaPrioridad extends JFrame {

	private JPanel contentPane;
	private JTextField textNombrePrio;
	private String nombrePrioridad;
	private AdministrarPrioridad adminPrioridad=new AdministrarPrioridad();
	private JTable table_1;
	List<Prioridad> listadoPrioridades;

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
		setBounds(100, 100, 511, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombrePrio = new JLabel("Nombre");
		lblNombrePrio.setBounds(40, 67, 46, 14);
		contentPane.add(lblNombrePrio);
		
		textNombrePrio = new JTextField();
		textNombrePrio.setBounds(98, 64, 86, 20);
		contentPane.add(textNombrePrio);
		textNombrePrio.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombrePrioridad=textNombrePrio.getText();
				adminPrioridad.AgregarPrioridad(nombrePrioridad);
				//adminPrioridad.listarPrioridades();
			}
		});
		btnAgregar.setBounds(98, 107, 89, 23);
		contentPane.add(btnAgregar);
		
		
		JButton btnConsultar = new JButton("Consultar");
		
		btnConsultar.setBounds(222, 107, 89, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblPrioridad = new JLabel("PRIORIDAD");
		lblPrioridad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrioridad.setBounds(178, 11, 106, 34);
		contentPane.add(lblPrioridad);
		
		
		table_1 = new JTable();
		table_1.setCellSelectionEnabled(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setBounds(55, 183, 378, 191);
		
		
//		table_1.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"dasdsa", "fdsfdsf"},
//				{null, null},
//				{null, null},
//				{null, null},
//			},
//			new String[] {
//				"Editar", "Eliminar"
//			}
//		));
		//table_1.getColumnModel().getColumn(1).setMinWidth(20);
		contentPane.add(table_1);
		
		
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listadoPrioridades = adminPrioridad.listarPrioridades();
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Nombre");
				model.addColumn("Editar");
				model.addColumn("Eliminar");
				
				//table_1.setModel(model);
				
				
				Object[][] listaFilas = new Object[listadoPrioridades.size()][3];
				
				for(int i = 0; i < listadoPrioridades.size(); i++) {
					JButton btnEdit = new JButton("Editar");
					btnEdit.setBounds(222, 149, 89, 23);
					
					JButton btnDelete = new JButton("Editar");
					btnDelete.setBounds(222, 149, 89, 23);
					
					listaFilas[i][0] = listadoPrioridades.get(i).getNombre();
					listaFilas[i][1] = btnEdit;
					listaFilas[i][2] = btnDelete;
				}
				
				table_1.setModel(new DefaultTableModel(
						listaFilas,
				new String[] {
					"Nombre", "Editar", "Eliminar"
				}
			));
				
				
			}
		});
	}
}
