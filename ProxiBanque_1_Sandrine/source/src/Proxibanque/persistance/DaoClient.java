package Proxibanque.persistance;

import java.util.List;

import Proxibanque.model.Client;

/**
 * Interface du DAO. ne contient que des m�thodes abstraites
 * 
 * @author Sandrine
 * @version 0.1
 */
public interface DaoClient {

	/**
	 * Sauvegarde d'un client
	 * 
	 * @param c
	 *            Instance de la classe Client que l'on va sauvegarder
	 */
	public void save(Client c);
	

	/**
	 * retourne une instance de la classe Client sp�cifique 
	 * @param id
	 * identifiant chiffr� du client et index dans la base de donn�e. il permet de retrouver facilement le client pour le retourner
	 * @return
	 * elle retourne l'instance de la classe Client porteuse de l'identifiant id et stock�e � l'index id dans la base de sauvegarde
	 */
	public Client getById(Integer id);

	/**
	 * @param id
	 * identifiant chiffr� du client et index dans la base de donn�e. il permet de retrouver facilement le client � d�truire.
	 */
	public void deleteById(Integer id);

	/**
	 * pour r�cuperer les clients
	 * @return
	 * la liste de toutes les instances de la classe Client stok�e
	 */
	public List<Client> getAll();
	

	/**
	 * m�thode pour modifier un client
	 * @param id
	 * identifiant du client
	 * @param cmodif
	 * Instance de l'objet client avec les modifications � int�grer.
	 */
	public void modifyClient(Integer id, Client cmodif);

}
