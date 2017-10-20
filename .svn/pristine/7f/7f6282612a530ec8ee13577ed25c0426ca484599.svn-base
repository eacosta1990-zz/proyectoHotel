<%@page import="datos.TipoEmpleado" %>

<%@ include file="/_acceso.jsp" %>
<%
if(request.getAttribute("insert_hecho") != null){
     response.sendRedirect("./TipoEmpleado?ok=true");
}
%>

<%@ include file="/_menu.jsp"%>
<%
String nombre="";
int id = 0;
String titulo_pag = "Nuevo";
if(request.getAttribute("tipoEmpleado") != null){
	TipoEmpleado c = (TipoEmpleado) request.getAttribute("tipoEmpleado");
	nombre = c.getTipoEmpleado();
	id = c.getIdTipoEmpleado();
	
	titulo_pag = "Modificar";
}
%>

<ol class="breadcrumb">
  <li class="active"><%=titulo_pag %> Tipo Empleado</li>
</ol>

<form class="form-horizontal" action="" method="post">
	<input type="hidden" name="id" value="<%=id %>">
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="nombre" value="<%=nombre %>">
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10  text-right">
			<button type="submit" class="btn btn-success">Guardar</button>
		</div>
	</div>
</form>

<%@ include file="/_footer.jsp"%>