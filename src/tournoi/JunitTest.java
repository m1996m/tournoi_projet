package tournoi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;


class JunitTest {

	Club club=new Club();
	
	//Un test qui permet de verifier si l'objet session existe dans l'objet  club.
	@Test
	public void testIsSession() {
		//club.CreerSession();
		assertNotNull(club.getSession());
		
	}
	
	//Un test qui permet de verifier si un objet equipe existe dans l'objet  club.
	@Test
	public void testEquipeExiste() {
		
		//club.creerEquipe();
		assertNotNull(club.getEquipe());
		
	}

}
