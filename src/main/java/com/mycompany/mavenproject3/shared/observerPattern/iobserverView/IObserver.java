/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.shared.observerPattern.iobserverView;

import com.mycompany.mavenproject3.shared.observerPattern.iobservableModel.Subject;

/**
 *
 * @author achref
 * @param <ObservedType>
 */
public interface IObserver<ObservedType> {
	public void update(Subject<ObservedType>observable ,ObservedType data);
	
}
