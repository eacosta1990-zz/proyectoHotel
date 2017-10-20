<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="datos.Habitacion" %>

<%@page import="datos.TipoHabitacion" %>
<%@page import="java.util.List" %>

<%@ include file="/_acceso.jsp" %>
<%
if(request.getAttribute("insert_hecho") != null){
     response.sendRedirect("./Habitacion?ok=true");
}
%>

<%@ include file="/_menu.jsp"%>
<%
String nroHabitacion="";
String capacidadMax = "";
int disponible = 1;
int id_tipoHabitacion = 0;
int id = 0;

String titulo_pag = "Nuevo";
if(request.getAttribute("habitacion") != null){
	Habitacion c = (Habitacion) request.getAttribute("habitacion");
	
	id = c.getIdHabitacion();
	
	nroHabitacion = c.getNroHabitacion();
	capacidadMax = Integer.toString(c.getCapacidadMax());
	disponible = c.getDisponible();
	id_tipoHabitacion = c.getTipoHabitacion().getIdTipoHabitacion();
	
	
	titulo_pag = "Habitacion";
}


String selectTipoHabitacion = "";
if(request.getAttribute("ListatipoHabitacion") != null){
	List<TipoHabitacion> tipoHabitaion = (List<TipoHabitacion>) request.getAttribute("ListatipoHabitacion");
	
	for (TipoHabitacion tipo : tipoHabitaion) {
		String selected = (id_tipoHabitacion==tipo.getIdTipoHabitacion()) ? "selected" : "";
		selectTipoHabitacion += "<option value='" +tipo.getIdTipoHabitacion()+ "' " +selected+ ">"+ tipo.getTipoHabitacion() +"</option>";
	}
}
%>

<ol class="breadcrumb">
  <li class="active"><%=titulo_pag %> Habitación</li>
</ol>
<form class="form-horizontal" action="" method="post">
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label">Nro Habitación</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="nro_habitacion" required="required" value="<%=nroHabitacion %>">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Capacidad Máxima</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" name="capacidad_max" required="required" value="<%=capacidadMax %>">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Disponible</label>
		<div class="col-sm-10">
			<select class="form-control" name="disponible">
				<option value="1" <%=(disponible==1) ? "selected":"" %>>Disponible</option>
				<option value="0" <%=(disponible==0) ? "selected":"" %>>No disponible</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Tipo	Habitación</label>
		<div class="col-sm-10">
			<select class="form-control" name="id_tipo_habitacion" required="required">
				<option value="">Seleccionar...</option>
				<%=selectTipoHabitacion %>
				
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10  text-right">
			<button type="submit" class="btn btn-success">Guardar</button>
		</div>
	</div>
</form>
<%@ include file="/_footer.jsp"%>