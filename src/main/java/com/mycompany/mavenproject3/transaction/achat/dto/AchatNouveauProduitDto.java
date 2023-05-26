/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.achat.dto;

/**
 *
 * @author achref
 */
public class AchatNouveauProduitDto {
	private static final AchatNouveauProduitDto instance = new AchatNouveauProduitDto();
	private int idProduit;
	private String nomProduit;
	private float prix;
	private int quantite;
	private String designation;
	private int idFournisseur;
	private String nomFournisseur;
	private int idAchat;
	
	public static AchatNouveauProduitDto getInstance(){
		return instance;
	}
	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public int getIdAchat() {
		return idAchat;
	}

	public void setIdAchat(int idAchat) {
		this.idAchat = idAchat;
	}

}
