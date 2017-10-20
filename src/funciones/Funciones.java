package funciones;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import datos.Factura;
import datos.TicketConsumo;
import negocio.FacturaABM;
import negocio.TicketConsumoABM;

public class Funciones {

	public static GregorianCalendar obtenerFechaActual() {
		GregorianCalendar reserva = new GregorianCalendar();
		int anio = reserva.get(Calendar.YEAR);
		int mes = reserva.get(Calendar.MONTH);
		int dia = reserva.get(Calendar.DAY_OF_MONTH);
		int hora = reserva.get(Calendar.HOUR_OF_DAY);
		int minuto = reserva.get(Calendar.MINUTE);
		reserva.set(anio, mes, dia, hora, minuto);
		return reserva;
	}
	
	public int maxNroFactura(){
		FacturaABM facturaabm=new FacturaABM();
		List<Factura> facturas=facturaabm.traerFactura();
		int maxId=0;
		for(Factura factura: facturas){
			if(factura.getIdFactura()>maxId){
				maxId=factura.getIdFactura();
			}
			
		}
		return maxId+1;
		
	}
	public int maxNroTicket(){
		TicketConsumoABM ticketabm=new TicketConsumoABM();
		List<TicketConsumo> tickets=ticketabm.traerTicketConsumo();
		int maxId=0;
		for(TicketConsumo ticket: tickets){
			if(ticket.getIdTicketConsumo()>maxId){
				maxId=ticket.getIdTicketConsumo();
			}
			
		}
		return maxId+1;
		
	}

	public static int obtenerDia(GregorianCalendar fecha) {
		return fecha.get(Calendar.DAY_OF_MONTH);
	}

	public static int obtenerMes(GregorianCalendar fecha) {
		return fecha.get(Calendar.MONTH) + 1;
	}

	public static int obtenerAnio(GregorianCalendar fecha) {
		return fecha.get(Calendar.YEAR);
	}

	public static int obtenerDiaSemana(GregorianCalendar fecha) {
		return fecha.get(Calendar.DAY_OF_WEEK);
	}

	// devuelvo gregorian calendar, recibo un string
	public static GregorianCalendar obtenerFecha(String fecha) {
		try { // intento convertir fecha String
			int anio = Integer.parseInt(fecha.substring(6));
			int mes = Integer.parseInt(fecha.substring(3, 5))-1 ;
			int dia = Integer.parseInt(fecha.substring(0, 2));
			return new GregorianCalendar(anio, mes, dia);

		} catch (NumberFormatException e) { // si no puedo convertir.. tiro
											// ERROR
			System.out.println("Se produjo un error al convertir la fecha en String.");
			return null;
		}
	}

	public static GregorianCalendar obtenerFechaInvertida(String fecha) {
		try { // intento convertir fecha String
			fecha = fecha.replace("/", "");

			int anio = Integer.parseInt(fecha.substring(0, 4));
			int mes = Integer.parseInt(fecha.substring(5, 6)) - 1;
			int dia = Integer.parseInt(fecha.substring(7, 8));
			return new GregorianCalendar(anio, mes, dia);

		} catch (NumberFormatException e) { // si no puedo convertir.. tiro
											// ERROR
			System.out.println("Se produjo un error al convertir la fecha en String.");
			return null;
		}
	}

	public static String SOLOobtenerFecha(GregorianCalendar fecha) {
		return obtenerDia(fecha) + "/" + obtenerMes(fecha) + "/" + obtenerAnio(fecha);
	}

	public static String obtenerFecha(GregorianCalendar fecha) {
		return obtenerDia(fecha) + "/" + obtenerMes(fecha) + "/" + obtenerAnio(fecha) + " "
				+ fecha.get(Calendar.HOUR_OF_DAY) + ":" + fecha.get(Calendar.MINUTE);
	}

	public static GregorianCalendar obtenerFecha(int anio, int mes, int dia) {
		if (esFechaValida(anio, mes, dia)) {
			return new GregorianCalendar(anio, mes, dia);
		} else {
			System.out.println("La fecha es invalida.");
			return null;
		}
	}

	public static boolean esDiaHabil(GregorianCalendar fecha) {
		int Num = fecha.get(Calendar.DAY_OF_WEEK) - 1;
		if (Num == 0 || Num == 6) {
			return false;
		}
		return true;
	}

	public static boolean sonFechasIguales(GregorianCalendar fecha, GregorianCalendar fecha2) {
		if (obtenerDia(fecha) == obtenerDia(fecha2) && obtenerMes(fecha) == obtenerMes(fecha2)
				&& obtenerAnio(fecha) == obtenerAnio(fecha2)) {
			return true;
		}
		return false;
	}

	public static int traerCantDiasDeUnMes(int anio, int mes) {
		if (esBisiesto(anio) && mes == 2) {
			return 29;
		} else if (!esBisiesto(anio) && mes == 2) {
			return 28;
		} else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
			return 30;
		} else {
			return 31;
		}
	}

	public static String obtenerMesNombre(GregorianCalendar fecha) {
		int Num = fecha.get(Calendar.MONTH);
		String[] mes = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		return mes[Num];
	}

	public static String obtenerDiaNombre(GregorianCalendar fecha) {
		int Num = fecha.get(Calendar.DAY_OF_WEEK) - 1;
		String[] dia = { "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };
		return dia[Num];
	}

	public static String obtenerFechaEntera(GregorianCalendar fecha) {
		String diaNombre = obtenerDiaNombre(fecha);
		String MesNombre = obtenerMesNombre(fecha);
		return diaNombre + " " + obtenerDia(fecha) + " de " + MesNombre + " de " + obtenerAnio(fecha);
	}

	public static boolean esBisiesto(int anio) {
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
			return true;
		}
		return false;
	}

	public static boolean esFechaValida(int anio, int mes, int dia) {
		if (mes > 12) {
			return false;
		} else if (esBisiesto(anio) && mes == 2 && dia > 29) {
			return false;
		} else if (!esBisiesto(anio) && mes == 2 && dia > 28) {
			return false;
		} else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
			return false;
		} else if (dia > 31) {
			return false;
		}
		return true;
	}
	
	public static long diferenciaDias(GregorianCalendar fecha1,GregorianCalendar fecha2){
		 long difmsegundos=fecha2.getTimeInMillis() - fecha1.getTimeInMillis();
		 long difdias=difmsegundos / (1000 * 60 * 60 * 24);
		 return difdias;
		
	}

	public static boolean esFechaValida(GregorianCalendar fecha) throws Exception {
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int anio = fecha.get(Calendar.YEAR);
		if (mes > 12) {
			throw new Exception("fecha invalida");
		} else if (esBisiesto(anio) && mes == 2 && dia > 29) {
			throw new Exception("fecha invalida");
		} else if (!esBisiesto(anio) && mes == 2 && dia > 28) {
			throw new Exception("fecha invalida");
		} else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
			throw new Exception("fecha invalida");
		} else if (dia > 31) {
			throw new Exception("fecha invalida");
		}
		return true;
	}

	public static int calcularEdad(GregorianCalendar fecha, GregorianCalendar fHoy) {
		long millis = fecha.getTimeInMillis();
		Timestamp birth = new Timestamp(millis);

		GregorianCalendar d = fHoy;

		SimpleDateFormat sdfDia = new SimpleDateFormat("dd");
		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
		SimpleDateFormat sdfAnio = new SimpleDateFormat("yyyy");

		int difAnio = obtenerAnio(d) - Integer.parseInt(sdfAnio.format(birth));
		int difMes = obtenerMes(d) - Integer.parseInt(sdfMes.format(birth));
		int difDia = obtenerDia(d) - Integer.parseInt(sdfDia.format(birth));

		if (difMes == 0 && !sonFechasIguales(fecha, fHoy) && difDia < 0) {
			difAnio += -1;
		}

		if (difMes < 0) {
			difAnio = difAnio - 1;
			difMes = 12 + difMes;
		}

		if (difDia < 0) {
			difMes = difMes - 1;
			switch (obtenerMes(d)) {
			case 2:
				int ano = obtenerAnio(d);
				if ((ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0)))
					difDia = 29 + difDia;
				else
					difDia = 28 + difDia;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				difDia = 30 + difDia;
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				difDia = 31 + difDia;
				break;
			}
		}

		if (difMes < 0)
			difMes = 0;

		return difAnio;
		// return difAnio + " a�o(s), " + difMes + " meses, " + difDia + "
		// dias";
	}

	public static boolean esNumero(char c) {
		if (Character.isDigit(c)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean esCaracter(char c) {
		if (!Character.isDigit(c)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean esCadenaNros(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean esCandenaLetras(String cadena) {
		try {
			Integer.parseInt(cadena);
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	/* FUNCIONES NUMERICAS */
	public static double aproximar2Decimal(double numero) {
		DecimalFormat df = new DecimalFormat("####0.00");
		return Double.parseDouble(df.format(numero).replace(",", "."));
	}

}