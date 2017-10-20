package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.TipoEmpleado;
import negocio.TipoEmpleadoABM;
import negocio.Facade;

public class ControladorTipoEmpleado extends HttpServlet {
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
			
			if(request.getParameter("id") == null){
				List<TipoEmpleado> LtipoEmpleado = TipoEmpleadoabm.traerTipoEmpleado();
				request.setAttribute("ListatipoEmpleado", LtipoEmpleado);
				
			}
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				TipoEmpleado tipoEmpleado = TipoEmpleadoabm.traerTipoEmpleado(id);
				request.setAttribute("tipoEmpleado", tipoEmpleado);
				
			}
			
			response.setStatus(200);


			request.getRequestDispatcher("/tipoEmpleado.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}

