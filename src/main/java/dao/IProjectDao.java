package dao;

import model.Project;

import java.sql.SQLException;
import java.util.List;

public interface IProjectDao {
        public void addProject(Project project) throws SQLException;
        public List<Project> getAllProjects() throws SQLException;
        public Project getProject(int id) throws SQLException;
        public void updateProject(Project projet) throws SQLException;
        public void deleteProject(int id) throws SQLException;
    }


