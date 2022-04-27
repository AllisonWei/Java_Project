/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author harshalneelkamal
 */
public class DataReader {
    
    private BufferedReader reader;
    private String[] header;
    private String path="D:/gitnew/Leqi_Wei_001561748/assignment4/Person.xlsx";
    
    public DataReader() throws FileNotFoundException {
        File file = new File(path);
        if(!file.exists())
            throw new FileNotFoundException("File not found at the path specified: "+path);
        reader = new BufferedReader(new FileReader(file));
    }
    
    public String[] getNextRow() throws IOException{
        if (header == null)
            header = getFileHeader();
        String line = "";
        if((line = reader.readLine()) != null){
            String[] rows = line.split(",");
            return rows;
        }
        return null;
    }
    
    public String[] getFileHeader() throws IOException{
        if(header == null){
            String line = "";
            if((line = reader.readLine()) != null){
                String[] rows = line.split(",");
                header = rows;
            }
        }
        return header;
    }
    
    
}
