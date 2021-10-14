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
		club.remplissageJoueurJoueur(club.getEquipe().get(0),club.getEquipe().get(1),5);
		assertNotNull("Aucun joueur n'a �t� pas enregistr�", club.getEquipe().get(0).getJoueur().get(0));
		assertNotNull("Aucun joueur n'a �t� pas enregistr�", club.getEquipe().get(1).getJoueur().get(0));
	}
	
	//Un test qui permet de verifier si manche existe dans Session d'un club.
	@Test
	public void testMancheExisteDansSession() {
		club.CreerSession();
		club.getSession().creerManche(2, club);
		assertNotNull("Aucune manche n'a ete pas cree", club.getSession().getNombreManche());
	}
	
	//Un test qui permet de verifier si les deux equipes existent dans Session d'un club.
	@Test
	public void testEquipe1Equipe2ExisteDansSession() {
		club.CreerSession();
		club.creerEquipe();
		club.getSession().formationDesEquipes(club);
		assertNotNull("Aucune manche n'a ete pas cree", club.getSession().getEquipe1());
		assertNotNull("Aucune manche n'a ete pas cree", club.getSession().getEquipe2());
	}
	
	//Un test qui permet de verifier si tout les joueur ont une arme chacun.
	@Test
	public void testArmeJoueurExiste() {
		club.creerEquipe();
		club.CreerSession();
		//remplissage des joueur
		club.getSession().formationDesEquipes(club);
		club.remplissageJoueurJoueur(club.getSession().getEquipe1(),club.getSession().getEquipe2(),4);
		//Creation des armes
		for(int i=0;i<club.getEquipe().size();i++) {
			for(int j=0;j<club.getEquipe().get(i).getJoueur().size();j++) {
				club.getEquipe().get(i).getJoueur().get(j).creerArme(club, i, j);
			}
		}
		for(int i=0;i<club.getEquipe().size();i++) {
			for(int j=0;j<club.getEquipe().get(i).getJoueur().size();j++) {
				assertNotNull("Aucune manche n'a �t� pas cr�e", club.getEquipe().get(i).getJoueur().get(j).getArme());
			}
		}
	}
	//Un test qui permet de verifier si tout les joueur ont un armure chacun.
	@Test
	public void testArmureJoueurExiste() {
		club.creerEquipe();
		club.CreerSession();
		club.getSession().formationDesEquipes(club);
		club.remplissageJoueurJoueur(club.getSession().getEquipe1(),club.getSession().getEquipe2(),3);
		//Creation des armures
		for(int i=0;i<club.getEquipe().size();i++) {
			for(int j=0;j<club.getEquipe().get(i).getJoueur().size();j++) {
				club.getEquipe().get(i).getJoueur().get(j).creerArmure(club, i, j);
			}
		}
		for(int i=0;i<club.getEquipe().size();i++) {
			for(int j=0;j<club.getEquipe().get(i).getJoueur().size();j++) {
				assertNotNull("Aucune manche n'a ete pas cree", club.getEquipe().get(i).getJoueur().get(j).getArmure());			}
		}
	}
	
	/*Un test qui permet de gerer l'equilibre entre les deux equipe en verifiant que soit
	 * soit les equipes ont le meme nombre de joueurs
	 * sinon verifier que le poids  total des joueurs composant les deux equipes se valent.
	 * sinon on s'interesse à l'anciénété pour les equilibres
	 * */
	
	@Test
	public void testEquilibrage() {
		club.creerEquipe();
		club.CreerSession();
		club.getSession().formationDesEquipes(club);
		club.remplissageJoueurJoueur(club.getSession().getEquipe1(),club.getSession().getEquipe2(), 5);
		//Verifier que le nombre de joueur composant les deux equipes sont les memes
		//assertEquals(club.getSession().getEquipe1().getNombreJoueur(), club.getSession().getEquipe2().getNombreJoueur());
		//Verifier que le nombre le poids les deux equipes sont les memes
		assertEquals(club.getSession().getEquipe1().getNombrePoids(), club.getSession().getEquipe2().getNombrePoids());	
	}
}