package negocio;

import java.util.List;

import dao.ConsumoDao;
import datos.Consumo;

public class ConsumoABM {
	ConsumoDao dao = new ConsumoDao();

	
	public Consumo traerConsumo(int id) {
		Consumo c = dao.traerConsumo(id);
		// implementar si c es null lanzar Exception
		return c;
	}

	public int agregar(String consumo, float precio) {
		// consultar si existe un Consumo con el mismo dni, si existe arrojar la
		// Excepcion
		Consumo c = new Consumo(consumo,precio);

		return dao.agregar(c);
	}

	public void modificar(Consumo c) {
		/*
		 * implementar antes de actualizar que no exista un Consumo con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(int idConsumo) {
		Consumo c = dao.traerConsumo(idConsumo);
		dao.eliminar(c);
	}

	public List<Consumo> traerConsumo() {
		return dao.traerConsumo();
	}
}