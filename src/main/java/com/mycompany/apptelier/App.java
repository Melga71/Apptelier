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

public class App extends Application {
    
    private Font f = new Font(20);
   
    
    public void start(Stage stage) {
        Label message = new Label("Bienvenue dans l'Apptelier !");
        message.setFont(new Font(30));
        
        Button gEquip = new Button("Gérer les équipements");
        gEquip.setOnAction(evt -> {fenetreEquipement();}); 

        Button gGammes = new Button("Gérer les gammes");
        gGammes.setOnAction(evt -> {fenetreGamme();}); 
        
        Button gOperateurs = new Button("Gérer les opérateurs");
        gOperateurs.setOnAction(evt -> {
          }); //A MODIF
        
        Button atelier = new Button("Afficher l'atelier");
        atelier.setOnAction(evt -> {message.setText("nouvelle fenêtre");});//A MODIF
        
        Button gProduit = new Button("Gérer les produits");
        gProduit.setOnAction(evt -> {message.setText("nouvelle fenêtre");});//A MODIF
        
        gEquip.setFont(f);
        gGammes.setFont(f);
        gOperateurs.setFont(f);
        atelier.setFont(f);
        gProduit.setFont(f);
        
        VBox buttonBar = new VBox(10, message, gEquip, gGammes, gOperateurs, gProduit, atelier);
        buttonBar.setAlignment(Pos.CENTER);
        
        
        
        Scene scene = new Scene(buttonBar, 450, 400);
        stage.setScene(scene);
        stage.setTitle("Gestion de l'atelier");
        stage.show();
    }

    public void fenetreEquipement(){
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
    
    public void fenetreGamme(){
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
    }
}