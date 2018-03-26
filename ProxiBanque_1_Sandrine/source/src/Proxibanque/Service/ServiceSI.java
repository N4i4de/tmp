package Proxibanque.Service;

import java.util.List;

import Proxibanque.model.Client;
import Proxibanque.model.Compte;

/**Interface SI de proxibanque
 * permet de r�aliser des op�rations du SI (Virement, simulation de credit, r�aliser l'audit de l'agence, et lancer l'alerte d�couvert)
 * @author adminl
 *
 */
public interface ServiceSI {
	/**
	 * r�alise une simulation de cr�dit d'un client en prenant en compte sa capacit� � emprunter
	 * @param client
	 * client qui demande la simulation
	 * @return
	 * une liste qui contient soit le montant emprutable, la dur�e du pret et la mensualit� soit la valeur 0 si le client n'est pas en capacit� d'emprunter
	 */
	public List<Double> simulationCredit(Client client);
	/**
	 * R�alise un virement entre un compte c1 et c2 d'un certain montant
	 * @param c1
	 * Compte de d�part du transfert 
	 * @param c2
	 * Compte d'arriv�e du transfert
	 * @param montant
	 * montant du virement
	 */
	public void virement(Compte c1, Compte c2,double montant);
	/**
	 * R�alise un audit de l'agence et renvoie la liste des clients qui ne respectent pas ces conditions.
	 * @return
	 * liste des client avec un d�couvert de plus de 5 000 � pour un particulier et de 50 000 � pour une entreprise
	 */
	public List<Client> audit();
	/**
	 * m�thode pour travailler avec les clients fortun�s. cette fonctionnalit� n'est pas impl�ment�e � ce jour. (vu et valider avec le Product Owner)
	 */
	public void clientfortune();
	/**
	 * R�alise l'alerte d�couvert et retourne la liste des clients qui ne respectent pas leur conditions de d�couverts.
	 * @return
	 * retourne la liste des client qui ont un compte courant avec un d�couvert sup�rieur � 1 000 �.
	 */
	public List<Client> alerteDecouvert();
}
