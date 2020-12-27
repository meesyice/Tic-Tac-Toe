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

    public char getBoard(int row, int coloum){
        return board[row][coloum];
    }

    public char getCurrentPlayerchar(){
        return currentPlayerchar;
    }

    public void setCurrentPlayerchar(char currentPlayerchar) {
        this.currentPlayerchar = currentPlayerchar;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void setBoard(int row, int coloum, char mark) {
        this.board[row][coloum] = mark;
    }

    public void initializeBoard(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                setBoard(i, j, '-');
            }
        }
    }

    public void printBoard(){
        StringBuilder sboard = new StringBuilder();
        sboard.append("-------------");
        sboard.append(System.lineSeparator());
        for (int i = 0; i < rows; i++){
            sboard.append("| ");
            for (int j = 0; j < columns; j++) {
                sboard.append(getBoard(i, j) + " | "); 
            }
            sboard.append(System.lineSeparator());
            sboard.append("-------------");
            sboard.append(System.lineSeparator());
        }
        SimpleIO.output(sboard.toString());
    }

    public boolean isBoardFull(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(getBoard(i, j) == '-'){
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
            if(checkRowCol(getBoard(0, i), getBoard(1, i), getBoard(2, i))){
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin(){
        for(int i = 0; i < columns; i++){
            if(checkRowCol(getBoard(i, 2), getBoard(i, 1), getBoard(i, 0))){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin(){
        if(checkRowCol(getBoard(0, 2), getBoard(1, 1), getBoard(2, 0)) || checkRowCol(getBoard(2, 2), getBoard(1, 1), getBoard(0, 0))){
            return true;
        }
        return false;
    }
    

    private boolean checkRowCol(char m1, char m2, char m3){
        return m1 == m2 && m2 == m3;
    }

    public void changePlayer(){
        if(getCurrentPlayerchar() == 'x'){
            setCurrentPlayerchar('o');
        }else setCurrentPlayerchar('x');
    }

    public boolean placeMark(int row, int coloum){
        if(getBoard(row, coloum) == '-'){
            setBoard(row, coloum, getCurrentPlayerchar());
            return true;
        }
        return false;
    }

}
