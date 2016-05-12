/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.dao.impl;

import com.lottery.dao.GenericDao;
import com.lottery.dao.LotteryHibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SGSCDHDX
 */
@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<E, K extends Serializable>
        implements GenericDao<E, K> {

    protected final Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private SessionFactory sessionFactory; // = LotteryHibernateUtil.getSessionFactory();
    protected Class<? extends E> daoType;

    /**
     * By defining this class as abstract, we prevent Spring from creating
     * instance of this class If not defined as abstract,
     * getClass().getGenericSuperClass() would return Object. There would be
     * exception because Object class does not hava constructor with parameters.
     */
    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
//        sessionFactory = LotteryHibernateUtil.getSessionFactory();
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public String getLogPrefix() {
        //return LoginUserInformation.getUserID() + " : ";
        return "[DEBUG]";
    }

    @Override
    public void add(E entity) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogPrefix() + "[" + daoType.getName() + "][add][" + entity + "]");
        }
        currentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(E entity) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogPrefix() + "[" + daoType.getName() + "][saveOrUpdate][" + entity + "]");
        }
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(E entity) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogPrefix() + "[" + daoType.getName() + "][update][" + entity + "]");
        }
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void remove(E entity) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogPrefix() + "[" + daoType.getName() + "][remove][" + entity + "]");
        }
        currentSession().delete(entity);
    }

    @Override
    public E find(K key) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogPrefix() + "[" + daoType.getName() + "][find][" + key + "]");
        }
        return (E) currentSession().get(daoType, key);
    }

    @Override
    public List<E> getAll() {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogPrefix() + "[" + daoType.getName() + "][getAll]");
        }
        currentSession().beginTransaction();
        final List list = currentSession().createCriteria(daoType).list();
        currentSession().getTransaction().commit();
        return list;
    }
}
