package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class SavePersonDetails
{
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the name");
        String name=sc.next();
        System.out.println("Enter the age");
        int age=sc.nextInt();
        System.out.println("Enter the passport no");
        String passNo=sc.next();
        System.out.println("Enter the country");
        String country=sc.next();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Passport.class);
        cfg=cfg.addAnnotatedClass(Person.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        //objecct of parent Entity
        Passport p1=new Passport();
        p1.setPassportNo(passNo);
        p1.setPassportCountry(country);

        //objecct of child Entity
        Person r1=new Person();
        r1.setPersonName(name);
        r1.setPersonAge(age);

        //compostion of child and parent class

        r1.setPassRef(p1);

        tx= ses.beginTransaction();
        ses.save(p1);
        ses.save(r1);
        tx.commit();
        System.out.println("Records inserted successfully");





    }
}
