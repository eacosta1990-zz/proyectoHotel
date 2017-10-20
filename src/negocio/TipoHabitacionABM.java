package negocio;

import java.util.List;

import dao.TipoHabitacionDao;
import datos.TipoHabitacion;

public class TipoHabitacionABM {
	TipoHabitacionDao dao = new TipoHabitacionDao();

	
	public TipoHabitacion traerTipoHabitacion(int id) {
		TipoHabitacion c = dao.traerTipoHabitacion(id);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(String tipoHabitacion, String descripcion, float precio) {
		// consultar si existe un TipoHabitacion con el mismo dni, si existe arrojar la
		// Excepcion
		TipoHabitacion c = new TipoHabitacion(tipoHabitacion, descripcion, precio);

		return dao.agregar(c);
	}

	public void modificar(TipoHabitacion c) {
		/*
		 * implementar antes de actualizar que no exista un TipoHabitacion con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(int idTipoHabitacion) {
		TipoHabitacion c = dao.traerTipoHabitacion(idTipoHabitacion);
		dao.eliminar(c);
	}

	public List<TipoHabitacion> traerTipoHabitacion() {
		return dao.traerTipoHabitacion();
	}
}