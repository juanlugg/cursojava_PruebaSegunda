<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.curso.modelo.*"%>
<%@ page import="com.curso.service.AlmacenService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AÃ±adir Producto</title>
</head>
<body style="background-color: #c4fffc">
	<h1 align="center"><i>AÑADIR PRODUCTO</i></h1>
	<div align="center">
		<form action="AddServlet" method="get">
			<input type="text" name="id"> 
			<input type="text" name="nombre">
			<select name="categoria"> 
				<% for(Categoria c : Categoria.values()){%>
			<option value="<%=c%>"><%=c%></option>	
			<%}%>
			</select>
			<input type="text" name="precio"> 
			<input type="text" name="stock"> 
			<input type="submit" value="ACEPTAR">
		</form>
	</div>
</body>
</html>