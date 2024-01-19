package jeupokemon.models;

import java.util.List;
import java.util.ArrayList;
public class Pokemon {
    private String nom;
    private int prix;
    private String type1;
    private String type2;
    private int pointsDeVie;
    private int niveau;
    private int attaque;
    private int attaqueSpeciale;
    private int defense;
    private int defenseSpeciale;
    private int vitesse;
    private List<Attaque> attaques;

    // Constructor
    public Pokemon(String nom, int prix, String type1, String type2, int pointsDeVie, int niveau,
                   int attaque, int attaqueSpeciale, int defense, int defenseSpeciale, int vitesse) {
        this.nom = nom;
        this.prix = prix;
        this.type1 = type1;
        this.type2 = type2;
        this.pointsDeVie = pointsDeVie;
        this.niveau = niveau;
        this.attaque = attaque;
        this.attaqueSpeciale = attaqueSpeciale;
        this.defense = defense;
        this.defenseSpeciale = defenseSpeciale;
        this.vitesse = vitesse;
        this.attaques = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getAttaqueSpeciale() {
        return attaqueSpeciale;
    }

    public int getDefense() {
        return defense;
    }

    public int getDefenseSpeciale() {
        return defenseSpeciale;
    }

    public int getVitesse() {
        return vitesse;
    }

    public List<Attaque> getAttaques() {
        return attaques;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    // Methode pour ajouter attaque
    public void ajouterAttaque(Attaque attaque) {
        attaques.add(attaque);
    }

    public void attaquer(Pokemon adversaire, Attaque attaque) {
        // Use the Attaque calculerDegats method
        int damage = attaque.calculerDegats(this, adversaire, this.getAttaque());

        // Adjust the opponent's HP accordingly
        adversaire.setPointsDeVie(adversaire.getPointsDeVie() - damage);

        System.out.println(this.getNom() + " attaque avec " + attaque.getNom() + " et inflige " + damage + " points de dégâts à " + adversaire.getNom());

        // Check if the opponent is knocked out
        if (adversaire.estKo()) {
            System.out.println(adversaire.getNom() + " est K.O.!");
        } else {
            System.out.println(adversaire.getNom() + " a maintenant " + adversaire.getPointsDeVie() + " points de vie restants.");
        }
    }


    public boolean estKo() {
        return pointsDeVie <= 0;
    }

    //pour apres
    public void afficherAttaques() {
        for (Attaque attaque : attaques) {
            attaque.afficher();
        }
    }



    public void afficher() {
        System.out.println("Nom : " + nom);
        System.out.println("Type(s) : " + type1 + (type2 != null ? ", " + type2 : ""));
        System.out.println("PV : " + pointsDeVie);
        System.out.println("Niveau : " + niveau);

    }

}
