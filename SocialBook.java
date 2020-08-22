import java.util.*;
import java.util.regex.*;

public class SocialBook extends Book
{
    private String expertise;
    private String position;
    Scanner socialbook = new Scanner (System.in);
    
    public SocialBook()
    {
        super();
        this.expertise = "???";
        this.position = "???";
    }
    
    public SocialBook (String isbn, String title, String subject, String publisher, String language, int numberofPages, int dayofPublish, 
                       int monthofPublish, int yearofPublish, int priceofBook, String expertise, String position)
    {
        super(isbn, title, subject, publisher, language, numberofPages, dayofPublish, monthofPublish, yearofPublish, priceofBook);
        this.expertise = expertise;
        this.position = position;
    }
    
    public String   getExpertise()                      {return expertise;}
    public String   getPosition()                       {return position;}
    public void     setExpertise (String expertise)     {this.expertise = expertise;}
    public void     setPosition (String position)       {this.position = position;}
    
    @Override
    public void AddInformation()
    {
        super.AddInformation();
        System.out.println("Please continue add 2 information for Social book:");
        System.out.print("Field of the book: ");            expertise = socialbook.nextLine();
        System.out.print("Position in your library: ");     position = socialbook.nextLine();
    }
    
    public boolean checkInformation()
    {
        if (!(Pattern.matches("^(?:ISBN(?:-13)?:?\\ )?(?=[0-9]{13}$|(?=(?:[0-9]+[-\\ ]){4})[-\\ 0-9]{17}$)97[89][-\\ ]?[0-9]{1,5}[-\\ ]?[0-9]+[-\\ ]?[0-9]+[-\\ ]?[0-9]$", super.getISBN())))
        {
            System.out.println("ISBN is not valid! Please check ISBN code again!");
            return false;
        }
        if (super.getNumberofPages() < 0)
        {
            System.out.println("Number of pages of book is not valid! Please check again!");
            return false;
        }
        if (super.getDayofPublish() <= 0 || super.getDayofPublish() >= 32)
        {
            System.out.println("Day of publish is not valid! Please check again!");
            return false;
        }
        if (super.getMonthofPublish() <= 0 || super.getMonthofPublish() >= 13)
        {
            System.out.println("Month of publish is not valid! Please check again!");
            return false;
        }
        if (super.getYearofPublish() < 0)
        {
            System.out.println("Year of publish is not valid! Please check again!");
            return false;
        }
        if (super.getPriceofBook() < 0)
        {
            System.out.println("Price of book is not valid! Please check again!");
            return false;
        }
        if (super.getNumberofBook() < 0)
        {
            System.out.println("Number of book is not valid! Please check again!");
            return false;
        }
        if (!Pattern.matches("^B[0-9]+-[0-9]+$", position))
        {
            System.out.println("The position isn't correct syntax! Please check it again");
            return false;
        }
        return true;
    }
    
    @Override
    public void PrintInformation()
    {
        System.out.println("Congratulation on you! You have finish add book in your library! Detail information you declared is:");
        super.PrintInformation();
        System.out.println("Types of book: Social Science book");
        System.out.println("Field of the book: " + expertise);
        System.out.println("Position in your library: " + position);
    }
    
    public void SeeInformation()
    {
        super.PrintInformation();
        System.out.println("Types of book: Natural science book");
        System.out.println("Field of the book: " + expertise);
        System.out.println("Position in your library: " + position);
    }
}