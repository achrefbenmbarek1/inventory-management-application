/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.produit.view;

import javafx.scene.control.Button;

/**
 *
 * @author achref
 */
public class ProduitItem {
	private String nom;
	private int idProduit;
	private float prix;
	private String designation;
	private int stock;
	private Button modificationBtn;

	public ProduitItem(String nom, int idProduit, float prix, String designation, int stock, Button modificationBtn) {
		this.nom = nom;
		this.idProduit = idProduit;
		this.prix = prix;
		this.designation = designation;
		this.stock = stock;
		this.modificationBtn = modificationBtn;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public Button getModificationBtn() {
		return modificationBtn;
	}

	public void setModificationBtn(Button modificationBtn) {
		this.modificationBtn = modificationBtn;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


}
