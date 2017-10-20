<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<%@page import="datos.Frigobar" %>
<%@page import="datos.Consumo" %>
<%@page import="datos.FrigobarItem" %>
<%@page import="java.util.List" %>

<%@ include file="/_acceso.jsp" %>
<%
if(request.getAttribute("insert_hecho") != null){
     response.sendRedirect("./FrigobarItem?ok=true");
}
%>

<%@ include file="/_menu.jsp"%>
<%
int id_Consumo=0;
int id_Frigobar=0;
int stock_Deseable = 0;
int stock_Existente = 0;
int id = 0;

String titulo_pag = "Nuevo";
if(request.getAttribute("frigobarItem") != null){
	FrigobarItem c = (FrigobarItem) request.getAttribute("frigobarItem");
	
	id = c.getIdFrigobarItem();
	stock_Deseable = c.getStockDeseable();
	stock_Existente = c.getStockExistente();
	id_Consumo=c.getConsumo().getIdConsumo();
	id_Frigobar=c.getFrigobar().getIdFrigobar();
	
	
	
	titulo_pag = "Frigobar Item";
}


String selectConsumo = "";
if(request.getAttribute("lConsumo") != null){
	List<Consumo> consumo = (List<Consumo>) request.getAttribute("lConsumo");
	
	for (Consumo tipo : consumo) {
		String selected = (id_Consumo==tipo.getIdConsumo()) ? "selected" : "";
		selectConsumo += "<option value='" +tipo.getIdConsumo()+ "' " +selected+ ">"+ tipo.getConsumo() +"</option>";
	}
}

String selectFrigobar = "";
if(request.getAttribute("lFrigobar") != null){
	List<Frigobar> frigobar = (List<Frigobar>) request.getAttribute("lFrigobar");
	
	for (Frigobar tipo : frigobar) {
		String selected = (id_Frigobar==tipo.getIdFrigobar()) ? "selected" : "";
		selectFrigobar += "<option value='" +tipo.getIdFrigobar()+ "' " +selected+ ">"+ tipo.getFrigobar() +"</option>";
	}
}
%>

<ol class="breadcrumb">
  <li class="active"><%=titulo_pag %> Frigobar Item</li>
</ol>
<form class="form-horizontal" action="" method="post">
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label">Stock Deseable</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" name="stockDeseable" required="required" value="<%=stock_Deseable %>">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Stock Existente</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" name="stockExistente" required="required" value="<%=stock_Existente %>">
		</div>
	</div>

	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Consumo</label>
		<div class="col-sm-10">
			<select class="form-control" name="idConsumo" required="required">
				<option value="">Seleccionar...</option>
				<%=selectConsumo %>
				
			</select>
		</div>
	</div>
		<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Frigobar</label>
		<div class="col-sm-10">
			<select class="form-control" name="idFrigobar" required="required">
				<option value="">Seleccionar...</option>
				<%=selectFrigobar %>
				
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