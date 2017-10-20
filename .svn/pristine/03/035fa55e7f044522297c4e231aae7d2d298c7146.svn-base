<%@ include file="/_acceso.jsp" %>

<%@ include file="/_menu.jsp" %>
<br />

<div class="row well">
    <div class="col-sm-12 text-center"><p class="text-muted">Accesos rápidos</p></div>
    
    <%if(privi==40){ // admin%>
    
	<div class="col-md-3 col-sm-4"">
		<a href="./Empleado" class="btn btn-block btn-success btn-lg"><i class="glyphicon glyphicon-briefcase"></i> Empleados</a>
	</div>
	<div class="col-md-3 col-sm-4">
		<a href="./Cliente" class="btn btn-block btn-warning btn-lg"><i class="glyphicon glyphicon-user"></i> Clientes</a>
	</div>
	<div class="col-md-3 col-sm-4">
		<a href="./Habitacion" class="btn btn-block btn-primary btn-lg"><i class="glyphicon glyphicon-briefcase"></i> Habitaciones</a>
	</div>
	<div class="col-md-3 col-sm-4">
		<a href="./Estadia" class="btn btn-block btn-danger btn-lg"><i class="glyphicon glyphicon-briefcase"></i> Estadías</a>
	</div>
	
	<% } else if(privi==30){ // mantenimento%>
	
	<div class="col-md-offset-3 col-md-3 col-sm-4"">
		<a href="./TipoMantenimiento" class="btn btn-block btn-success btn-lg"><i class="glyphicon glyphicon-briefcase"></i> Tipo Mantenimiento</a>
	</div>
	<div class="col-md-3 col-sm-4">
		<a href="./TicketMantenimiento" class="btn btn-block btn-warning btn-lg"><i class="glyphicon glyphicon-tag"></i> Ticket Mantenimiento</a>
	</div>
	
	<% } else if(privi==20){ // recepcion%>
	
	<div class="col-md-offset-3 col-md-3 col-sm-4"">
		<a href="./Frigobar" class="btn btn-block btn-success btn-lg"><i class="glyphicon glyphicon-briefcase"></i> Frigobar</a>
	</div>
	<div class="col-md-3 col-sm-4">
		<a href="./Habitacion" class="btn btn-block btn-warning btn-lg"><i class="glyphicon glyphicon-tag"></i> Habitacion</a>
	</div>
	
	<% } else if(privi==10){ // mantenimento%>
	

	<div class="col-md-offset-4 col-sm-4">
		<a href="./TicketMantenimiento" class="btn btn-block btn-warning btn-lg"><i class="glyphicon glyphicon-tag"></i> Ticket Mantenimiento</a>
	</div>
	
	<% } %>
</div>

<%@ include file="/_footer.jsp" %>