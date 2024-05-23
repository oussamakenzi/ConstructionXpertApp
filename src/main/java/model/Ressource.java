package model;

public class Ressource {
    private int idRessource;
    private String nomRessource;
    private String type;
    private int quantite;
    private String nomFournisseur;

    public Ressource(String type, int quantite, String nomRessource, String nomFournisseur) {
        this.type = type;
        this.quantite = quantite;
        this.nomRessource = nomRessource;
        this.nomFournisseur = nomFournisseur;
    }

    public Ressource(String adresse, String contactFournisseur, int idRessource, int idTache, String nomFournisseur, String nomRessource, int quantite, String type) {
        this.adresse = adresse;
        this.contactFournisseur = contactFournisseur;
        this.idRessource = idRessource;
        this.idTache = idTache;
        this.nomFournisseur = nomFournisseur;
        this.nomRessource = nomRessource;
        this.quantite = quantite;
        this.type = type;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContactFournisseur() {
        return contactFournisseur;
    }

    public void setContactFournisseur(String contactFournisseur) {
        this.contactFournisseur = contactFournisseur;
    }

    public int getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }

    public int getIdTache() {
        return idTache;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getNomRessource() {
        return nomRessource;
    }

    public void setNomRessource(String nomRessource) {
        this.nomRessource = nomRessource;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String contactFournisseur;
    private String adresse;
    private int idTache;


}

