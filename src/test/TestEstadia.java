package test;

import java.util.GregorianCalendar;
import java.util.List;

import datos.Estado;
import datos.Frigobar;
import funciones.Funciones;
import negocio.EstadiaABM;
import negocio.EstadoABM;
import negocio.Facade;
import negocio.FrigobarABM;

public class TestEstadia {

	public static void main(String[] args) {
		Facade facade = new Facade();
		EstadiaABM Estadiaabm = facade.getEstadiaABM();					
		EstadoABM estadoABM = facade.getEstadoABM();
		FrigobarABM frigobarABM = facade.getFrigobarABM();
		
		
		float precio = 54234; 
		float senia= 654; 
		int idEstado= 1;
		GregorianCalendar desde= Funciones.obtenerFecha("02/05/2016");
		GregorianCalendar hasta= Funciones.obtenerFecha("02/08/2016");
		GregorianCalendar reserva= Funciones.obtenerFecha("02/06/2016");
		
		Estado estado= estadoABM.traerEstado(idEstado); // pendiente
		Frigobar frigobar = frigobarABM.traerFrigobar(1);
		System.out.println("frigobar-> "+frigobar);
		
		int id_insert = Estadiaabm.agregar( desde,  hasta,  senia, reserva,  precio,  estado,  frigobar);
		
		System.out.println("Terminado !");
	}
}
