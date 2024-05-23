package dao;

import dbconnecrion.DbConnection;
import model.Projet;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IProjetDaoImpl implements IProjetDao {



    @Override
    public void addProjet(Projet projet) throws SQLException {
        String query = "INSERT INTO Projet (NomProjet, description, DteDebut, DateFin, Budget) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, projet.getNomProjet());
            statement.setString(2, projet.getDescription());
            statement.setDate(3, projet.getDateDebut());
            statement.setDate(4, projet.getDateFin());
            statement.setDouble(5, projet.getBudget());
            statement.executeUpdate();
        }
    }



    @Override
    public List<Projet> getAllProjets() throws SQLException {
        List<Projet> projets = new ArrayList<>();
        String query = "SELECT * FROM Projet";
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Projet projet = new Projet();
                projet.setIdProjet(resultSet.getInt("IdProjet"));
                projet.setNomProjet(resultSet.getString("NomProjet"));
                projet.setDescription(resultSet.getString("description"));
                projet.setDateDebut(resultSet.getDate("DteDebut"));
                projet.setDateFin(resultSet.getDate("DateFin"));
                projet.setBudget(resultSet.getDouble("Budget"));
                projets.add(projet);
            }
        }
        return projets;
    }

    @Override
    public Projet getProjet(int id) throws SQLException {
        Projet projet = null;
        String query = "SELECT * FROM Projet WHERE IdProjet = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                projet = new Projet();
                projet.setIdProjet(resultSet.getInt("IdProjet"));
                projet.setNomProjet(resultSet.getString("NomProjet"));
                projet.setDescription(resultSet.getString("description"));
                projet.setDateDebut(resultSet.getDate("DteDebut"));
                projet.setDateFin(resultSet.getDate("DateFin"));
                projet.setBudget(resultSet.getDouble("Budget"));
            }
        }
        return projet;
    }

    @Override
    public void updateProjet(Projet projet) throws SQLException {
        String query = "UPDATE Projet SET NomProjet = ?, description = ?, DteDebut = ?, DateFin = ?, Budget = ? WHERE IdProjet = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, projet.getNomProjet());
            statement.setString(2, projet.getDescription());
            statement.setDate(3, projet.getDateDebut());
            statement.setDate(4, projet.getDateFin());
            statement.setDouble(5, projet.getBudget());
            statement.setInt(6, projet.getIdProjet());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteProjet(int id) throws SQLException {
        String query = "DELETE FROM Projet WHERE IdProjet = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
