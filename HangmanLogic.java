import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class HangmanLogic {

  ///making Different displays per mistake
  static void showDifferentDisplays(int mistakes){
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
                System.out.print(line);
               }
              break;
        case 1: for(String line:Display[mistakes]){
                System.out.print(line);
               }
                break;
        case 2: for(String line:Display[mistakes]){
                System.out.print(line);
               }
                break;
        case 3: for(String line:Display[mistakes]){
                System.out.print(line);
               }
               break;
        case 4: for(String line:Display[mistakes]){
                System.out.print(line);
               }
                break;
        case 5: for(String line:Display[mistakes]){
                System.out.print(line);
               }
                break;
         case 6: for(String line:Display[mistakes]){
                System.out.print(line);
               }
                break;
         default:
            System.out.println("Error! 0.0009 chance this happens. Just making sure if this happens");       
     }
     
  }


  // make the display for the interaction and the blank spaces for the words
static char displayBlankWordsAndAccept(int wordlength ,String answerStack){
            //set scanner
            Scanner accept=new Scanner(System.in);

            System.out.println("|                                         |");    
        System.out.printf("|            %17s            |",answerStack);
            System.out.println("|            ");
            for(int i=1;i<=wordlength;i++){
                System.out.printf("-");
            }
            System.out.printf("|");
             
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
              accept.close();
             return correctInput;

            
}

//function to give random words
static String giveRandomWord(){
   //set random 
      Random giveRandom=new Random();
      
  
        
    //make the words first
    String[] words = {
    
    "binary", "syntax", "source", "device", "server",
    "client", "packet", "coding", "vector", "module",
    "canyon", "desert", "forest", "island", "planet",
    "meteor", "nebula", "shadow", "thunder", "freeze",
    "cookie", "cheese", "waffle", "butter", "flavor",
    "runner", "player", "jersey", "trophy", "league",
    "java", "program", "computer", "developer", "compiler",
    "software", "keyboard", "variable", "algorithm", "database",
    "network", "security", "encryption", "interface", "inheritance",
    "polymorphism", "argument", "boolean", "character", "double",
    "integer", "exception", "framework", "library", "object",
    "abstract", "instance", "iteration", "matrix", "recursion",
    "astronaut", "adventure", "dinosaur", "elephant", "flamingo",
    "galaxy", "horizon", "jungle", "kingdom", "labyrinth",
    "mystery", "navigator", "octopus", "pyramid", "quantum",
    "rainbow", "safari", "telescope", "universe", "volcano",
    "whisper", "xenon", "yesterday", "zipper", "blizzard",
    "breeze", "cyclone", "earthquake", "hurricane", "tsunami",
    "avocado", "chocolate", "espresso", "marshmallow", "pancake",
    "marathon", "champion", "stadium", "tournament", "victory"
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



    public static void main(String[] args) {  

    //start main
    boolean quit=false;
   

    while(quit==false){

      // set start
       boolean gameIsFinished=false;

      //set starting variables
     int wrongGuesses=0;
    String answerToDisplay=" ";
    char answer=' ';
    String chosenWord=giveRandomWord();
                                 //                   a function that modifies the answer right after user input e.g: he lo!   --naming it as (modify word display)
      // set To answer stack
      ArrayList<Character> toAnswerStack= new ArrayList<Character>();

      for(int i=0;i<chosenWord.length();i++){
        toAnswerStack.add(chosenWord.charAt(i));
      }
                                             

       //start game
       while(gameIsFinished==false){

        showDifferentDisplays(wrongGuesses);
        answer=displayBlankWordsAndAccept(chosenWord.length(),answerToDisplay);
        wrongGuesses+=evaluateAnswer(answer,toAnswerStack);
        


        

       }
     
    }
    

}

}