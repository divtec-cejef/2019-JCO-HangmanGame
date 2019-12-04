
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehangmangames;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class Menu extends Application{
       
    //Création d'un checkbox pour les indices
    CheckBox indices = new CheckBox("Oui je les veux !");
    //Création un groupe
    final ToggleGroup languesGroupe = new ToggleGroup();
    
    //Creation des boutons Francais
    //fr_ -> français
    ToggleButton choixfacile = new ToggleButton("Facile");
    ToggleButton choixMoyen = new ToggleButton("Moyen");
    ToggleButton choixDifficile = new ToggleButton("Difficile");
    
    public static void main(String[] args) {
        launch(args);
    }
 
    public void start(Stage primaryStage) { 
        //Création du bouton pour commencé le jeu
        Button btn_DemarrageJeu = new Button();
        btn_DemarrageJeu.setText("Jouons !");
        
        //Ajout dans un groupe pour le groupe français
        ToggleGroup choixGroupe = new ToggleGroup();
        choixGroupe.getToggles().addAll(choixfacile, choixMoyen, choixDifficile);
 
        //Création d'un nouveau label
        Label utilisateurDifficulte = new Label("Difficulté choisie :");
        
        //Creation d'un label pour les langues
        Label languesLabel = new Label ("Choix de la langue : ");
        
        //Création d'un radioButton      
        RadioButton langueFrancais = new RadioButton("Français");
        RadioButton langueAnglais = new RadioButton("Anglais");
        
        //Ajout d'un groupe
        langueFrancais.setToggleGroup(languesGroupe);
        langueAnglais.setToggleGroup(languesGroupe);
        
       //creation d'un label pour les indices
        Label indicesLabel = new Label("Voulez-vous des indices ?");
             
    

        //Lorsque le bouton est appuyé on lance le jeu 
        btn_DemarrageJeu.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                 Application.launch(TheHangmanGames.class);
                
            }
        });
        
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
        VBox root = new VBox(languesLabel,langueHB,utilisateurDifficulte,boutonChoix,indicesLabel,indicesHB,btn_DemarrageJeu);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;"+ "-fx-border-style:solid inside;"+"-fx-border-width: 2;"+"-fx-border-insets:5;");
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu du pendue || Menu");
        primaryStage.show(); 
    
    }
    public String choixFichierTexte(){
        String fichierLanguesDifficultes;
        if(languesGroupe.toString() == "Anglais"){
            if (choixfacile.isSelected() == true){
                    return fichierLanguesDifficultes = "/ListMots/an_WordsEasy";
                               
                
            }else if(choixMoyen.isSelected() == true){
                
                return fichierLanguesDifficultes = "/ListMots/an_WordsMedium";
            }else{
                return fichierLanguesDifficultes = "/ListMots/an_WordHard";
            }
        }else if(languesGroupe.toString() == "Français"){
            if (choixfacile.isSelected() == true){
                    return fichierLanguesDifficultes = "/ListMots/fr_MotsFaciles";
            
        }else if(choixMoyen.isSelected() == true){
            return fichierLanguesDifficultes = "/ListMots/fr_MotsMoyens";
        }else{
            return fichierLanguesDifficultes = "/ListMots/fr_MotsDifficiles";
        }
            
            
        }
        return fichierLanguesDifficultes = "";
    }
        
}
            
           