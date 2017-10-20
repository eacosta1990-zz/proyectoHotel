package datos;

import java.util.Set;

public class TipoHabitacion {
	private int idTipoHabitacion;
	private String tipoHabitacion;
	private String descripcion;// es text en bd
	private float precio;
	private Set<Habitacion> habitaciones;

	public TipoHabitacion(){}
	
	public TipoHabitacion( String tipoHabitacion, String descripcion, float precio) {
		this.tipoHabitacion = tipoHabitacion;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public void setHabitaciones(Set<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Set<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public int getIdTipoHabitacion() {
		return idTipoHabitacion;
	}

	protected void setIdTipoHabitacion(int idTipoHabitacion) {
		this.idTipoHabitacion = idTipoHabitacion;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "TipoHabitacion [idTipoHabitacion=" + idTipoHabitacion + ", tipoHabitacion=" + tipoHabitacion
				+ ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	

}
