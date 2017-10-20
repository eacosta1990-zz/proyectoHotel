<%@ include file="/_acceso.jsp" %>
<%@ include file="/_menu.jsp"%>
<%@page import="datos.Cliente" %>
<%
if(request.getAttribute("insert_hecho") != null){
     response.sendRedirect("./Cliente?ok=true");
}
%>
<%
String nombre="";
String apellido="";
long dni=0;
String telefono="";
String direccion="";
String email="";

int id = 0;
int idTipoEmpleado=0;
String titulo_pag = "Nuevo";
if(request.getAttribute("cliente") != null){
	Cliente c = (Cliente) request.getAttribute("cliente");
	id = c.getIdCliente();
	nombre= c.getNombre();
	apellido= c.getApellido();
	dni= c.getDni();
	telefono= c.getTelefono();
	direccion= c.getDireccion();
	email= c.getEmail();
	
	
	titulo_pag = "Modificar";
}


%>
<ol class="breadcrumb">
  <li><a href="cliente.jsp">Cliente</a></li>
  <li class="active">Alta Cliente</li>
</ol>
<form class="form-horizontal" action="" method="post">
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="nombre" value="<%=nombre %>">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Apellido</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="apellido" value="<%=apellido %>">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">DNI</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="dni" value="<%=dni %>">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Teléfono</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="telefono" value="<%=telefono %>">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Direccion</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="direccion" value="<%=direccion %>">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Email</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" name="email" value="<%=email %>">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10  text-right">
			<button type="submit" class="btn btn-success">Guardar</button>
		</div>
	</div>
</form>
<%@ include file="/_footer.jsp"%>