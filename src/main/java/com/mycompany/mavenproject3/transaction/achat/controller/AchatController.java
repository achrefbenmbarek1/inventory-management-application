/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.achat.controller;

import com.mycompany.mavenproject3.App;
import com.mycompany.mavenproject3.transaction.achat.dto.AchatNouveauProduitDto;
import com.mycompany.mavenproject3.transaction.achat.model.entities.Achat;
import com.mycompany.mavenproject3.transaction.interactor.ITransactionInteractor;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import com.mycompany.mavenproject3.shared.callback.view.TableViewAddAndRefresh;
import com.mycompany.mavenproject3.shared.callback.view.TableViewModifyAndRefresh;
import com.mycompany.mavenproject3.shared.view.DialogCreator;
import com.mycompany.mavenproject3.transaction.achat.view.AchatItem;

public class AchatController implements Initializable,TableViewAddAndRefresh<AchatItem>,TableViewModifyAndRefresh<AchatItem>{

	@FXML
	private TableColumn<AchatItem, Button> modification;

	@FXML
	private Hyperlink StatistiquesNavIemProduit;

	@FXML
	private Hyperlink achatsNavItemProduit;

	@FXML
	private Button annulationAchat;

	@FXML
	private Hyperlink clientsNavItemsProduit;

	@FXML
	private TableColumn<AchatItem, Integer> idAchat;

	@FXML
	private Hyperlink fournisseursNavItemProduit;

	@FXML
	private TableColumn<AchatItem, Integer> idProduit;

	@FXML
	private TableColumn<AchatItem, Integer> idFr;

	@FXML
	private TableColumn<AchatItem, Integer> quantite;

	@FXML
	private Hyperlink produitsNavItemProduit;

	@FXML
	private TableColumn<AchatItem, Date> dateAchat;

	@FXML
	private TableView<AchatItem> tableVIew;

	@FXML
	private Hyperlink ventesNavItemProduit;

	@FXML
	private TableColumn<AchatItem, Button> annulationColomn;

	private ITransactionInteractor<Achat, AchatNouveauProduitDto> achatInteractor;

	private ObservableList<AchatItem> data = FXCollections.observableArrayList();

	public AchatController(ITransactionInteractor<Achat, AchatNouveauProduitDto> achatInteractor) {
		this.achatInteractor = achatInteractor;
	}

	@FXML
	void acheterNouveauProduit(ActionEvent event) {
		FXMLLoader fXMLLoader = new FXMLLoader(App.class.getResource("nouveauProduitAchatDialog.fxml"));
		fXMLLoader.setControllerFactory(new Callback<Class<?>, Object>(){
			@Override
			public Object call(Class<?> param) {
				return new NouveauProduitDialogController(AchatController.this,achatInteractor);
			}
		});
		DialogCreator.createDialog(fXMLLoader);
	}

	@FXML
	void goToAchat(ActionEvent event) {
		try {
			App.setRoot("achat");
		} catch (IOException ex) {
			Logger.getLogger(AchatController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	void goToProduit(ActionEvent event) {
		try {
			App.setRoot("produit");
		} catch (IOException ex) {
			Logger.getLogger(AchatController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(Achat achat:achatInteractor.afficherTout()){
			AchatItem achatItem = new AchatItem(achat.getIdAchat(), achat.getIdProduit(), achat.getIdFr(), achat.getQuantite(), achat.getDateAchat(), new Button("annuler"),new Button("modifier"));
			data.add(achatItem);
		}
		for(AchatItem achatItem:data){
			achatItem.getModifierAchat().setOnAction(this::handleButtonActionModifier);
			achatItem.getModifierAchat().setStyle("-fx-background-color: #1BA531");
			achatItem.getAnnulerAchat().setOnAction(this::handleButtonActionAnnuler);
			achatItem.getAnnulerAchat().setStyle( "-fx-background-color: #FF0000");

		}
		idProduit.setCellValueFactory(new PropertyValueFactory<AchatItem,Integer>("idProduit"));
		idAchat.setCellValueFactory(new PropertyValueFactory<AchatItem,Integer>("idAchat"));
		idFr.setCellValueFactory(new PropertyValueFactory<AchatItem,Integer>("idFr"));
		quantite.setCellValueFactory(new PropertyValueFactory<AchatItem,Integer>("quantite"));
		dateAchat.setCellValueFactory(new PropertyValueFactory<AchatItem,Date>("dateAchat"));
		annulationColomn.setCellValueFactory(new PropertyValueFactory<AchatItem,Button>("annulerAchat"));
		modification.setCellValueFactory(new PropertyValueFactory<AchatItem,Button>("modifierAchat"));
		tableVIew.setItems(data);
	}

	@FXML
	void goToVente(ActionEvent event) {
		try {
			App.setRoot("vente");
		} catch (IOException ex) {
			Logger.getLogger(AchatController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void addAndRefresh( AchatItem item) {
		data.add(item);
		tableVIew.refresh();
	}

	@Override
	public void modifyAndRefresh(AchatItem item) {
		  data.filtered((oldItem) -> oldItem.getIdProduit() == item.getIdAchat()).get(0).setQuantite(item.getQuantite());
		  tableVIew.refresh();
	}

	private void handleButtonActionAnnuler(ActionEvent event) {
		achatInteractor.supprimer(data.filtered((t) -> t.getAnnulerAchat() == event.getSource()).get(0).getIdAchat());
		data.remove(data.filtered((t) -> t.getAnnulerAchat() == event.getSource()).get(0));
		tableVIew.refresh();

	}

	private void handleButtonActionModifier(ActionEvent event) {
		AchatNouveauProduitDto achatNouveauProduitDto = AchatNouveauProduitDto.getInstance();
		AchatItem achatItem = data.filtered((t) -> t.getModifierAchat()== event.getSource()).get(0);
		achatNouveauProduitDto.setIdAchat(achatItem.getIdAchat());
		achatNouveauProduitDto.setQuantite(achatItem.getQuantite());
		FXMLLoader fXMLLoader = new FXMLLoader(App.class.getResource("modifierAchat.fxml"));
		fXMLLoader.setControllerFactory((Class<?> param) -> new ModificationAchat(AchatController.this,achatInteractor));
		DialogCreator.createDialog(fXMLLoader);
	}

	

}
