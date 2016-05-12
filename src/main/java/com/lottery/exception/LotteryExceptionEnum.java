/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.exception;

/**
 *
 * @author SGSCDHDX
 */
public enum LotteryExceptionEnum {
    GENERAL_ERROR(0, "General Error!"),
    PROGRAMMING_ERROR(0, "Programming Error!");
    
    private int code;
    private String message;
    
    LotteryExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public int getCode() {
        return code;
    }
    
    public String getMessage() {
        return message;
    }
}
