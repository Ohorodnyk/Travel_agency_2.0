package com.softserve.edu.application;

import java.util.List;


import org.hibernate.Session;
import com.softserve.edu.dao.HibernateUtil;
import com.softserve.edu.entity.Country;

public class Application {
    public static void main(String[] args)
    {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
        
        
        org.hibernate.Transaction transaction = session.beginTransaction();
        
        transaction.commit();
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        session.close();
        HibernateUtil.getSessionFactory().close();
        
    }
}
}
