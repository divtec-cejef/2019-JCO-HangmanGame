package thehangmangames;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Cette classe est utilisé pour ce qui concerne le tirage du mot et la lecture 
 * Dans le fichier
 * @author mingsop
 */
public class LecteurMot {
        
    private static final String fichierMots = "";
    
    
    private FenetreModal fenetreMenu = new FenetreModal();

    
    //Création d'une  liste pour les mots
    private ArrayList<String> listeMots = new ArrayList<String>();

   /**
    *Ici on fait passer fichierMots pour un flux d'entrée
    *Et on teste si la lecture du fichier est terminée
    *Si la Fichier est vide ou introuvable une erreur est déclenché
    */
   public LecteurMot() {
       fenetreMenu.choisirFichier(fichierMots);
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
        if (listeMots.isEmpty()) return "aucune donnee";
        return listeMots.get((int)(Math.random()*listeMots.size()));
    }  
}