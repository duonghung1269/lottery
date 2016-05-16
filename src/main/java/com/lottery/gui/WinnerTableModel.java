/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.gui;

import com.lottery.model.TicketTable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author duonghung1269
 */
public class WinnerTableModel extends AbstractTableModel {

    private String[] columnNames = { "Name", "Serial No", "Line 1", "Line 2", "Line 3"};
    private static boolean DEBUG = true;
    private Object[][] data;
    
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    
    @Override
    public String getColumnName(int col) {
      return columnNames[col];
    }
    
    @Override
    public Class getColumnClass(int c) {
      return getValueAt(0, c).getClass();
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
      if (DEBUG) {
        System.out.println("Setting value at " + row + "," + col
            + " to " + value + " (an instance of "
            + value.getClass() + ")");
      }

      data[row][col] = value;
      fireTableCellUpdated(row, col);

      if (DEBUG) {
        System.out.println("New value of data:");        
      }
    }

    public Object[][] getData() {
        return data;
    }

    public void setData(Set<TicketTable> winTicketTables) {               
        this.data = new Object[winTicketTables.size()][columnNames.length];
        Iterator<TicketTable> iter = winTicketTables.iterator();
        int rowCount = 0;
        while (iter.hasNext()) {
            TicketTable winTicketTable = iter.next();
            data[rowCount++] = new Object[]{winTicketTable.getTicket().getBuyer().getName(), winTicketTable.getTicket().getSerialNumber()
                                    , winTicketTable.getFirstLine(), winTicketTable.getSecondLine(), winTicketTable.getThirdLine()};
        }
    }


}
