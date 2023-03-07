import java.util.Collections;
import java.util.ArrayList;
public class Main
{
    public static void loadTeams(ArrayList<Team> groupA, ArrayList<Team> groupB, ArrayList<Team> groupC, ArrayList<Team> groupD,
                                 ArrayList<Team> groupE, ArrayList<Team> groupF, ArrayList<Team> groupG, ArrayList<Team> groupH ) {
        groupA.add(new Team("Netherlands", 0, 'A', 0));groupA.add(new Team("Senegal", 0, 'A', 0));
        groupA.add(new Team("Ecuador", 0, 'A', 0));groupA.add(new Team("Qatar", 0, 'A', 0));
        groupB.add(new Team("England", 0, 'B', 0));groupB.add(new Team("USA", 0, 'B', 0));
        groupB.add(new Team("Iran", 0, 'B', 0));groupB.add(new Team("Wales", 0, 'B', 0));
        groupC.add(new Team("Argentina", 0, 'C', 0));groupC.add(new Team("Poland", 0, 'C', 0));
        groupC.add(new Team("Mexico", 0, 'C', 0));groupC.add(new Team("Saudi Arabia", 0, 'C', 0));
        groupD.add(new Team("France", 0, 'D', 0));groupD.add(new Team("Australia", 0, 'D', 0));
        groupD.add(new Team("Tunisia", 0, 'D', 0));groupD.add(new Team("Denmark", 0, 'D', 0));
        groupE.add(new Team("Spain", 0, 'E', 0));groupE.add(new Team("Germany", 0, 'E', 0));
        groupE.add(new Team("Japan", 0, 'E', 0));groupE.add(new Team("Costa Rica", 0, 'E', 0));
        groupF.add(new Team("Morocco", 0, 'F', 0));groupF.add(new Team("Croatia", 0, 'F', 0));
        groupF.add(new Team("Belgium", 0, 'F', 0));groupF.add(new Team("Canada", 0, 'F', 0));
        groupG.add(new Team("Brazil", 0, 'G', 0));groupG.add(new Team("Switzerland", 0, 'G', 0));
        groupG.add(new Team("Serbia", 0, 'G', 0));groupG.add(new Team("Cameroon", 0, 'G', 0));
        groupH.add(new Team("Portugal", 0, 'H', 0));groupH.add(new Team("Ghana", 0, 'H', 0));
        groupH.add(new Team("South Korea", 0, 'H', 0));groupH.add(new Team("Uruguay", 0, 'H', 0));
    }

    public static void main(String[] args) {
        ArrayList<Team> a = new ArrayList<>();ArrayList<Team> b = new ArrayList<>();ArrayList<Team> c = new ArrayList<>();ArrayList<Team> d = new ArrayList<>();
        ArrayList<Team> e = new ArrayList<>();ArrayList<Team> f = new ArrayList<>();ArrayList<Team> g = new ArrayList<>();ArrayList<Team> h = new ArrayList<>();
        loadTeams(a,b,c,d,e,f,g,h);
        ArrayList<ArrayList<Team>> groups = new ArrayList<>();
        Collections.addAll(groups, a,b,c,d,e,f,g,h);
        Team champion = Tournament.koStageSim(Tournament.groupStageSim(groups));
        System.out.println(champion.getName() +" has won the 2022 FIFA World Cup!!!");
    }
}
