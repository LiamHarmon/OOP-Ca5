package com.company;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        Main app = new Main();
        app.start();
    }

    public void start()
    {
        try
        {
            displayMainMenu();        // User Interface - Menu
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("Program ending, Goodbye");
    }

    private void displayMainMenu() throws IOException {

        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"
                + "1. ArrayList\n"
                + "2. HashMap\n"
                + "3. TreeMap\n"
                + "4. Exit\n"
                + "Enter Option [1,4]";

        final int ARRAYLIST = 1;
        final int HASHMAP = 2;
        final int TREEMAP = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do
        {
            System.out.println("\n" + MENU_ITEMS);
            try
            {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {
                    case ARRAYLIST:
                        System.out.println("ArrayList option chosen");
                        ArrayList1();
                        break;
                    case HASHMAP:
                        System.out.println("HashMap option chosen");
                        HashMap();
                        break;
                    case TREEMAP:
                        System.out.println("TreeMap option chosen");

                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Main Menu, goodbye.");

    }

public static void ArrayList1()
{
    ArrayList<Player> playerList = new ArrayList<>();

    playerList.add(new Player("Bundee Aki","Centre",35,281.00));
    playerList.add(new Player("Joey Carbery","Flyhalf",30,262.00));
    playerList.add(new Player("Keith Earls","Fullback/Wing",96,36.00));
    playerList.add(new Player("Tadhg Furlong","Prop",55,362.00));
    playerList.add(new Player("Cian Healy","Prop",114,73.00));
    playerList.add(new Player("Iain Henderson","Lock/Back Row",66,93.00));
    playerList.add(new Player("Robbie Henshaw","Centre/Fullback",55,150.00));
    playerList.add(new Player("Conor Murray","Scrumhalf",94,110.00));
    playerList.add(new Player("Peter O'Mahony","Back Row",82,244.00));
    playerList.add(new Player("Johnny Sexton","Flyhalf",103,216.00));

    System.out.printf("%5s %15s %15s %20s %n", "Name", "Position", "Caps", "Total Time");

    for(Player player : playerList)
    {
        System.out.println(player);
    }
}

public static void HashMap()
{
    Map<Integer, Player> playerMap = new HashMap<>();

    playerMap.put(1, new Player("Bundee Aki","Centre",35,281.00));
    playerMap.put(2, new Player("Joey Carbery","Flyhalf",30,262.00));
    playerMap.put(3, new Player("Keith Earls","Fullback/Wing",96,36.00));
    playerMap.put(4, new Player("Tadhg Furlong","Prop",55,362.00));
    playerMap.put(5, new Player("Cian Healy","Prop",114,73.00));
    playerMap.put(6, new Player("Iain Henderson","Lock/Back Row",66,93.00));
    playerMap.put(7, new Player("Robbie Henshaw","Centre/Fullback",55,150.00));
    playerMap.put(8, new Player("Conor Murray","Scrumhalf",94,110.00));
    playerMap.put(9, new Player("Peter O'Mahony","Back Row",82,244.00));
    playerMap.put(10,new Player("Johnny Sexton","Flyhalf",103,216.00));

    Set<Integer> keySet = playerMap.keySet();

    for (Integer key : keySet) {
        Player player = playerMap.get(key);
        System.out.println("Player_ID: " + key + " Name: "
                + player.getName() + " " +
                " " + "Position: " + player.getPosition() + " " + "Caps: " + player.getCaps() + " " + "Total Time: " + player.getTotalTime());
    }
}

}
