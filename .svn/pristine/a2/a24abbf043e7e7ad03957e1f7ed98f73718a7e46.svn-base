package negocio;

import java.util.List;

import org.hibernate.HibernateException;

import dao.FrigobarItemDao;
import datos.Consumo;
import datos.Frigobar;
import datos.FrigobarItem;


public class FrigobarItemABM {
	FrigobarItemDao dao = new FrigobarItemDao();

	public FrigobarItem traerFrigobarItem(int idFrigobarItem) {
		FrigobarItem c = dao.traerFrigobarItem(idFrigobarItem);
		return c;
	}

	public int agregar(int stockExistente,int stockDeseable,Consumo consumo,Frigobar frigobar) {
		
		FrigobarItem c = new FrigobarItem(stockExistente,stockDeseable,consumo,frigobar);

		return dao.agregar(c);
	}

	public void modificar(FrigobarItem c) {
		/*
		 * implementar antes de actualizar que no exista un FrigobarItem con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(int idFrigobarItem) {
		FrigobarItem c = dao.traerFrigobarItem(idFrigobarItem);
		dao.eliminar(c);
	}

	public List<FrigobarItem> traerFrigobarItem() {
		return dao.traerFrigobarItem();
	}
	

}
