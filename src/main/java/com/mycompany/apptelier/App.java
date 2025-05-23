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

import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import java.sql.*;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class App extends Application {
    
    private Font f = new Font(20);
   
    
    public void start(Stage stage) {
        Label message = new Label("Gérer l'Apptelier");
        message.setFont(new Font(30));
        
        
        Button gMachine = new Button("Machines");
        gMachine.setOnAction(evt -> {}); 
        
        Button gPoste = new Button("Postes");
        gMachine.setOnAction(evt -> {}); 

        Button gGamme = new Button("Gammes");
        gGamme.setOnAction(evt -> {}); 
        
        Button gOperation = new Button("Opérations");
        gGamme.setOnAction(evt -> {}); 
        
        Button gOperateur = new Button("Opérateurs");
        gOperateur.setOnAction(evt -> {
          }); //A MODIF
        
        Region espaceVide = new Region();
        espaceVide.setPrefHeight(50);
        
        Button atelier = new Button("Afficher l'atelier");
        atelier.setOnAction(evt -> {message.setText("nouvelle fenêtre");});//A MODIF
        
        Button gProduit = new Button("Produits");
        gProduit.setOnAction(evt -> {message.setText("nouvelle fenêtre");});//A MODIF
        
        gMachine.setFont(f);
        gPoste.setFont(f);
        gGamme.setFont(f);
        gOperation.setFont(f);
        gOperateur.setFont(f);
        atelier.setFont(f);
        gProduit.setFont(f);
      
        
        GridPane layout = new GridPane();
        layout.add(message, 0, 0, 2, 1);
        GridPane.setHalignment(message, HPos.CENTER);
        layout.add(gMachine, 0, 1);
        GridPane.setHalignment(gMachine, HPos.RIGHT);
        layout.add(gPoste, 1, 1);
        layout.add(gOperation, 0, 2);
        layout.add(gGamme, 1, 2);
        layout.add(gOperateur, 0, 3);
        layout.add(gProduit, 1, 3);
        layout.add(espaceVide, 0, 4, 2, 1);
        layout.add(atelier, 0, 5, 2, 1);
        GridPane.setHalignment(atelier, HPos.CENTER);
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10); layout.setVgap(10);
        

        
        Scene scene = new Scene(layout, 450, 400);
        stage.setScene(scene);
        stage.setTitle("Gestion de l'atelier");
        stage.show();
    }

    public void fenetreEquipement(){ //A ENLEVER
    Stage equipement = new Stage();
    equipement.setTitle("Gestion des équipements");

    Button machine = new Button("Machines");
        machine.setOnAction(e -> {System.out.println("nouvelle fenêtre");});//A MODIF
    Button poste = new Button("Postes");
        poste.setOnAction(e -> {System.out.println("nouvelle fenêtre");}); //A MODIF

    machine.setFont(f); poste.setFont(f);
    
    
    VBox box = new VBox(10, machine, poste);
    box.setAlignment(Pos.CENTER);
    
    
    Scene scene = new Scene(box, 310, 150);
        equipement.setX(800);equipement.setY(250);
        equipement.setScene(scene);
        equipement.show();
    }
    
    public void fenetreGamme(){ //A ENLEVER
    Stage Gamme = new Stage();
    Gamme.setTitle("Gestion des gammes");

    Button operation = new Button("Opérations");
        operation.setOnAction(e -> {System.out.println("nouvelle fenêtre");});//A MODIF
    Button gamme = new Button("Gammes");
        gamme.setOnAction(e -> {System.out.println("nouvelle fenêtre");}); //A MODIF

    operation.setFont(f); gamme.setFont(f);
    
        
    VBox box = new VBox(10, operation, gamme);
    box.setAlignment(Pos.CENTER);
    
    
    Scene scene = new Scene(box, 310, 150);
        Gamme.setX(170);Gamme.setY(250);
        Gamme.setScene(scene);
        Gamme.show();
    }
    
   
    
    public static void main(String[] args) {
        launch(args); 
        FiabiliteMachine.calculerFiabiliteDepuisFichier("suiviMaintenance.txt");
        DatabaseManager.creerTables();
    }
}
