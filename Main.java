package opgave2;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//Declaring local variable for input and creating a scanner object
        String input = "";
        Scanner scan = new Scanner(System.in);
        
//Game introduction and creation of player + game object through input
        System.out.print("--WELCOME TO DICEROLLER--\nPlease enter your name: ");
        Player player = new Player(scan.nextLine());
        Game game = new Game(player);

        System.out.print("--Which game would you like to play? (Enter 1, 2, 3 or \"QUIT\" to exit)--\n"
        + "*Game 1 rolls a standard dice 10 times. Highest sum wins.\n"
        + "*Game 2 rolls a 12 and a 24 sided dice 5 times each. If the sum of the rolls is an even number, your sum is doubled. Highest sum wins.\n"
        + "*Game 3 rolls a standard dice once. If the result is 1-3, you roll a 12 sided dice and sums. Else you roll a 10 sided dice and sums."
        + " Lowest sum wins.\nGame # choice: ");
        
//Menu loop - runs as long as player does NOT input quit (case ignored) - nested if-conditions to check choice and to avoid use of break in loop
        while (!input.equalsIgnoreCase("QUIT")) {
            input = scan.nextLine();

            if (input.equals("1")) {
                System.out.print("\nRolling dice...\n" + game.playGame1() + "\nEnter game # to play again, or \"QUIT\" to exit: ");
            } else if (input.equals("2")) {
                System.out.print("\nRolling dice...\n" + game.playGame2() + "\nEnter game # to play again, or \"QUIT\" to exit: ");
            } else if (input.equals("3")) {
                System.out.print("\nRolling dice...\n" + game.playGame3() + "\nEnter game # to play again, or \"QUIT\" to exit: ");
            } else if (!input.equalsIgnoreCase("QUIT")) {
                System.out.print("\n--ERROR UNKNOWN INPUT--\nNew input: ");
            }
        }
        
//Opgave D
//kører hvert spil x antal gange (sæt i testrun)
        int playWinCount1 = 0;
        int playWinCount2 = 0;
        int playWinCount3 = 0;
        int testRuns = 100000;
        int result;
        String resultStr;
       
        for (int i = 0; i < testRuns; i++) {
            game.playGame1();
            if(game.playGame1().getWin(true)){
                playWinCount1++;
            }
        }
        
        for (int i = 0; i < testRuns; i++) {
            game.playGame2();
            if(game.playGame2().getWin(true)){
                playWinCount2++;
            }
        }
        
        for (int j = 0; j < testRuns; j++) {
            game.playGame3();
            if(game.playGame3().getWin(true)){
                playWinCount3++;
            }
        }
        
//checks for the highest win-count
        if(playWinCount1 > playWinCount2 && playWinCount1 > playWinCount3){
            resultStr = "Game 1";
            result = ((playWinCount1 * 100) / testRuns);
        } else if (playWinCount2 > playWinCount1 && playWinCount2 > playWinCount3){
            resultStr = "Game 2";
            result = ((playWinCount2 * 100) / testRuns);
        } else {
            resultStr = "Game 3";
            result = ((playWinCount3 * 100) / testRuns);
        }
        
        System.out.println("//The highest chance of winning is in game: " + resultStr
                + " med " + result + "% chance.");
    }
}