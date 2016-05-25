/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.service.impl;

import com.lottery.dao.GenericDao;
import com.lottery.dao.TicketTableDao;
import com.lottery.model.TicketTable;
import com.lottery.service.TicketTableService;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author duonghung1269
 */
@Service
public class TicketTableServiceImpl extends GenericServiceImpl<TicketTable, Long> implements TicketTableService {

    @Resource
    private TicketTableDao ticketTableDao;    

    @Resource
    @Override
    public void setGenericDao(GenericDao<TicketTable, Long> genericDao) {
        this.genericDao = ticketTableDao;
    }

    @Override
    public List<TicketTable> getByDate(Date date) {
        return ticketTableDao.getByDate(date);
    }

    @Override
    public List<TicketTable> getWinners(Date drawedDate, byte round, byte winType) {
        return ticketTableDao.getWinners(drawedDate, round, winType);        
    }

}
