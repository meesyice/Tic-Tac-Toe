import java.util.Scanner;

public final class Launcher{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');
        System.out.println("Tic-Tac-Toe");
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
}