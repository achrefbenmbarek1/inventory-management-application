/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.vente.model.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author eya
 */
public class Vente implements Serializable{
	private int idVente; 
	private int idProduit; 
	private int idClient;
	private int quantiteVendu; 
	private Date dateVente; 

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

	public Vente(int idVente, int idProduit,int idClient, int quantiteVendu, Date dateVente) {
		this.idVente = idVente;
		this.idProduit = idProduit;
		this.idClient = idClient;
		this.quantiteVendu = quantiteVendu;
		this.dateVente = dateVente;
	}

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
		return dateVente;
	}

	public void setDateV(Date dateV) {
		this.dateVente = dateVente;
	}

	
}
