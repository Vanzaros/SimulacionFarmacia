package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuKeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.UIManager;

import sistema.PedidosDatos;

public class PedidosPrincipal extends JFrame implements ActionListener {

	private JPanel panelPrincipal;
	public JTextField txtNombreMedicamento;
	public JTextField txtCantidad;
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public JButton buttonConfirmar;
	public JButton buttonBorrar;
	public JComboBox cbTipoMedicamento;
	public JCheckBox cbSucursalPrincipal;
	public JCheckBox cbSucursalSecundaria;
	public JRadioButton nrbDistribuidor1;
	public JRadioButton nrbDistribuidor2;
	public JRadioButton nrbDistribuidor3;
	private Reporte ventanaReporte;
	private PedidosDatos pedidosDatos;

	public PedidosPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();
		
		setTitle("Pedidos");
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
	}


	private void iniciarComponentes() {
		setBounds(100, 100, 679, 335);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel jNombreMedicamento = new JLabel("Nombre del medicamento");
		jNombreMedicamento.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		jNombreMedicamento.setBounds(38, 11, 168, 14);
		panelPrincipal.add(jNombreMedicamento);
		
		JLabel jTipoMedicamento = new JLabel("Tipo de medicamento");
		jTipoMedicamento.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		jTipoMedicamento.setBounds(38, 61, 168, 14);
		panelPrincipal.add(jTipoMedicamento);
		
		JLabel jCantidad = new JLabel("Cantidad");
		jCantidad.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		jCantidad.setBounds(38, 111, 168, 14);
		panelPrincipal.add(jCantidad);
		
		JLabel jDistribuidor = new JLabel("Distribuidor");
		jDistribuidor.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		jDistribuidor.setBounds(38, 161, 168, 14);
		panelPrincipal.add(jDistribuidor);
		
		JLabel jSucursal = new JLabel("Sucursal");
		jSucursal.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		jSucursal.setBounds(38, 211, 168, 14);
		panelPrincipal.add(jSucursal);
		
		txtNombreMedicamento = new JTextField();
		txtNombreMedicamento.setForeground(Color.BLACK);
		txtNombreMedicamento.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		txtNombreMedicamento.setToolTipText("Introduzca nombre del medicamento");
		txtNombreMedicamento.setBounds(227, 11, 225, 20);
		panelPrincipal.add(txtNombreMedicamento);
		txtNombreMedicamento.setColumns(10);
		
		cbTipoMedicamento = new JComboBox();
		cbTipoMedicamento.setBackground(UIManager.getColor("CheckBox.background"));
		cbTipoMedicamento.setModel(new DefaultComboBoxModel(new String[] {"Analg\u00E9sico ", "Anal\u00E9ptico", "Anest\u00E9sico", "Anti\u00E1cido ", "Antidepresivo", "Antibi\u00F3ticos"}));
		cbTipoMedicamento.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		cbTipoMedicamento.setBounds(227, 60, 160, 22);
		panelPrincipal.add(cbTipoMedicamento);
		
		txtCantidad = new JTextField();
		txtCantidad.setForeground(Color.BLACK);
		txtCantidad.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		txtCantidad.setBounds(227, 111, 86, 20);
		panelPrincipal.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		nrbDistribuidor1 = new JRadioButton("Cofarma");
		nrbDistribuidor1.setBackground(Color.WHITE);
		buttonGroup.add(nrbDistribuidor1);
		nrbDistribuidor1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		nrbDistribuidor1.setBounds(223, 160, 109, 23);
		panelPrincipal.add(nrbDistribuidor1);
		
		nrbDistribuidor2 = new JRadioButton("Empsephar");
		nrbDistribuidor2.setBackground(Color.WHITE);
		buttonGroup.add(nrbDistribuidor2);
		nrbDistribuidor2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		nrbDistribuidor2.setBounds(356, 160, 109, 23);
		panelPrincipal.add(nrbDistribuidor2);
		
		nrbDistribuidor3 = new JRadioButton("Cemefar");
		nrbDistribuidor3.setBackground(Color.WHITE);
		buttonGroup.add(nrbDistribuidor3);
		nrbDistribuidor3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		nrbDistribuidor3.setBounds(482, 160, 109, 23);
		panelPrincipal.add(nrbDistribuidor3);
		
		buttonGroup.add(nrbDistribuidor1);
		buttonGroup.add(nrbDistribuidor2);
		buttonGroup.add(nrbDistribuidor3);
		
		cbSucursalPrincipal = new JCheckBox("Principal");
		cbSucursalPrincipal.setBackground(Color.WHITE);
		cbSucursalPrincipal.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		cbSucursalPrincipal.setBounds(223, 210, 97, 23);
		panelPrincipal.add(cbSucursalPrincipal);
		
		cbSucursalSecundaria = new JCheckBox("Secundaria");
		cbSucursalSecundaria.setBackground(Color.WHITE);
		cbSucursalSecundaria.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		cbSucursalSecundaria.setBounds(356, 210, 97, 23);
		panelPrincipal.add(cbSucursalSecundaria);
		
		buttonConfirmar = new JButton("Confirmar");
		buttonConfirmar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		buttonConfirmar.setBounds(184, 262, 97, 23);
		buttonConfirmar.addActionListener(this);
		panelPrincipal.add(buttonConfirmar);
		
		buttonBorrar = new JButton("Borrar todo");
		buttonBorrar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		buttonBorrar.setBounds(504, 262, 131, 23);
		buttonBorrar.addActionListener(this);
		panelPrincipal.add(buttonBorrar);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (buttonConfirmar == e.getSource()) {
			confirmar();
		}
		if (buttonBorrar == e.getSource()) {
			borrarTodo();
		}
	}
	
	public void confirmar() {
			if(txtNombreMedicamento.getText().equals("")
					|| txtCantidad.getText().equals("")
					|| !cbSucursalPrincipal.isSelected()
					&& !cbSucursalSecundaria.isSelected()
					|| buttonGroup.getSelection().equals(false)) {
				JOptionPane.showMessageDialog(this, "Llene todos los campos");
			}else {
				guardarDatos();
			}
	}
	
	public void borrarTodo() {
		txtNombreMedicamento.setText("");
		cbTipoMedicamento.setSelectedIndex(0);
		txtCantidad.setText("");
		buttonGroup.clearSelection();
		cbSucursalPrincipal.setSelected(false);
		cbSucursalSecundaria.setSelected(false);
	}
	
	public void guardarDatos() {
		pedidosDatos = new PedidosDatos(txtNombreMedicamento.getText(),
				cbTipoMedicamento.getSelectedItem(),Integer.parseInt(txtCantidad.getText()),
				getSelectedButtonText(buttonGroup),cbSucursalPrincipal.isSelected(), cbSucursalSecundaria.isSelected());
		
		if (ventanaReporte != null) {
			ventanaReporte.setVisible(true);
		}else {
		ventanaReporte = new Reporte(pedidosDatos);
		ventanaReporte.setVisible(true);
		PedidosPrincipal.this.dispose();
		}
	}
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				return button.getText();
			}
		}
		return null;
	}
}