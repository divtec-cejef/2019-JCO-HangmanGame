/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehangmangames;



import java.util.HashMap;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;



/**
 *
 * @author mingsop
 */
public class TheHangmanGames extends Application {
    private static final int APP_W = 900;
    private static final int APP_H = 500;
    
    private static final Font DEFAULT_FONT = new Font("Courier", 36);
    private static final float BONUS_MODIFIER = 0.2f;
    
    private static final int pointsLettre = 100;
    
    //Mot à deviner
    private SimpleStringProperty mot = new SimpleStringProperty();
    
    //Nombre de lettre à deviner
    private SimpleIntegerProperty lettreADeviner = new SimpleIntegerProperty();
      
    //Score actuelle
     private SimpleIntegerProperty scoreActuel = new SimpleIntegerProperty();
     
     private float scoreAModifier = 1.0f;
     
     //Le jeu est-il jouable
     private SimpleBooleanProperty jouable = new SimpleBooleanProperty();
     
     //Instancier la fenêtre "modal"
     testModalWindows FenetreModal = new testModalWindows();
     
     private ObservableList<Node> lettres;
     
     
     
     
    private final HashMap<Character, Text> alphabet = new HashMap<Character, Text>();
    
    private HangmanImage hangman = new HangmanImage();

    private LecteurMot LecteurMot = new LecteurMot();

    public Parent CreationContenu(){
        HBox ligneLettres = new HBox();
        ligneLettres.setAlignment(Pos.TOP_CENTER);
        lettres = ligneLettres.getChildren();
        
        jouable.bind(hangman.coups.greaterThan(0).and(lettreADeviner.greaterThan(0)));
        jouable.addListener((obs, old, newValue) ->{
            if(!newValue.booleanValue())
                arretJeu();
        });
        
        Button btnRejouer = new Button("Nouvelle partie !");
        btnRejouer.disableProperty().bind(jouable);
        btnRejouer.setOnAction(event -> demarrageJeu());
        
        HBox ligneAlphabet = new HBox(5);
        ligneAlphabet.setAlignment(Pos.CENTER);
        
        for (char c = 'A'; c <= 'Z'; c++) {
            Text t = new Text(String.valueOf(c));
            t.setFont(DEFAULT_FONT);
            alphabet.put(c, t);
            ligneAlphabet.getChildren().add(t);
        }

        Text tiret = new Text("-");
        tiret.setFont(DEFAULT_FONT);
        alphabet.put('-', tiret);
        ligneAlphabet.getChildren().add(tiret);

        Text texteScore = new Text();
        texteScore.textProperty().bind(scoreActuel.asString().concat(" Points"));

        HBox LignePendu = new HBox(10, btnRejouer, texteScore, hangman);
        LignePendu.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10);
        
        // Ajout élément graphique verticals
        vBox.getChildren().addAll(

                ligneLettres,
                ligneAlphabet,
                LignePendu);
        return vBox;
    }
    /**
     * Fonction qui décrit ce qui se passe à l'arrêt de jeu
     */
    private void arretJeu(){
        for (Node n : lettres){
            Lettre lettre = (Lettre) n;
            lettre.montrer();
            
        }
    }
    
    /**
     * Fonctionne qui décrit ce qui se passe au démarrage du jeu
     */
    private void demarrageJeu(){
        
        
        for (Text t : alphabet.values()) {
            t.setStrikethrough(false);
            t.setFill(Color.BLACK);
        }
        //Tirer le mot aléatoirement 
        hangman.reset();
        mot.set(LecteurMot.MotsAleatoires().toUpperCase());
        lettreADeviner.set(mot.length().get());
       
        lettres.clear();
       for (char c : mot.get().toCharArray()){
           lettres.add(new Lettre(c));
           
           
       }
       
    }
    
    /**
     * Classe qui dessine le pendue
     */
    private static class HangmanImage extends Parent {
        private static final int SPINE_START_X = 100;
        private static final int SPINE_START_Y = 20;
        private static final int SPINE_END_X = SPINE_START_X;
        private static final int SPINE_END_Y = SPINE_START_Y + 50;
        
        
        //Trouver le nombre de coup qui restent
        private SimpleIntegerProperty coups = new SimpleIntegerProperty();
        public HangmanImage(){
            Circle tete = new Circle(20);
            tete.setTranslateX(SPINE_START_X);

            Line corps = new Line();
            corps.setStartX(SPINE_START_X);
            corps.setStartY(SPINE_START_Y);
            corps.setEndX(SPINE_END_X);
            corps.setEndY(SPINE_END_Y);
            
            Line brasGauche = new Line();
            brasGauche.setStartX(SPINE_START_X);
            brasGauche.setStartY(SPINE_START_Y);
            brasGauche.setEndX(SPINE_START_X + 40);
            brasGauche.setEndY(SPINE_START_Y + 10);
            
            Line brasDroit = new Line();
            brasDroit.setStartX(SPINE_START_X);
            brasDroit.setStartY(SPINE_START_Y);
            brasDroit.setEndX(SPINE_START_X - 40);
            brasDroit.setEndY(SPINE_START_Y + 10);
            
            Line jambeGauche = new Line();
            jambeGauche.setStartX(SPINE_END_X);
            jambeGauche.setStartY(SPINE_END_Y);
            jambeGauche.setEndX(SPINE_END_X + 25);
            jambeGauche.setEndY(SPINE_END_Y + 50);

            Line jambeDroite = new Line();
            jambeDroite.setStartX(SPINE_END_X);
            jambeDroite.setStartY(SPINE_END_Y);
            jambeDroite.setEndX(SPINE_END_X - 25);
            jambeDroite.setEndY(SPINE_END_Y + 50);
            
            getChildren().addAll(tete, corps, brasGauche, brasDroit, jambeGauche, jambeDroite);
            coups.set(getChildren().size());          
        }
        
        /**
         * Reset le jeu
         */
        public void reset(){
            getChildren().forEach(node -> node.setVisible(false));
            coups.set(getChildren().size());
        }

        public void retirerVie() {
            for (Node n : getChildren()) {
                if (!n.isVisible()) {
                    n.setVisible(true);
                    coups.set(coups.get() - 1);
                    break;
                }
            }
        }
    }

    
    private static class Lettre extends StackPane {
        private Rectangle rectangle = new Rectangle(40, 60);
        private Text text;
        
        
        /**
         * 
         * @param lettre 
         */    
        public Lettre(char lettre) {
            rectangle.setFill(lettre == ' ' ? Color.DARKSEAGREEN : Color.WHITE);
            //Ligne de séparation de couleur ROSE
            rectangle.setStroke(Color.PINK);

            text = new Text(String.valueOf(lettre).toUpperCase());
            text.setFont(DEFAULT_FONT);
            text.setVisible(false);

            setAlignment(Pos.CENTER);
            getChildren().addAll(rectangle, text);
        }
        
        /**
         * Méthode pour animer l'affichage de la lettre
         */
        public void montrer(){
            RotateTransition rotationTransition = new RotateTransition(Duration.seconds(1), rectangle);
            rotationTransition.setAxis(Rotate.Y_AXIS);
            rotationTransition.setToAngle(180);
            rotationTransition.setOnFinished(event -> text.setVisible(true));
            rotationTransition.play(); 
            }
        
        /**
         * @return On returne vrai ou faux si la lettre tappée est égale 
         * à la lettre présente dans le mot
         */
        public boolean estEgalA(char autre) {
            return text.getText().equals(String.valueOf(autre).toUpperCase());
        }
    }
    
    public void start(Stage primaryStage) throws Exception {
        
        Scene scene = new Scene(CreationContenu());
        
        //Scène du menu avec une modal window
        StackPane secondaryLayout = new StackPane();
        Scene menuScene = new Scene(secondaryLayout, 230,100);
        
        // New window (Stage)
        Stage menuFenetre = new Stage();
        menuFenetre.setTitle("Menu");
        menuFenetre.setScene(menuScene);
        // Specifies the modality for new window.
        menuFenetre.initModality(Modality.WINDOW_MODAL);
 
        // Specifies the owner Window (parent) for new window
        menuFenetre.initOwner(primaryStage);
 
        // Set position of second window, related to primary window.
        menuFenetre.setX(primaryStage.getX() + 200);
        menuFenetre.setY(primaryStage.getY() + 100);
       

        menuFenetre.show();
        
        
        scene.setOnKeyPressed((KeyEvent event) -> {
            
            if (event.getText().isEmpty())
                return;        
            
            char touchePressee = event.getText().toUpperCase().charAt(0);
            if ((touchePressee < 'A' || touchePressee > 'Z') && touchePressee != '-')
                return;
            
            if (jouable.get()) {
                Text t = alphabet.get(touchePressee);
                if (t.isStrikethrough())
                    return;
                
                 // Noté que la lettre a été choisi
                t.setFill(Color.RED);
                t.setStrikethrough(true);
                
                boolean trouver = false;
                
                for (Node n : lettres){
                    Lettre lettre = (Lettre) n;
                    if(lettre.estEgalA(touchePressee)){
                        trouver = true;
                        scoreActuel.set(scoreActuel.get()+(int)(scoreAModifier  * pointsLettre));
                        lettreADeviner.set(lettreADeviner.get()- 1);
                        lettre.montrer();
                    }
                }
                if(!trouver){
                    hangman.retirerVie();
                    scoreAModifier = 1.0f;
                }
                else{
                    scoreAModifier+=BONUS_MODIFIER;
                }
            }
        });
        
        
        
        primaryStage.setResizable(false);
        primaryStage.setWidth(APP_W);
        primaryStage.setHeight(APP_H);
        primaryStage.setTitle("Jeu du pendue || Jeu");
        primaryStage.setScene(scene);
        primaryStage.show();
        demarrageJeu();
    }
    
    public static void main(String[] args){
        launch(args);
     } 
}
   

     
     
