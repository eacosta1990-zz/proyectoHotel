package negocio;

import java.util.List;

import dao.TipoEmpleadoDao;
import datos.TipoEmpleado;

public class TipoEmpleadoABM {
	TipoEmpleadoDao dao = new TipoEmpleadoDao();

	
	public TipoEmpleado traerTipoEmpleado(int id) {
		TipoEmpleado c = dao.traerTipoEmpleado(id);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(String tipoEmpleado) {
		// consultar si existe un TipoEmpleado con el mismo dni, si existe arrojar la
		// Excepcion
		TipoEmpleado c = new TipoEmpleado(tipoEmpleado);

		return dao.agregar(c);
	}

	public void modificar(TipoEmpleado c) {
		/*
		 * implementar antes de actualizar que no exista un TipoEmpleado con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(int idTipoEmpleado) {
		TipoEmpleado c = dao.traerTipoEmpleado(idTipoEmpleado);
		dao.eliminar(c);
	}

	public List<TipoEmpleado> traerTipoEmpleado() {
		return dao.traerTipoEmpleado();
	}
}