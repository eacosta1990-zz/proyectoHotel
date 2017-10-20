package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Empleado;
import datos.TipoEmpleado;
import negocio.TipoEmpleadoABM;
import negocio.Facade;
import negocio.EmpleadoABM;

public class ControladorEmpleado extends HttpServlet {
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
			EmpleadoABM Empleadoabm = facade.getEmpleadoABM();
			
			if(request.getParameter("id") == null){
				List<Empleado> LEmpleado = Empleadoabm.traerEmpleado();
				request.setAttribute("ListaEmpleado", LEmpleado);
				
			}
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				Empleado empleado = Empleadoabm.traerEmpleado(id);
				request.setAttribute("empleado", empleado);
				
			}
			
			response.setStatus(200);


			request.getRequestDispatcher("/empleado.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}

