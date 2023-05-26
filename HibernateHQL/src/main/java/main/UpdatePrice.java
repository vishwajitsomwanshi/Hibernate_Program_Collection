package main;

import domain.product1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdatePrice
{
    public static void main(String[] args)
    {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tr;
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(product1.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        //update price of all the books
        tr=ses.beginTransaction();
        int count=ses.createQuery("update product1 b set b.bookPrice=500").executeUpdate();
        tr.commit();
        System.out.println(count+" records updated");

    }
}
