package com.company.PART1;

import java.util.Comparator;

public class PlayerCapComparator implements Comparator<Player>
{
    private SortType sortType;

    public PlayerCapComparator(SortType sortType)
    {
        this.sortType = sortType;
    }

    @Override
    public int compare(Player p1, Player p2)
    {
        int direction = sortType.getValue();
        return direction * (p1.getCaps() - p2.getCaps());
    }

}
