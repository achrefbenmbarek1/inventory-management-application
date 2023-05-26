/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.shared.dto;

import javafx.scene.control.Button;

/**
 *
 * @author achref
 */
public class ButtonsDto {
	private Button modifier;
	private Button annuler;
	private static final ButtonsDto instance = new ButtonsDto();
 	
	private ButtonsDto() {
	}
	public static ButtonsDto getInstance(){
		return instance;
	}
	public Button getModifier() {
		return modifier;
	}

	public void setModifier(Button modifier) {
		this.modifier = modifier;
	}

	public Button getAnnuler() {
		return annuler;
	}

	public void setAnnuler(Button annuler) {
		this.annuler = annuler;
	}
	
}
