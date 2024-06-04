<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Estudiante"%>
<%
    List<Estudiante> estudiante = (List<Estudiante>) request.getAttribute("estudiante");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Listado de Estudiantes</title>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
  <h1>LISTADO DE ESTUDIANTES</h1>
  <div>
      <h1>Victor Hugo Rosa Mamani
              RU: 200051444
              CI: 13873717
      </h1>
  </div>
  <br>
  <a href="MainController?action=add" class="btn btn-primary">Agregar Nuevo Estudiante</a>
  <br>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nombres</th>
        <th>Apellidos</th>
        <th>Email</th>
        <th>Fecha de Nacimiento</th>
        <th>Acciones</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="estudiante" items="${estudiante}">
        <tr>
          <td>${estudiante.id}</td>
          <td>${estudiante.nombres}</td>
          <td>${estudiante.apellidos}</td>
          <td>${estudiante.email}</td>
          <td><fmt:formatDate value="${estudiante.fechaNac}" pattern="yyyy-MM-dd" var="fechaform"/>${fechaform}</td>
          <td>
            <a href="MainController?action=edit&id=${estudiante.id}" class="btn btn-warning">Editar</a> |
            <a href="MainController?action=delete&id=${estudiante.id}" onclick="return confirm('¿Está seguro de eliminar este estudiante?');" class="btn btn-danger">Eliminar</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <br>
</body>
</html>
