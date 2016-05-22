/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.service;

import com.lottery.model.DrawResult;
import com.lottery.model.TicketTable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author duonghung1269
 */
public interface DrawResultService {
    
    public void updateWinner(DrawResult newDrawResult, Set<TicketTable> winTicketTables);
    
    public DrawResult findBy(Date drawDate, byte round);
    
}
