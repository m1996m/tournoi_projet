package tournoi;

import java.util.ArrayList;
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
}
