package main;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveDetails
{
    public static void main(String[] args)
    {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg= new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Course.class);

        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        //student object
        Student s1=new Student();
        s1.setStudentName("vishwa");

        Course c1=new Course();
        c1.setCourseName("java");

        Course c2=new Course();
        c2.setCourseName("J2EE");


        s1.addcourse(c1);
        s1.addcourse(c2);

        tx= ses.beginTransaction();
        ses.save(s1);
        ses.save(c1);
        ses.save(c2);
        tx.commit();
        System.out.println("inserted successfully");
    }
}
