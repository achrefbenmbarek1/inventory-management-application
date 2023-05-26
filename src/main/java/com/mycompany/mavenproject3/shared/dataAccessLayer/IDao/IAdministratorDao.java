/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.shared.dataAccessLayer.IDao;

import com.mycompany.mavenproject3.authentification.valueObject.Administrateur;

/**
 *
 * @author achref
 */
public interface IAdministratorDao {
	public Administrateur rechercher(String email,String password);
}
