public class TTT {
    private char[][] board;
    private char currentPlayerchar;
    private static int rows = 3;
    private static int columns = 3;

    public TTT(){
        this.board = new char[rows][columns];
        this.currentPlayerchar = 'X';
    }

    public char[][] getBoard(){
        return board;
    }

    public char getCurrentPlayerchar(){
        return currentPlayerchar;
    }

    

    public void initializeBoard(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                board[i][j] = '-';
            }
        }
    }

    public void printBoard(){
        System.out.println("-------------");
        for (int i = 0; i < rows; i++) {
            System.out.println("| ");
            for (int j = 0; j < columns; j++) {
                System.out.println(board[i][j] + " | ");  
            }
        }
    }

    public boolean isBoardFull(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin(){
        return checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin();
    }

    private boolean checkRowsForWin(){
        for(int i = 0; i < rows; i++){
            if(checkRowCol(board[0][i],board[1][i],board[2][i])){
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin(){
        for(int i = 0; i < columns; i++){
            if(checkRowCol(board[i][2],board[i][1],board[i][0])){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin(){
        if(checkRowCol(board[0][2],board[1][1],board[2][0]) || checkRowCol(board[2][2],board[1][1],board[0][0])){
            return true;
        }
        return false;
    }

    private boolean checkRowCol(char m1, char m2, char m3){
        return m1 == m2 && m2 == m3;
    }







}
