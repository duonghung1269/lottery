/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.service.impl;


import com.lottery.dao.BuyerDao;
import com.lottery.dao.GenericDao;
import com.lottery.dao.impl.BuyerDaoImpl;
import com.lottery.model.Buyer;
import com.lottery.service.BuyerService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired
        ;
import org.springframework.stereotype.Service;

/**
 *
 * @author SGSCDHDX
 */
@Service
public class BuyerServiceImpl extends GenericServiceImpl<Buyer, Long> implements BuyerService{
    
    @Resource
    private BuyerDao buyerDao; // = new BuyerDaoImpl();
    
    public BuyerServiceImpl() {
        super();
        this.genericDao = buyerDao;
    }

    public BuyerDao getBuyerDao() {
        return buyerDao;
    }

    public void setBuyerDao(BuyerDao buyerDao) {
        this.buyerDao = buyerDao;
    }

    @Resource
    @Override
    public void setGenericDao(GenericDao<Buyer, Long> genericDao) {
        this.genericDao = buyerDao;
    }
    
    
}
