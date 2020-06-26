/** Terrà conto del punteggio del gioco */

public class Counter {
    private int count;
    private int record;
    private static Counter obj;
    
    private Counter (){
        count = 0;
        readRecord();
    }

    
    public static Counter getInstance(){
        if(obj == null) obj = new Counter();
        return obj;
    }

    public void setCount(){
        count = 0;
    }

    private void setNewRecord(int c){
        record = c;
    }

    public void increaseCount(){
        count ++;
    }

    public boolean newRecord(){
        if( count > record ) return true;
        else return false;
    }

    public int getCount(){
        return count;
    }

    public int getRecord(){
        return record;
    }

    private boolean writeRecord(){
        return Writer.writeNewRecord(record);
    }

    public void readRecord(){
        record = Reader.loadRecord();
    }

    public void writeNewRecord(int c){
        setNewRecord(c);
        writeRecord();
    }   

}