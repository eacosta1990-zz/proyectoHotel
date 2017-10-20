package datos;

import java.util.GregorianCalendar;
import java.util.Set;

public class Factura {
	private int idFactura;
	private int nroFactura;
	private GregorianCalendar fecha;
	private boolean estado;
	private FormaPago formaPago;
	private Cliente cliente;
	private Login login;
	private Set<FacturaItem> facturaItem;
	private Estadia estadia;

	public Factura(){}
	
	public Factura( int nroFactura, GregorianCalendar fecha
			 , boolean estado, FormaPago formaPago, Cliente cliente,
			Login login,Estadia estadia) {

		this.nroFactura = nroFactura;
		this.fecha = fecha;
		this.estado = estado;
		this.formaPago = formaPago;
		this.cliente = cliente;
		this.login = login;
		this.estadia = estadia;
	}

	public int getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}



	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public Set<FacturaItem> getFacturaItem() {
		return facturaItem;
	}

	public void setFacturaItem(Set<FacturaItem> facturaItem) {
		this.facturaItem = facturaItem;
	}
	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", nroFactura=" + nroFactura + ", fecha=" + fecha  + ", estado=" + estado +   "]";
	}

}
