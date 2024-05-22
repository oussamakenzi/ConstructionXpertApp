package dao;

import metier.Project;

import java.util.List;

public interface IProjectDao {
        public Project save(Project p);
        public List<Project> findAll();
        public Project getProjet(int id);
        public Project update(Project p);
        public void deleteProjet(int id);
    }


