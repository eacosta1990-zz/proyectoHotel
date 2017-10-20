package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.FormaPagoDao;
import datos.Cliente;
import datos.Estadia;
import datos.FormaPago;
import datos.FormaPago;
import datos.Login;

public class FormaPagoABM {
	FormaPagoDao dao = new FormaPagoDao();

	
	public FormaPago traerFormaPago(int id) {
		FormaPago c = dao.traerFormaPago(id);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(String formaPago) {
		// consultar si existe un FormaPago con el mismo dni, si existe arrojar la
		// Excepcion
		FormaPago c = new FormaPago(formaPago);

		return dao.agregar(c);
	}

	public void modificar(FormaPago c) {
		/*
		 * implementar antes de actualizar que no exista un FormaPago con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(int idFormaPago) {
		FormaPago c = dao.traerFormaPago(idFormaPago);
		dao.eliminar(c);
	}

	public List<FormaPago> traerFormaPago() {
		return dao.traerFormaPago();
	}
}