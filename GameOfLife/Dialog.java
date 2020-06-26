
public class Dialog {

    public static void credit()  {
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("//                             CREDIT                                 //");
        System.out.println("//                                                                    //");
        System.out.println("//    Software made by Vincent Antonio Jr Pastor x8100034             //");
        System.out.println("//    as project for''Ingegneria del Software'' at Università degli   //");
        System.out.println("//    studi di Catania during year 2019/2020                          //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//    Press any key to go back                                        //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                          By V.P    //");
        System.out.println("////////////////////////////////////////////////////////////////////////");
        
    }


    public static void setup(){
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("//                             SETUP                                  //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//     1. Custom         ( Custom setup. )                            //");
        System.out.println("//                                                                    //");
        System.out.println("//     2. Diehard        ( DieHard is a pattern that eventually       //");
        System.out.println("//                         disappears, after 130 generations. )       //");
        System.out.println("//                                                                    //"); 
        System.out.println("//     3. Arcorn         ( Arcorn takes 5206 generation to generate   //");
        System.out.println("//                         633 cells, including 13 escaped gliders )  //");
        System.out.println("//                                                                    //");
        System.out.println("//     4. Load                                                        //");                                      
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                          By V.P    //");
        System.out.println("////////////////////////////////////////////////////////////////////////");
    }


    public static void setup2(){
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("//  Primary settings not selected.                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//     1. Custom         ( Custom setup. )                            //");
        System.out.println("//                                                                    //");
        System.out.println("//     2. Diehard        ( DieHard is a pattern that eventually       //");
        System.out.println("//                         disappears, after 130 generations. )       //");
        System.out.println("//                                                                    //"); 
        System.out.println("//     3. Arcorn         ( Arcorn takes 5206 generation to generate   //");
        System.out.println("//                         633 cells, including 13 escaped gliders )  //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");                                      
        System.out.println("//     4. Load                                                        //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                          By V.P    //");
        System.out.println("////////////////////////////////////////////////////////////////////////");
    }


    public static void menu(){
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                          GAME OF LIFE                              //");
        System.out.println("//                                                                    //");
        System.out.println("//             1.   START                                             //");
        System.out.println("//                                                                    //");
        System.out.println("//             2.   SETUP                                             //");
        System.out.println("//                                                                    //");
        System.out.println("//             3.   CREDIT                                            //");
        System.out.println("//                                                                    //");
        System.out.println("//             4.   ABOUT                                             //");
        System.out.println("//                                                                    //");
        System.out.println("//             5.   EXIT                                              //");
        System.out.println("//                                                          By V.P    //");
        System.out.println("////////////////////////////////////////////////////////////////////////");
    }
    

    public static void about() {
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("//                             ABOUT                                  //");
        System.out.println("//   The game of life is a cellular automaton devised by the british  //");
        System.out.println("//   John Horton Conway in 1970. It's a zero-player game, meaning     //");
        System.out.println("//   that its evolution is determined by its initial state.           //");
        System.out.println("//                                                                    //");
        System.out.println("//   One interacts with the Game of Life by creating an initial       //");
        System.out.println("//   configuration and observing how it evolves.                      //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//    Press any key to go back                                        //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                          By V.P    //");
        System.out.println("////////////////////////////////////////////////////////////////////////");
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }


    public static void loadSucc(){
        clearScreen();
        System.out.println("Loading completed; ");
    }


    public static void loadError(){
        clearScreen();
        System.out.println("Loading failed. Please insert again the name configuration: ");
    }


    public static void loadConf(){
        clearScreen();
        System.out.println("Loading your configuration wait...");
    }


    public static void dataName(){
        clearScreen();
        System.out.println("Please insert the configuration name: ");
    }


    public static void saveData(){
        clearScreen();
        System.out.println("Do you want to save this configuration? Digit 'yes'");
    }


    public static void saveSucc(){
        clearScreen();
        System.out.println("Saved. ");
    }


    public static void saveError(){
        clearScreen();
        System.out.println("Error in saving. ");
    }


    public static void insertName(){
        System.out.println("File name: ");
    }


    public static void newRecord(){
        clearScreen();
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("//                                                                    //");
        System.out.println("//                     You set a new record!                          //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//     Do you want to save this configuration?                        //");
        System.out.println("//     digit yes or no                                                //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                                    //");
        System.out.println("//                                                          By V.P    //");
        System.out.println("////////////////////////////////////////////////////////////////////////");
    }

    public static void loadName(){
        System.out.println("Insert name of the configuration want to load: ");
    }


    public static String catchNameConfiguration(){
        Dialog.clearScreen();
        Dialog.dataName();
        return Worker.takeInput();
    }
}