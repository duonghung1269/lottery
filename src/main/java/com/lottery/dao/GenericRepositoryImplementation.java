/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.dao;

import org.hibernate.Session;

/**
 *
 * @author SGSCDHDX
 */
public class GenericRepositoryImplementation<T> implements GenericRepositoryInterface<T> {

    protected Session entityManager;
    private Class<T> type;

    public GenericRepositoryImplementation() {
        // TODO Auto-generated constructor stub
    }

    public GenericRepositoryImplementation(Class<T> type) {
        // TODO Auto-generated constructor stub

        this.type = type;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T save(T emp) {
        // TODO Auto-generated method stub
        entityManager.persist(emp);
        entityManager.flush();
        return emp;
    }

    @Override
    public Boolean delete(T emp) {
        // TODO Auto-generated method stub
        try {
            entityManager.remove(emp);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @Override
    public T edit(T emp) {
        // TODO Auto-generated method stub
        try {
            return entityManager.merge(emp);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public T find(Long empId) {
        // TODO Auto-generated method stub
        return (T) entityManager.find(Employee.class, empId);
    }
}
