package com.mkyong.common;

import com.mkyong.persistence.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by stepinfo on 03/03/16.
 */
public class App {

    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Stock stock = new Stock();

        stock.setStockCode("4715");
        stock.setStockName("GENM");

        session.save(stock);
        session.getTransaction().commit();
    }
}
