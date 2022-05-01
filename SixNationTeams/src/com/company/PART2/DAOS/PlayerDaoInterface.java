package com.company.PART2.DAOS;

import com.company.PART2.DTOs.Player;
import com.company.PART2.Exceptions.DaoException;

import java.util.List;

public interface PlayerDaoInterface
{
    public List<Player> findAllPlayers() throws DaoException;

    public Player findPlayerByID(String player_id) throws  DaoException;

    public void deletePlayerByID(String player_id) throws DaoException;

    public void addPlayer(String full_name, String position, int caps, double total_time) throws DaoException;

    public String JSONFindAllPlayers() throws DaoException;

    public String JSONFindPlayerByID(String player_id) throws DaoException;

}

