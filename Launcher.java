import java.io.File;
import java.util.Scanner;

public final class Launcher{
    public static void main(String[] args){
        setupFiles(); 
        mainMenu();
    }

    private static void setupFiles(){
        String path = System.getProperty("java.class.path");
        new File(path + "/Players").mkdirs();
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
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');
        System.out.print("Player 1 please Enter your name: ");
        player1.setName(in.nextLine());
        System.out.println("Hello " + player1.toString() + " you'll play as " + player1.getMark());
        System.out.print("Player 2 please Enter your name: ");
        player2.setName(in.nextLine());
        System.out.println("Hello " + player2.toString() + " you'll play as " + player2.getMark());

        Board game = new Board();
        game.initializeBoard();
        game.printBoard();
        game.setCurrentPlayer(player1);
        int col, row;

        while(!game.isBoardFull()){
            System.out.println("it's " + game.getCurrentPlayer().toString() + "'s Turn");
            System.out.println("Enter your move (column[1-3] row[1-3]):");
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