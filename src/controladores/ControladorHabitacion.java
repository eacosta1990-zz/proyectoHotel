package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Habitacion;
import datos.TipoEmpleado;
import negocio.TipoEmpleadoABM;
import negocio.Facade;
import negocio.HabitacionABM;

public class ControladorHabitacion extends HttpServlet {
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
			HabitacionABM Habitacionabm = facade.getHabitacionABM();
			
			if(request.getParameter("id") == null){
				List<Habitacion> LHabitacion = Habitacionabm.traerHabitacion();
				request.setAttribute("ListaHabitacion", LHabitacion);
				
			}
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				Habitacion habitacion = Habitacionabm.traerHabitacion(id);
				request.setAttribute("habitacion", habitacion);
				
			}
			
			response.setStatus(200);


			request.getRequestDispatcher("/habitacion.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}

