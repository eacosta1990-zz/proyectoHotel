package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xml.sax.helpers.ParserFactory;

import datos.Cliente;
import datos.Estadia;
import datos.Estado;
import datos.Frigobar;
import datos.Habitacion;
import datos.Hotel;
import datos.Mail;
import datos.TipoHabitacion;
import funciones.Funciones;
import negocio.ClienteABM;
import negocio.EstadiaABM;
import negocio.EstadoABM;
import negocio.HotelABM;
import negocio.LoginABM;
import negocio.TipoHabitacionABM;
import negocio.Facade;
import negocio.FrigobarABM;
import negocio.HabitacionABM;

public class ControladorAltaPrueba extends HttpServlet {
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
			Estadia estadia = new Estadia();

			EstadoABM estadoABM = facade.getEstadoABM();
			FrigobarABM frigobarABM = facade.getFrigobarABM();
			HabitacionABM habitacionABM = facade.getHabitacionABM();
			TipoHabitacionABM tipoHabitacionabm = facade.getTipoHabitacionABM();
			TipoHabitacion tipoHabitacion = new TipoHabitacion();
			Cliente cliente = new Cliente();
			ClienteABM clienteabm = facade.getClienteABM();
			Habitacion habitacion = new Habitacion();

			HabitacionABM habitacionabm = facade.getHabitacionABM();
			Mail mail = new Mail();
			


			if (request.getParameter("dni") != null) {
				String nombre = (String) request.getParameter("nombre");

				String apellido = (String) request.getParameter("apellido");

				String email = (String) request.getParameter("email");

				int idTipoHabitacion = Integer.parseInt(request.getParameter("id"));

				int capacidad = Integer.parseInt(request.getParameter("capacidad"));

				GregorianCalendar desde = Funciones.obtenerFecha(request.getParameter("fdesde"));

				GregorianCalendar hasta = Funciones.obtenerFecha(request.getParameter("fhasta"));

				long dni = Long.parseLong(request.getParameter("dni"));

				GregorianCalendar reserva = Funciones.obtenerFechaActual();

				Funciones.esFechaValida(desde);
				Funciones.esFechaValida(hasta);
				
				
			
				

				long diasEstadia = Funciones.diferenciaDias(desde, hasta);

				List<Habitacion> habitaciones = habitacionabm.traerHabitacionPorTipo(idTipoHabitacion,capacidad);
				for (Habitacion habi : habitaciones) {
					habitacion = null;
					if (habi.getDisponible() == 1) {
						habitacion = habi;
					}

				}
				
				int senia=0;
				float precio =0;
				precio= habitacion.getTipoHabitacion().getPrecio() * diasEstadia;

				

				
				cliente = clienteabm.traerCliente(dni);
				if (cliente==null){
					clienteabm.agregar(nombre, apellido, dni, null, null, email);
					cliente = clienteabm.traerCliente(dni);
				}
				

				int id = cliente.getIdCliente();
				Estado estado = estadoABM.traerEstado(2);
				Frigobar frigobar = frigobarABM.traerFrigobar(1);
				int id_insert = 0;

				try {
					id_insert = Estadiaabm.agregar(desde, hasta, senia, reserva, precio, estado, frigobar);
					estadia = (Estadia) Estadiaabm.traerEstadia(id_insert);
					Set<Estadia> esta = cliente.getEstadia();
					esta.add(estadia);
					habitacion.setDisponible(2);
					habitacionabm.modificar(habitacion);
					cliente.setEstadia(esta);
					cliente.getEstadia();
					clienteabm.modificar(cliente);
					mail.send(cliente, cliente.getEmail());
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede agregar el registro");
				}

				request.setAttribute("insert_hecho", "OK");

			}

			response.setStatus(200);

			request.getRequestDispatcher("/index.jsp").forward(request, response);

		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}
