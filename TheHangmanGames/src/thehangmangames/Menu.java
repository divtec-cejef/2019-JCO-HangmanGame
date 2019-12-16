
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
    CheckBox CB_indices = new CheckBox("Oui je les veux !");
    //Création un groupe
    final ToggleGroup languesGroupe = new ToggleGroup();
    
    //Creation des boutons Francais
    //fr_ -> français
    ToggleButton TB_choixfacile = new ToggleButton("Facile");
    ToggleButton TB_choixDifficile = new ToggleButton("Difficile");
    
    public static void main(String[] args) {
        launch(args);
    }
 
    public void start(Stage primaryStage) { 
        //Création du bouton pour commencé le jeu
        Button BTN_DemarrageJeu = new Button();
        BTN_DemarrageJeu.setText("Jouons !");
        
        //Ajout dans un groupe pour le groupe français
        ToggleGroup TG_choixGroupe = new ToggleGroup();
        TG_choixGroupe.getToggles().addAll(TB_choixfacile, TB_choixDifficile);
 
        //Création d'un nouveau label
        Label LB_utilisateurDifficulte = new Label("Difficulté choisie :");
        
        //Creation d'un label pour les langues
        Label LB_languesLabel = new Label ("Choix de la langue : ");
        
        //Création d'un radioButton      
        RadioButton RB_langueFrancais = new RadioButton("Français");
        RadioButton RB_langueAnglais = new RadioButton("Anglais");
        
        //Ajout d'un groupe
        RB_langueFrancais.setToggleGroup(languesGroupe);
        RB_langueAnglais.setToggleGroup(languesGroupe);
        
       //creation d'un label pour les indices
        Label LB_indices = new Label("Voulez-vous des indices ?");
             
    

        //Lorsque le bouton est appuyé on lance le jeu 
        BTN_DemarrageJeu.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                 Application.launch(TheHangmanGames.class);
                
            }
        });
        
        //Création d'un ligne de composants des boutons Français
        HBox HB_boutonChoix = new HBox(TB_choixfacile, TB_choixDifficile);
        HB_boutonChoix.setSpacing(10);     
        
        //Création de la ligne de composant pour la checkbox
        HBox HB_indices = new HBox(CB_indices);
        HB_indices.setSpacing(30);
        
        //Création de la ligne de composant pour les radios Buttons
        HBox langueHB = new HBox(RB_langueFrancais, RB_langueAnglais);
        langueHB.setSpacing(30);
        
        //Création d'une ligne verticale de composant
        VBox root = new VBox(LB_languesLabel,langueHB,LB_utilisateurDifficulte,HB_boutonChoix,LB_indices,HB_indices,BTN_DemarrageJeu);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;"+ "-fx-border-style:solid inside;"+"-fx-border-width: 2;"+"-fx-border-insets:5;");
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu du pendue || Menu");
        primaryStage.show(); 
    
    }
    public String choixFichierTexte(String nomfichier){
        if(languesGroupe.toString() == "Anglais"){
            if (TB_choixfacile.isSelected() == true){
                    return nomfichier = "/ListMots/an_WordsEasy";
            }else{
                return nomfichier = "/ListMots/an_WordHard";
            }
        }else if(languesGroupe.toString() == "Français"){
            if (TB_choixfacile.isSelected() == true){
                    return nomfichier = "/ListMots/fr_MotsFaciles";
        }else{
            return nomfichier = "/ListMots/fr_MotsDifficiles";
        } 
        }
        return nomfichier = "";
    }
        
}
            
           