package com.company.DAOS;

import com.company.DTOs.Player;
import com.company.Exceptions.DaoException;

import java.util.List;

public interface PlayerDaoInterface
{
    public List<Player> findAllPlayers() throws DaoException;

    public Player findPlayerByID(String player_id) throws  DaoException;

    public void deletePlayerByID(String player_id) throws DaoException;

    public void addPlayer(String full_name, String position, int caps, double total_time) throws DaoException;

}

