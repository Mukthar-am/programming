package com.muks.java.design.SnakeAndLadder.dao;

public class Board {
    int Rows = 10;
    int Cols = 10;
    Cell[][] BoardMatrix = new Cell[Rows][Cols];

    public Board() {
        int num = 0;
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                Cell cell = new Cell(++num);
                BoardMatrix[i][j] = new Cell(++num);
            }
        }

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                if (i == 6) {
                    Cell ladderDestinationCell = BoardMatrix[2][2];
                    BoardMatrix[i][j].Type = CellType.LADDER;
                    BoardMatrix[i][j].setLadder(ladderDestinationCell);
                }

            }
        }
    }

    public void print() {
        // Loop through all rows
        for (int i = 0; i < BoardMatrix.length; i++) {
            System.out.print("[");

            // Loop through all elements of current row
            for (int j = 0; j < BoardMatrix[i].length; j++) {
                if (BoardMatrix[i][j].Type == CellType.EMPTY) {
                    System.out.print("- ");
                }

                else if (BoardMatrix[i][j].Type == CellType.SNAKE) {
                    if (BoardMatrix[i][j].SnakeHead != null) {
                        System.out.print("sH" + " ");
                    } else if (BoardMatrix[i][j].SnakeTail != null) {
                        System.out.print("sT" + " ");
                    }
                }

                else if (BoardMatrix[i][j].Type == CellType.LADDER) {
                    if (BoardMatrix[i][j].LadderStart != null) {
                        System.out.print("Ls" + " ");
                    } else if (BoardMatrix[i][j].LadderDestination != null) {
                        System.out.print("Le" + " ");
                    }
                }

//                System.out.print(BoardMatrix[i][j].Id + " ");
            }
            System.out.println("]");
        }
    }


}
