<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="datos.TipoMantenimiento" %>
<%@page import="funciones.Funciones" %>

<%@page import="datos.TicketMantenimiento" %>


<%@page import="java.util.List" %>

<%@ include file="/_acceso.jsp" %>
<%
if(request.getAttribute("insert_hecho") != null){
     response.sendRedirect("./TicketMantenimiento?ok=true");
}
%>

<%@ include file="/_menu.jsp"%>
<%


String problema="";
String fechaInicio ="";
String fechaResolucion = "";
boolean terminado=false;
float precio = 0;
int idLogin=1;
int idTipoMantenimiento=0;

String titulo_pag = "Nueva";
if(request.getAttribute("ticketMantenimiento") != null){
	TicketMantenimiento c = (TicketMantenimiento) request.getAttribute("ticketMantenimiento");
	problema=c.getProblema();
	fechaInicio =Funciones.SOLOobtenerFecha(c.getFechaInicio());
	fechaResolucion = Funciones.SOLOobtenerFecha(c.getFechaResolucion());
	terminado=c.isTerminado();
	precio = c.getPrecio();
	idLogin= c.getLogin().getIdLogin();
	idTipoMantenimiento=c.getTipoMantenimiento().getIdTipoMantenimiento();
	
	titulo_pag = "Modificar";
}


String selectTipoMantenimiento = "";
if(request.getAttribute("ListaTipoMantenimiento") != null){
	List<TipoMantenimiento> tipoMantenimiento = (List<TipoMantenimiento>) request.getAttribute("ListaTipoMantenimiento");
	
	for (TipoMantenimiento tipo : tipoMantenimiento) {
		String selected = (idTipoMantenimiento==tipo.getIdTipoMantenimiento()) ? "selected" : "";
		selectTipoMantenimiento += "<option value='" +tipo.getIdTipoMantenimiento()+ "' " +selected+ ">"+ tipo.getTipoMantenimiento() +"</option>";
	}
}
%>

<ol class="breadcrumb">
  <li class="active"><%=titulo_pag %> Ticket Mantenimiento</li>
</ol>
<form class="form-horizontal" action="" method="post">
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label">Problema</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="problema" required="required" value="<%=problema %>">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Fecha Inicio</label>
		<div class="col-sm-10">
			<input type="date" class="form-control" name="fechaInicio" required="required" value="<%=fechaInicio %>">
		</div>
	</div>
		<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Fecha Resolucion</label>
		<div class="col-sm-10">
			<input type="date" class="form-control" name="fechaResolucion" required="required" value="<%=fechaResolucion %>">
		</div>
	</div>
			<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Precio</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" name="precio" required="required" value="<%=precio %>">
		</div>
	</div>
			<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Terminado</label>
		<div class="col-sm-10">
		    <select class="form-control" name="terminado" required="required">
				<option value="true">Si</option>
				<option value="false">No</option>
			</select>
		</div>
	</div>
	
	
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">TipoMantenimiento</label>
		<div class="col-sm-10">
			<select class="form-control" name="idTipoMantenimiento" required="required">
				<option value="">Seleccionar...</option>
				<%=selectTipoMantenimiento %>
			</select>
		</div>
	</div>
			
	<input type="hidden" class="form-control" name="idLogin" required="required" value="<%=idLogin %>">


	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10  text-right">
			<button type="submit" class="btn btn-success">Guardar</button>
		</div>
	</div>
</form>
<%@ include file="/_footer.jsp"%>