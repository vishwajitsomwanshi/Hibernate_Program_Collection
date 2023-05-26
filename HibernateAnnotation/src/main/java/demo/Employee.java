package demo;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_data")
public class Employee
{
   @Id
   @Column(name="emp_id")
    private int empid;
    @Column(name="emp_name")
   private String empName;
    @Column(name="emp_salary")
    private double empSalary;
    public Employee(){

    }
    public Employee(int empid, String empName, double empSalary) {
        this.empid = empid;
        this.empName = empName;
        this.empSalary = empSalary;
    }
    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }
}
