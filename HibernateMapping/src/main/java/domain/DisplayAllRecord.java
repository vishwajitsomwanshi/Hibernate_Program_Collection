package domain;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllRecord
{
    public static void main(String[] args)
    {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tr;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Person.class);
        cfg=cfg.addAnnotatedClass(Passport.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Query q=ses.createQuery("from Person b");
        List<Person> personDetail=q.list();
        System.out.println("personName"+"\t"+"personAge"+"\t"+"passportNo"+"\t"+"passportCountry");
        for(Person b:personDetail)
        {
            System.out.println(b);
        }

    }
}
