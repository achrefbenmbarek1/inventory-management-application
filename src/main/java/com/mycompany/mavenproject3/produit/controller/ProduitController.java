package com.mycompany.mavenproject3.produit.controller;

import com.mycompany.mavenproject3.App;
import com.mycompany.mavenproject3.produit.model.entities.Produit;
import com.mycompany.mavenproject3.produit.model.iinteractor.IProduitInteractor;
import com.mycompany.mavenproject3.produit.view.ProduitItem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import com.mycompany.mavenproject3.transaction.achat.dto.AchatNouveauProduitDto;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import com.mycompany.mavenproject3.shared.callback.view.TableViewModifyAndRefresh;
import com.mycompany.mavenproject3.shared.view.DialogCreator;

public class ProduitController implements Initializable,TableViewModifyAndRefresh<ProduitItem>{
	@FXML
	private Hyperlink StatistiquesNavIemProduit;

	@FXML
	private Hyperlink achatsNavItemProduit;

	@FXML
	private Hyperlink clientsNavItemsProduit;

	@FXML
	private TableColumn<ProduitItem, String> designationProduit;

	@FXML
	private Hyperlink fournisseursNavItemProduit;

	@FXML
	private TableColumn<ProduitItem, Integer> idProduit;

	@FXML
	private TableColumn<ProduitItem, String> nomProduit;

	@FXML
	private TableColumn<ProduitItem, Float> prix;

	@FXML
	private Hyperlink produitsNavItemProduit;

	@FXML
	private TableColumn<ProduitItem, Integer> stockProduit;

	@FXML
	private TableView<ProduitItem> tableVIew;
	@FXML
	private TableColumn<ProduitItem, Button> ajoutProduit;

	@FXML
	private Hyperlink ventesNavItemProduit;

	IProduitInteractor produitInteractor;
	private ObservableList<ProduitItem> data = FXCollections.observableArrayList();


	public ProduitController(IProduitInteractor produitInteractor) {
		this.produitInteractor = produitInteractor;
	}

	@FXML
	void goToAchat(ActionEvent event) {
		try {
			App.setRoot("achat");
		} catch (IOException ex) {
			Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	void goToProduit(ActionEvent event) {
		try {
			App.setRoot("produit");
		} catch (IOException ex) {
			Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	@FXML
	void goToVente(ActionEvent event) {
		try {
			App.setRoot("vente");
		} catch (IOException ex) {
			Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		for(Produit produit:produitInteractor.afficherTout()){
			ProduitItem produitItem = new ProduitItem(produit.getNom(), produit.getIdProduit(), produit.getPrix(), produit.getDesignation(), produit.getStock(), new Button("modifier"));
			data.add(produitItem);
		}
		for(ProduitItem produitItem:data){
			produitItem.getModificationBtn().setOnAction(this::handleButtonActionModifier);
			produitItem.getModificationBtn().setStyle("-fx-background-color: #1BA531");

		}
		idProduit.setCellValueFactory(new PropertyValueFactory<ProduitItem,Integer>("idProduit"));
		nomProduit.setCellValueFactory(new PropertyValueFactory<ProduitItem,String>("nom"));
		prix.setCellValueFactory(new PropertyValueFactory<ProduitItem,Float>("prix"));
		designationProduit.setCellValueFactory(new PropertyValueFactory<ProduitItem,String>("designation"));
		stockProduit.setCellValueFactory(new PropertyValueFactory<ProduitItem,Integer>("stock"));
		ajoutProduit.setCellValueFactory(new PropertyValueFactory<ProduitItem,Button>("modificationBtn"));
		tableVIew.setItems(data);
	}


	private void handleButtonActionModifier(ActionEvent event) {
		AchatNouveauProduitDto achatNouveauProduitDto = AchatNouveauProduitDto.getInstance();
		ProduitItem produitItem = data.filtered((t) -> t.getModificationBtn()== event.getSource()).get(0);
		achatNouveauProduitDto.setIdProduit(produitItem.getIdProduit());
		achatNouveauProduitDto.setPrix(produitItem.getPrix());
		achatNouveauProduitDto.setNomProduit(produitItem.getNom());
		achatNouveauProduitDto.setDesignation(produitItem.getDesignation());
		FXMLLoader fXMLLoader = new FXMLLoader(App.class.getResource("augmenterLaQuantiteDuProduit.fxml"));
		fXMLLoader.setControllerFactory((Class<?> param) -> new AugmenterQuantiteProduitController(ProduitController.this,produitInteractor));
		DialogCreator.createDialog(fXMLLoader);
	}

	@Override
	public void modifyAndRefresh(ProduitItem item) {
		  data.filtered((oldItem) -> oldItem.getIdProduit() == item.getIdProduit()).get(0).setDesignation(item.getDesignation());
		  data.filtered((oldItem) -> oldItem.getIdProduit() == item.getIdProduit()).get(0).setDesignation(item.getNom());
		  data.filtered((oldItem) -> oldItem.getIdProduit() == item.getIdProduit()).get(0).setPrix(item.getPrix());
		 tableVIew.refresh();
	}

}