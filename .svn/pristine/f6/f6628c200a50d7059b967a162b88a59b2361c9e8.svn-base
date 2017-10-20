package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Habitacion;

public class HabitacionDao {

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

	public int agregar(Habitacion objeto) {
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

	public void actualizar(Habitacion objeto) throws HibernateException {
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

	public void eliminar(Habitacion objeto) throws HibernateException {
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

	public Habitacion traerHabitacion(int id) throws HibernateException {
		Habitacion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Habitacion) session.get(Habitacion.class, id);
		} finally {
			session.close();
		}
		return objeto;
	}


	@SuppressWarnings("unchecked")
	public List<Habitacion> traerHabitacion() throws HibernateException {
		List<Habitacion> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Habitacion c").list();

		} finally {
			session.close();
		}
		return lista;
	}
	public List<Habitacion> traerHabitacionDisponible() throws HibernateException {
		List<Habitacion> lista = null;
		int estado=1;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Habitacion c where c.disponible="+estado).list();

		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Habitacion> traerHabitacionPorTipo(int tipo,int capacidad) throws HibernateException {
		List<Habitacion> lista = null;
		int estado=1;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Habitacion h where h.tipoHabitacion="+tipo+"and h.disponible="+estado+"and h.capacidadMax="+capacidad).list();

		} finally {
			session.close();
		}
		return lista;
	}

}