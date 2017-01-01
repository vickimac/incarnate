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
 * Retrieves a string of text from a dialog file depending on the ID required.
 * Allows for dynamic retrieval of dialog from disk, rather than having to hard
 * code each piece of dialog to the code itself.
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public class DialogText {
    
    /**
     * Opens the specified file and retrieves an array containing all dialog that
     * has been assigned with the specified ID.
     * 
     * @param folderName    Name of the folder containing the file to be retrieved.
     *                      May be area or NPC specific.
     * @param fileName      Name of the file to be retrieved. May be area or NPC
     *                      specific.
     * @param diaID         ID of the pieces of dialog required. May be multiple.
     * 
     * @return  dialog      Array of all lines of dialog of the specified ID.
     * 
     * @throws IOException  If the file cannot be found or read.
     */
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
                if(id.equals(line.substring(0,7)))
                {
                    
                    diaCounter++;
                }
            }
        } catch (IOException x) {
            System.err.format("IOException %s%n", x);
        }
        dialog = new String[diaCounter];
        
        try (BufferedReader reader = Files.newBufferedReader(path, charset))
        {
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                if(id.equals(line.substring(0,7)))
                {
                    dialog[i] = line.substring(8);
                    i++;
                }
            }
        } catch (IOException x) {
            System.err.format("IOException %s%n", x);
        }
        
        return dialog;
    }
}
