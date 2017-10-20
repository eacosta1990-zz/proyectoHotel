package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Empleado;
import datos.Hotel;
import datos.Login;
import datos.TipoEmpleado;
import negocio.EmpleadoABM;
import negocio.HotelABM;
import negocio.LoginABM;
import negocio.TipoEmpleadoABM;
import negocio.Facade;

public class ControladorModificarEmpleado extends HttpServlet {
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
			EmpleadoABM Empleadoabm = facade.getEmpleadoABM();
			LoginABM Loginabm = facade.getLoginABM();
			
			TipoEmpleadoABM TipoEmpleadoabm = facade.getTipoEmpleadoABM();

			
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				
				try{
					Empleado empleado = Empleadoabm.traerEmpleado(id);
					Login login = Loginabm.traerLogin(id);
					
					if(request.getParameter("dni")!= null){
						String nombre= request.getParameter("nombre");
						String apellido=request.getParameter("apellido");
						Long dni= Long.parseLong(request.getParameter("dni"));
						String telefono=request.getParameter("telefono");
						String direccion=request.getParameter("direccion");
						String email=request.getParameter("email");
						String legajo=request.getParameter("legajo");
						Float sueldo=Float.parseFloat(request.getParameter("sueldo"));
						int tipoemple = Integer.parseInt(request.getParameter("tipoemple"));
						String clave = request.getParameter("clave");
						String usuario = request.getParameter("usuario");
						
						
						TipoEmpleado tipoEmpleado = TipoEmpleadoabm.traerTipoEmpleado(tipoemple);
						int id_insert = 0;
						
						empleado.setNombre(nombre);
						empleado.setDireccion(direccion);
						empleado.setDni(dni);
						empleado.setTelefono(telefono);
						empleado.setEmail(email);
						empleado.setApellido(apellido);
						empleado.setNroLegajo(legajo);
						empleado.setSueldo(sueldo);
						empleado.setTipoEmpleados(tipoEmpleado);
						
						
						
						try{
							Empleadoabm.modificar(empleado);
							// Empleadoabm.modificar(nroEmpleado, capacidadMax, disponible, tipoEmpleado, hotel);
							
							
						} catch (Exception e) {
							HttpSession session = request.getSession();
							session.setAttribute("msgErr", "No se puede guardar el registro");
						}
						
						request.setAttribute("insert_hecho", "OK");
						
					}
					
					
					request.setAttribute("empleado", empleado);
					request.setAttribute("login", login);
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede traer el registro");
				}
				
			}
			
			
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaEmpleado.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}






