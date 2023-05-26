/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.vente.controller;

/**
 *
 * @author achref
 */

import com.mycompany.mavenproject3.App;
import com.mycompany.mavenproject3.shared.view.DialogCreator;
import com.mycompany.mavenproject3.transaction.interactor.ITransactionInteractor;
import com.mycompany.mavenproject3.transaction.vente.dto.NouvelleVenteDto;
import com.mycompany.mavenproject3.transaction.vente.model.entity.Vente;
import com.mycompany.mavenproject3.transaction.vente.view.VenteItem;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent ;
import javafx.fxml.FXML ;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button ;
import javafx.scene.control.Hyperlink ;
import javafx.scene.control.TableColumn ;
import javafx.scene.control.TableView ;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class VenteController implements Initializable{

		@FXML
		private TableColumn<VenteItem, Date> dateVente;

		@FXML
		private Hyperlink StatistiquesNavIemProduit;

		@FXML
		private Button achatNouveauProduit;

		@FXML
		private Hyperlink achatsNavItemProduit;

		@FXML
		private Hyperlink clientsNavItemsProduit;

		@FXML
		private Hyperlink fournisseursNavItemProduit;

		@FXML
		private TableColumn<VenteItem, Integer> idVente;

		@FXML
		private TableColumn<VenteItem, Integer> idClient;

		@FXML
		private TableColumn<VenteItem, Integer> idProduit;

		@FXML
		private Button venteProduit;

		@FXML
		private TableColumn<VenteItem, Button> modierColomn;

		@FXML
		private TableColumn<VenteItem, Button> annulerColomn;

		@FXML
		private Hyperlink produitsNavItemProduit;

		@FXML
		private TableColumn<VenteItem, Integer> quantite;

		@FXML
		private TableView<VenteItem> tableVIew;

		@FXML
		private Hyperlink ventesNavItemProduit;

		@FXML
		private TextField searchBox;

		ITransactionInteractor<Vente,NouvelleVenteDto> venteInteractor;

		private ObservableList<VenteItem> data = FXCollections.observableArrayList();

		public VenteController(ITransactionInteractor<Vente, NouvelleVenteDto> venteInteractor) {
			this.venteInteractor = venteInteractor;
		}

		@FXML
		void goToAchat(ActionEvent event) {
			try {
				App.setRoot("achat");
			} catch (IOException ex) {
				Logger.getLogger(VenteController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		@FXML
		void goToProduit(ActionEvent event) {
			try {
				App.setRoot("produit");
			} catch (IOException ex) {
				Logger.getLogger(VenteController.class.getName()).log(Level.SEVERE, null, ex);
			}

		}

		@FXML
	void vendreProduit(ActionEvent event) {
		FXMLLoader fXMLLoader = new FXMLLoader(App.class.getResource("ajouterVente.fxml"));
		fXMLLoader.setControllerFactory(new Callback<Class<?>, Object>(){
			@Override
			public Object call(Class<?> param) {
				return new NouvelleVenteDialog();
			}
		});
		DialogCreator.createDialog(fXMLLoader);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		for(Vente vente:venteInteractor.afficherTout()){
			VenteItem venteItem = new VenteItem(vente.getIdVente(),vente.getIdProduit(),vente.getIdClient(),vente.getQuantiteVendu(),vente.getDateV(), new Button("modifierAchat"),new Button("annulerAchat"));
			data.add(venteItem);
		}
		for(VenteItem venteItem:data){
			venteItem.getModifierVente().setOnAction(this::handleButtonActionModifier);
			venteItem.getAnnulerVente().setOnAction(this::handleButtonActionAnnuler);
		}

		idProduit.setCellValueFactory(new PropertyValueFactory<VenteItem,Integer>("idProduit"));
		idVente.setCellValueFactory(new PropertyValueFactory<VenteItem,Integer>("idVente"));
		idClient.setCellValueFactory(new PropertyValueFactory<VenteItem,Integer>("idClient"));
		quantite.setCellValueFactory(new PropertyValueFactory<VenteItem,Integer>("quantiteVendu"));
		dateVente.setCellValueFactory(new PropertyValueFactory<VenteItem,Date>("dateVente"));
		annulerColomn.setCellValueFactory(new PropertyValueFactory<VenteItem,Button>("annulerVente"));
		modierColomn.setCellValueFactory(new PropertyValueFactory<VenteItem,Button>("modifierVente"));
		tableVIew.setItems(data);
		FilteredList<VenteItem>filteredListItem = new FilteredList<>(data,b->true);
		searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredListItem.setPredicate((t) -> {
			if(newValue == null || newValue.isEmpty())
				return true;
			String lowerCaseFilter = newValue.toLowerCase();
			if(String.valueOf(t.getIdVente()).indexOf(lowerCaseFilter)!=-1)
				return true;
				
			else
				return false;
			});
		});
		SortedList<VenteItem> sortedData = new SortedList<>(filteredListItem);
		sortedData.comparatorProperty().bind(tableVIew.comparatorProperty());
		tableVIew.setItems(sortedData);
		
	}

	private void handleButtonActionModifier(ActionEvent event) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	private void handleButtonActionAnnuler(ActionEvent event) {
		venteInteractor.supprimer(data.filtered((venteItem) -> venteItem.getAnnulerVente()== event.getSource()).get(0).getIdVente());
		data.remove(data.filtered((venteItem) -> venteItem.getAnnulerVente()== event.getSource()).get(0));
		tableVIew.refresh();
	}

}
