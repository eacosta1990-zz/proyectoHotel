package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Consumo;
import negocio.ConsumoABM;
import negocio.Facade;

public class ControladorModificarConsumo extends HttpServlet {
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
			ConsumoABM Consumoabm = facade.getConsumoABM();
		
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				
				try{
					Consumo consumo = Consumoabm.traerConsumo(id);
					
					if(request.getParameter("consumo") != null){
						String Vconsumo =request.getParameter("consumo");
						float precio = Float.parseFloat(request.getParameter("precio"));
						consumo.setConsumo(Vconsumo);
						consumo.setPrecio(precio);
						
						try{
							Consumoabm.modificar(consumo);
							
						} catch (Exception e) {
							HttpSession session = request.getSession();
							session.setAttribute("msgErr", "No se puede guardar el registro");
						}
						
						request.setAttribute("insert_hecho", "OK");
						
					}
					
					
					
					request.setAttribute("consumo", consumo);
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede traer el registro");
				}
				
			}
			
			
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaConsumo.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}






