/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.achat.model.entities;

import java.io.Serializable;
import java.sql.Date;


/**
 *
 * @author eya
 */
public class Achat implements Serializable{
	private int idAchat;
	private int idProduit;
	private int idFr;
	private int quantite;
	private Date dateAchat;

	public Achat(int idAchat, int idProduit, int idFr, int quantite, Date dateAchat) {
		this.idAchat = idAchat;
		this.idProduit = idProduit;
		this.idFr = idFr;
		this.quantite = quantite;
		this.dateAchat = dateAchat;
	}

	public int getIdAchat() {
		return idAchat;
	}

	public void setIdAchat(int idAchat) {
		this.idAchat = idAchat;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getIdFr() {
		return idFr;
	}

	public void setIdFr(int idFr) {
		this.idFr = idFr;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}


}
