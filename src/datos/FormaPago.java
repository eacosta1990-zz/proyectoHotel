package datos;

import java.util.Set;

public class FormaPago {
	private int idFormaPago;
	private String formaPago;
	private Set<Factura> factura;

	public FormaPago(){
	
	}
	public FormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	public Set<Factura> getFactura() {
		return factura;
	}

	public void setFactura(Set<Factura> factura) {
		this.factura = factura;
	}

	public int getIdFormaPago() {
		return idFormaPago;
	}

	protected void setIdFormaPago(int idFormaPago) {
		this.idFormaPago = idFormaPago;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	@Override
	public String toString() {
		return "FormaPago [idFormaPago=" + idFormaPago + ", formaPago=" + formaPago + "]";
	}
	

}
