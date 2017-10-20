package negocio;
import java.util.List;

import dao.LoginDao;
import datos.Empleado;
import datos.Login;

public class LoginABM {
	LoginDao dao = new LoginDao();


	public Login traerLogin(int id) {
		Login c = dao.traerLogin(id);
		// implementar si c es null lanzar Exception
		return c;
	}
	public Login traerLogin(String usuario, String clave) throws Exception {
		Login c = dao.traerLogin(usuario, clave);
		if(c == null){
			throw new Exception("No hay resultados.");
		}
		return c;
	}


	public int agregar(String usuario, String clave, int privilegio) {
		// consultar si existe un Login con el mismo dni, si existe arrojar la
		// Excepcion
		Login c = new Login(usuario, clave, privilegio);

		return dao.agregar(c);
	}

	public void modificar(Login c) {
		/*
		 * implementar antes de actualizar que no exista un Login con el mismo
		 * documento a modificar y con el mismo id, lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(int idLogin) {
		Login c = dao.traerLogin(idLogin);
		dao.eliminar(c);
	}

	public List<Login> traerLogin() {
		return dao.traerLogin();
	}
	
	public Login traerLoginYEmpleado(long idLogin) {
		Login c = dao.traerLoginYEmpleado(idLogin);
		// implementar si c es null lanzar Exception
		return c;
	}
}