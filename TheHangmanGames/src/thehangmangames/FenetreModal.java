
package thehangmangames;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Cette classe concerne le menu réglages qui permet de changer la difficultés
 * et la langue du mot.
 * @author mingsop
 */
public class FenetreModal {
    final ToggleGroup languesGroupe = new ToggleGroup();
    static  Button TB_choixfacile = new Button("Facile");
    static  Button TB_choixDifficile = new Button("Difficile");
    static TheHangmanGames demarrerJeu = new TheHangmanGames();
    
    //Création d'un radioButton      
    static RadioButton RB_langueFrancais = new RadioButton("Français");
    static RadioButton RB_langueAnglais = new RadioButton("Anglais");
    
    /**
    * Methode pour créer et afficher le contenu
    * @param title nom de la fênetre
    */
    public static void nouvelleFenetre(String title){
        
        Stage fenêtreMenu = new Stage();
        fenêtreMenu.initModality(Modality.APPLICATION_MODAL);
        
        Pane pane = new Pane();
        
        Button BT_Fermeture = new Button("Confirmer et jouer");
        //Création d'un checkbox pour les indices
        CheckBox CB_indices = new CheckBox("Oui je les veux !");
        //Création un groupe
        final ToggleGroup languesGroupe = new ToggleGroup();

        //Creation des boutons
        
        //Création du bouton pour commencé le jeu
        Button BTN_DemarrageJeu = new Button();
        BTN_DemarrageJeu.setText("Jouons !");
        
        //MISE EN COMMENTAIRE CAR TEST
        //Ajout dans un groupe pour le groupe français
        //ToggleGroup TG_choixGroupe = new ToggleGroup();
        //TG_choixGroupe.getToggles().addAll(TB_choixfacile, TB_choixDifficile);
 
        //Création d'un nouveau label
        Label LB_utilisateurDifficulte = new Label("Difficulté choisie :");
        
        //Creation d'un label pour les langues
        Label LB_languesLabel = new Label ("Choix de la langue : ");
        
        //Ajout d'un groupe
        RB_langueFrancais.setToggleGroup(languesGroupe);
        RB_langueAnglais.setToggleGroup(languesGroupe);
        
       //creation d'un label pour les indices
        Label LB_indices = new Label("Voulez-vous des indices ?");
        
        //Lorsque le bouton fermer est appuyé vérifier les réglages fait
        BT_Fermeture.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                
                demarrerJeu.demarrageJeu();
                 BT_Fermeture.setOnAction(event->fenêtreMenu.close());
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
        VBox root = new VBox(LB_languesLabel,langueHB,LB_utilisateurDifficulte,HB_boutonChoix,LB_indices,HB_indices, BT_Fermeture);
        root.setSpacing(10);              
        
        pane.getChildren().addAll(root);
        Scene sceneMenu = new Scene(pane, 250,250);
        
        fenêtreMenu.setScene(sceneMenu);
        fenêtreMenu.setTitle(title);
        fenêtreMenu.showAndWait();
        
    }
        /**
         * Fonctionne qui retourne le chemin selon la langue et la difficulté
         * @param nomfichier chemin du fichier
         * @return 
         */
        public String choisirFichier(String nomfichier){
            if(RB_langueAnglais.isPressed()){
                if (!TB_choixfacile.isPressed()){
                    return nomfichier = "/ListMots/an_WordHard";
                }else{
                    return nomfichier = "/ListMots/an_WordsEasy";
                }
                
            }else if(RB_langueFrancais.isPressed()){                
                if (TB_choixfacile.isPressed()){
                    return nomfichier = "/ListMots/fr_MotsFaciles";
                }else{
                    return nomfichier = "/ListMots/fr_MotsDifficiles";
                } 
            }
            return nomfichier;
        }
        
       
    

      
    
    
}
