package tournoi;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author DELL
 * Une classe permetttant de creer un club
 *
 */
public class Club {
	private List<Equipe> equipe=new ArrayList<Equipe>();
	private Session session;
	private int isEquipe=0;
	private int isSession=0;
	/**
	 * Constructeur deux arguments(une liste dequipe et une liste de combat)
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
	
	public int getIsEquipe() {
		return isEquipe;
	}

	public void setIsEquipe(int isEquipe) {
		this.isEquipe = isEquipe;
	}

	public int getIsSession() {
		return isSession;
	}

	public void setIsSession(int isSession) {
		this.isSession = isSession;
	}

	//fonction permettant d'ajouter une equipe qui re�oit en parametre une session
	public void creerEquipe(Club club) {
		
		Equipe equipe1=new Equipe();
		Equipe equipe2=new Equipe();
		List<Equipe> l=new ArrayList<Equipe>();
		l.add(equipe1);
		l.add(equipe2);
		club.setEquipe(l);	
		this.isEquipe=1;
	}
	//fonciton qu i permet de creer une session qui re �oit en parametre une session 
	public void CreerSession() {
		this.setSession(new Session());
		this.isSession=1;
		
	}
	//fonciton qui permet de creer une liste de joueur
	public List<Joueur> tabJoueur(int nombreJoueur,int ancienete,List<Joueur> joueur){
		List<Joueur> l =new ArrayList<Joueur>();
		double p=40;
		int annee=YearMonth.now().getYear();
		for(int i=0;i<nombreJoueur;i++) {
			if(ancienete==1) {
				if(!joueur.isEmpty()) {
					joueur.add(new Joueur(i,"nom"+i,"prenom"+i,"adresse"+i,p,annee));
				}else {
					l.addAll(joueur);
					joueur.clear();
				}
				annee-=2;
			}else {
				joueur.add(new Joueur(i,"nom"+i,"prenom"+i,"adresse"+i,p,annee));
			}
			p=p+3;
			
		}
		return joueur;	
	}
	
	
 	//fonciton qui permet de partager les 20 joueurs entre les deux equipe
	public void remplissageJoueurJoueur(Equipe equipe1,Equipe equipe2,int nombreJoueur,List<Joueur> joueur) {
		List<Joueur> j =new ArrayList<Joueur>();
		if(joueur.isEmpty()) {
			joueur=tabJoueur(nombreJoueur,0,j);
		}
		
		int taille=joueur.size()/2;
		int nombre1=0;
		double poids1=0;
		int nombre2=0;
		double poids2=0;
		for(int i=0;i<joueur.size();i++){
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
		List<Joueur> l=new ArrayList<Joueur>();
		joueur=tabJoueur(nombreJoueur,1,l);
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
			if(Math.floorMod(total/2,2)==0){
				while((p+valeur!=total/2 || p+valeur!=total/2+2) && j<equipe2.getJoueur().size()){
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
	
	public int isSessionEncours(Session session) {
		return session.getIsSession();
	}
	//Fonction permettant de demarrer ou d'arreter une session
	public void startOrEndSession(Session session) {
		if(this.isSessionEncours(session)==1) {
			session.setIsSession(2);
		}else if(this.isSessionEncours(session)==0) {
			session.setIsSession(1);
		}else {
			System.out.println("Cette cession est dejà terminée");
		}
		
	}
	 //Fonction permettant à l'utlisateur de saisir des joueurs
	public List<Joueur> addPlayer(List<Joueur> joueur) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Saisir le nombre de joueur que vous voulez saisir");
		int nombre =sc.nextInt();
		
		for(int i=0;i<nombre;i++) {
			System.out.println("Saisir le nom du joueur numero: "+i);
			String nom=sc.nextLine();
			System.out.println("Saisir le prenom du joueur numero: "+i);
			String prenom=sc.nextLine();
			System.out.println("Saisir l'adresse du joueur numero: "+i);
			String adresse=sc.nextLine();
			System.out.println("Saisir le poids du joueur numero: "+i);
			double poids=sc.nextDouble();
			joueur.add(new Joueur(i,nom, prenom, adresse, poids, YearMonth.now().getYear()));
		}
		
		return joueur;
		
	}
	
	public int equipeExiste(Club club) {
		int nombre=0;
		if(club.getIsEquipe()!=0) {
			nombre=1;
		}
		return nombre;
 	}
	
	public int sessionExiste(Club club) {
		int nombre=0;
		if(club.getIsSession()!=0) {
			nombre=1;
		}
		return nombre;
 	}
	public void creerArme(List<Joueur> joueur) {
		
		for(int i=0;i<joueur.size();i++) {
			joueur.get(i).setArme(new Arme("arme"));
		}
	}
	public void creerArmure(List<Joueur> joueur) {
		for(int i=0;i<joueur.size();i++) {
			joueur.get(i).setArmure(new Armure("armure"));
		}
		
	}
}