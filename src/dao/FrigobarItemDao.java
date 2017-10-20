package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.FrigobarItem;

public class FrigobarItemDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(FrigobarItem objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();

		}
		return id;
	}

	public void actualizar(FrigobarItem objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {

			session.close();
		}
	}

	public void eliminar(FrigobarItem objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}


	public FrigobarItem traerFrigobarItem(int id) throws HibernateException {
		FrigobarItem objeto = null;
		try {
			iniciaOperacion();
			objeto = (FrigobarItem) session.createQuery("from FrigobarItem c where c.id=" + id).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<FrigobarItem> traerFrigobarItem() throws HibernateException {
		List<FrigobarItem> lista = null;
		try {
			iniciaOperacion();

			lista = session.createQuery("from FrigobarItem c order by c.frigobar  asc  ").list();

		} finally {
			session.close();
		}
		return lista;
	
	 }
	

}
