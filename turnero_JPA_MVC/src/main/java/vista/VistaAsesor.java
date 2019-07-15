package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.AdministrarAsesor;
import modelo.Asesor;
import modelo.Prioridad;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.ScrollPane;

public class VistaAsesor extends JFrame {
	private AdministrarAsesor adminAsesor = new AdministrarAsesor();
	private JPanel contentPane;
	private JTextField txtIdentificacion;
	private JTextField txtNombre;
	private String nombre;
	private String identificacion;
	private boolean estado;
	private JTable table;
	private String idEditar;
	private List<Asesor> listaAsesor;

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
		setBounds(100, 100, 504, 544);
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
		
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Cédula");
				model.addColumn("Nombre");
				
				listaAsesor = adminAsesor.obtenerListaAsesores();
				for(Asesor a: listaAsesor) {
					String[] fila = {a.getIdentificacion(), a.getNombre()};
					model.addRow(fila);
				}
				table.setModel(model);
				table.setVisible(true);
			}
		});
		btnListar.setBounds(332, 202, 97, 25);
		contentPane.add(btnListar);
		
		JLabel lblAsesor = new JLabel("ASESOR");
		lblAsesor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAsesor.setBounds(163, 24, 97, 36);
		contentPane.add(lblAsesor);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				String identificacion = txtIdentificacion.getText();
				
				
				if(nombre != "" && nombre != null && idEditar != null) {
					Asesor asesor = new Asesor();
					asesor.setIdentificacion(identificacion);
					asesor.setNombre(nombre);
					
					adminAsesor.actualizarAsesor(asesor);
					limpiar();
					
				}
			}
		});
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() > -1) {
					String cc = table.getValueAt(table.getSelectedRow(), 0).toString();
					adminAsesor.eliminarAsesor(cc);
					limpiar();
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() > -1) {
					txtIdentificacion.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					txtNombre.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					idEditar = table.getValueAt(table.getSelectedRow(), 0).toString();
					
				}
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
		
		
		btnEliminar.setBounds(235, 203, 89, 23);
		contentPane.add(btnEliminar);
		
		btnEditar.setBounds(279, 168, 89, 23);
		contentPane.add(btnEditar);
		
		btnActualizar.setBounds(10, 203, 89, 23);
		contentPane.add(btnActualizar);
		
		btnGuardar.setBounds(123, 202, 97, 25);
		contentPane.add(btnGuardar);
		
		
	}
	
	
	public void limpiar() {
		idEditar = null;
		txtIdentificacion.setText("");
		txtNombre.setText("");
		table.setModel(new DefaultTableModel());
	}
}
