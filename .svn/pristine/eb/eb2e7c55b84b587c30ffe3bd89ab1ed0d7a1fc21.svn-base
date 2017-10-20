package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Servicio;



public class ServicioDao {

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

	public int agregar(Servicio objeto) {
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

	public void actualizar(Servicio objeto) throws HibernateException {
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

	public void eliminar(Servicio objeto) throws HibernateException {
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

	public Servicio traerServicio(long id) throws HibernateException {
		/*Servicio objeto = null;
		try {
			iniciaOperacion();
			objeto = (Servicio) session.get(Servicio.class, idServicio);
		} finally {
			session.close();
		}
		return objeto;
		*/
		
		Servicio objeto = null;
		try {
			iniciaOperacion();
			objeto = (Servicio) session.createQuery("from Servicio c where c.id=" + id ).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}


	@SuppressWarnings("unchecked")
	public List<Servicio> traerServicio() throws HibernateException {
		List<Servicio> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Servicio c ").list();

		} finally {
			session.close();
		}
		return lista;
	}
	/*
	public Servicio traerServicioYServicio(long idServicio) throws HibernateException {
		 Servicio objeto = null;
		 try {
			 iniciaOperacion();
			 String hql="from Servicio c where c.idServicio ="+idServicio;
			 objeto=(Servicio) session.createQuery(hql).uniqueResult();
			 //Hibernate.initialize(objeto.getPrestamos());
		 } finally {
			session.close();
		 }
		 return objeto;
	 }
*/
}
