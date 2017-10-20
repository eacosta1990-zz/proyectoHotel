package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.TipoEmpleado;
import negocio.TipoEmpleadoABM;
import negocio.Facade;

public class ControladorAltaTipoEmpleado extends HttpServlet {
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
			TipoEmpleadoABM TipoEmpleadoabm = facade.getTipoEmpleadoABM();
		
			if(request.getParameter("nombre") != null){
				// eliminar registro
				String nombre = (String) request.getParameter("nombre");
				int id_insert = 0;
				
				try{
					id_insert = TipoEmpleadoabm.agregar(nombre);
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede agregar el registro");
				}
				
				request.setAttribute("insert_hecho", "OK");
				
			}
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaTipoEmpleado.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}



