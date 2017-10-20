package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xml.sax.helpers.ParserFactory;
import funciones.Funciones;
import datos.Cliente;
import datos.Estadia;
import datos.Estado;
import datos.Factura;
import datos.FormaPago;
import datos.Frigobar;
import datos.Habitacion;
import datos.Login;
import datos.Mail;
import datos.TipoHabitacion;
import funciones.Funciones;
import negocio.ClienteABM;
import negocio.EstadiaABM;
import negocio.EstadoABM;
import negocio.Facade;
import negocio.FacturaABM;
import negocio.FormaPagoABM;
import negocio.FrigobarABM;
import negocio.HabitacionABM;
import negocio.LoginABM;
import negocio.TipoHabitacionABM;

public class ControladorAltaEstadia extends HttpServlet {
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
			Funciones funciones=new Funciones();
			Facade facade = new Facade();
			LoginABM loginabm=facade.getLoginABM();
			Login login =new Login();
			EstadiaABM Estadiaabm = facade.getEstadiaABM();
			Estadia estadia = new Estadia();
			Factura factura =new Factura();
			FacturaABM facturaabm= facade.getFacturaABM();
			FormaPago formaPago=new FormaPago();
			FormaPagoABM formaPagoabm=facade.getFormaPagoABM();
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
			List<Estado> ListaEstado = estadoABM.traerEstado();
			List<TipoHabitacion> ListaTipoHabitacion = tipoHabitacionabm.traerTipoHabitacion();
			List<Habitacion> ListaHabitacion = habitacionABM.traerHabitacionDisponible();
			List<FormaPago> ListaFormaPago=formaPagoabm.traerFormaPago();
			request.setAttribute("ListaTipoHabitacion", ListaTipoHabitacion);
			request.setAttribute("ListaFormaPago", ListaFormaPago);
			request.setAttribute("ListaEstado", ListaEstado);
			request.setAttribute("ListaHabitacion", ListaHabitacion);
			

			if (request.getParameter("dni") != null) {

				float precio = 0;
				float senia = Float.parseFloat(request.getParameter("senia"));
				GregorianCalendar desde = Funciones.obtenerFecha(request.getParameter("desde"));
				GregorianCalendar hasta = Funciones.obtenerFecha(request.getParameter("hasta"));
				int idFormaPago=Integer.parseInt(request.getParameter("formaPago"));
				long dni = Long.parseLong(request.getParameter("dni"));
				

				GregorianCalendar reserva = Funciones.obtenerFechaActual();

				Funciones.esFechaValida(desde);
				Funciones.esFechaValida(hasta);

				if (desde.before(hasta) != true || desde.equals(hasta) == true) {
					throw new Exception("fecha hasta tiene que ser mayor a fecha desde");
				}

				if (desde.before(reserva) == true) {
					throw new Exception("desde tiene que ser mayor dia reserva");

				}
				long diasEstadia = Funciones.diferenciaDias(desde, hasta);
				
				formaPago=formaPagoabm.traerFormaPago(idFormaPago);
				System.out.println(formaPago);

				habitacion = habitacionabm.traerHabitacion(Integer.parseInt(request.getParameter("idHabitacion")));
				tipoHabitacion = tipoHabitacionabm.traerTipoHabitacion(Integer.parseInt(request.getParameter("idTipoHabitacion")));

				precio = tipoHabitacion.getPrecio() * diasEstadia;

				float diferencia = precio - senia;
				int opcion = 0;
				if (diferencia == 0) {
					opcion = 1;
				} else {
					opcion = 2;
				}

				if (clienteabm.traerCliente(dni) != null) {
					cliente = clienteabm.traerCliente(dni);
				} else {
					throw new Exception("DNI INCORRECTO");
				}

				Estado estado = estadoABM.traerEstado(opcion);
				Frigobar frigobar = frigobarABM.traerFrigobar(1);

				int id_insert = 0;

				try {
					
					id_insert = Estadiaabm.agregar(desde, hasta, senia, reserva, precio, estado, frigobar);
					estadia = (Estadia) Estadiaabm.traerEstadia(id_insert);
					Set<Estadia> esta = cliente.getEstadia();
					esta.add(estadia);
					habitacion.setDisponible(2);
					habitacionabm.modificar(habitacion);
					if (senia!=0){
						int nroFactura=funciones.maxNroFactura();
						System.out.println(nroFactura);
						login=loginabm.traerLogin(1);
						facturaabm.agregar(nroFactura, reserva, true, formaPago, cliente, login, estadia);
						
					}
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

			request.getRequestDispatcher("/altaEstadia.jsp").forward(request, response);

		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}
