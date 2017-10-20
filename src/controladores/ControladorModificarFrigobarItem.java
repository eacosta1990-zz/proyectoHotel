package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Consumo;
import datos.Frigobar;
import datos.FrigobarItem;
import negocio.FrigobarItemABM;
import negocio.ConsumoABM;
import negocio.Facade;
import negocio.FrigobarABM;

public class ControladorModificarFrigobarItem extends HttpServlet {
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
			FrigobarItemABM FrigobarItemabm = facade.getFrigobarItemABM();
			
			
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				
				try{
					FrigobarItem frigobarItem = FrigobarItemabm.traerFrigobarItem(id);
					System.out.println(frigobarItem);
					ConsumoABM consumoabm = facade.getConsumoABM();
					FrigobarABM frigobarabm = facade.getFrigobarABM();

					
					List<Consumo> lConsumo = consumoabm.traerConsumo();
					request.setAttribute("lConsumo", lConsumo);
					
					List<Frigobar> lFrigobar = frigobarabm.traerFrigobar();
					request.setAttribute("lFrigobar", lFrigobar);
					
					if(request.getParameter("stockExistente") != null){
						
						int stockExistente = Integer.parseInt(request.getParameter("stockExistente")); 
						int stockDeseable = Integer.parseInt(request.getParameter("stockDeseable"));
						
						Frigobar frigobar = frigobarabm.traerFrigobar(Integer.parseInt(request.getParameter("idFrigobar")));
						Consumo consumo = consumoabm.traerConsumo(Integer.parseInt(request.getParameter("idConsumo")));
						
					
						
						frigobarItem.setStockExistente(stockExistente);
						frigobarItem.setStockDeseable(stockDeseable);
						frigobarItem.setFrigobar(frigobar);
						frigobarItem.setConsumo(consumo);
						
						
						try{
							FrigobarItemabm.modificar(frigobarItem);
							
							
						} catch (Exception e) {
							HttpSession session = request.getSession();
							session.setAttribute("msgErr", "No se puede guardar el registro");
						}
						
						request.setAttribute("insert_hecho", "OK");
						
					}
					
					
					request.setAttribute("frigobarItem", frigobarItem);
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede traer el registro");
				}
				
			}
			
			
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaFrigobarItem.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}






