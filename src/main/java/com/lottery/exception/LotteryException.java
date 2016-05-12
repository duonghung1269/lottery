/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.exception;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author SGSCDHDX
 */
public class LotteryException extends Exception {
    
    public LotteryException() {
        super();
    }
    
    public LotteryException(LotteryExceptionEnum exceptionEnum, String message) {
        super(StringUtils.isBlank(message) ? "Error code: " + exceptionEnum.getCode() + "\nMessage: " + exceptionEnum.getMessage() 
                                            : "Error code: " + exceptionEnum.getCode() + "\nMessage: " + exceptionEnum.getMessage() + "\nDetail: " + message);        
    }
    
    
}
