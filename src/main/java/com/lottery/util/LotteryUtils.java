/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.util;

import com.lottery.exception.LotteryException;
import com.lottery.model.Ticket;
import com.lottery.pojo.LineBall;
import com.lottery.model.TicketTable;
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
    
    private static final Logger LOGGER = Logger.getLogger(LotteryUtils.class);
    
    public static final int MIN_BALL_VALUE = 1;
    public static final int MAX_BALL_VALUE = 75;
    public static final int MAX_BALLS_PER_LINE = 8;
    public static final int NO_CELLS_PER_LINE = 10;
    public static final int NO_BLANK_CELLS_PER_LINE = NO_CELLS_PER_LINE - MAX_BALLS_PER_LINE;
    
    public static final int NO_LINES_PER_TABLE = 3;
    public static final int NO_TABLES_PER_TICKET = 3;
    
    public static final String BALLS_SEPARATOR = " ";
    public static final String GROUP_BALLS_SEPARATOR = "|";
    
    public static LineBall generateLineBalls(List<Integer> generatedBalls) {
        List<Integer> balls = new ArrayList<>();
        Random rand = new Random();
                
        int countBalls = 0;
        int randBall = 0;
        while (countBalls < MAX_BALLS_PER_LINE) {
            randBall = MIN_BALL_VALUE + rand.nextInt(MAX_BALL_VALUE);
            if (generatedBalls.contains(randBall)) {
                continue;
            }
            
            generatedBalls.add(randBall);
            balls.add(randBall);
            countBalls++;
        }
        
        // sort ascending
        Collections.sort(balls);
        
        Random randBlankCell = new Random();          
        List<Integer> blankCellIndices = new ArrayList<>(NO_BLANK_CELLS_PER_LINE);
        int countBlankCells = 0;
        while (countBlankCells < NO_BLANK_CELLS_PER_LINE) {
            int blankCellIndex = randBlankCell.nextInt(NO_CELLS_PER_LINE);
            if (blankCellIndices.contains(blankCellIndex)) {
                continue;
            }
            blankCellIndices.add(blankCellIndex);
            countBlankCells++;
        }
        return new LineBall(balls, blankCellIndices);
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
    public static Ticket generateTicket(List<String> lineBallStrings, Date date) throws LotteryException {
        Ticket ticket = new Ticket();
        ticket.setDrawDate(date);
        ticket.setSerialNumber("SN" + System.currentTimeMillis());
        
        for (byte round = 1; round <= NO_TABLES_PER_TICKET; round++) {

            int lineCount = 1;            
            TicketTable ticketTable = new TicketTable();
            ticketTable.setTicket(ticket);
            
            List<String> blankIndices = new ArrayList<>();
            List<Integer> generatedBalls = new ArrayList<>();
            while (lineCount <= NO_LINES_PER_TABLE) {
                LineBall lineBall = generateLineBalls(generatedBalls);
                final String ballsValue = lineBall.getBallsString();
                if (isValidLineBall(ballsValue, lineBallStrings)) {
                    switch (lineCount) {
                        case 1:
                            ticketTable.setFirstLine(ballsValue);
                            lineCount++;
                            break;
                        case 2:
                            ticketTable.setSecondLine(ballsValue);
                            lineCount++;
                            break;
                        case 3:
                            ticketTable.setThirdLine(ballsValue);
                            lineCount++;
                            break;
                        default:
                            LOGGER.error("generateTicket programming error!");
                            break;
                    }
                    
                    lineBallStrings.add(ballsValue);
                }
                
                blankIndices.add(lineBall.getBlankIndicesString());
            }
                        
            ticketTable.setRound(round);
            ticketTable.setBlankIndices(StringUtils.join(blankIndices, GROUP_BALLS_SEPARATOR));
            ticketTable.setFullTable(ticketTable.getFirstLine() + GROUP_BALLS_SEPARATOR + ticketTable.getSecondLine() + GROUP_BALLS_SEPARATOR + ticketTable.getThirdLine());
            ticket.getTicketTables().add(ticketTable);
        }
        
        return ticket;
    }
    
    public static Date getNextDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
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
    
    public static List<String> getAllLinesBalls(List<TicketTable> ticketTables) {
        List<String> results = new ArrayList<>();
        for (TicketTable ticketTable : ticketTables) {
            results.add(ticketTable.getFirstLine());
            results.add(ticketTable.getSecondLine());
            results.add(ticketTable.getThirdLine());
        }
        
        return results;
    }
    
    public static List<TicketTable> isWinner(List<TicketTable> ticketTables, List<Integer> drawNumbers) {
        List<TicketTable> winTicketTables = new ArrayList<>();
        List<Integer> sortedNumbers = new ArrayList<>();
        sortedNumbers.addAll(drawNumbers);
        Collections.sort(sortedNumbers);
        
        String numbersString = StringUtils.join(sortedNumbers, BALLS_SEPARATOR);
        
        for (TicketTable ticketTable : ticketTables) {
            if (ticketTable.getFirstLine().indexOf(numbersString) != -1 
               || ticketTable.getSecondLine().indexOf(numbersString) != -1 
               || ticketTable.getThirdLine().indexOf(numbersString) != -1      ) {
                winTicketTables.add(ticketTable);
            }
        }
        
        return winTicketTables;
    }
}
