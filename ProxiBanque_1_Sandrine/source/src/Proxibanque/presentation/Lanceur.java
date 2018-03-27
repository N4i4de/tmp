package Proxibanque.presentation;

import java.util.List;
import java.util.Scanner;

import Proxibanque.Service.ImplServiceGestion;
import Proxibanque.Service.ImplServiceSI;
import Proxibanque.model.CarteBanquaire;
import Proxibanque.model.Client;
import Proxibanque.model.Compte;
import Proxibanque.model.CompteCourant;
import Proxibanque.model.CompteEpargne;
import Proxibanque.model.Conseiller;



/**
 * Main du programme.
 * g�re l'interface utilisateur. Commence par un tuto destin� au conseiller puis suit par une IHM qui permet plusieurs actions au choix.
 * @author Sandrine
 * @version 0.1
 *
 */
//test git
public class Lanceur {

	public static void main(String[] args) {
		// DONE faire un lanceur
		// Initialisation 
		String particulier = Compte.particulier;
		String entreprise = Compte.entreprise;
		String electron = CarteBanquaire.ELECTRON;
		String visa = CarteBanquaire.VISA;

		ImplServiceGestion gestion = new ImplServiceGestion();
		ImplServiceSI si = new ImplServiceSI();

		// Partie Tuto (permet une initialisation de donn�es client)
		Scanner input = new Scanner(System.in);
		System.out.println("bienvenue dans le SI de proxibanque" + '\n' + "Partie Tuto : Cot� conseill�");
		// Cr�ation Conseiller
		System.out.println("Conseiller, entrez votre nom");
		String nomconseiller = input.nextLine();
		Conseiller conseil1 = new Conseiller();
		conseil1.setNom(nomconseiller);

		// Partie Tuto : cr�ation Client
		System.out.println("Creation d'un client" + '\n' + "Entrez le nom du client");
		String nomclient1 = input.nextLine();
		System.out.println("Entrez le pr�nom du client");
		String prenomc1 = input.nextLine();
		Client client1 = new Client(nomclient1, prenomc1);
		conseil1.getListeClient().add(client1);
		gestion.creerClient(client1);
		Integer id = client1.getId();
		gestion.lireInfoClient(id);
		// Partie tuto : Ajout d'un compte Epargne
		System.out.println("Ajoutez un compte Epargne � votre client");
		CompteEpargne compteepargne1 = new CompteEpargne();
		client1.setCompteEpargne(compteepargne1);
		// solde du compte
		System.out.println("Entrez le solde du compte : ");
		Double soldecompteepargne = input.nextDouble();
		input.nextLine();
		compteepargne1.setSolde(soldecompteepargne);
		compteepargne1.setNumeroCompte("E" + client1.getId());
		// particulier ou entreprise
		System.out.println("Particulier [p] ou Entreprise [e]?");
		String reptypecompte = input.nextLine();
		if (reptypecompte.equals("p")) {
			compteepargne1.setType(particulier);
		} else if (reptypecompte.equals("e")) {
			compteepargne1.setType(entreprise);
		}
		gestion.lireComptes(id);
		// Ajout d'un compte Courant
		System.out.println("Ajoutez un compte courant � votre client");
		CompteCourant comptecourant1 = new CompteCourant();
		client1.setCompteCourant(comptecourant1);
		System.out.println("Entrez le solde du compte : ");
		Double soldecomptecourant = input.nextDouble();
		input.nextLine();
		comptecourant1.setSolde(soldecomptecourant);
		comptecourant1.setNumeroCompte("C" + client1.getId());
		System.out.println("Particulier [p] ou Entreprise [e]?");
		reptypecompte = input.nextLine();
		if (reptypecompte.equals("p")) {
			comptecourant1.setType(particulier);
		} else if (reptypecompte.equals("e")) {
			comptecourant1.setType(entreprise);
		}
		gestion.lireComptes(id);
		// Ajout d'une carte
		System.out.println("Ajoutez une carte � votre client");
		CarteBanquaire carte1 = new CarteBanquaire(client1);
		System.out.println("Visa [v] ou Electron [e]");
		String rep = input.nextLine();
		switch (rep) {
		case "e":
			carte1.setType(electron);
			break;
		case "v":
			carte1.setType(visa);
			break;
		default:
			System.out.println("erreur, carte non cr��e");
			break;
		}
		gestion.ajouterCarte(id, carte1);
		gestion.lireCarte(id);

		// Partie IHM � choix :
		System.out.println("La partie tutorielle est termin�e. vous pouvez maintenant passer au logiciel");
		int reponseutilisateur = 1;
		do {
			System.out.println("Que voulez vous faire ?" + '\n' + "Ajouter un nouveau client [1]" + '\n'
					+ "Creer des compte [2]" + '\n' + "Creer une carte [3]" + '\n' + "Modifier les donn�es clients [4]"
					+ '\n' + "Faire un viremment [5]" + '\n' + "Faire une simulation de Credit [6]" + '\n'
					+ "Gerer des clients fortun�s [7]" + '\n' + "Lancer l'alerte d�couvert [8]" + '\n'
					+ "Lancer l'audit [9]" + '\n' + "Quitter Proxibanque SI [0]");
			reponseutilisateur = input.nextInt();
			input.nextLine();
			switch (reponseutilisateur) {
			case 1:// ajout client
				if (conseil1.getListeClient().size() < 10) {
					System.out.println("Creation d'un client" + '\n' + "Entrez le nom du client");
					String nomclienti = input.nextLine();
					System.out.println("Entrez le pr�nom du client");
					String prenomclienti = input.nextLine();
					Client clienti = new Client(nomclienti, prenomclienti);
					conseil1.getListeClient().add(clienti);
					gestion.creerClient(clienti);
					CompteCourant comptecouranti = new CompteCourant();
					CompteEpargne compteepargnei = new CompteEpargne();
					//mise � z�ro des comptes pour �viter les probl�mes pour les audits et les alertes d�couverts
					clienti.setCompteCourant(comptecouranti);
					clienti.setCompteEpargne(compteepargnei);
					clienti.getCompteCourant().setSolde(0);
					clienti.getCompteEpargne().setSolde(0);
					Integer idi = clienti.getId();
					gestion.lireInfoClient(idi);
				} else {
					System.out.println("Conseill� "+conseil1.getNom()+" Vous avez d�j� 10 clients � votre charge");
				}

				break;
			case 2:// creer un compte
				System.out.println("Eparge[e] ou Courant [c]");
				String repc = input.nextLine();

				if (repc.equals("e")) {
					// epargne
					System.out
							.println("cr�ation d'un compte �pargne" + '\n' + "entr�e l'identifiant chiffr� du client");
					Integer idi = (Integer) input.nextInt();
					CompteEpargne compteepargnei = new CompteEpargne();
					Client clienti = gestion.retournClient(idi);
					clienti.setCompteEpargne(compteepargnei);
					System.out.println("Entrez le solde du compte : ");
					Double soldecei = input.nextDouble();
					compteepargnei.setSolde(soldecei);
					compteepargnei.setNumeroCompte("E" + clienti.getId());
					input.nextLine();
					System.out.println("Particulier [p] ou Entreprise [e]?");
					reptypecompte = input.nextLine();
					if (reptypecompte.equals("p")) {
						compteepargnei.setType(particulier);
					} else if (reptypecompte.equals("e")) {
						compteepargnei.setType(entreprise);
					}
					gestion.modifierClient(idi, clienti);
					gestion.lireComptes(idi);

				} else if (repc.equals("c")) {
					// courant
					System.out
							.println("cr�ation d'un compte courant" + '\n' + "entr�e l'identifiant chiffr� du client");
					int idi = input.nextInt();
					Client clienti = gestion.retournClient(idi);
					CompteCourant comptecouranti = new CompteCourant();
					clienti.setCompteCourant(comptecouranti);
					System.out.println("Entrez le solde du compte : ");
					Double soldecomptecouranti = input.nextDouble();
					comptecouranti.setSolde(soldecomptecouranti);
					comptecouranti.setNumeroCompte("C" + clienti.getId());
					input.nextLine();
					System.out.println("Particulier [p] ou Entreprise [e]?");
					reptypecompte = input.nextLine();
					if (reptypecompte.equals("p")) {
						comptecouranti.setType(particulier);
					} else if (reptypecompte.equals("e")) {
						comptecouranti.setType(entreprise);
					}
					gestion.modifierClient(idi, clienti);
					gestion.lireComptes(idi);
				} else {
					System.out.println("erreur. compte non cr�er");
				}
				input.nextLine();

				break;
			case 3: // creer une carte
				System.out.println("Ajoutez une carte � votre client");
				CarteBanquaire cartei = new CarteBanquaire();
				System.out.println("Visa [v] ou Electron [e]");
				String repcarte = input.nextLine();
				switch (repcarte) {
				case "e":
					cartei.setType(electron);
					break;
				case "v":
					cartei.setType(visa);
					break;
				default:
					System.out.println("erreur, carte non cr��e");
					break;
				}
				gestion.ajouterCarte(id, cartei);
				gestion.lireCarte(id);
				break;
			case 4: // Modifier les donn�es clients
				System.out.println("Entrez l'identifant du client � modifier");
				Integer idi = (Integer) input.nextInt();
				Client clienti = gestion.retournClient(idi);
				System.out.println(clienti);
				input.nextLine();
				System.out.println("Que voulez vous modifier ?" + '\n'
						+ "nom [n], pr�nom [p], adresse [a], code postal [c] ou la ville [v] ? ou supprimer le client [s]? ");
				// swicth case pour les diff�rents attributs
				String repm = input.nextLine();
				switch (repm) {
				case "n":// nom
					System.out.println("Entrez la nouvelle donn�es : ");
					String newnom = input.nextLine();
					clienti.setNom(newnom);
					gestion.modifierClient(idi, clienti);
					break;
				case "p":// prenom
					System.out.println("Entrez la nouvelle donn�es : ");
					String newprenom = input.nextLine();
					clienti.setNom(newprenom);
					gestion.modifierClient(idi, clienti);

					break;
				case "a":// adresse
					System.out.println("Entrez la nouvelle donn�es : ");
					String newadresse = input.nextLine();
					clienti.setNom(newadresse);
					gestion.modifierClient(idi, clienti);

					break;
				case "c":// code postal
					System.out.println("Entrez la nouvelle donn�es : ");
					String newcode = input.nextLine();
					clienti.setNom(newcode);
					gestion.modifierClient(idi, clienti);

					break;
				case " v":// ville
					System.out.println("Entrez la nouvelle donn�es : ");
					String newville = input.nextLine();
					clienti.setNom(newville);
					gestion.modifierClient(idi, clienti);

					break;
				case "s": // suppression d'u client
					System.out.println("suppression du client");
					gestion.supprimerClient(idi);
				default:
					System.out.println("erreur, donn�e client laiss�e identique");
					break;
				}
				System.out.println(gestion.retournClient(idi));

				break;
			case 5: // Faire un virement
				System.out.println("entrez le n� de compte de d�part");
				String numcompte1 = input.nextLine();
				System.out.println("entrez le n� de compte d'arriv�e");
				String numcompte2 = input.nextLine();
				System.out.println("entrez le montant � virer");
				double montant = input.nextDouble();
				List<Client> listeClient = gestion.retournListeClient();
				Compte comptedepart = new Compte();
				Compte comptedarrivee = new Compte();
				for (Client client : listeClient) {
					Compte compteepargeteste = client.getCompteEpargne();
					Compte comptecourantteste = client.getCompteCourant();
					if (compteepargeteste.getNumeroCompte().equals(numcompte1)) {
						comptedepart = compteepargeteste;
					} else if (comptecourantteste.getNumeroCompte().equals(numcompte1)) {
						comptedepart = comptecourantteste;
					}
					if (compteepargeteste.getNumeroCompte().equals(numcompte2)) {
						comptedarrivee = compteepargeteste;
					} else if (comptecourantteste.getNumeroCompte().equals(numcompte2)) {
						comptedarrivee = comptecourantteste;
					}

				}
				si.virement(comptedepart, comptedarrivee, montant);
				System.out.println("nouveau solde compte depart " + comptedepart.getSolde() + '\n'
						+ "nouveau solde compte arrivee " + comptedarrivee.getSolde());
				break;
			case 6:// Faire une simulation de credit
				System.out.println("Entrez l'identifant du client qui demande la simulation de pr�t");
				idi = (Integer)input.nextInt();
				Client clientpret = gestion.retournClient(idi);
				List<Double> reponsesimulationpret = si.simulationCredit(clientpret);
				if(reponsesimulationpret.size()>1) {
					double montantpret = reponsesimulationpret.get(0);
					double dureepret = reponsesimulationpret.get(1);
					double mensualitepret = reponsesimulationpret.get(2);
					
					System.out.println("Vous pouvez avoir un pr�t de " + montantpret+ " remboursable sur "+ dureepret+" ans et de mensualit� "+ mensualitepret);
					
				}else {
					System.out.println("d�sol�e, le pret ne peut �tre accord�.");
				}

				break;
			case 7:// Gerer les clients fortune
				System.out.println("Fonctionnalit� pas encore disponible. (Vu et valid� avec le product owner).");

				break;
			case 8:// Lancer l'alerte d�couvert
				System.out.println("lancement de l'analyse d�couvert...");
				List<Client> listeclientdecouvert = si.alerteDecouvert();
				if (listeclientdecouvert.size()!=0) {
					System.out.println("Attention : " + listeclientdecouvert.size() +" client(s) d�passe(nt) leur d�couvert autoris�. Voici la liste");
					for (Client clientdecouvert : listeclientdecouvert) {
						System.out.println(clientdecouvert);
					}
					System.out.println("Ces clients ont �t� pr�venus par sms de leur d�couvert.");
				} else {
					System.out.println("aucun client ne d�passe son d�couvert autoris�");
				}
				

				break;
			case 9:// Lancer l'audit
				System.out.println("Lancement de l'audit de votre agence");
				List<Client> listeclientaudit = si.audit();
				if (listeclientaudit.size() != 0) {
					System.out.println(
							"Attention, " + listeclientaudit.size() + " client(s) ne respecte(nt) pas les conditions d'audit. Voici la liste");
					for (Client clientaudit : listeclientaudit) {
						System.out.println(clientaudit);
					}

				} else {
					System.out.println("Felicitations. tout vos clients respectent les conditions d'audit");
				}

				break;
			case 0 : 
				break;
				
			default:
				System.out.println("Je n'ai pas compris votre r�ponse.");
				break;
			}

		} while (reponseutilisateur != 0);
		input.close();
		System.out.println("Fermeture du logiciel ProxibanqueSI" + '\n' + "Au revoir et � bientot");
	}

}
