package com.test;


import com.lottery.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SGSCDHDX
 */
public class Test {
    
    @Autowired(required=true)
    private BuyerService buyerService;
    
    public static void main(String... args) {
        Test t = new Test();
        
        System.out.print(t.buyerService);
        System.out.print("hahaa");
    }
}
