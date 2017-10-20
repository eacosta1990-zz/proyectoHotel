package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Hotel;

public class HotelDao {

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


	public Hotel traerHotel(int id) throws HibernateException {
		Hotel objeto = null;
		try {
			iniciaOperacion();
			objeto = (Hotel) session.get(Hotel.class, id);
		} finally {
			session.close();
		}
		return objeto;
	}


	@SuppressWarnings("unchecked")
	public List<Hotel> traerHotel() throws HibernateException {
		List<Hotel> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Hotel c").list();

		} finally {
			session.close();
		}
		return lista;
	}

}