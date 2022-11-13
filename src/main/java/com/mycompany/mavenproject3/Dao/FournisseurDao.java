/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Dao;

import com.mycompany.mavenproject3.dtos.Fournisseur;
import com.mycompany.mavenproject3.IDao.IFournisseurDao;
import java.util.ArrayList;

/**
 *
 * @author eya
 */
public class FournisseurDao implements IFournisseurDao{

	public FournisseurDao() {
		fournisseurs = new ArrayList<>();
	}




	@Override
	public void supprimer(int id) {
		int indice = rechercher(id);
		if(indice>=0)
			fournisseurs.remove(indice);
	}

	@Override
	public int rechercher(int id) {
		for(int i=0;i<fournisseurs.size();++i){
			if(fournisseurs.get(i).getIdFr() == id)
				return i;
		}
		return -1;
	}

	@Override
	public void ajouter(Fournisseur fournisseur) {
		if(rechercher(fournisseur.getIdFr()) == -1)
			fournisseurs.add(fournisseur);
	}

	@Override
	public String toString() {
		return "FournisseurDao{" + "fournisseurs=" + fournisseurs + '}';
	}

ArrayList<Fournisseur> fournisseurs;	
}
