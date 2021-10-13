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
		club.getSession().setEquipe2(club.getEquipe().get(0));
		
	}

	public void DebuterOuArreterManche(Manche manche) {
		
	}
	//fonciton qui permet debuter ou arreter une manche
	public int isManscheStart(Manche manche) {
		
		return 0;
		
	}
	
	//qui permet de mettre � jour le score d'une session ou d'une manche
	public void miseAjourScore(Equipe equipe1, Equipe equipe2) {
		
		
		
	}
	
}
