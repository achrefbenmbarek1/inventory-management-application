/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.shared.dataAccessLayer.Dao;

import com.mycompany.mavenproject3.shared.dataAccessLayer.IDao.IDao;
import com.mycompany.mavenproject3.shared.dataAccessLayer.factory.FactoryConnection;
import com.mycompany.mavenproject3.shared.exceptions.daoException.RechercheException;
import com.mycompany.mavenproject3.shared.exceptions.daoException.SuppressionException;
import com.mycompany.mavenproject3.transaction.vente.model.entity.Vente;
import com.mycompany.mavenproject3.shared.observerPattern.iobservableModel.Subject;
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
public class VenteDao extends Subject implements IDao<Vente> {

	private static final String INSERT_vente = "insert into vente values (?,?,?,?,?);";
	private static final String SELECT_vente = "select * from vente where  idVente = ?;";
	private static final String SELECT_vente_ALL = "select * from vente;";
	private static final String DELETE_vente = "DELETE FROM vente WHERE idVente=?;";
	private FactoryConnection factoryConnection = new FactoryConnection();

	@Override
	public void ajouter(Vente vente) {
		try ( Connection connection = factoryConnection.getConnection();  
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_vente)) {
			preparedStatement.setInt(1, vente.getIdVente());
			preparedStatement.setInt(2, vente.getIdProduit());
			preparedStatement.setInt(3, vente.getIdClient());
			preparedStatement.setInt(4, vente.getQuantiteVendu());
			preparedStatement.setDate(5, vente.getDateV());
			preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(VenteDao.class.getName()).log(Level.SEVERE, null, ex);

		}

	}

	@Override
	public void supprimer(int id) {
		try ( Connection connection = factoryConnection.getConnection();  
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_vente)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			throw new SuppressionException("problème lors de la suppression", ex);
		}
	}

	@Override
	public Vente rechercher(int id) {
		try ( Connection connection = factoryConnection.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_vente)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int idVente = resultSet.getInt("idVente");
				Date dateV = resultSet.getDate("date");
				int quantite = resultSet.getInt("quantie");
				int idProduit = resultSet.getInt("idProduit");
				int idClient = resultSet.getInt("idClient");
				Vente vente = new Vente(idVente, idProduit,idClient, quantite, dateV);
				return vente;
			}

		} catch (SQLException se) {
			throw new RechercheException("la vente n'existe pas", se);

		}
		return null;

	}

	@Override
	public List<Vente> afficherTout() {
		List<Vente> ventes = new ArrayList<>();
		try ( Connection connection = factoryConnection.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_vente_ALL)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				int idVente = resultSet.getInt("idVente");
				Date dateV = resultSet.getDate("date");
				int quantite = resultSet.getInt("quantie");
				int idProduit = resultSet.getInt("idProduit");
				int idClient = resultSet.getInt("idClient");
				Vente vente = new Vente(idVente, idProduit,idClient, quantite, dateV);
				ventes.add(vente);

			}

		} catch (SQLException se) {
			throw new RechercheException("la vente n'existe pas", se);

		}
		return ventes;

}
}
