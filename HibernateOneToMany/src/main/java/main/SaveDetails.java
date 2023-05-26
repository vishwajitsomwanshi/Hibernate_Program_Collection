package main;

import domain.Customer;
import domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveDetails
{
    public static void main(String[] args) {
        Configuration cfg ;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Customer.class);
        cfg=cfg.addAnnotatedClass(Order.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        //objet of customer

        Customer c1=new Customer();
        c1.setCustName("vishwa");
        c1.setCustContact(123455);

        //object of Order

        Order o1=new Order();
        o1.setOrdNo("OR123D");

        Order o2=new Order();
        o2.setOrdNo("OR456D");

        c1.placeOrder(o1);
        c1.placeOrder(o2);

        tx=ses.beginTransaction();
        ses.save(c1);
        tx.commit();
        System.out.println("order placed successfully");

    }
}
