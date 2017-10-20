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
import datos.TipoHabitacion;
import negocio.TipoEmpleadoABM;
import negocio.TipoHabitacionABM;
import negocio.Facade;
import negocio.HabitacionABM;

public class ControladorVistaHabitacionPorTipo extends HttpServlet {
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
			TipoHabitacionABM tipoHabitacionabm = facade.getTipoHabitacionABM();

		
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				int capa = Integer.parseInt(request.getParameter("capa"));

				TipoHabitacion tipoHabitacion=tipoHabitacionabm.traerTipoHabitacion(id);
				List<Habitacion> Habitacion = Habitacionabm.traerHabitacionPorTipo(id,capa);
				
				request.setAttribute("id", Habitacion);
				request.setAttribute("capa", capa);

				
			}

			response.setStatus(200);

			request.getRequestDispatcher("/vistaHabitacion.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}

