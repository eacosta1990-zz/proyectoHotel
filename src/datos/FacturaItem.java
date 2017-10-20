package datos;

public class FacturaItem {
 private int idFacturaItem;
	private int cantidad;
	private float precio;
	private Factura factura;

	public FacturaItem() {
	}

	public FacturaItem(int idFacturaItem, int cantidad, float precio, Factura factura) {
		this.idFacturaItem = idFacturaItem;
		this.cantidad = cantidad;
		this.precio = precio;
		this.factura = factura;
	}


	public int getIdFacturaItem() {
		return idFacturaItem;
	}

	protected void setIdFacturaItem(int idFacturaItem) {
		this.idFacturaItem = idFacturaItem;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "FacturaItem [idFacturaItem=" + idFacturaItem + ", cantidad=" + cantidad + ", precio=" + precio;
	}

}
