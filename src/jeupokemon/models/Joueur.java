package jeupokemon.models;

public class Joueur {

    protected String nom;
    protected int mancheGagnee;
    protected int argent;


// CONSTRUCTEUR
    public Joueur(String nom, int mancheGagnee, int argent){
        this.nom = nom;
        this.mancheGagnee = mancheGagnee;
        this.argent = argent;
    }

}
