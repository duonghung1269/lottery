/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author duonghung1269
 */
public class Launcher {
    public void launch() {
        String[] contextPaths = new String[] {"/applicationContext.xml"};
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(contextPaths);
        System.out.print("launched");
    }
}
