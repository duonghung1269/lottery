/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.service.impl;

import com.lottery.dao.DrawResultDao;
import com.lottery.dao.GenericDao;
import com.lottery.model.DrawResult;
import com.lottery.model.TicketTable;
import com.lottery.service.DrawResultService;
import com.lottery.service.TicketTableService;
import java.util.Date;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author duonghung1269
 */
@Service
public class DrawResultServiceImpl extends GenericServiceImpl<DrawResult, Long> implements DrawResultService {

    @Resource
    private DrawResultDao drawResultDao;
    
    @Autowired
    private TicketTableService ticketTableService;
    
    @Override
    @Resource
    public void setGenericDao(GenericDao<DrawResult, Long> genericDao) {
        this.genericDao = drawResultDao;
    }

    @Override
    public void updateWinner(DrawResult newDrawResult, Set<TicketTable> winTicketTables) {
        genericDao.saveOrUpdate(newDrawResult);
        for (TicketTable ticketTable : winTicketTables) {
            ticketTable.setDrawResult(newDrawResult);
            ticketTableService.update(ticketTable);
        }
    }

    @Override
    public DrawResult findBy(Date drawDate, byte round) {
        return drawResultDao.findBy(drawDate, round);
    }
    
}
