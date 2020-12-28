import java.io.File;
import java.util.Scanner;

public final class Launcher{
    static final String PATH = System.getProperty("java.class.path");
    static String p1; 
    static String p2;
    public static void main(String[] args){
        setupFiles(); 
        mainMenu();
    }

    private static void setupFiles(){
        new File(PATH + "/Players").mkdirs();
    }

    private static void mainMenu(){
        Scanner in = new Scanner(System.in);
        int input;
        System.out.println("Tic-Tac-Toe");
        System.out.println("1. New Game");
        System.out.println("2. Leaderboard");
        System.out.println("3. Exit");
        input = in.nextInt();
        switch(input){
            case 1 -> newGame();
            case 2 -> leaderboard();
            case 3 -> System.exit(input);
            default -> mainMenu();
        }
        in.close();
    }

    private static void newGame(){
        Scanner in = new Scanner(System.in);
        System.out.print("Player 1 please Enter your name: ");
        p1 = in.nextLine();
        Player player1 = new Player(p1, 'X');
        System.out.print("Player 2 please Enter your name: ");
        p2 = in.nextLine();
        Player player2 = new Player(p2, 'O');
       
        Board game = new Board();
        game.initializeBoard();
        game.printBoard();
        game.setCurrentPlayer(player1);
        int col; 
        int row;

        while(!game.isBoardFull()){
            System.out.println("it's " + game.getCurrentPlayer().toString() + "'s Turn");
            System.out.println("Enter your move (column[0-2] row[0-2]):");
            col = in.nextInt();
            row = in.nextInt();
            if(game.isCellempty(col, row)){
                game.placeMark(col, row);
            }else{
                System.out.println("cell already marked, try again");
                continue;
            }
            if(game.checkForWin()){
                game.printBoard();
                System.out.println(game.getCurrentPlayer().toString() +" has won!");
                break;
            }
            if(game.getCurrentPlayer().equals(player1)){
                game.changePlayer(player2);
            }else game.changePlayer(player1);
            game.printBoard();
        }
        System.out.println("Thnaks for Playing!");
        in.close();
    }

    public static void leaderboard(){
        //TODO
    }
}