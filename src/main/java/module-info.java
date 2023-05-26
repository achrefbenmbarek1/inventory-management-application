module com.mycompany.mavenproject3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.mavenproject3 to javafx.fxml;

    opens com.mycompany.mavenproject3.authentification.controller to javafx.fxml;
    opens com.mycompany.mavenproject3.produit.controller to javafx.fxml;
    opens com.mycompany.mavenproject3.transaction.achat.controller to javafx.fxml;
    opens com.mycompany.mavenproject3.transaction.vente.controller to javafx.fxml;
    opens com.mycompany.mavenproject3.transaction.achat.model.entities to javafx.base;
    opens com.mycompany.mavenproject3.transaction.vente.view to javafx.base;
    opens com.mycompany.mavenproject3.produit.view to javafx.base;
    opens com.mycompany.mavenproject3.transaction.achat.view to javafx.base;

    exports com.mycompany.mavenproject3;
}
