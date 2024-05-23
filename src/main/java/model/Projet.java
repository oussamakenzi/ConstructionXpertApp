package model;

import java.util.Date;
import java.util.List;

public class Projet {
    private int idProjet;
    private String nomProjet;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private double budget;

    public List<Tache> getListTachesOfProject() {
        return listTachesOfProject;
    }

    public void setListTachesOfProject(List<Tache> listTachesOfProject) {
        this.listTachesOfProject = listTachesOfProject;
    }

    private List<Tache> listTachesOfProject;

    public Projet(double budget, Date dateDebut, Date dateFin, String description, int idProjet, String nomProjet) {
        this.budget = budget;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.idProjet = idProjet;
        this.nomProjet = nomProjet;

    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public java.sql.Date getDateDebut() {
        return (java.sql.Date) dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public java.sql.Date getDateFin() {
        return (java.sql.Date) dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public Projet() {
    }
}
