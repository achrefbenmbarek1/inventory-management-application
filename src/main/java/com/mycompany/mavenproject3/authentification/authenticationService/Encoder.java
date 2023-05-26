/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.authentification.authenticationService;

import java.util.Base64;

/**
 *
 * @author achref
 */
public class Encoder {
	private static Base64.Encoder encoder = Base64.getEncoder();
	private static Base64.Decoder decoder = Base64.getDecoder();

	public String encode(String text){
		try {
			return encoder.encodeToString(text.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String decode(String text){
		try {
			return new String(decoder.decode(text.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
