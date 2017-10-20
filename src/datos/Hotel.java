package datos;

import java.util.Set;

public class Hotel {
	private int idHotel;
	private String hotel;
	private String telefono;
	private String email;
	private String direccion;
	private int categoria;
	private Set<Servicio> servicios;
	private Set<Habitacion> habitaciones;
	
	
	public Hotel(){}
	
	public Hotel( String hotel, String telefono, String email, String direccion, int categoria) {
		this.hotel = hotel;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.categoria = categoria;

	}

	public Set<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Set<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Set<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}

	public int getIdHotel() {
		return idHotel;
	}

	protected void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email =email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", hotel=" + hotel + ", telefono=" + telefono + ", email=" + email
				+ ", direccion=" + direccion + ", categoria=" + categoria +  "]";
	}
	

}
