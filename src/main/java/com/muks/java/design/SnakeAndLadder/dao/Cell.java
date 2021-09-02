package com.muks.java.design.SnakeAndLadder.dao;

public class Cell {
    public int Id = -1;
    public Cell SnakeHead, SnakeTail = null;
    public Cell LadderStart, LadderDestination = null;
    public CellType Type = CellType.EMPTY;


    public Cell(int id) {
        this.Id = id;
    }

    public void hasSnake() {

    }

    public void hasLadder() {

    }

    public void setType(CellType t) {
        this.Type = t;
    }

    public void setType(CellType t, Cell snakeTail, Cell ladderDestination) {
        this.Type = t;

        if (t == CellType.SNAKE) {
            this.SnakeTail = snakeTail;
        }

        if (t == CellType.LADDER) {
            this.LadderDestination = ladderDestination;
        }
    }

    public void setSnake(Cell snakeHead, Cell snakeTail) {
        this.SnakeHead = snakeHead;
        this.SnakeTail = snakeTail;
    }

    public void setLadder(Cell ladderDestination) {
        this.LadderStart = this;
        this.LadderDestination = ladderDestination;
    }
}
