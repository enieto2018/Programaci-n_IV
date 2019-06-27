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
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;

public class Enturnar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enturnar frame = new Enturnar();
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
	public Enturnar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setBounds(45, 67, 102, 14);
		contentPane.add(lblIdentificacion);
		
		JLabel lblSeleccionDeTurnos = new JLabel("SELECCION DE TURNOS");
		lblSeleccionDeTurnos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSeleccionDeTurnos.setBounds(116, 24, 205, 23);
		contentPane.add(lblSeleccionDeTurnos);
		
		textField = new JTextField();
		textField.setBounds(143, 64, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(45, 100, 46, 14);
		contentPane.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 92, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnGenerar = new JButton("Generar ");
		btnGenerar.setBounds(181, 203, 89, 23);
		contentPane.add(btnGenerar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(143, 123, 86, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(143, 156, 86, 20);
		contentPane.add(comboBox_1);
	}
}
