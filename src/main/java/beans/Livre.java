package beans;

import utils.DbObject;

public class Livre extends DbObject {
	private String titre;
	private String description;
	private boolean estDisponible;

	public Livre() {
		titre = "";
		description = "";
		estDisponible = false;
		insert();
	}
	
	public Livre(String titre, String contenu, boolean estDisponible) {
		super();
		this.setTitre(titre);
		this.description = contenu;
		this.estDisponible = estDisponible;
		insert();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		update();
	}

	public boolean getEstDisponible() {
		return estDisponible;
	}

	public void setEstDisponible(boolean estDisponible) {
		this.estDisponible = estDisponible;
		update();
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
		update();
	}
}
