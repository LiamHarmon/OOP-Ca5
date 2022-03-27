package com.company.PlayerApp;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.company.DAOS.MySqlPlayerDao;
import com.company.DAOS.PlayerDaoInterface;
import com.company.DTOs.Player;
import com.company.Exceptions.DaoException;

import java.util.List;
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
                + "3. Exit\n"
                + "Enter Option [1,3]";

        final int FINDALLPLAYERSFROMSQL = 1;
        final int FINDPLAYERBYID = 2;
        final int EXIT = 3;

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
            System.out.println("\nCall FindAllPlayers()");
            List<Player> players = IPlayerDao.findAllPlayers();     // call a method in the DAO

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
            System.out.println("\nCall: findUserByUsernamePassword()\n");
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
}
