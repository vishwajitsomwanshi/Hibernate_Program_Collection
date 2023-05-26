package main;

import domain.Product1;
import domain.Product2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveProduct2
{
    public static void main(String[] args)
    {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tr;
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product2.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        Product2 p2=new Product2();
        p2.setProductName("fan");
        p2.setProductPrice(20000);
        tr= ses.beginTransaction();

        ses.save(p2);

        tr.commit();
        System.out.println("object saved succesfully");


    }
}
