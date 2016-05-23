/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFormattedTextField;
import javax.swing.text.DateFormatter;

/**
 *
 * @author duonghung1269
 */
public class FormatDateFactory extends JFormattedTextField.AbstractFormatterFactory {

    @Override
    public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormatter df = new DateFormatter(dateFormat);
        return df;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
