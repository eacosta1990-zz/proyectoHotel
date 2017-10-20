package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.EstadiaDao;
import datos.Estadia;
import datos.Estado;
import datos.Frigobar;

public class EstadiaABM {
	EstadiaDao dao = new EstadiaDao();

	public Estadia traerEstadia(int idEstadia) {
		Estadia c = dao.traerEstadia(idEstadia);
		// implementar si c es null lanzar Exception
		return c;
	}

	public Estadia traerEstadia(long dni) {
		Estadia c = dao.traerEstadia(dni);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(GregorianCalendar fechaDesde, GregorianCalendar fechaHasta, float senia,
			GregorianCalendar fechaReserva, float precio, Estado estado, Frigobar frigobar) {
		// consultar si existe un Estadia con el mismo dni, si existe arrojar la
		// Excepcion
		Estadia c = new Estadia(fechaDesde, fechaHasta, senia, fechaReserva, precio, estado, frigobar);

		return dao.agregar(c);
	}

	public void modificar(Estadia c) {
		/*
		 * implementar antes de actualizar que no exista un Estadia con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(long idEstadia) {
		Estadia c = dao.traerEstadia(idEstadia);
		dao.eliminar(c);
	}

	public List<Estadia> traerEstadia() {
		return dao.traerEstadia();
	}
	
	/*
	public Estadia traerEstadiaYEstadia(long idEstadia) {
		Estadia c = dao.traerEstadiaYEstadia(idEstadia);
		// implementar si c es null lanzar Exception
		return c;
	}
	*/
}
