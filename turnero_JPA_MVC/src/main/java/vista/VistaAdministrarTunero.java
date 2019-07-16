package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaAdministrarTunero extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAdministrarTunero frame = new VistaAdministrarTunero();
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
	public VistaAdministrarTunero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrearPrioridad = new JButton("Crear Prioridad");
		btnCrearPrioridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPrioridad vent= new VistaPrioridad();
				vent.setVisible(true);
			}
		});
		btnCrearPrioridad.setBounds(53, 41, 154, 23);
		contentPane.add(btnCrearPrioridad);
		
		JButton btnCrearAsesor = new JButton("Crear Asesor");
		btnCrearAsesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaAsesor vent= new VistaAsesor();
				vent.setVisible(true);
			}
		});
		btnCrearAsesor.setBounds(53, 91, 154, 23);
		contentPane.add(btnCrearAsesor);
		
		JButton btnCrearPuntoDe = new JButton("Crear punto de atención");
		btnCrearPuntoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				PuntoAtencion vent=new PuntoAtencion();
//				vent.setVisible(true);
			}
		});
		btnCrearPuntoDe.setBounds(53, 201, 154, 23);
		contentPane.add(btnCrearPuntoDe);
		
		JButton btnCrearServicio = new JButton("Crear Servico");
		btnCrearServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaServicio vent= new VistaServicio();
				vent.setVisible(true);
				
			}
		});
		btnCrearServicio.setBounds(53, 142, 154, 23);
		contentPane.add(btnCrearServicio);
		
		JButton btnAsociarAsesorY = new JButton("Asociar Asesor y Servicio");
		btnAsociarAsesorY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarServAsesor vent=new AgregarServAsesor();
				vent.setVisible(true);
				

				}
		});
		btnAsociarAsesorY.setBounds(229, 41, 180, 23);
		contentPane.add(btnAsociarAsesorY);
	}

}
