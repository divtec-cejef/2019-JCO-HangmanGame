
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
        
    private static final String fichierMots = "/ListMots/mots.txt";
    
    //Création d'une  liste pour les mots
    private ArrayList<String> mots = new ArrayList<String>();
    
   public LecteurMots() {
        try (InputStream in = getClass().getResourceAsStream(fichierMots);
                BufferedReader bf = new BufferedReader(new InputStreamReader(in))) {

            String ligne = "";
            while ((ligne = bf.readLine()) != null)
                mots.add(ligne);
        }
        catch (Exception e) {
            System.out.println("Couldn't find/read file: " + fichierMots);
            System.out.println("Error message: " + e.getMessage());
        }
    }

/**
 * Tire un mot aléatoirement dans la liste
 * @return le mot tirée aléatoirement
 */
    public String MotsAleatoires() {
        if (mots.isEmpty()) return "NO-DATA";
        return mots.get((int)(Math.random()*mots.size()));
    }
}