package datos;

import java.util.Set;

public class Cliente {
	

	private int idCliente;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String direccion;
	private long dni;
	private Set<Factura> factura;
	private Set<Estadia> estadia;

	public Cliente() {
	}

	public Cliente( String nombre, String apellido, String telefono, String direccion, long dni,
			String email) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.dni = dni;
		this.email = email;

	}

	public Set<Estadia> getEstadia() {
		return estadia;
	}

	public void setEstadia(Set<Estadia> estadia) {
		this.estadia = estadia;
	}



	public Set<Factura> getFactura() {
		return factura;
	}

	public void setFactura(Set<Factura> factura) {
		this.factura = factura;
	}

	public int getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono="
				+ telefono + ", email=" + email + ", direccion=" + direccion + ", dni=" + dni + "]";
	}

}
