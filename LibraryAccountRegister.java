import java.util.*;
import java.util.regex.*;

public class LibraryAccountRegister
{
    private String id, name, sex, phone, email;
    private int day, month, year;
    private boolean accept;
    Scanner libraryAccountRegister = new Scanner(System.in);
     
    // Default constructor when not declared anything
    public LibraryAccountRegister() 
    {
        super();
        this.id = "???";
        this.name = "???"; 
        this.sex = "???";
        this.phone = "???";
        this.email = "???";
        this.day = -1;
        this.month = -1;
        this.year = -1;
        this.accept = false;
    }
    
    // The information will be sent to management system when declared anything
    public LibraryAccountRegister(String id, String name, String sex, String phone, String email, int day, int birth, int year, boolean accept) 
    {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.day = day;
        this.month = month;
        this.year = year;
        this.accept = accept;
    }
 
    public String   getID()                                     {return id;}
    public String   getName()                                   {return name;}
    public String   getSex()                                    {return sex;}
    public String   getPhone()                                  {return phone;} 
    public String   getEmail()                                  {return email;}
    public int      getDay()                                    {return day;}
    public int      getMonth()                                  {return month;}
    public int      getYear()                                   {return year;}
    public boolean  getAccept()                                 {return accept;}
    public void     setID               (String id)             {this.id = id;}
    public void     setName             (String name)           {this.name = name;}
    public void     setPhone            (String phone)          {this.phone = phone;}
    public void     setEmail            (String email)          {this.email = email;}
    public void     setDay              (int day)               {this.day = day;}
    public void     setMonth            (int month)             {this.month = month;}
    public void     setYear             (int year)              {this.year = year;}
    public void     setSex              (String sex)            {this.sex = sex;}
    public void     setAccept           (Boolean accept)        {this.accept = accept;}
    
    public void giveInformation() 
    {
        System.out.print("Full name: ");                                                            name = libraryAccountRegister.nextLine();
        System.out.print("Sex (Input F if female, M if male): ");                                   sex = libraryAccountRegister.nextLine();
        System.out.print("ID: ");                                                                   id = libraryAccountRegister.nextLine();
        System.out.print("Phone number: ");                                                         phone = libraryAccountRegister.nextLine();
        System.out.print("Email: ");                                                                email = libraryAccountRegister.nextLine();
        System.out.print("Day: ");                                                                  day = libraryAccountRegister.nextInt();
        System.out.print("Month: ");                                                                month = libraryAccountRegister.nextInt();
        System.out.print("Year: ");                                                                 year = libraryAccountRegister.nextInt();
        libraryAccountRegister.nextLine();
        System.out.print("Please tick: I accept the rules of the library (Input true or false): "); accept = libraryAccountRegister.nextBoolean();
    }
     
    public boolean checkInformation() 
    {
        if (!(Pattern.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$", name)))
        {
            System.out.println("Your name contains the invalid letter. Please check your name again!");
            return false;
        }
        if (!(Pattern.matches("^[FM]$", sex)))
        {
            System.out.println("Your sex only F or M and don't take the unnecessary letter. Please check your sex again!");
            return false;
        }
        if (!(Pattern.matches("^[0-9]\\S+?[0-9]{8,20}$", id)))
        {
            System.out.println("Your ID is invalid. Please check your ID again!");
            return false;
        }
        if (!(Pattern.matches("^[0-9]{8,20}$", phone)))
        {
            System.out.println("Your phone is invalid. Please check your phone again!");
            return false;
        }
        if (!(Pattern.matches("^[a-z][a-z0-9_.]{5,32}@[a-z0-9]{2,}(.[a-z0-9]{2,4}){1,2}$", email)))
        {
            System.out.println("Your email is not valid. Please check your email again!");
            return false;
        }
        if (day <= 0 || day > 31)
        {
            System.out.println("Your day birth is not valid. Please check your birth again!");
            return false;
        }
        if (month <= 0 || month > 12)
        {
            System.out.println("Your month birth is not valid. Please check your birth again!");
            return false;
        }
        if (year <= 0)
        {
            System.out.println("Your year birth is not valid. Please check your birth again!");
            return false;
        }
        if (!accept)
        {
            System.out.println("Please tick to the commitment of the company!");
            return false;
        }
        return true;
    }

    public void PrintInformation()
    {
        System.out.println("Congratulation on you! You have finished to declared your personal information to us!. The below is the information you declared:");
        System.out.println("Your name: " + this.name);
        String printsex = (this.sex.charAt(0) == 'F')? "Female": "Male";
        System.out.println("Your sex: " + printsex);
        System.out.println("Your ID: " + this.id);
        System.out.println("Your phone number: " + this.phone);
        System.out.println("Your email: " + this.email);
        System.out.println("Your birth: " + this.day + "/" + this.month + "/" + this.year);
    }
    
    public void seeInformation()
    {
        System.out.println("Your name: " + this.name);
        String printsex = (this.sex.charAt(0) == 'F')? "Female": "Male";
        System.out.println("Your sex: " + printsex);
        System.out.println("Your ID: " + this.id);
        System.out.println("Your phone number: " + this.phone);
        System.out.println("Your email: " + this.email);
        System.out.println("Your birth: " + this.day + "/" + this.month + "/" + this.year);
    }
}