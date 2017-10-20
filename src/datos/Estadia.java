package datos;

import java.util.GregorianCalendar;
import java.util.Set;

import funciones.Funciones;

public class Estadia {
	private int idEstadia;
	private GregorianCalendar fechaDesde;
	private GregorianCalendar fechaHasta;
	private float senia;
	private GregorianCalendar fechaReserva;
	private float precio;
	private Estado estado;
	private Frigobar frigobar;
	private Set<Cliente> cliente;
	private Set<TicketConsumo> ticketConsumo;
	private Set<Habitacion> habitaciones;
	private Set<Factura> factura;

	public Estadia(){}

	public Estadia( GregorianCalendar fechaDesde, GregorianCalendar fechaHasta, float senia,
			GregorianCalendar fechaReserva, float precio, Estado estado, Frigobar frigobar) {
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.senia = senia;
		this.fechaReserva = fechaReserva;
		this.precio = precio;
		this.estado = estado;
		this.frigobar = frigobar;

	}

	

	public int getIdEstadia() {
		return idEstadia;
	}

	public void setIdEstadia(int idEstadia) {
		this.idEstadia = idEstadia;
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

	public float getSenia() {
		return senia;
	}

	public void setSenia(float senia) {
		this.senia = senia;
	}

	public GregorianCalendar getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(GregorianCalendar fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Frigobar getFrigobar() {
		return frigobar;
	}

	public void setFrigobar(Frigobar frigobar) {
		this.frigobar = frigobar;
	}

	public Set<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(Set<Cliente> cliente) {
		this.cliente = cliente;
	}

	public Set<TicketConsumo> getTicketConsumo() {
		return ticketConsumo;
	}

	public void setTicketConsumo(Set<TicketConsumo> ticketConsumo) {
		this.ticketConsumo = ticketConsumo;
	}

	public Set<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Set<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Set<Factura> getFactura() {
		return factura;
	}

	public void setFactura(Set<Factura> factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Estadia [idEstadia=" + idEstadia + ", fechaDesde=" + Funciones.obtenerFecha(fechaDesde) + ", Fecha Hasta" +  Funciones.obtenerFecha(fechaHasta)
				+ ", senia=" + senia + ", fechaReserva=" + Funciones.obtenerFecha(fechaReserva) + ", precio=" + precio + "]";
	}
	

}
