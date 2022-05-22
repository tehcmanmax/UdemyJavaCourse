package com.practice;
//Best way to use the class (including initialization) is from the Main class not from the Team class

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings({"rawtypes", "unchecked"})

public class League<T extends Team> {
    private String seasonYear; // 2020/2021
    private String leagueName; // Championship
    private ArrayList<T> teams; // saves teams

    public League(String leagueName) {
        this.seasonYear = "2021/2022";
        this.leagueName = leagueName;
        this.teams = new ArrayList<>();
    }

    public void addTeamsToLeague(T team) {
        if(this.teams.contains(team))
            System.out.println("Could not added since " + team.getTeamName() + " is already there");
        else
            this.teams.add(team);
    }

    public void printSortedLeagueTeams() {
        Collections.sort(teams); // uses Comparable from the Team class, thus, able to sort
        for(T e : teams)
            System.out.println(e.getTeamName() + " ranking: " + e.rank());
    }

    public String getSeasonYear() {
        return seasonYear;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public ArrayList<T> getTeams() {
        return teams;
    }
}