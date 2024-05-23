package dao;


import model.Projet;

import java.sql.SQLException;
import java.util.List;

public interface IProjetDao {
        public void addProjet(Projet projet) throws SQLException;
        public void updateProjet(Projet projet) throws SQLException;
        public void deleteProjet(int id) throws SQLException;
        public List<Projet> getAllProjets() throws SQLException;
        public Projet getProjet(int id) throws SQLException;

    }


