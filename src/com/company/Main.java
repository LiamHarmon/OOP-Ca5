package com.company;

import java.io.IOException;
import java.util.*;

// Liam Harmon SD2b

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
                + "4. PriorityQueue\n"
                + "5. PriorityQueue1\n"
                + "6. Exit\n"
                + "Enter Option [1,6]";

        final int ARRAYLIST = 1;
        final int HASHMAP = 2;
        final int TREEMAP = 3;
        final int PRIORITYQUEUE = 4;
        final int PRIORITYQUEUE1 = 5;
        final int EXIT = 6;

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
                        TreeMap();
                        break;
                    case PRIORITYQUEUE:
                        System.out.println("PriorityQueue option chosen");
                        PriorityQueue();
                        break;
                    case PRIORITYQUEUE1:
                        System.out.println("PriorityQueue Compare option chosen");
                        PlayerComapare();
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

    for(Player player : playerList)
    {
        System.out.println(player + ",");
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

    System.out.println("All values from the Map:");
    Collection<Player> values = playerMap.values(); // get all the values
    for (Player p : values) {
        System.out.println(p + ", ");
    }

        System.out.println("\n");
        Scanner kb = new Scanner(System.in);
        System.out.println("\nEnter a Key(1-10) to search for a player. Type 0 to exit");
        int key = kb.nextInt();
        Player player = playerMap.get(key);
    if(player != null)
    {
        System.out.println(key + " favourite player is: " + player);
    }else{
        System.out.println("The key: " + key + " could not be found.");
    }
}

public static void TreeMap()
{
    Map<Long, Player> playerTree = new TreeMap<>();

    playerTree.put(10L, new Player("Bundee Aki","Centre",35,281.00));
    playerTree.put(7L, new Player("Joey Carbery","Flyhalf",30,262.00));
    playerTree.put(8L, new Player("Keith Earls","Fullback/Wing",96,36.00));
    playerTree.put(4L, new Player("Tadhg Furlong","Prop",55,362.00));
    playerTree.put(5L, new Player("Cian Healy","Prop",114,73.00));
    playerTree.put(6L, new Player("Iain Henderson","Lock/Back Row",66,93.00));
    playerTree.put(2L, new Player("Robbie Henshaw","Centre/Fullback",55,150.00));
    playerTree.put(3L, new Player("Conor Murray","Scrumhalf",94,110.00));
    playerTree.put(9L, new Player("Peter O'Mahony","Back Row",82,244.00));
    playerTree.put(1L,new Player("Johnny Sexton","Flyhalf",103,216.00));

    Set<Long> keySet = playerTree.keySet();

    for (Long key : keySet) {
        Player player = playerTree.get(key);
        System.out.println("Key: " + key
                + player.getName() + ", Position: " + player.getPosition() + ", Caps: " + player.getCaps() + ", Total Time: " + player.getTotalTime());
    }
}

public static void PriorityQueue()
{
    PriorityQueue<Player> queuePlayer = new PriorityQueue<Player>(new PlayerCapComparator(SortType.Ascending));

    queuePlayer.add(new Player("Bundee Aki","Centre",35,281.00));
    queuePlayer.add(new Player("Joey Carbery","Flyhalf",30,262.00));
    queuePlayer.add(new Player("Keith Earls","Fullback/Wing",96,36.00));
    queuePlayer.add(new Player("Tadhg Furlong","Prop",55,362.00));
    queuePlayer.add(new Player("Cian Healy","Prop",114,73.00));
    queuePlayer.add(new Player("Iain Henderson","Lock/Back Row",66,93.00));
    queuePlayer.add(new Player("Robbie Henshaw","Centre/Fullback",55,150.00));
    queuePlayer.add(new Player("Conor Murray","Scrumhalf",94,110.00));
    queuePlayer.add(new Player("Peter O'Mahony","Back Row",82,244.00));
    queuePlayer.add(new Player("Johnny Sexton","Flyhalf",103,216.00));

    System.out.println("Values in order of Age Priority:");
    Iterator<Player> iterator = queuePlayer.iterator();
    while (iterator.hasNext()) {
        System.out.println(queuePlayer.remove());
    }
}

public static void PlayerComapare()
{
    PriorityQueue<Player> queuePlayer1 = new PriorityQueue<Player>();

    queuePlayer1.add(new Player("Bundee Aki","Centre",35,281.00));
    queuePlayer1.add(new Player("Joey Carbery","Flyhalf",30,262.00));
    queuePlayer1.add(new Player("Keith Earls","Fullback/Wing",96,36.00));
    queuePlayer1.add(new Player("Tadhg Furlong","Prop",55,362.00));
    queuePlayer1.add(new Player("Cian Healy","Prop",114,73.00));
    queuePlayer1.add(new Player("Iain Henderson","Lock/Back Row",66,93.00));
    queuePlayer1.add(new Player("Robbie Henshaw","Centre/Fullback",55,150.00));
    queuePlayer1.add(new Player("Conor Murray","Scrumhalf",94,110.00));
    queuePlayer1.add(new Player("Peter O'Mahony","Back Row",82,244.00));
    queuePlayer1.add(new Player("Johnny Sexton","Flyhalf",103,216.00));

    System.out.println("Priority order dictated by compareTo() method in drivers class");
    Iterator<Player> iterator = queuePlayer1.iterator();
    while (iterator.hasNext()) {
        System.out.println(queuePlayer1.remove());
    }

    while(!queuePlayer1.isEmpty()){
        System.out.println(queuePlayer1.remove());
    }

}

}



