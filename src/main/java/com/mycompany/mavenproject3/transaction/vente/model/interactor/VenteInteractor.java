/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.vente.model.interactor;

import com.mycompany.mavenproject3.produit.model.entities.Produit;
import com.mycompany.mavenproject3.shared.dataAccessLayer.IDao.IDao;
import com.mycompany.mavenproject3.shared.dataAccessLayer.IDao.IProduitDao;
import com.mycompany.mavenproject3.transaction.vente.model.entity.Vente;
import com.mycompany.mavenproject3.transaction.interactor.ITransactionInteractor;
import com.mycompany.mavenproject3.transaction.vente.dto.NouvelleVenteDto;
import java.sql.Date;
import java.util.List;


/**
 *
 * @author achref
 */
public class VenteInteractor implements ITransactionInteractor<Vente, NouvelleVenteDto>{
	
	private IDao<Vente> venteDao;
	private IProduitDao produitDao;

	public VenteInteractor(IDao<Vente> venteDao,  IProduitDao produitDao) {
		this.venteDao = venteDao;
		this.produitDao = produitDao;
	}

	@Override
	public void supprimer(int id) {
		int idProduit = venteDao.rechercher(id).getIdProduit();
		int quantiteVenduAnnuler = venteDao.rechercher(id).getQuantiteVendu();
		Produit produit = produitDao.rechercher(idProduit);
		produitDao.updateStock(idProduit, produit.getStock() + quantiteVenduAnnuler);
		venteDao.supprimer(id);
	}

	@Override
	public Vente rechercher(int id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void ajouter(NouvelleVenteDto dto) {
		Vente vente = new Vente(dto.getIdVente(), dto.getIdProduit(),dto.getIdClient(),dto.getQuantiteVendu() ,new Date(System.currentTimeMillis()));

		Produit produit = produitDao.rechercher(vente.getIdProduit());
		produit.setStock(produit.getStock()-vente.getQuantiteVendu());
		venteDao.ajouter(vente);
		produitDao.updateStock(vente.getIdProduit(), produit.getStock());
			
	}

	@Override
	public List<Vente> afficherTout() {
		return venteDao.afficherTout();
	}

	@Override
	public void modiferQuantie(int id, int quantite) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	

}
