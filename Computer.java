public class Computer extends Player{

    private Difficulty difficulty;

    public Computer(Difficulty diffi, char mark){
        super(diffi.toString() + " Compueter", mark);
        this.difficulty = diffi;
        this.createPlayerFile();
    }

    public Difficulty getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Computer && obj.getClass().equals(this.getClass())){
            Computer computer = (Computer) obj;
            return super.equals(computer) && this.difficulty == computer.difficulty;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void playTurn(Board gameBoard){
        if(checkForLoss(gameBoard)){
            preventLoss();
            return;
        }
        if(checkForWin(gameBoard)){
            winGame();
            return;
        }
        
    }

    private boolean checkForLoss(Board gameBoard){
        //TODO
    }

    private void preventLoss(){
        //TODO
    }

    private boolean checkForWin(Board gameBoard){
        //TODO
    }

    private boolean winGame(){
        //TODO
    }


}
