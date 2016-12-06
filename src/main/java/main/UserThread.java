package main;

import beans.Utilisateur;

public class UserThread extends Thread{
	private Utilisateur user;

	public UserThread(Utilisateur user) {
		this.user = user;
	}
	public void run() {
		while(true) {
			ExampleBibliotheque.empruntLivre(ExampleBibliotheque.getRandomLivre(), user);
			chill();
			if (user.getLivres().size() > 0) {
				ExampleBibliotheque.retournerLivre(user.getLivres().get(0), user);
			}
			chill();
		}
	}
	
	private void chill() {
			try {
				sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
