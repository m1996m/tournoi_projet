package tournoi;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 * Une classe permetttant de creer un club
 *
 */
public class Club {
	private List<Equipe> equipe=new ArrayList<Equipe>();
	private Session session;
	/**
	 * Constructeur � deux arguments(une liste dequipe et une liste de combat)
	 */
	public Club() {
		//this.equipe = null;
		//this.session = null;	
	}

	public List<Equipe> getEquipe() {
		return equipe;
	}

	public void setEquipe(List<Equipe> equipe) {
		this.equipe = equipe;
	}

	public Session getSession() {
		return session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	//fonction permettant d'ajouter une equipe qui re�oit en parametre une session
	public void creerEquipe() {
		
		Equipe equipe1=new Equipe();
		Equipe equipe2=new Equipe();
		List<Equipe> l=new ArrayList<Equipe>();
		l.add(equipe1);
		l.add(equipe2);
		this.setEquipe(l);	
	}
	//fonciton qu i permet de creer une session qui re �oit en parametre une session 
	public void CreerSession() {
		this.setSession(new Session());
		
	}
	//fonciton qui permet de creer une liste de joueur
	public List<Joueur> tabJoueur(int nombreJoueur,int ancienete){
		List<Joueur> joueur =new ArrayList<Joueur>();
		double p=40;
		int annee=YearMonth.now().getYear();
		for(int i=0;i<nombreJoueur;i++) {
			if(ancienete==1) {
				joueur.add(new Joueur(i,"nom"+i,"prenom"+i,"adresse"+i,p,annee));
				annee-=2;
			}else {
				joueur.add(new Joueur(i,"nom"+i,"prenom"+i,"adresse"+i,p,annee));
			}
			p=p+3;
			
		}
		return joueur;	
	}
	
	
 	//fonciton qui permet de partager les 20 joueurs entre les deux equipe
	public void remplissageJoueurJoueur(Equipe equipe1,Equipe equipe2,int nombreJoueur) {
		List<Joueur> joueur =new ArrayList<Joueur>();
		joueur=tabJoueur(nombreJoueur,0);
		
		int taille=joueur.size()/2;
		int nombre1=0;
		double poids1=0;
		int nombre2=0;
		double poids2=0;
		for(int i=0;i<nombreJoueur;i++){
			if(i<taille) {
				equipe1.getJoueur().add(joueur.get(i));
				nombre1++;
				poids1=poids1+joueur.get(i).getPoids();
			}else {
	 			equipe2.getJoueur().add(joueur.get(i));
				nombre2 ++;
				poids2=poids2+joueur.get(1).getPoids();
			}	
		}
		equipe1.setNombreJoueur(nombre1);
		equipe1.setNombrePoids(poids1);
		equipe2.setNombreJoueur(nombre2);
		equipe2.setNombrePoids(poids2);
		
	}
	
	// Fonction permettant de recuperer le nombre d'annee d'anciennete total de chaque equipe
	public int testAciennete(Equipe equipe,int nombreJoueur,List<Joueur> joueur ) {
		joueur=tabJoueur(nombreJoueur,1);
		int p=0;
		 // Test permettant de recupperer le nombre d'ancienete total de l'equipe1
		for(int i=0;i<nombreJoueur;i++) {
			for(int j=0;j<equipe.getJoueur().size();j++) {
				if(joueur.get(i).equals(equipe.getJoueur().get(j))) {
					p+=YearMonth.now().getYear()-joueur.get(i).getAnneeParticipation();
				}
			}
		}
		return p;
		
	}
	
	// Fonction permettant de recuperer le nombre d'annee d'anciennete total de chaque equipe
	@SuppressWarnings("unlikely-arg-type")
	public void testEquilibrage(Equipe equipe1,Equipe equipe2,int nombreJoueur,List<Joueur> joueur ) {
		int total=this.testAciennete(equipe1, nombreJoueur, joueur)+this.testAciennete(equipe2, nombreJoueur, joueur);
		int p=0;
		int j;
		int valeur=this.testAciennete(equipe1,nombreJoueur,joueur);
		List<Integer> indice = new ArrayList<Integer>();
		List<Joueur> l =new ArrayList<Joueur>();
		 //Test permettant de recupperer le nombre d'ancienete total de l'equipe1
		for(int i=0;i<equipe2.getJoueur().size();i++) {
			j=i+1;
			l.clear();
			p=YearMonth.now().getYear()-equipe2.getJoueur().get(i).getAnneeParticipation();
			if(Math.floorMod(total/2,2)==0) {
				while(p!=total/2 && j<equipe2.getJoueur().size()){
					l.add(equipe2.getJoueur().get(j));
					indice.add(j);
					p+=YearMonth.now().getYear()-equipe2.getJoueur().get(j).getAnneeParticipation();
					if(p>total/2) {
						p=equipe2.getJoueur().get(i).getAnneeParticipation();
						l.clear();
						indice.clear();
					}
					j++;
				}
			}else {
				while(((p+valeur!=total/2-1) || p+valeur!=total/2+2) && j<equipe2.getJoueur().size()){
					l.add(equipe2.getJoueur().get(j));
					indice.add(j);
					p+=YearMonth.now().getYear()-equipe2.getJoueur().get(j).getAnneeParticipation();
					if(p>total/2){
						p=equipe2.getJoueur().get(i).getAnneeParticipation();
						l.clear();
						indice.clear();
					}
					j++;
				}
			}
			if(p+valeur==total/2 || p+valeur!=total/2-1 || p+valeur!=total/2+2) {
				i=nombreJoueur;
			}
		}
		for(int i=0;i<l.size();i++) {
			equipe1.getJoueur().add(l.get(i));
		}
		for(int i=0;i<indice.size();i++) {
			equipe2.getJoueur().remove(indice.get(i));
		}

	}
} 