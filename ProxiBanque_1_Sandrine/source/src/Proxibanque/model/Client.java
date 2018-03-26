package Proxibanque.model;

/**
 * Classe client. il s'agit de la classe coeur de l'appli.
 * Cette classe porte en attribut les caract�ristiques du client (nom, prenom, adresse, etc.) sous forme de String, 
 * et l'identifiant sous forme d'un entier (index de la base de donn�es de sauvegarde).
 * Elle porte aussi en attribut les instances des classes CompteCourant, CompteEpargne et CarteBanquaire attibu�s au client.
 * Cette classe est un javabean avec une m�thode toString en plus.
 * 
 * @author Sandrine
 * @version 0.1
 *
 */
public class Client {
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private int id;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	private CarteBanquaire carte;

	public Client(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Client() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public CarteBanquaire getCarte() {
		return carte;
	}

	public void setCarte(CarteBanquaire carte) {
		this.carte = carte;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", id=" + id + ", compteCourant=" + compteCourant + ", compteEpargne="
				+ compteEpargne + ", carte=" + carte + "]";
	}


	
	
}
