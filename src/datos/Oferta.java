package datos;

import java.util.GregorianCalendar;

public class Oferta {
	private int idOferta;
	private float descuento;
	private GregorianCalendar fechaDesde;
	private GregorianCalendar fechaHasta;
	private boolean estado;

	public Oferta(){
		
	}
	public Oferta( float descuento, GregorianCalendar fechaDesde,
			GregorianCalendar fechaHasta, boolean estado) {
		this.descuento = descuento;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.estado = estado;
	}

	public int getIdOferta() {
		return idOferta;
	}

	protected void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public GregorianCalendar getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(GregorianCalendar fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public GregorianCalendar getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(GregorianCalendar fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Oferta [idOferta=" + idOferta + ", descuento=" + descuento + ", fechaDesde=" + fechaDesde
				+ ", fechaHasta=" + fechaHasta + ", estado=" + estado + "]";
	}
	

}
