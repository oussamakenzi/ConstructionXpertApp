package dao;


import dbconnecrion.DbConnection;
import model.Tache;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ITacheDaoImpl implements ITacheDao {

    @Override
    public boolean insertTache(Tache tache) throws SQLException {
        String sql = "INSERT INTO Tache (nomTache, tacheDescription, dateDbTache, dateFinTache, statut, IdProjet) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tache.getNomTache());
            statement.setString(2, tache.getTacheDescription());
            statement.setDate(3, tache.getDateDbTache());
            statement.setDate(4, tache.getDateFinTache());
            statement.setString(5, tache.getStatut());
            statement.setInt(6, tache.getIdProjet());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public List<Tache> listAllTachesByProjet(int idProjet) throws SQLException {
        List<Tache> listTache = new ArrayList<>();

        String sql = "SELECT * FROM Tache WHERE IdProjet = ?";

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idProjet);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idTache = resultSet.getInt("IdTache");
                String nomTache = resultSet.getString("nomTache");
                String TacheDescription = resultSet.getString("tacheDescription");
                Date dateDbTache = resultSet.getDate("dateDbTache");
                Date dateFinTache = resultSet.getDate("dateFinTache");
                String statut = resultSet.getString("statut");

                Tache tache = new Tache(idTache, nomTache, TacheDescription, dateDbTache, dateFinTache, statut, idProjet);
                listTache.add(tache);
            }

            return listTache;
        }
    }

    @Override
    public boolean deleteTache(int idTache) throws SQLException {
        String sql = "DELETE FROM Tache WHERE IdTache = ?";

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idTache);
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateTache(Tache tache) throws SQLException {
        String sql = "UPDATE Tache SET nomTache = ?, tacheDescription = ?, dateDbTache = ?, dateFinTache = ?, statut = ? WHERE IdTache = ?";

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tache.getNomTache());
            statement.setString(2, tache.getTacheDescription());
            statement.setDate(3, tache.getDateDbTache());
            statement.setDate(4, tache.getDateFinTache());
            statement.setString(5, tache.getStatut());
            statement.setInt(6, tache.getIdTache());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public Tache getTache(int idTache) throws SQLException {
        Tache tache = null;
        String sql = "SELECT * FROM Tache WHERE IdTache = ?";

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idTache);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nomTache = resultSet.getString("nomTache");
                String TacheDescription = resultSet.getString("TacheDescription");
                Date dateDbTache = resultSet.getDate("dateDbTache");
                Date dateFinTache = resultSet.getDate("dateFinTache");
                String status = resultSet.getString("statut");
                int idProjet = resultSet.getInt("IdProjet");


                tache = new Tache(idTache, nomTache, TacheDescription, dateDbTache, dateFinTache, status, idProjet);
            }
        }

        return tache;
    }
}
