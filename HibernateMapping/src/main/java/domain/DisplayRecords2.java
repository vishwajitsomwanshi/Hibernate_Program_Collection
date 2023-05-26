package domain;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.build.AllowSysOut;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class DisplayRecords2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the country");
        String country=sc.next();
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

        Criteria criteria=ses.createCriteria(Person.class);
        criteria.add(Restrictions.eq("passportCountry",country));
        Person pass= (Person) criteria.uniqueResult();
        System.out.println(pass.getPassRef().getPassportCountry());










    }

}
