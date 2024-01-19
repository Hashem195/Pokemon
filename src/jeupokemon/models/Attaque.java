package jeupokemon.models;

public class Attaque {
    protected String nomAttaque;
    protected String typeAttaque;
    protected boolean categorieAttaque;
    protected double precisionAttaque;
    protected int puissanceAttaque;
    protected int ppAttaque;
//CONSTRUCTEUR
    public Attaque(String nomAttaque, String typeAttaque, boolean categorieAttaque, double precisionAttaque, int puissanceAttaque, int ppAttaque){
        this.nomAttaque = nomAttaque;
        this.typeAttaque = typeAttaque;
        this.categorieAttaque = categorieAttaque;
        this.precisionAttaque = precisionAttaque;
        this.puissanceAttaque = puissanceAttaque;
        this.ppAttaque = ppAttaque;
    }
}
