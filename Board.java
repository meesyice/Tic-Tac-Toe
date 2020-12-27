public class Board {
    private final int  rows;
    private final int columns;
    private char[][] cells;
    private Player currentPlayer;

    public Board(){
        this.rows = 3;
        this.columns = 3;
        this.cells = new char[this.columns][this.rows];
    }

    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.cells = new char[this.columns][this.rows];
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getCells() {
        return cells;
    }

    public char getCell(int col, int row) {
        return cells[col][row];
    }

    public void setCell(int col, int row, char mark) {
        this.cells[col][row] = mark;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void initializeBoard(){
        for(int i = 0; i < columns; i++){
            for(int j = 0; j < rows; j++){
                setCell(i, j, '-');
            }
        }
    }

    public void printBoard(){
        StringBuilder board = new StringBuilder();
        board.append("  Tic-Tac-Toe");
        board.append(System.lineSeparator());
        board.append(" -------------");
        board.append(System.lineSeparator());
        for (int i = 2; i >= 0; i--){
            board.append(i +"| ");
            for (int j = 0; j < columns; j++) {
                board.append(getCell(j, i) + " | "); 
            }
            board.append(System.lineSeparator());
            board.append(" -------------");
            board.append(System.lineSeparator());
        }
        board.append("   0   1   2");
        System.out.println(board.toString());
    }

    public boolean isBoardFull(){
        for(int i = 0; i < columns; i++){
            for(int j = 0; j < rows; j++){
                if(getCell(i, j) == '-') return false;
            }
        }
        return true;
    }

    public boolean checkForWin(){
        return checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin();
    }

    private boolean checkRowsForWin(){
        for (int i = 0; i < rows; i++){
            if(checkRowCol(getCell(0, i), getCell(1, i), getCell(2, i))){
                return true;
            }  
        }
        return false;
    }

    private boolean checkColumnsForWin(){
        for (int i = 0; i < columns; i++) {
            if(checkRowCol(getCell(i, 0), getCell(i, 1), getCell(i, 2))){
                return true;
            }  
        }
        return false;
    }

    private boolean checkDiagonalsForWin(){
        if(checkRowCol(getCell(0, 0), getCell(1, 1), getCell(2, 2))) return true;
        if(checkRowCol(getCell(0, 2), getCell(1, 1), getCell(2, 0))) return true;
        return false;
    }
    

    private boolean checkRowCol(char m1, char m2, char m3){
        return (m1 == m2 && m1 == m3 && m2 == m3) && (m1 != '-' && m2 != '-' && m3 != '-');
    }

    public void changePlayer(Player currentPlayer){
        setCurrentPlayer(currentPlayer);
    }

    public boolean placeMark(int coloum, int row){
        if(getCell(coloum, row) == '-'){
            setCell(coloum, row, getCurrentPlayer().getMark());
            return true;
        }
        return false;
    }

    public boolean isCellempty(int col, int row){
        return getCell(col, row) == '-';
    }

}
