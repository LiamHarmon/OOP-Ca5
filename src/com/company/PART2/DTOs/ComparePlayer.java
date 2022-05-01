package com.company.PART2.DTOs;

import java.util.Comparator;

public class ComparePlayer implements Comparator<Player>
{

    public int compare(Player p1, Player p2)
    {
        if(p1.getFull_name().equalsIgnoreCase(p2.getFull_name()))
        {
            return p1.getCaps() - p2.getCaps();
        }
        else
        {
            return p1.getFull_name().compareToIgnoreCase(p2.getFull_name());
        }
    }
}
