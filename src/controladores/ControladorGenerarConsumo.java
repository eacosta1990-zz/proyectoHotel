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
import datos.Consumo;
import datos.Estadia;
import datos.Habitacion;
import datos.Hotel;
import datos.Login;
import datos.Servicio;
import datos.TicketConsumo;
import datos.TicketConsumoItem;
import datos.TipoHabitacion;
import funciones.Funciones;
import negocio.ClienteABM;
import negocio.ConsumoABM;
import negocio.EstadiaABM;
import negocio.HotelABM;
import negocio.LoginABM;
import negocio.ServicioABM;
import negocio.TicketConsumoABM;
import negocio.TicketConsumoItemABM;
import negocio.TipoHabitacionABM;
import negocio.Facade;

public class ControladorGenerarConsumo extends HttpServlet {
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
			LoginABM loginabm = new LoginABM();
			Login login = new Login();
			Funciones funciones = new Funciones();
			Consumo consumo = new Consumo();
			ConsumoABM consumoabm = facade.getConsumoABM();
			List<Consumo> listaConsumo = consumoabm.traerConsumo();
			request.setAttribute("listaConsumo", listaConsumo);
			boolean firmado = false;
			boolean nuevoTicket = true;
			boolean modificado = false;
			TicketConsumoItem ticketItem = new TicketConsumoItem();
			TicketConsumoItemABM ticketItemabm = facade.getTicketConsumoItemABM();
			
			TicketConsumo ticket = new TicketConsumo();
			TicketConsumoABM ticketabm = facade.getTicketConsumoABM();
			Cliente cliente = new Cliente();
			ClienteABM clienteabm = facade.getClienteABM();
			List<Cliente> ListaCliente = clienteabm.traerCliente();
			request.setAttribute("ListaCliente", ListaCliente);
			
			Estadia estadia = new Estadia();
			EstadiaABM estadiaabm = facade.getEstadiaABM();
			login = loginabm.traerLogin(1);

			if (request.getParameter("cliente") != null) {
				int idCliente = Integer.parseInt(request.getParameter("cliente"));
				int idProducto = Integer.parseInt(request.getParameter("producto"));
				int cantidad = Integer.parseInt(request.getParameter("cantidad"));

				GregorianCalendar fechaActual = funciones.obtenerFechaActual();
				Consumo producto = consumoabm.traerConsumo(idProducto);
				float precio = producto.getPrecio();
				cliente = clienteabm.traerClienteEstadias(idCliente);
				/*
				 * traer la estadia activa en el momento del cliente estado==1
				 */
				Set<Estadia> estadias = cliente.getEstadia();
				for (Estadia esta : estadias) {
					if (esta.getEstado().getIdEstado() == 1) {

						estadia = estadiaabm.traerEstadia(esta.getIdEstadia());

					}
				}
				/* traer los ticket consumo de esa estadia */
				int nroFactura = funciones.maxNroTicket();
				Set<TicketConsumo> ticketConsumos = estadia.getTicketConsumo();
				/*
				 * verificar que halla uno sin firmar(firmado=cerrado y
				 * agregarle los item que siguen consumiento)
				 */
				for (TicketConsumo ticke : ticketConsumos) {
					if (ticke.isFirmado() == false) {
						

						nuevoTicket = false;
						ticket = ticketabm.traerTicketConsumo(ticke.getIdTicketConsumo());
						
						List<TicketConsumoItem> listaTicketConsumoItem = ticketItemabm.traerListaTicketConsumoItem(ticket.getIdTicketConsumo(),idProducto);
					
						for(TicketConsumoItem ti: listaTicketConsumoItem){
							/*trae los items COnsumos y compara si alguno de estos tienen el mismo producto*/
							/* si hay coincidencia modifica su cantidad*/
							/*sino agrega un nuevo itemconsumo*/
							if (ti.getConsumo().getIdConsumo()==(producto.getIdConsumo())) {
								ti.setCantidad(ti.getCantidad()+cantidad);
								ticketItemabm.modificar(ti);
								modificado=true;
								
							}
							
						}
						if(modificado==false){
							ticketItemabm.agregar(cantidad, precio, ticket, producto);
						}
			
						
					}

				}
				int id_insert = 0;
				int id = 0;
				try {
					if (nuevoTicket == true) {
						/*
						 * si estan todos firmados agrego un nuevo ticket y le
						 * asigno un item
						 */
						id_insert = ticketabm.agregar(nroFactura, fechaActual, firmado, estadia, login);

						ticketItemabm.agregar(cantidad, precio, ticketabm.traerTicketConsumo(id_insert), producto);

					}

				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede agregar el registro");
				}

				request.setAttribute("insert_hecho", "OK");

			}

			response.setStatus(200);

			request.getRequestDispatcher("/generarConsumo.jsp").forward(request, response);

		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}
