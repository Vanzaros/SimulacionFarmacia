package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.PedidosDatos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Reporte extends JFrame implements ActionListener {

	private JPanel contentPane;
	JLabel labelCantidadYTipo;
	JLabel labelDireccion;
	JButton BotonEnviar;
	JButton BotonCancelar;
	PedidosPrincipal vPrincipal;
	private PedidosDatos pedidosDatos;

	/**
	 * Create the frame.
	 */
	public Reporte(PedidosDatos b) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();
		
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		this.pedidosDatos = b;
		mostrar();
	}
	
	public void iniciarComponentes() {
		setBounds(100, 100, 612, 232);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelCantidadYTipo = new JLabel();
		labelCantidadYTipo.setBackground(Color.WHITE);
		labelCantidadYTipo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelCantidadYTipo.setBounds(10, 22, 573, 41);
		contentPane.add(labelCantidadYTipo);
		
		labelDireccion = new JLabel();
		labelDireccion.setBackground(Color.WHITE);
		labelDireccion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelDireccion.setBounds(10, 74, 573, 41);
		contentPane.add(labelDireccion);
		
		BotonEnviar = new JButton("Enviar Pedido");
		BotonEnviar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonEnviar.setBounds(10, 141, 143, 27);
		BotonEnviar.addActionListener(this);
		contentPane.add(BotonEnviar);
		
		BotonCancelar = new JButton("Cancelar Pedido");
		BotonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BotonCancelar.setBounds(434, 141, 149, 27);
		BotonCancelar.addActionListener(this);
		contentPane.add(BotonCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (BotonEnviar == e.getSource()) {
			enviarPedido();
		}
		if (BotonCancelar == e.getSource()) {
			regresarVentana();
		}
		
	}
	
	public void regresarVentana() {
		vPrincipal = new PedidosPrincipal();
		vPrincipal.setVisible(true);
		Reporte.this.dispose();
	}
	
	public void enviarPedido() {
		JOptionPane.showMessageDialog(this, "Se ha enviado el pedido");
		regresarVentana();
		System.out.println("Pedido enviado");
	}
	private void mostrar() {
		setTitle("Pedido al distribuidor "+pedidosDatos.getDistribuidor());
		labelCantidadYTipo.setText(
				pedidosDatos.getCantidad()+" unidades del "+pedidosDatos.getTipoMedicamento()+" "+pedidosDatos.getNombreMedicamento());
		
		if (pedidosDatos.getSucursal() == true && pedidosDatos.getSucursal2() == true) {
			labelDireccion.setText(
					"Para la farmacia situada en Calle de la Rosa n.28 y para la situada en Calle Alcazabilla n.3");
		} else if (pedidosDatos.getSucursal() == true) {
			labelDireccion.setText(
					"Para la farmacia situada en Calle de la Rosa n. 28");
		}else if (pedidosDatos.getSucursal2() == true) {
			labelDireccion.setText(
					"Para la farmacia situada en Calle Alcazabilla n. 3");
		}
		
	}
	
	

}
