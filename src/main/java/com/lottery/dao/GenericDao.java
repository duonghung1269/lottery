/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.dao;

import java.util.List;

/**
 *
 * @author SGSCDHDX
 */
public interface GenericDao<E,K> {
    public void add(E entity) ;
    public void saveOrUpdate(E entity) ;
    public void update(E entity) ;
    public void remove(E entity);
    public E find(K key);
    public List<E> getAll() ;
}
