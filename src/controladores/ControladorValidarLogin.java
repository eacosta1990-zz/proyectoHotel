package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Login;
import negocio.Facade;
import negocio.LoginABM;

public class ControladorValidarLogin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			Facade facade = new Facade();
			
			String clave =(request.getParameter("clave"));
			String usuario =(request.getParameter("usuario"));
			
			LoginABM loginabm= facade.getLoginABM();
			Login login = loginabm.traerLogin(usuario, clave);
			response.setStatus(200);
			
			request.setAttribute("login", login);
			
			HttpSession session = request.getSession();
			session.setAttribute("idLogin", login.getIdLogin());
			session.setAttribute("nomLogin", login.getUsuario());
			session.setAttribute("privilegio", login.getPrivilegio());
			
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		} catch (Exception e) {
			HttpSession session = request.getSession();
			session.setAttribute("msgErr", "Usuario o contraseña incorrectos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
			// response.sendError(500, "Usuario o contraseña incorrectos.");
		}
	}
}
