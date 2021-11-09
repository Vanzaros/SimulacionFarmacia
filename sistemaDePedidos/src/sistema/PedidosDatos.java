package sistema;

public class PedidosDatos {
	private String nombreMedicamento;
	private String tipoMedicamento;
	private int cantidad;
	private String distribuidor;
	private boolean sucursal;
	private boolean sucursal2;
	
	
	public PedidosDatos() {
		
	}

	public PedidosDatos(String nombreMedicamento, Object tipoMedicamentos, int cantidad, String distribuidor, boolean selected,
			boolean selected2) {
		// TODO Auto-generated constructor stub
		this.nombreMedicamento = nombreMedicamento;
		this.tipoMedicamento = tipoMedicamentos.toString();
		this.cantidad = cantidad;
		this.distribuidor = distribuidor;
		this.sucursal = selected;
		this.sucursal2 = selected2;
	}

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}

	public String getTipoMedicamento() {
		return tipoMedicamento;
	}

	public void setTipoMedicamento(String tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}

	public boolean getSucursal() {
		return sucursal;
	}

	public void setSucursal(boolean sucursal) {
		this.sucursal = sucursal;
	}
	public boolean getSucursal2() {
		return sucursal2;
	}
	public void setSucursal2(boolean sucursal) {
		this.sucursal2 = sucursal;
	}
}
