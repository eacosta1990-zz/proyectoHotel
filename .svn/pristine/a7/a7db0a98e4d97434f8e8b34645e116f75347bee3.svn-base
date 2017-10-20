package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.TicketConsumoItemDao;
import datos.Consumo;
import datos.Estado;
import datos.Frigobar;
import datos.TicketConsumo;
import datos.TicketConsumoItem;

public class TicketConsumoItemABM {
	TicketConsumoItemDao dao = new TicketConsumoItemDao();

	public TicketConsumoItem traerTicketConsumoItem(int idTicketConsumoItem) {
		TicketConsumoItem c = dao.traerTicketConsumoItem(idTicketConsumoItem);
		// implementar si c es null lanzar Exception
		return c;
	}

	public TicketConsumoItem traerTicketConsumoItem(long dni) {
		TicketConsumoItem c = dao.traerTicketConsumoItem(dni);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(int cantidad, float precio, TicketConsumo ticketConsumo, Consumo consumo) {
		// consultar si existe un TicketConsumoItem con el mismo dni, si existe arrojar la
		// Excepcion
		TicketConsumoItem c = new TicketConsumoItem(cantidad, precio, ticketConsumo, consumo);

		return dao.agregar(c);
	}

	public void modificar(TicketConsumoItem c) {
		/*
		 * implementar antes de actualizar que no exista un TicketConsumoItem con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(long idTicketConsumoItem) {
		TicketConsumoItem c = dao.traerTicketConsumoItem(idTicketConsumoItem);
		dao.eliminar(c);
	}

	public List<TicketConsumoItem> traerTicketConsumoItem() {
		return dao.traerTicketConsumoItem();
	}
	public List<TicketConsumoItem> traerListaTicketConsumoItem(int idTicketConsumo,int consumo) {
		return dao.traerListaTicketConsumoItem(idTicketConsumo, consumo);
	}
	

}
