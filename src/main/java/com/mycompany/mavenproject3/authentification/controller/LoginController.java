package com.mycompany.mavenproject3.authentification.controller;

import com.mycompany.mavenproject3.App;
import com.mycompany.mavenproject3.shared.exceptions.authentificationException.InvalidEmailException;
import com.mycompany.mavenproject3.shared.exceptions.authentificationException.InvalidPasswordException;
import com.mycompany.mavenproject3.authentification.authenticationService.AuthenticationService;
import com.mycompany.mavenproject3.shared.exceptions.daoException.RechercheException;
import com.mycompany.mavenproject3.shared.view.DialogCreator;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	AuthenticationService authenticationService;


	public LoginController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@FXML
	private TextField email;

	@FXML
	private Button login;

	@FXML
	private PasswordField password;
	@FXML
	private Label errorLabel;

	@FXML
	void login(ActionEvent event) throws IOException {
		try {
			authenticationService.signIn(email.getText(), password.getText());
			App.setRoot("produit");
			
		} catch (InvalidEmailException iee) {
			String toastMsg =iee.getMessage();
			DialogCreator.showErrorAlert(toastMsg);
	
		}
		catch(InvalidPasswordException ipe){
			String toastMessage = ipe.getMessage();
			DialogCreator.showErrorAlert(toastMessage);

		}
		catch(RechercheException re){
			String toast = re.getMessage();
			DialogCreator.showErrorAlert(toast);
		}

	}


}


