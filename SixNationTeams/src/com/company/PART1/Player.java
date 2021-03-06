package com.company.PART1;

import java.util.Objects;

public class Player implements Comparable<Player>
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return getCaps() == player.getCaps() && Double.compare(player.getTotalTime(), getTotalTime()) == 0 && Objects.equals(getName(), player.getName()) && Objects.equals(getPosition(), player.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition(), getCaps(), getTotalTime());
    }

    public int compareTo(Player p)
    {
        boolean bSamePlayerName =
                this.getName().equalsIgnoreCase(p.getName());

        boolean bSamePlayerPosition =
                this.getPosition().equalsIgnoreCase(p.getPosition());

        if(bSamePlayerName && bSamePlayerPosition)
        {
            return this.getCaps() - p.getCaps();
        }
        else if(!bSamePlayerName && bSamePlayerPosition)
        {
            return this.getName().compareToIgnoreCase(p.getName());
        }
        else
        {
            return this.getPosition().compareToIgnoreCase(p.getPosition());
        }
    }
}
