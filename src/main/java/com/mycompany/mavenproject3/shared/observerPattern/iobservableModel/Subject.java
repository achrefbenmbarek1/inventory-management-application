/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.shared.observerPattern.iobservableModel;

import com.mycompany.mavenproject3.shared.observerPattern.iobserverView.IObserver;
import java.util.List;

/**
 *
 * @author achref
 * @param <ObservedType>
 */
public class Subject<ObservedType>  {
	private List<IObserver<ObservedType>> observers; 
	public void addObserver(IObserver observer){
		this.observers.add(observer);
	}
	public void removeObserver(IObserver<ObservedType> observer){
		this.observers.remove(observer);
	}
	public void notifyObserver(ObservedType data){
		for (IObserver<ObservedType> observer : observers) {
			observer.update(this ,data);
		}
	}
	
}
