<html>
<HEAD>
<META httpequiv="ContentType" content="text/htmlÍ¾charset=ISO88591" />

<script src="js/jquery.min.js" type="text/javascript"></script>
<script>

	function mostrarConsumos() {
		var id = $('#idClienteSelect').val();
	if (id != "0") {
			$.ajax({
				method : "POST",
				url : " ./VistaConsumo",
				data : {
					id : id
				},
				async : false
			}).done(function(data) {
				$("#idConsumosCliente").html(data);
			})
		} else {
			$("#idConsumosCliente").html("");
		}

	}
</script>
</HEAD>
<body>

	<%@ include file="/_acceso.jsp"%>
	<%@ include file="/_menu.jsp"%>
	<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

	<%@page import="java.util.List"%>
	<%@page import="datos.Consumo"%>
	<%@page import="datos.Cliente"%>
	<%@page import="datos.Servicio"%>

	<%
		int cantidad = 0;
	%>




	<div class="page-header">
		<h1>Generar Consumo</h1>
	</div>
	<form class="form-horizontal" action="" method="post">
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Seleccione
				Cliente</label>
			<div class="col-sm-10">
				<select name="cliente"	id="idClienteSelect"  onchange="mostrarConsumos();">

					<option value="0">Seleccione Dni Cliente</option>
					<%
						List<Cliente> clientes = (List) request.getAttribute("ListaCliente");
						for (Cliente c : clientes) {
					%>
					<option value="<%=c.getIdCliente()%>"><%=c.getDni()%></option>
					<%
						}
					%>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Seleccione
				Producto</label>
			<div class="col-sm-10">
				<select name="producto">

					<option value="0">Seleccione Producto</option>
					<%
						List<Consumo> consumos = (List) request.getAttribute("listaConsumo");
						for (Consumo consumo : consumos) {
					%>
					<option value="<%=consumo.getIdConsumo()%>"><%=consumo.getConsumo()%></option>
					<%
						}
					%>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Cantidad
				Producto</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" name="cantidad"
					value="<%=cantidad%>">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10  text-right">
				<button type="submit" class="btn btn-success">Guardar</button>
			</div>
		</div>
	</form>

		
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">
			</label>
		<div id="idConsumosCliente" name="consumosCliente"></div>
	</div>
<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10  text-right">
				<button id="cerrarTicket" type="button" class="btn btn-success">Cerrar ticket </button>
			</div>
		</div>
	<%System.out.println("id ticket consumo "+request.getParameter("id"));%>
	<%@ include file="/_footer.jsp"%>

</body>
</html>
	