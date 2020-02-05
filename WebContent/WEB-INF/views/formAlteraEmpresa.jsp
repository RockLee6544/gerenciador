<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="controller"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${controller}" method="post">
	    Nome: <input type="text" name="nome" <c:if test="${not empty empresa}"> value="${empresa.nome}" </c:if>/>
	  	Data Abertura: <input type="text" name="dataAbertura" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" /> "/>
	   <input type="hidden" name="id" value="${empresa.id}" / >
	   <input type="hidden"	 name="acao" value="AlteraEmpresa"  />
	   <input type="submit" />
	</form>

</body>
</html>