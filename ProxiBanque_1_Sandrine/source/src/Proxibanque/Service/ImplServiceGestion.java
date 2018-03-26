package Proxibanque.Service;

import java.util.List;
import java.util.Scanner;

import Proxibanque.model.CarteBanquaire;
import Proxibanque.model.Client;
import Proxibanque.model.Compte;
import Proxibanque.model.CompteCourant;
import Proxibanque.model.CompteEpargne;
import Proxibanque.persistance.DaoClient;
import Proxibanque.persistance.MemDAOClient;

/**
 * @author Sandrine
 *
 */
public class ImplServiceGestion implements ServiceGestion {

	DaoClient dao = new MemDAOClient();

	public void creerClient(Client c) {
		// TODO Auto-generated method stub
		dao.save(c);
	}

	public void modifierClient(Integer id,Client cmodif) {
		// TODO 
		// faire un switch case pour modifier les data
		dao.modifyClient(id, cmodif);
	}

	public void lireInfoClient(Integer id) {

		System.out.println("données client" + dao.getById(id));
	}

	@Override
	public void supprimerComptes(Integer id) {
		// TODO Auto-generated method stub
			dao.getById(id).setCompteEpargne(null);
			dao.getById(id).setCompteCourant(null);
		}

	@Override
	public void lireComptes(Integer id) {
		// TODO Auto-generated method stub
		System.out.println(dao.getById(id).getCompteEpargne()+" "+dao.getById(id).getCompteCourant());

	}

	@Override
	public void ajouterCarte(Integer id, CarteBanquaire carte) {
		// TODO Auto-generated method stub
		dao.getById(id).setCarte(carte);

	}

	@Override
	public void supprimerCarte(Integer id) {
		// TODO Auto-generated method stub
		dao.getById(id).setCarte(null);
	}

	@Override
	public void lireCarte(Integer id) {
		// TODO Auto-generated method stub
		System.out.println(dao.getById(id).getCarte());

	}

	@Override
	public void supprimerClient(Integer id) {
		// TODO Auto-generated method stub
		dao.getById(id).setCompteCourant(null);
		dao.getById(id).setCompteEpargne(null);
		dao.getById(id).setCarte(null);
		dao.deleteById(id);
	}

	@Override
	public void ajouterCompteEpargne(Integer id, CompteEpargne c) {
		// TODO Auto-generated method stub
		dao.getById(id).setCompteEpargne(c);
	}

	@Override
	public void ajouterCompteCourant(Integer id, CompteCourant c) {
		// TODO Auto-generated method stub
		dao.getById(id).setCompteCourant(c);
	}

	/**
	 * @author Sandrine
	 *méthode pour faciliter les modifications clients
	 */
	
	@Override
	public Client retournClient(Integer id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public List<Client> retournListeClient() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}


}
