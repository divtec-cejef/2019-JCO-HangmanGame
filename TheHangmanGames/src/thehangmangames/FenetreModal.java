/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehangmangames;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Cette classe gère l'affichage de la fenêtre modal "Menu"
 * @author mingsop
 */
public class FenetreModal {
    final ToggleGroup languesGroupe = new ToggleGroup();
    
    //Création des radioButton      
    static ToggleButton RB_langueFrancais = new ToggleButton("Français");
    static ToggleButton RB_langueAnglais = new ToggleButton("Anglais");
    
    static RadioButton RB_choixfacile = new RadioButton("Facile");
    static RadioButton RB_choixDifficile = new RadioButton("Difficile");
    
    public void nouvelleFenetre(String title){
        
        LecteurMot choixMot = new LecteurMot();
        
        Stage fenêtreMenu = new Stage();
        fenêtreMenu.initModality(Modality.APPLICATION_MODAL);
        
        Pane pane = new Pane();
        
        Button BT_Fermeture = new Button("Confirmer et jouer");
        BT_Fermeture.setOnAction(event->fenêtreMenu.close());
        
        //Création d'un checkbox pour les indices
        CheckBox CB_indices = new CheckBox("Oui je les veux !");
        
        //Ajout dans un groupe pour le groupe français
        ToggleGroup TG_choixGroupe = new ToggleGroup();
        TG_choixGroupe.getToggles().addAll(RB_choixfacile, RB_choixDifficile);
 
        //Création d'un nouveau label
        Label LB_utilisateurDifficulte = new Label("Difficulté choisie :");
        
        //Creation d'un label pour les langues
        Label LB_languesLabel = new Label ("Choix de la langue : ");
      
       //creation d'un label pour les indices
        Label LB_indices = new Label("Voulez-vous des indices ?");
              
        //Lorsque le bouton fermer la fênetre se ferme
        BT_Fermeture.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                choixMot.MotAleatoire();
                fenêtreMenu.close();              
            }
        });
        
        
        //Création d'un ligne de composants des boutons Français
        HBox HB_boutonChoix = new HBox(RB_choixDifficile, RB_choixDifficile);
        HB_boutonChoix.setSpacing(10);     
        
        //Création de la ligne de composant pour la checkbox
        HBox HB_indices = new HBox(CB_indices);
        HB_indices.setSpacing(30);
        
        //Création de la ligne de composant pour les radios Buttons
        HBox langueHB = new HBox(RB_langueFrancais, RB_langueAnglais);
        langueHB.setSpacing(30);
        
        //Création d'une ligne verticale de composant
        VBox root = new VBox(LB_languesLabel,langueHB,LB_utilisateurDifficulte,HB_boutonChoix,LB_indices,HB_indices, BT_Fermeture);
        root.setSpacing(10);              
        
        pane.getChildren().addAll(root);
        Scene sceneMenu = new Scene(pane, 250,250);
        
        fenêtreMenu.setScene(sceneMenu);
        fenêtreMenu.setTitle(title);
        fenêtreMenu.showAndWait();
        
    }
        /*public String choisirFichier(String nomfichier){
         if(RB_langueAnglais.isPressed()){
            if (RB_choixfacile.isSelected() == true){
                    return nomfichier = "/ListMots/an_WordsEasy.txt";
            }else{
                return nomfichier = "/ListMots/an_WordHard.txt";
            }
        }else if(RB_langueFrancais.isPressed()){
            if (RB_choixfacile.isSelected() == true){
                    return nomfichier = "/ListMots/fr_MotsFaciles.txt";
        }else{
            return nomfichier = "/ListMots/fr_MotsDifficiles.txt";
        } 
        }
        return nomfichier;
    }*/
       
    
    public String choixDifficulté(String choixDifficulte){
        if(RB_choixDifficile.isPressed()){
            return choixDifficulte = "fr_MotsFaciles.txt";
        }else{
            return choixDifficulte ="fr_MotsDifficile.txt";
        }
    }

      
    
    
}
