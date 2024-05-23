<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Projets</title>
    <!-- Link vers Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <!-- Vos styles CSS personnalisés -->
    <style>
        .project-actions {
            display: flex;
            justify-content: space-between;
        }
        .btn-edit,
        .btn-delete {
            margin-right: 5px;
        }
        .btn-success {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h2>Liste des Projets</h2>
    <table class="table table-bordered mt-3">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Nom du Projet</th>
            <th scope="col">Description</th>
            <th scope="col">Date de Début</th>
            <th scope="col">Date de Fin</th>
            <th scope="col">Budget</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="projet" items="${listProjet}">
            <tr>
                <td>${projet.idProjet}</td>
                <td>${projet.nomProjet}</td>
                <td>${projet.description}</td>
                <td>${projet.dateDebut}</td>
                <td>${projet.dateFin}</td>
                <td>${projet.budget}</td>
                <td class="project-actions">
                    <a href="edit?id=${projet.idProjet}" class="btn btn-primary btn-sm btn-edit">Modifier</a>
                    <a href="delete?id=${projet.idProjet}" class="btn btn-danger btn-sm btn-delete">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="new" class="btn btn-success">Ajouter un nouveau projet</a>
</div>
</body>
</html>
