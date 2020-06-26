public class Menu {
    private Facade facade;
    //private static Menu obj;
    private String input;
    
    public Menu(){
        facade = new Facade();
    }

    public void showMenu() throws InterruptedException {
        Dialog.clearScreen();
        Dialog.menu();
        waitInput();
        waitChoose();
    }

    private void waitChoose() throws InterruptedException {
        switch(input){
            case "1":
                start();
                break;
            case "2":
                setup();
                break;
            case "3":
                credits();
                break;
            case "4":
                about();
                break;
            case "5":
                break;
            default: 
                showMenu();
                break;
        }
    }

    private void start() throws InterruptedException {
        Dialog.clearScreen();
        facade.start();
        showMenu();
    }

    private void setup() throws InterruptedException {
        facade.setup();
        showMenu();
    }

    private void credits() throws InterruptedException {
        facade.credits();
        showMenu();
    }
    private void about() throws InterruptedException {
        facade.about();
        showMenu();
    }

    private void waitInput(){
        input = Worker.takeInput();
    }
}