package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.TipoHabitacion;
import negocio.TipoHabitacionABM;
import negocio.Facade;

public class ControladorModificarTipoHabitacion extends HttpServlet {
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
			TipoHabitacionABM TipoHabitacionabm = facade.getTipoHabitacionABM();
		
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				
				try{
					TipoHabitacion tipoHabitacion = TipoHabitacionabm.traerTipoHabitacion(id);
					
					if(request.getParameter("nombre") != null){
						String nombre = (String) request.getParameter("nombre");
						String descripcion = (String) request.getParameter("descripcion");
						float precio = Float.parseFloat(request.getParameter("precio"));
						
						tipoHabitacion.setTipoHabitacion(nombre);
						tipoHabitacion.setDescripcion(descripcion);
						tipoHabitacion.setPrecio(precio);
						
						try{
							TipoHabitacionabm.modificar(tipoHabitacion);
							
						} catch (Exception e) {
							HttpSession session = request.getSession();
							session.setAttribute("msgErr", "No se puede guardar el registro");
						}
						
						request.setAttribute("insert_hecho", "OK");
						
					}
					
					
					
					request.setAttribute("tipoHabitacion", tipoHabitacion);
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede traer el registro");
				}
				
			}
			
			
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaTipoHabitacion.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}






