/**
 * Cell svolge il ruolo di context, il sistema conoscerà il Cell e non il tipo generale CellState e le sue varie implementazioni
 */
public class Cell{

    private CellState cell ;

    public Cell(int x, int y, int life){
        if(life == 0) cell = new DeadCell(x, y);
        else cell = new LivingCell(x, y);
    }

    public boolean isAlive(){
        return cell.isAlive();
    }

    public CellState state(Cell[][] m){
        return cell.state(m);
    }
    
    public void setCellState(CellState c){
        cell = c;
    }
       
}