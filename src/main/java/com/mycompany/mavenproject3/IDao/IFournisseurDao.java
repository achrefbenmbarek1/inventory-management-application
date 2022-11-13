/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.IDao;

import com.mycompany.mavenproject3.dtos.Fournisseur;

/**
 *
 * @author achref
 */
public interface IFournisseurDao {
	public void supprimer(int id);
	public int rechercher(int id);
	void ajouter(Fournisseur fournisseur);
}
