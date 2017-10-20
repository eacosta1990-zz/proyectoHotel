package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Cliente;
import negocio.Facade;
import negocio.ClienteABM;

public class ControladorCliente extends HttpServlet {
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
			
			if(request.getParameter("id") == null){
				List<Cliente> LCliente = Clienteabm.traerCliente();
				request.setAttribute("ListaCliente", LCliente);
				
			}
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				Cliente cliente = Clienteabm.traerCliente(id);
				request.setAttribute("cliente", cliente);
				
			}
			
			response.setStatus(200);


			request.getRequestDispatcher("/cliente.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}

