package tournoi;

import java.util.ArrayList;
import java.util.*;

/**
 * @author DELL
 * Class permettant de creer une equipe
 *
 */
public class Equipe {
	//Declaration des attributs liste de joueurs, nombre de joueur, nombre de poidstotal des joueurs, nombre de point 
	
	private List<Joueur> joueur =new ArrayList<Joueur>();
	private int nombreJoueur;
	private double nombrePoids;
	private int nombrePoint;
	/**
	 * 
	 */
	/*public Equipe() {
		// TODO Auto-generated constructor stub
		this.joueur=joueur;
		this.nombrePoids=nombrePoids;
		this.nombreJoueur=nombreJoueur;
		this.nombrePoint=nombrePoint;
	}*/
	public List<Joueur> getJoueur() {
		return joueur;
	}
	public void setJoueur(List<Joueur> joueur) {
		this.joueur = joueur;
	}
	public int getNombreJoueur() {
		return nombreJoueur;
	}
	public void setNombreJoueur(int nombreJoueur) {
		this.nombreJoueur = nombreJoueur;
	}
	public double getNombrePoids() {
		return nombrePoids;
	}
	public void setNombrePoids(double nombrePoids) {
		this.nombrePoids = nombrePoids;
	}
	public int getNombrePoint() {
		return nombrePoint;
	}
	public void setNombrePoint(int nombrePoint) {
		this.nombrePoint = nombrePoint;
	}
}
