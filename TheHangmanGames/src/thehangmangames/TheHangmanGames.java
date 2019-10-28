/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehangmangames;

import TheHangmanGames.LecteurMots;


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
    
     
     
    
    
     public void start(Stage primaryStage) {
         
         
     }

     
     }
    
