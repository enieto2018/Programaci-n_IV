package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.AdministrarAsesor;
import controlador.AdministrarPuntoAtencion;
import modelo.Asesor;
import modelo.PuntoAtencion;

public class VistaPuntoAtencion extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private String nombre;
	private boolean disponible;
	private AdministrarPuntoAtencion adminPunto= new AdministrarPuntoAtencion();
	private AdministrarAsesor adminAsesor =new AdministrarAsesor();
	private String nombreAsesor;
	private JTable table;
	private List<PuntoAtencion> listaPuntoAtencion;
	private Integer idEditar;
	private JComboBox comboBoxAsesor;
	private JCheckBox chckbxDisponible;
	private List<Asesor> listaAsesores  =adminAsesor.obtenerListaAsesores();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPuntoAtencion frame = new VistaPuntoAtencion();
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
	public VistaPuntoAtencion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAsesor = new JLabel("Asesor");
		lblAsesor.setBounds(91, 125, 46, 14);
		contentPane.add(lblAsesor);
		
		JLabel lblPuntoDeAtencin = new JLabel("PUNTO DE ATENCIÓN");
		lblPuntoDeAtencin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPuntoDeAtencin.setBounds(107, 36, 226, 14);
		contentPane.add(lblPuntoDeAtencin);
		
		chckbxDisponible = new JCheckBox("Disponible");
		chckbxDisponible.setBounds(71, 161, 97, 23);
		contentPane.add(chckbxDisponible);
		
		
		
		String [] listNombAsesor= new String[listaAsesores.size()];
		
		for(int i=0; i<listNombAsesor.length; i++) {
			listNombAsesor[i] = listaAsesores.get(i).getIdentificacion()+" - "+listaAsesores.get(i).getNombre();
		}
		
		comboBoxAsesor = new JComboBox();
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
				System.out.println(asesor.toString());
				
				adminPunto.AgregarPuntoAtencion(asesor, disponible, nombre);
				
				limpiar();
			}
		});
		

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombre=textNombre.getText();
				disponible=chckbxDisponible.isSelected();
				int index=comboBoxAsesor.getSelectedIndex();
				Asesor asesor = listaAsesores.get(index);
				
				if(nombre != "" && nombre != null && idEditar != null) {
					PuntoAtencion p = new PuntoAtencion();
					p.setId(idEditar);
					p.setNombre(nombre);
					p.setDisponible(disponible);
					p.setAsesor(asesor);
					adminPunto.actualizarPuntoAtencion(p);
					limpiar();
					
				}
			}
		});
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() > -1) {
					Integer idPunto = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
					adminPunto.eliminarPuntoAtencion(idPunto);
					limpiar();
				}
			}
		});
		
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() > -1) {
					idEditar = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
					textNombre.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					chckbxDisponible.setSelected(table.getValueAt(table.getSelectedRow(), 2).toString()== "S"?true : false);
					String cc =  table.getValueAt(table.getSelectedRow(), 3).toString();
					
					for(int i = 0; i < listaAsesores.size(); i++) {
						if(listaAsesores.get(i).getIdentificacion().equals(cc)) {
							comboBoxAsesor.setSelectedIndex(i);
							break;
						}
					}
					
				}
			}
		});
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Id Punto");
				model.addColumn("Nombre");
				model.addColumn("Displonible");
				model.addColumn("Asesor");
				
				listaPuntoAtencion = adminPunto.listarPuntosAtencion();
				System.out.println(listaPuntoAtencion.size());
				for(PuntoAtencion p: listaPuntoAtencion) {
					String[] fila = {p.getId().toString(), p.getNombre(), p.isDisponible()==true?"S":"N", p.getAsesor().getIdentificacion()};
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
		
		btnEliminar.setBounds(222, 249, 89, 23);
		contentPane.add(btnEliminar);
		
		btnEditar.setBounds(352, 197, 89, 23);
		contentPane.add(btnEditar);
		
		btnActualizar.setBounds(99, 249, 89, 23);
		contentPane.add(btnActualizar);
		
		btnAgregar.setBounds(99, 197, 89, 23);
		contentPane.add(btnAgregar);
		
		
		btnConsultar.setBounds(222, 197, 89, 23);
		contentPane.add(btnConsultar);
		
		textNombre = new JTextField();
		textNombre.setBounds(170, 84, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre Punto");
		lblNewLabel.setBounds(91, 87, 69, 14);
		contentPane.add(lblNewLabel);
	}
	
	public void limpiar() {
		idEditar = null;
		textNombre.setText("");
		table.setModel(new DefaultTableModel());
	}
}
