/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.shared.dataAccessLayer.IDao;

import com.mycompany.mavenproject3.produit.model.entities.Produit;
import java.util.List;

/**
 *
 * @author achref
 */
public interface IProduitDao {
	public void supprimer(int id);
	public Produit rechercher(int id);
	void ajouter(Produit produit);
	public List<Produit> afficherTout();
	public void updateStock(int id,int quantite);	
	public void updatePrix(int id, float prix);
	public void updateNom(int id, String nom);
	public void updateDesignation(int id, String designation);
}
