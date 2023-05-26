package main;

import domain.product1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateSome
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
        tr= ses.beginTransaction();
        int count=ses.createQuery("update product1 b set b.bookPrice=620 where b.bookID<=3").executeUpdate();
        tr.commit();
        System.out.println(count+" records updated");

    }
}
