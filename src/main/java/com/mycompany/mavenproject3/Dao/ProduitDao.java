/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Dao;

import com.mycompany.mavenproject3.dtos.Produit;
import java.util.ArrayList;
import com.mycompany.mavenproject3.IDao.IProduitDao;

/**
 *
 * @author eya
 */
public class ProduitDao implements IProduitDao{

	public ProduitDao() {
		produits = new ArrayList<>();
	}

	@Override
	public void supprimer(int id) {
		int indice = rechercher(id);
		if(indice>=0)
			produits.remove(indice);
	}

	@Override
	public int rechercher(int id) {
		for(int i=0;i<produits.size();++i){
			if(produits.get(i).getIdProduit() == id)
				return i;
		}
		return -1;
	}
	@Override	
	public void mettreAjrsStock(int variation ,int indice){
		produits.get(indice).setStock(produits.get(indice).getStock() + variation);
	}

	@Override
	public void ajouter(Produit produit) {
		if(rechercher(produit.getIdProduit()) == -1)
			produits.add(produit);
	}

	@Override
	public String toString() {
		return "ProduitDao{" + "produits=" + produits + '}';
	}

	ArrayList<Produit> produits;
}
