/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.shared.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author achref
 */
public class DialogCreator {
public static void createDialog(FXMLLoader fXMLLoader){
		Stage newStage = new Stage();
		try {
			newStage.setScene(new Scene(fXMLLoader.load()));
			newStage.initModality(Modality.APPLICATION_MODAL);
			newStage.show();
		} catch (IOException ex) {
		}
}

	public static void showErrorAlert(String message){
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Erreur");
			alert.setContentText(message);
			alert.showAndWait();

	}
}
