package org.academiadecodigo.bootcamp;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by codecadet on 18/06/2019.
 */
public class ReadWrite {

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private String line = "";
    private Grid grid;
    private Cell cell;


    public ReadWrite(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void Read(Grid grid) {

        for (int i = 0; i < grid.getArray().length ; i++) {

            if(cell.blackOrWhite() == "black") {

                line += "black";
            }
        }
    }
}
