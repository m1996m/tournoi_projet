package tournoi;

import java.util.*;

/**
 * @author DELL
 *Class permettant de creer un combat
 */
public class Session {
	// Declaration des attributs equipe1,equipe2 et nombrebre de Manche
	private Equipe equipe1;
	private Equipe equipe2;
	private List<Manche> nombreManche= new ArrayList<Manche>();
	private int isSession;
	

	/**
	 * Construct avec trois arguments qui sont: equipe1,equipe2 et le nombre de manche
	 */
	/*public Session(Equipe equipe1,Equipe equipe2) {
		// TODO Auto-generated constructor stub
		this.equipe1=equipe1;
		this.equipe2=equipe2;
		this.nombreManche=null;
	}*/

	public Equipe getEquipe1() {
		return equipe1;
	}

	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}

	public Equipe getEquipe2() {
		return equipe2;
	}

	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}
	
	//fonciton qui permet debuter ou arreter une manche

	public List<Manche> getNombreManche() {
		return nombreManche;
	}

	public void setNombreManche(List<Manche> nombreManche) {
		this.nombreManche = nombreManche;
	}

	public int getIsSession() {
		return isSession;
	}

	public void setIsSession(int isSession) {
		this.isSession = isSession;
	}
	
	//qui permet de mettre � jour le score d'une session ou d'une manche
	public void creerManche(int nombre,Club club) {
		List<Manche> l =new ArrayList<Manche>();
		for(int i=0;i<nombre;i++) {
			club.getSession().getNombreManche().add(new Manche("manche"+i)); 
		}
		
	}
	
	//fonciton qui permet de former les equipes
	public void formationDesEquipes(Club club) {
		
		club.getSession().setEquipe1(club.getEquipe().get(0));
		club.getSession().setEquipe2(club.getEquipe().get(1));
		
	}
	//Fonction permettant de rechercher une manche
	public int rehercherMancheEncours(Session session,int resultat) {
		int i=0;
		int valeur=-1;
		while(session.getNombreManche().get(i).getIsManche()!=resultat && session.getNombreManche().size()!=i+1) {
			i++;
		}
		if(session.getNombreManche().get(i).getIsManche()==resultat) {
			valeur=i;
		}
		return valeur;
	}

	public void startOrStopManche(Session session) {
		
		if(session.getNombreManche().get(this.rehercherMancheEncours(session, 0)).getIsManche()==0) {
			session.getNombreManche().get(this.rehercherMancheEncours(session, 0)).setIsManche(1);
			
		}else if(session.getNombreManche().get(this.rehercherMancheEncours(session, 1)).getIsManche()==1) {
			session.getNombreManche().get(this.rehercherMancheEncours(session, 1)).setIsManche(2);
		}else {
			System.out.println("Toutes les manches sont terminées");
		}
	}
	
	//qui permet de mettre � jour le score d'une session ou d'une manche
	public void miseAjourScore(Equipe equipe1, Equipe equipe2) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Saisir le score de la première equipe");
		int score =sc.nextInt();
		equipe1.setNombrePoids(score);
		System.out.println("Saisir le score de la deuxième equipe");
		score=sc.nextInt();
		equipe2.setNombrePoids(score);
		
	}
	//qui permet de passer à une nouvelle manche
	public void mancheSuivant(Club club) {
		int i=0;
		int trouve=0;
		while(i<club.getSession().getNombreManche().size() && trouve==0) {
			if(club.getSession().getNombreManche().get(i).getIsManche()!=1 &&club.getSession().getNombreManche().get(i).getIsManche()!=2)
			{
				trouve=1;
			}else {
				i++;
			}
		}
		if(trouve==1) {
			club.getSession().getNombreManche().get(i).setIsManche(1);
			club.getSession().getNombreManche().get(i-1).setIsManche(2);
		}
	}

	@Override
	public String toString() {
		return "Session [equipe1=" + equipe1 + ", equipe2=" + equipe2 + "]";
	}
		
	
}  