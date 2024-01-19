package jeupokemon.models;

public class Attaque {
    private String nom;
    private String type;
    private String categorie;
    private double precision;
    private int puissance;
    private int pp;

    // Constructor
    public Attaque(String nom, String type, String categorie, double precision, int puissance, int pp) {
        this.nom = nom;
        this.type = type;
        this.categorie = categorie;
        this.precision = precision;
        this.puissance = puissance;
        this.pp = pp;
    }
    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getCategorie() {
        return categorie;
    }

    public double getPrecision() {
        return precision;
    }

    public int getPuissance() {
        return puissance;
    }

    public int getPp() {
        return pp;
    }
    public int calculerDegats(Pokemon attaquant, Pokemon adversaire) {
        double stab = 1.0;
        if (attaquant.getType1().equals(type) || (attaquant.getType2() != null && attaquant.getType2().equals(type))) {
            stab = 1.5;
        }

        double cm = ((2.0 * attaquant.getNiveau() / 5.0 + 2.0) * attaquant.getAttaque() * puissance) /
                (adversaire.getDefense() * 50.0) + 2.0;

        cm *= stab;

        int damage = (int) (cm * precision);

        pp--;
        if (pp < 0) {
            pp = 0;
        }

        return damage;
    }

    public void afficher() {
        System.out.println("Attaque : " + nom);
        System.out.println("Type : " + type);
        System.out.println("Catégorie : " + categorie);
        System.out.println("Précision : " + precision);
        System.out.println("Puissance : " + puissance);
        System.out.println("PP : " + pp);
    }

}


