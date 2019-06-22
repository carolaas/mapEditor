package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by codecadet on 18/06/2019.
 */
public class Grid {

    private int rows;
    private int cols;
    private Cell[][] cellArray;
    private String arrayStr = "";


    public Grid(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
        cellArray = new Cell[cols][rows];
        init();
    }

    public void init() {

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {

                cellArray[col][row] = new Cell(col, row);

            }
        }
    }

    public void delete() {

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {

                cellArray[col][row].uncolor();
            }

        }
    }

    public String arrayToStr() {

        arrayStr = "";
        for (int col = 0; col < cols ; col++) {
            for (int row = 0; row < rows; row++) {
                arrayStr += cellArray[col][row].colorState();
            }

            arrayStr += "\n";
        }

        return arrayStr;
    }

    public void stringToArray(String result) {

        int index = 0;

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {

                //Cell cell = cellArray[col][row];

                if (result.charAt(index) == '0') {

                    cellArray[col][row].uncolor();

                } else if (result.charAt(index) == '1') {

                    cellArray[col][row].color(Color.BLACK);


            }    else {

                    cellArray[col][row].color(Color.MAGENTA);
                }

                index++;
            }
            index++;
        }
    }

    public Cell getCell(int row, int col) {

        return cellArray[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell[][] getArray() {

        return cellArray;
    }

}
