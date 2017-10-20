package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Estadia;



public class EstadiaDao {

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

	public int agregar(Estadia objeto) {
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

	public void actualizar(Estadia objeto) throws HibernateException {
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

	public void eliminar(Estadia objeto) throws HibernateException {
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

	public Estadia traerEstadia(long id) throws HibernateException {
		/*Estadia objeto = null;
		try {
			iniciaOperacion();
			objeto = (Estadia) session.get(Estadia.class, idEstadia);
		} finally {
			session.close();
		}
		return objeto;
		*/
		
		Estadia objeto = null;
		try {
			iniciaOperacion();
			objeto = (Estadia) session.createQuery("from Estadia c where c.id=" + id ).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}


	@SuppressWarnings("unchecked")
	public List<Estadia> traerEstadia() throws HibernateException {
		List<Estadia> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Estadia c ").list();

		} finally {
			session.close();
		}
		return lista;
	}
	/*
	public Estadia traerEstadiaYEstadia(long idEstadia) throws HibernateException {
		 Estadia objeto = null;
		 try {
			 iniciaOperacion();
			 String hql="from Estadia c where c.idEstadia ="+idEstadia;
			 objeto=(Estadia) session.createQuery(hql).uniqueResult();
			 //Hibernate.initialize(objeto.getPrestamos());
		 } finally {
			session.close();
		 }
		 return objeto;
	 }
*/
}
