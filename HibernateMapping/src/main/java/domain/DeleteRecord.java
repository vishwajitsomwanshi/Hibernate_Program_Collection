package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteRecord
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id");
        int id=sc.nextInt();
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Person.class);
        cfg=cfg.addAnnotatedClass(Passport.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
         Person p=ses.load(Person.class,id);

        tx= ses.beginTransaction();
        ses.delete(p);
        tx.commit();
        System.out.println("Records Deleted successfully");
    }
}
