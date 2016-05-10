/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.dao;

/**
 *
 * @author SGSCDHDX
 */
public interface GenericRepositoryInterface<T> {
    public T save(T emp);
    public Boolean delete(T emp);
    public T edit(T emp);
    public T find(Long empId);
}
