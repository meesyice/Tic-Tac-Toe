public class Player {
    String name;
    char mark;

    public Player(String name, char mark){
        this.name = name;
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }
    
    public void setName(String name) {
        this.name = name;
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
