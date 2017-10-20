package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Estadia;
import datos.TipoHabitacion;
import funciones.Funciones;
import negocio.EstadiaABM;
import negocio.Facade;
import negocio.TipoHabitacionABM;

public class ControladorModificarEstadia extends HttpServlet {
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
			EstadiaABM Estadiaabm = facade.getEstadiaABM();
			TipoHabitacionABM tipohabitacionabm=facade.getTipoHabitacionABM();
		
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				
				try{
					Estadia estadia = Estadiaabm.traerEstadia(id);
					
					List<TipoHabitacion> LTipoHabitacion = tipohabitacionabm.traerTipoHabitacion();
					request.setAttribute("ListaTipoHabitacion", LTipoHabitacion);
					
					if(request.getParameter("estadia") != null){
						float senia = Float.parseFloat(request.getParameter("senia"));
						GregorianCalendar desde = Funciones.obtenerFecha(request.getParameter("desde"));
						GregorianCalendar hasta = Funciones.obtenerFecha(request.getParameter("hasta"));
						
					
						estadia.setSenia(senia);
						estadia.setFechaDesde(desde);
						estadia.setFechaHasta(hasta);

						
						try{
							Estadiaabm.modificar(estadia);
							
						} catch (Exception e) {
							HttpSession session = request.getSession();
							session.setAttribute("msgErr", "No se puede guardar el registro");
						}
						
						request.setAttribute("insert_hecho", "OK");
						
					}
					
					
					
					request.setAttribute("estadia", estadia);
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede traer el registro");
				}
				
			}
			
			
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaEstadia.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}






