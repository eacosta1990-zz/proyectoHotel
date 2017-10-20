package datos;

import java.util.Set;

public class Login {
	private int idLogin;
	private String usuario;
	private String clave;
	private int privilegio;
	private Empleado empleado;
	private Set<Factura> factura;
	private Set<TicketConsumo> ticketConsumo;
	private Set<TicketMantenimiento>ticketMantenimiento;
	
	public Login(){}
	public Login(String usuario, String clave, int privilegio) {
		this.usuario = usuario;
		this.clave = clave;
		this.privilegio = privilegio;
	}
	public Login(String usuario, String clave, int privilegio, Empleado empleado) {
		this.usuario = usuario;
		this.clave = clave;
		this.privilegio = privilegio;
		this.empleado = empleado;
	}
	
	public Set<TicketMantenimiento> getTicketMantenimiento() {
		return ticketMantenimiento;
	}

	public void setTicketMantenimiento(Set<TicketMantenimiento> ticketMantenimiento) {
		this.ticketMantenimiento = ticketMantenimiento;
	}

	public Set<TicketConsumo> getTicketConsumo() {
		return ticketConsumo;
	}

	public void setTicketConsumo(Set<TicketConsumo> ticketConsumo) {
		this.ticketConsumo = ticketConsumo;
	}

	public Set<Factura> getFactura() {
		return factura;
	}

	public void setFactura(Set<Factura> factura) {
		this.factura = factura;
	}

	public int getIdLogin() {
		return idLogin;
	}
	protected void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(int privilegio) {
		this.privilegio = privilegio;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Login [idLogin=" + idLogin + ", usuario=" + usuario + ", clave=" + clave + ", privilegio=" + privilegio
				+  "]";
	}
	
}
