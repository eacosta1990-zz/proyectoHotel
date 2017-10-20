package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import negocio.ServicioABM;
import datos.Empleado;
import negocio.EmpleadoABM;
import negocio.FrigobarItemABM;


public class Facade {
	public EmpleadoABM getEmpleadoABM() {
		return new EmpleadoABM();
	}
	public LoginABM getLoginABM() {
		return new LoginABM();
	}
	public FacturaABM getFacturaABM() {
		return new FacturaABM();
	}
	public FormaPagoABM getFormaPagoABM() {
		return new FormaPagoABM();
	}

	public TipoEmpleadoABM getTipoEmpleadoABM() {
		return new TipoEmpleadoABM();
	}
	public TipoHabitacionABM getTipoHabitacionABM() {
		return new TipoHabitacionABM();
	}
	public HabitacionABM getHabitacionABM() {
		return new HabitacionABM();
	}
	public HotelABM getHotelABM() {
		return new HotelABM();
	}

	public EstadiaABM getEstadiaABM() {
		return new EstadiaABM();
	}
	public EstadoABM getEstadoABM() {
		return new EstadoABM();
	}
	public FrigobarABM getFrigobarABM() {
		return new FrigobarABM();
	}
	public FrigobarItemABM getFrigobarItemABM() {
		return new FrigobarItemABM();
	}
	public ConsumoABM getConsumoABM() {
		return new ConsumoABM();
	}
	public TipoMantenimientoABM getTipoMantenimientoABM() {
		return new TipoMantenimientoABM();
	}
	public TicketMantenimientoABM getTicketMantenimientoABM() {
		return new TicketMantenimientoABM();
	}
	public TicketConsumoABM getTicketConsumoABM() {
		return new TicketConsumoABM();
	}
	public ClienteABM getClienteABM() {
		return new ClienteABM();
	}
	public ServicioABM getServicioABM() {
		return new ServicioABM();
	}
	public TicketConsumoItemABM getTicketConsumoItemABM() {
		return new TicketConsumoItemABM();
	}
	
	
}
