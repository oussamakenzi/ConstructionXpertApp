package dao;

import dbconnecrion.DbConnection;
import model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IProjectDaoImpl implements IProjectDao {
@Override
    public void addProject(Project project) throws SQLException {
        String query = "INSERT INTO Projet (NomProjet, description, DteDebut, DateFin, Budget) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, project.getNom());
            statement.setString(2, project.getDescription());
            statement.setDate(3, project.getDateDebut());
            statement.setDate(4, project.getDateFin());
            statement.setDouble(5, project.getBudget());
            statement.executeUpdate();
        }
    }

    public List<Project> getAllProjects() throws SQLException {
        List<Project> projets = new ArrayList<>();
        String query = "SELECT * FROM Projet";
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Project projet = new Project();
                projet.setId_projet(resultSet.getInt("IdProjet"));
                projet.setNom(resultSet.getString("NomProjet"));
                projet.setDescription(resultSet.getString("description"));
                projet.setDateDebut(resultSet.getDate("DteDebut"));
                projet.setDateFin(resultSet.getDate("DateFin"));
                projet.setBudget(resultSet.getDouble("Budget"));
                projets.add(projet);
            }
        }
        return projets;
    }

    public Project getProject(int id) throws SQLException {
        Project projet = null;
        String query = "SELECT * FROM Projet WHERE IdProjet = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                projet = new Project();
                projet.setId_projet(resultSet.getInt("IdProjet"));
                projet.setNom(resultSet.getString("NomProjet"));
                projet.setDescription(resultSet.getString("description"));
                projet.setDateDebut(resultSet.getDate("DteDebut"));
                projet.setDateFin(resultSet.getDate("DateFin"));
                projet.setBudget(resultSet.getDouble("Budget"));
            }
        }
        return projet;
    }

    public void updateProject(Project projet) throws SQLException {
        String query = "UPDATE Projet SET NomProjet = ?, description = ?, DteDebut = ?, DateFin = ?, Budget = ? WHERE IdProjet = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, projet.getNom());
            statement.setString(2, projet.getDescription());
            statement.setDate(3, projet.getDateDebut());
            statement.setDate(4, projet.getDateFin());
            statement.setDouble(5, projet.getBudget());
            statement.setInt(6, projet.getId_projet());
            statement.executeUpdate();
        }
    }

    public void deleteProject(int id) throws SQLException {
        String query = "DELETE FROM Projet WHERE IdProjet = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


}
