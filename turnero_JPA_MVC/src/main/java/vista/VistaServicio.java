package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.AdministrarServicios;
import modelo.Servicios;

public class VistaServicio extends JFrame {
	private AdministrarServicios adminServicio= new AdministrarServicios();
	private String nombre;

	private JPanel contentPane;
	private JTextField txtNombre;
	
	private JTable table;
	private List<Servicios> listaServicios;
	private Integer idEditar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaServicio frame = new VistaServicio();
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
	public VistaServicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(56, 90, 46, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(121, 87, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombre=txtNombre.getText();
				adminServicio.AgregarServicio(nombre);
				limpiar();
			}
		});
		
		JLabel lblServicio = new JLabel("SERVICIO");
		lblServicio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblServicio.setBounds(147, 26, 136, 32);
		contentPane.add(lblServicio);
				
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				
				if(nombre != "" && nombre != null && idEditar != null) {
					Servicios s = new Servicios();
					s.setIdServicio(idEditar);
					s.setNombre(nombre);
					
					adminServicio.actualizarServicio(s);
					limpiar();
					
				}
			}
		});
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() > -1) {
					Integer idServicio = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
					adminServicio.eliminarServicio(idServicio);
					limpiar();
				}
			}
		});
		
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() > -1) {
					txtNombre.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					idEditar = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
				}
			}
		});
		
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Id Servicio");
				model.addColumn("Nombre");
				
				listaServicios = adminServicio.obtenerListaServicios();
				for(Servicios s: listaServicios) {
					String[] fila = {s.getIdServicio().toString(), s.getNombre()};
					model.addRow(fila);
				}
				table.setModel(model);
				table.setVisible(true);
			}
		});	
		
		
		ScrollPane scroll = new ScrollPane();
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(99, 295, 330, 170);
		scroll.setBounds(99, 295, 330, 170);
		scroll.add(table);
		scroll.setVisible(true);
		contentPane.add(scroll);
		
		
		btnEliminar.setBounds(222, 203, 89, 23);
		contentPane.add(btnEliminar);
		
		btnEditar.setBounds(350, 149, 89, 23);
		contentPane.add(btnEditar);
		
		btnActualizar.setBounds(92, 203, 89, 23);
		contentPane.add(btnActualizar);
		
		btnAgregar.setBounds(95, 149, 89, 23);
		contentPane.add(btnAgregar);
		
		
		btnListar.setBounds(222, 149, 89, 23);
		contentPane.add(btnListar);
		
	}
	
	
	public void limpiar() {
		idEditar = null;
		txtNombre.setText("");
		table.setModel(new DefaultTableModel());
	}
}
