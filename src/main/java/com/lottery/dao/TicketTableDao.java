/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.dao;

import com.lottery.model.TicketTable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author duonghung1269
 */
public interface TicketTableDao extends GenericDao<TicketTable, Long>{
    
    public List<TicketTable> getByDate(Date date);
    
    public List<TicketTable> getWinners(Date drawedDate, byte round, byte winType);
}
