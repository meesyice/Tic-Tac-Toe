import java.io.File;
import java.io.IOException;

public class Player {
    private String name;
    private char mark;
    private int wins;
    private int losses;
    private int ties;
    private Score score;
    private File playerFile;

    public Player(String name, char mark){
        this.name = name;
        this.mark = mark;
        try{
            playerFile = new File(Launcher.PATH + "/Players/" + toString() +".txt");
            if(playerFile.createNewFile()){
                setWins(0);
                setTies(0);
                setLosses(0);
                System.out.println("Hello " + getName() + " you'll play as " + getMark());
            }else{
                setWins(0);
                setTies(0);
                setLosses(0);
                System.out.println("Welcome back " + getName() + " you'll play as " + getMark());
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public char getMark(){
        return this.mark;
    }

    public int getWins(){
        return this.wins;
    }

    public int getLosses(){
        return losses;
    }

    public int getTies(){
        return this.ties;
    }

    public String getName(){
        return this.name;
    }
    
    public Score getScore() {
        return this.score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Player && obj.getClass().equals(this.getClass())){
            Player player = (Player) obj;
            return player.getName().equals(this.getName()) && player.getMark() == this.getMark();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    private static void createPlayerFile(){
        //TODO
    }

    public void editScore(Score score){
        switch(score){
            case WIN:
                this.addWin();
                break;
            case TIE:
                this.addTie();
                break;
            case LOSS:
                this.addLoss();
                break;
            default:
                break;
        }
    }

    private void addWin(){
        this.wins += 1;
    }

    private void addTie(){
        this.ties += 1;
    }

    private void addLoss(){
        this.losses += 1;
    }
}
