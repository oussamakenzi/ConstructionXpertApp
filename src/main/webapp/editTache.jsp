<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 27/05/2024
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Task</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="mt-4 mb-4">Edit Task</h2>
    <form action="tache?action=updateTache" method="post">
        <div class="form-group">
            <label for="nomTache">Task Name</label>
            <input type="text" class="form-control" id="nomTache" name="nomTache" value="${tache.nomTache}" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description" required>${tache.tacheDescription}</textarea>
        </div>
        <div class="form-group">
            <label for="dateDbTache">Start Date</label>
            <input type="date" class="form-control" id="dateDbTache" name="dateDbTache" value="${tache.dateDbTache}" required>
        </div>
        <div class="form-group">
            <label for="dateFinTache">End Date</label>
            <input type="date" class="form-control" id="dateFinTache" name="dateFinTache" value="${tache.dateFinTache}" required>
        </div>
        <div class="form-group">
            <label for="status">Status</label>
            <input type="text" class="form-control" id="status" name="status" value="${tache.statut}" required>
        </div>
        <input type="hidden" name="idTache" value="${tache.idTache}">
        <input type="hidden" name="idProjet" value="${tache.idProjet}">
        <button type="submit" class="btn btn-primary">Save</button>
        <a href="tache?action=listTache&idProjet=${tache.idProjet}" class="btn btn-secondary">Cancel</a>
    </form>
</div>
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
>
