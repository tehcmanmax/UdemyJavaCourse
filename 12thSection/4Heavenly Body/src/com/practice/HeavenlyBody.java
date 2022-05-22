package com.practice;

import java.util.*;

final public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod){
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }


    public String getName(){
        return name;
    }

    public double getOrbitalPeriod(){
        return orbitalPeriod;
    }

    public HashSet<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        HeavenlyBody that = (HeavenlyBody) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, orbitalPeriod, satellites);
    }
}
