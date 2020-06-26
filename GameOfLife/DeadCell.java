public class DeadCell implements CellState{
    
    private int x,y;

    public DeadCell(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int neighbors(Cell[][] m) {
        int count=0;
        for(int i=x-1; i<=x+1; i++){
            for(int j=y-1; j<=y+1; j++){
                if(inRange(i) && inRange(j)){
                    if(m[i][j].isAlive()){
                        count++;
                    }
                }    
            }
        }
        return count;
    }

    @Override
    public CellState state(Cell[][] m) {
       int count = neighbors(m);
       if(reproduction(count)) return (new LivingCell(x, y));
       else return this;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public boolean reproduction(int count) {
        return (count == 3);
    }

    @Override
    public boolean underpopulation(int count) {
        return false;
    }

    @Override
    public boolean overpopulation(int count) {
        return false;
    }

    private boolean inRange(int index){
        if(index >= 0 && index<Settings.width) return true;
        else return false;
    }

}