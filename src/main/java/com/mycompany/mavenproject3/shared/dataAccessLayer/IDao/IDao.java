/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.shared.dataAccessLayer.IDao;

import java.util.List;

/**
 *
 * @author achref
 * @param <T>
 */
public interface IDao<T> {
	
	public void supprimer(int id);
	public T rechercher(int id);
	void ajouter(T dto);
	public List<T> afficherTout();
}
