/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.model.modelA;

import com.mycompany.mavenproject3.IDao.IAchatDao;
import com.mycompany.mavenproject3.dtos.Achat;

/**
 *
 * @author achref
 */
public class AchatModel implements IAchatDao{

	@Override
	public Boolean ajouter(Achat achat) {
		return iAchatDao.ajouter(achat);

	}

	public AchatModel(IAchatDao iAchatDao) {
		this.iAchatDao = iAchatDao;
	}

	@Override
	public String toString() {
		return "AchatModel{" + "iAchatDao=" + iAchatDao + '}';
	}

IAchatDao iAchatDao;  
}
