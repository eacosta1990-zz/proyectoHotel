package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xml.sax.helpers.ParserFactory;

import datos.Empleado;
import datos.Habitacion;
import datos.Hotel;
import datos.TipoEmpleado;
import datos.TipoHabitacion;
import negocio.HabitacionABM;
import negocio.HotelABM;
import negocio.LoginABM;
import negocio.TipoEmpleadoABM;
import negocio.TipoHabitacionABM;
import negocio.EmpleadoABM;
import negocio.Facade;

public class ControladorAltaEmpleado extends HttpServlet {
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
			Empleado empleado = new Empleado();
			LoginABM loginabm = new LoginABM();
			EmpleadoABM Empleadoabm = facade.getEmpleadoABM();
			TipoEmpleadoABM TipoEmpleadoabm = facade.getTipoEmpleadoABM();
			
			List<TipoEmpleado> LTipoEmpleado = TipoEmpleadoabm.traerTipoEmpleado();
			request.setAttribute("ListatipoEmpleado", LTipoEmpleado);
			
			
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
				int privilegio = Integer.parseInt(request.getParameter("privilegio"));
				
				
				TipoEmpleado tipoEmpleado = TipoEmpleadoabm.traerTipoEmpleado(tipoemple);
				int id_insert = 0;
				int id =0;
				try{
					id = loginabm.agregar(usuario, clave, privilegio);
					id_insert = Empleadoabm.agregar(nombre,apellido,dni,telefono,direccion,email,legajo,sueldo,tipoEmpleado);
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede agregar el registro");
				}
				
				request.setAttribute("insert_hecho", "OK");
				
				
			}
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaEmpleado.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}



