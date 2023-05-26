/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.achat.model.Interactor;

import com.mycompany.mavenproject3.shared.dataAccessLayer.IDao.IDao;
import com.mycompany.mavenproject3.shared.exceptions.achatInteractorException.AnnulationAchatException;
import com.mycompany.mavenproject3.transaction.achat.dto.AchatNouveauProduitDto;
import com.mycompany.mavenproject3.transaction.achat.exception.AjoutDunProduitExistantException;
import com.mycompany.mavenproject3.transaction.achat.model.entities.Achat;
import com.mycompany.mavenproject3.produit.model.entities.Produit;
import java.sql.Date;
import java.util.List;
import com.mycompany.mavenproject3.transaction.interactor.ITransactionInteractor;
import com.mycompany.mavenproject3.shared.dataAccessLayer.IDao.IProduitDao;

/**
 *
 * @author achref
 */
public class AchatInteractor implements ITransactionInteractor<Achat,AchatNouveauProduitDto> {

	private IDao<Achat> iAchatDao;  
	private IProduitDao iProduitDao;

	public AchatInteractor(IDao<Achat> iAchatDao, IProduitDao iProduitDao) {
		this.iAchatDao = iAchatDao;
		this.iProduitDao = iProduitDao;
	}


	@Override
	public void supprimer(int id) {
		int idProduit = iAchatDao.rechercher(id).getIdProduit();
		int quantiteAcheter = iAchatDao.rechercher(id).getQuantite();
		Produit produit = iProduitDao.rechercher(idProduit);
		if(produit.getStock()-quantiteAcheter<0)
			throw new AnnulationAchatException("Impossible d'annuler l'achat.La quantité achetée est déjà vendu");
		iProduitDao.updateStock(idProduit, produit.getStock()-quantiteAcheter);
		iAchatDao.supprimer(id);

	}

	@Override
	public Achat rechercher(int id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void ajouter(AchatNouveauProduitDto dto) {
		Achat achat = new Achat(dto.getIdAchat(), dto.getIdProduit(),dto.getIdFournisseur() , dto.getQuantite(), new Date(System.currentTimeMillis()));
		try {
			 if (iProduitDao.rechercher(achat.getIdProduit()) != null)
				 throw new AjoutDunProduitExistantException("le produit est déjà existant");

			iAchatDao.ajouter(achat);
			iProduitDao.ajouter(new Produit(dto.getNomProduit(), dto.getIdProduit(), dto.getPrix() ,dto.getDesignation(), dto.getQuantite()));
			 
			//iProduitDao.updateStock(produit.getIdProduit(), produit.getStock()+achat.quantite());
			
		} 
		
		catch(AjoutDunProduitExistantException adpee){
			
		}
	}

	@Override
	public List<Achat> afficherTout() {
		return iAchatDao.afficherTout();
	}

	@Override
	public void modiferQuantie(int id,int quantite) {
		int idProduit = iAchatDao.rechercher(id).getIdProduit();
		int stock = iProduitDao.rechercher(idProduit).getStock();
		iProduitDao.updateStock(id, stock + quantite);
		iAchatDao.rechercher(id).setQuantite(stock + quantite);
	}

}
