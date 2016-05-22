/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.dao.impl;

import com.lottery.dao.DrawResultDao;
import com.lottery.model.DrawResult;
import java.util.Date;
import org.springframework.stereotype.Repository;

/**
 *
 * @author duonghung1269
 */
@Repository
public class DrawResultDaoImpl extends GenericDaoImpl<DrawResult, Long> implements DrawResultDao {

    @Override
    public DrawResult findBy(Date drawDate, byte round) {        
        return (DrawResult) currentSession().createQuery("Select dr from DrawResult dr where dr.drawDate = :drawDate and dr.round = :round")
                                          .setParameter("drawDate", drawDate)
                                          .setParameter("round", round)
                                          .uniqueResult();
        
    }

}
