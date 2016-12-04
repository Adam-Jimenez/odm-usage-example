package main;

import beans.Livre;
import beans.Utilisateur;

public class ExampleBibliotheque {
	public static void main(String[] args) {
		Utilisateur adam = new Utilisateur("Adam", "adam@adam.com", "hunter2");
		Utilisateur bob = new Utilisateur("Bob", "bob@bob.com", "VeraCold123");
		Utilisateur paul = new Utilisateur("Paul", "paul@paul.com", "password");

		Livre livre1 = new Livre("Cooking for Dummies", "Recipes", true);
		Livre livre2 = new Livre("ODM for Dummies", "???", true);
		Livre livre3 = new Livre("Super Secret Book", "https://www.youtube.com/watch?v=dQw4w9WgXcQ", true);

		// breakpoint here
		preterLivre(livre1, adam);
		preterLivre(livre2, bob);
		preterLivre(livre3, paul);
	}
	
	public static void preterLivre(Livre livre, Utilisateur utilisateur) {
		if (livre.getEstDisponible()) {
			livre.setEstDisponible(false);
			utilisateur.addLivre(livre);
		}
	}
}
