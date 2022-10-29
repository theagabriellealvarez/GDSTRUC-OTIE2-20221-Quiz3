package com.gdstruc.otie.module4;

import java.util.NoSuchElementException;

public class ArrayQueue {
    private Player[] queue;
    private  int front;
    private  int back;

    public ArrayQueue(int capacity) {
        queue = new Player[capacity];
        front = 0;
        back = 0;
    }

    // add player at the back of the queue
    public void enqueue(Player player) {
        if (back == queue.length) {
            Player[] newQueue = new Player[queue.length * 2];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }

        queue[back] = player;
        back++;
    }

    // remove the player that is in front of the queue
    public Player dequeue() {
        if (size() == 0) {
            throw  new NoSuchElementException();
        }

        Player removedPlayer = queue[front];
        front++;

        // reset the trackers to the first element of the array
        // when array is empty
        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return  removedPlayer;
    }

    // access the front player
    public Player peek() {
        if (size() == 0) {
            throw  new NoSuchElementException();
        }

        return queue[front];
    }

    // get the number of elements in queue
    public int size() {
        return back - front;
    }

    // print all the elements of the queue
    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
