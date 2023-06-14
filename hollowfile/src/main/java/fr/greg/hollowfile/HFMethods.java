package fr.greg.hollowfile;

import java.nio.file.DirectoryStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class HFMethods {
    
    public static void testDirectoryStream(String in) throws IOException 
    {
        Path cdin = Paths.get(in);
        DirectoryStream<Path> stream = Files.newDirectoryStream(cdin);
        try 
        { 
          Iterator<Path> iterator = stream.iterator();
          while(iterator.hasNext()) 
          {
            Path p = iterator.next();
            System.out.println(p); 
          }
        } finally 
        { 
          stream.close(); 
        }
    }

    public static String changeDirectory(String sc, String cd) throws IOException 
    {
                   
                    String newDirectory = sc;
                    File directory = new File(newDirectory);

                    if (directory.isDirectory()) {
                        cd = directory.getAbsolutePath(); // Mettre à jour le répertoire actuel
                        System.out.println("Répertoire changé avec succès !");
                    } else {
                        System.out.println("Le chemin spécifié n'est pas un répertoire valide !");
                    }

                    return cd;
        
    }
}
