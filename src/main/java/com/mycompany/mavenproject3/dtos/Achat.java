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
public record Achat(int idProduit, int idFr, int quantite, Date dateA) {

	public Achat(int idProduit, int idFr, int quantite, Date dateA) {
		this.idProduit = idProduit;
		this.idFr = idFr;
		this.quantite = quantite;
		this.dateA = dateA;
	}

}
