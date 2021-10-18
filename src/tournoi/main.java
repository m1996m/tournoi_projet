package tournoi;

import java.util.*;

public class main {

	public static void main(String[] args) {
		List<Joueur> joueur=new ArrayList<Joueur>();
		List<Joueur> historique=new ArrayList<Joueur>();
		Menu menu =new Menu();
		Club club =new Club() ;
		menu.appelMenuPrincipal(club,joueur,historique);;

	}

}
