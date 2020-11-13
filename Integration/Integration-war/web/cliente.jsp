<%-- 
    Document   : cliente
    Created on : 22-oct-2020, 20:08:20
    Author     : cevp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TiendaPC Cliente</title>
    </head>
    <body>
        <!-- El atributo mensaje se usara para mostrar avisos al usuario, por ejemplo
             el resultado de una operacion -->
        <h1><%= session.getAttribute("mensaje")%></h1>
        
        <h2>Escoja opción</h2>
        <form action="controladorHacerPedido" name="ejemplo" method="get">
            <input type="submit" value="Hacer Pedido" name="envio"> <br>
        </form>
        <form action="controladorBorrarPedido" name="ejemplo2" method="get">
            <input type="submit" value="Borrar Pedido" name="envio2"> <br>
        </form>
        <form action="controladorImportePedido" name="ejemplo3" method="get">
            <input type="submit" value="Importe Pedidos Completados" name="envio3"><br>
        </form>
        <form action="index.jsp" name="ejemplo4" method="get">
            <input type="submit" value="Salir" name="envio4"><br>
            <%session.setAttribute("mensaje","Menú principal");%>
        </form>
    </body>
</html>
