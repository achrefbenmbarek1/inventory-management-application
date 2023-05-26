/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.vente.exception;

/**
 *
 * @author achref
 */
public class StockNegatifException extends RuntimeException{

	public StockNegatifException(String message) {
		super(message);
	}

}
