package com.softserve.edu.application;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import com.softserve.edu.dao.HibernateUtil;
import com.softserve.edu.entity.*;

public class Application {
    public static void main(String[] args)
    {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
        
        org.hibernate.Transaction transaction = session.beginTransaction();
        Country country =new Country("Poland");
        session.save(country);
        transaction.commit();
        session.close();
        
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction transaction2 = session2.beginTransaction();
        City city = new City ("Warsaw",country);
       
        
        session2.save(city);
        transaction2.commit();
        session2.close();
        
       
      
       
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
       
        HibernateUtil.getSessionFactory().close();
        
    }
}
}
