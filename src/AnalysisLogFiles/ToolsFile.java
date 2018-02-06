/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalysisLogFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.util.converter.FormatStringConverter;

/**
 *
 * @author uidb499s
 */
public class ToolsFile {
    
    public static String lecturaArchivo(File file)throws FileNotFoundException,IOException{
        
        
        String cadena = null;
        StringBuilder sb = new StringBuilder();
        
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        
        while(b.readLine()!=null){
            
            cadena = b.readLine() + "\n";
            
            if(/*cadena.indexOf("| x |")> -1 ||*/ cadena.indexOf("| ! |") > -1 /*|| cadena.indexOf("Error")> -1*/){
                
                sb.append(cadena);
                
            }
            
            
           
            
        }
        
       f.close();
       return sb.toString(); 
    }
    
    
}
