package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.TipoHabitacion;
import negocio.TipoHabitacionABM;
import negocio.Facade;

public class ControladorEliminarTipoHabitacion extends HttpServlet {
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
			TipoHabitacionABM TipoHabitacionabm = facade.getTipoHabitacionABM();
		
			if(request.getParameter("id") != null){
				// eliminar registro
				int id = Integer.parseInt(request.getParameter("id"));
				try{
					TipoHabitacionabm.eliminar(id);
					HttpSession session = request.getSession();
					session.setAttribute("msgOK", "Eliminado correctamente!");
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede eliminar el registro");
				}
				
				List<TipoHabitacion> LtipoHabitacion = TipoHabitacionabm.traerTipoHabitacion();
				request.setAttribute("ListatipoHabitacion", LtipoHabitacion);
				
			}
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/tipoHabitacion.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}



