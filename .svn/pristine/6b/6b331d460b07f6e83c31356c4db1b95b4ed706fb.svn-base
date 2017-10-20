package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.TipoMantenimiento;
import negocio.TipoMantenimientoABM;
import negocio.Facade;

public class ControladorEliminarTipoMantenimiento extends HttpServlet {
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
		
			if(request.getParameter("id") != null){
				// eliminar registro
				int id = Integer.parseInt(request.getParameter("id"));
				try{
					TipoMantenimientoabm.eliminar(id);
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede eliminar el registro");
				}
				
				List<TipoMantenimiento> LTipoMantenimiento = TipoMantenimientoabm.traerTipoMantenimiento();
				request.setAttribute("ListatipoMantenimiento", LTipoMantenimiento);
				
			}
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/tipoMantenimiento.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}



