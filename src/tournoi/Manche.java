package tournoi;

public class Manche {
	private String nom;
	private int isManche;
	public Manche(String nom) {
		this.nom=nom;
		this.isManche=0;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIsManche() {
		return isManche;
	}
	public void setIsManche(int isManche) {
		this.isManche = isManche;
	}
	@Override
	public String toString() {
		return "Manche [nom=" + nom + ", isManche=" + isManche + "]";
	}

}
