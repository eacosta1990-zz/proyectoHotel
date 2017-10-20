package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.TicketMantenimiento;
import datos.TipoMantenimiento;
import funciones.Funciones;
import negocio.TicketMantenimientoABM;
import negocio.TipoMantenimientoABM;
import negocio.Facade;
import negocio.LoginABM;

public class ControladorModificarTicketMantenimiento extends HttpServlet {
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
			TipoMantenimientoABM TipoMantenimientoabm = facade.getTipoMantenimientoABM();
			LoginABM loginabm = facade.getLoginABM();

			List<TipoMantenimiento> ListaTipoMantenimiento = TipoMantenimientoabm.traerTipoMantenimiento();
			request.setAttribute("ListaTipoMantenimiento", ListaTipoMantenimiento);

		
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				
				try{
					TicketMantenimiento TicketMantenimiento = TicketMantenimientoabm.traerTicketMantenimiento(id);
					
					if(request.getParameter("problema") != null){
						String problema =request.getParameter("problema");
						float precio = Float.parseFloat(request.getParameter("precio"));
						GregorianCalendar fechaInicio=Funciones.obtenerFecha(request.getParameter("fechaInicio"));
						GregorianCalendar fechaResolucion=Funciones.obtenerFecha(request.getParameter("fechaResolucion"));
						Boolean terminado=Boolean.parseBoolean(request.getParameter("terminado"));
						int idTipoMantenimiento=Integer.parseInt(request.getParameter("idTipoMantenimiento"));
						int idLogin=Integer.parseInt(request.getParameter("idLogin"));

						TicketMantenimiento.setProblema(problema);
						TicketMantenimiento.setPrecio(precio);
						TicketMantenimiento.setFechaInicio(fechaInicio);
						TicketMantenimiento.setFechaResolucion(fechaResolucion);
						TicketMantenimiento.setTerminado(terminado);
						TicketMantenimiento.setTipoMantenimiento(TipoMantenimientoabm.traerTipoMantenimiento(idTipoMantenimiento));
						TicketMantenimiento.setLogin(loginabm.traerLogin(idLogin));


						
						
						try{
							TicketMantenimientoabm.modificar(TicketMantenimiento);
							
						} catch (Exception e) {
							HttpSession session = request.getSession();
							session.setAttribute("msgErr", "No se puede guardar el registro");
						}
						
						request.setAttribute("insert_hecho", "OK");
						
					}
					
					
					
					request.setAttribute("ticketMantenimiento", TicketMantenimiento);
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede traer el registro");
				}
				
			}
			
			
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaTicketMantenimiento.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}






