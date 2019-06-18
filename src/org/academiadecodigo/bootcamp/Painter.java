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

    private Rectangle rectangle;
    private Grid grid;

    public Painter(Grid grid) {

        rectangle = new Rectangle(1, 1, 20 , 20);
        rectangle.setColor(Color.BLACK);
        rectangle.fill();
        this.grid = grid;

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

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT && rectangle.getX() < (grid.getCols() - 1) * 20) {

            System.out.println(rectangle.getX());
            System.out.println(grid.getCols());
            rectangle.translate(20, 0);


        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT && rectangle.getX() > 20 ) {

            rectangle.translate(-20, 0);


        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP && rectangle.getY() > 20) {

            rectangle.translate(0, -20);

        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN && rectangle.getY() < (grid.getRows() -1) * 20) {

            rectangle.translate(0, 20);

        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

            Cell cell = grid.getCell(rectangle.getX() / 20, rectangle.getY() / 20);

           if (cell.isColored()) {

               cell.uncolor();

           } else {

               cell.color();
           }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}

