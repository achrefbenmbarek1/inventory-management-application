package com.mycompany.mavenproject3.transaction.achat.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.mavenproject3.transaction.achat.dto.AchatNouveauProduitDto;
import com.mycompany.mavenproject3.transaction.achat.model.entities.Achat;
import java.sql.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.mycompany.mavenproject3.shared.callback.view.TableViewAddAndRefresh;
import com.mycompany.mavenproject3.shared.view.DialogCreator;
import com.mycompany.mavenproject3.transaction.achat.exception.AjoutDunProduitExistantException;
import com.mycompany.mavenproject3.transaction.achat.view.AchatItem;
import com.mycompany.mavenproject3.transaction.interactor.ITransactionInteractor;
import javafx.scene.layout.HBox;

public class NouveauProduitDialogController {

	@FXML
	private Button apply;

	@FXML
	private Button cancel;

	@FXML
	private Label designationLabelDialog;

	@FXML
	private TextField designationTextFieldDialog;

	@FXML
	private Label idAchatLabelDialog;

	@FXML
	private TextField idAchatTextFieldDialog;

	@FXML
	private Label idFournisseurLabelDialog;

	@FXML
	private TextField idFournisseurTextFieldDialog;

	@FXML
	private Label idProduitLabelDialog;

	@FXML
	private TextField idProduitTextFieldDIalog;

	@FXML
	private Label nomFournisseurLabelDialog;

	@FXML
	private TextField nomFournisseurTextFieldDialog;

	@FXML
	private Label nomProduitLabelDialog;

	@FXML
	private TextField nomProduitTextFieldDialog;

	@FXML
	private Label prixLabelDialog;

	@FXML
	private TextField prixTextFieldDialog;

	@FXML
	private Label quantiteLabelDialog;

	@FXML
	private TextField quantiteTextFieldDialog;

	private AchatNouveauProduitDto achatNouveauProduitDto = AchatNouveauProduitDto.getInstance();

	private TableViewAddAndRefresh<AchatItem> refresher;

	private ITransactionInteractor<Achat,AchatNouveauProduitDto> achatInteractor;

	public NouveauProduitDialogController(TableViewAddAndRefresh<AchatItem> refresher,ITransactionInteractor<Achat,AchatNouveauProduitDto>achatInteractor) {
		this.refresher = refresher;
		this.achatInteractor = achatInteractor;
		
	}

	@FXML
	void cancelDialog(ActionEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();

	}

	@FXML
	void sendNewOrder(ActionEvent event) {
		try {
		achatNouveauProduitDto.setIdProduit(Integer.parseInt(idProduitTextFieldDIalog.getText()));
		achatNouveauProduitDto.setNomProduit((nomProduitTextFieldDialog.getText()));
		achatNouveauProduitDto.setPrix(Float.parseFloat(prixTextFieldDialog.getText()));
		achatNouveauProduitDto.setQuantite(Integer.parseInt(quantiteTextFieldDialog.getText()));
		achatNouveauProduitDto.setIdAchat(Integer.parseInt(idAchatTextFieldDialog.getText()));
		achatNouveauProduitDto.setNomFournisseur((nomFournisseurTextFieldDialog.getText()));
		achatNouveauProduitDto.setIdFournisseur(Integer.parseInt(idFournisseurTextFieldDialog.getText()));
		achatNouveauProduitDto.setDesignation((designationTextFieldDialog.getText()));
		achatInteractor.ajouter(achatNouveauProduitDto);
		AchatItem item = new AchatItem(achatNouveauProduitDto.getIdAchat(), achatNouveauProduitDto.getIdProduit(), achatNouveauProduitDto.getIdFournisseur(), achatNouveauProduitDto.getQuantite(), new Date(System.currentTimeMillis()),new Button("annuler"),new Button("modifier"));
		item.getModifierAchat().setStyle("-fx-background-color: #1BA531");
		item.getAnnulerAchat().setStyle("-fx-background-color: #FF0000");

		refresher.addAndRefresh(item);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
			
		} catch (AjoutDunProduitExistantException adpee) {
			DialogCreator.showErrorAlert(adpee.getMessage());
		}

	}


}
