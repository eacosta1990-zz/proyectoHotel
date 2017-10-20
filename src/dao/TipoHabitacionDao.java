package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TipoHabitacion;

public class TipoHabitacionDao {

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

	public int agregar(TipoHabitacion objeto) {
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

	public void actualizar(TipoHabitacion objeto) throws HibernateException {
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

	public void eliminar(TipoHabitacion objeto) throws HibernateException {
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

	public TipoHabitacion traerTipoHabitacion(int id) throws HibernateException {
		TipoHabitacion objeto = null;
		try {
			iniciaOperacion();
			objeto = (TipoHabitacion) session.get(TipoHabitacion.class, id);
			
		} finally {
			session.close();
		}
		return objeto;
	}


	@SuppressWarnings("unchecked")
	public List<TipoHabitacion> traerTipoHabitacion() throws HibernateException {
		List<TipoHabitacion> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from TipoHabitacion c").list();
		} finally {
			session.close();
		}
		return lista;
	}

}