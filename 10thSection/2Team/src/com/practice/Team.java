package com.practice;
/* Things to implement
 * getName
 * addPlayer (most complex)
 * numberOfPlayers
 * gameResult
 *
 * Next, make this class only accept to members only certain type of players (parameterized type)
 * Next, make ranking system
 * Then, compare each command and sort best team descending (just an idea)
 * */

/*League:
 *   season, team, league name
 * Team:
 *   adds to league */

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> { //upper bound and build in comparable static function

    private String teamName;
    private ArrayList<T> members;
    private int win, lose, draw, played, numberOfPlayers;

    public Team(String name) {
        this.teamName = name;

        this.members = new ArrayList<>();
    }

    public void addToTeam(T player) {
        if(members.contains(player)) {

            // (FootballPlayer)player) -- casting to class if I weren't specify the upper bound
            System.out.println("The player " + player.getName() + " already in team " + this.teamName);
            return;
        }
        members.add(player);
        System.out.println("Player " + player.getName() + " is added to " + this.teamName);
        this.numberOfPlayers++;
    }

    public void gameResult(Team<T> opponentTeam, int ourScore, int theirScore) {
        if(opponentTeam == null || this.teamName.contains(opponentTeam.teamName)) {
            System.out.println("Please, enter a valid opponent!");
            return;
        }
        this.played++;
        opponentTeam.played++;

        if(ourScore > theirScore) {
            this.win++;
            opponentTeam.lose++;
        } else if(ourScore == theirScore) {
            this.draw++;
            opponentTeam.draw++;
        } else {
            this.lose++;
            opponentTeam.win++;
        }
        //        opponentTeam.gameResult(null,theirScore,ourScore); I can possible do this, but it doesn't makes sense in this context

    }

    //    TAKE AWAY
    public String getMembers() {
        String stringMembers = members.toString();

        //getting rid of the square bracket when printing the list entries
        //https://stackoverflow.com/questions/31718178/how-to-remove-the-brackets-from-arraylisttostringx
        return stringMembers.substring(1, (stringMembers.length() - 1)) + '\n';
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public String getTeamName() {
        return teamName;
    }

    public int rank() {
        return (this.win * 3) + this.draw + this.played;
    }

    @Override
    public String toString() {
        if(this.played == 0) {
            return "Your team " + this.teamName + " played no game";
        }
        System.out.println(); //indentation
        System.out.println("Team " + "teamName='" + teamName + '\'' + "\nwin=" + win + "\nlose=" + lose + "\ndraw=" + draw + "\nplayed=" + played + "\nnumberOfPlayers=" + numberOfPlayers);
        System.out.println("Players of the team: ");
        return getMembers();
    }

    @Override
    public int compareTo(Team<T> o) { // if 1st argument is bigger then 1. If 2nd then -1. else 0
        if(this.rank() > o.rank()) {
            return -1;
        } else if(this.rank() < o.rank()) {
            return 1;
        } else {
            return 0;
        }
    }
}