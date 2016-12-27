/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.framework.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/**
 *
 * @author Vicki
 */
public class DialogText {
    
    public String[] openDialog(String folderName, String fileName, String diaID) throws IOException
    {
        String[] dialog;
        int i = 0;
        int diaCounter = 0;
        int partCounter = 0;
        String filePath = new File("").getAbsolutePath();
        Path path = Paths.get(filePath+"/src/resources/dialog/"+folderName+"/"+fileName+".dialog");
        String id = "ID:"+diaID;
        
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(path, charset))
        {
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
                System.out.println(id);
                System.out.println(line.substring(0,7));
                if(id.equals(line.substring(0,7)))
                {
                    
                    diaCounter++;
                }
            }
        } catch (IOException x) {
            System.err.format("IOException %s%n", x);
        }
        System.out.println("diaCounter="+diaCounter);
        dialog = new String[diaCounter];
        
        try (BufferedReader reader = Files.newBufferedReader(path, charset))
        {
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                if(id.equals(line.substring(0,7)))
                {
                    dialog[i] = line.substring(8);
                    System.out.println("dialog["+i+"] = " + dialog[i]);
                    i++;
                }
            }
        } catch (IOException x) {
            System.err.format("IOException %s%n", x);
        }
        
        return dialog;
    }
}
