/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.produit.model.interactor;

import com.mycompany.mavenproject3.produit.model.entities.Produit;
import com.mycompany.mavenproject3.produit.model.iinteractor.IProduitInteractor;
import java.util.List;
import com.mycompany.mavenproject3.shared.dataAccessLayer.IDao.IProduitDao;

/**
 *
 * @author eya
 */
public class ProduitIntreractor implements IProduitInteractor{
	IProduitDao produitDao;

	public ProduitIntreractor(IProduitDao produitDao) {
		this.produitDao = produitDao;
	}

	@Override
	public void supprimer(int id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}


	@Override
	public void modifier(Produit produit) {
		Produit ancienProduit = produitDao.rechercher(produit.getIdProduit());
		if(!produit.getNom().equalsIgnoreCase(ancienProduit.getNom()))
			produitDao.updateNom(produit.getIdProduit(), produit.getNom());
		if(produit.getPrix() != ancienProduit.getPrix())
			produitDao.updatePrix(produit.getIdProduit(), produit.getPrix());
		if(!produit.getDesignation().equalsIgnoreCase(ancienProduit.getDesignation()))
			produitDao.updateDesignation(produit.getIdProduit(), produit.getDesignation());
		
	}

	@Override
	public List<Produit> afficherTout() {
		return produitDao.afficherTout();
	}

	
}
