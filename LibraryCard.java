import java.util.*;
import java.util.regex.*;

public class LibraryCard extends LibraryAccountRegister
{
    private String idCard;
    private long fineAmount;
    Scanner librarycard = new Scanner(System.in);
     
    // Default constructor when not declared anything
    public LibraryCard() 
    {
        super();
        this.idCard = "???";
        this.fineAmount = 0;
    }
    
    // The information will be sent to management system when declared anything
    public LibraryCard (String id, String name, String sex, String phone, String email, int day, int birth, int year, boolean accept, String idCard,
                        long fineAmount) 
    {
        super(id, name, sex, phone, email, day, birth, year, accept);
        this.idCard = idCard;
        this.fineAmount = fineAmount;
    }
    
    public String   getIDCard()                         {return idCard;}
    public long     getFineAmount()                     {return fineAmount;}
    public void     setIDCard       (String idCard)     {this.idCard = idCard;}
    public void     setFineAmount   (long fineAmount)   {this.fineAmount = fineAmount;}
    
    @Override
    public void PrintInformation()
    {
        super.PrintInformation();
        System.out.println("----------------------------------------------------------------------------------------------------------------------");  
        System.out.print("The library provides you a library card with your ID is: "); 
        idCard = UUID.randomUUID().toString();
        System.out.println(idCard);
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
    }
}