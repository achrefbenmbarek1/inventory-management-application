/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.mavenproject3.authentification.valueObject;

import com.mycompany.mavenproject3.shared.exceptions.authentificationException.InvalidEmailException;
import com.mycompany.mavenproject3.shared.exceptions.authentificationException.InvalidPasswordException;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author eya
 */
public record Administrateur(String email, String motsDePasse) implements Serializable {

	public Administrateur {
		
		Pattern pattern = Pattern.compile("^[A-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[A-Z0-9_!#$%&'*+/=?`{|}~^-]+↵\n"
			+ ")*@[A-Z0-9-]+(?:\\.[A-Z0-9-]+)*$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		if(!matcher.find())
			throw new InvalidEmailException("invalid email");
	
	 pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
	 matcher = pattern.matcher(motsDePasse);
	 if(!matcher.find())
		 throw new InvalidPasswordException("invalid passord");
	}
}
