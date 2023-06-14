package fr.greg.hollowfile;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * Fonctionnalités à venir :
 * 
 * se déplacer de répertoire (. et ..) 
 * retourner au chemin précédent  
 * créer un fichier 
 * déplacer un ficher (ou plusieurs)
 * renommer un ficher (ou plusieurs) 
 * supprimer un ou plusieurs fichiers
 * 
 * Bonus: voir les données d'un fichier 
 * modifier les données d'un fichier 
 * coder ?, *, et |
 * rechercher un fichier (ou plusieurs) 
 * différents types de fichiers en différentes couleurs
 * 
 * Fonctions secondaires : randomiser les noms des fichiers d'un dossier 
 * Gerer des permissionsutilisateur sur la lecture, l'écriture, et l'execution
 */

public class App 
{   
    public static void menu() {
        
        System.out.println("\nChoisissez votre option :");
        System.out.println("1 - Repertoire actuel");
        System.out.println("2 - Contenu du repertoire actuel");
        System.out.println("3 - Changer de répertoire");
        System.out.println("*****************************************************");
        System.out.println("(Entrez -1 pour fermer le programme)");
    }
       
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println("*****************************************************");
        System.out.println("********* Hollow File - Gestion de fichiers *********");
        System.out.println("*************** Par Gregoire Bouteillier ************");
        System.out.println("*****************************************************");

        String cd = System.getProperty("user.dir"); // recupération du repertoire actuel
        
        menu();

        while (!sc.hasNextInt()) {
        System.out.println("Veuillez entrer un entier valide !");
        sc.next(); // Consommer l'entrée invalide
        }
        choice = sc.nextInt();

        while (choice != -1)
         {
            switch (choice) 
            {
                case 1:
                    System.out.println("Votre repertoire actuel :\n" + cd);
                    break;

                case 2:
                    System.out.println("Contenu du répertoire :");
                    try 
                    {
                        HFMethods.testDirectoryStream(cd); // affichage du contenu du repertoire actuelle (fichiers et dossiers)
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Entrez le chemin absolu du nouveau répertoire :");
                    try 
                    {
                        cd = HFMethods.changeDirectory(sc.next(), cd); // permet d'entrer un nouveau repertoire

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                System.out.println("Option indisponible !");
                    break;
                    
            }
            
        menu();

        while (!sc.hasNextInt()) {
        System.out.println("Veuillez entrer un entier valide !");
        sc.next(); // Consommer l'entrée invalide
        }
        choice = sc.nextInt();

        }
    }
}

