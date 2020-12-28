import java.io.File;

public class Player {
    String name;
    char mark;
    int wins;
    int losses;
    int ties;
    File playerFile;

    public Player(String name, char mark){
        this.name = name;
        this.mark = mark;
    }

    public char getMark(){
        return mark;
    }

    public int getWins(){
        return wins;
    }

    public int getLosses(){
        return losses;
    }

    public int getTies(){
        return ties;
    }

    public String getName(){
        return name;
    }

    public void setMark(char mark){
        this.mark = mark;
    }
    
    public void setName(String name){
        this.name = name;
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
}
