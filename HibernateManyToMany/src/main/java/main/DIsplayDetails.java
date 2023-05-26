package main;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DIsplayDetails
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id ");
        int id =sc.nextInt();
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

        Student s1=ses.load(Student.class,id);
        System.out.println(s1.getStudentName());
        List<Course> students=s1.getCourseList();

        for(Course c:students)
        {
            System.out.println(c);
        }



    }
}
