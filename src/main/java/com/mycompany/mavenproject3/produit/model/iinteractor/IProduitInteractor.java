/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.produit.model.iinteractor;

import com.mycompany.mavenproject3.produit.model.entities.Produit;
import java.util.List;

/**
 *
 * @author achref
 */
public interface IProduitInteractor {
	public void supprimer(int id);
	public void modifier(Produit produit);
	public List<Produit> afficherTout(); 

}
