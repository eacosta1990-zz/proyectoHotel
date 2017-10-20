package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xml.sax.helpers.ParserFactory;

import datos.Cliente;
import datos.Habitacion;
import datos.Hotel;
import datos.TipoHabitacion;
import negocio.ClienteABM;
import negocio.HotelABM;
import negocio.LoginABM;
import negocio.TipoHabitacionABM;
import negocio.Facade;

public class ControladorAltaCliente extends HttpServlet {
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
			Cliente cliente = new Cliente();
			LoginABM loginabm = new LoginABM();
			ClienteABM Clienteabm = facade.getClienteABM();
			
			List<Cliente> LTipoCliente = Clienteabm.traerCliente();
			request.setAttribute("ListaCliente", LTipoCliente);
			
			
			if(request.getParameter("dni")!= null){
				
				String nombre= request.getParameter("nombre");
				String apellido=request.getParameter("apellido");
				Long dni= Long.parseLong(request.getParameter("dni"));
				String telefono=request.getParameter("telefono");
				String direccion=request.getParameter("direccion");
				String email=request.getParameter("email");
				
			
				int id_insert = 0;
				int id =0;
				try{
					id_insert = Clienteabm.agregar(nombre,apellido,dni,telefono,direccion,email);
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede agregar el registro");
				}
				
				request.setAttribute("insert_hecho", "OK");
				
				
			}
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaCliente.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}



