package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xml.sax.helpers.ParserFactory;

import datos.Habitacion;
import datos.Hotel;
import datos.TipoHabitacion;
import negocio.HabitacionABM;
import negocio.HotelABM;
import negocio.TipoHabitacionABM;
import negocio.Facade;

public class ControladorAltaHabitacion extends HttpServlet {
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
			HabitacionABM Habitacionabm = facade.getHabitacionABM();
			TipoHabitacionABM TipoHabitacionabm = facade.getTipoHabitacionABM();
			
			List<TipoHabitacion> LTipoHabitacion = TipoHabitacionabm.traerTipoHabitacion();
			request.setAttribute("ListatipoHabitacion", LTipoHabitacion);
			
			// System.out.println("nro habi: "+ request.getParameter("nro_habitacion"));
			
			if(request.getParameter("nro_habitacion") != null){
				//System.out.println("nro habi entre: "+ request.getParameter("nro_habitacion"));
				
				String nroHabitacion = (String) request.getParameter("nro_habitacion"); 
				int capacidadMax = Integer.parseInt(request.getParameter("capacidad_max")); 
				int disponible = Integer.parseInt(request.getParameter("disponible"));
				int id_tipoHabitacion= Integer.parseInt(request.getParameter("id_tipo_habitacion"));
				
				TipoHabitacion tipoHabitacion = TipoHabitacionabm.traerTipoHabitacion(id_tipoHabitacion);
				
				HotelABM Hotelabm = facade.getHotelABM();
				Hotel hotel = Hotelabm.traerHotel(1);
				//System.out.println("hotel entre: "+ hotel);
				
				int id_insert = 0;
				
				try{
					id_insert = Habitacionabm.agregar(nroHabitacion, capacidadMax, disponible, tipoHabitacion, hotel);
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede agregar el registro");
				}
				
				request.setAttribute("insert_hecho", "OK");
				
			}
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaHabitacion.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}



