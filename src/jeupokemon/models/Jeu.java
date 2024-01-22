package jeupokemon.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {
    private List<Joueur> joueurs;

    // Constructor
    public Jeu() {
        this.joueurs = new ArrayList<>();
    }

    // Method to start the game
    public void jouer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le Jeu Pokémon!");

        // Initialize Player 1
        System.out.print("Joueur 1, entrez votre nom: ");
        String nomJoueur1 = scanner.nextLine();
        Joueur joueur1 = new Joueur(nomJoueur1, 0, 1000);
        joueurs.add(joueur1);

        // Initialize Player 2
        System.out.print("Joueur 2, entrez votre nom: ");
        String nomJoueur2 = scanner.nextLine();
        Joueur joueur2 = new Joueur(nomJoueur2, 0, 1000);
        joueurs.add(joueur2);

        joueur1.choisirPokemon();
        joueur2.choisirPokemon();



        for (int round = 1; round <= 3; round++) {
            System.out.println("\nRound " + round + "!");
            combatRound(joueur1, joueur2,round);
        }
        Joueur winner = determineGagnant(joueur1, joueur2);

        System.out.println("\nLe joueur " + winner.getNom() + " remporte la victoire!");

    }

    private void combatRound (Joueur joueur1, Joueur joueur2,int round){
        Pokemon pokemonJoueur1 = joueur1.recupererPokemon(round);
        Pokemon pokemonJoueur2 = joueur2.recupererPokemon(round);

        // Determine which Pokémon attacks first based on speed
        Pokemon premierAttaquant, secondAttaquant;
        if (pokemonJoueur1.getVitesse() > pokemonJoueur2.getVitesse()) {
            premierAttaquant = pokemonJoueur1;
            secondAttaquant = pokemonJoueur2;
        } else {
            premierAttaquant = pokemonJoueur2;
            secondAttaquant = pokemonJoueur1;
        }

        System.out.println(premierAttaquant.getNom() + " attaque en premier!");

        // Players choose their attacks
        Attaque attaqueJoueur1 = joueur1.choisirAttaque(pokemonJoueur1);
        Attaque attaqueJoueur2 = joueur2.choisirAttaque(pokemonJoueur2);

        // First Pokémon attacks
        premierAttaquant.attaquer(secondAttaquant, attaqueJoueur1);
        // Check if the opponent is knocked out
        if (secondAttaquant.estKo()) {
            return; // If the opponent is knocked out, the round ends
        }

        // Second Pokémon attacks
        secondAttaquant.attaquer(premierAttaquant, attaqueJoueur2);
    }
    private Joueur determineGagnant(Joueur joueur1, Joueur joueur2) {
        if (joueur1.getManchesGagnees() > joueur2.getManchesGagnees()) {
            return joueur1;
        } else{
            return joueur2;
        }
    }



}