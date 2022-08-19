package com.eight.puzzle.controller;

import com.eight.puzzle.model.Board;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Eduardo Marques
 */
public class Controller {
    private Board board = new Board();
    
    public void initBoard() {
        Integer[][] blocks = new Integer[3][3];
        Random random = new Random();
        
        for(int i = 0; i < blocks.length; i++) {
            for(int j = 0; j < blocks[i].length;) {
                Integer newValue = random.nextInt(9);
                if(!this.containsValueInBlocks(newValue, blocks)) {
                    blocks[i][j] = newValue;
                    j++;
                }
            }
        }
        
        this.board.setBlocks(blocks);
    }
    
    public boolean containsValueInBlocks(Integer value, Integer[][] blocks) {
        for(int i = 0; i < blocks.length; i++) {
            for(int j = 0; j < blocks[i].length; j++) {
                if(blocks[i][j] == value){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public Integer[][] getBlocksOfBoard() {
        return this.board.getBlocks();
    }
    
    
    public boolean checkWin(Integer[][] blocks) {
        return Arrays.deepEquals(blocks, this.board.getStateOfVictory());
    }
    
    public boolean moveBlocks(int linePosition, int columnPosition) {
        Integer[][] blocks = this.board.getBlocks();
        
        if((linePosition - 1) >= 0) {
            if(blocks[linePosition - 1][columnPosition] == 0){
                blocks[linePosition - 1][columnPosition] = blocks[linePosition][columnPosition];
                blocks[linePosition][columnPosition] = 0;
                
                return true;
            }
        }
        
        if((linePosition + 1) <= 2) {
            if(blocks[linePosition + 1][columnPosition] == 0) {
                blocks[linePosition + 1][columnPosition] = blocks[linePosition][columnPosition];
                blocks[linePosition][columnPosition] = 0;
                
                return true;
            }
        } 
        
        if((columnPosition - 1) >= 0) {
            if(blocks[linePosition][columnPosition - 1] == 0) {
                blocks[linePosition][columnPosition - 1] = blocks[linePosition][columnPosition];
                blocks[linePosition][columnPosition] = 0;
                
                return true;
            }
        } 
        
        if((columnPosition + 1)<= 2) {
            if(blocks[linePosition][columnPosition + 1] == 0) {
                blocks[linePosition][columnPosition + 1] = blocks[linePosition][columnPosition];
                blocks[linePosition][columnPosition] = 0;
                
                return true;
            }
        }
        
        return false;
    }
}
