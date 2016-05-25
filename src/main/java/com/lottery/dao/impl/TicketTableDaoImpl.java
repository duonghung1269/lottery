/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.dao.impl;

import com.lottery.dao.TicketTableDao;
import com.lottery.model.TicketTable;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author duonghung1269
 */
@Repository
public class TicketTableDaoImpl extends GenericDaoImpl<TicketTable, Long> implements TicketTableDao{

    @Override
    public List<TicketTable> getByDate(Date date) {        
//        final List<TicketTable> list = currentSession().createSQLQuery("Select tt.* from Ticket_Table tt inner join Ticket t on tt.ticket_id = t.id where t.draw_date = :drawDate")
//                                          .setParameter("drawDate", date)
//                                           .setResultTransformer(Transformers.aliasToBean(TicketTable.class))
//                                          .list();
        
        final List<TicketTable> list = currentSession().createQuery("Select tt from TicketTable tt inner join tt.ticket t inner join t.buyer b where t.drawDate = :drawDate")
                                          .setParameter("drawDate", date)
//                                           .setResultTransformer(Transformers.aliasToBean(TicketTable.class))
                                          .list();
        return list;
    }

    @Override
    public List<TicketTable> getWinners(Date drawedDate, byte round, byte winType) {
        final List<TicketTable> list = currentSession()
                                        .createQuery("Select tt from TicketTable tt inner join tt.ticket t where t.drawDate = :drawDate and tt.winType = :winType and tt.round = :round")
                                        .setParameter("drawDate", drawedDate)
                                        .setParameter("winType", winType)
                                        .setParameter("round", round)
                                        .list();
        return list;
    }
    
}
