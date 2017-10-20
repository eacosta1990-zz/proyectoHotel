package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.TicketMantenimientoDao;
import datos.Login;
import datos.TicketMantenimiento;
import datos.TipoMantenimiento;

public class TicketMantenimientoABM {
	TicketMantenimientoDao dao = new TicketMantenimientoDao();

	
	public TicketMantenimiento traerTicketMantenimiento(int id) {
		TicketMantenimiento c = dao.traerTicketMantenimiento(id);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(String problema,GregorianCalendar fechaInicio,float precio,GregorianCalendar fechaResolucion,boolean terminado,Login login,TipoMantenimiento tipoMantenimiento) {
		// consultar si existe un TicketMantenimiento con el mismo dni, si existe arrojar la
		// Excepcion
		TicketMantenimiento c = new TicketMantenimiento(problema,fechaInicio,precio,fechaResolucion,terminado,login, tipoMantenimiento);

		return dao.agregar(c);
	}

	public void modificar(TicketMantenimiento c) {
	
		dao.actualizar(c);
	}

	public void eliminar(int idTicketMantenimiento) {
		TicketMantenimiento c = dao.traerTicketMantenimiento(idTicketMantenimiento);
		dao.eliminar(c);
	}

	public List<TicketMantenimiento> traerTicketMantenimiento() {
		return dao.traerTicketMantenimiento();
	}
}