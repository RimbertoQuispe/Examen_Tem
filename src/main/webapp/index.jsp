<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Almacen"%>
<%
    List<Almacen>TEM = (List<Almacen>)request.getAttribute("TEM");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
          <table border="1">
            <td>
                 <p>2DO PARCIAL PRACTICO TEM-742<p>
                <p>Nombre: Rimberto Quispe Alanoca<p>
                <p>Carnet: 8425404 L.P.<p>
            </td>
        </table>
        
        
     
        <p><a href="Inicio?action=add">Nuevo producto</a></p>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>DESCRIPCION</th>
                <th>CANTIDAD</th>
                <th>PRECIO</th><!--   <th>Contenido</th> -->
                  <th>CATEGORIA</th>
                <th>Editar</th>
                 <th>Eliminar</th>
            </tr>
            <c:forEach var="item" items="${TEM}">
            <tr>
                <td>${item.id}</td>
                <td>${item.descripcion}</td>
                <td>${item.cantidad}</td>
                 <td>${item.precio}</td>
                  <td>${item.categoria}</td>
                <td><a href="Inicio?action=edit&id=${item.id}">Editar</a> </td>
                   
                <td><a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Estas seguro?'))">Eliminar</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>