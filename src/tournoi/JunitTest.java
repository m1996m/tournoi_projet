package tournoi;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class JunitTest {

	Club club=new Club();
	
	//Un test qui permet de verifier si l'objet session existe dans l'objet  club.
	@Test
	public void testIsSession() {
		club.CreerSession();
		assertNotNull(club.getSession());
		
	}
	
	//Un test qui permet de verifier si un objet equipe existe dans l'objet  club.
	@Test
	public void testEquipeExiste() {
		
		club.creerEquipe();
		assertNotNull(club.getEquipe());
		
	}
	
	//Un test qui permet de verifier s'il ya des joueurs dans l'objet Equipe d'un club.
	@Test
	public void testJoueurExisteDansEquipe() {
		club.creerEquipe();
		club.remplissageJoueurJoueur(club.getEquipe().get(0), club.getEquipe().get(1), club,20);
		assertNotNull("Aucun joueur n'a �t� pas enregistr�", club.getEquipe().get(0).getJoueur().get(0));
		assertNotNull("Aucun joueur n'a �t� pas enregistr�", club.getEquipe().get(1).getJoueur().get(0));
	}

}
