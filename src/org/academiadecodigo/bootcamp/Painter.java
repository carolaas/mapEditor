package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;



/**
 * Created by codecadet on 18/06/2019.
 */
public class Painter implements KeyboardHandler {

    public static final int PADDING = 10;
    private Rectangle rectangle;
    private Grid grid;
    private int painterSize = 20;
    private ReadWrite state;

    public Painter(Grid grid) {


        rectangle = new Rectangle(PADDING, PADDING, 20 , 20);
        rectangle.setColor(Color.BLACK);
        rectangle.fill();
        this.grid = grid;
        state = new ReadWrite();

    }

    public void defKeys() {

        Keyboard painter = new Keyboard(this);
        KeyboardEvent eventR = new KeyboardEvent();
        eventR.setKey(KeyboardEvent.KEY_RIGHT);
        eventR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        painter.addEventListener(eventR);

        KeyboardEvent eventL = new KeyboardEvent();
        eventL.setKey(KeyboardEvent.KEY_LEFT);
        eventL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        painter.addEventListener(eventL);

        KeyboardEvent eventU = new KeyboardEvent();
        eventU.setKey(KeyboardEvent.KEY_UP);
        eventU.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        painter.addEventListener(eventU);

        KeyboardEvent eventD = new KeyboardEvent();
        eventD.setKey(KeyboardEvent.KEY_DOWN);
        eventD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        painter.addEventListener(eventD);

        KeyboardEvent eventPaint = new KeyboardEvent();
        eventPaint.setKey(KeyboardEvent.KEY_SPACE);
        eventPaint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        painter.addEventListener(eventPaint);

        KeyboardEvent eventS = new KeyboardEvent();
        eventS.setKey(KeyboardEvent.KEY_S);
        eventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        painter.addEventListener(eventS);

        KeyboardEvent eventZ = new KeyboardEvent();
        eventZ.setKey(KeyboardEvent.KEY_Z);
        eventZ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        painter.addEventListener(eventZ);



    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT && rectangle.getX() < (grid.getCols() - 1) * 20) {

            System.out.println(rectangle.getX());
            System.out.println(grid.getCols());
            rectangle.translate(painterSize, 0);


        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT && rectangle.getX() > painterSize) {

            rectangle.translate(-painterSize, 0);


        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP && rectangle.getY() > painterSize) {

            rectangle.translate(0, -painterSize);

        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN && rectangle.getY() < (grid.getRows() - 1) * painterSize) {

            rectangle.translate(0, painterSize);

        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

            Cell cell = grid.getCell(rectangle.getX() / painterSize, rectangle.getY() / painterSize);

            if (cell.isColored()) {

                cell.uncolor();

            } else {

                cell.color();
            }
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {

            state.write(grid.arrayToStr());

        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_Z) {

            grid.stringToArray(state.read());
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}

