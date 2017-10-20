package datos;

import java.util.Set;

public class Habitacion {
	private int idHabitacion;
	private String nroHabitacion;
	private int capacidadMax;
	private int disponible;
	private Hotel hotel;
	private TipoHabitacion tipoHabitacion;
	private Set<Estadia> estadias;

	public Habitacion() {
	}

	public Habitacion( String nroHabitacion, int capacidadMax, int disponible, Hotel hotel,TipoHabitacion tipoHabitacion) {
		this.nroHabitacion = nroHabitacion;
		this.capacidadMax = capacidadMax;
		this.disponible = disponible;
		this.hotel = hotel;
		this.tipoHabitacion = tipoHabitacion;
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public String getNroHabitacion() {
		return nroHabitacion;
	}

	public void setNroHabitacion(String nroHabitacion) {
		this.nroHabitacion = nroHabitacion;
	}

	public int getCapacidadMax() {
		return capacidadMax;
	}

	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public Set<Estadia> getEstadias() {
		return estadias;
	}

	public void setEstadias(Set<Estadia> estadias) {
		this.estadias = estadias;
	}

	@Override
	public String toString() {
		return "Habitacion [idHabitacion=" + idHabitacion + ", nroHabitacion=" + nroHabitacion + ", capacidadMax="
				+ capacidadMax + ", disponible=" + disponible + ", hotel=" + hotel + ", tipoHabitacion="
				+ tipoHabitacion + "]";
	}
	
}