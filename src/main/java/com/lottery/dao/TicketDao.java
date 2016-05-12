/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.dao;

import com.lottery.model.Ticket;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SGSCDHDX
 */
public interface TicketDao extends GenericDao<Ticket, Long> {
    /**
     *
     * @param date
     * @return
     */
    public List<String> findFullTableColumn(Date date);
    
    public List<String> findByColumn(String columnName, Date date);
}
