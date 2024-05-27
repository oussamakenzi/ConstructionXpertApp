<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Project Management Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/css/adminlte.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
    <style>
        body {
            min-height: 100vh;
            background-color: #f4f6f9;
        }
        .container {
            padding: 20px;
        }
        .card {
            margin-bottom: 20px;
        }
        @media (min-width: 768px) {
            .card-header {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .card-header .btn {
                margin-left: auto;
            }
        }
        @media (min-width: 1300px) {
            .card-header {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .card-header .btn {
                margin-left: auto;
            }
        }
    </style>
</head>
<body>


<div class="wrapper">
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Home</a>
            </li>
        </ul>
    </nav>

    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <a href="#" class="brand-link">
            <img src="https://adminlte.io/themes/v3/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
            <span class="brand-text font-weight-light">AdminLTE 3</span>
        </a>
        <div class="sidebar">
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>Dashboard</p>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>

    <div class="content-wrapper">
        <section class="content">
            <div class="container">
                <h1>Les projets réalisés</h1>
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Liste des projets</h3>
                        <a href="new" class="btn btn-primary" id="export-file">Ajouter</a>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nom du Projet</th>
                                    <th>Description</th>
                                    <th>Date début</th>
                                    <th>Date Fin</th>
                                    <th>Budget</th>
                                    <th>Actions</th>
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
                                        <td>
                                            <a href="edit?id=${projet.idProjet}" class="btn btn-warning btn-sm"><i class="fas fa-edit"></i></a>
                                            <a href="delete?id=${projet.idProjet}" class="btn btn-danger btn-sm"><i class="fas fa-trash"></i></a>
                                            <a href="tache?action=listTache&idProjet=${projet.idProjet}" class="btn btn-info btn-sm"><i class="fa fa-cogs" aria-hidden="true"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <aside class="control-sidebar control-sidebar-dark"></aside>

    <footer class="main-footer">
        <div class="float-right d-none d-sm-inline">Anything you want</div>
        <strong>Copyright &copy; 2024 <a href="#">Your Company</a>.</strong> All rights reserved.
    </footer>
</div>

<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
    <!-- Modal Content -->
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/js/adminlte.min.js"></script>
<script>
    $(document).ready(function () {
        $('#example1').DataTable();
    });
</script>

</body>
</html>
