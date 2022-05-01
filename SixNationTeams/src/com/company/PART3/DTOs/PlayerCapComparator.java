package com.company.PART3.DTOs;

import com.company.PART1.Player;
import com.company.PART1.SortType;

import java.util.Comparator;

public class PlayerCapComparator implements Comparator<com.company.PART1.Player>
{
    private com.company.PART1.SortType sortType;

    public PlayerCapComparator(SortType sortType)
    {
        this.sortType = sortType;
    }

    @Override
    public int compare(com.company.PART1.Player p1, Player p2)
    {
        int direction = sortType.getValue();
        return direction * (p1.getCaps() - p2.getCaps());
    }

}
