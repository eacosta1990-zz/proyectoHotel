
<%@ page language="java" contentType="text/html; "%>
<%@ page import="datos.Habitacion"%>
<%@ page import="datos.Estadia"%>
<%@ page import="datos.TipoHabitacion"%>


<%@ page import="java.util.List"%>

<div class="col-sm-10">
	<select name="idHabitacion">
		<option value="0">Seleccione Habitacion</option>
		<%
		String selectHabitacion="";
			List<Habitacion> habitaciones = (List) request.getAttribute("id");
			for (Habitacion h : habitaciones) {
		%>
		<option value="<%=h.getIdHabitacion()%>"><%=h.getNroHabitacion()%></option>
		<%
		
			}
		%>
	</select>
	
	<% int cas=Integer.parseInt(request.getParameter("capa")); %>
	
</div>



