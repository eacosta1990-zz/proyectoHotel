package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.TipoHabitacion;
import datos.TipoHabitacion;
import negocio.TipoHabitacionABM;
import negocio.Facade;

public class ControladorTipoHabitacion extends HttpServlet {
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
			
			if(request.getParameter("id") == null){
				List<TipoHabitacion> LTipoHabitacion = TipoHabitacionabm.traerTipoHabitacion();
				request.setAttribute("ListatipoHabitacion", LTipoHabitacion);
				
			}
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				TipoHabitacion tipoHabitacion = TipoHabitacionabm.traerTipoHabitacion(id);
				request.setAttribute("tipoHabitacion", tipoHabitacion);
				
			}
			
			response.setStatus(200);


			request.getRequestDispatcher("/tipoHabitacion.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}

