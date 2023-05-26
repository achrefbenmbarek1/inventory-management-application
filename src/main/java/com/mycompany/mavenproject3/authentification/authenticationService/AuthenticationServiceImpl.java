/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.authentification.authenticationService;

import com.mycompany.mavenproject3.shared.dataAccessLayer.IDao.IAdministratorDao;
import com.mycompany.mavenproject3.authentification.valueObject.Administrateur;
import com.mycompany.mavenproject3.shared.exceptions.daoException.RechercheException;


public class AuthenticationServiceImpl implements AuthenticationService {
	IAdministratorDao administrateurDao;	

	public AuthenticationServiceImpl(IAdministratorDao administrateurDao) {
		this.administrateurDao = administrateurDao;
	}
	@Override
	public void signIn(String email ,String password) {
		Administrateur administrateur = new Administrateur(email, password);
		Administrateur administrateurCourant = administrateurDao.rechercher(email, password);
		if(administrateurCourant == null)
			 throw new RechercheException("le compte n'existe pas");

	}

}
