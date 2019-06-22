package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;



/**
 * Created by codecadet on 18/06/2019.
 */
public class Painter {

    public static final int PADDING = 10;
    private Rectangle rectangle;
    private Grid grid;
    private int painterSize = 20;


    public Painter(Grid grid) {


        rectangle = new Rectangle(PADDING, PADDING, 20 , 20);
        rectangle.setColor(Color.MAGENTA);
        rectangle.fill();
        this.grid = grid;
    }

    public enum Direction {

        RIGHT,
        LEFT,
        UP,
        DOWN;
    }

    public int getPainterSize() {

        return painterSize;
    }

    public Rectangle getPos() {

        return rectangle;
    }

    public void move(Direction direction) {


        switch (direction) {

            case RIGHT:

                if(rectangle.getX() < (grid.getCols() - 1) * painterSize) {

                    rectangle.translate(painterSize, 0);
                }
                    break;

            case LEFT:

                if(rectangle.getX() > painterSize) {

                    rectangle.translate(-painterSize, 0);
                }
                    break;

            case UP:

                if(rectangle.getY() > painterSize) {

                    rectangle.translate(0, -painterSize);

                }
                    break;

            case DOWN:

                if(rectangle.getY() < (grid.getRows() - 1) * painterSize) {

                    rectangle.translate(0, painterSize);
                }
                    break;
        }
    }
}

