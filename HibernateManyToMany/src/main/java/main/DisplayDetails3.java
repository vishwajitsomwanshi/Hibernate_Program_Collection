package main;

import domain.Course;
import domain.Student;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class DisplayDetails3
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
        Criteria ctr1= ses.createCriteria(Student.class);
        List<Student> studentList=ctr1.list();
        Iterator itr=studentList.iterator();

        while(itr.hasNext())
        {
            Student stud= (Student) itr.next();
            System.out.println("Student Name: "+stud.getStudentName());
            List<Course> co=stud.getCourseList();
            for(Course c1:co)
            {


                System.out.println("cources: "+c1.getCourseName());
            }
        }

    }
}
