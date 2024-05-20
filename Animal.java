import java.util.*;
import java.text.*;


/**
 * Animal Abstract Class
 * @author Ömer Faruk Sezen
 * @version 1.0
 */
public abstract class Animal
{
    static Scanner input = new Scanner(System.in);
    private int tagNo;
    private String gender;
    private Date dateOfBirth;
    private boolean purchased;
    private List<Treatment> treatmentList;
    private HashMap milking;


    /**
     * Setter tagNo
     * @param tagNo-- Int
     */
    public void setTagNo(int tagNo)
    {
        this.tagNo = tagNo;
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
     * Setter purchased
     * @param purchased-- boolean
     */
    public void setPurchased(boolean purchased)
    {
        this.purchased = purchased;
    }


    /**
     * Setter treatmentList
     * @param treatmentList-- List<Treatment>
     */
    public void setTreatmentList(List<Treatment> treatmentList)
    {
        this.treatmentList = treatmentList;
    }


    /**
     * Setter milking
     * @param milking-- HashMap
     */
    public void setMilking(HashMap milking)
    {
        this.milking = milking;
    }


    /**
     * Getter tagNo
     * @return tagNo-- Int
     */
    public int getTagNo()
    {
        return tagNo;
    }


    /**
     * Getter gender
     * @return gender -- String
     */
    public String getGender()
    {
        return gender;
    }


    /**
     * Getter dateOfBirth
     * @return dateOfBirth -- Date
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }


    /**
     * Getter purchased
     * @return purchased -- boolean
     */
    public boolean getPurchased()
    {
        return purchased;
    }


    /**
     * Getter treatmentList
     * @return treatmentList -- List<Treatment>
     */
    public List<Treatment> getTreatmentList()
    {
        return treatmentList;
    }


    /**
     * Getter milking
     * @return milking -- HashMap
     */
    public HashMap getMilking()
    {
        return milking;
    }


    /**
     * This method calculates the age of the animal and returns it
     * @return age -- Int
     */
    public int getAge()
    {
        Date current_date = new Date();
        return current_date.getYear() - dateOfBirth.getYear();
    }


    /**
     * This is an abstract method definition. Implemented in Cow Class.
     */
    public abstract double getWeight();


    /**
     * Animal Default Constructor
     */
    public Animal()
    {
        setTagNo(-1);
        setGender("not Initialize");
        setDateOfBirth("01/01/01");
        setPurchased(false);
        setTreatmentList(new ArrayList<>());
        setMilking(new HashMap());
    }


    /**
     * Animal Parameterized Constructor
     */
    public Animal(int _tagNo,String _gender, String _date,boolean _purchased)
    {
        setTagNo(_tagNo);
        setGender(_gender);
        setDateOfBirth(_date);
        setPurchased(_purchased);
        setTreatmentList(new ArrayList<>());
        setMilking(new HashMap());
    }


    public void addCleaningTreatment(String dateOfTreatment, String material,int workerID)
    {
        Treatment newTreatment = new CleaningTreatment(dateOfTreatment,workerID,material);
        treatmentList.add(newTreatment);
    }


    public void addHealthTreatment(String dateOfTreatment,boolean emergency,int vetID,Medication newMedication)
    {
        Treatment newTreatment = new HealthTreatment(dateOfTreatment,vetID,newMedication,emergency);
        treatmentList.add(newTreatment);
    }


    /**
     * This method gets input from user and add the treatment to the system.
     * @param _empId -- Int type
     */
    public void addTreatment(int _empId,int typeOfTreatment)
    {
        int choice = 1;
        String _date,_materials;
        boolean _emergency;

        System.out.print("Enter the date of treatment (dd/MM/yyyy): ");
        _date = input.nextLine();

            if(typeOfTreatment == 1)//cleaning
            {
                System.out.print("Enter the materials: ");
                _materials = input.nextLine();

                Treatment newTreatment = new CleaningTreatment(_date,_empId,_materials);
                treatmentList.add(newTreatment);
            }

            else if (typeOfTreatment == 2) //health
            {
                System.out.print("Is this treatment emergency?(true/false): ");
                _emergency = input.nextBoolean();


            }


        do {

            //treatmentList.get(treatmentList.size() - 1).addMedication();

            System.out.println("Do you want to add more medication? Yes(1) No(0)  ");
            choice = input.nextInt();
            input.nextLine();

        }while (choice == 1);
    }
}
