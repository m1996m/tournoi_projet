package tournoi;

public class Joueur extends Personne {
	private double poids;
	private int anneeParticipation;
	private Arme arme;
	private Armure armure;

	public Joueur(int id, String nom, String prenom, String adresse,int poids, int anneeParticipation) {
		super(id, nom, prenom, adresse);
		this.poids=poids;
		this.anneeParticipation=anneeParticipation;
		
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public int getAnneeParticipation() {
		return anneeParticipation;
	}

	public void setAnneeParticipation(int anneeParticipation) {
		this.anneeParticipation = anneeParticipation;
	}

	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	public Armure getArmure() {
		return armure;
	}

	public void setArmure(Armure armure) {
		this.armure = armure;
	}
}
