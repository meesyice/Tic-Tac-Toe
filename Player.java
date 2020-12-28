import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Player{
    private String name;
    private char mark;
    private Integer wins;
    private Integer losses;
    private Integer ties;
    private Score score;
    private File playerFile;
    private static String erorr = "An error occurred.";

    public Player(String name, char mark){
        this.name = name;
        this.mark = mark;
        try{
            playerFile = new File(Launcher.PATH + "/Players/" + toString() +".txt");
            if(playerFile.createNewFile()){
                setWins(0);
                setTies(0);
                setLosses(0);
                writetoFile();
                System.out.println("Welcome " + getName() + " you'll play as " + getMark());
            }else{
                readFromFile();
                System.out.println(wins.toString() + ties.toString() + losses.toString());
                System.out.println("Welcome back " + getName() + " you'll play as " + getMark());
            }
        }catch(IOException e){
            System.out.println(erorr);
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

    private void writetoFile(){
        try(FileWriter playerFileWriter = new FileWriter(playerFile.getAbsolutePath())){
            playerFileWriter.write(wins.toString());
            playerFileWriter.write(System.lineSeparator());
            playerFileWriter.write(ties.toString());
            playerFileWriter.write(System.lineSeparator());
            playerFileWriter.write(losses.toString());
          }catch(IOException e){
            System.out.println(erorr);
            e.printStackTrace();
        }
    }

    private void readFromFile(){
        try(Scanner playerFileReader = new Scanner(playerFile)){
            wins = Integer.parseInt(playerFileReader.nextLine());
            ties = Integer.parseInt(playerFileReader.nextLine());
            losses = Integer.parseInt(playerFileReader.nextLine());
        }catch(FileNotFoundException e){
            System.out.println(erorr);
            e.printStackTrace();
        }
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
        writetoFile();
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
