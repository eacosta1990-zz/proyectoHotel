package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Consumo;
import negocio.ConsumoABM;
import negocio.Facade;

public class ControladorConsumo extends HttpServlet {
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
			
			if(request.getParameter("id") == null){
				List<Consumo> LConsumo = Consumoabm.traerConsumo();
				request.setAttribute("LConsumo", LConsumo);
				
			}
			
			if(request.getParameter("id") != null){
				int id = Integer.parseInt(request.getParameter("id"));
				Consumo con = Consumoabm.traerConsumo(id);
				request.setAttribute("con", con);
				
			}
			
			response.setStatus(200);


			request.getRequestDispatcher("/consumo.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}

