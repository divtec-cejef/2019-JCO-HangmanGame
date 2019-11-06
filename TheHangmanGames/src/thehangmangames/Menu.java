/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehangmangames;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author mingsop
 */
public class Menu extends Application { 
    
   Label choixDifficulte = new Label("Choix de la difficulté : None");

    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) { 
        
        //Creation des boutons
        ToggleButton choixfacile = new ToggleButton("Facile");
        ToggleButton choixMoyen = new ToggleButton("Moyen");
        ToggleButton choixDifficile = new ToggleButton("Difficile");
        
        //Création du champs de saisie
        Label labelNom = new Label("Nom de la partie : ");
        TextField nomPartie = new TextField();

        
        //Ajout d'un écouteur sur les boutons
        

        
                
        
        //Ajout dans un group
        ToggleGroup choixGroupe = new ToggleGroup();
        choixGroupe.getToggles().addAll(choixfacile, choixMoyen, choixDifficile);
        
        //Ajout d'un "écouteur"
        choixGroupe.selectedToggleProperty().addListener(this::changed);
        
        //Création d'un nouveau label
        Label utilisateurDifficulte = new Label("Difficulté choisie :");
        
        HBox boutonChoix = new HBox(choixfacile, choixMoyen, choixDifficile, nomPartie);
        boutonChoix.setSpacing(10);
        
        VBox root = new VBox(choixDifficulte,utilisateurDifficulte,boutonChoix);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;"+ "-fx-border-style:solid inside;"+"-fx-border-width: 2;"+"-fx-border-insets:5;"+"-fx-border-radius:5;"+"-fx-border-color: blue;");
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu du pendue || Menu");
        primaryStage.show(); 
        
        //Champs de saisie pour que la partie est un nom
        
    
    }
    
    //La fonction écoute un listener pour savoir quel bouton a été appuyé pour changer le texte
    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldBtn, Toggle newBtn){
        String selectedLabel = "None";
        if(newBtn != null){
            selectedLabel = ((Labeled)newBtn).getText();
        }
        choixDifficulte.setText("Choix de la difficulté : "+ selectedLabel);
    }
    //On retourne un String pour savoir ce que contient le bouton comme texte
    //Afin de pouvoir l'utiliser dans le LecteurMots
   /* public String typedeJeu(ObservableValue<? extends Toggle> observable, Toggle oldBtn, Toggle newBtn){
        
        
        
    }*/
 
}