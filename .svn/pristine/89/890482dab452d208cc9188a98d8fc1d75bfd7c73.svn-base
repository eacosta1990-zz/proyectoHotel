package test;

import java.util.List;

import datos.Empleado;
import datos.Hotel;
import datos.TipoHabitacion;
import negocio.EmpleadoABM;
import negocio.HabitacionABM;
import negocio.HotelABM;
import negocio.TipoHabitacionABM;

public class TestEmpleado {

	public static void main(String[] args) {
		HotelABM hotelabm = new HotelABM();
		Hotel hotel = hotelabm.traerHotel(1);
		System.out.println("Hotel -->" + hotel);
		
		TipoHabitacionABM TipoHabitacionabm = new TipoHabitacionABM();		
		TipoHabitacion tipoHabitacion = TipoHabitacionabm.traerTipoHabitacion(6);
		System.out.println("tipo -->" + tipoHabitacion);
		
		HabitacionABM habitaionabm = new HabitacionABM();
		
		int id_insert = habitaionabm.agregar("adas 234", 2, 1, tipoHabitacion, hotel);
		
		System.out.println("habi -->" + id_insert);
		
		/*
		EmpleadoABM abm = new EmpleadoABM();
		// traer el obj a modificar
		List<Empleado> c = abm.traerEmpleado();
		
		for (Empleado Empleado : c) {
			System.out.println("Empleado -->" + Empleado);
		}
		*/
		System.out.println("Terminado !");
	}
}
