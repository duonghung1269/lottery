/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.dao;

import com.lottery.model.DrawResult;
import java.util.Date;

/**
 *
 * @author duonghung1269
 */
public interface DrawResultDao extends GenericDao<DrawResult, Long> {        
    
    public DrawResult findBy(Date drawDate, byte round);
    
}
