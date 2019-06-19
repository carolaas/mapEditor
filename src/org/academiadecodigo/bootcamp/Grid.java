package org.academiadecodigo.bootcamp;

/**
 * Created by codecadet on 18/06/2019.
 */
public class Grid {

    public static final int PADDING = 10;
    private int rows;
    private int cols;
    private Cell[][] cellArray;
    private Painter painter;
    private String arrayStr = "";
    private ReadWrite readWrite;


    public Grid(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
        cellArray = new Cell[cols][rows];
        painter = new Painter(this);
        painter.defKeys();
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
        for (int col = 0; col < cols; col++) {
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

                Cell cell = cellArray[col][row];

                if(arrayStr.charAt(index) == '0') {

                    cell.uncolor();

                } else {

                    cell.color();
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
