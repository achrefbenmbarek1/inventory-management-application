/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.achat.view;

import java.sql.Date;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author achref
 */
public class AchatItem {
	private int idAchat;
	private int idProduit;
	private int idFr;
	private int quantite;
	private Date dateAchat;
	private Button annulerAchat;
	private Button modifierAchat;

	public AchatItem() {
	}

	public AchatItem(int idAchat, int idProduit, int idFr, int quantite, Date dateAchat, Button annulerAchat,Button modifierAchat) {
		this.idAchat = idAchat;
		this.idProduit = idProduit;
		this.idFr = idFr;
		this.quantite = quantite;
		this.dateAchat = dateAchat;
		this.annulerAchat = annulerAchat;
		this.modifierAchat = modifierAchat;
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

	public Button getAnnulerAchat() {
		return annulerAchat;
	}

	public void setAnnulerAchat(Button annulerAchat) {
		this.annulerAchat = annulerAchat;
	}

	public Button getModifierAchat() {
		return modifierAchat;
	}

	public void setModifierAchat(Button modifierAchat) {
		this.modifierAchat = modifierAchat;
	}


	
}
