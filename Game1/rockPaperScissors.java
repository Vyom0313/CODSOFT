import java.util.*;
class rockPaperScissors {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            String[] rps = {"r","p","s"};
            String computerMove = rps[new Random().nextInt(rps.length)];
            
            String playerMove;
            while (true) {
                System.out.println("Enter Your Move: Rock Paper Scissors");
                playerMove = sc.nextLine();
                
                if(playerMove.equals("r") || playerMove.equals("p") || playerMove.equals("s"))
                break;
                
                System.out.println("Enter valid choice");
            }
            
            System.out.println("Computer played: "+ computerMove);
            System.out.println("You played: "+ playerMove);
            
            if (playerMove.equals(computerMove))
            System.out.println("The game was a tie!");
            
            else if (playerMove.equals("r")) {
                if(computerMove.equals("p"))
                System.out.println("Computer wins");
                
                else
                System.out.println("Player Wins");
            }
            
            else if (playerMove.equals("p")) {
                if(computerMove.equals("s"))
                System.out.println("Computer wins");
                
                else
                System.out.println("Player Wins");
            }
            
            else {
                if(computerMove.equals("r"))
                System.out.println("Computer wins");
                
                else
                System.out.println("Player Wins");
            }
            System.out.println("Wanna play again? y/n");
            String playAgain = sc.nextLine();
            
            if(!playAgain.equals("y"))
            break;
        }
    }
}