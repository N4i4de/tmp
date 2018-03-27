package Proxibanque.Service;

import java.util.ArrayList;
import java.util.List;

import Proxibanque.model.Client;
import Proxibanque.model.Compte;

public class ImplServiceSI implements ServiceSI {
	ImplServiceGestion gestion = new ImplServiceGestion();

	@Override
	public List<Double> simulationCredit(Client client) {
		// DONE simulation credit
		List<Double> donneesimupret= new ArrayList<>();
		double soldecc = client.getCompteCourant().getSolde();
		double soldece = client.getCompteEpargne().getSolde();
		if (soldecc > 0 && soldece > 0) {
			double capaciteemprunt = (soldecc + soldece) * Math.random() * 1000;
			double dureepret = (int) Math.random() * 100;
			double mensualite = (int) (capaciteemprunt / (12 * dureepret));
			donneesimupret.add(capaciteemprunt);
			donneesimupret.add(dureepret);
			donneesimupret.add(mensualite);

		} else {
			donneesimupret.add(0.0);
		}
		return donneesimupret;
		
	}

	@Override
	public void virement(Compte c1, Compte c2, double montant) {
		// DONE Auto-generated method stub
		// C1 : compte d'entree
		// C2 : compte de sortie
		c1.setSolde(c1.getSolde() - montant);
		c2.setSolde(c2.getSolde() + montant);
	}

	@Override
	public List<Client> audit() {
		// DONE Auto-generated method stub
		List<Client> listeclient = gestion.retournListeClient();
		List<Client> listaudit = new ArrayList<>();
		for (Client client : listeclient) {
			double soldecc = client.getCompteCourant().getSolde();
			double soldece = client.getCompteEpargne().getSolde();
			if ((soldecc < -5000.0 || soldece < -5000.0)
					&& client.getCompteCourant().getType().equals(Compte.particulier)) {
				listaudit.add(client);
			} else if ((soldecc < -50000.0 || soldece < -50000.0)
					&& client.getCompteCourant().getType().equals(Compte.entreprise)) {
				listaudit.add(client);
			}
		}
		return listaudit;

	}

	@Override
	public void clientfortune() {
		// vue avec le product Owner=> fonctionnalité laissée de coté.

	}

	@Override
	public List<Client> alerteDecouvert() {
		// DONE Auto-generated method stub
		List<Client> listeclient = gestion.retournListeClient();
		List<Client> listdecouvert = new ArrayList<>();
		for (Client client : listeclient) {
			double soldecc = client.getCompteCourant().getSolde();
			if (soldecc < -1000.0) {
				listdecouvert.add(client);
			}
		}
		return listdecouvert;

	}

}
