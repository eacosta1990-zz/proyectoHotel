package datos;

import java.util.GregorianCalendar;
import java.util.Set;

public class TicketConsumo {


	private int idTicketConsumo;
	private GregorianCalendar fecha;
	private boolean firmado;
	private int nroFactura;
	private Estadia estadia;
	private Login login;
	private Set<TicketConsumoItem> ticketConsumoItem;

	public TicketConsumo(){
		
	}
	public TicketConsumo( GregorianCalendar fecha,boolean firmado, int nroFactura, Estadia estadia, Login login) {
		
		this.fecha = fecha;
		this.firmado = firmado;
		this.nroFactura = nroFactura;
		this.estadia = estadia;
		this.login = login;
		
	}



	public int getIdTicketConsumo() {
		return idTicketConsumo;
	}
	public void setIdTicketConsumo(int idTicketConsumo) {
		this.idTicketConsumo = idTicketConsumo;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	public boolean isFirmado() {
		return firmado;
	}
	public void setFirmado(boolean firmado) {
		this.firmado = firmado;
	}
	public int getNroFactura() {
		return nroFactura;
	}
	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}
	public Estadia getEstadia() {
		return estadia;
	}
	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Set<TicketConsumoItem> getTicketConsumoItem() {
		return ticketConsumoItem;
	}
	public void setTicketConsumoItem(Set<TicketConsumoItem> ticketConsumoItem) {
		this.ticketConsumoItem = ticketConsumoItem;
	}
	@Override
	public String toString() {
		return "TicketConsumo [idTicketConsumo=" + idTicketConsumo + ", fecha="
				+ fecha + ", firmado=" + firmado + ", facturado=" + nroFactura
				+  "]";
	}
}
