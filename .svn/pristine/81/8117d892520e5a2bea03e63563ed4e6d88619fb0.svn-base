package negocio;

import java.util.List;

import org.hibernate.HibernateException;

import dao.EstadoDao;
import datos.Estado;
import datos.Frigobar;


public class EstadoABM {
	EstadoDao dao = new EstadoDao();

	public Estado traerEstado(int idEstado) {
		Estado c = dao.traerEstado(idEstado);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(String estado) {
		// consultar si existe un Estado con el mismo dni, si existe arrojar la
		// Excepcion
		Estado c = new Estado(estado);

		return dao.agregar(c);
	}

	public void modificar(Estado c) {
		/*
		 * implementar antes de actualizar que no exista un Estado con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(int idEstado) {
		Estado c = dao.traerEstado(idEstado);
		dao.eliminar(c);
	}

	public List<Estado> traerEstado() {
		return dao.traerEstado();
	}
	

}
