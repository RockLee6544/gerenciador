<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List,br.com.gerenciador.modelo.Empresa" %>
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
<ul>
	<c:forEach items="${empresas}" var="empresa" >
		
		<li>
		  ${empresa.nome} - <fmt:formatDate 
		  value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
		  <a href="${controller}?acao=RemoveEmpresa&id=${empresa.id}" >Remover</a>
		  <a href="${controller}?acao=MostraEmpresa&id=${empresa.id}" >Editar</a>
		</li>
	</c:forEach>
</ul>

</body>
</html>