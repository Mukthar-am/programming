package com.muks.java.design.SnakeAndLadder.test;

import com.muks.java.design.SnakeAndLadder.dao.Player;
import com.muks.java.design.SnakeAndLadder.dao.Tournment;
import com.muks.java.design.SnakeAndLadder.main.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Testing {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future> allThreads = new ArrayList<>();    /** track all submitted threads */

        Player p1 = new Player(1, "mukthar");
        Player p2 = new Player(2, "ahmed");
        Player p3 = new Player(3, "maniyar");
        Player p4 = new Player(4, "muks");

        Tournment tournment = new Tournment(1);
        try {
            tournment.addPlayer(p1);
            tournment.addPlayer(p2);
            tournment.addPlayer(p3);
            tournment.addPlayer(p4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("Tournment: " + tournment);

        Game game = new Game("GameBoard-1", 1);
        game.run();

    }
}
