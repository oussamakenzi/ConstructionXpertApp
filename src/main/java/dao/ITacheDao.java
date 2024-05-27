package dao;

import model.Projet;
import model.Tache;

import java.sql.SQLException;
import java.util.List;

public interface ITacheDao {
  public   boolean insertTache(Tache tache) throws SQLException;
    public List<Tache> listAllTachesByProjet(int idProjet) throws SQLException;
   public boolean deleteTache(int idTache) throws SQLException;
   public boolean updateTache(Tache tache) throws SQLException;
   public Tache getTache(int idTache) throws SQLException;
}
