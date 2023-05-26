/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.vente.dto;

import java.sql.Date;

/**
 *
 * @author achref
 */
public class NouvelleVenteDto {
	
	private int idVente; 
	private int idProduit; 
	private int idClient;

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	private int quantiteVendu; 
	private Date dateV; 

	public int getIdVente() {
		return idVente;
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
		return dateV;
	}

	public void setDateV(Date dateV) {
		this.dateV = dateV;
	}

	
}
