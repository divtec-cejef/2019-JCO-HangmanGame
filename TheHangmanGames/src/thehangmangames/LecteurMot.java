package thehangmangames;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Cette classe gère ce qui concerne les mots
 * la lecture et le tirage au sort
 * @author mingsop
 */
public class LecteurMot {
    //Chemin du fichier texte par défaut    
    private static final String fichierMots = "/ListMots/fr_MotsFaciles.txt";
    
    private FenetreModal fenetreMenu = new FenetreModal();
    
    //Création d'une  liste pour les mots
    private ArrayList<String> listeMots = new ArrayList<String>();

   /**
    *Ici on fait passer fichierMots pour un flux d'entrée
    *Et on teste si la lecture du fichier est terminée
    *Si la Fichier est vide ou introuvable une erreur est déclenché
    */
   public LecteurMot() {
       //Choisir le fichier selon le choix dans le menu
       fenetreMenu.choixDifficulté(fichierMots);
       //InputStream -> Es utilisé pour lire des données d'une sources
        try (InputStream lectureDonnées = getClass().getResourceAsStream(fichierMots);
                //BufferedReader -> Lit un texte à partir d'un flux d'entrée
                BufferedReader lecteurFluxEntrée = new BufferedReader(new InputStreamReader(lectureDonnées))) {

            String ligne = "";
            while ((ligne = lecteurFluxEntrée.readLine()) != null)
                listeMots.add(ligne);
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
    public String MotAleatoire() {
        if (listeMots.isEmpty()) return "Aucunes données";
        return listeMots.get((int)(Math.random()*listeMots.size()));
    }  
}