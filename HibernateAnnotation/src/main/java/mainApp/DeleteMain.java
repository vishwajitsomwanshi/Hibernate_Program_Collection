package mainApp;

import demo.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteMain
{
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory   factory;
        Session ses;
        Transaction tr;
        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Employee.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();
        Employee e1=ses.load(Employee.class,1);
        tr=ses.beginTransaction();
        ses.delete(e1);
        tr.commit();
        System.out.println("deleted successfully");

    }
}
