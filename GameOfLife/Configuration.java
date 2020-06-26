
import java.util.List;

public class Configuration extends Subject {
    private List<Integer> custom;

    private static Configuration obj;

    private Configuration() {
    }

    public static Configuration getInstance() {
        if (obj == null) obj = new Configuration();
        return obj;
    }

    public void setArcorn() {
        custom = Reader.loadSave("Arcorn");
        setChanged();
        notify(custom);
    }

    public void setDieHard()  {
        custom = Reader.loadSave("Diehard");
        setChanged();
        notify(custom);
    }

    public void setCustom(List <Integer> l){
        custom = l;
        setChanged();
        notify(custom);
    }

    public boolean customStatus(){
        if( (custom != null) && !(custom.isEmpty()) ) return true;
        return false;
    }
    public void resetCustom(){
        custom.clear();
    }
    public List<Integer> getCustom(){
        return custom;
    }
    
    public void reset(){
        setChanged();
        notify(custom);
    }
}