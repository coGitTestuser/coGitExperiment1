import java.util.*;
import java.text.*;
import java.io.*;



/**
 * Employee Abstract Class
 * @author Ömer Faruk Sezen
 * @version 1.0
 */
public abstract class Employee implements Payment,Comparable<Employee>
{
    private int empID;
    private String gender;
    private Date dateOfBirth;


    /**
     * Getter empID
     * @return empID- Int
     */
    public int getEmpID()
    {
        return empID;
    }


    /**
     * Getter gender
     * @return gender-- String
     */
    public String getGender()
    {
        return gender;
    }


    /**
     * Getter dateOfBirth
     * @return dateOfBirth-- Date
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }


    /**
     * Setter empID
     * @param empID-- Int
     */
    public void setEmpID(int empID)
    {
        this.empID = empID;
    }


    /**
     * Setter gender
     * @param gender-- String
     */
    public void setGender(String gender)
    {
        this.gender = gender;
    }


    /**
     * Setter dateOfBirth
     * @param dateOfBirth-- Date
     */
    public void setDateOfBirth(String dateOfBirth)
    {
        try
        {
            this.dateOfBirth = new SimpleDateFormat ("dd/MM/yyyy").parse(dateOfBirth);
        }

        catch (ParseException e)
        {
            System.out.println("Unparseable");
        }
    }

    /**
     * Employee Default Constructor
     */
    public Employee()
    {
        empID = -1;
        gender = "not Initialize";
        setDateOfBirth("01/01/01");
    }


    /**
     * Employee Parameterized Constructor
     */
    public Employee(int _empID,String _gender,String _date)
    {
        empID = _empID;
        gender = _gender;
        setDateOfBirth(_date);
    }

    public abstract boolean getBScDegree();
    public abstract Date getDateOfGraduation();
    public abstract int getExpertiseLevel();

    public abstract String getPreviousFarmName();
    public abstract int getWorkexperience();

}
