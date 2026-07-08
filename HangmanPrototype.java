import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class HangmanPrototype {




    public static void main(String[] args) {  

    //start main
    boolean quit=false;
   
    while(quit==false){

      // set start
       boolean gameIsFinished=false; //set something to display when finished (victory or loss) in displayBlankWordsAndAccept function

      //set starting variables
    int wrongGuesses=0;
      String answerToDisplay = null;
    char answer=' ';
    String chosenWord=giveRandomWord();
                                
      // set To answer stack  
      ArrayList<Character> toAnswerStack= new ArrayList<Character>();

      for(int i=0;i<chosenWord.length();i++){
        toAnswerStack.add(chosenWord.charAt(i));
      }
                                             

       //start game
       while(gameIsFinished==false){
        answerToDisplay=modifyWordToDisplay(answer,chosenWord,answerToDisplay);
        showDifferentDisplays(wrongGuesses);
        answer=displayBlankWordsAndAccept(chosenWord.length(),answerToDisplay,toAnswerStack);
        boolean isWrong=(evaluateAnswer(answer,toAnswerStack)==1)? false:true;
        if(isWrong){
          wrongGuesses++;
        }else{
         answerToDisplay=modifyWordToDisplay(answer,chosenWord,answerToDisplay);
        }
         //make a condition to check if the game is finished and also make a function to display the chosen word
          gameIsFinished=(wrongGuesses==6 || toAnswerStack.isEmpty()||answer==0)? true:false;
       }
      
       System.out.println("Do you want to play again? (Y/N)");
    
    }

}



static void showDifferentDisplays(int mistakes){ ///tis correct------------------------------------------------
     String[][] Display={
        {"_________________________________________",
        "|                                         |",
        "|             _________                   |",
        "|             |       l                   |",
        "|             |                           |",
        "|             |                           |",
        "|             |                           |",
        "|             |                           |",
        "|        ---------                        |",
        "|                                         |",
        "|                                         |",
        "|-----------------------------------------|",
        },
          {"_________________________________________",
        "|                                         |",
        "|             _________                   |",
        "|             |       l                   |",
        "|             |       0                   |",
        "|             |                           |",
        "|             |                           |",
        "|             |                           |",
        "|        ---------                        |",
        "|                                         |",
        "|                                         |",
        "|-----------------------------------------|",
        },
          {"_________________________________________",
        "|                                         |",
        "|             _________                   |",
        "|             |       l                   |",
        "|             |       0                   |",
        "|             |       |                   |",
        "|             |                           |",
        "|             |                           |",
        "|        ---------                        |",
        "|                                         |",
        "|                                         |",
        "|-----------------------------------------|",
        },
          {"_________________________________________",
        "|                                         |",
        "|             _________                   |",
        "|             |       l                   |",
        "|             |       0                   |",
        "|             |      /|                   |",
        "|             |                           |",
        "|             |                           |",
        "|        ---------                        |",
        "|                                         |",
        "|                                         |",
        "|-----------------------------------------|",
        },
          {"_________________________________________",
        "|                                         |",
        "|             _________                   |",
        "|             |       l                   |",
        "|             |       0                   |",
        "|             |      /|\\                  |",
        "|             |                           |",
        "|             |                           |",
        "|        ---------                        |",
        "|                                         |",
        "|                                         |",
        "|-----------------------------------------|",
        },
          {"_________________________________________",
        "|                                         |",
        "|             _________                   |",
        "|             |       l                   |",
        "|             |       0                   |",
        "|             |      /|\\                  |",
        "|             |      /                    |",
        "|             |                           |",
        "|        ---------                        |",
        "|                                         |",
        "|                                         |",
        "|-----------------------------------------|",
        }, 
         {"_________________________________________",
        "|                                         |",
        "|             _________                   |",
        "|             |       l                   |",
        "|             |       0                   |",
        "|             |      /|\\                  |",
        "|             |      / \\                  |",
        "|             |                           |",
        "|        ---------                        |",
        "|               GAME OVER!                |",
        "|                                         |",
        "|-----------------------------------------|",
        }
     };

     switch(mistakes){
        case 0: 
               for(String line:Display[mistakes]){
                System.out.println(line);
               }
              break;
        case 1: for(String line:Display[mistakes]){
                System.out.println(line);
               }
                break;
        case 2: for(String line:Display[mistakes]){
                System.out.println(line);
               }
                break;
        case 3: for(String line:Display[mistakes]){
                System.out.println(line);
               }
               break;
        case 4: for(String line:Display[mistakes]){
                System.out.println(line);
               }
                break;
        case 5: for(String line:Display[mistakes]){
                System.out.println(line);
               }
                break;
         case 6: for(String line:Display[mistakes]){
                System.out.println(line);
               }
                break;
         default:
            System.out.println("Error: Invalid number of mistakes.");       
     }
     
  }

   // make the display for the interaction and the blank spaces for the words
static char displayBlankWordsAndAccept(int wordlength ,String answerStack,ArrayList<Character> wordsToGuess){
            //set scanner
            Scanner accept=new Scanner(System.in);
            
            System.out.println("|                                         |");   
            if(wordsToGuess.isEmpty()){
                System.out.printf("|            %17s            |\n","You Win!");
              }else{
                System.out.printf("|            %17s            |\n",answerStack);
              }
           System.out.println("|_________________________________________|");
             
            char correctInput=' ';
            //ask for user input
            boolean inputIsRight=false;
             while(inputIsRight==false){
                String input;
                System.out.printf("Enter a letter from A-Z[0 to exit]: "); input=accept.nextLine();
                
                if(input.length()==1){
                   char testChar=input.toUpperCase().charAt(0);

                   if(Character.isLetter(testChar)){
                    correctInput=testChar;
                    inputIsRight=true;
                   }

                    if(testChar == '0') {
                        correctInput='0';
                    break;
            }
            
                }
                

             }
             return correctInput;

            
}

  ///making Different displays per mistake
  


//function to give random words
static String giveRandomWord(){
   //set random 
      Random giveRandom=new Random();
      
  
        
    //make the words first
    String[] words = { 
    "binary", "syntax", "source", "device", "server", "client", "packet", "coding", "vector", "module", 
    "canyon", "desert", "forest", "island", "planet", "meteor", "nebula", "shadow", "thunder", "freeze", 
    "cookie", "cheese", "waffle", "butter", "flavor", "runner", "player", "jersey", "trophy", "league", 
    "java", "program", "computer", "developer", "compiler", "software", "keyboard", "variable", "algorithm", "database", 
    "network", "security", "encryption", "interface", "inheritance", "polymorphism", "argument", "boolean", "character", "double", 
    "integer", "exception", "framework", "library", "object", "abstract", "instance", "iteration", "matrix", "recursion", 
    "astronaut", "adventure", "dinosaur", "elephant", "flamingo", "galaxy", "horizon", "jungle", "kingdom", "labyrinth", 
    "mystery", "navigator", "octopus", "pyramid", "quantum", "rainbow", "safari", "telescope", "universe", "volcano", 
    "whisper", "xenon", "yesterday", "zipper", "blizzard", "breeze", "cyclone", "earthquake", "hurricane", "tsunami", 
    "avocado", "chocolate", "espresso", "marshmallow", "pancake", "marathon", "champion", "stadium", "tournament", "victory",
    "backend", "frontend", "gateway", "firewall", "protocol", "endpoint", "metadata", "payload", "pipeline", "cluster", 
    "terminal", "script", "runtime", "garbage", "memory", "buffer", "pointer", "register", "firmware", "hardware", 
    "monitor", "storage", "backup", "restore", "lambda", "closure", "sandbox", "token", "session", "header", 
    "request", "response", "thread", "process", "daemon", "kernel", "driver", "console", "encapsulation", "constructor", 
    "destructor", "method", "function", "parameter", "constant", "literal", "operand", "stack", "queue", "array", 
    "tuple", "dictionary", "graph", "tree", "node", "vertex", "override", "overload", "package", "namespace", 
    "import", "export", "generic", "wildcard", "annotation", "glacier", "valley", "tundra", "savanna", "prairie", 
    "monsoon", "tornado", "typhoon", "wildfire", "avalanche", "comet", "asteroid", "pulsar", "quasar", "eclipse", 
    "orbit", "gravity", "cosmos", "infinity", "starlight", "expedition", "voyage", "odyssey", "journey", "treasure", 
    "artifact", "relic", "ancient", "temple", "cavern", "waterfall", "plateau", "summit", "crescent", "aurora", 
    "solstice", "equinox", "dolphin", "penguin", "giraffe", "cheetah", "leopard", "panther", "kangaroo", "koala", 
    "platypus", "wombat", "falcon", "eagle", "hawk", "owl", "parrot", "peacock", "chameleon", "iguana", 
    "alligator", "crocodile", "gorilla", "chimpanzee", "baboon", "lemur", "meerkat", "badger", "otter", "beaver", 
    "walrus", "narwhal", "brownie", "muffin", "cupcake", "donut", "pastry", "croissant", "biscuit", "macaron", 
    "caramel", "vanilla", "cinnamon", "nutmeg", "ginger", "honey", "syrup", "cappuccino", "latte", "mocha", 
    "macchiato", "smoothie", "cheesecake", "pudding", "gelato", "sorbet", "custard", "truffle", "fondue", "pretzel", 
    "popcorn", "cracker", "athlete", "referee", "umpire", "coach", "manager", "captain", "olympics", "medal", 
    "podium", "scoreboard", "playoff", "bracket", "defense", "offense", "tactics", "strategy", "training", "workout", 
    "fitness", "circuit", "whistle", "sneaker", "cleats", "helmet", "goggles", "uniform", "arena", "velodrome", 
    "cyber", "malware", "phishing", "spyware", "ransomware", "bitcoin", "wallet", "miner", "hash", "block"
};


     //define size of the words array
     
     int wordDraw=words.length;
     
     //set the random index
      int randomIndex=giveRandom.nextInt(wordDraw);
    //set random word
    String chosenWord=words[randomIndex];      
      
 return chosenWord;

}

static int evaluateAnswer(char givenChar,ArrayList<Character> wordStack){
      
  int stackLength=wordStack.size();
  
         for(int letter=0;letter<stackLength;letter++){
             if(givenChar==wordStack.get(letter)){
                  wordStack.remove(letter);
                  return 1;
        }
       }
       return 0;
}

static String modifyWordToDisplay(char answer,String chosenWord,String answerToDisplay){
  int wordLength = chosenWord.length();
  StringBuilder modifiedAnswer;

  if(answerToDisplay == null || answerToDisplay.length() != wordLength){
    modifiedAnswer = new StringBuilder();
    for(int i=0;i<wordLength;i++) modifiedAnswer.append('_');
  } else {
    modifiedAnswer = new StringBuilder(answerToDisplay);
  }

  for(int i=0;i<wordLength;i++){
    if(chosenWord.charAt(i) == answer){
      modifiedAnswer.setCharAt(i, answer);
    }
  }

  return modifiedAnswer.toString();

}

}
