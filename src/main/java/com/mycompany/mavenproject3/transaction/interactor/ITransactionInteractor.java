/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.interactor;

import java.util.List;

/**
 *
 * @author achref
 * @param <T>
 */
public interface ITransactionInteractor<T,D> {
	
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
	void ajouter(D dto);

	/**
	 *
	 * @return
	 */
	public List<T> afficherTout();

	public void modiferQuantie(int id ,int quantite);
}
