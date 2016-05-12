/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.service;

import com.lottery.dao.GenericDao;
import java.util.List;

/**
 *
 * @author SGSCDHDX
 */
public interface GenericService<E, K> {
    public void saveOrUpdate(E entity);
    public List<E> getAll();
    public E get(K id);
    public void add(E entity);
    public void update(E entity);
    public void remove(E entity);
    
}