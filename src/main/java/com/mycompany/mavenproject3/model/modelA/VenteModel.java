/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.model.modelA;

import com.mycompany.mavenproject3.dtos.Vente;
import com.mycompany.mavenproject3.IDao.IVenteDao;

/**
 *
 * @author achref
 */
public class VenteModel implements IVenteDao{

	@Override
	public Boolean ajouter(Vente vente) {
		return iventeDao.ajouter(vente);
	}
	

	public VenteModel(IVenteDao iventeDao) {
		this.iventeDao = iventeDao;
	}

	@Override
	public String toString() {
		return "VenteModel{" + "iventeDao=" + iventeDao + '}';
	}

	IVenteDao iventeDao;
}
