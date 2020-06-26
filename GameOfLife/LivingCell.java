public class LivingCell implements CellState{
    private int x, y;
    //private int count;
    public LivingCell(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int neighbors(Cell[][] m) {
        int count=0;
        for(int i=x-1; i<=x+1; i++){
            for(int j=y-1; j<=y+1; j++){
                if(inrange(i) && inrange(j)){
                    if(m[i][j].isAlive()){
                        count++;
                    }
                }    
                
            }
        }
        count--;
        return count;
    }

    @Override
    public CellState state(Cell[][] m) {
        int count = neighbors(m);
        //if(x < 3 && y < 3) System.out.println(x+" "+y+" "+count);
        if(underpopulation(count) || overpopulation(count)){
            return new DeadCell(x, y);
        }else return this;
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public boolean reproduction(int count) {
        return false;
    }

    @Override
    public boolean underpopulation(int count) {
        if( count < 2) return true;
        else return false;
    }

    @Override
    public boolean overpopulation(int count) {
        if( count > 3 ) return true;
        else return false;
    }
    
    private boolean inrange(int x){
        if(x>=0 && x<Settings.width) return true;
        else return false;
    }
}