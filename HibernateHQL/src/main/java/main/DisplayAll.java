package main;

import domain.product1;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.print.Book;
import java.util.List;

public class DisplayAll
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
        //Dispaly all books
        Query q=ses.createQuery("from product1 b");
        List<product1> booklist=q.list();
        for(product1 b:booklist){
            System.out.println(b);
        }
        //Display all book names
        q=ses.createQuery("select b.bookName from product1 b");
        List<String> bookNames=q.list();
        for(String s:bookNames)
        {
            System.out.println(s);
        }

    }

}
