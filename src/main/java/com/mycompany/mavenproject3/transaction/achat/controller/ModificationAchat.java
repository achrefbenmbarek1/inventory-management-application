/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.achat.controller;

import com.mycompany.mavenproject3.shared.callback.view.TableViewModifyAndRefresh;
import com.mycompany.mavenproject3.transaction.achat.dto.AchatNouveauProduitDto;
import com.mycompany.mavenproject3.transaction.achat.model.entities.Achat;
import com.mycompany.mavenproject3.transaction.achat.view.AchatItem;
import com.mycompany.mavenproject3.transaction.interactor.ITransactionInteractor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author achref
 */
public class ModificationAchat implements Initializable{

	@FXML
	private Button modificationBtn;

	@FXML
	private TextField quantite;

	private TableViewModifyAndRefresh<AchatItem> tableViewModifyAndRefresh;
	private ITransactionInteractor<Achat,AchatNouveauProduitDto> achatInteractor;

	public ModificationAchat(TableViewModifyAndRefresh<AchatItem> tableViewModifyAndRefresh, ITransactionInteractor<Achat,AchatNouveauProduitDto>achatInteractor ) {
		this.tableViewModifyAndRefresh = tableViewModifyAndRefresh;
		this.achatInteractor = achatInteractor;
		
	}

	@FXML
	void modifierAchat(ActionEvent event) {
		AchatNouveauProduitDto achatNouveauProduitDto = AchatNouveauProduitDto.getInstance();
		achatInteractor.modiferQuantie(achatNouveauProduitDto.getIdAchat(), achatNouveauProduitDto.getQuantite());
		//AchatItem achatItem = new AchatItem(achatNouveauProduitDto.getIdAchat(), achatNouveauProduitDto.getIdProduit(), achatNouveauProduitDto.getIdFournisseur(), achatNouveauProduitDto.ge, dateAchat, hbox)
		AchatItem achatItem = new AchatItem();
		achatItem.setQuantite(achatNouveauProduitDto.getQuantite());
		achatItem.setIdAchat(achatNouveauProduitDto.getIdAchat());
		tableViewModifyAndRefresh.modifyAndRefresh(achatItem);
		
	}	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		AchatNouveauProduitDto achatNouveauProduitDto = AchatNouveauProduitDto.getInstance();	
		quantite.setText(Integer.toString(achatNouveauProduitDto.getQuantite()));
	}
}
