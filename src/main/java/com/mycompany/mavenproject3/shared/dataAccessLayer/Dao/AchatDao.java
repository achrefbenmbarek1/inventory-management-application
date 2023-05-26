/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.shared.dataAccessLayer.Dao;

import com.mycompany.mavenproject3.transaction.achat.model.entities.Achat;
import com.mycompany.mavenproject3.shared.dataAccessLayer.IDao.IDao;
import com.mycompany.mavenproject3.shared.exceptions.daoException.RechercheException;
import com.mycompany.mavenproject3.shared.exceptions.daoException.SuppressionException;
import com.mycompany.mavenproject3.shared.dataAccessLayer.factory.FactoryConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eya
 */
public class AchatDao implements IDao<Achat>{
	private static final String INSERT_ACHAT = "insert into achat values (?,?,?,?,?);";
	private static final String SELECT_ACHAT = "select * from achat where  idAchat = ?;";
	private static final String SELECT_ACHAT_ALL = "select * from achat;";
	private static final String DELETE_ACHAT = "DELETE FROM achat WHERE idAchat=?;";
	private FactoryConnection factoryConnection = new FactoryConnection();


	@Override
	public void ajouter(Achat achat) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACHAT)){
		preparedStatement.setInt(1, achat.getIdAchat());
		preparedStatement.setInt(2, achat.getIdProduit());
		preparedStatement.setInt(3, achat.getIdFr());
		preparedStatement.setInt(4, achat.getQuantite());
		preparedStatement.setDate(5,  achat.getDateAchat());
		preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(AchatDao.class.getName()).log(Level.SEVERE, null, ex);
		
		}

	}

	@Override
	public void supprimer(int id) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACHAT)){
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			throw new SuppressionException("problème lors de la suppression", ex);
		}
	}

	@Override
	public Achat rechercher(int id) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACHAT)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
			int idAchat = resultSet.getInt("idAchat");
			int idProduit = resultSet.getInt("idProduit");
			int idFr = resultSet.getInt("idFr");
			int quantite =resultSet.getInt("quantite");
			Date dateAchat =resultSet.getDate("dateAchat");	
			Achat achat = new Achat(idAchat, idProduit, idFr, quantite, dateAchat);
			return achat;
			}
			
		} catch (SQLException se) {
			throw new RechercheException("l'achat n'existe pas", se);

		}
		return null;
       
	}
	
	@Override
	public List<Achat> afficherTout() {
		List<Achat> achats = new ArrayList<>();
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACHAT_ALL)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
			int idAchat = resultSet.getInt("idAchat");
			int idProduit = resultSet.getInt("idProduit");
			int idFr = resultSet.getInt("idFr");
			int quantite =resultSet.getInt("quantite");
			Date dateAchat =resultSet.getDate("dateAchat");	
			Achat achat = new Achat(idAchat, idProduit, idFr, quantite, dateAchat);
			achats.add(achat);
			}
			
		} catch (SQLException se) {
			throw new RechercheException("l'achat n'existe pas", se);

		}
		return achats;
       
	}
}
