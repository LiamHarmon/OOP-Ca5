package com.company.PlayerApp;

import java.io.IOException;
import java.util.*;

import com.company.DAOS.MySqlPlayerDao;
import com.company.DAOS.PlayerDaoInterface;
import com.company.DTOs.ComparePlayer;
import com.company.DTOs.Player;
import com.company.Exceptions.DaoException;

// Liam Harmon SD2b

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    public void start() {
        try {
            displayMainMenu();        // User Interface - Menu
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Program ending, Goodbye");
    }

    private void displayMainMenu() throws IOException {

        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"
                + "1. FindAllPlayersFromSql\n"
                + "2, FindPlayerByID\n"
                + "3, DeletePlayerByID\n"
                + "4, AddPlayer\n"
                + "5, JSONFindAllPlayers\n"
                + "6, JSONFindPlayerByID\n"
                + "7. Exit\n"
                + "Enter Option [1,7]";

        final int FINDALLPLAYERSFROMSQL = 1;
        final int FINDPLAYERBYID = 2;
        final int DELETEPLAYERBYID = 3;
        final int ADDPLAYER = 4;
        final int JSONFINDALLPLAYERS = 5;
        final int JSONFINDPLAYERBYID = 6;
        final int EXIT = 7;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case FINDALLPLAYERSFROMSQL:
                        System.out.println("Find all Players from MySQL Database");
                        FindAllPlayers();
                        break;
                    case FINDPLAYERBYID:
                        System.out.println("Find Players By ID from MySQL Database");
                        findPlayerByID();
                        break;
                    case DELETEPLAYERBYID:
                        System.out.println("Delete Player By ID from MySQL Database");
                        deletePlayerByID();
                        break;
                    case ADDPLAYER:
                        System.out.println("Add Player to MySQL Database");
                        addPlayer();
                        break;
                    case JSONFINDALLPLAYERS:
                        System.out.println("Find Players And Put Into JSON Format From MySQL Database");
                        JSONFindAllPlayers();
                        break;
                    case JSONFINDPLAYERBYID:
                        System.out.println("Find Player By ID And Put Into JSON Format From MySQL Database");
                        JSONFindPlayerByID();
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException | DaoException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Main Menu, goodbye.");

    }


    public void FindAllPlayers() {
        PlayerDaoInterface IPlayerDao = new MySqlPlayerDao();

        try {
            System.out.println("\n============================");
            System.out.println("Call FindAllPlayers()");
            System.out.println("============================\n");
            List<Player> players = IPlayerDao.findAllPlayers();     // call a method in the DAO
            players.sort(new ComparePlayer());

            if (players.isEmpty())
                System.out.println("There are no Players");
            else {
                for (Player player : players)
                    System.out.println("Player: " + player.toString());
            }

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void findPlayerByID() throws DaoException {
        PlayerDaoInterface IPlayerDao = new MySqlPlayerDao();

        try {
            System.out.println("\n============================");
            System.out.println("Call: findPlayerByID()");
            System.out.println("============================\n");
            System.out.println("Enter value between 1-10");
            Scanner kb = new Scanner(System.in);
            String player_id = kb.nextLine();
            Player player = IPlayerDao.findPlayerByID(player_id);

            if (player != null) // null returned if userid and password not valid
                System.out.println("Player found: " + player);
            else
                System.out.println("Player with that key not found");

        }catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void deletePlayerByID() throws DaoException {
        PlayerDaoInterface IPlayerDao = new MySqlPlayerDao();

        try {
            System.out.println("\n============================");
            System.out.println("Call: deletePlayerByID()");
            System.out.println("============================\n");
            System.out.println("Enter valid playerID");
            Scanner kb = new Scanner(System.in);
            String player_id = kb.nextLine();
            IPlayerDao.deletePlayerByID(player_id);

            if (player_id != null)
                System.out.println("Player deleted");
            else
                System.out.println("Player with that key not found");

        }catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void addPlayer() throws DaoException {
        PlayerDaoInterface IPlayerDao = new MySqlPlayerDao();

        try {
            System.out.println("\nCall: addPlayer()\n");
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter A Six Nations Players FUll Name");
            String full_name = kb.nextLine();
            System.out.println("\nEnter The Players Position");
            String position = kb.nextLine();
            System.out.println("\nEnter Players Caps For Their Team");
            int caps = kb.nextInt();
            System.out.println("\nEnter Players Total Time on The Pitch");
            double total_time = kb.nextDouble();
            IPlayerDao.addPlayer(full_name, position, caps, total_time);

            System.out.println("Player Added");

        }catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void JSONFindAllPlayers() throws DaoException{
        PlayerDaoInterface IPlayerDao = new MySqlPlayerDao();

        try {
            System.out.println("\n============================");
            System.out.println("Call FindAllPlayers()");
            System.out.println("============================\n");
            String playerJSON = IPlayerDao.JSONFindAllPlayers();     // call a method in the DAO

            System.out.println(playerJSON);

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void JSONFindPlayerByID() throws DaoException{
        PlayerDaoInterface IPlayerDao = new MySqlPlayerDao();

        try {
            System.out.println("\n============================");
            System.out.println("Call: findPlayerByID()");
            System.out.println("============================\n");
            System.out.println("Enter value between 1-10");
            Scanner kb = new Scanner(System.in);
            String player_id = kb.nextLine();
            String playerJSON = IPlayerDao.JSONFindPlayerByID(player_id);

            System.out.println(playerJSON);

        }catch (DaoException e) {
            e.printStackTrace();
        }
    }

}
