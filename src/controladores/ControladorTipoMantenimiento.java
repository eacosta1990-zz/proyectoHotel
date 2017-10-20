package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.TipoMantenimiento;
import negocio.TipoMantenimientoABM;
import negocio.Facade;

public class ControladorTipoMantenimiento extends HttpServlet {
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
			TipoMantenimientoABM TipoMantenimientoabm = facade.getTipoMantenimientoABM();
			
			if(request.getParameter("id") == null){
				List<TipoMantenimiento> LTipoMantenimiento = TipoMantenimientoabm.traerTipoMantenimiento();
				request.setAttribute("ListatipoMantenimiento", LTipoMantenimiento);
				
			}
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				TipoMantenimiento TipoMantenimiento = TipoMantenimientoabm.traerTipoMantenimiento(id);
				request.setAttribute("tipoMantenimiento", TipoMantenimiento);
				
			}
			
			response.setStatus(200);


			request.getRequestDispatcher("/tipoMantenimiento.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}

