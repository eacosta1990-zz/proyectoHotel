package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.Empleado;
import negocio.EmpleadoABM;
import negocio.Facade;

public class ControladorMostrarEmpleado extends HttpServlet {
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
			int dni = Integer.parseInt(request.getParameter("dni"));
			EmpleadoABM Empleadoabm = facade.getEmpleadoABM();
			Empleado Empleado = Empleadoabm.traerEmpleado(dni);
			response.setStatus(200);
			PrintWriter salida = response.getWriter();
			salida.println("");
			salida.println("<!DOCTYPE 4.01 Transitional//EN\">");
			salida.println("<HTML>");
			salida.println(" <HEAD>");
			salida.println(" <TITLE>Sistema Francés</TITLE>");
			salida.println(" </HEAD>");
			salida.println(" <BODY>");
			salida.println(" Apellido: " + Empleado.getApellido() + "<BR>");
			salida.println(" Nombre : " + Empleado.getNombre() + "<BR>");
			salida.println(" DNI : " + Empleado.getDni() + "<BR>");
			salida.println(" ID : " + Empleado.getIdEmpleado() + "<BR>");
			salida.println("<A href=\"/SistemaFrances/Empleado.html\">Volver...</A>");
			salida.println(" </BODY>");
			salida.println("</HTML>");
		} catch (Exception e) {
			response.sendError(500, "El DNI Ingresado no existe en la base de datos.");
		}
	}
}
