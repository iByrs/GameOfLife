import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/** Classe che si occupa della gestione di scrittura e lettura */

public class Writer {
    private static String path;

    public static boolean writeNewRecord(int record){
        path = getPathRecord();
        return write(path, String.valueOf(record));
    }

    public static boolean writeSave(String name, int record, List <Integer> l){
        path = getPathSaves(name);
        String list = extractList(l);
        return write(path, name, list, record);
    }

    private static boolean write(String p, String c) {
        try{
            File file = new File(p);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(c);
            bw.flush();
            bw.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }

    private static boolean write(String p, String name, String l, int record){
        try{
            File file = new File(p);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(stringSaves(name, l, record));
            bw.flush();
            bw.close();
            return true;
        }catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String getPathRecord(){
        return (System.getProperty("user.dir") + "/Record/Record.txt");
    }

    private static String getPathSaves(String p){
        return (System.getProperty("user.dir") + "/Saves/"+p+".txt");
    }

    private static String extractList(List < Integer > l){
        String list=l.stream().map(x -> String.valueOf(x)).reduce("", (s, t) -> s + ',' +t);
        return list;
    }
    
    private static String stringSaves(String name, String list, int record){
        return (name+":"+list+"::"+record+":");
    }

}
