package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.TicketMantenimiento;
import datos.TipoEmpleado;
import negocio.TipoEmpleadoABM;
import negocio.Facade;
import negocio.TicketMantenimientoABM;

public class ControladorTicketMantenimiento extends HttpServlet {
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
			
			if(request.getParameter("id") == null){
				List<TicketMantenimiento> LTicketMantenimiento = TicketMantenimientoabm.traerTicketMantenimiento();
				request.setAttribute("ListaTicketMantenimiento", LTicketMantenimiento);
				
			}
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				TicketMantenimiento TicketMantenimiento = TicketMantenimientoabm.traerTicketMantenimiento(id);
				request.setAttribute("TicketMantenimiento", TicketMantenimiento);
				
			}
			
			response.setStatus(200);


			request.getRequestDispatcher("/ticketMantenimiento.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}

