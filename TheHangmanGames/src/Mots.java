/*}
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import thehangmangames.Menu;

/**
 *
 * @author mingsop
 */
public class Mots {
    
  public static void main(String[] args) {
    //Lire le fichier texte et choisir un mot aléatoire dedant
    //En attendant de trouver la solution, j'ai mit des mots dans un tableau
    
    String tableauMotsFacile[] = {"Vent","Table","Chaton","Rire","Simple"};
    
    //String tableauMotsMoyen[] = {"Zebre","Rotule","cachalot","accolader","igloo"};
    //String tableauMotsDifficile[] = {"rempaillage","rénaux","fébrilement","zygopétale"}; 
    
    //Choisir un mot aéléatoirement
    int nombreAleatoire = 0;
    nombreAleatoire = (int)(Math.random()* tableauMotsFacile.length); 
    String motADeviner = tableauMotsFacile[nombreAleatoire];
    
    
}
  
  
  
  
}
