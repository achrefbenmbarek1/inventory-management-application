/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.mavenproject3.dtos;

import java.util.Date;

/**
 *
 * @author eya
 */
public record Vente(int idVente, int idProduit, int quantiteVendu, Date dateV) {

	public Vente(int idVente, int idProduit, int quantiteVendu, Date dateV) {
		this.idVente = idVente;
		this.idProduit = idProduit;
		this.quantiteVendu = quantiteVendu;
		this.dateV = dateV;
	}

}
