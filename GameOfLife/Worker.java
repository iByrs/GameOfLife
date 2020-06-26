import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**Classe che si occupa di gestire gli input da tastiera*/
public class Worker {
    
    private static Scanner scanner = new Scanner (System.in);
    private static String scan = ",";
    private static int count = 0;
    private static String supp = "";
    


    public static String takeInput(){
        return scanner.next();
    }

    public static List<Integer> takeConfiguration(){
        List <Integer> custom = new ArrayList <>();
        System.out.println("Please insert any pair of number such as [x,y]. Digit ''quit'' to exit; ");
        while(getPair(custom));
        return custom;
    }

    private static boolean getPair(List<Integer> l){
        System.out.print("=> ");
        scan = takeInput();
        if(quit(scan)){
            return false;
        }else{
            resetSupp();
            resetCount();
            int X = extractNumber(scan);
            count ++;
            resetSupp();
            int Y = extractNumber(scan);
            insert(l, X, Y);
            return true;
        }
    }

    private static boolean quit(String x){
        if(x.contains("quit")) return true;
        else return false;
    }

    private static int extractNumber(String scanned){
        while((count<scanned.length()) && (scanned.charAt(count )!=',')){
            supp+=scanned.charAt(count++);
        }
        return alert(supp);
    }

    private static void resetSupp(){
        supp = "";
    }

    private static void resetCount(){
        count = 0;
    }

    private static int alert(String s){
        try{
            int x = Integer.parseInt(s);
            return x;
        }catch(NumberFormatException nfe){
            return -1;
        }
    }

    private static boolean check(int x){            
        if((x<0) || (x>Settings.width-1)){
            return false;
        }else return true;
    }

    private static void insert(List <Integer > l, int X, int Y){
        if((check(X)) && (check(Y))){
            l.add(X);
            l.add(Y);
        }else System.out.println("Pair of number not valid; ");
    }

    
}