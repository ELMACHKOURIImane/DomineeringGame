/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domineering;

/**
 *
 * @author hp
 */
class DomineeringMove extends Move {
    int startRow, startCol;
    boolean isHorizontal;
    DomineeringMove(int startRow, int startCol, boolean isHorizontal) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.isHorizontal = isHorizontal;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public boolean isIsHorizontal() {
        return isHorizontal;
    }
    
}
