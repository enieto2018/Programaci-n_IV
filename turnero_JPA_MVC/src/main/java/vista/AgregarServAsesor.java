package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class AgregarServAsesor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		
		textField = new JTextField();
		textField.setBounds(166, 86, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(91, 211, 89, 23);
		contentPane.add(btnAgregar);
		
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
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(166, 113, 114, 52);
		contentPane.add(list_1);
		
		
	}
}
