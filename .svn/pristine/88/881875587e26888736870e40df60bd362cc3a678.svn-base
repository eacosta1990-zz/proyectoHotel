<%@ include file="/_acceso.jsp" %>
<%@ include file="/_menu.jsp"%>

<%@page import="java.util.List" %>
<%@page import="datos.Consumo" %>




<div class="page-header">
  <h1>Consumo <a href="./AltaConsumo" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i></a></h1>
</div>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Consumo</th>
			<th>Precio</th>
		</tr>
	</thead>
	<tbody>
<% 
if(request.getAttribute("LConsumo") != null){
	List<Consumo> c = (List<Consumo>) request.getAttribute("LConsumo");
	if(!c.isEmpty())
	for (Consumo tipo : c) {
%>
<tr>
	<td><%=tipo.getConsumo() %></td>
	<td>$<%=tipo.getPrecio() %></td>
	
	 <td class="text-right">
		<a href="./ModificarConsumo?id=<%=tipo.getIdConsumo()%>" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-pencil"></span></a>
		<a href="./EliminarConsumo?id=<%=tipo.getIdConsumo()%>" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash"></span></a> 
	</td>
</tr>
<%
	}
} else { 
%>
<tr>
	<td colspan="2">No hay datos</td>
</tr>
<% } %>
		
	</tbody>
</table>

<!-- Modal Eliminar-->
<div class="modal fade" id="ver" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title text-danger" id="myModalLabel">Eliminar</h4>
      </div>
      <div class="modal-body">
        ¿Está seguro que desea eliminar este registro?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        <button type="button" class="btn btn-danger">Eliminar</button>
      </div>
    </div>
  </div>
</div>

<%@ include file="/_footer.jsp"%>