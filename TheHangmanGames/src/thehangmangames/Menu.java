/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehangmangames;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Classe de teste pour le menu
 * @author mingsop
 */
public class Menu {
     public static void nouvelleFenetre(String titre){
         Stage fenêtreMenu = new Stage();
        fenêtreMenu.initModality(Modality.APPLICATION_MODAL);
        
        
        Pane pane = new Pane();
        
        //Button pour le choix du fichier ANglais
        Button BT_Anglais = new Button("Anglais");
        //Bouton pour le choix du fichier français
        Button BT_Français = new Button("Français");
        //Bouton pour fermer la fênetre de réglages
        Button BT_Fermeture = new Button("Confirmer et jouer");
        
        Button BTN_DemarrageJeu = new Button();
        BTN_DemarrageJeu.setText("Jouons !");
        
        //Création d'un checkbox pour les indices
        CheckBox CB_indices = new CheckBox("Oui je les veux !");
        
        //Création d'un nouveau label
        Label LB_utilisateurDifficulte = new Label("Difficulté choisie :");
        
        //Creation d'un label pour les langues
        Label LB_languesLabel = new Label ("Choix de la langue : ");
        //creation d'un label pour les indices
        Label LB_indices = new Label("Voulez-vous des indices ?");
         
        
        //Création de la ligne de composant pour la checkbox
        HBox HB_indices = new HBox(CB_indices);
        HB_indices.setSpacing(30);
        
        //Création de la ligne de composant pour les radios Buttons
        HBox langueHB = new HBox(BT_Anglais, BT_Français);
        langueHB.setSpacing(30);
        
     }
    
    
}
