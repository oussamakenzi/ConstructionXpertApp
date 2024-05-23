<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire de Projet</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="mt-5">${projet != null ? 'Modifier Projet' : 'Nouveau Projet'}</h2>
    <form action="${projet != null ? 'update' : 'insert'}" method="get">
        <input type="hidden" name="id" value="${projet != null ? projet.idProjet : ''}">
        <div class="form-group">
            <label for="nomProjet">Nom du Projet</label>
            <input type="text" class="form-control" id="nomProjet" name="nomProjet" value="${projet != null ? projet.nomProjet : ''}" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description" rows="3" required>${projet != null ? projet.description : ''}</textarea>
        </div>
        <div class="form-group">
            <label for="dateDebut">Date de Début</label>
            <input type="date" class="form-control" id="dateDebut" name="dateDebut" value="${projet != null ? projet.dateDebut : ''}" required>
        </div>
        <div class="form-group">
            <label for="dateFin">Date de Fin</label>
            <input type="date" class="form-control" id="dateFin" name="dateFin" value="${projet != null ? projet.dateFin : ''}" required>
        </div>
        <div class="form-group">
            <label for="budget">Budget</label>
            <input type="number" class="form-control" id="budget" name="budget" value="${projet != null ? projet.budget : ''}" step="0.01" required>
        </div>
        <button type="submit" class="btn btn-primary">Enregistrer</button>
        <a href="list" class="btn btn-secondary">Annuler</a>
    </form>
</div>
</body>
</html>
