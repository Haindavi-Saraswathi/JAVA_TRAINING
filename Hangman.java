import java.util.Scanner;
import java.util.Arrays;


public class Hangman {
 

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    
    
    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};





    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        /**choose a random word */
        double integer=(Math.random()*(words.length));
        int randomInt=(int)integer;
        String randomWord = words[(randomInt)];
        char[] sent = randomWord.toCharArray();
         /**print _ for the word */
         
        char[] display =new char[randomWord.length()];
         for(int i=0;i<display.length;i++){
            display[i]='_';
            
         }
         int misses=0;
         char[] missedGuess = new char[6];
         while (misses<6){
                   /**take user input */
         System.out.print("Word :  ");
         System.out.print(display.toString());
         System.out.print("Misses  :"+misses);
         System.out.print("\n Guess : ");
        char guess=scan.next().charAt(0);
       /**check if guess is there in randomword or not */
        if(checkGuess(guess,sent)){
            updateDisplay(guess,sent,display);
        }
        else {
         missedGuess[misses]=guess;
         misses++;
        }
        if (Arrays.equals(display,sent)) {
            System.out.print(gallows[misses]);
            System.out.print("\nWord:   ");
            System.out.print(display.toString());
            System.out.println("\nGOOD WORK!");                
            break;
        }
        

         }

         
       
      scan.close();

    }
     
    /**function to check whether guess is there there in randomword or not  */
    public static boolean checkGuess(char x,char[] sent){
        for(int i=0;i<sent.length;i++){
            if (x==sent[i])
            return true;
            
        }return false;
        
    }
    public static void updateDisplay(char x,char[] sent,char[] display){
        for(int j=0;j<sent.length;j++){
            if(x==sent[j])
            display[j]=sent[j];
        }
    }








}









