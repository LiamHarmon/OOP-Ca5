package com.company;

import java.util.Objects;

public class Player
{
    String name;
    String position;
    int caps;
    double totalTime;

    public Player(String name, String position, int caps, double totalTime)
    {
        this.name = name;
        this.position = position;
        this.caps = caps;
        this.totalTime = totalTime;

    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getCaps() {
        return caps;
    }

    public double getTotalTime() {
        return totalTime;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", caps=" + caps +
                ", totalTime=" + totalTime +
                '}';
    }
}
