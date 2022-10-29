package com.gdstruc.otie.module4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        ArrayQueue players = new ArrayQueue(7);
        int game = 0;
        int turn = 1;

        //loop
        while (game < 10)
        {
            //print status
            System.out.println("TURN " + turn);

            //create players and enqueue
            Random rand = new Random();
            int upperbound = 7; //makes it 0-6
            int enqueueAmt = rand.nextInt(upperbound) + 1;

            for (int i = 0; i < enqueueAmt; i++)
            {
                players.enqueue(new Player(i));
            }
            System.out.println("Enqueued: " + enqueueAmt);
            System.out.println("Current Number in Queue: " + players.size());


            //check if there are 5 players and if there are dequeue them
            if (players.size() >= 5)
            {
               while (players.size() >= 5)
               {
                   for (int i = 0; i < 5; i++) {
                       players.dequeue();
                   }
                   System.out.println("GAME START (Dequeued 5 players)");
                   game++;
               }
            }
            else
            {
                System.out.println("Not enough players to start a game");
            }

            System.out.println("Current Number in Queue: " + players.size());
            System.out.println("Amount of Games Matched: " + game  + "\n");

            System.out.println("Press enter to end the round");
            Scanner scanner = new Scanner(System.in);
            String decision = scanner.nextLine();
            if (decision == decision)
            {
                turn++;
                continue;
            }
            scanner.close();
        }

    }
}