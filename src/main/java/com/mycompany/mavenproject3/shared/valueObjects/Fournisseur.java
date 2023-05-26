/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.mavenproject3.shared.valueObjects;

import java.io.Serializable;

/**
 *
 * @author eya
 */
public record Fournisseur(String nom, int idFr) implements Serializable {

	public Fournisseur {
		if (nom.length() == 0 )
			throw new IllegalArgumentException("please write a valid name");
	}


}

