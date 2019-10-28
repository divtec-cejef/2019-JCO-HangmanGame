/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehangmangames;



import java.util.HashMap;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    
    private static final int pointsLettre = 100;
    
    //Mot à deviner
    private SimpleStringProperty mot = new SimpleStringProperty();
    
    //Nombre de lettre à deviner
    private SimpleIntegerProperty lettreADeviner = new SimpleIntegerProperty();
      
    //Score actuelle
     private SimpleIntegerProperty scoreActuel = new SimpleIntegerProperty();
     
     //Le jeu est-il jouable
     private SimpleBooleanProperty jouable = new SimpleBooleanProperty();
     
     
     private ObservableList<Node> lettres;
     
     
    private final HashMap<Character, Text> alphabet = new HashMap<Character, Text>();
    
    private HangmanImage hangman = new HangmanImage();

    private LecteurMots LecteurMot = new LecteurMots();
    
    
    public Parent CreationContenu(){
        HBox ligneLettres = new HBox();
        ligneLettres.setAlignment(Pos.CENTER);
        lettres = ligneLettres.getChildren();
        
        jouable.bind(hangman.live.greaterThan(0).and(lettreADeviner.greaterThan(0)));
        jouable.addListener((obs, old, newValue) ->{
            if(!newValue.booleanValue())
                arretJeu();
        });
        
        Button btnRejouer = new Button("Nouvelle partie !");
        btnRejouer.disableProperty().bind(jouable);
        btnRejouer.setOnAction(event -> demarrageJeu());
        
        HBox ligne1 = new HBox();
        HBox ligne3 = new HBox();
        ligne1.setAlignment(Pos.CENTER);
        ligne3.setAlignment(Pos.CENTER);
        for (int i = 0 ; i < 20; i++) {
            ligne1.getChildren().add(new Lettre(' '));
            ligne3.getChildren().add(new Lettre(' '));
        }
        
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
        texteScore.textProperty().bind(score.asString().concat(" Points"));

        HBox LignePendu = new HBox(10, btnRejouer, texteScore, hangman);
        LignePendu.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10);
        
        // vertical layout
        vBox.getChildren().addAll(
                ligne1,
                ligneLettres,
                ligne3,
                ligneAlphabet,
                LignePendu);
        return vBox;
    }
    private void arretJeu(){
        for (Node n : lettres){
            Lettre lettre = (Lettre) n;
            lettre.show();
            
        }
    }
    private void demarrageJeu(){
        for (Text t : alphabet.values()) {
            t.setStrikethrough(false);
            t.setFill(Color.BLACK);
        }
        //Tirer le mot aléatoirement 
        hangman.reset();
        mot.set(LecteurMots.MotsAleatoires().toUpperCase());
        lettreADeviner.set(mot.length().get());
       
        lettres.clear();
       for (char c : mot.get().toCharArray()){
           lettres.add(new Lettre(c));
       }
    }
    private static class HangmanImage extends Parent {
        private static final int SPINE_START_X = 100;
        private static final int SPINE_START_Y = 20;
        private static final int SPINE_END_X = SPINE_START_X;
        private static final int SPINE_END_Y = SPINE_START_Y + 50;
        

        
    
        
       
     
     
    
    
     public void start(Stage primaryStage) {
         
         
     }

     
     }
    
