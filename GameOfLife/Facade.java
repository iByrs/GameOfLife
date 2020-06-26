import java.util.List;


public class Facade implements Runnable{
    private GameBoard field = GameBoard.getInstance();
    private Model model = Model.getInstance();
    private Configuration configuration = Configuration.getInstance();
    private Counter count = Counter.getInstance();
    private static String input;
    
    public Facade(){
        model.attach(field);
        configuration.attach(model);
    }

/////////START/////////////////////////////////////////////////////////
    
    public void start() throws InterruptedException {
        count.setCount();
        if(configuration.customStatus()) game1();
        else game2();
        configuration.reset();   
    }

    private void game() throws InterruptedException {
        while (model.untilHasLife()) {
            Dialog.clearScreen();
            field.showField();
            count.increaseCount();
            Thread.sleep(1000);
            model.nextGeneration();
        }
    }

    private void game1() throws InterruptedException {
        game();
        if(count.newRecord()) newRecord();
        saveConfiguration();
    }

    private void game2() throws InterruptedException {
        setup2();
        game1();
    }

    private void newRecord() {
        Dialog.clearScreen();
        Dialog.newRecord();
        count.writeNewRecord(count.getCount());
    }
////////////SAVE///////////////////////////////////////////////////////////////
    private void saveConfiguration() {
        Dialog.clearScreen();
        Dialog.saveData();
        input = Worker.takeInput();
        if (input.contains("y")) {
            final String name = Dialog.catchNameConfiguration();
            writeConfiguration(name);
        }
    }

    private void writeConfiguration(final String name) {
        if (Writer.writeSave(name, count.getCount(), configuration.getCustom())) {
            Dialog.saveSucc();
        } else
            Dialog.saveError();
    }
/////////SETUP//////////////////////////////////////////////////////////////////////////

    public void setup(){
        Dialog.clearScreen();
        Dialog.setup();
        input = Worker.takeInput();
        setConfiguration();
    }

    private void setup2(){
        Dialog.clearScreen();
        Dialog.setup2();
        input = Worker.takeInput();
        setConfiguration();
    }

    private void setConfiguration() {
        switch (input) {
            case "1":
                configuration.setCustom(Worker.takeConfiguration());
                break;
            case "2":
                configuration.setDieHard();
                break;
            case "3":
                configuration.setArcorn();
                break;
            case "4":
                Dialog.loadName();
                final String name = Dialog.catchNameConfiguration();
                load(name);
                break;
            default :
        }
    }
    
    private void load(final String name){
        final List<Integer> l = Reader.loadSave(name);
        configuration.setCustom(l);
        Dialog.loadSucc();
    }

//////CREDITS////////////////////////////////////////////////////////
    public void credits(){
        Dialog.clearScreen();
        Dialog.credit();
        input = Worker.takeInput();
    }
////////////////////////////////////////////////////////////////
/////ABOUT////////////////////////////////////////////////////

    public void about(){
        Dialog.clearScreen();
        Dialog.about();
        input = Worker.takeInput();
    }

    @Override
    public void run(){
        
    }
}