package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xml.sax.helpers.ParserFactory;

import datos.Hotel;
import datos.Consumo;
import datos.Frigobar;
import datos.FrigobarItem;
import negocio.FrigobarItemABM;
import negocio.HotelABM;
import negocio.ConsumoABM;
import negocio.Facade;
import negocio.FrigobarABM;

public class ControladorAltaFrigobarItem extends HttpServlet {
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
			
			ConsumoABM consumoabm= facade.getConsumoABM();
			List<Consumo> lConsumo=consumoabm.traerConsumo();
			
			FrigobarABM frigobarabm= facade.getFrigobarABM();
			List<Frigobar> lFrigobar=frigobarabm.traerFrigobar();
			
			request.setAttribute("lConsumo", lConsumo);
			request.setAttribute("lFrigobar", lFrigobar);

			
			if(request.getParameter("stockExistente") != null){
				
				int stockExistente = Integer.parseInt(request.getParameter("stockExistente")); 
				int stockDeseable = Integer.parseInt(request.getParameter("stockDeseable")); 

				Frigobar frigobar = frigobarabm.traerFrigobar(Integer.parseInt(request.getParameter("idFrigobar")));
				Consumo consumo = consumoabm.traerConsumo(Integer.parseInt(request.getParameter("idConsumo")));
				
				int id_insert = 0;
				
				try{
					id_insert = FrigobarItemabm.agregar(stockExistente, stockDeseable, consumo, frigobar);
					
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setAttribute("msgErr", "No se puede agregar el registro");
				}
				
				request.setAttribute("insert_hecho", "OK");
				
			}
			
			
			response.setStatus(200);

			request.getRequestDispatcher("/altaFrigobarItem.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}



