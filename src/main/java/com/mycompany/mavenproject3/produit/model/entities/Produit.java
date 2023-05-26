/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.produit.model.entities;

import com.mycompany.mavenproject3.transaction.vente.exception.StockNegatifException;
import java.io.Serializable;


/**
 *
 * @author eya
 */
public class Produit implements Serializable{
	private String nom;
	private int idProduit;
	private float prix;
	private String designation;
	private int stock;

	public Produit() {
	}

	public Produit(int idProduit, String nom, float prix, String designation) {
		this.idProduit = idProduit;
		this.nom = nom;
		this.prix = prix;
		this.designation = designation;
	}
	

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Produit(String nom, int idProduit, float prix, String designation, int stock) {
		this.nom = nom;
		this.idProduit = idProduit;
		this.prix = prix;
		this.designation = designation;
		if(stock < 0)
			throw new StockNegatifException("la quantite de stock donner est negatif");
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public String getNom() {
		return nom;
	}

	public String getDesignation() {
		return designation;
	}

	public void setStock(int stock) {
		if(stock < 0)
			throw new StockNegatifException("le stock donner est negatif impossible !!!");
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Produit{" + "nom=" + nom + ", idProduit=" + idProduit + ", prix=" + prix + ", designation=" + designation + ", stock=" + stock + '}';
	}

	public int getIdProduit() {
		return idProduit;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 97 * hash + this.idProduit;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Produit other = (Produit) obj;
		return this.idProduit == other.idProduit;
	}

	
}
