/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 *
 * @author param
 */
public class Note implements Serializable {
    private String title;
    private String contents;
    
    public Note(String path)
    {
        
        try
        {
            
            // to read files
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            
            
            title = br.readLine();
            contents = br.readLine();
            br.close();
        }
        catch(FileNotFoundException FNFex)
        {
            FNFex.printStackTrace();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void saveNote(String path)
    {
        PrintWriter pw;
        // to write to a file
        try
        {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
            pw.print(this.title + "\n" + this.contents);
        }
        catch(FileNotFoundException FNFex)
        {
            FNFex.printStackTrace();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setContents(String contents)
    {
        this.contents = contents;
    }
    public String getContents()
    {
        return contents;
    }
    public String getTitle()
    {
        return title;
    }
}
