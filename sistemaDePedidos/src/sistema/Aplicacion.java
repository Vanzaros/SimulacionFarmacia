package sistema;

import gui.PedidosPrincipal;

public class Aplicacion {
	

	public Aplicacion() {
		
		presentarVentana();
	}
	
	private void presentarVentana() {
		PedidosPrincipal miVentana = new PedidosPrincipal();
		miVentana.setVisible(true);
	}

}
