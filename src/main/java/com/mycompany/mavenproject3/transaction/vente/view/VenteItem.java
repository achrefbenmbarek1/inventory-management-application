/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.vente.view;

import java.sql.Date;
import javafx.scene.control.Button;

/**
 *
 * @author achref
 */
public class VenteItem {
	private int idVente; 
	private int idProduit; 
	private int idClient;
	private int quantiteVendu; 
	private Date dateVente; 
	private Button modifierVente;
	private Button annulerVente;

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Date getDateVente() {
		return dateVente;
	}

	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}

	public int getIdVente() {
		return idVente;
	}

	public VenteItem(int idVente, int idProduit,int idClient, int quantiteVendu, Date dateVente, Button modifierVente, Button annulerVente) {
		this.idVente = idVente;
		this.idProduit = idProduit;
		this.idClient = idClient;
		this.quantiteVendu = quantiteVendu;
		this.dateVente = dateVente;
		this.modifierVente = modifierVente;
		this.annulerVente = annulerVente;
	}

	public void setIdVente(int idVente) {
		this.idVente = idVente;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getQuantiteVendu() {
		return quantiteVendu;
	}

	public void setQuantiteVendu(int quantiteVendu) {
		this.quantiteVendu = quantiteVendu;
	}

	public Date getDateV() {
		return dateVente;
	}

	public void setDateV(Date dateVente) {
		this.dateVente = dateVente;
	}

	public Button getModifierVente() {
		return modifierVente;
	}

	public void setModifierVente(Button modifierVente) {
		this.modifierVente = modifierVente;
	}


	public Button getAnnulerVente() {
		return annulerVente;
	}

	public void setAnnulerVente(Button annulerVente) {
		this.annulerVente = annulerVente;
	}
}
