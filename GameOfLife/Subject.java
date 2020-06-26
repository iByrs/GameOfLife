import java.util.ArrayList;
import java.util.List;

public class Subject {
    
    private boolean changed = false;
    
    private List<Observer> subscribers=new ArrayList<>();

    public void notify(Cell[][] m){                   //NOTIFICA AI SUOI SOTTOSCRITTI
        if(!changed) return;
        subscribers.stream().forEach(x -> x.update(this, m));
        changed = false;
    }
    
    public void notify(List<Integer> l){
        if(!changed) return;
        subscribers.stream().forEach(x -> x.update(this, l));
    }

    public void setChanged(){                       //MODIFICA IL SUO STATO
        this.changed=true;
    }

    public void attach(Observer o){                 //ATTACCA UN OBSERVER
        subscribers.add(o);
    }

    public void detach(Observer o){                 //RIMUOVE UN OBSERVER
        subscribers.remove(o);
    }
    
}