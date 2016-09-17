package com.example.tonya.testtask;

import java.io.Serializable;

/**
 * Created by tonya on 9/14/16.
 */
public class Matrix implements Serializable {
    private int columnLen;
    private int rowLen;
    private int posX;
    private int posY;

    private int[][] elements;

    public Matrix(int columnLen, int rowLen, int posY, int posX) {
        this.columnLen = columnLen;
        this.posX = posX;
        this.posY = posY;
        this.rowLen = rowLen;

        elements = new int[rowLen][columnLen];
        generate();
    }

    public int getColumnLen() {
        return columnLen;
    }

    public int getRowLen() {
        return rowLen;
    }

    public int[][] getElements() {
        return elements;
    }

    //algorithm of generation
    private void generate() {
        
        int count = 0;

        int startX = posX;
        int endX = posX;

        int startY = posY;
        int endY = posY;


        while (startX >= 0 || endY < columnLen || endX < rowLen || startY >= 0) {
            count++;
            startX = startX - 1;
            endX = endX + 1;

            startY = startY - 1;
            endY = endY + 1;


            for (int i = startX; i <= endX; i++) {

                if (i >= 0 && i < rowLen) {
                    if (startY >= 0) {
                        elements[i][startY] = count;
                    }
                    if (endY < columnLen) {
                        elements[i][endY] = count;
                    }
                }
            }

            for (int j = startY; j <= endY; j++) {
                if (j >= 0 && j < columnLen) {

                    if (startX >= 0) {
                        elements[startX][j] = count;
                    }

                    if (endX < rowLen) {
                        elements[endX][j] = count;
                    }
                }
            }
        }


        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                System.out.print(" " + elements[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix = (Matrix) o;

        if (columnLen != matrix.columnLen) return false;
        if (rowLen != matrix.rowLen) return false;
        if (posX != matrix.posX) return false;
        return posY == matrix.posY;

    }

    @Override
    public int hashCode() {
        int result = columnLen;
        result = 31 * result + rowLen;
        result = 31 * result + posX;
        result = 31 * result + posY;
        return result;
    }
}
