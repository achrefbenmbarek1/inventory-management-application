/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.shared.iinteractor;

import java.util.List;

/**
 *
 * @author achref
 */
public interface Iinteractor<T> {
	/**
	 *
	 * @param id
	 */
	public void supprimer(int id);

	/**
	 *
	 * @param id
	 * @return
	 */
	public T rechercher(int id);

	/**
	 *
	 * @param dto
	 * 
	 */
	void ajouter(T dto);

	/**
	 *
	 * @return
	 */
	public List<T> afficherTout();
	
}
