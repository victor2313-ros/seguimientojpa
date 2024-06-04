<%@page import="com.emergentes.entidades.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    Estudiante estudiante = (Estudiante) request.getAttribute("estudiante");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Editar Estudiante</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Editar Estudiante</h1>
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="guardar">
            <input type="hidden" name="id" value="${estudiante.id}">
            <div class="mb-3">
                <p>
                    <label for="nombre" class="form-label">Nombres:</label>
                    <input type="text" name="nombres" class="form-control" id="nombre" value="${estudiante.nombres}" required>
                </p>
                <p>
                    <label for="apellidos" class="form-label" >Apellidos:</label>
                    <input type="text" name="apellidos" class="form-control" id="apellidos" value="${estudiante.apellidos}" required>
                </p>
                <p>
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" name="email"  class="form-control" id="email" value="${estudiante.email}" required>
                </p>
                <p>
                    <label for="fechaNac" class="form-label">Fecha de Nacimiento:</label>
                    <fmt:formatDate value="${estudiante.fechaNac}" pattern="yyyy-MM-dd" var="fechaNacFormateada" />
                    <input type="date" name="fechaNac" class="form-control" id="fechaNac" value="${fechaNacFormateada}" required>
                </p>
                <p>
                    <button type="submit" class="btn-primary">Guardar</button>
                </p>
            </div>
        </form>
    </body>
</html>
