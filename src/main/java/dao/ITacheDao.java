package dao;

import model.Projet;
import model.Tache;

import java.sql.SQLException;
import java.util.List;

public interface ITacheDao {
    public void addTache(Tache tache) throws SQLException;
    public void updateTache(Tache tache) throws SQLException;
    public void deleteTache(int id) throws SQLException;
    public List<Tache> getAllTache() throws SQLException;
    public Tache getTache(int id) throws SQLException;
}
