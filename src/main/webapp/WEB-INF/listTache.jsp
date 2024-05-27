<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Task List</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h2 class="mt-4 mb-4">Task List for Project ${idProjet}</h2>
  <a href="tache?action=newTache&idProjet=${idProjet}" class="btn btn-primary mb-4">Add New Task</a>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Description</th>
      <th>Start Date</th>
      <th>End Date</th>
      <th>Status</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="tache" items="${listTache}">
      <tr>
        <td>${tache.idTache}</td>
        <td>${tache.nomTache}</td>
        <td>${tache.tacheDescription}</td>
        <td>${tache.dateDbTache}</td>
        <td>${tache.dateFinTache}</td>
        <td>${tache.statut}</td>
        <td>
          <a href="tache?action=editTache&idTache=${tache.idTache}" class="btn btn-warning btn-sm">Edit</a>
          <a href="tache?action=deleteTache&idTache=${tache.idTache}" class="btn btn-danger btn-sm">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <a href="projet?action=listProjet" class="btn btn-secondary">Back to Project List</a>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
