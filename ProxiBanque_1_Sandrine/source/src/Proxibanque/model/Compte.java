package Proxibanque.model;

/**
 * Classe Compte. Il s'agit de la classe m�re des Classes CompteEpargne et CompteCourant.
 * Elle porte en attribut un num�ro de Compte (String), un solde sous forme de double, une date de cr�ation et un type de String.
 * les attributs Public finaux permettent d'attirbuer un compte � un particulier ou a une entreprise simplement.
 *  Il s'agit d'un java bean avec une m�thode toString.
 *  
 *  NOTA BENE : le fait d'avoir diff�rentes classes de types compte permet d'�tre s�r de n'attribuer qu'un compte courant et qu'un 
 *  compte Epargne � chaque client.
 * 
 * @author Sandrine
 * @version 0.1
 *
 */
public class Compte {

	private String numeroCompte;
	private double solde;
	private String datecreation;
	private String type;
	public static final String entreprise = "ENTREPRISE";
	public static final String particulier = "PARTICULIER";

	public Compte() {

	}

	public Compte(String numeroCompte, double solde, String type) {
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.type = type;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Compte [numeroCompte=" + numeroCompte + ", solde=" + solde + ", type=" + type + "]";
	}

}
