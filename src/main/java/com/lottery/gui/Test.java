/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.gui;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author duonghung1269
 */
public class Test {

    public static void main(String... agrs) {
        String s1 = "1 3 5 7 9 11 13";
        String s2 = "2 5 9 11 14";
        String[] s11 = s1.split(" ");
        String[] s22 = s2.split(" ");
        List s111 = Arrays.asList(s11);
        List s222 = Arrays.asList(s22);
        
        s222.retainAll(s111);
        System.out.print(s222);
    }
}
