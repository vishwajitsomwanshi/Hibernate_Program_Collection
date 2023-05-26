package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stud_id")
    private int studentId;
    @Column(name = "stud_name")
    private String studentName;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="student_course",
            joinColumns = @JoinColumn(name="student_ref"),
            inverseJoinColumns = @JoinColumn(name="course_ref")

    )
    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public void addcourse(Course cref)
    {
        if(courseList==null)
        {
            courseList=new LinkedList<>();

        }
        courseList.add(cref);

    }

    @Override
    public String toString() {
        return studentName;
    }
}
