/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.shared.dataAccessLayer.Dao;

import com.mycompany.mavenproject3.shared.dataAccessLayer.factory.FactoryConnection;
import com.mycompany.mavenproject3.shared.exceptions.daoException.AjoutException;
import com.mycompany.mavenproject3.shared.exceptions.daoException.RechercheException;
import com.mycompany.mavenproject3.shared.exceptions.daoException.SuppressionException;
import com.mycompany.mavenproject3.produit.model.entities.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.mavenproject3.shared.dataAccessLayer.IDao.IProduitDao;

/**
 *
 * @author eya
 */
public class ProduitDao implements IProduitDao{
	private static final String INSERT_PRODUIT = "insert into produit values (?,?,?,?,?);";
	private static final String SELECT_PRODUIT = "select * from produit where  idProduit = ?;";
	private static final String SELECT_PRODUIT_ALL = "select * from produit;";
	private static final String DELETE_PRODUIT = "DELETE FROM produit WHERE idProduit=?;";
	private static final String UPDATE_PRODUIT_NOM = "UPDATE produit set nom = ? where idProduit=?;";
	private static final String UPDATE_PRODUIT_PRIX = "UPDATE produit set prix = ? where idProduit=?;";
	private static final String UPDATE_PRODUIT_DESIGNATION = "UPDATE produit set designation = ? where idProduit=?;";
	private static final String UPDATE_PRODUIT_STOCK = "UPDATE produit set stock = ? where idProduit=?;";
	private FactoryConnection factoryConnection = new FactoryConnection();

	@Override
	public void supprimer(int id) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUIT)){
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			throw new SuppressionException("problème lors de la suppression", ex);
		}
	}

	@Override
	public Produit rechercher(int id) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUIT)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
			String nomProduit = resultSet.getString("nom");
			int idProduit = resultSet.getInt("idProduit");
			float prix = resultSet.getFloat("prix");
			String designation = resultSet.getString("designation");
			int stock =resultSet.getInt("stock");
			Produit produit = new Produit(nomProduit, idProduit, prix, designation, stock);
			return produit;
			}
			
		} catch (SQLException se) {
			throw new RechercheException("le produit n'existe pas", se);

		}
		return null;
	}

	@Override
	public void ajouter(Produit dto) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUIT)){
		preparedStatement.setString(1, dto.getNom());
		preparedStatement.setInt(2, dto.getIdProduit());
		preparedStatement.setFloat(3, dto.getPrix());
		preparedStatement.setString(4, dto.getDesignation());
		preparedStatement.setFloat(5,  dto.getStock());
		preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			throw new AjoutException("probléme lors de l'ajout du produit");
		
		}
	}

	@Override
	public List<Produit> afficherTout() {
		List<Produit> produits = new ArrayList<>();
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUIT_ALL)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
			String nomProduit = resultSet.getString("nom");
			int idProduit = resultSet.getInt("idProduit");
			float prix = resultSet.getFloat("prix");
			String designation = resultSet.getString("designation");
			int stock =resultSet.getInt("stock");
			Produit produit = new Produit(nomProduit, idProduit, prix, designation, stock);
			produits.add(produit);
			}
			
		} catch (SQLException se) {
			throw new RechercheException("le produit n'existe pas", se);

		}
		return produits;
	}

	@Override
	public void updateStock(int id, int quantite) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUIT_STOCK)){
		preparedStatement.setInt(1, quantite);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();

		} catch (SQLException se) {
			throw new AjoutException("probléme lors de l'ajout du produit");
		
		}

	}

	@Override
	public void updatePrix(int id, float prix) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUIT_PRIX)){
		preparedStatement.setFloat(1, prix);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();

		} catch (SQLException se) {
			throw new AjoutException("probléme lors de la mise a jours du prix");
		
		}
	}

	@Override
	public void updateNom(int id, String nom) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUIT_NOM)){
		preparedStatement.setString(1, nom);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();

		} catch (SQLException se) {
			throw new AjoutException("probléme lors de la mise a jour du nom");
		
		}
	}

	@Override
	public void updateDesignation(int id, String designation) {
		try(Connection connection = factoryConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUIT_DESIGNATION)){
		preparedStatement.setString(1, designation);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();

		} catch (SQLException se) {
			throw new AjoutException("probléme lors de l'ajout du produit");
		
		}
	}

}
