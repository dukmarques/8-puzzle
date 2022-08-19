package com.eight.puzzle.model;

/**
 *
 * @author Eduardo Marques
 */
public class Board {
    private Integer[][] blocks = new Integer[3][3];
    
    public Board() {
    }
    
    public Integer[][] getBlocks() {
        return this.blocks;
    }
    
    public void setBlocks(Integer[][] blocks) {
        this.blocks = blocks;
    }
    
    public Integer[][] getStateOfVictory() {
        Integer[][] stateOfVictory = {{1,2,3}, {4,5,6}, {7,8,0}};
        return stateOfVictory;
    }
}
