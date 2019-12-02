package thehangmangames;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mingsop
 */
public class LecteurMots {
        
    private static final String fichierMots = "/ListMots/fr_MotsFaciles.txt";
    
    //Choisir la difficulté selon le choix du menu
    
    
    //Création d'une  liste pour les mots
    private ArrayList<String> mots = new ArrayList<String>();

   
   public LecteurMots() {
       //Ici on fait passer fichierMots pour un flux d'entrée
       //Et on teste si la lecture du fichier est terminée
       //Si la Fichier est vide ou introuvable une erreur est déclenché
        try (InputStream in = getClass().getResourceAsStream(fichierMots);
                BufferedReader bf = new BufferedReader(new InputStreamReader(in))) {

            String ligne = "";
            while ((ligne = bf.readLine()) != null)
                mots.add(ligne);
        }
        catch (Exception e) {
            System.out.println("Nous n'arrivons pas à lire trouver le fichier : " + fichierMots);
            System.out.println("Message d'erreur : " + e.getMessage());
        }
    }

/**
 * Tire un mot aléatoirement dans la liste
 * @return le mot tirée aléatoirement
 */
    public String MotsAleatoires() {
        if (mots.isEmpty()) return "Aucunes données";
        return mots.get((int)(Math.random()*mots.size()));
    }
    
   //methode pour les boutons choix difficultés
   
}