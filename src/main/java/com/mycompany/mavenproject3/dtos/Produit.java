/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.dtos;


/**
 *
 * @author eya
 */
public class Produit {
	private String nom;
	private int idProduit;
	private int prix;
	private String designation;
	private int stock;

	public Produit(String nom, int idProduit, int prix, String designation, int stock) {
		this.nom = nom;
		this.idProduit = idProduit;
		this.prix = prix;
		this.designation = designation;
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Produit{" + "nom=" + nom + ", idProduit=" + idProduit + ", prix=" + prix + ", designation=" + designation + ", stock=" + stock + '}';
	}

	public int getIdProduit() {
		return idProduit;
	}

	
}
