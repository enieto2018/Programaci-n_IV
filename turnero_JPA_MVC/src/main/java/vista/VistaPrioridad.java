package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.AdministrarPrioridad;
import modelo.Prioridad;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class VistaPrioridad extends JFrame {

	private JPanel contentPane;
	private JTextField textNombrePrio;
	private String nombrePrioridad;
	private AdministrarPrioridad adminPrioridad=new AdministrarPrioridad();
	private JTable table;
	private List<Prioridad> listaPrioridad;
	private Integer idEditar;

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
		setBounds(100, 100, 514, 572);
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
				limpiar();
			}
		});
		btnAgregar.setBounds(95, 149, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(222, 149, 89, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblPrioridad = new JLabel("PRIORIDAD");
		lblPrioridad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrioridad.setBounds(157, 31, 106, 34);
		contentPane.add(lblPrioridad);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dato = textNombrePrio.getText();
				
				if(dato != "" && dato != null && idEditar != null) {
					Prioridad p = new Prioridad();
					p.setIdPrioridad(idEditar);
					p.setNombre(dato);
					
					adminPrioridad.actualizarPrioridad(p);
					limpiar();
					
				}
			}
		});
		btnActualizar.setBounds(92, 203, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(222, 203, 89, 23);
		contentPane.add(btnEliminar);
		
		ScrollPane scroll = new ScrollPane();
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(99, 295, 330, 170);
		scroll.setBounds(99, 295, 330, 170);
		scroll.add(table);
		scroll.setVisible(true);
		contentPane.add(scroll);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() > -1) {
					textNombrePrio.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					idEditar = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
					System.out.println(idEditar);
				}
			}
		});
		btnEditar.setBounds(350, 149, 89, 23);
		contentPane.add(btnEditar);
		
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Id Prioridad");
				model.addColumn("Nombre");
				
				listaPrioridad = adminPrioridad.listarPrioridades();
				for(Prioridad p: listaPrioridad) {
					String[] fila = {p.getIdPrioridad().toString(), p.getNombre()};
					model.addRow(fila);
				}
				table.setModel(model);
				table.setVisible(true);
			}
		});
		
		
		
	}
	
	public void limpiar() {
		idEditar = null;
		textNombrePrio.setText("");
		table.setModel(new DefaultTableModel());
	}
}
