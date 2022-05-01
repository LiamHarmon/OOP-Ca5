package com.company.PART2.DAOS;

import com.company.PART2.DTOs.Player;
import com.company.PART2.Exceptions.DaoException;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MySqlPlayerDao extends MySqlDao implements PlayerDaoInterface
{

    @Override
    public List<Player> findAllPlayers() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Player> playerList = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM PLAYER";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int playerId = resultSet.getInt("PLAYER_ID");
                String full_name = resultSet.getString("FULL_NAME");
                String position = resultSet.getString("POSITION");
                int caps = resultSet.getInt("CAPS");
                double total_time = resultSet.getDouble("TOTAL_TIME");
                Player p = new Player(playerId, full_name, position, caps, total_time);
                playerList.add(p);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllPlayerResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllUsers() " + e.getMessage());
            }
        }
        return playerList;     // may be empty
    }

    @Override
    public Player findPlayerByID(String player_id) throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Player player = null;

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM PLAYER WHERE PLAYER_ID = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, player_id);


            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            if (resultSet.next())
            {
                int playerId = resultSet.getInt("PLAYER_ID");
                String full_name = resultSet.getString("FULL_NAME");
                String position = resultSet.getString("POSITION");
                int caps = resultSet.getInt("CAPS");
                double total_time = resultSet.getDouble("TOTAL_TIME");

                player = new Player(playerId, full_name, position, caps, total_time);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllPlayerResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findPlayerByID() " + e.getMessage());
            }
        }
        return player;     // may be empty
    }

    @Override
    public void deletePlayerByID(String player_id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.getConnection();

            String query = "DELETE FROM six_nations.player WHERE PLAYER_ID = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, player_id);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void addPlayer(String full_name, String position, int caps, double total_time) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.getConnection();

            String query = "INSERT INTO six_nations.player VALUES (null, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, full_name);
            preparedStatement.setString(2, position);
            preparedStatement.setInt(3, caps);
            preparedStatement.setDouble(4, total_time);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String JSONFindAllPlayers() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Player> playerList = new ArrayList<>();
        String jsonString = "";
        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM PLAYER";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int playerId = resultSet.getInt("PLAYER_ID");
                String full_name = resultSet.getString("FULL_NAME");
                String position = resultSet.getString("POSITION");
                int caps = resultSet.getInt("CAPS");
                double total_time = resultSet.getDouble("TOTAL_TIME");
                Player p = new Player(playerId, full_name, position, caps, total_time);
                playerList.add(p);
            }
            Gson gsonParser = new Gson();

            jsonString = gsonParser.toJson(playerList);
        } catch (SQLException e)
        {
            throw new DaoException("findAllPlayerResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllUsers() " + e.getMessage());
            }
        }
        return jsonString;     // may be empty
    }

    @Override
    public String JSONFindPlayerByID(String player_id) throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Player player = null;
        String jsonString = "";

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM PLAYER WHERE PLAYER_ID = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, player_id);


            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            if (resultSet.next())
            {
                int playerId = resultSet.getInt("PLAYER_ID");
                String full_name = resultSet.getString("FULL_NAME");
                String position = resultSet.getString("POSITION");
                int caps = resultSet.getInt("CAPS");
                double total_time = resultSet.getDouble("TOTAL_TIME");

                player = new Player(playerId, full_name, position, caps, total_time);
            }
            Gson gsonParser = new Gson();

            jsonString = gsonParser.toJson(player);
        } catch (SQLException e)
        {
            throw new DaoException("findAllPlayerResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findPlayerByID() " + e.getMessage());
            }
        }
        return jsonString;     // may be empty
    }
}


