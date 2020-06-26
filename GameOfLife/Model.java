import java.util.List;

public class Model extends Subject implements Observer {
    
    private static Model obj;
    private Cell[][] game ;
    private Cell[][] supp ;
    private int height = Settings.height;
    private int width = Settings.width;
    
    private Model() {
        game = new Cell[height][width];   
        supp = new Cell[height][width];
        setupGame();
    }

    public static Model getInstance() {
        if (obj == null)
            obj = new Model();
        return obj;
    }

    private void setupGame() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                game[i][j] = new Cell(i, j, 0);
            }
        }
        setChanged();
        notify(game);
    }

   
    public void nextGeneration() {
        setupSupp();
        checkState();
        game = supp;
        setChanged();
        notify(game);
    }

    private void setupSupp(){
        supp = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                supp[i][j] = new Cell(i, j, 1);
            }
        }
    }
    private void checkState(){
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){ 
                supp[i][j].setCellState(game[i][j].state(game));
            }
        }
    }
    @Override
    public void update(Subject o, Cell[][] m) {                             //MOTIVI DI TRASPARENZA
       return;  
    }

    @Override
    public void update(Subject o, List<Integer> l) {
       readConfiguration(l);
    }

    private void readConfiguration(List<Integer> l){                        //LEGGERE LA LISTA
        for(int i=0; i<l.size()-1; i+=2){
            game[l.get(i)][l.get(i+1)]=new Cell(l.get(i), l.get(i+1), 1);
        }
        setChanged();
        notify(game);
    }

    public boolean untilHasLife(){
        int count = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(game[i][j].isAlive()) count ++;
            }
        }
        return (count > 0);
    }

}