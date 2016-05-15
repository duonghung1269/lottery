/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.pojo;

import com.lottery.exception.LotteryException;
import com.lottery.exception.LotteryExceptionEnum;
import com.lottery.util.LotteryUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author SGSCDHDX
 */
public class TicketTable {
    
    private List<LineBall> table = new ArrayList<>();

    public List<LineBall> getTable() {
        return table;
    }

    public void setTable(List<LineBall> table) {
        this.table = table;
    }
    
    public void add(LineBall lineBall) throws LotteryException {        
        if (table.size() >= LotteryUtils.NO_LINES_PER_TABLE) {
            throw new LotteryException(LotteryExceptionEnum.PROGRAMMING_ERROR, "Can not add more than " + LotteryUtils.NO_LINES_PER_TABLE + " rows for 1 table.");
        }
        
        table.add(lineBall);
    }
    
    public String generateBlankIndices() throws LotteryException {
        if (table.size() != LotteryUtils.NO_LINES_PER_TABLE) {
            throw new LotteryException(LotteryExceptionEnum.PROGRAMMING_ERROR, "Can not generate blank cells");
        }
        
        List<Integer> blankIndices = new ArrayList<>();
//        for (LineBall lineBall : table) {
//            for (int i = 0; i < lineBall.getBlankIndices().length; i++) {
//                blankIndices.add(lineBall.getBlankIndices()[i]);
//            }
//        }
        
        return StringUtils.join(blankIndices, LotteryUtils.BALLS_SEPARATOR);
    }
}
