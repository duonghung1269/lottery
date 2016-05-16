/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.util;

import com.lottery.exception.LotteryException;
import com.lottery.model.Buyer;
import com.lottery.model.Ticket;
import com.lottery.pojo.LineBall;
import com.lottery.model.TicketTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


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
//        Set s = new HashSet();
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
        
        List<String> drawNumberStrings = new ArrayList<>();
        for (Integer number : drawNumbers) {
            drawNumberStrings.add(String.valueOf(number));
        }
        
        for (TicketTable ticketTable : ticketTables) {        
            List<String> firstLines = new ArrayList<>(Arrays.asList(ticketTable.getFirstLine().split(BALLS_SEPARATOR)));
            List<String> secondtLines = new ArrayList<>(Arrays.asList(ticketTable.getSecondLine().split(BALLS_SEPARATOR)));
            List<String> thirdLines = new ArrayList<>(Arrays.asList(ticketTable.getThirdLine().split(BALLS_SEPARATOR)));                        

            firstLines.retainAll(drawNumberStrings);
            secondtLines.retainAll(drawNumberStrings);
            thirdLines.retainAll(drawNumberStrings);
            
            if (firstLines.size() == MAX_BALLS_PER_LINE || secondtLines.size() == MAX_BALLS_PER_LINE || thirdLines.size() == MAX_BALLS_PER_LINE) {
                winTicketTables.add(ticketTable);
            }
        }
        
        return winTicketTables;
    }
    
    public static void generatePhysicalTicket(Buyer buyer, String fileName) throws IOException {
            HSSFWorkbook workbook = new HSSFWorkbook();

//		sheet.setDefaultRowHeight(IMAGE_ROW_HEIGHT);


        List<Ticket> tickets = buyer.getTickets();
        for (int ticketIndex = 0; ticketIndex < tickets.size(); ticketIndex++) {
            Map<String, Object[]> data = new LinkedHashMap<String, Object[]>();
            data.put("1", new Object[] { "Name", "", "", "", "", "", "", "", "", ""});
            data.put("2", new Object[] { "IC", "", "", "", "", "", "", "", "", ""});
            data.put("3", new Object[] { "Draw Date", "", "", "", "", "", "", "", "", ""});

            // prepare data
            int rowNumber = 5;

            Ticket ticket = tickets.get(ticketIndex);

            HSSFSheet sheet = workbook.createSheet(DateFormatUtils.format(ticket.getDrawDate(), "yyyyMMdd"));

            List<TicketTable> ticketTables = ticket.getTicketTables();

            for (TicketTable ticketTable : ticketTables) {
                byte round = ticketTable.getRound();
                String[] blankIndicesGroup = ticketTable.getBlankIndices().split("\\" + GROUP_BALLS_SEPARATOR);

                String[] firstLineBalls = ticketTable.getFirstLine().split(BALLS_SEPARATOR);
                String[] secondLineBalls = ticketTable.getSecondLine().split(BALLS_SEPARATOR);
                String[] thirdLineBalls = ticketTable.getThirdLine().split(BALLS_SEPARATOR);

                List<String> firstLineBallsList = new ArrayList<>();
                firstLineBallsList.addAll(Arrays.asList(firstLineBalls));
                String[] blankIndices = blankIndicesGroup[0].split(BALLS_SEPARATOR);
                int firstLineBlankCell1 = Integer.parseInt(blankIndices[0]);
                int firstLineBlankCell2 = Integer.parseInt(blankIndices[1]);
                firstLineBallsList.add(firstLineBlankCell1, "");
                firstLineBallsList.add(firstLineBlankCell2, "");                                                                                                

                Object[] objArray = new Object[NO_CELLS_PER_LINE];
                for (int colIndex = 0; colIndex < NO_CELLS_PER_LINE; colIndex++) {
                    objArray[colIndex] = firstLineBallsList.get(colIndex);
                }
                data.put(String.valueOf(rowNumber++), objArray);

                rowNumber++; // add 1 empty row

                List<String> secondLineBallsList = new ArrayList<>();
                secondLineBallsList.addAll(Arrays.asList(secondLineBalls));
                blankIndices = blankIndicesGroup[1].split(BALLS_SEPARATOR);
                int secondLineBlankCell1 = Integer.parseInt(blankIndices[0]);
                int secondLineBlankCell2 = Integer.parseInt(blankIndices[1]);
                secondLineBallsList.add(secondLineBlankCell1, "");
                secondLineBallsList.add(secondLineBlankCell2, "");                                                                                                

                Object[] objArray2 = new Object[NO_CELLS_PER_LINE];
                for (int colIndex = 0; colIndex < NO_CELLS_PER_LINE; colIndex++) {
                    objArray[colIndex] = secondLineBallsList.get(colIndex);
                }
                data.put(String.valueOf(rowNumber++), objArray2);

                rowNumber++; // add 1 empty row

                List<String> thirdLineBallsList = new ArrayList<>();
                thirdLineBallsList.addAll(Arrays.asList(thirdLineBalls));
                blankIndices = blankIndicesGroup[2].split(BALLS_SEPARATOR);
                int thirdLineBlankCell1 = Integer.parseInt(blankIndices[0]);
                int thirdLineBlankCell2 = Integer.parseInt(blankIndices[1]);
                thirdLineBallsList.add(thirdLineBlankCell1, "");
                thirdLineBallsList.add(thirdLineBlankCell2, "");                                                                                                

                Object[] objArray3 = new Object[NO_CELLS_PER_LINE];
                for (int colIndex = 0; colIndex < NO_CELLS_PER_LINE; colIndex++) {
                    objArray[colIndex] = thirdLineBallsList.get(colIndex);
                }
                data.put(String.valueOf(rowNumber++), objArray3);                        

            }

            // export data to excel file
            Set<String> keyset = data.keySet();
            int rownum = 0;	    
            for (String key : keyset) {
                Row row = sheet.createRow(rownum);
                Object [] objArr = data.get(key);
                int cellnum = 0;
                for (int i = 0; i < objArr.length; i++) {
                        Object obj = objArr[i];

    //	        	if (i == ID_COLUMN_INDEX) {
    //	        		continue;
    //	        	}

                    Cell cell = row.createCell(cellnum++);
                    if(obj instanceof String)
                        cell.setCellValue((String)obj);
                    else if(obj instanceof Integer)
                        cell.setCellValue((Integer)obj);
                }


            }
	    	    
	}
        
        try (FileOutputStream out = new FileOutputStream(new File(fileName))) {
            workbook.write(out);

        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
        System.out.println("Excel written successfully..");
                
                
    }
}
