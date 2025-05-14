package com.mycompany.apptelier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    
    public void start(Stage stage) {
        Label message = new Label("Bienvenue dans l'Apptelier !");
        message.setFont(new Font(10));
        
        Button equip = new Button("Gérer des équipements");
        equip.setOnAction(evt -> {message.setText("ouvrir une nouvelle fenêtre");
                                        
                                       });
        //helloButton.setOnAction(new EventHandler<ActionEvent>() {
        //    @Override
        //    public void handle(ActionEvent t) {
        //        message.setText("Bonjour !");
        //        System.out.println("Bonjour !");
        //    }
        //});

        Button gamme = new Button("Gérer les opérations");
        gamme.setOnAction(evt -> {message.setText("nouvelle fenêtre");});
        
        Button operateur = new Button("Gérer les opérateurs");
        operateur.setOnAction(evt -> {message.setText("nouvelle fenêtre");});
        
        Button atelier = new Button("Afficher l'atelier");
        atelier.setOnAction(evt -> {message.setText("nouvelle fenêtre");});
        
        Button produit = new Button("Gérer les produits");
        produit.setOnAction(evt -> {message.setText("nouvelle fenêtre");});
        
        VBox buttonBar = new VBox(10, message, equip, gamme, operateur, atelier);
        buttonBar.setAlignment(Pos.CENTER);
        
        BorderPane root = new BorderPane();
        
       root.setCenter(buttonBar);
        
        //StackPane root = new StackPane();
        //root.getChildren().addAll(message,buttonBar);

        //FlowPane root = new FlowPane();
        //root.getChildren().addAll(message,buttonBar);

        //HBox root = new HBox();
        //root.getChildren().addAll(message,buttonBar);

        //VBox root = new VBox();
        //root.getChildren().addAll(message,buttonBar);

        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.setTitle("Gestion de l'atelier");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); 
    }
}