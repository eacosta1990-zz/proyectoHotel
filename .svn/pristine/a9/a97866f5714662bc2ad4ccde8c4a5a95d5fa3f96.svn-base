package negocio;

import java.util.List;

import org.hibernate.HibernateException;

import dao.FrigobarDao;
import datos.Frigobar;
import datos.Frigobar;


public class FrigobarABM {
	FrigobarDao dao = new FrigobarDao();

	public Frigobar traerFrigobar(int idFrigobar) {
		Frigobar c = dao.traerFrigobar(idFrigobar);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(String frigobar) {
		// consultar si existe un Frigobar con el mismo dni, si existe arrojar la
		// Excepcion
		Frigobar c = new Frigobar();

		return dao.agregar(c);
	}

	public void modificar(Frigobar c) {
		/*
		 * implementar antes de actualizar que no exista un Frigobar con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(int idFrigobar) {
		Frigobar c = dao.traerFrigobar(idFrigobar);
		dao.eliminar(c);
	}

	public List<Frigobar> traerFrigobar() {
		return dao.traerFrigobar();
	}
	

}
