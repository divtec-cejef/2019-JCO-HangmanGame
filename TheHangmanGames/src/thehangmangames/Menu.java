
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mingsop
 */
public class Menu extends Application {
    /* enum Difficulte{
         DIFFICULTE_1,
         DIFFICULTE_2,
         DIFFICULTE_3;
         
         private String description;
     }
    */
    
    Label choixDifficulte = new Label("Choix de la difficulté : None");

    public static void main(String[] args) {
        launch(args);
    }
 
    public void start(Stage primaryStage) { 

        //Creation des boutons Francais
        //fr_ -> français
        ToggleButton choixfacile = new ToggleButton("Facile");
        ToggleButton choixMoyen = new ToggleButton("Moyen");
        ToggleButton choixDifficile = new ToggleButton("Difficile");
              
        //Création du bouton pour commencé le jeu
        Button btn_DemarrageJeu = new Button("Jouons !"); 
        
        //Ajout dans un groupe pour le groupe français
        ToggleGroup choixGroupe = new ToggleGroup();
        choixGroupe.getToggles().addAll(choixfacile, choixMoyen, choixDifficile);
        
        //Ajout d'un "écouteur" pour changer le texte de difficulté
        choixGroupe.selectedToggleProperty().addListener(this::changed);
        
        //Ajout d'un "écouteur" pour les fichiers textes
        choixGroupe.selectedToggleProperty().addListener(this::chargementFichierTexte);
        
        
        //Création d'un nouveau label
        Label utilisateurDifficulte = new Label("Difficulté choisie :");
        
       //creation d'un label pour les indices
        Label indicesLabel = new Label("Voulez-vous des indices ?");
        
        //Creation d'un label pour les langues
        Label languesLabel = new Label ("Choix de la langue : ");
        
        //Création d'un radioButton
        final ToggleGroup languesGroupe = new ToggleGroup();
        RadioButton langueFrancais = new RadioButton("Français");
        RadioButton langueAnglais = new RadioButton("Anglais");
        
        //Ajout d'un groupe
        langueFrancais.setToggleGroup(languesGroupe);
        langueAnglais.setToggleGroup(languesGroupe);
        
        //Création d'un checkbox pour les indices
        CheckBox indices = new CheckBox("Oui je les veux !");
        
        //Création d'un ligne de composants des boutons Français
        HBox boutonChoix = new HBox(choixfacile, choixMoyen, choixDifficile);
        boutonChoix.setSpacing(10);     
        
        //Création de la ligne de composant pour la checkbox
        HBox indicesHB = new HBox(indices);
        indicesHB.setSpacing(30);
        
        //Création de la ligne de composant pour les radios Buttons
        HBox langueHB = new HBox(langueFrancais, langueAnglais);
        langueHB.setSpacing(30);
        
        //Création d'une ligne verticale de composant
        VBox root = new VBox(choixDifficulte,utilisateurDifficulte,boutonChoix,indicesLabel,indicesHB,languesLabel,langueHB);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;"+ "-fx-border-style:solid inside;"+"-fx-border-width: 2;"+"-fx-border-insets:5;");
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu du pendue || Menu");
        primaryStage.show(); 
    
    }
    
    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldBtn, Toggle newBtn){
        //changer nom variable
        String selectedLabel = "None";
        if(newBtn != null){
            selectedLabel = ((Labeled)newBtn).getText();
        }
        choixDifficulte.setText("Choix de la difficulté : "+ selectedLabel);
    }
    /**
     * La fonctionne permet de savoir l'index des bouton afin que dans la classe LecteurMots
     * afin de pouvoir choisir le bon fichier texte
     * @return l'index du bouton appuyé
     */
    public int chargementFichierTexte(ObservableValue<? extends Toggle> observable, Toggle oldBtn, Toggle newBtn){
        int indexBouton = 0;
        return indexBouton;
    }
    
    
 }