package jeupokemon.models;

import java.util.List;

public class Pokemon {
    protected String nom;
    protected double prix;
    protected String types;
    protected int pointsVie;
    protected int niveau;
    protected int attaque;
    protected int attaqueSpecial;
    protected int defense;
    protected int defenseSpecial;
    protected int vitesse;
    protected List<Attaque> attaques;

//Constructeur:
    public Pokemon(String nom, double prix, String types, int pointsVie, int niveau, int attaque, int attaqueSpecial, int defense, int defenseSpecial, int vitesse, List<Attaque> attaques) {
        this.nom = nom;
        this.prix = prix;
        this.types = types;
        this.pointsVie = pointsVie;
        this.niveau = niveau;
        this.attaque = attaque;
        this.attaqueSpecial = attaqueSpecial;
        this.defense = defense;
        this.defenseSpecial = defenseSpecial;
        this.vitesse = vitesse;
        this.attaques = attaques;
    }

    public  void ajouterAttaque(Attaque attaque){
        attaques.add(attaque);
    }
    public void attaquer (){
        // logic of attaquing
    }

}
