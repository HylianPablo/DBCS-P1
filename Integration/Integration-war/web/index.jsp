<%-- 
    Document   : index
    Created on : 22-oct-2020, 19:33:06
    Author     : cevp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TiendaPC</title>
    </head>
    <body>
        <% if (session.isNew()) {%>
        <% session.setAttribute("pagina", "index"); %>
        <p>Introduce nombre cif y clave</p>
        <form action="controladorIndex" name="ejemplo" method="get">
            NIF: <input type="text" name="NifCif"><br>
            Password: <input type="password" name="clave"><br><br>
        <input type="submit" name="botonE" value="Acceder Empleado">
        <input type="submit" name="botonC" value="Acceder Cliente">
        <input type="reset" value="Vaciar">
        </form>
        <% } else {%>
        <% session.setAttribute("pagina", "index"); %>
        <!-- Mediante el atributo "mensaje" mostramos los errores o indicaciones
             que consideremos en cada caso -->
        <h1><%= session.getAttribute("mensaje")%> </h1>
        <p>Introduce nombre cif y clave</p>
        <form action="controladorIndex" name="ejemplo" method="get">
            NIF: <input type="text" name="NifCif"><br>
            Password: <input type="password" name="clave"><br><br>
        <input type="submit" name="botonE" value="Acceder Empleado">
        <input type="submit" name="botonC" value="Acceder Cliente">
        <input type="reset" value="Vaciar">
        </form>
        <% } %>
    </body>
</html>
