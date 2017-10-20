package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Cliente;
import datos.Hotel;
import negocio.ClienteABM;
import negocio.HotelABM;
import negocio.Facade;

public class ControladorModificarCliente extends HttpServlet {
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
			ClienteABM Clienteabm = facade.getClienteABM();
			
			
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				
				try{
					Cliente cliente = Clienteabm.traerCliente(id);
					
					if(request.getParameter("dni")!= null){
						
						String nombre= request.getParameter("nombre");
						String apellido=request.getParameter("apellido");
						Long dni= Long.parseLong(request.getParameter("dni"));
						String telefono=request.getParameter("telefono");
						String direccion=request.getParameter("direccion");
						String email=request.getParameter("email");
						
						/*
						HotelABM Hotelabm = facade.getHotelABM();
						Hotel hotel = Hotelabm.traerHotel(1);
						*/
						
						cliente.setNombre(nombre);
						cliente.setApellido(apellido);
						cliente.setDireccion(direccion);
						cliente.setDni(dni);
						cliente.setEmail(email);
						cliente.setTelefono(telefono);
						
						
						try{
							Clienteabm.modificar(cliente);
							// Clienteabm.modificar(nroCliente, capacidadMax, disponible, tipoCliente, hotel);
							
							
						} catch (Exception e) {
							HttpSession session = request.getSession();
							session.setAttribute("msgErr", "No se puede guardar el registro");
						}
						
						request.setAttribute("insert_hecho", "OK");
						
					}
					
					
					request.setAttribute("cliente", cliente);
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede traer el registro");
				}
				
			}
			
			
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaCliente.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}






