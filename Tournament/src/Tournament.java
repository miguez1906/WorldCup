import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tournament{
    public static ArrayList<ArrayList<Team>> groupMatchMaker(ArrayList<Team> group){
        ArrayList<ArrayList<Team>> groupMatches = new ArrayList<>();
        ArrayList<Team> match1 = new ArrayList<>(Arrays.asList(group.get(0), group.get(1)));
        ArrayList<Team> match2 = new ArrayList<>(Arrays.asList(group.get(2), group.get(3)));
        ArrayList<Team> match3 = new ArrayList<>(Arrays.asList(group.get(3), group.get(0)));
        ArrayList<Team> match4 = new ArrayList<>(Arrays.asList(group.get(1), group.get(2)));
        ArrayList<Team> match5 = new ArrayList<>(Arrays.asList(group.get(0), group.get(2)));
        ArrayList<Team> match6 = new ArrayList<>(Arrays.asList(group.get(1), group.get(3)));
        groupMatches.add(match1);
        groupMatches.add(match2);
        groupMatches.add(match3);
        groupMatches.add(match4);
        groupMatches.add(match5);
        groupMatches.add(match6);
        return groupMatches;
    }

    public static String matchDisplay(Team t1, Team t2){
        return t1.getName() + " VS " + t2.getName() + "\nInput Score";
    }

    public static String scoreLineDisplay(Team t1, Team t2, Integer t1Score, Integer t2Score){
        return "FINAL SCORE\n"+t1.getName()+" "+t1Score+ " - " + t2Score+ " "+ t2.getName()+"\n\n";
    }

    public static ArrayList<Team> matchDay(Team t1, Team t2, Integer t1Score, Integer t2Score, ArrayList<Team> match){
        int t1index = match.indexOf(t1);
        int t2index = match.indexOf(t2);
        if(t1Score.equals(t2Score)){
            t1.setPoints(t1.getPoints()+ 1);
            t2.setPoints(t2.getPoints()+ 1);
            match.set(t1index, t1);
            match.set(t2index, t2);
            return match;
        }
        else{
            if(t1Score> t2Score){
                t1.setPoints(t1.getPoints()+ 3);
                t1.setGd(t1.getGd() + t1Score - t2Score);
                t2.setGd(t2.getGd() + t2Score - t1Score);
                match.set(t1index, t1);
                match.set(t2index, t2);
                return match;
            }
            else{
                t2.setPoints(t2.getPoints()+ 3);
                t2.setGd(t2.getGd() + t2Score - t1Score);
                t1.setGd(t1.getGd() + t1Score - t2Score);
                match.set(t1index, t1);
                match.set(t2index, t2);
                return match;
            }
        }
    }

    public static ArrayList<Team> groupUpdater(ArrayList<Team> group, ArrayList<Team> teamAfterMatch){
        int t1index = group.indexOf(teamAfterMatch.get(0));
        int t2index = group.indexOf(teamAfterMatch.get(1));
        group.set(t1index, teamAfterMatch.get(0));
        group.set(t2index, teamAfterMatch.get(1));
        return group;
    }
    public static ArrayList<Team> groupStandings(ArrayList<Team> group){
        Collections.sort(group, Team.TeamPointsNo);
        return group;
    }
    public static void groupStandingsDisplay(ArrayList<Team> group){
        group = groupStandings(group);
        for (Team str : group) {
            System.out.println(str);
        }
    }

    public static ArrayList<Team>groupStageSim(ArrayList<ArrayList<Team>> groups){
        Scanner sc = new Scanner(System.in);
        ArrayList<Team> finalists = new ArrayList<>();
        ArrayList<String> alphabet = new ArrayList<>();
        Collections.addAll(alphabet, "A", "B", "C", "D", "E", "F", "G", "H");
        for(int i =0; i<8;i++){
            ArrayList<Team> currentGroup = groups.get(i);
            System.out.println("Would you like to continue with actual Group "+alphabet.get(i)+" standings? \n1 - YES\n2 - NO");
            int userOption = sc.nextInt();
            if(userOption == 1){
                if(alphabet.get(i).equals("A")){
                    Team team1 = Team.getTeamByName("Netherlands", currentGroup);
                    team1.setPoints(7);
                    team1.setGd(4);
                    Team team2 = Team.getTeamByName("Senegal", currentGroup);
                    team2.setPoints(6);
                    team2.setGd(1);
                    Collections.addAll(finalists, team1, team2);
                }
                if(alphabet.get(i).equals("B")){
                    Team team1 = Team.getTeamByName("England", currentGroup);
                    team1.setPoints(7);
                    team1.setGd(7);
                    Team team2 = Team.getTeamByName("USA", currentGroup);
                    team2.setPoints(5);
                    team2.setGd(1);
                    Collections.addAll(finalists, team1, team2);
                }
                if(alphabet.get(i).equals("C")){
                    Team team1 = Team.getTeamByName("Argentina", currentGroup);
                    team1.setPoints(6);
                    team1.setGd(3);
                    Team team2 = Team.getTeamByName("Poland", currentGroup);
                    team2.setPoints(4);
                    team2.setGd(0);
                    Collections.addAll(finalists, team1, team2);
                }
                if(alphabet.get(i).equals("D")){
                    Team team1 = Team.getTeamByName("France", currentGroup);
                    team1.setPoints(6);
                    team1.setGd(3);
                    Team team2 = Team.getTeamByName("Australia", currentGroup);
                    team2.setPoints(6);
                    team2.setGd(-1);
                    Collections.addAll(finalists, team1, team2);
                }
                if(alphabet.get(i).equals("E")){
                    Team team1 = Team.getTeamByName("Japan", currentGroup);
                    team1.setPoints(6);
                    team1.setGd(1);
                    Team team2 = Team.getTeamByName("Spain", currentGroup);
                    team2.setPoints(4);
                    team2.setGd(6);
                    Collections.addAll(finalists, team1, team2);
                }
                if(alphabet.get(i).equals("F")){
                    Team team1 = Team.getTeamByName("Morocco", currentGroup);
                    team1.setPoints(7);
                    team1.setGd(3);
                    Team team2 = Team.getTeamByName("Croatia", currentGroup);
                    team2.setPoints(5);
                    team2.setGd(3);
                    Collections.addAll(finalists, team1, team2);
                }
                if(alphabet.get(i).equals("G")){
                    Team team1 = Team.getTeamByName("Brazil", currentGroup);
                    team1.setPoints(6);
                    team1.setGd(2);
                    Team team2 = Team.getTeamByName("Switzerland", currentGroup);
                    team2.setPoints(6);
                    team2.setGd(1);
                    Collections.addAll(finalists, team1, team2);
                }
                if(alphabet.get(i).equals("H")){
                    Team team1 = Team.getTeamByName("Portugal", currentGroup);
                    team1.setPoints(6);
                    team1.setGd(2);
                    Team team2 = Team.getTeamByName("South Korea", currentGroup);
                    team2.setPoints(4);
                    team2.setGd(0);
                    Collections.addAll(finalists, team1, team2);
                }
            }
            else{
                ArrayList<ArrayList<Team>> currentGroupMatches = new ArrayList<>();
                currentGroupMatches = groupMatchMaker(currentGroup);
                for(int x=0;x<6;x++){
                    Team team1 = currentGroupMatches.get(x).get(0);
                    Team team2 = currentGroupMatches.get(x).get(1);
                    System.out.println(matchDisplay(team1,team2));
                    System.out.println(team1.getName()+": ");
                    int s1 = sc.nextInt();
                    System.out.println(team2.getName()+": ");
                    int s2 = sc.nextInt();
                    System.out.println(scoreLineDisplay(team1, team2, s1, s2));
                    ArrayList<Team> teamsAfterMatch = matchDay(team1, team2, s1, s2, currentGroupMatches.get(x));
                    currentGroup = groupUpdater(currentGroup, teamsAfterMatch);
                }
                System.out.println("FINAL GROUP STANDINGS");
                groupStandingsDisplay(currentGroup);
                Collections.addAll(finalists, currentGroup.get(0), currentGroup.get(1));
            }
        }
        return finalists;
    }


    public static Team kOMatchDay(ArrayList<Team> match, Integer t1Score, Integer t2Score){
        Team t1 = match.get(0);
        Team t2 = match.get(1);
        if(t1Score > t2Score){
            return t1;
        }
        else{
            return t2;
        }
    }

    public static ArrayList<ArrayList<Team>> formatWinners(ArrayList<Team> koTeams){
        ArrayList<ArrayList<Team>> finalists = new ArrayList<>();
        for(int i=0;i<koTeams.size();i+=2){
            ArrayList<Team> groupWinners = new ArrayList<>();
            Collections.addAll(groupWinners, koTeams.get(i), koTeams.get(i+1));
            finalists.add(groupWinners);
        }
        return finalists;
    }

    public static ArrayList<ArrayList<Team>> initiateKoMatches(ArrayList<Team> koTeams){
        ArrayList<ArrayList<Team>> finalists = formatWinners(koTeams);
        ArrayList<ArrayList<Team>> koMatches  = new ArrayList<>();
        //left
        for(int i=0; i<7;i+=2){
            ArrayList<Team> koMatch = new ArrayList<>();
            Collections.addAll(koMatch, finalists.get(i).get(0), finalists.get(i+1).get(1));
            koMatches.add(koMatch);
        }
        //right
        for(int i=0; i<7;i+=2){
            ArrayList<Team> koMatch = new ArrayList<>();
            Collections.addAll(koMatch, finalists.get(i).get(1), finalists.get(i+1).get(0));
            koMatches.add(koMatch);
        }
        return koMatches;
    }

    public static Team koStageSim(ArrayList<Team> koTeams){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Team>> koMatches = initiateKoMatches(koTeams);

        for(int x=0; x<4;x++){
            ArrayList<Team> koWinners = new ArrayList<>();

            for(int i=0; i<koMatches.size();i++){
                Team team1 = koMatches.get(i).get(0);
                Team team2 = koMatches.get(i).get(1);
                System.out.println(matchDisplay(team1,team2));
                System.out.println(team1.getName()+": ");
                int s1 = sc.nextInt();
                System.out.println(team2.getName()+": ");
                int s2 = sc.nextInt();
                System.out.println(scoreLineDisplay(team1, team2, s1, s2));
                Team winner = kOMatchDay(koMatches.get(i), s1, s2);
                koWinners.add(winner);
            }
            if(koWinners.size()>1){
                ArrayList<ArrayList<Team>> newKoMatches = new ArrayList<>();
                for(int i=0; i<koWinners.size();i+=2){
                    ArrayList<Team> koMatch = new ArrayList<>();
                    Collections.addAll(koMatch, koWinners.get(i), koWinners.get(i+1));
                    newKoMatches.add(koMatch);
                }
                koMatches = newKoMatches;
            }
        }
        return koMatches.get(0).get(0);
    }
}