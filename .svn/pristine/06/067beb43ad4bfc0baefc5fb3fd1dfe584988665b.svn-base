package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TicketConsumo;



public class TicketConsumoDao {

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

	public int agregar(TicketConsumo objeto) {
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

	public void actualizar(TicketConsumo objeto) throws HibernateException {
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

	public void eliminar(TicketConsumo objeto) throws HibernateException {
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

	public TicketConsumo traerTicketConsumo(long id) throws HibernateException {
		/*TicketConsumo objeto = null;
		try {
			iniciaOperacion();
			objeto = (TicketConsumo) session.get(TicketConsumo.class, idTicketConsumo);
		} finally {
			session.close();
		}
		return objeto;
		*/
		
		TicketConsumo objeto = null;
		try {
			iniciaOperacion();
			objeto = (TicketConsumo) session.createQuery("from TicketConsumo c where c.id=" + id ).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}


	@SuppressWarnings("unchecked")
	public List<TicketConsumo> traerTicketConsumo() throws HibernateException {
		List<TicketConsumo> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from TicketConsumo c ").list();

		} finally {
			session.close();
		}
		return lista;
	}
	/*
	public TicketConsumo traerTicketConsumoYTicketConsumo(long idTicketConsumo) throws HibernateException {
		 TicketConsumo objeto = null;
		 try {
			 iniciaOperacion();
			 String hql="from TicketConsumo c where c.idTicketConsumo ="+idTicketConsumo;
			 objeto=(TicketConsumo) session.createQuery(hql).uniqueResult();
			 //Hibernate.initialize(objeto.getPrestamos());
		 } finally {
			session.close();
		 }
		 return objeto;
	 }
*/
}
