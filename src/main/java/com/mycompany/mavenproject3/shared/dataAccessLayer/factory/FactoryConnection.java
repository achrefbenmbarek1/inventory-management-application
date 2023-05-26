/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.shared.dataAccessLayer.factory;

import com.mycompany.mavenproject3.shared.exceptions.daoException.ConnectionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author achref
 */
public class FactoryConnection {
	private final String jdbcUrl = "jdbc:mysql://localhost:3306/database_demo?zeroDateTimeBehavior=CONVERT_TO_NULL";
	private final String jdbcUserName="root";
	
	public Connection getConnection(){
		Connection connection = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcUrl,jdbcUserName,"");
		} catch (ClassNotFoundException cnfe) {
			Logger.getLogger(FactoryConnection.class.getName()).log(Level.SEVERE, null, cnfe);
			//catch this exception in the controller don't forget !!!
			throw new ConnectionException("couldn't connect to the database",cnfe);
		} catch (SQLException ex) {
			throw new ConnectionException("couldn't connect to the database",ex);
		}
		return connection;
		
	}
	
}
