<%
HttpSession sessionns = request.getSession(false);
if(sessionns != null)
	sessionns.invalidate();
response.sendRedirect(".");
//request.getRequestDispatcher("/login.jsp").forward(request,response);
%>