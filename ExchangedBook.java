import java.util.*;
import java.util.regex.*;
public class ExchangedBook
{
    private String isbnCheck, dayBorrow, dayReturn, billCode;
    private int leftLimit = 48, rightLimit = 57, targetStringLength = 12;
    Scanner exchangedbook = new Scanner(System.in);
     
    // Default constructor when not declared anything
    public ExchangedBook() 
    {
        super();
        this.isbnCheck = "???";
        this.dayBorrow = "???";
        this.dayReturn = "???";
        this.billCode = "???";
    }
    
    // The information will be sent to management system when declared anything
    public ExchangedBook (String idCheck, String isbnCheck, String dayBorrow, String dayReturn, String billCode) 
    {
        this.isbnCheck = isbnCheck;
        this.dayBorrow = dayBorrow;
        this.dayReturn = dayReturn;
        this.billCode = billCode;
    }
    
    public String   getISBNCheck()                          {return isbnCheck;}
    public String   getDayBorrow()                          {return dayBorrow;}
    public String   getDayReturn()                          {return dayReturn;}
    public String   getBillCode()                           {return billCode;}
    public void     setISBNCheck    (String isbnCheck)      {this.isbnCheck = isbnCheck;}
    public void     setDayBorrow    (String dayBorrow)      {this.dayBorrow = dayBorrow;}
    public void     setDayReturn    (String dayReturn)      {this.dayReturn = dayReturn;}
    public void     setBillCode     (String billCode)       {this.billCode = billCode;}
    
    public void addInformationBorrow()
    {
        System.out.print("Please input ISBN code of book they wanted to borrow: ");     
        isbnCheck = exchangedbook.nextLine();
        System.out.println("Please input the day borrowed this book (Syntax dd/mm/yyyy, if number of day/month is between 0 to 9, please add 0 before"
                         + " it, example input 01 instead of 1): ");                                      
        dayBorrow = exchangedbook.nextLine();
    }
    
    public boolean checkInformationBorrow()
    {
        if (!(Pattern.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$", dayBorrow)))
        {
            System.out.println ("The format of day borrowed is not correct! Please read carefully instruction and do it again!");
            return false;
        }
        return true; 
    }
    
    public void PrintBillCode()
    {
        System.out.println("***********************************************************************************************************************");
        System.out.print("Bill code to prove that yourself is borrowed library book today: ");
        Random random = new Random();
        billCode = random.ints(leftLimit, rightLimit + 1).filter(i -> (i >= 48 && i <= 57)).limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println(billCode);
        System.out.println("Note that: Borrowing period is 7 days since the day you officially borrow this book! Please return book on time! "
                       + "When you returned this book, please bring the bill to checkbook borrowing procedures, finalize book returns "
                       + "and handle related issues. All problems affecting the quality of the book, the borrower must take full responsibility "
                       + "and must compensate according to the committed library law in cases of loss of books, torn books, or marked on books. "
                       + "Therefore, during the borrowing time, please take care of the borrowed book well");
        System.out.println("***********************************************************************************************************************");
    }
    
    public void addInformationReturn()
    {
        System.out.println("Please input the day returned this book (Syntax dd/mm/yyyy, if number of day/month is between 0 to 9, please add 0 before"
                         + " it, example input 01 instead of 1): ");                                      
        dayReturn = exchangedbook.nextLine();
    }
    
    public boolean checkInformationReturn()
    {
        if (!(Pattern.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$", dayReturn)))
        {
            System.out.println ("The format of day returned is not correct! Please read carefully instruction and do it again!");
            return false;
        }
        return true; 
    }
    
    public void ShowInformation()
    {
        System.out.println("Bill code: " + billCode);
        System.out.println("ISBN book borrow: " + isbnCheck);
        System.out.println("Day borrow: " + dayBorrow);
        if (dayReturn.equals("???") == true)
            System.out.println("Day return: Book not returned");
        else
            System.out.println("Day return: " + dayReturn);
    }
}