<%@page import="datos.Empleado" %>
<%@page import="datos.TipoEmpleado" %>
<%@page import="java.util.List" %>
<%@page import="datos.Login" %>

<%@ include file="/_acceso.jsp" %>
<%
if(request.getAttribute("insert_hecho") != null){
	System.out.println(request.getAttribute("insert_hecho"));
     response.sendRedirect("./Empleado?ok=true");
}
%>

<%@ include file="/_menu.jsp"%>
<%
String nombre="";
String apellido="";
long dni=0;
String telefono="";
String direccion="";
String email="";
String legajo="";
float sueldo=0;
String usuario="";
String clave="";
float precio=0;
int id = 0;
int idTipoEmpleado=0;
String titulo_pag = "Nuevo";
if(request.getAttribute("empleado") != null){
	Empleado c = (Empleado) request.getAttribute("empleado");
	Login l = (Login) request.getAttribute("login");
	id = c.getIdEmpleado();
	nombre= c.getNombre();
	apellido= c.getApellido();
	dni= c.getDni();
	telefono= c.getTelefono();
	direccion= c.getDireccion();
	email= c.getEmail();
	legajo= c.getNroLegajo();
	sueldo= c.getSueldo();
	usuario= l.getUsuario();
	//clave= l.getClave();
	
	titulo_pag = "Modificar";
}
String selectTEmpleado = "";
if(request.getAttribute("ListatipoEmpleado") != null){
	List<TipoEmpleado> tipoEmpleado = (List<TipoEmpleado>) request.getAttribute("ListatipoEmpleado");
	
	for (TipoEmpleado tipo : tipoEmpleado) {
		String selected = (idTipoEmpleado== tipo.getIdTipoEmpleado()) ? "selected" : "";
		selectTEmpleado += "<option value='" +tipo.getIdTipoEmpleado()+ "' " +selected+ ">"+ tipo.getTipoEmpleado() +"</option>";
	}
}

%>

<ol class="breadcrumb">
  <li class="active"><%=titulo_pag %> Empleado</li>
</ol>

<form class="form-horizontal" action="" method="post">
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="nombre" value="<%=nombre %>" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Apellido</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="apellido" id="apellido" value="<%=apellido %>" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">DNI</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="dni"id="dni" value="<%=dni %>" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Teléfono</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="telefono" id="telefono" value="<%=telefono %>">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Direccion</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="direccion" id="direccion" value="<%=direccion %>">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Email</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" name="email"id="email" value="<%=email %>" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Legajo</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="legajo" id="legajo" value="<%=legajo %>">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Sueldo</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" name="sueldo" id="sueldo" value="<%=sueldo %>">
		</div>
	</div>
		<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Tipo	Empleado</label>
		<div class="col-sm-10">
			<select class="form-control" name="tipoemple" required="required">
				<option value="">Seleccionar...</option>
				<%=selectTEmpleado %>
				
			</select>
		</div>
	</div>
		<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Privilegio</label>
		<div class="col-sm-10">
			<select class="form-control" name="privilegio" required="required">
				<option value="">Seleccionar...</option>
				<option value="20">Recepcionista</option>
				<option value="10">Mucama</option>
				<option value="30">Encargador Mantenimiento</option>
				<option value="40">Adminitrador</option>
				
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Usuario</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="usuario" value="<%=usuario %>" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Contraseña</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" name="clave" value="<%=clave %>">
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10  text-right">
			<button type="submit" class="btn btn-success">Guardar</button>
		</div>
	</div>
</form>
<%@ include file="/_footer.jsp"%>