/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.IDao;

import com.mycompany.mavenproject3.dtos.Produit;

/**
 *
 * @author achref
 */
public interface IProduitDao {
	void supprimer(int id);
	int rechercher(int id);
	void ajouter(Produit produit);
	void mettreAjrsStock(int variation ,int indice);

}
