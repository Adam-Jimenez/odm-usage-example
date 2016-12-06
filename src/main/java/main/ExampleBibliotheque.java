package main;

import java.util.ArrayList;

import beans.Livre;
import beans.Utilisateur;
import core.ODM;
import query.Selector;

public class ExampleBibliotheque {
	private static Livre[] livres;
	private static Utilisateur[] utilisateurs;
	public static void main(String[] args) {

		utilisateurs = new Utilisateur[3]; 
		utilisateurs[0] = new Utilisateur("Adam", "adam@adam.com", "hunter2");
		utilisateurs[1] = new Utilisateur("Bob", "bob@bob.com", "VeraCold123");
		utilisateurs[2] = new Utilisateur("Paul", "paul@paul.com", "password");

		livres = new Livre[3];
		livres[0] = new Livre("Cooking for Dummies", "Recipes", true);
		livres[1] = new Livre("ODM for Dummies", "???", true);
		livres[2] = new Livre("Super Secret Book", "https://www.youtube.com/watch?v=dQw4w9WgXcQ", true);

		UserThread t1 = new UserThread(utilisateurs[0]);
		UserThread t2 = new UserThread(utilisateurs[1]);
		UserThread t3 = new UserThread(utilisateurs[2]);
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	public synchronized static Livre getRandomLivre() {
		ArrayList<Livre> livresDisponibles = new ArrayList<Livre>();
		for(Livre livre : livres) {
			if (livre.getEstDisponible()){
				livresDisponibles.add(livre);
			}
		}
		if (livresDisponibles.size() == 0) {
			return null;
		}
		return livresDisponibles.get((int)(Math.random() * livresDisponibles.size()));
	}
	public synchronized static void empruntLivre(Livre livre, Utilisateur utilisateur) {
		if (livre == null || utilisateur == null) return;
		if (livre.getEstDisponible() && !utilisateur.getLivres().contains(livre)) {
			livre.setEstDisponible(false);
			utilisateur.addLivre(livre);
		}
	}
	
	public synchronized static void retournerLivre(Livre livre, Utilisateur utilisateur) {
		if (livre == null || utilisateur == null) return;
		if(utilisateur.getLivres().contains(livre)) {
			utilisateur.getLivres().remove(livre);
			livre.setEstDisponible(true);
		}
	}
}
