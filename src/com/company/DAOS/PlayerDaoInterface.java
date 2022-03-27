package com.company.DAOS;

import com.company.DTOs.Player;
import com.company.Exceptions.DaoException;

import java.util.List;

public interface PlayerDaoInterface
{
    public List<Player> findAllPlayers() throws DaoException;

    public Player findPlayerByID(String player_id) throws  DaoException;

}

