package tournoi;
import java.util.*;

public class Menu {
	public void menuPrincipal(Club club) {
		System.out.println();
		System.out.println("\t\t Bienvenu sur notre logiciel de jeu");
		System.out.println("\t -1 Entraitenement");
		System.out.println("\t -0 Quitter");
		System.out.println();
		System.out.println();
	}
	
	public void menuCombat(Club club) {
		System.out.println();
		System.out.println("\t\t Bienvenu sur notre logiciel");
		System.out.println("\t -1 Equipes");
		System.out.println("\t -2 Session");
		System.out.println("\t -3 Ajouter le score");
		System.out.println("\t -4 Ajouter des joueurs");
		System.out.println("\t -5 Menu Principal");
		System.out.println("\t -0 Quitter");
		System.out.println();
		System.out.println();
	}
	
	public void menuSession(Club club) {
		System.out.println();
		System.out.println("\t\t Bienvenu sur notre logiciel");
		System.out.println("\t -1 Creer une session");
		System.out.println("\t -2 Ajouter des equipes a la session");
		System.out.println("\t -3 Creer des manches");
		System.out.println("\t -4 Manche suivant");
		System.out.println("\t -5 Lancer la session");
		System.out.println("\t -6 Liste joueur par equipe");
		System.out.println("\t -7 Liste manche");
		System.out.println("\t -8 Arreter la session");
		System.out.println("\t -9 Etat de la session");
		System.out.println("\t -10 Manche actuelle");
		System.out.println("\t -11 Retour");
		System.out.println("\t -0 Quitter");
		System.out.println();
		System.out.println();
	}
	
	public void menuEquipe(Club club) {
		System.out.println();
		System.out.println("\t\t Bienvenu sur notre logiciel");
		System.out.println("\t -1 Creer des equipes");
		System.out.println("\t -2 Creer les joueurs");
		System.out.println("\t -3 Liste equipe");
		System.out.println("\t -4 Liste joueur");
		System.out.println("\t -5 Retour");
		System.out.println("\t -0 Quitter");
		System.out.println();
		System.out.println();
	}
	
	public void appelMenuPrincipal(Club club,List<Joueur> joueur,List<Joueur> historique) {
		int choix=0;
		Scanner sc =new Scanner(System.in);
		this.menuPrincipal(club);
		System.out.println("Faites un choix");
		choix=sc.nextInt();
		if(choix==1) {
			this.jeu(club,joueur,historique);
		}else if(choix==0) {
			System.exit(0);
		}
	}
	
	public void jeu(Club club,List<Joueur> joueur,List<Joueur> historique) {
		int choix=0;
		Scanner sc =new Scanner(System.in);
		do {
			this.menuCombat(club);
			System.out.println("Faites un choix");
			choix=sc.nextInt();
			switch(choix) {
			case 1:
				this.equipe(club,joueur,historique);
				break;
			case 2:
				this.session(club,joueur,historique);
				break;	
			case 3:
				int nombre=0;
				if(club.isSessionEncours(club.getSession())==1) {
					do {
						club.getSession().miseAjourScore(club.getSession().getEquipe1(), club.getSession().getEquipe2());
						club.startOrEndSession(club.getSession());
						System.out.println("Mise a jour du score bien reussi");
					}while(nombre<0);
				}else {
					System.out.println(" Aucune session encours");
				}
				break;
			case 4:
				if(club.isSessionEncours(club.getSession())==1) {
					club.addPlayer(joueur);
					if(club.getSession().rehercherMancheEncours(club.getSession(), 1)==-1) {
						club.remplissageJoueurJoueur(club.getSession().getEquipe1(), club.getSession().getEquipe2(), joueur.size(),joueur);
						club.testEquilibrage(club.getSession().getEquipe1(), club.getSession().getEquipe2(), joueur.size(), joueur);
						club.creerArme(joueur);
						club.creerArmure(joueur);
						historique=club.tabJoueur(1, 1,historique);
					}
				}else {
					System.out.println("La session n'a commencé");
				}
				break;
			case 5:
				this.appelMenuPrincipal(club,joueur,historique);
			case 0:
				System.exit(0);
			default:
				System.out.println("Entrer un bon numero");
			}
			
		}while(choix!=0);
	}
	
	public void session(Club club,List<Joueur> joueur,List<Joueur> historique) {
		int choix=0;
		Scanner sc =new Scanner(System.in);
		do {
			this.menuSession(club);
			System.out.println("Faites un choix");
			choix=sc.nextInt();
			switch(choix) {
			case 1:
				if(club.sessionExiste(club)==0) {
					club.CreerSession();
					System.out.println("Session bien créée");
				}else {
					System.out.println("Une session existe dejà");
				}
				break;
			case 2:
				if(club.equipeExiste(club)==1) {
					club.getSession().formationDesEquipes(club);
					System.out.println("Les equipes sont ajoutees avec succes");
				}else{
					System.out.println("Il faut creer des equipes dabord");
				}
				break;
			case 3: 
				int nombre;
				if(club.isSessionEncours(club.getSession())==0) {
					do {
						System.out.println("Entrer le nombre de manches?");
						nombre=sc.nextInt();
					}while(nombre<0);
					club.getSession().creerManche(nombre, club);
					System.out.println("Manche créée avec succès");
				}else {
					System.out.println("Il faut creer une manche dabord");
				}
				break;	
			case 4:
				if(club.getSession().getIsSession()==1) {
					if(!club.getSession().getNombreManche().isEmpty()) {
					if(club.getSession().getNombreManche().get(0).getIsManche()!=0 &&
					club.getSession().getNombreManche().get(club.getSession().getNombreManche().size()-1).getIsManche()==0) {
						if(!joueur.isEmpty()) {
							club.remplissageJoueurJoueur(club.getSession().getEquipe1(), club.getSession().getEquipe2(), joueur.size(),joueur);
							club.testEquilibrage(club.getSession().getEquipe1(), club.getSession().getEquipe2(), joueur.size(), joueur);
							historique.addAll(joueur);
							joueur.clear();
						}
						int total=club.getSession().rehercherMancheEncours(club.getSession(), 1)+1;
						club.getSession().mancheSuivant(club);
						System.out.println("Vous êtes passé a la manche suivante");
						System.out.println("Vous etes a la "+total+"/"+club.getSession().getNombreManche().size()+"manche");
					}else {
						System.out.println("La session n'est pas lance dabord/oubien vous ete sur la derniere manche");
					}
					
				}
				}else {
					System.out.println("Lancer la session dabord");
				}

				break;
			case 5:
				if(club.getSession().getIsSession()==0 && !club.getSession().getNombreManche().isEmpty()) {
					if(club.getSession().getNombreManche().get(0).getIsManche()==0){
					club.getSession().startOrStopManche(club.getSession());
					club.startOrEndSession(club.getSession());
					System.out.println("La première manche et la session bien lancée");
				}else {
		 			System.out.println("La manche a deja debuté");
				}
				}else {
					System.out.println("La session n'est pas lance dabord/oubien vous ete sur la derniere manche");
				}

				break;
			case 6:
				System.out.println(club.getSession().getEquipe1().toString());
				System.out.println(club.getSession().getEquipe2().toString());
				break;
			case 7:
				System.out.println(club.getSession().getNombreManche().toString());
				break;
			case 8:
				if(!club.getSession().getNombreManche().isEmpty()) {
					if(club.getSession().getNombreManche().get(club.getSession().getNombreManche().size()-1).getIsManche()==1) {
						if(club.getSession().getIsSession()==1) {
							club.getSession().getNombreManche().get(club.getSession().getNombreManche().size()-1).setIsManche(2);
							club.getSession().setIsSession(2);
							System.out.println("Fin de la session" );
						}
					}
				}
				break;
			case 9:
				if(club.getSession().getIsSession()==0) {
					System.out.println("Session en attente");
				}else if(club.getSession().getIsSession()==1){
					System.out.println("Session encours");
					
				}else {
					System.out.println("Session est terminee");
				}
				break;
			case 10:
				if(club.getSession().getIsSession()==1 && !club.getSession().getNombreManche().isEmpty()) {
					int total=club.getSession().rehercherMancheEncours(club.getSession(), 1)+1;
					if(club.getSession().rehercherMancheEncours(club.getSession(), 1)!=-1) {
						System.out.println("Vous etes a la "+total+"/"+club.getSession().getNombreManche().size()+"manche");
					}else {
						System.out.println("Toustes les manches sont jouees");
					}
				}else {
					System.out.println("Session en attente ou manche non creee");
				}
				break;
			case 11:
				this.jeu(club,joueur,historique);
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Faite un bon choix");				
			}
			
		}while(choix!=0);
	}
	
	public void equipe(Club club,List<Joueur> joueur,List<Joueur> historique) {
		int choix=0;
		Scanner sc =new Scanner(System.in);
		do {
			this.menuEquipe(club);
			System.out.println("Faites un choix");
			choix=sc.nextInt();
			switch(choix) {
			case 1:
				if(club.getIsEquipe()==0) {
					club.creerEquipe(club);
					System.out.println("Equipes bien créée avec succès");
				}else {
					System.out.println("Equipe dejà creer");
				}

				break;
			case 2:
				int nombreJoueur;
				if(club.getIsEquipe()==0 && club.getEquipe().get(0).getJoueur().isEmpty()) {
					System.out.println("Il faut dabord creer des equipes ");
				}else {
					do {
						System.out.println("Donner le nombre de joueurs?");
						nombreJoueur =sc.nextInt();
					}while(nombreJoueur<2);
					//creation des joueur
					club.remplissageJoueurJoueur(club.getEquipe().get(0), club.getEquipe().get(1), nombreJoueur,joueur);
					if(!club.getEquipe().get(0).getJoueur().isEmpty()) {
						//Creation des armes 
						club.creerArme(club.getEquipe().get(0).getJoueur());
						club.creerArme(club.getEquipe().get(1).getJoueur());
						//Creation des armures
						club.creerArmure(club.getEquipe().get(0).getJoueur());
						club.creerArmure(club.getEquipe().get(1).getJoueur());
					}
					System.out.println("Joueur ajoute avec succes");
					historique.addAll(joueur);
					joueur.clear();
				}
				break;
			case 3:
				System.out.println(club.getEquipe().toString());
				break;
			case 4:
				for(int i=0;i<club.getEquipe().size();i++) {
					System.out.println(club.getEquipe().get(i).getJoueur().toString());
				}
				break;
			case 5:
				this.jeu(club,joueur,historique);
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Faites un bon choix");
			}
			
			
		}while(choix!=0);
	}

} 