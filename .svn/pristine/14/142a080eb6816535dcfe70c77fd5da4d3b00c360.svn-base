package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Frigobar;
import datos.FrigobarItem;
import negocio.FrigobarItemABM;
import negocio.ConsumoABM;
import negocio.Facade;
import negocio.FrigobarABM;

public class ControladorFrigobarItem extends HttpServlet {
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
			FrigobarItemABM frigobarItemabm = facade.getFrigobarItemABM();
			FrigobarABM frigobarabm = facade.getFrigobarABM();
			
			

			if(request.getParameter("id") == null){
				List<FrigobarItem> lFrigobarItem = frigobarItemabm.traerFrigobarItem();
				request.setAttribute("lFrigobarItem", lFrigobarItem);
				List<Frigobar> lFrigobar = frigobarabm.traerFrigobar();
				request.setAttribute("lFrigobar", lFrigobar);
				

				
			}
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				FrigobarItem frigobarItem = frigobarItemabm.traerFrigobarItem(id);
				request.setAttribute("frigobarItem", frigobarItem);
				
			}
			
			response.setStatus(200);


			request.getRequestDispatcher("/frigobarItem.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}

