package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ServicioDao;
import datos.Servicio;
import datos.Estado;
import datos.Frigobar;
import datos.Hotel;

public class ServicioABM {
	ServicioDao dao = new ServicioDao();

	public Servicio traerServicio(int idServicio) {
		Servicio c = dao.traerServicio(idServicio);
		// implementar si c es null lanzar Exception
		return c;
	}

	public Servicio traerServicio(long dni) {
		Servicio c = dao.traerServicio(dni);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(String servicio,String descripcion,boolean incluido,boolean disponible,float precio) {
		// consultar si existe un Servicio con el mismo dni, si existe arrojar la
		// Excepcion
		HotelABM hotelabm=new HotelABM();
		Hotel hotel =hotelabm.traerHotel(1);
		Servicio c = new Servicio(hotel,servicio, descripcion, incluido, disponible, precio);

		return dao.agregar(c);
	}

	public void modificar(Servicio c) {
		/*
		 * implementar antes de actualizar que no exista un Servicio con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(long idServicio) {
		Servicio c = dao.traerServicio(idServicio);
		dao.eliminar(c);
	}

	public List<Servicio> traerServicio() {
		return dao.traerServicio();
	}
	
	/*
	public Servicio traerServicioYServicio(long idServicio) {
		Servicio c = dao.traerServicioYServicio(idServicio);
		// implementar si c es null lanzar Exception
		return c;
	}
	*/
}
