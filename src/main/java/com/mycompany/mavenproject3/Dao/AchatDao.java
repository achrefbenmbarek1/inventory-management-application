/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Dao;

import com.mycompany.mavenproject3.dtos.Achat;
import com.mycompany.mavenproject3.IDao.IAchatDao;
import java.util.ArrayList;

/**
 *
 * @author eya
 */
public class AchatDao implements IAchatDao{
	private String jdcbUrl = "jdbc:mysql://localhost/database-_demo?useSSL=false";
	private String jdbcUserName="root";

	@Override
	public Boolean ajouter(Achat achat) {
		if(achats.indexOf(achat) == -1){
			achats.add(achat);
			return true;

		}
		return false;
	}

	@Override
	public String toString() {
		return "AchatDao{" + "achats=" + achats + '}';
	}

	ArrayList<Achat> achats = new ArrayList<>();
	
}
