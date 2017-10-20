<html>
<HEAD>
<META httpequiv="ContentType" content="text/html;charset=ISO88591" />

<script src="js/jquery.min.js" type="text/javascript"></script>
<script>


	
	function mostrarhabitacion() {
		var id = $('#idtipohabitacionselect').val();
		var capa=$('#capacidad').val();
		<%System.out.println("asd");%>
		if (id != "0") {
			$.ajax({
				method : "POST",
				url : " ./VistaHabitacion",
				data : {
					capa:capa,
					id :  id
				},
				async : false
			}).done(function(data) {
				$("#habitacionportipo").html(data);
			})
		} else {
			$("#habitacionportipo").html("");
		}
		
	}
	
		
	
</script>
</HEAD>
<body>
	<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
	<%@page import="datos.Estado"%>
	<%@page import="datos.Estadia"%>
	<%@page import="datos.Habitacion"%>
	<%@page import="datos.TipoHabitacion"%>
<%@page import="datos.FormaPago"%>
	


	<%@page import="java.util.List"%>

	<%@ include file="/_acceso.jsp"%>
	<%
		if (request.getAttribute("insert_hecho") != null) {
			response.sendRedirect("./Estadia?ok=true");
		}
	%>

	<%@ include file="/_menu.jsp"%>
	<%
		String nroHabitacion = "";

		String desde = "";
		String hasta = "";
		String dni = "";
		float senia = 0;
		float precio = 0;
		String titulo_pag = "Nueva";
		int idTipoHabitacion = 0;
		int idHabitacion = 0;
		int idFormaPago=0;
		int capacidad = 1;
		String selectHabitacion = "";
		String selectTipoHabitacion = "";
		if(request.getAttribute("estadia") != null){
			Estadia c = (Estadia) request.getAttribute("estadia");
			
			int id = c.getIdEstadia();
			senia=c.getSenia();
			
		
			
			
			titulo_pag = "Habitacion";
		}
	%>

	<ol class="breadcrumb">
		<li class="active"><%=titulo_pag%> Estadia</li>
	</ol>
	<form class="form-horizontal" action="" method="post">


		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Capacidad</label>
			<div class="col-sm-10">
				<select class="form-control" name="capacidad" id="capacidad">
					<option value="1" <%=(capacidad == 1) ? "selected" : ""%>>1</option>
					<option value="2" <%=(capacidad == 2) ? "selected" : ""%>>2</option>
					<option value="3" <%=(capacidad == 3) ? "selected" : ""%>>3</option>
					<option value="4" <%=(capacidad == 4) ? "selected" : ""%>>4</option>
					<option value="5" <%=(capacidad == 5) ? "selected" : ""%>>5</option>
					<option value="6" <%=(capacidad == 6) ? "selected" : ""%>>6</option>
					<option value="7" <%=(capacidad == 7) ? "selected" : ""%>>7</option>
					<option value="8" <%=(capacidad == 8) ? "selected" : ""%>>8</option>
					<option value="9" <%=(capacidad == 9) ? "selected" : ""%>>9</option>
					<option value="10" <%=(capacidad == 10) ? "selected" : ""%>>10</option>

				</select>
			</div>
		</div>

		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Tipo
				Habitacion</label>
			<div class="col-sm-10">
				<select name="idTipoHabitacion" id="idtipohabitacionselect" 	onchange="mostrarhabitacion();">
					<option value="0">Seleccione Tipo Habitacion</option>
					<%
						List<TipoHabitacion> tipoHabitaciones = (List) request.getAttribute("ListaTipoHabitacion");
						for (TipoHabitacion h : tipoHabitaciones) {
					%>
					<option value="<%=h.getIdTipoHabitacion()%>"><%=h.getTipoHabitacion()%></option>
					<%
						}
					%>
				</select>
			</div>
		</div>


		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Habitacion</label>
			<div id="habitacionportipo" name="idHabitacion"></div>
		</div>

		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">F.Desde</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="desde"
					required="required" value="<%=desde%>">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">F.Hasta</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="hasta"
					required="required" value="<%=hasta%>">
			</div>
		</div>


		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Se�a</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" name="senia"
					required="required" value="<%=senia%>">
			</div>
		</div>
		

<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Forma De Pago</label>
			<div class="col-sm-10">
				<select name="formaPago" >
					
					<option value="0">Seleccione Forma de Pago</option>
					<%
						List<FormaPago> formaPago = (List) request.getAttribute("ListaFormaPago");
						for (FormaPago h : formaPago) {
					%>
					<option value="<%=h.getIdFormaPago()%>"><%=h.getFormaPago()%></option>
					<%
						}
					%>
				</select>
			</div>
		</div>




		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Documento</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" name="dni"
					required="required" value="<%=dni%>">
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10  text-right">
				<button type="submit" class="btn btn-success">Guardar</button>
			</div>
		</div>

	
	</form>

	<%@ include file="/_footer.jsp"%>

</body>
</html>



