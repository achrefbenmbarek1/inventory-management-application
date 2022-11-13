/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.model.modelE;

import com.mycompany.mavenproject3.IDao.IProduitDao;
import com.mycompany.mavenproject3.dtos.Produit;

/**
 *
 * @author eya
 */
public class ProduitModel implements IProduitDao{
	IProduitDao iProduitDao;

	public ProduitModel(IProduitDao iProduitDao) {
		this.iProduitDao = iProduitDao;
	}

	@Override
	public void supprimer(int id) {
		iProduitDao.supprimer(id);
	}

	@Override
	public int rechercher(int id) {
		return iProduitDao.rechercher(id);
	}

	@Override
	public void ajouter(Produit produit) {
		iProduitDao.ajouter(produit);
	}
	@Override
	public void mettreAjrsStock(int variation, int indice) {
		iProduitDao.mettreAjrsStock(variation, indice);
	}

	@Override
	public String toString() {
		return "ProduitModel{" + "iProduitDao=" + iProduitDao + '}';
	}
	
}
