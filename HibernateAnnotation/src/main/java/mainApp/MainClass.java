package mainApp;

import demo.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass
{
    public static void main(String[] args)
    {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tr;
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Employee.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        Employee e1=new Employee(1,"vishwajit",25000.50);
        Employee e2=new Employee(2,"chandra",0.5);
        Employee e3=new Employee(3,"vikrant",35000.50);

        tr= ses.beginTransaction();

        ses.save(e1);
        ses.save(e2);
        ses.save(e3);

        tr.commit();
        System.out.println("object saved succesfully");

    }
}
