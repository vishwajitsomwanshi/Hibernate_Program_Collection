package main;

import domain.Product1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Saveproduct1
{
    public static void main(String[] args)
    {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tr;
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product1.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        Product1 p1=new Product1();
        p1.setProductName("fan");
        p1.setProductPrice(20000);
        tr= ses.beginTransaction();

        ses.save(p1);

        tr.commit();
        System.out.println("object saved succesfully");


    }
}
