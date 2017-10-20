<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
if(request.getSession().getAttribute("idLogin") == null){
     response.sendRedirect("login.jsp");
     // System.exit(0);
}
int privi = 9999;
if(request.getSession().getAttribute("privilegio") != null){
	privi = Integer.parseInt(request.getSession().getAttribute("privilegio").toString());
}


%>