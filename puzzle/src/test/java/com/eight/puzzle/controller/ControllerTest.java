package com.eight.puzzle.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Eduardo Marques
 */
public class ControllerTest {
    
    Controller controller;
    
    public ControllerTest() {
    }
    
    @BeforeEach
    public void init() {
        controller = new Controller();
        controller.initBoard();
    }
    
    @Test
    public void testContainsValueInBlocks() {
        Integer[][] blocksTest = {{1,2,3}, {4,5,6}, {7,8,0}};
        int valueTest = 5;
        
        assertEquals(true, this.controller.containsValueInBlocks(valueTest, blocksTest));
    }
    
    @Test
    public void testGetBlocksOfBoard() {
        assertNotNull(this.controller.getBlocksOfBoard());
    }
    
    @Test
    public void testDontContainValueInBlocks() {
        Integer[][] blocksTest = {{1,2,3}, {4,5,6}, {7,8,0}};
        int valueTest = 15;
        
        assertEquals(false, this.controller.containsValueInBlocks(valueTest, blocksTest));
    }
    
    @Test
    public void testCheckWin() {
        Integer[][] blocksTest = {{1,2,3}, {4,5,6}, {7,8,0}};
        
        assertEquals(true, this.controller.checkWin(blocksTest));
    }
    
    @Test
    public void testCheckWinFail() {
        Integer[][] blocksTest = {{8,5,3}, {4,2,6}, {7,1,0}};
        
        assertEquals(false, this.controller.checkWin(blocksTest));
    }
    
}
