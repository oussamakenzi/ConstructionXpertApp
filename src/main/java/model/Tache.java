package model;


import java.util.Date;

public class Tache {
    private int idTache;
    private String nomTache;


    public String getTacheDescription() {
        return tacheDescription;
    }

    public void setTacheDescription(String tacheDescription) {
        this.tacheDescription = tacheDescription;
    }

    private String tacheDescription;
    private Date dateDbTache;
    private Date dateFinTache;
    private String statut;
    private int idProjet;



    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }


    public Tache() {

    }

    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }











    public java.sql.Date getDateDbTache() {
        return (java.sql.Date) dateDbTache;
    }

    public void setDateDbTache(Date dateDbTache) {
        this.dateDbTache = dateDbTache;
    }

    public java.sql.Date getDateFinTache() {
        return (java.sql.Date) dateFinTache;
    }

    public void setDateFinTache(Date dateFinTache) {
        this.dateFinTache = dateFinTache;
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

    public Tache(int idTache, String nomTache, String tacheDescription, Date dateDbTache, Date dateFinTache, String statut, int idProjet) {
        this.idTache = idTache;
        this.nomTache = nomTache;
        this.tacheDescription = tacheDescription;
        this.dateDbTache = dateDbTache;
        this.dateFinTache = dateFinTache;
        this.statut = statut;
        this.idProjet = idProjet;

    }

    public Tache(String nomTache, String tacheDescription, Date dateDbTache, Date dateFinTache, String statut, int idProjet) {
        this.nomTache = nomTache;
        this.tacheDescription = tacheDescription;
        this.dateDbTache = dateDbTache;
        this.dateFinTache = dateFinTache;
        this.statut = statut;
        this.idProjet = idProjet;
    }
}
