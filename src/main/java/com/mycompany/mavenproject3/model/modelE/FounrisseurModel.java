/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.model.modelE;

import com.mycompany.mavenproject3.dtos.Fournisseur;
import com.mycompany.mavenproject3.IDao.IFournisseurDao;

/**
 *
 * @author eya
 */
public class FounrisseurModel implements IFournisseurDao{
    
	@Override
	public void supprimer(int id) {
		iFournisseurDao.supprimer(id);

	}

	@Override
	public int rechercher(int id) {
		return iFournisseurDao.rechercher(id);
	}

	@Override
	public void ajouter(Fournisseur fournisseur) {
		iFournisseurDao.ajouter(fournisseur);
	}

	@Override
	public String toString() {
		return "FounrisseurModel{" + "iFournisseurDao=" + iFournisseurDao + '}';
	}

	public FounrisseurModel(IFournisseurDao iFournisseurDao) {
		this.iFournisseurDao = iFournisseurDao;
	}

IFournisseurDao iFournisseurDao;	

}
