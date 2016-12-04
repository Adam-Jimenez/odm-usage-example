package beans;

import java.util.ArrayList;
import java.util.List;

import utils.DbObject;

public class Utilisateur extends DbObject {
	private String nom;
	private String motDePasse;
	private String courriel;
	
	private List<Livre> livres;

	public Utilisateur() {
		nom = "";
		motDePasse = "";
		courriel = "";
		livres = new ArrayList<Livre>();
		insert();
	}

	public Utilisateur(String nom, String courriel, String motDePasse) {
		super();
		this.nom = nom;
		this.motDePasse = motDePasse;
		this.courriel = courriel;
		this.livres = new ArrayList<Livre>();
		insert();
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
		update();
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
		update();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
		update();
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	
	public void addLivre(Livre livre) {
		this.livres.add(livre);
		update();
	}
}
