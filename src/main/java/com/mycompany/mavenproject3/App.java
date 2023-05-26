package com.mycompany.mavenproject3;

import com.mycompany.mavenproject3.transaction.achat.controller.AchatController;
import com.mycompany.mavenproject3.produit.controller.ProduitController;
import com.mycompany.mavenproject3.shared.dataAccessLayer.Dao.AchatDao;
import com.mycompany.mavenproject3.shared.dataAccessLayer.Dao.ProduitDao;
import com.mycompany.mavenproject3.authentification.controller.LoginController;
import com.mycompany.mavenproject3.transaction.achat.model.entities.Achat;
import com.mycompany.mavenproject3.transaction.achat.model.Interactor.AchatInteractor;
import com.mycompany.mavenproject3.produit.model.interactor.ProduitIntreractor;
import com.mycompany.mavenproject3.authentification.authenticationService.AuthenticationServiceImpl;
import com.mycompany.mavenproject3.shared.dataAccessLayer.Dao.AdministrateurDao;
import com.mycompany.mavenproject3.shared.dataAccessLayer.Dao.VenteDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import javafx.util.Callback;
import com.mycompany.mavenproject3.transaction.interactor.ITransactionInteractor;
import com.mycompany.mavenproject3.transaction.vente.controller.VenteController;
import com.mycompany.mavenproject3.transaction.vente.model.interactor.VenteInteractor;
/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

	public static Scene getScene() {
		return scene;
	}

    @Override
    public void start(Stage stage) throws IOException {
	    try {
		  	//FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("primary.fxml"));
			
         scene = new Scene(loadFXML("login"));
        stage.setScene(scene);
	
	    Achat achat = new Achat(1,4, 8, 3, Date.valueOf("1980-5-10"));
	    AchatDao achatDao = new AchatDao();
	    ProduitDao produitDao = new ProduitDao();
	    //IDao iachatDao = new AchatModel(achatDao);
	   // iachatDao.ajouter(achat);
	    //achatDao.ajouter(achat);
	    ITransactionInteractor imodel = new AchatInteractor(achatDao,produitDao);
	    imodel.afficherTout();
        stage.show();
		    
	    } catch (Exception e) {
		    e.printStackTrace();
	    }
    }


    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
	fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>(){
		@Override
		public Object call(Class<?> param) {
			switch(fxml){
				case "produit":
					return new ProduitController(new ProduitIntreractor(new ProduitDao()));
				case "achat":
					return new AchatController(new AchatInteractor(new AchatDao(),new ProduitDao()));
				case "vente":
					return new VenteController(new VenteInteractor(new VenteDao(),new ProduitDao()));
				default:
					return new LoginController(new AuthenticationServiceImpl(new AdministrateurDao()));


			}
		}

	});
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}