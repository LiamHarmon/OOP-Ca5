package com.company.PART3;

/**
 * CLIENT                                                  March 2021
 * <p>
 * This Client program asks the user to input commands to be sent to the server.
 * <p>
 * There are only two valid commands in the protocol: "Time" and "Echo"
 * <p>
 * If user types "Time" the server should reply with the current server time.
 * <p>
 * If the user types "Echo" followed by a message, the server will echo back the message.
 * e.g. "Echo Nice to meet you"
 * <p>
 * If the user enters any other input, the server will not understand, and
 * will send back a message to the effect.
 * <p>
 * NOte: You must run the server before running this the client.
 * (Both the server and the client will be running together on this computer)
 */


import com.company.PART1.SortType;
import com.company.PART3.DTOs.ComparePlayer;
import com.company.PART3.DTOs.Player;
import com.company.PART3.DTOs.PlayerCapComparator;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 8080);  // connect to server socket
            System.out.println("Client: Port# of this client : " + socket.getLocalPort());
            System.out.println("Client: Port# of Server :" + socket.getPort());

            System.out.println("Client message: The Client is running and has connected to the server");

            System.out.println("Client Side Menu\n");
            System.out.println("1: Display All Players");
            System.out.println("2: Display Player By ID");
            System.out.println("3: Add Player");
            System.out.println("4: Delete Player By ID");
            System.out.println("5: Display All in Order of Caps\n");
            System.out.println("Enter next command");
            String command = in.next();

            OutputStream os = socket.getOutputStream();
            PrintWriter socketWriter = new PrintWriter(os, true);   // true => auto flush buffers

            socketWriter.println(command);

            Scanner socketReader = new Scanner(socket.getInputStream());  // wait for, and retrieve the reply
            boolean keep_looping = true;
            while (keep_looping == true) {
                if (command.startsWith("1"))   //we expect the server to return a time
                {
                    System.out.println("Display All Players Chosen\n");
                    String player = socketReader.nextLine();
                    System.out.println(player);
                } else if (command.startsWith("2"))                            // the user has entered the Echo command or an invalid command
                {
                    System.out.println("Display Player By ID Chosen\n");
                    System.out.println("Enter Player ID");
                    int player_id = in.nextInt();
                    socketWriter.println(player_id);
                    String displayPlayerByID = socketReader.nextLine();
                    System.out.println(displayPlayerByID);
                }
                else if (command.startsWith("3"))
                {
                    Scanner keyboard = new Scanner(System.in);

                    System.out.println("Add Player Chosen\n");
                    System.out.println("Enter Name");
                    String full_name = keyboard.nextLine();
                    System.out.println("Enter Position");
                    String position = keyboard.nextLine();
                    System.out.println("Enter Caps");
                    int caps = keyboard.nextInt();
                    System.out.println("Enter Total Time");
                    double total_time = keyboard.nextDouble();

                    String addPlayer =  full_name + "," + position + "," + caps + "," + total_time;
                    System.out.println();
                    socketWriter.println(addPlayer);

                }
                else if (command.startsWith("4"))
                {
                    System.out.println("Delete Player By ID Chosen\n");
                    System.out.println("Enter Player ID");
                    int player_id = in.nextInt();
                    socketWriter.println(player_id);
                    String deletePlayer = socketReader.nextLine();
                    System.out.println(deletePlayer);
                }
                else if (command.startsWith("5"))                            // the user has entered the Echo command or an invalid command
                {
                    System.out.println("Display All Players In Order of Caps Chosen\n");
                    String player = socketReader.nextLine();
                    System.out.println(player(new PlayerCapComparator(SortType.Ascending)));
                }
                System.out.println("Client Side Menu\n");
                System.out.println("1: Display All Players");
                System.out.println("2: Display Player By ID");
                System.out.println("3: Add Player");
                System.out.println("4: Delete Player By ID");
                System.out.println("5: Display All in Order of Caps\n");
                System.out.println("Enter next command");
                command = in.next();
                socketWriter.println(command);
            }
                socketWriter.close();
                socketReader.close();
                socket.close();


        } catch (IOException e) {
            System.out.println("Client message: IOException: " + e);
        }
    }

    private boolean player(PlayerCapComparator playerCapComparator) {
        return true;
    }
}


//  LocalTime time = LocalTime.parse(timeString); // Parse timeString -> convert to LocalTime object if required