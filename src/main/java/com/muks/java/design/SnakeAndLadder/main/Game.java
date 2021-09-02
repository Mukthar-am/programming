package com.muks.java.design.SnakeAndLadder.main;


/**
 * reference: https://www.geeksforgeeks.org/design-snake-game/
 */

import com.muks.java.design.SnakeAndLadder.dao.Board;
import com.muks.java.design.SnakeAndLadder.dao.Snake;

/**
 *
 *  Game driver
 *      Note: make this stateless by having in-memory object for each games
 *
 * */
public class Game implements Runnable {

    public static final int DIRECTION_NONE = 0,
            DIRECTION_RIGHT = 1,
            DIRECTION_LEFT = -1,
            DIRECTION_UP = 2,
            DIRECTION_DOWN = -2;

    private Snake snake;
    private Board GameBoard = new Board();
    private int direction;
    private boolean gameOver;

    /** getters */
    public Snake getSnake() {
        return snake;
    }

    public Board getGameBoard() {
        return GameBoard;
    }

    public int getDirection() {
        return direction;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    /** setters */
    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setGameBoard(Board gameBoard) {
        this.GameBoard = gameBoard;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }


    private ThreadLocal<String> Name =  new ThreadLocal<>();
    private ThreadLocal<Integer> Id = new ThreadLocal<>();


    public Game(String name, int id) {
        System.out.println("setting....");
        this.Name.set(name);
        this.Id.set(id);
    }

    @Override
    public void run() {
        boolean isRunning = true;
        int attempts = 0;

        while (isRunning && attempts != 10) {

            /** dice
             *      - get number
             *      - move
             *          - find if the final node is a snake, ladder or empty
             *      - get current state of the board with players on it
             *
             *  switch player, next in the queue and repeat the same above steeps
             */

            GameBoard.print();
            attempts = 10;

//            System.out.println("Running Game: " + this.Name.get() + "-id: " + this.Id.get().toString() + "... will wait for 2 secs");
//            attempts++;
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
}
