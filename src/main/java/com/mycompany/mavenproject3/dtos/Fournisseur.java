/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.mavenproject3.dtos;

import java.util.ArrayList;

/**
 *
 * @author eya
 */
public record Fournisseur(String nom, int idFr) {

	public Fournisseur(String nom, int idFr) {
		if (nom.length() == 0 )
			throw new IllegalArgumentException("please write a valid name");
		this.nom = nom;
		this.idFr = idFr;
	}

	public int getIdFr() {
		return idFr;
	}

}

