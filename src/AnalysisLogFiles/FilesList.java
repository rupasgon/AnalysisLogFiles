/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalysisLogFiles;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author uidb499s
 */
public class FilesList {
    
    Date today;
    String sDirectorio;
    File f;
    File lastFile;
    
    
    public FilesList(){
        
        this.today = new Date();
        this.sDirectorio = null;
        lastFile = null;
        
        
    }
    
    public File[] getFileList(String hostName){
        
        File[] files = null;
        
        
        return files;
    }
    
    
    public File getFolders(String hostName){
        
        this.today = new Date();
        
        SimpleDateFormat dia = new SimpleDateFormat("dd");
        SimpleDateFormat mes = new SimpleDateFormat("MM");
        SimpleDateFormat ano = new SimpleDateFormat("yyyy");
        
        System.out.println(dia.format(today));
        System.out.println(mes.format(today));
        System.out.println(ano.format(today));
        
        this.sDirectorio = "\\\\" + hostName + "\\Data\\Workstation\\Logs\\" + ano.format(today) + "\\" + mes.format(today) + "\\" + dia.format(today) + "\\";

        //this.sDirectorio = "D:\\test\\" + ano.format(today) + "\\" + mes.format(today) + "\\" + dia.format(today) + "\\";
        System.out.println("La URL del directorio de archivos es: " + sDirectorio);
        
        File f = new File(sDirectorio);
        
        if(f!=null){
            
            System.out.println(sDirectorio);
            
            try {
                
                File[] files = f.listFiles();
            
                if(files.length<=0){
                
                    System.out.println("No hay archivos en el directorio: " + sDirectorio);
                
                }else{
            
                    long firstModifiet;
                    long lastModifiet=0;
                    //File lastFile = null;
                
                    for (int x=0;x<files.length;x++){
                    
                    firstModifiet = files[x].lastModified();
                
                    if(firstModifiet>lastModifiet){
                        
                        lastModifiet=firstModifiet;
                        lastFile = files[x];
                        
                    }
                    
                    System.out.println(files[x].getName()+" - " + files[x].lastModified());
                
                }
                
                System.out.println(lastFile.getName());
                
                
                
                
            }    
                
            } catch (Exception e) {
                
                System.out.println("No se ha podido cargar los archivos - " + e.getMessage());
                
            }
            
        }
        else{
            
            System.out.println("NO FUNCIONA ES NULL");
            
        }
    
        return lastFile;
    }
    
    
    
}
