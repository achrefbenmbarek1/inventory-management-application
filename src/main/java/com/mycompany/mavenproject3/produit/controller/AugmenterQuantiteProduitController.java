package com.mycompany.mavenproject3.produit.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.mavenproject3.produit.model.entities.Produit;
import com.mycompany.mavenproject3.produit.model.iinteractor.IProduitInteractor;
import com.mycompany.mavenproject3.produit.view.ProduitItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.mycompany.mavenproject3.shared.callback.view.TableViewModifyAndRefresh;
import com.mycompany.mavenproject3.shared.exceptions.dialogException.EmptyFieldException;
import com.mycompany.mavenproject3.shared.view.DialogCreator;
import com.mycompany.mavenproject3.transaction.achat.dto.AchatNouveauProduitDto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AugmenterQuantiteProduitController implements Initializable{

	@FXML
	private Button modificationBtn;

	@FXML
	private Label designationLabel;

	@FXML
	private TextField designationTf;
	@FXML
	private Label nomProduitLabel;

	@FXML
	private TextField nomTf;

	@FXML
	private Label prixProduitLabel;

	@FXML
	private TextField prixTf;

	private AchatNouveauProduitDto achatNouveauProduitDto = AchatNouveauProduitDto.getInstance();
	
	private IProduitInteractor produitInteractor;

	private TableViewModifyAndRefresh<ProduitItem>refresher;

	public AugmenterQuantiteProduitController(TableViewModifyAndRefresh<ProduitItem> refresher,IProduitInteractor produitInteractor) {
		this.refresher = refresher;
		this.produitInteractor = produitInteractor;
	}

	@FXML
	void modifierProduit(ActionEvent event) {
		try {
	if(nomTf.getText() == null || designationTf.getText()== null || prixTf.getText() == null )	
		throw new EmptyFieldException("les champs doivent etres tous remplis");
		achatNouveauProduitDto.setPrix(Float.parseFloat(prixTf.getText()));
		achatNouveauProduitDto.setNomProduit(nomTf.getText());
		achatNouveauProduitDto.setDesignation(designationTf.getText());
		Produit produit = new Produit(achatNouveauProduitDto.getIdProduit(),achatNouveauProduitDto.getNomProduit(),achatNouveauProduitDto.getPrix(),achatNouveauProduitDto.getDesignation());
		produitInteractor.modifier(produit);
		ProduitItem produitItem = new ProduitItem(achatNouveauProduitDto.getNomProduit(), achatNouveauProduitDto.getIdProduit(), achatNouveauProduitDto.getPrix(), achatNouveauProduitDto.getDesignation(), achatNouveauProduitDto.getQuantite(), new Button("achat"));
		refresher.modifyAndRefresh(produitItem);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
			
		} catch (EmptyFieldException efe) {
			DialogCreator.showErrorAlert(efe.getMessage());
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nomTf.setText(achatNouveauProduitDto.getNomProduit());
		prixTf.setText(Float.toString(achatNouveauProduitDto.getPrix()));
		designationTf.setText(achatNouveauProduitDto.getDesignation());
	}

}
