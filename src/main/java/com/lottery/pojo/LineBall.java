/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.pojo;

import com.lottery.util.LotteryUtils;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author SGSCDHDX
 */
public class LineBall {
    
    private List<Integer> blankIndices;
    private List<Integer> balls;
    private String ballsString;

    public LineBall(List<Integer> balls, List<Integer> blankIndices) {        
        this.balls = balls;
        this.blankIndices = blankIndices;
    }
    
    /**
     * @return the blankIndices
     */
    public List<Integer> getBlankIndices() {
        return blankIndices;
    }

    /**
     * @param blankIndices the blankIndices to set
     */
    public void setBlankIndices(List<Integer> blankIndices) {
        this.blankIndices = blankIndices;
    }

    /**
     * @return the balls
     */
    public List<Integer> getBalls() {
        return balls;
    }

    /**
     * @param balls the balls to set
     */
    public void setBalls(List<Integer> balls) {
        this.balls = balls;
    }
    
    public String getBallsString() {
        return StringUtils.join(balls, LotteryUtils.BALLS_SEPARATOR);
    }
    
    public String getBlankIndicesString() {
        return StringUtils.join(blankIndices, LotteryUtils.BALLS_SEPARATOR);
    }
}
