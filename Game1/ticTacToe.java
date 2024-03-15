import java.util.*;
public class ticTacToe {
    
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    
    public static void main() {
        
        char[][] gameBoard = {{' ','|',' ','|',' '},
                              {'-','+','-','+','-'},
                              {' ','|',' ','|',' '},
                              {'-','+','-','+','-'},
                              {' ','|',' ','|',' '}};
                              
        printGameBoard(gameBoard);
        
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your placement from 1-9: ");
            int playerPos = sc.nextInt(); 
            
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("Position already taken. Choose Another");
                playerPos = sc.nextInt();
            }
            
            placePiece(gameBoard, playerPos, "player");
            
            String result = checkWinner();
            if(result.length()>0) {
                System.out.println(result);
                break;
            }
            
            Random ran = new Random();
            int cpuPos = ran.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                //System.out.println("Position already taken. Choose Another");
                cpuPos = ran.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "cpu");
            
            printGameBoard(gameBoard);
            
            result = checkWinner();
            if(result.length()>0) {
                System.out.println(result);
                break;
            }
        }
    }
    public static void printGameBoard(char[][] gameBoard) {
        for(char[]row : gameBoard) {
            for(char element : row) {
                System.out.print(element);
            }
            System.out.println("");
        }
    }
    public static void placePiece(char[][]gameBoard, int pos, String user) {
        char symbol = ' ';
        
        if(user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        }
        else if(user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }
        switch(pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
        //printGameBoard(gameBoard);
    }
    public static String checkWinner() {
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        
        List leftDiag = Arrays.asList(1,5,9);
        List rightDiag = Arrays.asList(7,5,3);
        
        List<List> winning = new ArrayList<List>(); //why
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(leftDiag);
        winning.add(rightDiag);
        
        for(List l : winning) { //why
            if(playerPositions.containsAll(l)) {
                return "Congratulations! You Win!";
            }
            else if(cpuPositions.containsAll(l)) {
                return "CPU Wins. Sorry:(";
            }
            else if(cpuPositions.size() + playerPositions.size() == 9) {
                return "Time Wasted Successfully";
            }
        }
        return "";
    }
}