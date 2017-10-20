package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.TicketMantenimiento;
import negocio.TicketMantenimientoABM;
import negocio.Facade;

public class ControladorEliminarTicketMantenimiento extends HttpServlet {
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
			TicketMantenimientoABM TicketMantenimientoabm = facade.getTicketMantenimientoABM();
		
			if(request.getParameter("id") != null){
				// eliminar registro
				int id = Integer.parseInt(request.getParameter("id"));
				try{
					TicketMantenimientoabm.eliminar(id);
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede eliminar el registro");
				}
				
				List<TicketMantenimiento> LTicketMantenimiento = TicketMantenimientoabm.traerTicketMantenimiento();
				request.setAttribute("LTicketMantenimiento", LTicketMantenimiento);
				
			}
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/ticketMantenimiento.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}



