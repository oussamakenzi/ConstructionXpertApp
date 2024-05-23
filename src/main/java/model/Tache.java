package model;

import java.util.Date;

public class Tache {
    private int idTache;
    private String description;
    private Date dateDbTache;
    private Date dateFinTache;
    private int idProjet;

    public Tache(Date dateDbTache, Date dateFinTache, String description) {
        this.dateDbTache = dateDbTache;
        this.dateFinTache = dateFinTache;
        this.description = description;
    }

    public Tache(Date dateDbTache, Date dateFinTache, String description, int idProjet, int idTache) {
        this.dateDbTache = dateDbTache;
        this.dateFinTache = dateFinTache;
        this.description = description;
        this.idProjet = idProjet;
        this.idTache = idTache;
    }

    public Date getDateDbTache() {
        return dateDbTache;
    }

    public void setDateDbTache(Date dateDbTache) {
        this.dateDbTache = dateDbTache;
    }

    public Date getDateFinTache() {
        return dateFinTache;
    }

    public void setDateFinTache(Date dateFinTache) {
        this.dateFinTache = dateFinTache;
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

    public int getIdTache() {
        return idTache;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
    }

}
