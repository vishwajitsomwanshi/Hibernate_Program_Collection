package main;

import domain.product1;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

import java.awt.print.Book;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Dispalyrecords
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
        //display all columns from specific table
        List<product1> booklist=ses.createCriteria(product1.class).list();
        for(product1 p:booklist)
        {
            System.out.println(p);
        }
        //dispaly specific column from table
        Criteria crt=ses.createCriteria(product1.class);
        crt.setProjection(Projections.property("bookPrice"));
        List<Double> booklis=crt.list();
        for(Double p1:booklis){
            System.out.println(p1);
        }

//        c.add(Restrictions.eq("bookName","Name"));
//        c.add(Restrictions.eq("bookPrice","price"));
        Criteria c=ses.createCriteria(product1.class);
        Projection p1=Projections.property("bookName");
        Projection p2=Projections.property("bookPrice");
        ProjectionList p=Projections.projectionList();
        p.add(p1);
        p.add(p2);
        c.setProjection(p);
       Iterator itr = c.list().iterator();
        while(itr.hasNext())
        {
            Objects [] arr=(Objects[]) itr.next();
            System.out.println(arr[0]+"\t"+arr[1]);
        }


    }
}
