/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.shared.dataAccessLayer.Dao;

import com.mycompany.mavenproject3.authentification.valueObject.Administrateur;
import com.mycompany.mavenproject3.shared.dataAccessLayer.IDao.IAdministratorDao;
import com.mycompany.mavenproject3.shared.dataAccessLayer.factory.FactoryConnection;
import com.mycompany.mavenproject3.shared.exceptions.daoException.RechercheException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author achref
 */
public class AdministrateurDao implements IAdministratorDao{


	private static final String SELECT_ADMINISTRATEUR = "select * from administrateur where  email = ? and password = ?;";
	private FactoryConnection factoryConnection = new FactoryConnection();

	@Override
	public Administrateur rechercher(String email,String password) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMINISTRATEUR)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {				
				String emailResult = resultSet.getString("email");
				String passwordResult = resultSet.getString("password");
				Administrateur administrateur = new Administrateur(emailResult, passwordResult);
				return administrateur;
			}

			
		} catch (SQLException se) {
			throw new RechercheException("vous n'êtes pas inscrits", se);

		}
		return null;
	}

	
}
