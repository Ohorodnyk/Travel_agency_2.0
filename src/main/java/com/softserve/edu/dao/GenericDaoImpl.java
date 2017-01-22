package com.softserve.edu.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDaoImpl<E> implements GenericDao<E> {
    private Class<E> genericClass;

    public GenericDaoImpl(Class<E> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    public void add(E element) {
        Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(element);
            transaction.commit();
        }

        finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }

        }

    }

    @Override
    public void update(E element) {

        Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(element);
            transaction.commit();
        }

        finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }

        }

    }

    @Override
    public E getById(Integer id) {
        Session session = null;
        E element = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            element = (E) session.get(genericClass, id);
            transaction.commit();
        }

        finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }

        }

        return element;

    }

    @Override
    public List<E> getAllElements() {

        Session session = null;
        List<E> elements = new ArrayList<E>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            elements = session.createCriteria(genericClass).list();
            transaction.commit();
        }

        finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }

        }

        return elements;
    }

    @Override
    public void delete(E element) {

        Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(element);
            transaction.commit();
        }

        finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }

        }
    }

}
