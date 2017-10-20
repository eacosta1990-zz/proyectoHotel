package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Estadia;
import datos.TipoEmpleado;
import negocio.TipoEmpleadoABM;
import negocio.Facade;
import negocio.EstadiaABM;

public class ControladorEstadia extends HttpServlet {
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
			EstadiaABM Estadiaabm = facade.getEstadiaABM();
			
			if(request.getParameter("id") == null){
				List<Estadia> LEstadia = Estadiaabm.traerEstadia();
				request.setAttribute("ListaEstadia", LEstadia);
				
			}
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				Estadia estadia = Estadiaabm.traerEstadia(id);
				request.setAttribute("estadia", estadia);
				
			}
			
			response.setStatus(200);


			request.getRequestDispatcher("/estadia.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}

