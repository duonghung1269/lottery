/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.pojo;

/**
 *
 * @author SGSCDHDX
 */
public class LineBall {
    
    private int[] blankIndices;
    private String balls;

    public LineBall(int[] blankIndices, String balls) {
        this.blankIndices = blankIndices;
        this.balls = balls;
    }
    
    /**
     * @return the blankIndices
     */
    public int[] getBlankIndices() {
        return blankIndices;
    }

    /**
     * @param blankIndices the blankIndices to set
     */
    public void setBlankIndices(int[] blankIndices) {
        this.blankIndices = blankIndices;
    }

    /**
     * @return the balls
     */
    public String getBalls() {
        return balls;
    }

    /**
     * @param balls the balls to set
     */
    public void setBalls(String balls) {
        this.balls = balls;
    }
    
    
}
