package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Cliente;
import datos.Estadia;
import datos.Habitacion;
import datos.TicketConsumo;
import datos.TicketConsumoItem;
import datos.TipoEmpleado;
import datos.TipoHabitacion;
import negocio.TipoEmpleadoABM;
import negocio.TipoHabitacionABM;
import negocio.ClienteABM;
import negocio.EstadiaABM;
import negocio.Facade;
import negocio.HabitacionABM;
import negocio.TicketConsumoABM;
import negocio.TicketConsumoItemABM;

public class ControladorVistaGenerarConsumo extends HttpServlet {
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
			TicketConsumoItem ticketItem =new  TicketConsumoItem();
			TicketConsumoItemABM ticketItemabm =facade.getTicketConsumoItemABM();
			TicketConsumo ticket = new TicketConsumo();
			TicketConsumoABM ticketabm =facade.getTicketConsumoABM();
			Cliente cliente = new Cliente();
			ClienteABM clienteabm = facade.getClienteABM();
			List<Cliente> ListaCliente = clienteabm.traerCliente();
			Estadia estadia=new Estadia();
			EstadiaABM estadiaabm=facade.getEstadiaABM();
		
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				cliente=clienteabm.traerCliente(id);
				/* traer la estadia activa en el momento del cliente estado==1*/
				Set<Estadia> estadias = cliente.getEstadia();
				for (Estadia esta: estadias){
					if(esta.getEstado().getIdEstado()==1){
						estadia=estadiaabm.traerEstadia(esta.getIdEstadia());
						
					}
				}
				
				/* traer los ticket consumo de esa estadia*/
				Set<TicketConsumo> ticketConsumos = estadia.getTicketConsumo();

				/* verificar que halla uno sin firmar(firmado=cerrado y agregarle los item que siguen consumiento)*/
				for (TicketConsumo ticke: ticketConsumos){
					if(ticke.isFirmado()==false ){

						ticket=ticketabm.traerTicketConsumo(ticke.getIdTicketConsumo());
					}
				}

				request.setAttribute("id", ticket);
				

				
			}

			response.setStatus(200);

			request.getRequestDispatcher("/vistaConsumo.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}

