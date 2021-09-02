package com.muks.java.design.SnakeAndLadder.dao;

import java.util.LinkedList;
import java.util.Queue;

public class Tournment {
    public int Id = 0;
    public Queue<Player> PlayersQ = new LinkedList<>();
    private int MaxPlayers = 4;

    public Tournment(int id) {
        this.Id = id;
    }

    public int getId() {
        return Id;
    }

    public Queue<Player> getPlayersQ() {
        return PlayersQ;
    }

    public int getMaxPlayers() {
        return MaxPlayers;
    }

    public void addPlayer(Player player) throws Exception {
        if (isMaxed()) {
            throw new Exception("TournmentFulException: Max player reached.");
        }

        this.PlayersQ.offer(player);
    }

    public boolean isMaxed() {
        return (MaxPlayers == this.PlayersQ.size());
    }

    public void dropPlayer(Player player) throws Exception {
        if (PlayersQ.size() == 0) {
            throw new Exception("QueueEmptyException: The tournment player's Q is empty");
        }

        this.PlayersQ.removeIf((lock -> lock.Id == player.Id));
    }

    public String toString() {
        return "{tmax: " + this.MaxPlayers + ", tid: " + this.Id + ", tplayers: " + this.PlayersQ.toString() + "}";
    }
}
