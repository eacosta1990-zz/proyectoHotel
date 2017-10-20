<%@ page language="java" contentType="text/html"%>
<%@ page import="java.util.List"%>
<%@ page import="datos.TicketConsumo"%>
<%@ page import="datos.TicketConsumoItem"%>
<%@ page import="datos.Consumo"%>

<%
	float total = 0;
%>

<div class="col-sm-10">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Consumo</th>
				<th>Cantidad</th>
				<th>Precio Unidad</th>
				<th>Sub Total</th>

			</tr>
		</thead>
	
	
		<%
			TicketConsumo tie = (TicketConsumo) request.getAttribute("id");

			for (TicketConsumoItem t : tie.getTicketConsumoItem()) {
		%>
	
				<tr>
					<th><%=t.getConsumo().getConsumo()%></th>
					<th><%=t.getCantidad()%></th>
					<th>$ <%=t.getConsumo().getPrecio()%></th>
					<th>$ <%=t.getPrecio() * t.getCantidad()%></th>
					<%
						total = total + t.getPrecio() * t.getCantidad();
					%>
				</tr>
		
		
		<%
			}
		%>
		
			<tr>
				<th></th>
				<th></th>
				<th></th>
				<th>Total $ <%=total%></th>
			</tr>
		</table>
</div>



