package negocio;

import java.util.List;

import dao.EmpleadoDao;
import datos.Empleado;
import datos.TipoEmpleado;

public class EmpleadoABM {
	EmpleadoDao dao = new EmpleadoDao();

	public Empleado traerEmpleado(int idEmpleado) {
		Empleado c = dao.traerEmpleado(idEmpleado);
		// implementar si c es null lanzar Exception
		return c;
	}


	public int agregar(String nombre, String apellido,long dni, String telefono, String direccion,
			String email, String nroLegajo, float sueldo,TipoEmpleado tipo) {
		// consultar si existe un Empleado con el mismo dni, si existe arrojar la
		// Excepcion
		Empleado c = new Empleado(nombre, apellido, telefono, direccion, dni, email, nroLegajo, sueldo,tipo);

		return dao.agregar(c);
	}

	public void modificar(Empleado c) {
		/*
		 * implementar antes de actualizar que no exista un Empleado con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(int idEmpleado) {
		Empleado c = dao.traerEmpleado(idEmpleado);
		dao.eliminar(c);
	}

	public List<Empleado> traerEmpleado() {
		return dao.traerEmpleado();
	}
	
	/*
	public Empleado traerEmpleadoYEmpleado(long idEmpleado) {
		Empleado c = dao.traerEmpleadoYEmpleado(idEmpleado);
		// implementar si c es null lanzar Exception
		return c;
	}
	*/
}
