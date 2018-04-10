package com.m3c.ane;

import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws Exception {
        int ponder = 5;
        int size = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher(
                    sticks[i], sticks[(i + 1) % size], i, ponder));
        }
        System.out.println("Press 'Enter' to quit");
        System.in.read();
        exec.shutdownNow();
    }

}