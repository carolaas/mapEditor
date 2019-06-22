package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 22/06/2019.
 */
public class KeyboardManager implements KeyboardHandler {


    MapEditor mapEditor;

    public KeyboardManager(MapEditor mapEditor) {

        this.mapEditor = mapEditor;
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

        KeyboardEvent eventDel = new KeyboardEvent();
        eventDel.setKey(KeyboardEvent.KEY_D);
        eventDel.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        painter.addEventListener(eventDel);

        KeyboardEvent eventM = new KeyboardEvent();
        eventM.setKey(KeyboardEvent.KEY_M);
        eventM.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        painter.addEventListener(eventM);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:

                mapEditor.getPainter().move(Painter.Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:

                mapEditor.getPainter().move(Painter.Direction.LEFT);
                break;

            case KeyboardEvent.KEY_UP:

                mapEditor.getPainter().move(Painter.Direction.UP);
                break;

            case KeyboardEvent.KEY_DOWN:

                mapEditor.getPainter().move(Painter.Direction.DOWN);
                break;

            case KeyboardEvent.KEY_SPACE:

                Cell cell = mapEditor.getGrid().getCell(mapEditor.getPainter().getPos().getX() / mapEditor.getPainter().getPainterSize(), mapEditor.getPainter().getPos().getY() / mapEditor.getPainter().getPainterSize());

                if (cell.isColored()) {

                    cell.uncolor();

                } else {

                    cell.color(Color.BLACK);
                }
                break;

            case KeyboardEvent.KEY_S:

                mapEditor.getReadWrite().write(mapEditor.getGrid().arrayToStr());
                break;

            case KeyboardEvent.KEY_Z:

                mapEditor.getGrid().stringToArray(mapEditor.getReadWrite().read());
                break;

            case KeyboardEvent.KEY_D:

                mapEditor.getGrid().delete();
                break;

            case KeyboardEvent.KEY_M:

                cell = mapEditor.getGrid().getCell(mapEditor.getPainter().getPos().getX() / mapEditor.getPainter().getPainterSize(), mapEditor.getPainter().getPos().getY() / mapEditor.getPainter().getPainterSize());
                cell.color(Color.MAGENTA);
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
