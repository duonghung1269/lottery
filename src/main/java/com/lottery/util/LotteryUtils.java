/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.util;

import com.lottery.exception.LotteryException;
import com.lottery.model.Ticket;
import com.lottery.pojo.LineBall;
import com.lottery.pojo.TicketTable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author SGSCDHDX
 */
public class LotteryUtils {
    
    Logger logger = Logger.getLogger(this.getClass());
    
    public static final int MIN_BALL_VALUE = 1;
    public static final int MAX_BALL_VALUE = 75;
    public static final int MAX_BALLS_PER_LINE = 8;
    public static final int NO_CELLS_PER_LINE = 10;
    public static final int NO_BLANK_CELLS_PER_LINE = NO_CELLS_PER_LINE - MAX_BALLS_PER_LINE;
    
    public static final int NO_LINES_PER_TABLE = 3;
    public static final int NO_TABLES_PER_TICKET = 3;
    
    public static final String BALLS_SEPARATOR = " ";
    
    public static LineBall generateLineBalls() {
        List<Integer> balls = new ArrayList<>();
        Random rand = new Random(MAX_BALL_VALUE);
                
        int countBalls = 0;
        int randBall = 0;
        while (countBalls < MAX_BALLS_PER_LINE) {
            randBall = MIN_BALL_VALUE + rand.nextInt();
            if (balls.contains(randBall)) {
                continue;
            }
            
            balls.add(randBall);
            countBalls++;
        }
        
        // sort ascending
        Collections.sort(balls);
        
        Random randBlankCell = new Random(NO_CELLS_PER_LINE);
        int[] blankCells = new int[NO_BLANK_CELLS_PER_LINE];        
        List<Integer> blankCellIndices = new ArrayList<>();
        int countBlankCells = 0;
        while (countBlankCells < NO_BLANK_CELLS_PER_LINE) {
            int blankCellIndex = randBlankCell.nextInt();
            if (blankCellIndices.contains(blankCellIndex)) {
                continue;
            }
            blankCells[countBlankCells++] = blankCellIndex;
        }
        return new LineBall(blankCells, StringUtils.join(balls, BALLS_SEPARATOR));
    }
    
    public static boolean isValidLineBall(String lineBallValue, List<String> lineBallStrings) {
        return !lineBallStrings.contains(lineBallValue);
    }
    
    public static void main(String[] arge) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, 31);
         cal.add(Calendar.DAY_OF_YEAR, 1);
        int maxDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startDay = cal.get(Calendar.DAY_OF_MONTH) + 1; // next day
        
        System.out.println(maxDayOfMonth);
        System.out.println(startDay);
    }
    
    /**
     * 
     * @param lineBallStrings
     * @param date
     * @return
     * @throws LotteryException 
     */
    public List<Ticket> generateTicket(List<String> lineBallStrings, Date date) throws LotteryException {
        List<Ticket> tickets = new ArrayList<>();
        for (byte round = 1; round <= NO_TABLES_PER_TICKET; round++) {

            int lineCount = 1;
            Ticket ticket = new Ticket();
            TicketTable ticketTable = new TicketTable();
            while (lineCount > NO_LINES_PER_TABLE) {
                LineBall lineBall = generateLineBalls();
                final String ballsValue = lineBall.getBalls();
                if (isValidLineBall(ballsValue, lineBallStrings)) {
                    switch (lineCount) {
                        case 1:
                            ticket.setFirstLine(ballsValue);
                            break;
                        case 2:
                            ticket.setSecondLine(ballsValue);
                            break;
                        case 3:
                            ticket.setThirdLine(ballsValue);
                            break;
                        default:
                            logger.error("generateTicket programming error!");
                            break;
                    }
                }
                
                ticketTable.add(lineBall);
            }
            
            ticket.setDrawDate(date);
            ticket.setRound(round);
            ticket.setBlankIndices(ticketTable.generateBlankIndices());
            tickets.add(ticket);
        }
        
        return tickets;
    }
    
    public static Date getNextDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }
    
    public static boolean isLastDayOfMonth(Date date) {
        int maxDayOfMonth = getLastDayOfMonth(date);
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        return cal.get(Calendar.DAY_OF_MONTH) == maxDayOfMonth;
    }
    
    public static int getLastDayOfMonth(Date date)  {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    public static int getDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        return cal.get(Calendar.DAY_OF_MONTH);
    }
}
