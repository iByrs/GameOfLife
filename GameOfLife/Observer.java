import java.util.List;
/** Interfaccia Observer */

public interface Observer{
    public void update(Subject o, Cell[][] m);

    public void update(Subject o, List<Integer> l);
}