package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.TipoMantenimiento;
import negocio.TipoMantenimientoABM;
import negocio.Facade;

public class ControladorAltaTipoMantenimiento extends HttpServlet {
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
		
			if(request.getParameter("tipoMantenimiento") != null){
				// eliminar registro
				String tipoMantenimiento = (String) request.getParameter("tipoMantenimiento");
				int id_insert = 0;
				
				try{
					id_insert = TipoMantenimientoabm.agregar(tipoMantenimiento);
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede agregar el registro");
				}
				
				request.setAttribute("insert_hecho", "OK");
				
			}
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaTipoMantenimiento.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}



