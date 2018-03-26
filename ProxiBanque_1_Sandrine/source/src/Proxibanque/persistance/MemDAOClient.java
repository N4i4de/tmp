package Proxibanque.persistance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import Proxibanque.model.Client;

/**
 * Classe qui implémente l'interface DaoClient. 
 * Pour l'exercice les instances de client sont sauvegarder icidans une HashMap. elle est Statique finale pour éviter des écritures ou suppression malheureuse.
 * @author Sandrine
 *
 */
public class MemDAOClient implements DaoClient {
	
	public static final HashMap<Integer, Client> DBCLIENT = new HashMap<>();

	/* (non-Javadoc)
	 * @see Proxibanque.persistance.DaoClient#save(Proxibanque.model.Client)
	 */
	public void save(Client c) {
		// DONE Sauvegarder le client dans la Hasmap et y ajoute son index
		Integer i = DBCLIENT.size();
		Integer index = i+((int)Math.random()*10);
		DBCLIENT.put(i+((int)Math.random()*10),c);
		c.setId(index);
	}

	public Client getById(Integer id) {
		// DONE récupérer le client
		return DBCLIENT.get(id);
	}

	public void deleteById(Integer id) {
		// DONE supprimer le client
		DBCLIENT.remove(id);

	}

	public List<Client> getAll() {
		// DONE recuperer la liste des instances Client sauvegardées.
		Collection<Client> c = DBCLIENT.values();
		ArrayList<Client> liste = new ArrayList<Client>(c);
		return  liste;
	}

	public void modifyClient(Integer id, Client cmodif) {
		// DONE modifier une instance de client stockée.
		DBCLIENT.remove(id);
		DBCLIENT.put(id, cmodif);
		
	}


}
