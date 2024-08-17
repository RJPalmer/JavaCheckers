/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacheckers;

/**
 *
 * @author robertpalmer
 */
public class PlayerArea {

    /**
     * The rows that define the player area.
     */
    public int[] areaRows;

    /**
     * Get the value of areaRows
     *
     * @return the value of areaRows
     */
    public int[] getAreaRows() {
        return areaRows;
    }

    /**
     * Set the value of areaRows
     *
     * @param areaRows new value of areaRows
     */
    public void setAreaRows(int[] areaRows) {
        this.areaRows = areaRows;
    }

    /**
     * The color of pieces placed in the area.
     */
    public String areaColor;

    /**
     * Get the value of areaColor
     *
     * @return the value of areaColor
     */
    public String getAreaColor() {
        return areaColor;
    }

    /**
     * Set the value of areaColor
     *
     * @param areaColor new value of areaColor
     */
    public void setAreaColor(String areaColor) {
        this.areaColor = areaColor;
    }

    /**
     * Empty Constructor
     */
    public PlayerArea() {
        areaColor = "";
        areaRows = new int[0];
    }

    /**
     * Constructor
     * @param areaRows
     * @param areaColor 
     */
    public PlayerArea(int[] areaRows, String areaColor) {
        this.areaRows = areaRows;
        this.areaColor = areaColor;
    }
    
    

}
