import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Reader {
    private static String path;
    private static int size;
    private static char[] buffer = new char[100];
    private static int record;

    public static int loadRecord(){
        path = getPathRecord();
        resetBuffer();
        readRecord(path);
        return record;
    }


    public static List<Integer> loadSave(String save)  {
        path = getPathSaves(save);
        resetBuffer();
        if(readSave(path)) return catchList();
        else return Arrays.asList(0,0);
    }

    public static void printSave(String save)  {
        path = getPathSaves(save);
        resetBuffer();
        readSave(path);
        printBuffer();
    }

//////////////////////////////////////////////////////////////////
    private static void resetBuffer(){
        size = 0;
        buffer = new char[100];
    }

    private static boolean readRecord(String p){
        try{
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            size = br.read(buffer);
            record = Integer.parseInt(extractFromBuffer(size));
            br.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    private static boolean readSave(String p)  {
        try{
            File file = new File(p);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            br.read(buffer);
            br.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }

    private static String extractFromBuffer(int size){
        String x = "";                              //FARE UN METODO CHE PRENDE 
        for(int i=0; i<size; i++) x += buffer[i];
        return x;
    }
    
    private static String getPathRecord(){
        return (System.getProperty("user.dir") + "/Record/Record.txt");
    }

    private static String getPathSaves(String p){
        return (System.getProperty("user.dir") + "/Saves/"+p+".txt");
    }


    private static List<Integer> catchList(){
        List <Integer> l=new ArrayList<>();
        String y="";
        nextHop();
        size++;         //:
        size++;         //,
        while(buffer[size] != ':' ){
            y="";
            while(buffer[size]!=',' && buffer[size]!=':'){
                y+=buffer[size++];
            }
            l.add(Integer.parseInt(y));
            size++;
        }
        return l;
    }

    private static void nextHop(){
        while(buffer[size] != ':') size++;
    }

    private static void printBuffer(){
        for(int i=0; i<size; i++){
            System.out.print(buffer[i]);
        }
    }

}