package Proxibanque.model;

/**
 * Classe qui permet d'instancier des cartes Bancaires et de les lier � un client.
 * Il s'agit d'un java bean.
 * @author Sandrine
 * @version 0.1
 * 
 *
 */
public class CarteBanquaire {
	
	/**
	 * Client : client auxquel va �tre attribu� la carte
	 * Type : type de la carte (VISA ou electron).
	 * les deux valeurs statiques finales permettent d'attibuer le type sans erreur.
	 * 
	 */
	
	private Client client;
	private String type;
	public static final String VISA = "VISA";
	public static final String ELECTRON = "ELECTRON";
	
	public CarteBanquaire() {
		
	}

	public CarteBanquaire(Client client) {

		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "CarteBanquaire [type=" + type + "]";
	}
	
	

}
