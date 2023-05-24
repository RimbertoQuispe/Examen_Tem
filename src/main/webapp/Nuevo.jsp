<%-- 
    Document   : Nuevo
    Created on : 16 may. 2023, 20:22:03
    Author     : Rimberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
          <table border="1">
            <td>
                <p>2DO PARCIAL PRACTICO TEM-742<p>
                <p>Nombre: Rimberto Quispe Alanoca<p>
                <p>Carnet: 8425404 L.P.<p>
            </td>
        </table>
    </head>
    <body>
        <h1>Nuevo </h1>
        <form action="Inicio" method="post">
            <input type="hidden" name="id" value ="${TEM.id}"/>
            <table>

                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion" value="${TEM.descripcion}" /></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="number" step="0.01"  name="cantidad" value="${TEM.cantidad}" /></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio" value="${TEM.precio}" /></td>
                </tr>
                <tr>
                    <td>Categoria</td>
                    <td><input type="text" name="categoria" value="${TEM.categoria}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>


        </form>
    </body>
</html>
