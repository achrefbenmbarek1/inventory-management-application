/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.shared.dataAccessLayer.Dao;

import com.mycompany.mavenproject3.shared.dataAccessLayer.IDao.IDao;
import com.mycompany.mavenproject3.shared.dataAccessLayer.factory.FactoryConnection;
import com.mycompany.mavenproject3.shared.exceptions.daoException.AjoutException;
import com.mycompany.mavenproject3.shared.exceptions.daoException.RechercheException;
import com.mycompany.mavenproject3.shared.exceptions.daoException.SuppressionException;
import com.mycompany.mavenproject3.shared.valueObjects.Fournisseur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eya
 */
public class FournisseurDao implements IDao<Fournisseur>{
	private static final String INSERT_FOURNISSEUR = "insert into fournisseur values (?,?);";
	private static final String SELECT_FOURNISSEUR = "select * from fournisseur where idFr = ? ;";
	private static final String SELECT_FOURNISSEUR_ALL = "select * from fournisseur;";
	private static final String DELETE_FOURNISSEUR = "DELETE FROM fournisseur WHERE idFr=?;";
	private FactoryConnection factoryConnection = new FactoryConnection();

	@Override
	public void supprimer(int id) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FOURNISSEUR)){
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			throw new SuppressionException("problème lors de la suppression", ex);
		}
	}

	@Override
	public Fournisseur rechercher(int id) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FOURNISSEUR)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
			int idFr = resultSet.getInt("idAchat");
			String nomFournisseur = resultSet.getString("nom");
			Fournisseur fournisseur = new Fournisseur(nomFournisseur ,idFr);
			return fournisseur;
			}
			
		} catch (SQLException se) {
			throw new RechercheException("le fournisseur n'existe pas", se);

		}
		return null;
	}

	@Override
	public void ajouter(Fournisseur dto) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FOURNISSEUR)){
		preparedStatement.setInt(1, dto.idFr());
		preparedStatement.setString(2, dto.nom());
		preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			throw new AjoutException("probléme lors de l'ajout");
		}
	}

	@Override
	public List<Fournisseur> afficherTout() {
		List<Fournisseur> fournisseurs = new ArrayList<>();
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FOURNISSEUR_ALL)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
			int idFr = resultSet.getInt("idFr");
			String nomFournisseur =resultSet.getString("nom");
			Fournisseur fournisseur = new Fournisseur(nomFournisseur,idFr);
			fournisseurs.add(fournisseur);
			}
			
		} catch (SQLException se) {
			throw new RechercheException("l'achat n'existe pas", se);

		}
		return fournisseurs;
	}


}
