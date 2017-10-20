<%@page import="datos.Consumo" %>

<%@ include file="/_acceso.jsp" %>
<%
if(request.getAttribute("insert_hecho") != null){
     response.sendRedirect("./Consumo?ok=true");
}
%>

<%@ include file="/_menu.jsp"%>
<%
String consumo="";
float precio= 0;
String titulo_pag = "Nuevo";

if(request.getAttribute("consumo") != null){
	Consumo c = (Consumo) request.getAttribute("consumo");
	consumo = c.getConsumo();
	precio = c.getPrecio();
	
	titulo_pag = "Modificar";
}
%>

<ol class="breadcrumb">
  <li class="active"><%=titulo_pag %>Consumo</li>
</ol>

<form class="form-horizontal" action="" method="post">
	
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label">Consumo</label>
		<div class="col-sm-10">
			<input type="text" required class="form-control" name="consumo" value="<%=consumo %>">
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label">Precio</label>
		<div class="col-sm-10">
					<div class="input-group">
 				 		<span class="input-group-addon" id="basic-addon1">$</span>
						<input type="number" class="form-control" required name="precio" value="<%=precio %>">
					</div>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10  text-right">
			<button type="submit" class="btn btn-success">Guardar</button>
		</div>
	</div>
</form>

<%@ include file="/_footer.jsp"%>