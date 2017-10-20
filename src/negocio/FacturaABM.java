package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.FacturaDao;
import datos.Cliente;
import datos.Estadia;
import datos.Factura;
import datos.FormaPago;
import datos.Login;

public class FacturaABM {
	FacturaDao dao = new FacturaDao();

	
	public Factura traerFactura(int id) {
		Factura c = dao.traerFactura(id);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(int nroFactura, GregorianCalendar fecha,boolean estado,FormaPago formaPago,Cliente cliente,Login login,Estadia estadia) {
		// consultar si existe un Factura con el mismo dni, si existe arrojar la
		// Excepcion
		Factura c = new Factura(nroFactura,fecha,estado,formaPago,cliente,login,estadia);

		return dao.agregar(c);
	}

	public void modificar(Factura c) {
		/*
		 * implementar antes de actualizar que no exista un Factura con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(int idFactura) {
		Factura c = dao.traerFactura(idFactura);
		dao.eliminar(c);
	}

	public List<Factura> traerFactura() {
		return dao.traerFactura();
	}
}