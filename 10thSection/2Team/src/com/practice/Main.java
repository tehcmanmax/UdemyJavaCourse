/*Implementing teams and players in OOP with generics*/
package com.practice;
// EXEMPLARY CODE

// ArrayList<Team> teams;
// Collections.sort(teams);
// Create a generic class to implement a league table for a sport.
// The class should allow teams to be added to the list, and store
// a list of teams that belong to the league.
//
// Your class should have a method to print out the teams in order,
// with the team at the top of the league printed first.
//
// Only teams of the same type should be added to any particular
// instance of the league class - the program should fail to compile
// if an attempt is made to add an incompatible team.


public class Main {

    public static void main(String[] args) {
        Team<SoccerPlayer> ourTeamUAM = new Team<>("UAM");
        Team<SoccerPlayer> politech = new Team<>("Poznańska Politechnika");
        Team<SoccerPlayer> uniwerKarola = new Team<>("Med. Uniwersytet Karola");

        Team<BasketballPlayer> basketStreetWolves = new Team<>("Street Wolves");
        Team<BasketballPlayer> basketFoxes = new Team<>("Foxes");

        //One may add the players to team
        SoccerPlayer md = new SoccerPlayer("MD", 42);
        SoccerPlayer player1 = new SoccerPlayer("Enemy1", 1);
        SoccerPlayer player2 = new SoccerPlayer("Enemy2", 2);

        BasketballPlayer jordan = new BasketballPlayer("Michel Jordan", 1);
        basketFoxes.addToTeam(jordan);

        //Adding the league
        League<Team<SoccerPlayer>> championship = new League<>("League of Champions");
        championship.addTeamsToLeague(ourTeamUAM);
        championship.addTeamsToLeague(politech);
        championship.addTeamsToLeague(uniwerKarola);

        //game
        ourTeamUAM.gameResult(politech, 1, 0);
        ourTeamUAM.gameResult(uniwerKarola, 3, 1);

        uniwerKarola.gameResult(politech, 4, 0);
        uniwerKarola.gameResult(ourTeamUAM, 12, 7);

        politech.gameResult(ourTeamUAM, 0, 5);
        politech.gameResult(uniwerKarola, 1, 1);

        championship.printSortedLeagueTeams(); //descending order
        ////

        League<Team<BasketballPlayer>> goldenNet = new League<>("Golden Net");

        goldenNet.addTeamsToLeague(basketFoxes);
        goldenNet.addTeamsToLeague(basketStreetWolves);

        basketFoxes.gameResult(basketStreetWolves, 3, 4);

        goldenNet.printSortedLeagueTeams();
    }
}