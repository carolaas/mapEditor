package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 18/06/2019.
 */
public class Cell {


    public static final int PADDING = 10;
    private int posRow;
    private int posCol;
    private int cellSize = 20;
    private Rectangle rectangle;
    private String bOrW;


    public Cell(int posCol, int posRow) {

        this.posRow = posRow;
        this.posCol = posCol;
        init();
    }

    public void init() {

        rectangle = new Rectangle(posCol * cellSize, posRow * cellSize, cellSize, cellSize);
        rectangle.draw();
    }

    public int getPosRow() {
        return posRow;
    }

    public int getPosCol() {
        return posCol;
    }

    public int getWidth() {
        return cellSize;
    }

    public int getHeight() {
        return cellSize;
    }

    public boolean isColored() {

        return rectangle.isFilled();
    }

    public String blackOrWhite() {

        if(isColored()) {

            return bOrW = "black";
        } else {

            return bOrW = "white";
        }
    }


    public int getCellSize() {

        return cellSize;
    }


    public void color() {

        rectangle.setColor(Color.BLACK);
        rectangle.fill();
    }

    public void uncolor() {

        rectangle.draw();
    }
}
