public interface CellState {
    
    public int neighbors(Cell[][] m);
    public CellState state(Cell[][] m);
    public boolean isAlive();
    // I METODI CHE CALCOLERANNO LO STATO DI UNA CELLA;
    public boolean reproduction(int count);
    public boolean underpopulation(int count);
    public boolean overpopulation (int count);

}