/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.dao.impl;

import com.lottery.dao.TicketDao;
import com.lottery.model.Ticket;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SGSCDHDX
 */
public class TicketDaoImpl extends GenericDaoImpl<Ticket, Long> implements TicketDao {
    
    @Override
    public List<String> findFullTableColumn(Date date) {
                
        final List<String> list = currentSession().createSQLQuery("Select full_table from Ticket where draw_date = :drawDate")
                                          .setParameter("drawDate", date)
                                          .list();        
        
        return list;
    }

    @Override
    public List<String> findByColumn(String columnName, Date date) {
        currentSession().beginTransaction();
        final List<String> list = currentSession().createSQLQuery("Select :columnName from Ticket where draw_date = :drawDate")
                                          .setParameter("drawDate", date)
                                          .setParameter("columnName", columnName)
                                          .list();
        currentSession().getTransaction().commit();
        
        return list;
    }
}
