import java.util.Comparator;
import java.util.ArrayList;
public class Team{
    public String name;
    public Integer points;
    public Character group;
    public Integer gd;
    public Team(String name, Integer points, Character group, Integer gd) {
        this.name = name;
        this.points = points;
        this.group = group;
        this.gd = gd;
    }
    public String getName(){
        return name;
    }
    public Integer getPoints(){
        return points;
    }
    public Integer getGd(){
        return gd;
    }
    public void setPoints(Integer points){
        this.points = points;
    }
    public void setGd(Integer gd){
        this.gd = gd;
    }

    public static Comparator<Team> TeamPointsNo = (s1, s2) -> {

        int pointsno1 = s1.getPoints();
        int pointsno2 = s2.getPoints();
        int gdno1 = s1.getGd();
        int gdno2 = s2.getGd();
        if(pointsno1 == pointsno2){
            return gdno2 - gdno1;
        }
        else{
            return pointsno2-pointsno1;
        }

        // For ascending order
        //return pointsno1 - pointsno2;

        // For descending order
        //return pointsno2-pointsno1;<------what we want
    };
    public static Team getTeamByName(String name, ArrayList<Team> group){
        Team team = null;
        for(int i=0; i<4;i++){
            if(group.get(i).getName()==name){
                team = group.get(i);
                break;
            }
        }
        return team;
    }
    @Override
    public String toString() {
        return name + " | PTS: " + points + " | GRP: " + group + " | GD: " + gd;
    }
}
