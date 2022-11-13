/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Dao;

import com.mycompany.mavenproject3.IDao.IVenteDao;
import com.mycompany.mavenproject3.dtos.Vente;
import java.util.ArrayList;

/**
 *
 * @author eya
 */
public class VenteDao implements IVenteDao{

	@Override
	public Boolean ajouter(Vente vente) {
		if(ventes.indexOf(vente) == -1){
			ventes.add(vente);
			return true;

		}
		return false;

	}

	@Override
	public String toString() {
		return "VenteDao{" + "ventes=" + ventes + '}';
	}
	
	ArrayList<Vente>ventes = new ArrayList<>();
}
