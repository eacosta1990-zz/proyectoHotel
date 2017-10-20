package datos;

public class Servicio {
	private int idServicio;
	private String servicio;
	private String descripcion;// es text en bd
	private boolean incluido;
	private boolean disponible;
	private Hotel hotel;

	private float precio;

	public Servicio() {
	}

	public Servicio(Hotel hotel, String servicio, String descripcion, boolean incluido, boolean disponible,
			float precio) {
		this.servicio = servicio;
		this.hotel = hotel;
		this.descripcion = descripcion;
		this.incluido = incluido;
		this.disponible = disponible;
		this.precio = precio;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getIdServicio() {
		return idServicio;
	}

	protected void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isIncluido() {
		return incluido;
	}

	public void setIncluido(boolean incluido) {
		this.incluido = incluido;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", servicio=" + servicio + ", descripcion=" + descripcion
				+ ", incluido=" + incluido + ", disponible=" + disponible +  ", precio=" + precio
				+ "]";
	}

}
