import java.util.List;

/**
 * Concrete Observer, dove prenderà le informazioni da Model e li rappresenterà
 * nella mappa
 */

public class GameBoard implements Observer {

    private static GameBoard obj;
    private int height;
    private int width;
    private char[][] field;

    private Counter score;

    private GameBoard() {
        height = Settings.height;
        width = Settings.width;
        field = new char[height][width];
        score = Counter.getInstance();
        setup();
    }

    public static GameBoard getInstance() {
        if (obj == null)
            obj = new GameBoard();
        return obj;
    }

    private void setup() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                field[i][j] = '-';
            }
        }
    }

    public void showField() {
        printScore();
        printBoard();
        printLowBoard();
    }

    private void printBoard() {
        System.out.print("   ");
        for (int i = 0; i < width; i++) {
            printLine(i);
        }
        newLine();
    }

    private void newLine() {
        System.out.println();
    }

    private void printLowBoard() {
        for (int i = 0; i < height; i++) {
            printLine(i);
            for (int j = 0; j < width; j++) {
                printCell(i, j);
            }
            newLine();
        }
    }

    private void printLine(int i) {
        if (i < 10)
            System.out.print(" " + i + " ");
        else
            System.out.print(i + " ");
    }

    private void printCell(int i, int j) {
        System.out.print(" " + field[i][j] + " ");
    }

    private void printScore() {
        System.out.println("Record: " + score.getRecord() + "      Score: " + score.getCount());
    }

    private void printCell(Cell[][] m, int i, int j){
        if(m[i][j].isAlive()) field[i][j] = '*';
        else field[i][j] = '-';
    }

    @Override
    public void update(Subject o, Cell[][] m) {
       for(int i=0; i<height; i++){
           for(int j=0; j<width; j++){
                printCell(m, i, j);
           }
       }
    }

    @Override
    public void update(Subject o, List<Integer> l) {
        return;
    }

    
}