package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 22/06/2019.
 */
public class MapEditor {

    private Grid grid;
    private Painter painter;
    private KeyboardManager keyboardManager;
    private ReadWrite readWrite;

    public MapEditor() {

       grid = new Grid(20, 20);
       painter = new Painter(grid);
       readWrite = new ReadWrite();
       keyboardManager = new KeyboardManager(this);
    }

    public Grid getGrid() {

        return grid;
    }

    public Painter getPainter() {

        return painter;
    }

    public ReadWrite getReadWrite() {
        return readWrite;
    }

    public void init() {


        keyboardManager.defKeys();
    }
}
