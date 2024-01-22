package jeupokemon.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur {
    private String nom;
    private int manchesGagnees;
    private int argent;
    private List<Pokemon> pokemons;

    private int currentRound;

    // Constructor
    public Joueur(String nom, int manchesGagnees, int argent) {
        this.nom = nom;
        this.manchesGagnees = manchesGagnees;
        this.argent = argent;
        this.pokemons = new ArrayList<>();
        this.currentRound=1;
    }
    //getters


    public int getCurrentRound() {
        return currentRound;
    }
    public void incrementRound(){
        currentRound++;
    }
    public String getNom() {
        return nom;
    }

    public int getManchesGagnees() {
        return manchesGagnees;
    }

    public int getArgent() {
        return argent;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void choisirPokemon() {
        Scanner scanner = new Scanner(System.in);
        List<Pokemon> availablePokemon = new ArrayList<>();
        Pokemon pokemon = new Pokemon("Bulbasaur", 50, "Plante", null, 30, 3, 20,
                15, 10, 15, 10);
        pokemon.ajouterAttaque(new Attaque("Leaf Storm", "Plant", "Physique", 0.90, 130, 5));
        pokemon.ajouterAttaque(new Attaque("Vine Whip", "Plante", "Physique", 0.70, 90, 8));
        pokemon.ajouterAttaque(new Attaque("Sleep Powder", "Plante", "Statut", 0.75, 0, 10));
        pokemon.ajouterAttaque(new Attaque("Solar Beam", "Plante", "Spécial", 1.00, 150, 3));

        availablePokemon.add(pokemon);
        ///////////////////////
        pokemon = new Pokemon("Charmander", 60, "Feu", null, 25, 3, 22,
                18, 12, 16, 18);
        pokemon.ajouterAttaque(new Attaque("Tackle", "Eau", "Physique", 0.50, 100, 3));

        pokemon.ajouterAttaque(new Attaque("Ember", "Feu", "Spécial", 0.60, 80, 10));
        pokemon.ajouterAttaque(new Attaque("Dragon Claw", "Dragon", "Physique", 0.85, 120, 12));
        pokemon.ajouterAttaque(new Attaque("Flamethrower", "Feu", "Spécial", 0.90, 130, 15));
        availablePokemon.add(pokemon);
        ///////////////////////
        pokemon = new Pokemon("Squirtle", 55, "Eau", null, 28, 3, 18,
                16, 14, 14, 18);
        pokemon.ajouterAttaque(new Attaque("Thunderbolt", "Electrique", "Physique",0.80, 110, 2));

        pokemon.ajouterAttaque(new Attaque("Bubble", "Eau", "Spécial", 0.50, 70, 8));
        pokemon.ajouterAttaque(new Attaque("Aqua Tail", "Eau", "Physique", 0.75, 100, 12));
        pokemon.ajouterAttaque(new Attaque("Hydro Pump", "Eau", "Spécial", 0.95, 150, 15));
        availablePokemon.add(pokemon);
        //////////////////////
        pokemon = new Pokemon("Pikachu", 55, "Électrik", null, 25, 3, 20,
                15, 12, 12, 25);
        pokemon.ajouterAttaque(new Attaque("Sweet Kiss", "Fée", "Normal",0.95, 150, 1));

        pokemon.ajouterAttaque(new Attaque("Thunder Shock", "Électrik", "Spécial", 0.55, 80, 10));
        pokemon.ajouterAttaque(new Attaque("Quick Attack", "Normal", "Physique", 0.70, 90, 12));
        pokemon.ajouterAttaque(new Attaque("Thunderbolt", "Électrik", "Spécial", 0.90, 130, 15));

        availablePokemon.add(pokemon);
        /////////////////////
        pokemon = new Pokemon("Jigglypuff", 65, "Fée", "Normal", 30, 3, 15,
                18, 10, 15, 18);
        pokemon.ajouterAttaque(new Attaque("Scratch0", "FEU", "Physique", 0.60, 100, 3));
        pokemon.ajouterAttaque(new Attaque("Rollout", "Normal", "Physique", 0.80, 110, 12));
        pokemon.ajouterAttaque(new Attaque("Dazzling Gleam", "Fée", "Spécial", 0.95, 140, 15));
        pokemon.ajouterAttaque(new Attaque("Hyper Voice", "Normal", "Spécial", 0.90, 130, 18));

        availablePokemon.add(pokemon);
        /////////////////////
        pokemon = new Pokemon("Geodude", 45, "Roche", "Sol", 35, 3, 18,
                15, 20, 12, 10);
        pokemon.ajouterAttaque(new Attaque("Geodude", "Roche", "Sol", 120,2, 2));
        pokemon.ajouterAttaque(new Attaque("Rock Throw", "Roche", "Physique", 0.70, 90, 10));
        pokemon.ajouterAttaque(new Attaque("Magnitude", "Sol", "Physique", 0.80, 110, 12));
        pokemon.ajouterAttaque(new Attaque("Stone Edge", "Roche", "Physique", 0.95, 140, 15));
        availablePokemon.add(pokemon);


        System.out.println("Joueur " + nom + ", choisissez vos 3 Pokémons:");

        for (int i = 0; i < 3; i++) {
            System.out.println("Liste des Pokémons disponibles:");
            afficherListePokemon(availablePokemon);

            System.out.print("Entrez le numéro du Pokémon que vous souhaitez choisir (1, 2, 3, ...): ");
            int choixPokemon = scanner.nextInt();

            if (choixPokemon >= 1 && choixPokemon <= availablePokemon.size()) {
                Pokemon selectedPokemon = availablePokemon.remove(choixPokemon - 1);
                pokemons.add(selectedPokemon);

                System.out.println("Vous avez choisi " + selectedPokemon.getNom() + "!");
            } else {
                System.out.println("Numéro invalide. Veuillez choisir un Pokémon disponible.");
                i--; // To repeat the loop for the same iteration
            }

        }

        System.out.println("Félicitations, " + nom + "! Vous avez choisi vos 3 Pokémons!");
    }
    private void afficherListePokemon(List<Pokemon> pokemonList) {
        for (int i = 0; i < pokemonList.size(); i++) {
            Pokemon pokemon = pokemonList.get(i);
            System.out.println((i + 1) + ". " + pokemon.getNom());
        }
    }



    public void ajouterPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public Attaque choisirAttaque(Pokemon pokemon) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("C'est à " + nom + " de choisir une attaque pour " + pokemon.getNom() + ":");

        // les attaques available
        List<Attaque> attaques = pokemon.getAttaques();
        for (int i = 0; i < attaques.size(); i++) {
            Attaque attaque = attaques.get(i);
            System.out.println((i + 1) + ". " + attaque.getNom());
        }


        int choix;
        do {
            System.out.print("Choix de l'attaque: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un numéro valide.");
                scanner.next();
            }
            choix = scanner.nextInt();
        } while (choix < 1 || choix > attaques.size());


        return attaques.get(choix - 1);
    }
    public Pokemon recupererPokemon(int numero) {
        if (numero < 1 || numero > pokemons.size()) {
            System.out.println("Numéro de Pokémon invalide.");
            return null;
        }


        return pokemons.get(numero - 1);
    }
    public void afficherPokemons() {
        for (Pokemon pokemon : pokemons) {
            pokemon.afficher();
        }
    }


    public void afficher() {
        System.out.println("Nom : " + nom);
        System.out.println("Manches gagnées : " + manchesGagnees);
        System.out.println("Argent : " + argent);

    }

}