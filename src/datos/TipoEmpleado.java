package datos;

import java.util.Set;

public class TipoEmpleado {
	private int idTipoEmpleado;
	private String tipoEmpleado;
	private Set<Empleado> empleado;
	
	public TipoEmpleado() {}

	public TipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public int getIdTipoEmpleado() {
		return idTipoEmpleado;
	}

	protected void setIdTipoEmpleado(int idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public String getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public Set<Empleado> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Set<Empleado> empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "TipoEmpleado [idTipoEmpleado=" + idTipoEmpleado + ", tipoEmpleado=" + tipoEmpleado + "]";
	}


	
}
