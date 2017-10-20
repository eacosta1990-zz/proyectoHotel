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

public class ControladorModificarTipoMantenimiento extends HttpServlet {
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
				int id = Integer.parseInt(request.getParameter("id"));
				
				try{
					TipoMantenimiento TipoMantenimiento = TipoMantenimientoabm.traerTipoMantenimiento(id);
					
					if(request.getParameter("tipoMantenimiento") != null){
						String tipoMantenimiento = (String) request.getParameter("tipoMantenimiento");
						TipoMantenimiento.setTipoMantenimiento(tipoMantenimiento);
						
						try{
							TipoMantenimientoabm.modificar(TipoMantenimiento);
							
						} catch (Exception e) {
							HttpSession session = request.getSession();
							session.setAttribute("msgErr", "No se puede guardar el registro");
						}
						
						request.setAttribute("insert_hecho", "OK");
						
					}
					
					
					
					request.setAttribute("TipoMantenimiento", TipoMantenimiento);
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede traer el registro");
				}
				
			}
			
			
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaTipoMantenimiento.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}






