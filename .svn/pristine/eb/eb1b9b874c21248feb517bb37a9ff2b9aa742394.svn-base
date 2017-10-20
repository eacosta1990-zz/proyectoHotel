package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xml.sax.helpers.ParserFactory;

import datos.Estado;
import datos.Frigobar;
import datos.Login;
import datos.TipoMantenimiento;
import funciones.Funciones;
import negocio.TicketMantenimientoABM;
import negocio.TipoMantenimientoABM;
import negocio.Facade;

import negocio.LoginABM;

public class ControladorAltaTicketMantenimiento extends HttpServlet {
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
			TicketMantenimientoABM ticketMantenimientoabm = facade.getTicketMantenimientoABM();					
			TipoMantenimientoABM tipoMantenimientoabm = facade.getTipoMantenimientoABM();
			LoginABM loginabm = facade.getLoginABM();
			
			List<TipoMantenimiento> ListaTipoMantenimiento = tipoMantenimientoabm.traerTipoMantenimiento();
			request.setAttribute("ListaTipoMantenimiento", ListaTipoMantenimiento);
			
			List<Login> ListaLogin = loginabm.traerLogin();
			request.setAttribute("ListaLogin", ListaLogin);
		
			if(request.getParameter("precio") != null){
				
				String problema = (String) request.getParameter("problema");
				GregorianCalendar fechaInicio= Funciones.obtenerFechaInvertida(request.getParameter("fechaInicio"));
				float precio= Float.parseFloat(request.getParameter("precio")); 
				GregorianCalendar fechaResolucion= Funciones.obtenerFechaInvertida(request.getParameter("fechaResolucion"));
				boolean terminado=Boolean.parseBoolean(request.getParameter("terminado"));
				int idTipoMantenimiento= Integer.parseInt(request.getParameter("idTipoMantenimiento"));
				int idLogin= Integer.parseInt(request.getParameter("idLogin"));

				

				TipoMantenimiento tipoMantenimiento= tipoMantenimientoabm.traerTipoMantenimiento(idTipoMantenimiento);
				Login login= loginabm.traerLogin(idLogin);
				
				
				int id_insert = 0;
				
				try{
					System.out.println(request.getParameter("fechaInicio"));
					id_insert = ticketMantenimientoabm.agregar( problema,  fechaInicio,  precio, fechaResolucion,  terminado,login,  tipoMantenimiento);
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede agregar el registro");
				}
				
				request.setAttribute("insert_hecho", "OK");
				
			}
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaTicketMantenimiento.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}



