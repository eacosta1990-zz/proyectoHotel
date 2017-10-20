package datos;

public class TicketConsumoItem {
	private int idTicketConsumoItem;
	private int cantidad;
	private float precio;
	private TicketConsumo ticketConsumo;
	private Consumo consumo;

	public TicketConsumoItem(){
		
	}
	public TicketConsumoItem( int cantidad,float precio, TicketConsumo ticketConsumo, Consumo consumo) {
		this.cantidad = cantidad;
		this.precio = precio;
		this.ticketConsumo = ticketConsumo;
		this.consumo = consumo;
	}

	public int getIdTicketConsumoItem() {
		return idTicketConsumoItem;
	}

	
	protected void setIdTicketConsumoItem(int idTicketConsumoItem) {
		this.idTicketConsumoItem = idTicketConsumoItem;
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

	public TicketConsumo getTicketConsumo() {
		return ticketConsumo;
	}

	public void setTicketConsumo(TicketConsumo ticketConsumo) {
		this.ticketConsumo = ticketConsumo;
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}
	@Override
	public String toString() {
		return "TicketConsumoItem [idTicketConsumoItem=" + idTicketConsumoItem
				+ ", cantidad=" + cantidad + ", precio=" + precio
				+  "]";
	}
}
