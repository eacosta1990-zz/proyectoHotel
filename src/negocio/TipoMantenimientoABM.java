package negocio;

import java.util.List;

import dao.TipoMantenimientoDao;
import datos.TipoMantenimiento;

public class TipoMantenimientoABM {
	TipoMantenimientoDao dao = new TipoMantenimientoDao();

	
	public TipoMantenimiento traerTipoMantenimiento(int id) {
		TipoMantenimiento c = dao.traerTipoMantenimiento(id);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(String TipoMantenimiento) {
		// consultar si existe un TipoMantenimiento con el mismo dni, si existe arrojar la
		// Excepcion
		TipoMantenimiento c = new TipoMantenimiento(TipoMantenimiento);

		return dao.agregar(c);
	}

	public void modificar(TipoMantenimiento c) {
		/*
		 * implementar antes de actualizar que no exista un TipoMantenimiento con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(int idTipoMantenimiento) {
		TipoMantenimiento c = dao.traerTipoMantenimiento(idTipoMantenimiento);
		dao.eliminar(c);
	}

	public List<TipoMantenimiento> traerTipoMantenimiento() {
		return dao.traerTipoMantenimiento();
	}
}