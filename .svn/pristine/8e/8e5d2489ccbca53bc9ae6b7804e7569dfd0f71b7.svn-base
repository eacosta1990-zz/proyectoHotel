package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.TicketConsumoDao;
import datos.TicketConsumo;
import datos.Estadia;
import datos.Estado;
import datos.Frigobar;
import datos.Login;

public class TicketConsumoABM {
	TicketConsumoDao dao = new TicketConsumoDao();

	public TicketConsumo traerTicketConsumo(int idTicketConsumo) {
		TicketConsumo c = dao.traerTicketConsumo(idTicketConsumo);
		// implementar si c es null lanzar Exception
		return c;
	}

	public TicketConsumo traerTicketConsumo(long dni) {
		TicketConsumo c = dao.traerTicketConsumo(dni);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(int nroFactura, GregorianCalendar fecha, boolean firmado,Estadia estadia, Login login) {
		// consultar si existe un TicketConsumo con el mismo dni, si existe arrojar la
		// Excepcion
		TicketConsumo c = new TicketConsumo(fecha,firmado,nroFactura,estadia,login);

		return dao.agregar(c);
	}

	public void modificar(TicketConsumo c) {
		/*
		 * implementar antes de actualizar que no exista un TicketConsumo con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(long idTicketConsumo) {
		TicketConsumo c = dao.traerTicketConsumo(idTicketConsumo);
		dao.eliminar(c);
	}

	public List<TicketConsumo> traerTicketConsumo() {
		return dao.traerTicketConsumo();
	}
	
	/*
	public TicketConsumo traerTicketConsumoYTicketConsumo(long idTicketConsumo) {
		TicketConsumo c = dao.traerTicketConsumoYTicketConsumo(idTicketConsumo);
		// implementar si c es null lanzar Exception
		return c;
	}
	*/
}
